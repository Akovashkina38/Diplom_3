package testsburger;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import user.User;
import user.UserGenerate;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterTest {
    private User user;
    private HomePage homePage;

    @Before
    public void setUp() {
        user = UserGenerate.getRandomUser();
        homePage = open(HomePage.URL, HomePage.class);
    }

    @After
    public void clearState() {
        user = null;
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Регистрация пользвателя с корректными данными")
    public void registerUserByValidCredentials() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);

        assertFalse(isDisplayed);
    }

    @Test
    @DisplayName("Регистрация пользователя с неверным паролем")
    public void registerUserByInvalidPassword() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .clickRegisterButton(Condition.visible);

        assertTrue(isDisplayed);
    }

    @Test
    @DisplayName("Регистрация пользователя с ошибкой пароля")
    public void registerUserIsDisplayedPasswordError() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), "888")
                .isDisplayedPasswordError();

        assertTrue(isDisplayed);
    }
}