package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HackerNewsController {

    @GetMapping("/posts/{page}")
    public Post[] getPosts(@PathVariable int page) {
        return Page.get(page);
    }
}
