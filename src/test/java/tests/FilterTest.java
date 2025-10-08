package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.MoviePageAndFiltersSteps;

@UITest
public class FilterTest {
    @Test
    @Step("Сценарий проверки работы фильтров")
    public void testFilter() {
        new MoviePageAndFiltersSteps().setFilters("MSK", "Криминал", "Новые");
    }
}
