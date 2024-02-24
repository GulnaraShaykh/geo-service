import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

class LocalizationServiceImplTest {

    @Test
    void testLocale() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        // Проверяем возвращаемый текст для разных стран
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
        // Добавьте больше тестов для различных сценариев
    }
}
