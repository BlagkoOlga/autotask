import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver(final String os) {
        if (os.equals("Mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        }
        return new ChromeDriver();
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    static void getTitleAfterRefresh(WebDriver driver, WebElement element) {
        element.click();
        String title = driver.getTitle();
        System.out.println(title);
        driver.navigate().refresh();
        String titleAfter = driver.getTitle();
        System.out.println(titleAfter);
        assert(title.equals(titleAfter));
    }
}
