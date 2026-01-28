package vn.hoidanit.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.todo.Entity.Todo;

@RestController
public class HelloController {
    /**
     * Responds to HTTP GET requests at the application root with a greeting message.
     *
     * @return the plain-text greeting "Hello World from Spring Boot with tuan"
     */
    @GetMapping("/")
    public ResponseEntity<String> index() {
        // return "Hello World from Spring Boot with tuan";
        return ResponseEntity.ok().body("Hello World ");
    }

    @GetMapping("/tuanit")
    public ResponseEntity<Todo> indexx() {
        Todo test = new Todo("tuan", true);
        return ResponseEntity.ok().body(test);
    }
}