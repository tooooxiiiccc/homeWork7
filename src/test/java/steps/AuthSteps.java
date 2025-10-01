package steps;

import pages.LoginPage;
import pages.MoviesPage;

public class AuthSteps {
    public MoviesPage loginToMoviesPage() {
        String email = "danila.morozov25@gmail.com";
        String password = "misterBeast12345_";
        return new LoginPage().makeALogin(email, password);
    }
}
