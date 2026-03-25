package com.chatbot.whatsapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebhookController {

    @PostMapping("/webhook")
    public Map<String, String> receiveMessage(@RequestBody Map<String, String> request) {

        String message = request.get("message");
        String reply;

        if (message == null) {
            reply = "Invalid message";
        } else {
            switch (message.toLowerCase()) {
                case "hi":
                    reply = "Hello";
                    break;
                case "i love you":
                    reply = "I love you more";
                    break;
                case "how are you?":
                    reply = "I'm good, thanks for asking!";
                    break;
                case "bye":
                    reply = "Goodbye";
                    break;
                default:
                    reply = "I don't understand";
            }
        }

        System.out.println("Incoming message: " + message);

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);

        return response;
    }
}
