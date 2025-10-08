package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement loginPageButton = $x("//a[@data-qa-id='login_page_button']");
    private final SelenideElement emailInput = $x("//input[@id='email']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");

    @Step("Открыть основную страницу")
    public LoginPage openMainPage() {
        open("/");
        return this;
    }

    @Step("Открыть страницу логина")
    public LoginPage openLoginPage() {
        loginPageButton.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Ввести email: {email}")
    public LoginPage setEmail(String email) {
        emailInput.shouldBe(Condition.visible);
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль: {password}")
    public LoginPage setPassword(String password) {
        passwordInput.shouldBe(Condition.visible);
        passwordInput.setValue(password);
        return this;
    }

    @Step("Нажать на кнопку Login")
    public LoginPage clickLoginButton() {
        loginButton.shouldBe(Condition.visible);
        loginButton.click();
        return this;
    }
}
