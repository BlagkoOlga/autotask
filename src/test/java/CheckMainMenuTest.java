import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static utils.Properties.*;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("Mac");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getBaseAdminUrl());

        WebElement loginField = driver.findElement(By.id("email"));
        enterText(loginField, getAdminLogin());

        WebElement passwordField = driver.findElement(By.id("passwd"));
        enterText(passwordField, getAdminPassword());

        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginButton.click();

        wait(driver, "tab-AdminDashboard");
        WebElement dashboardItem = driver.findElement(By.id("tab-AdminDashboard"));
        getTitleAfterRefresh(driver, dashboardItem);

        wait(driver, "subtab-AdminParentOrders");
        WebElement ordersItem = driver.findElement(By.id("subtab-AdminParentOrders"));
        getTitleAfterRefresh(driver, ordersItem);

        wait(driver, "subtab-AdminCatalog");
        WebElement catalogItem = driver.findElement(By.id("subtab-AdminCatalog"));
        getTitleAfterRefresh(driver, catalogItem);

        //wait(driver, "subtab-AdminParentCustomer");
        WebElement customersItem = driver.findElement(By.partialLinkText("AdminParentCustomers"));
        getTitleAfterRefresh(driver, customersItem);

        //wait(driver, "subtab-AdminParentCustomerThreads");
        WebElement customersThreadsItem = driver.findElement(By.id("subtab-AdminParentCustomerThreads"));
        getTitleAfterRefresh(driver, customersThreadsItem);

        wait(driver, "ssubtab-AdminStats");
        WebElement adminStatsItem = driver.findElement(By.id("ssubtab-AdminStats"));
        getTitleAfterRefresh(driver, adminStatsItem);

        wait(driver, "subtab-AdminParentModulesSf");
        WebElement modulesItem = driver.findElement(By.id("subtab-AdminParentModulesSf"));
        getTitleAfterRefresh(driver, modulesItem);

        wait(driver, "subtab-AdminParentThemes");
        WebElement designItem = driver.findElement(By.id("subtab-AdminParentThemes"));
        getTitleAfterRefresh(driver, designItem);

        wait(driver, "subtab-AdminParentShipping");
        WebElement shippingItem = driver.findElement(By.id("subtab-AdminParentShipping"));
        getTitleAfterRefresh(driver, shippingItem);

        wait(driver, "subtab-AdminParentPayment");
        WebElement paymentItem = driver.findElement(By.id("subtab-AdminParentPayment"));
        getTitleAfterRefresh(driver, paymentItem);

        wait(driver, "subtab-AdminInternational");
        WebElement internationalItem = driver.findElement(By.id("subtab-AdminInternational"));
        getTitleAfterRefresh(driver, internationalItem);

        wait(driver, "subtab-ShopParameters");
        WebElement shopParametersItem = driver.findElement(By.id("subtab-ShopParameters"));
        getTitleAfterRefresh(driver, shopParametersItem);

        wait(driver, "subtab-AdminAdvancedParameters");
        WebElement configItem = driver.findElement(By.id("subtab-AdminAdvancedParameters"));
        getTitleAfterRefresh(driver, configItem);

    }

    private static void wait(WebDriver driver, String locator) {
        WebElement explicitWait = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }

}
