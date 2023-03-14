package au.com.telstra.simcardactivator.component;

import au.com.telstra.simcardactivator.model.SimCard;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimCardActivationController {
    private final SimCardHandler simCardHandler;

    @PostMapping(value = "/activate")
    public void handleRequest(@RequestBody SimCard simCard) {
        var actuationResult = simCardHandler.actuate(simCard);
        System.out.println(actuationResult.getSuccess());
    }

}
