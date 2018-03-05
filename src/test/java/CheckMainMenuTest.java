import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static utils.Properties.*;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("Mac");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getBaseAdminUrl());

        loginIntoApplication(driver, getAdminLogin(), getAdminPassword());

        List<WebElement> menuElements = driver.findElements(By.cssSelector(".menu .maintab"));

        for (int i = 1; i <= menuElements.size(); i++) {
            Boolean isPresent = driver.findElements(By.cssSelector(".link-levelone")).size() >= 1;
            System.out.println(isPresent);
            if (isPresent) {
                driver.navigate().back();
            }
            WebElement element = driver.findElement(By.xpath("//li[contains(@class, 'maintab')][" + i + "]//a//span"));
            System.out.println(element.getText());
            getTitleAfterRefresh(driver, element);

        }

    }

    private static void getTitleAfterRefresh(WebDriver driver, WebElement element) {
        element.click();
        String title = driver.getTitle();
        System.out.println(title);
        driver.navigate().refresh();
        String titleAfter = driver.getTitle();
        System.out.println(titleAfter);
        assert (title.equals(titleAfter));
    }
}
