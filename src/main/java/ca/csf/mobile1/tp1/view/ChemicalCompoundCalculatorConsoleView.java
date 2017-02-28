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
    private String outputString = "Le poids de %s est %f g/mol.\n";
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

    //TODO : À compléter


    public void addListener(Listener listener)
    {
        this.listeners.add(listener);
    }

    public void show()
    {
        writeToConsole(inputString);

        for (Listener listener : listeners)
        {
            listener.onDataEntered();
        }


        String.format(outputString,formula,molarWeigth);
        writeToConsole(outputString);

    }



    //public String getInput() { return input; }
    //public void setOutput(votre_type outputNumber) { writeToConsole(String.format(â€¦)); }


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
        writeToConsole("La formule saisie est vide.\n");
    }

    public void showIllegalCharacterException (IllegalCharacterException e)
    {
        writeToConsole(String.format("Le caractère \"%s\" est illégal dans une formule chimique.\n",e.getCharacter()));
    }

    public void showMisplacedExponentException (MisplacedExponentException e)
    {
        writeToConsole("Un exposant invalide est placé avant mëme un élément chimique ou une parenthèse.\n");
    }

    public void showIllegalClosingParenthesisException (IllegalClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse fermante sans sa parenthèse ouvrante.\n");
    }

    public void showUnknownChemicalElementException (UnknownChemicalElementException e)
    {

        writeToConsole(String.format("L'élément chimique \"%s\" est inconnu.",e.getElement()));
    }

    public void showMissingClosingParenthesisException (MissingClosingParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse ouvrante sans sa parenthèse fermante.\n");
    }

    public void showEmptyParenthesisException (EmptyParenthesisException e)
    {
        writeToConsole("Il y a une parenthèse vide invalide.\n");
    }



}