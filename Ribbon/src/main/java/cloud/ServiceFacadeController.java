package cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class ServiceFacadeController {
    private static Logger log = LoggerFactory.getLogger(ServiceFacadeController.class);
    @Value("${cloud.application.name}")
    private String applicationName;
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/")
    public String index() {
        return "welcome, you can find weather by access /weather";
    }

    @RequestMapping("/weather")
    public String getWeather(@RequestParam(value="city", required=false) String city) {
        log.info("access /weather with parameter city= ["+ city+ "], applicationName: " +applicationName);

       return this.restTemplate.getForObject("http://"+applicationName+"/weather", String.class);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @RequestMapping("/weather2")
    public String getWeather2(@RequestParam(value="city", required=false) String city) {
        log.info("access /weather with parameter city= ["+ city+ "], applicationName: " +applicationName);

        ServiceInstance instance = this.loadBalancerClient.choose(applicationName);
        URI helloUri = URI.create(String.format("http://%s:%s/weather", instance.getHost(), instance.getPort()));
        log.info("Target service uri = "+ helloUri.toString());
        return new RestTemplate().getForObject(helloUri, String.class);
    }
}
