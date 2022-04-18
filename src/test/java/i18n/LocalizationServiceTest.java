package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    Country country = Country.RUSSIA;
    String expected = "Добро пожаловать";
    LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    public void locale_test() {
        String result = localizationService.locale(country);
        Assertions.assertTrue(expected.equals(result));
    }
}
