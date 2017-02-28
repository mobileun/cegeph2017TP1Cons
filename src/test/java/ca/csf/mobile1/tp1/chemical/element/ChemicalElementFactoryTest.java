package ca.csf.mobile1.tp1.chemical.element;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChemicalElementFactoryTest {

    private ChemicalElementFactory chemicalElementFactory;

    @Before
    public void before() {
        chemicalElementFactory = new ChemicalElementFactory();
    }

    @Test
    public void canCreateChemicalElementFromCommasSeparatedString() {
        ChemicalElement chemicalElement = chemicalElementFactory.createFromString("Hydrogène,H,1,1.00794");

        assertEquals("Hydrogène", chemicalElement.getName());
        assertEquals("H", chemicalElement.getSymbol());
        assertEquals(1, chemicalElement.getNumber());
        assertEquals(1.00794D, chemicalElement.getWeight(), 0.000001D);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateChemicalElementFromNullString() {
        chemicalElementFactory.createFromString(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateChemicalElementFromEmptyString() {
        chemicalElementFactory.createFromString("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateChemicalElementFromWhitespaceString() {
        chemicalElementFactory.createFromString("           ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateChemicalElementIfPartsAreMissingFromString() {
        chemicalElementFactory.createFromString("Hydrogène,H,1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateChemicalElementIfPartsAreNotOfTheRightType() {
        chemicalElementFactory.createFromString("1.00794,Hydrogène,H,1");
    }

}