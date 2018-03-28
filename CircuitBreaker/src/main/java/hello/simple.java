package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class simple {
    /*@Service
    public static class ReliableWeatherService {

      private final RestTemplate restTemplate;

      public ReliableWeatherService(RestTemplate rest) {
        this.restTemplate = rest;
      }

      @HystrixCommand(fallbackMethod = "reliable")
      public String readingList() {
        URI uri = URI.create("http://localhost:6601/weather");

        return this.restTemplate.getForObject(uri, String.class);
      }

      public String reliable() {
        return "Raining. #by fallback";
      }

    }

    //@EnableHystrixDashboard
    @EnableCircuitBreaker
    @RestController
    @SpringBootApplication
    public static class CircuitBreakerApplication {

      @Autowired
      private ReliableWeatherService reliableWeatherService;

      @Bean
      public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
      }

      @RequestMapping("/weather")
      public String toRead() {
        return reliableWeatherService.readingList();
      }

      public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerApplication.class, args);
      }
    }*/
}
