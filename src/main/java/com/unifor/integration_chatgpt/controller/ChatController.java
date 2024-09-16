package com.unifor.integration_chatgpt.controller;

import com.theokanning.openai.completion.chat.ChatMessage;
import com.unifor.integration_chatgpt.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<String> sendPrompt(@RequestBody String prompt) {
        ChatMessage response = chatService.sendPrompt(prompt);
        return ResponseEntity.ok(response.getContent());
    }
}
