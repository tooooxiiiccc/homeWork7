package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.FilterSteps;

@UITest
public class FilterTest {
    @Test
    public void isFiltersWorks(){
        FilterSteps filterSteps = new FilterSteps();
        filterSteps.applyFiltersAndVerify(
            "MSK",
            "Криминал",
            "Новые",
            "Криминал",
            "MSK"
        );
    }
}
