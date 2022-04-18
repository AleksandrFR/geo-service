package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiseTest {

    String MOSCOW_IP = "172.0.32.11";
    Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

    @Test
    public void location_by_Ip_test() {

        GeoService geoService = new GeoServiceImpl();

        Location result = geoService.byIp(MOSCOW_IP);

        Assertions.assertEquals(location, result);
    }
}
