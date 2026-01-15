package tests;

import io.qameta.allure.Step;
import junit.UITest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.AllMoviesPageSteps;
import utils.FilterData;
import utils.TestData;

@UITest
@Tag("regress")
public class FilterTest {
    private final AllMoviesPageSteps allMoviesPageSteps = new AllMoviesPageSteps();

    @Test
    @Step("Сценарий проверки работы фильтров")
    public void testFilter() {
        FilterData filterData = new FilterData(
            TestData.FILTER_CITY_MSK,
            TestData.FILTER_GENRE_CRIME,
            TestData.FILTER_DATE_NEW
        );
        allMoviesPageSteps.openAllMoviesPage();
        allMoviesPageSteps.setFilters(filterData);
        allMoviesPageSteps.verifyFilters(filterData);
    }
}
