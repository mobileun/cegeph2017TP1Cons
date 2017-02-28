package ca.csf.mobile1.tp1.view;

import java.io.*;

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

}