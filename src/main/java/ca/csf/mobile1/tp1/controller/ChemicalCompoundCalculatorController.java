package ca.csf.mobile1.tp1.controller;

import ca.csf.mobile1.tp1.chemical.compound.ChemicalCompound;
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

/**
 * Classe ayant le rôle de controller dans l'appication selon le modèle d'architecture MVC
 * Le modèle est une librairire calculant les masse molaires de composés chimiques
 */
public class ChemicalCompoundCalculatorController implements ChemicalCompoundCalculatorConsoleView.Listener
{ //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
    private String outputString = "Le poids de %s est %f g/mol.\n";
    ChemicalCompoundCalculatorConsoleView view;
    ChemicalCompoundFactory model;

    /**
     * Constructeur de la classe
     * @param view la view de l'application selon architeccture MVC
     * @param model le modèle de l'application selon architeccture MVC
     */
    public ChemicalCompoundCalculatorController(ChemicalCompoundCalculatorConsoleView view , ChemicalCompoundFactory model)
    { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
        this.model = model;
        this.view = view;
        view.addListener(this);
    }

    /**
     * Méthode de l'interface Listener de la view du MVC
     * La méthode appelle le modèle de calcul des masse molaires
     * et gère les exceptions de composés chimiques non valables
     * @see ChemicalCompoundCalculatorConsoleView #Listener
     */
    public void onDataEntered()
    { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.

       try {
           String formula = view.getInput();
           ChemicalCompound compound= model.createFromString(formula);
           double molarWeigth = compound.getWeight();

           outputString = String.format(outputString,formula,molarWeigth);
           view.setOutput(outputString);
       }
        catch (EmptyParenthesisException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            view.showEmptyParenthesisException(e);
        }
        catch (IllegalCharacterException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
             view.showIllegalCharacterException(e);
        }
        catch (IllegalClosingParenthesisException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            view.showIllegalClosingParenthesisException(e);
        }
        catch (MisplacedExponentException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            view.showMisplacedExponentException(e);
        }
        catch (EmptyFormulaException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            view.showEmptyFormulaException(e);
        }
        catch (UnknownChemicalElementException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
             view.showUnknownChemicalElementException(e);
        }
        catch (MissingClosingParenthesisException e)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
              view.showMissingClosingParenthesisException(e);
        }
    }

    /**
     * Méthode déammarrant le contrôleur
     */
    public void show()
    {
        view.show();
    }

}
