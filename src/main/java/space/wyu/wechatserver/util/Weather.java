package space.wyu.wechatserver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.wyu.wechatserver.config.WechatConfig;
import space.wyu.wechatserver.controller.WechatController;

import javax.annotation.PostConstruct;

@Component
public class Weather {
    static Logger logger = LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private WechatConfig wechatConfig;
    public volatile static Weather weather = new Weather();

    @PostConstruct
    public void init() {
        weather = this;
        weather.wechatConfig = this.wechatConfig;
    }

    public String getWeather(String latitude, String longitude) {
        String key = wechatConfig.getWeatherKey();
        String url = "https://free-api.heweather.net/s6/weather/forecast?location=" + longitude + "," + latitude + "&key=" + key;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        logger.info("weather info: " + result);
        StringBuilder weatherInfo = new StringBuilder();
        weatherInfo.append("\n\n===============\n\n天气预报：\n");
        try {
            JSONObject object = new JSONObject(result);
            JSONObject weather = (JSONObject) object.getJSONArray("HeWeather6").get(0);
            weatherInfo.append("\n城市名称：");
            weatherInfo.append(weather.getJSONObject("basic").getString("location"));
            weatherInfo.append("\n城市ID：");
            weatherInfo.append(weather.getJSONObject("basic").getString("cid"));
            weatherInfo.append("\n城市的上级城市：");
            weatherInfo.append(weather.getJSONObject("basic").getString("parent_city"));
            weatherInfo.append("\n城市所属行政区域：");
            weatherInfo.append(weather.getJSONObject("basic").getString("admin_area"));
            weatherInfo.append("\n城市所属国家名称：");
            weatherInfo.append(weather.getJSONObject("basic").getString("cnty"));
            weatherInfo.append("\n城市纬度：");
            weatherInfo.append(weather.getJSONObject("basic").getString("lat"));
            weatherInfo.append("\n城市经度：");
            weatherInfo.append(weather.getJSONObject("basic").getString("lon"));
            weatherInfo.append("\n城市所在时区：");
            weatherInfo.append(weather.getJSONObject("basic").getString("tz"));
            weatherInfo.append("\n最后更新时间（当地）：");
            weatherInfo.append(weather.getJSONObject("update").getString("loc"));
            weatherInfo.append("\n最后更新时间（UTC）：");
            weatherInfo.append(weather.getJSONObject("update").getString("utc"));
            JSONArray forecast = weather.getJSONArray("daily_forecast");
            for (int i = 0; i < forecast.length(); i++) {
                weatherInfo.append("\n\n预报日期：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("date"));
                weatherInfo.append("\n日出时间：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("sr"));
                weatherInfo.append("\n日落时间：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("ss"));
                weatherInfo.append("\n月升时间：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("mr"));
                weatherInfo.append("\n月落时间：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("ms"));
                weatherInfo.append("\n最高温度：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("tmp_max"));
                weatherInfo.append("\n最低温度：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("tmp_min"));
                weatherInfo.append("\n白天天气状况描述：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("cond_txt_d"));
                weatherInfo.append("\n晚间天气状况描述：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("cond_txt_n"));
                weatherInfo.append("\n风向360角度：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("wind_deg"));
                weatherInfo.append("\n风向：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("wind_dir"));
                weatherInfo.append("\n风力：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("wind_sc"));
                weatherInfo.append("\n风速，公里/小时：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("wind_spd"));
                weatherInfo.append("\n相对湿度：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("hum"));
                weatherInfo.append("\n降水量：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("pcpn"));
                weatherInfo.append("\n降水概率：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("pop"));
                weatherInfo.append("\n大气压强：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("pres"));
                weatherInfo.append("\n紫外线强度指数：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("uv_index"));
                weatherInfo.append("\n能见度，单位(公里)：");
                weatherInfo.append(((JSONObject) forecast.get(i)).getString("vis"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherInfo.toString();
    }
}
