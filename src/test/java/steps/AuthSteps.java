package steps;

import pages.LoginPage;
import pages.MoviesPageAndFilters;

public class AuthSteps {
    public MoviesPageAndFilters loginToMoviesPage() {
        String email = "danila.morozov25@gmail.com";
        String password = "misterBeast12345_";
        return new LoginPage().makeALogin(email, password);
    }
}
