package ca.csf.mobile1.tp1.chemical.element;

/**
 * Fabrique d'éléments du tableau périodique.
 *
 * @author Benjamin Lemelin
 * @author Daniel Huot
 * @see ChemicalElement
 */
public class ChemicalElementFactory {

    /**
     * Construit un nouveau {@link ChemicalElement} à partir d'une chaine de caractères, formatée ainsi :
     * <br />
     * <br />
     * <code>
     *     NOM, SYMBOLE, NUMÉRO, POIDS
     * </code>
     * <br />
     * <br />
     * Par exemple :
     * <br />
     * <br />
     * <code>
     *     Hydrogene,H,1,1.00794
     * </code>
     * <br />
     * <br />
     * Les 4 parties doivent être séparées par une virgule. <code>NOM</code> et <code>SYMBOLE</code> doivent être une chaine de caractère.
     * <code>NUMÉRO</code> doit être un entier positif et <code>POIDS</code> doit être un nombre décimal compatible avec le type {@link Double}.
     * Si le format est incorrect, une {@link IllegalArgumentException} est lancée.
     * @param string La chaine de caractère à transformer en {@link ChemicalElement}.
     * @return {@link ChemicalElement} créé à partir de la chaine de caractère reçue
     * @throws IllegalArgumentException Lorsque la chaine de caractères ne respecte pas le format demandé.
     */
    public ChemicalElement createFromString(String string) {
        //BEN_CORRECTION : Enlever les "TODO" une fois fait.
        //TODO : À partir de la string, créer un ChemicalElement.
        //       Cette String est en 4 parties :
        //              1. Le nom
        //              2. Le symbole
        //              3. Le numéro
        //              4. Le poids
        //      Chaque partie est séparée par une virgule.
        if (string == null)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            throw new IllegalArgumentException();
        }
        string =string.replaceAll("\\s","");
        string =string.replaceAll("\\\t","");
        string =string.replaceAll("\\\n","");


        if (string.length() < 1)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            throw new IllegalArgumentException();
        }

        String[] formulaSplitted = string.split(",");
        if (formulaSplitted.length != 4)
        { //BEN_CORRECTION : "{" styles C#. Non respect du standard Java.
            throw new IllegalArgumentException();
        }
        //BEN_REVIEW : Évite de créer une variable si ce n'est que pour la "retourner" juste après.
        ChemicalElement chemicalElement = new ChemicalElement(formulaSplitted[0],formulaSplitted[1],Integer.parseInt(formulaSplitted[2]),Double.parseDouble(formulaSplitted[3]));



        return chemicalElement;
    }

}
