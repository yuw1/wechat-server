package space.wyu.wechatserver;

import org.junit.jupiter.api.Test;
import space.wyu.wechatserver.util.Weather;

public class WeatherTest {
    @Test
    public void test() {
        System.out.println(Weather.getWeather("116.531784", "39.337372"));;
    }
}
