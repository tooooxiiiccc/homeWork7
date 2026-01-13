package junit;

import utils.ConfigReader;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.HashMap;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        Selenide.closeWebDriver();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = ConfigReader.getBaseUrl();
        String selenoidUrl = System.getProperty("selenoid.url");
        if (selenoidUrl != null && !selenoidUrl.isEmpty()) {
            Configuration.remote = selenoidUrl;
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserVersion = System.getProperty("browser.version", "128.0");
            Configuration.headless = true;
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
                put("enableVNC", true);
                put("enableVideo", false);
                put("enableLog", true);
            }});
            
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            
            Configuration.browserCapabilities = capabilities;
        } else {
            Configuration.browser = "chrome";
            Configuration.headless = false;
        }
        
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.timeout = 10000;
    }
}
