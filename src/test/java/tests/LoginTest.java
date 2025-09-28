package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.MoviePage;
import pages.MoviesPage;
import pages.PaymentPage;


@UITest
public class LoginTest {

    @Test
    public void testLoginAndSelectMovie() {
        MoviesPage moviesPage = new MoviesPage();
        moviesPage.selectMovie("Механик");
        MoviePage moviePage = new MoviePage();
        moviePage.clickBuyTicketButton();
    }

}
