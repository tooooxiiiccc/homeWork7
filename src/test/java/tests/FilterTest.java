package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.AllMoviesPage;
import steps.AllMoviesPageSteps;

@UITest
public class FilterTest {
    private final AllMoviesPage allMoviesPage = new AllMoviesPage();
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();

    @Test
    @Step("Сценарий проверки работы фильтров")
    public void testFilter() {
        String city = "MSK";
        String genre = "Криминал";
        String date = "Новые";
        allMoviesPage.open();
        allMoviesPageSteps.setFilters(city, genre, date);
        allMoviesPageSteps.verifyFilters(city, genre, date);
    }
}
