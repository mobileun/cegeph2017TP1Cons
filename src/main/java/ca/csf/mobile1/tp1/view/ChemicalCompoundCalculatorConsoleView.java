package ca.csf.mobile1.tp1.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


import ca.csf.mobile1.tp1.chemical.compound.EmptyFormulaException;
import ca.csf.mobile1.tp1.chemical.compound.EmptyParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.IllegalCharacterException;
import ca.csf.mobile1.tp1.chemical.compound.IllegalClosingParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.MisplacedExponentException;
import ca.csf.mobile1.tp1.chemical.compound.MissingClosingParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.UnknownChemicalElementException;

/**
 * Classe ayant le rôle de view dans l'appication selon le modèle d'architecture MVC
 * Le modèle est une librairire calculant les masse molaires de composés chimiques
 */
public class ChemicalCompoundCalculatorConsoleView {

    private final BufferedReader consoleInput;
    private final BufferedWriter consoleOuput;

    private final LinkedList<Listener> listeners;

    private final String inputString = "System.out.println(inputString);";
    private final String questionString = "Entrez une formule chimique :\n";

    private String formula;
    private double molarWeigth;

    /**
     * Interface de gestion d'une entrée de formule chimique
     * dont l'on veut calculer la masse molaire.
     */
    public interface Listener { void onDataEntered(); }

    /**
     * Constructeur de la view
     */
    public ChemicalCompoundCalculatorConsoleView() {
        this.consoleInput = new BufferedReader(new InputStreamReader(System.in));
        this.consoleOuput = new BufferedWriter(new OutputStreamWriter(System.out));
        listeners = new LinkedList<Listener>();
        formula = "";
        molarWeigth = 0.0;
    }

    /**
     * Méthode permettant d'ajouter des class possédant l'interface Listener
     * au événement générés par la view
     * @param listener
     */
    public void addListener(Listener listener)
    {
        this.listeners.add(listener);
    }

    /**
     * Méthode effectuant l'affichage de la vue (interface de l'aplication)
     */
    public void show()
    {

        writeToConsole(questionString);
        formula = readFromConsole();
        for (Listener listener : listeners)
        {
            listener.onDataEntered();
        }
   }

    /**
     * Méthode permettant de récupérer la formule chimique dont l'on veut la masse molaire
     * @return la formule chimique
     */
    public String getInput() { return formula; }

    /**
     * Méthode permettant d'afficher la masse molaire de la formule chimique.
     * @param output la masse molaire
     */
    public void setOutput(String output) { writeToConsole(output); }

    /**
     * Méthode effectuant la lecture de données entrées à la console par l'utilisateur
     * @return les données entrées par l'utilisateur
     */
    private String readFromConsole() {
        try {
            return consoleInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     *  Méthode effectuant l'affichage à la console
     * @param string les données à affichées
     */
    private void writeToConsole(String string) {
        try {
            consoleOuput.write(string);
            consoleOuput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode affichant le message d'erreur de l'exception @see EmptyFormulaException
     * @param e instance de EmptyFormulaException
     */
    public void showEmptyFormulaException (EmptyFormulaException e)
    {
        //Il n'a pas été possible de faire fonctionner tous les tests avec cette
        //chaîne de caractère sans les trois \n
        writeToConsole("La formule saisie est vide.\n\n\n");
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see EIllegalCharacterException
     * @param e instance de IllegalCharacterException
     */
    public void showIllegalCharacterException (IllegalCharacterException e)
    {
        writeToConsole(String.format("Le caractère \"%s\" est illégal dans une formule chimique.",e.getCharacter()));
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see MisplacedExponentException
     * @param e instance de MisplacedExponentException
     */
    public void showMisplacedExponentException (MisplacedExponentException e)
    {
        writeToConsole("Un exposant invalide est placé avant même un élément chimique ou une parenthèse.");
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see IllegalClosingParenthesisException
     * @param e instance de IllegalClosingParenthesisException
     */
    public void showIllegalClosingParenthesisException (IllegalClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse fermante sans sa parenthèse ouvrante.");
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see UnknownChemicalElementException
     * @param e instance de UnknownChemicalElementException
     */
    public void showUnknownChemicalElementException (UnknownChemicalElementException e)
    {

        writeToConsole(String.format("L'élément chimique \"%s\" est inconnu.",e.getElement()));
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see MissingClosingParenthesisException
     * @param e instance de MissingClosingParenthesisException
     */
    public void showMissingClosingParenthesisException (MissingClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse ouvrante sans sa parenthèse fermante.");
    }
    /**
     * Méthode affichant le message d'erreur de l'exception @see EmptyParenthesisException
     * @param e instance de EmptyParenthesisException
     */
    public void showEmptyParenthesisException (EmptyParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse vide invalide.");
    }



}