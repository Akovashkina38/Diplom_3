package testsburger;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class BurgerConstructorTest {
    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = open(HomePage.URL, HomePage.class);
    }

    @Test
    @DisplayName("Переход к Булке")
    public void navigateToBunIngredient() {
        boolean isDisplayed = homePage.findBunIngredient();

        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Переход к соусу")
    public void navigateToSauceIngredient() {
        boolean isDisplayed = homePage.findSauceIngredient();

        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Переход к начинкам")
    public void navigateToFillingIngredient() {
        boolean isDisplayed = homePage.findFillingIngredient();

        assertTrue(isDisplayed);
    }
}