import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

import java.util.List;

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

//    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
//    public void modalAdHeaderFontColorIsWhite() {
//        String fontColor = modalAdTitleBar.getCssValue("color");
//        String fontColorHex = Color.fromString(fontColor).asHex();
//
//        Assert.assertEquals(fontColorHex, "#ffffff");
//    }
//
//    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
//    public void modalAdHeaderFontFacadeIsOpenSans() {
//        String fontFamily = modalAdTitleBar.getCssValue("font-family");
//        System.out.println(fontFamily);
//        String mainFont = fontFamily.split(",")[0];
//
//        Assert.assertTrue(mainFont.contains("Open Sans"));
//    }
//
//    @Test(dependsOnMethods = {"modalAdIsDisplayed"})
//    public void modalAdHasBlackBackgroundHeader() {
//        String backgroundColor = modalAdTitleBar.getCssValue("background-color");
//        // pobrany kolor w formacie rgb();
//        System.out.println(backgroundColor);
//        // konwersja do formatu szesnastkowego (heksadecymalny)
//        String backgroundColorHex = Color.fromString(backgroundColor).asHex();
//
//        Assert.assertEquals(backgroundColorHex, "#252525");
//    }


    //ZADANIA DOMOWE ROZWIĄZANIA:


    //1. przetestować poprawność koloru linku 'click here' na stronie http://the-internet.herokuapp.com/entry_ad

    @Test
    public void linkFontColorIsBlue() {

        driver.get("http://the-internet.herokuapp.com/entry_ad");

        WebElement close = driver.findElement(By.cssSelector(".modal-footer > p"));

        if (close.isDisplayed()) {
            close.click();

            WebElement clickHereButton = driver.findElement(By.cssSelector("#restart-ad"));

            String fontColor = clickHereButton.getCssValue("color");
            String fontColorHex = Color.fromString(fontColor).asHex();

            Assert.assertEquals(fontColorHex, "#2ba6cb");

        } else {

            WebElement clickHereButton = driver.findElement(By.cssSelector("#restart-ad"));

            String fontColor = clickHereButton.getCssValue("color");
            String fontColorHex = Color.fromString(fontColor).asHex();

            Assert.assertEquals(fontColorHex, "#2ba6cb");


        }
    }


    //2. przetestować czy zmienia się kolor linku po najechaniu
    //5. Dopisać w dowolnym teście zrobienie zrzutu ekranu

    @Test
    public void linkHoverColor() {

        driver.get("http://the-internet.herokuapp.com/entry_ad");

        WebElement close = driver.findElement(By.cssSelector(".modal-footer > p"));

        if (close.isDisplayed()) {
            close.click();

            WebElement clickHereButton = driver.findElement(By.cssSelector("#restart-ad"));

            Actions hoverLink = new Actions(driver);
            hoverLink.moveToElement(clickHereButton)
                    //.pause(1000)
                    .build()
                    .perform();

            String fontColorHov = clickHereButton.getCssValue("color");
            String fontColorHexHov = Color.fromString(fontColorHov).asHex();

            Assert.assertEquals(fontColorHexHov, "#2795b6");

            ScreenshotUtil.takeScreenshot(driver, "linkHover.jpg");

        } else {

            WebElement clickHereButton = driver.findElement(By.cssSelector("#restart-ad"));

            Actions hoverLink = new Actions(driver);
            hoverLink.moveToElement(clickHereButton)
                    //.pause(1000)
                    .build()
                    .perform();

            String fontColorHov = clickHereButton.getCssValue("color");
            String fontColorHexHov = Color.fromString(fontColorHov).asHex();

            Assert.assertEquals(fontColorHexHov, "#2795b6");

            ScreenshotUtil.takeScreenshot(driver, "linkHover.jpg");
        }
    }



    //4. Stworzyć klasę testującą checkboxy i wykonać test czy checkbox 'I have a bike' ma atrybut value równy bike

    @Test
    public void ifCheckBoxHasValueBike() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        List<WebElement> checkBox = driver.findElements(By.cssSelector("input[type='checkbox']"));

        Assert.assertEquals(checkBox.size(), 2);

        WebElement bike = driver.findElement(By.cssSelector("[value='Bike']"));
        String Bike = bike.getAttribute("value");

        Assert.assertEquals(Bike, "Bike");

        ScreenshotUtil.takeScreenshot(driver, "checkBox.jpg");
    }



    //3*. https://justjoin.it/ -> przetestować działanie trybu dzień/noc

    @Test
    public void LightDarkModeTest() {
        driver.get("https://justjoin.it/");

        WebElement locationText = driver.findElement(By.cssSelector(".css-rbgze > .MuiButton-label"));

        String fontColor = locationText.getCssValue("color");
        String fontColorHex = Color.fromString(fontColor).asHex();

        System.out.println("Lightmode font color for Location:");
        System.out.println(fontColorHex);
        System.out.println(fontColor);

        System.out.println("=========");

        WebElement changeMode = driver.findElement(By.cssSelector(".jss171"));
        changeMode.click();

        String darkFontColor = locationText.getCssValue("color");
        String darkFontColorHex = Color.fromString(darkFontColor).asHex();

        System.out.println("Darkmode font color for Location:");
        System.out.println(darkFontColorHex);
        System.out.println(darkFontColor);

        if (fontColor != darkFontColor) {
            System.out.println("Light and Dark mode switching works fine");
        } else {
            System.out.println("Something went wrong");
        }
    }

}

