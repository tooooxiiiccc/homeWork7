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
        String selenoidUrl = System.getProperty("selenoid.url");
        if (selenoidUrl != null && !selenoidUrl.isEmpty()) {
            // Отключаем автоматическое управление драйвером для удаленного запуска
            Configuration.driverManagerEnabled = false;
            
            // Настройка удаленного запуска через Selenoid
            Configuration.remote = selenoidUrl;
            Configuration.browser = System.getProperty("browser", "chrome");
            String browserVersion = System.getProperty("browser.version", "latest");
            Configuration.browserVersion = browserVersion;
            Configuration.headless = true;
            
            // Настройка ChromeOptions для Selenoid
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            
            // Настройка Selenoid options через ChromeOptions
            HashMap<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", false);
            selenoidOptions.put("enableLog", true);
            chromeOptions.setCapability("selenoid:options", selenoidOptions);
            
            // Применение ChromeOptions к конфигурации
            Configuration.browserCapabilities = chromeOptions;
        } else {
            Configuration.browser = "chrome";
            Configuration.headless = false;
            Configuration.driverManagerEnabled = true;
        }
        
        Configuration.browserSize = System.getProperty("browser.size", "1920x1080");
        Configuration.timeout = 10000;
    }
}
