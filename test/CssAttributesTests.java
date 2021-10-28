import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
ZADANIE DOMOWE:

1. przetestować poprawność koloru linku 'click here' na stronie http://the-internet.herokuapp.com/entry_ad
2. przetestować czy zmienia się kolor linku po najechaniu
3*. https://justjoin.it/ -> przetestować działanie trybu dzień/noc

4. Stworzyć klasę testującą checkboxy i wykonać test czy checkbox 'I have a bike' ma atrybut value równy bike
5. Dopisać w dowolnym teście zrobienie zrzutu ekranu
 */
public class CssAttributesTests extends BaseTest {
    private static WebElement modalAd;
    private static WebElement modalAdTitleBar;

    @Test
    public void modalAdIsDisplayed() {
        driver.get("http://the-internet.herokuapp.com/entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        modalAd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal")));
        modalAdTitleBar = modalAd.findElement(By.className("modal-title"));

        Assert.assertTrue(modalAd.isDisplayed());
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontColorIsWhite() {
        String fontColor = modalAdTitleBar.getCssValue("color");
        String fontColorHex = Color.fromString(fontColor).asHex();

        Assert.assertEquals(fontColorHex, "#ffffff");
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHeaderFontFacadeIsOpenSans() {
        String fontFamily = modalAdTitleBar.getCssValue("font-family");
        System.out.println(fontFamily);
        String mainFont = fontFamily.split(",")[0];

        Assert.assertTrue(mainFont.contains("Open Sans"));
    }

    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
    public void modalAdHasBlackBackgroundHeader() {
        String backgroundColor = modalAdTitleBar.getCssValue("background-color");
        // pobrany kolor w formacie rgb();
        System.out.println(backgroundColor);
        // konwersja do formatu szesnastkowego (heksadecymalny)
        String backgroundColorHex = Color.fromString(backgroundColor).asHex();

        Assert.assertEquals(backgroundColorHex, "#252525");
    }
}
