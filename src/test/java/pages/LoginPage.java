package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement emailInput = $x("//input[@id='email']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");

    @Step("Открыть страницу логина")
    public void openLoginPage() {
        open("https://cinescope.t-qa.ru/login");
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        emailInput.shouldBe(Condition.visible);
        emailInput.setValue(email);
    }

    @Step("Ввести пароль: {password}")
    public void enterPassword(String password) {
        passwordInput.shouldBe(Condition.visible);
        passwordInput.setValue(password);
    }

    @Step("Нажать на кнопку Login")
    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible);
        loginButton.click();
    }

    public MoviesPageAndFilters makeALogin(String email, String password) {
        openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        MoviesPageAndFilters moviesPage = new MoviesPageAndFilters();
        return moviesPage.navigateToAllMoviesPage();
    }
}
