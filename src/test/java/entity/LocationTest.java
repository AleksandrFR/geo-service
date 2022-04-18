package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class LocationTest {
    Location location = new Location("New York", Country.USA, null, 0);
    Country expected = Country.USA;

    @Test
    public void getCountry_test() {
        Country result = location.getCountry();
        Assertions.assertEquals(expected, result);
    }
}
