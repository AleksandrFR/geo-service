package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @Test
    public void send_ipRus_test() {
        String expected = "Добро пожаловать";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.00.00");
        String ip = "172.0.00.00";
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String result = messageSender.send(headers);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void send_ipUSA_test() {
        String expected = "Welcome";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String ip = "96.44.183.149";
        Location location = new Location("New York", Country.USA, null, 0);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String result = messageSender.send(headers);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void send_anotherCountry_test() {
        String expected = "Welcome";
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "1.1.1.1");
        String ip = "1.1.1.1";
        Location location = new Location(null, Country.BRAZIL, null, 0);

        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn(expected);

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);

        String result = messageSender.send(headers);
        Assertions.assertEquals(expected, result);
    }

}