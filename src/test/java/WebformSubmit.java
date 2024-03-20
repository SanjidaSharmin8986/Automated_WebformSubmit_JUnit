import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebformSubmit {
    WebDriver driver;
    @BeforeAll
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void SubmitForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElements(By.className("onetrust-close-btn-handler")).get(0).click();
        driver.findElement(By.id("edit-name")).sendKeys("Sanjida Sharmin");
        driver.findElement(By.id("edit-number")).sendKeys("01845678999");
        List < WebElement> age = driver.findElements(By.className("ui-checkboxradio-label"));
        age.get(1).click();
        driver.findElement(By.id("edit-date")).sendKeys("03/20/2024");
        Scrolling.scroll(driver,0,500);
        driver.findElement(By.id("edit-email")).sendKeys("sanjidasharmin@test.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("Hi, this is Sanjida. I am a professional SQA Engineer.");
        Scrolling.scroll(driver,0,500);
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Test_Data.xlsx");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust the timeout as needed
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit-uploadocument-upload")));
        Scrolling.scroll(driver,0,500);
        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assertions.assertTrue(actualText.contains("Thank you for your submission!"));

    }
}
