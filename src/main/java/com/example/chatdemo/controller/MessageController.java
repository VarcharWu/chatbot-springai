package com.example.chatdemo.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @GetMapping("/chat")
    public String chat() {
        return ollamaChatModel.call("hello");
    }
}
