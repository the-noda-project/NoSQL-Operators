package gr.ds.unipi.noda.api.core.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIConnectionMessage {

    @RequestMapping(value = "/connection-message", produces = "text/plain")
    public String connectionMessage() {
        return "Connected to NODA API";
    }

}
