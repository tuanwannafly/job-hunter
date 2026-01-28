package vn.hoidanit.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * Responds to HTTP GET requests at the application root with a greeting message.
     *
     * @return the plain-text greeting "Hello World from Spring Boot with tuan"
     */
    @GetMapping("/")
    public String index() {
        return "Hello World from Spring Boot with tuan";
    }
}