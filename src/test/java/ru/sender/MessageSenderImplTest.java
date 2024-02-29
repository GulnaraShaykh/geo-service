package ru.sender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import ru.entity.Country;
import ru.entity.Location;
import ru.geo.GeoService;
import ru.i18n.LocalizationService;
import ru.sender.MessageSenderImpl;

public class MessageSenderImplTest {

    //Тест на отправку русского текста при российском IP
    @Test
    void shouldSendRussianMessageForRussianIp() {

        GeoService geoService = mock(GeoService.class);
        LocalizationService localizationService = mock(LocalizationService.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String message = messageSender.send(headers);
        assertEquals("Добро пожаловать", message);

    }

    //Тест на отправку английского текста при американском IP:

    @Test
    void shouldSendEnglishMessageForAmericanIp() {
        GeoService geoService = mock(GeoService.class);
        LocalizationService localizationService = mock(LocalizationService.class);
        MessageSenderImpl  messageSender = new MessageSenderImpl(geoService, localizationService);

        when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, null, 0));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String message = messageSender.send(headers);

        assertEquals("Welcome", message);

    }

}
