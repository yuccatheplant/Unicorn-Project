package unicorn.project.config;

import unicorn.project.model.Beer;
import unicorn.project.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitialisationConfig {
    @Autowired
    private BeerService beerService;

    /**
    * Event listener that fires on every startup of application
    */
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (beerService.getAllBeers().isEmpty()) {
            fetchDataFromExternalEndpoint();
        }
    }

    /**
    * Process of fetching beers from the endpoint and uploading them into MongoDB database
    */
    private void fetchDataFromExternalEndpoint() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://random-data-api.com/api/v2/beers?size=100";
        Beer[] users = restTemplate.getForObject(url, Beer[].class);
        if (users != null) {
            List<Beer> userList = Arrays.asList(users);
            userList.forEach(beerService::saveBeer);
        }
    }
}
