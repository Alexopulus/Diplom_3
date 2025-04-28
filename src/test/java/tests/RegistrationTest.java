package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Успешная регистрация")
    @Description("Открывается страница входа")
    public void successfulRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();

        String email = "testuser_" + System.currentTimeMillis() + "@example.com";
        registerPage.register("Test User", email, "password123");

        assertTrue("После регистрации должна открыться страница входа",
                loginPage.isPageLoaded());
    }

    @Test
    @DisplayName("Ошибка при регистрации с некорректным паролем")
    @Description("Отображается ошибка о некорректном пароле")
    public void registrationWithShortPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();

        registerPage.register("Test User", "test@example.com", "12345");

        assertTrue("Должна отображаться ошибка о некорректном пароле",
                registerPage.isPasswordErrorDisplayed());
    }
}