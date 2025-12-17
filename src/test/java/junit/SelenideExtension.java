package junit;

import utils.ConfigReader;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.codeborne.selenide.Configuration;



public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.closeWebDriver();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }
}
