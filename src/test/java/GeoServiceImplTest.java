import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeoServiceImplTest {

    @Test
    void shouldReturnCorrectLocationForIp() {
        GeoService geoService = new GeoServiceImpl();

        Location moscow = geoService.byIp("172.0.32.11");
        assertEquals(Country.RUSSIA, moscow.getCountry());

        Location newYork = geoService.byIp("96.44.183.149");
        assertEquals(Country.USA, newYork.getCountry());
    }
}