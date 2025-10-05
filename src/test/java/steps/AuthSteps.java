package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.MoviesPageAndFilters;

public class AuthSteps {
    @Step("Залогиниться на CineScope")
    public MoviesPageAndFilters loginToMoviesPage() {
        String email = "danila.morozov25@gmail.com";
        String password = "misterBeast12345_";
        return new LoginPage().makeALogin(email, password);
    }
}
