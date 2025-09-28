package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement emailInput = $x("//input[@id='email']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement loginButton = $x("//button[@type='submit']");

    public void openLoginPage() {
        open("https://cinescope.t-qa.ru/login");
    }

    public void enterEmail(String email) {
        emailInput.shouldBe(Condition.visible);
        emailInput.setValue(email);
    }

    public void enterPassword(String password) {
        passwordInput.shouldBe(Condition.visible);
        passwordInput.setValue(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(Condition.visible);
        loginButton.click();
    }

    public MoviesPage login(String email, String password) {
        openLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();

        MoviesPage moviesPage = new MoviesPage();
        return moviesPage.navigateToAllMoviesPage();
    }
}
