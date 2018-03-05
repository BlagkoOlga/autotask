import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver(final String os) {
        if (os.equals("Mac")) {
            new File(BaseScript.class.getResource("drivers/chromedriver").getFile()).getPath();
        } else {
            new File(BaseScript.class.getResource("drivers/chromedriver.exe").getFile()).getPath();
        }
        return new ChromeDriver();
    }

    public static void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    static void loginIntoApplication(WebDriver driver, final String login, final String password) {
        WebElement loginField = driver.findElement(By.id("email"));
        enterText(loginField, login);

        WebElement passwordField = driver.findElement(By.id("passwd"));
        enterText(passwordField, password);

        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginButton.click();
    }
}
