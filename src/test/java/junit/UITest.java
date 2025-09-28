package junit;

import org.junit.jupiter.api.extension.ExtendWith;
import junit.LoginExtension;
import junit.SelenideExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(SelenideExtension.class)
@ExtendWith(LoginExtension.class)
public @interface UITest {
}
