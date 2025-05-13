package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import static org.junit.Assert.assertTrue;

public class NavigationTest extends BaseTest {
    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Перешли в личный кабинет, отображается страница профиля")
    public void navigateToPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();

        assertTrue("Должна отображаться страница профиля",
                profilePage.isPageLoaded());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    @Description("Перешли в конструктор, активен раздел Булки")
    public void navigateFromProfileToConstructorViaButtonTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickConstructorButton();

        assertTrue("Должен быть активен раздел 'Булки'",
                mainPage.isBunsSectionActive());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Description("Перешли в конструктор, активен раздел Булки")
    public void navigateFromProfileToConstructorViaLogoTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickLogo();

        assertTrue("Должен быть активен раздел 'Булки'",
                mainPage.isBunsSectionActive());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Отображается страница входа")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.open();
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.clickLogoutButton();

        assertTrue("После выхода должна открыться страница входа",
                loginPage.isPageLoaded());
    }
}
