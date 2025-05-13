package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunsSection = By.xpath("//span[text()='Булки']/parent::div");
    private final By saucesSection = By.xpath("//span[text()='Соусы']/parent::div");
    private final By fillingsSection = By.xpath("//span[text()='Начинки']/parent::div");
    private final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Открыть главную страницу")
    public void open() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));
    }

    @Step("Кликнуть на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Кликнуть на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton)).click();
    }

    @Step("Кликнуть на раздел 'Булки'")
    public void clickBunsSection() {
        clickSection(bunsSection);
    }

    @Step("Кликнуть на раздел 'Соусы'")
    public void clickSaucesSection() {
        clickSection(saucesSection);
    }

    @Step("Кликнуть на раздел 'Начинки'")
    public void clickFillingsSection() {
        clickSection(fillingsSection);
    }

    @Step("Кликнуть на логотип")
    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
    }

    @Step("Кликнуть на 'Конструктор'")
    public void clickConstructorButton() {
        wait.until(ExpectedConditions.elementToBeClickable(constructorButton)).click();
    }

    private void clickSection(By section) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(section));
        element.click();
    }

    @Step("Проверить активность раздела 'Булки'")
    public boolean isBunsSectionActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bunsSection))
                .getAttribute("class").contains("current");
    }

    @Step("Проверить активность раздела 'Соусы'")
    public boolean isSaucesSectionActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(saucesSection))
                .getAttribute("class").contains("current");
    }

    @Step("Проверить активность раздела 'Начинки'")
    public boolean isFillingsSectionActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fillingsSection))
                .getAttribute("class").contains("current");
    }
}