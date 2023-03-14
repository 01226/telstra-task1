package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.model.ActuationResult;
import au.com.telstra.simcardactivator.model.SimCard;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardHandler {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public SimCardHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8444/actuate";
    }

    public ActuationResult actuate(SimCard simCard) {
        return restTemplate.postForObject(incentiveApiUrl, simCard, ActuationResult.class);
    }

}
