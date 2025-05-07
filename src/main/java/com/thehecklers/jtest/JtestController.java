package com.thehecklers.jtest;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JtestController {
    private final ChatClient client;

    public JtestController(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @GetMapping
    public String testing123(@RequestParam(defaultValue = "Tell me a joke") String message) {
        return client.prompt()
                .user(message)
                .call()
                .content();
    }
}
