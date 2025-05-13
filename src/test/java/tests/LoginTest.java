package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    @Description("Пользователь авторизован")
    public void loginViaMainPageButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        assertTrue("После входа должна отображаться страница профиля",
                profilePage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Пользователь авторизован")
    public void loginViaPersonalAccountButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        assertTrue("После входа должна отображаться страница профиля",
                profilePage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Пользователь авторизован")
    public void loginViaRegisterFormTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        assertTrue("После входа должна отображаться страница профиля",
                profilePage.isPageLoaded());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Пользователь авторизован")
    public void loginViaForgotPasswordFormTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickLoginButton();
        loginPage.clickRestorePasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        assertTrue("После входа должна отображаться страница профиля",
                profilePage.isPageLoaded());
    }
}
