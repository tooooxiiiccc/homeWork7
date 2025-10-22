package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;

@UITest
public class FilterTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();

    @Test
    @Step("Сценарий проверки работы фильтров")
    public void testFilter() {
        String city = "MSK";
        String genre = "Криминал";
        String date = "Новые";
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.setFilters(city, genre, date);
        allMoviesPageSteps.verifyFilters(city, genre, date);
    }
}
