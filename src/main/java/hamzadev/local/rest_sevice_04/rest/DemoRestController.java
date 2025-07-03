package hamzadev.local.rest_sevice_04.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //add code for the "/hello" endpint
    @GetMapping("/hello")
    public String sayHello()
    {
        return "hello world";
    }
}
