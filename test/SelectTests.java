import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectTests extends BaseTest{

    @Test
    public void selectListTest() {
        driver.get("http://automationpractice.com/index.php?id_product=1&controller=product");
        WebElement selectList = driver.findElement(By.id("group_1"));

        Select select = new Select(selectList);
        select.selectByValue("3");

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "L");
    }
}
