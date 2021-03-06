import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static utils.Properties.*;

public class LoginTest extends BaseScript {

    public static void main(String[] args) {

        WebDriver driver = getDriver("Mac");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getBaseAdminUrl());

        loginIntoApplication(driver, getAdminLogin(), getAdminPassword());

        WebElement userIcon = driver.findElement(By.id("employee_infos"));
        userIcon.click();

        WebElement exitButton = driver.findElement(By.id("header_logout"));
        exitButton.click();

    }

}
