package gr.ds.unipi.noda.api.core.springserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {


    @RequestMapping(value = "/hello", produces = "text/plain")
    public String sayHello() {
        return "hello";
    }

}
