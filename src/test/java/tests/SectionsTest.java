package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SectionsTest extends BaseTest {
    @Test
    @DisplayName("Переход к разделу 'Булки'")
    public void navigateToBunsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesSection();
        mainPage.clickBunsSection();
        assertTrue("Раздел 'Булки' должен быть активным",
                mainPage.isBunsSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Соусы'")
    public void navigateToSaucesSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesSection();
        assertTrue("Раздел 'Соусы' должен быть активным",
                mainPage.isSaucesSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу 'Начинки'")
    public void navigateToFillingsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsSection();
        assertTrue("Раздел 'Начинки' должен быть активным",
                mainPage.isFillingsSectionActive());
    }
}