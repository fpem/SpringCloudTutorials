package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WeatherService {
    private static Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/weather")
    public String getWeather() {
        log.info("Access /weather");

        return "Sunny :) \n  -- service provided by instance "+ serverPort ;
    }

    @RequestMapping(value = "/greeting")
    public String greet() {
        log.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

}
