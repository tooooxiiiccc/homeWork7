package steps;

import io.qameta.allure.Step;
import pages.MoviesPageAndFilters;

public class NavigationSteps {
    @Step("Перейти на страницу всех фильмов")
    public MoviesPageAndFilters navigateToAllMoviesPage(){
        return new MoviesPageAndFilters().navigateToAllMoviesPage();
    }
}
