import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;
import runner.TestUtils;

public class FreestyleTest extends BaseTest {
    private static final String[] characterName = {"!", "@", "#", "$", ";", "%", "^", "&", "?", "*", "[", "]", "/", ":"};

    @Test
    public void userCanCreateFreestyleProject() {
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys("Name");
        getDriver().findElement(By.className("hudson_model_FreeStyleProject")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.cssSelector("[type='submit']")).click();

        Assert.assertEquals(getDriver()
                        .findElement(By.xpath(String.format("//li/a[@href='/job/%s/']", "Name"))).getText(), "Name");
    }

    @Test
    public void userCannotCreateProjectNameWithInvalidCharacter() {
        getDriver().findElement(By.linkText("New Item")).click();
        for(String symbol : characterName) {
            TestUtils.clearAndSend(getDriver(), By.id("name"), symbol);

            Assert.assertEquals(getDriver().findElement(By.id("itemname-invalid")).getText(),
                    String.format("» ‘%s’ is an unsafe character", symbol));
        }
    }
}
