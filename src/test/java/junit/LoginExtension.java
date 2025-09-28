package junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.AuthSteps;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("Login Extension: Начало логина");
        try {
            AuthSteps authSteps = new AuthSteps();
            authSteps.loginToMoviesPage();
            System.out.println("Login Extension: Логин успешен");
        } catch (Exception e) {
            System.out.println("Login Extension: Ошибка логина");
            e.printStackTrace();
        }
    }
}
