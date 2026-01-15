package junit;

import utils.ConfigReader;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.closeWebDriver();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.timeout = 10000;
        
//        String selenoidUrl = System.getProperty("selenoid.url");
        String selenoidUrl = "http://selenoid:4444/wd/hub";
        if (selenoidUrl != null && !selenoidUrl.isEmpty()) {
            Configuration.remote = selenoidUrl;
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserVersion = System.getProperty("browser.version", "128.0");
            Configuration.headless = true;
            
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            
            HashMap<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", false);
            selenoidOptions.put("enableLog", true);
            chromeOptions.setCapability("selenoid:options", selenoidOptions);
            
            Configuration.browserCapabilities = chromeOptions;
        } else {
            Configuration.browser = "chrome";
            Configuration.headless = false;
        }
    }
}
