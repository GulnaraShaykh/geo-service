package ru.geo;

import org.junit.jupiter.api.Test;
import ru.entity.Country;
import ru.entity.Location;
import ru.geo.GeoService;
import ru.geo.GeoServiceImpl;

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