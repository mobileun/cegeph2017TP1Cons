package ca.csf.mobile1.tp1.controller;

import ca.csf.mobile1.tp1.chemical.compound.ChemicalCompoundFactory;
import ca.csf.mobile1.tp1.chemical.compound.EmptyFormulaException;
import ca.csf.mobile1.tp1.chemical.compound.EmptyParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.IllegalCharacterException;
import ca.csf.mobile1.tp1.chemical.compound.IllegalClosingParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.MisplacedExponentException;
import ca.csf.mobile1.tp1.chemical.compound.MissingClosingParenthesisException;
import ca.csf.mobile1.tp1.chemical.compound.UnknownChemicalElementException;
import ca.csf.mobile1.tp1.view.ChemicalCompoundCalculatorConsoleView;

/**
 * Created by Fredgag on 2017-02-28.
 */

public class ChemicalCompoundCalculatorController implements ChemicalCompoundCalculatorConsoleView.Listener
{

    ChemicalCompoundCalculatorConsoleView view;
    ChemicalCompoundFactory model;

    public ChemicalCompoundCalculatorController(ChemicalCompoundCalculatorConsoleView view , ChemicalCompoundFactory model)
    {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }

    public void onDataEntered()
    {

       try {
           model.createFromString(view.getInput());
           //String.format(outputString,formula,molarWeigth);
           //writeToConsole(outputString);
       }
        catch (EmptyParenthesisException e)
        {
            view.showEmptyParenthesisException(e);
        }
        catch (IllegalCharacterException e)
        {
             view.showIllegalCharacterException(e);
        }
        catch (IllegalClosingParenthesisException e)
        {
            view.showIllegalClosingParenthesisException(e);
        }
        catch (MisplacedExponentException e)
        {
            view.showMisplacedExponentException(e);
        }
        catch (EmptyFormulaException e)
        {
            view.showEmptyFormulaException(e);
        }
        catch (UnknownChemicalElementException e)
        {
             view.showUnknownChemicalElementException(e);
        }
        catch (MissingClosingParenthesisException e)
        {
              view.showMissingClosingParenthesisException(e);
        }
    }

    public void show()
    {
        view.show();
    }

}
