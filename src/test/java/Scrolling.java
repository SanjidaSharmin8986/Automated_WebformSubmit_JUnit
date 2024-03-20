import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling
{
        public static void scroll(WebDriver driver, int w, int h)
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy("+w+","+h+")", "");
        }
}
