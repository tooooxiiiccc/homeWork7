package steps;

import utils.ConfigReader;
import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginPageSteps {
    @Step("Залогиниться на CineScope")
    public void login() {
        String email = ConfigReader.getEmail();
        String password = ConfigReader.getPassword();
        new LoginPage()
            .openMainPage()
            .openLoginPage()
            .setEmail(email)
            .setPassword(password)
            .clickLoginButton();
    }
}
