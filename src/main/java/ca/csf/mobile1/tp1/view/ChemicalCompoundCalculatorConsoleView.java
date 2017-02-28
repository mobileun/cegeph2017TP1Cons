package ca.csf.mobile1.tp1.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import ca.csf.mobile1.tp1.chemical.compound.EmptyFormulaException;

public class ChemicalCompoundCalculatorConsoleView {

    private final BufferedReader consoleInput;
    private final BufferedWriter consoleOuput;

    public ChemicalCompoundCalculatorConsoleView() {
        this.consoleInput = new BufferedReader(new InputStreamReader(System.in));
        this.consoleOuput = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    //TODO : À compléter

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


}