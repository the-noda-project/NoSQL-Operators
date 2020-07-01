package gr.ds.unipi.noda.api.core.springserver.testJSON;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class testjson {

    @RequestMapping(value = "/testjson")
    public List<model> sayHelloMate() {
        return Arrays.asList(
                new model("454541542", "Nikos", "kous"),
                new model("98398989", "nikolas", "koutr"),
                new model("90909090909", "mplampla", "mplou")
        );
    }
}