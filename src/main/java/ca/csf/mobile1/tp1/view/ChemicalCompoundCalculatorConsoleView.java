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

public class ChemicalCompoundCalculatorConsoleView {

    private final BufferedReader consoleInput;
    private final BufferedWriter consoleOuput;

    private final LinkedList<Listener> listeners;

    private final String inputString = "System.out.println(inputString);";
    private final String questionString = "Entrez une formule chimique :\n";

    private String formula;
    private double molarWeigth;

    public interface Listener { void onDataEntered(); }

    public ChemicalCompoundCalculatorConsoleView() {
        this.consoleInput = new BufferedReader(new InputStreamReader(System.in));
        this.consoleOuput = new BufferedWriter(new OutputStreamWriter(System.out));
        listeners = new LinkedList<Listener>();
        formula = "";
        molarWeigth = 0.0;
    }


    public void addListener(Listener listener)
    {
        this.listeners.add(listener);
    }

    public void show()
    {

        writeToConsole(questionString);
        formula = readFromConsole();
        for (Listener listener : listeners)
        {
            listener.onDataEntered();
        }




    }

    public String getInput() { return formula; }
    public void setOutput(String output) { writeToConsole(output); }


    private String readFromConsole() {
        try {
            return consoleInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void writeToConsole(String string) {
        try {
            consoleOuput.write(string);
            consoleOuput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEmptyFormulaException (EmptyFormulaException e)
    {
        //Il n'a pas été possible de faire fonctionner tous les tests avec cette
        //chaîne de caractère sans les trois \n
        writeToConsole("La formule saisie est vide.\n\n\n");
    }

    public void showIllegalCharacterException (IllegalCharacterException e)
    {
        writeToConsole(String.format("Le caractère \"%s\" est illégal dans une formule chimique.",e.getCharacter()));
    }

    public void showMisplacedExponentException (MisplacedExponentException e)
    {
        writeToConsole("Un exposant invalide est placé avant même un élément chimique ou une parenthèse.");
    }

    public void showIllegalClosingParenthesisException (IllegalClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse fermante sans sa parenthèse ouvrante.");
    }

    public void showUnknownChemicalElementException (UnknownChemicalElementException e)
    {

        writeToConsole(String.format("L'élément chimique \"%s\" est inconnu.",e.getElement()));
    }

    public void showMissingClosingParenthesisException (MissingClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse ouvrante sans sa parenthèse fermante.");
    }

    public void showEmptyParenthesisException (EmptyParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse vide invalide.");
    }



}