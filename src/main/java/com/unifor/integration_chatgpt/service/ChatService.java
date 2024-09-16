package com.unifor.integration_chatgpt.service;

import com.theokanning.openai.OpenAiHttpException;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import com.unifor.integration_chatgpt.model.ChatResult;
import com.unifor.integration_chatgpt.repository.ResponseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ChatService {

    @Value("${spring.ai.openai.api-key}")
    private String token;

    @Value("${spring.ai.openai.model}")
    private String model;

    @Autowired
    private ResponseRepository responseRepository;

    public ChatMessage sendPrompt(String prompt) {

        try {
            OpenAiService service = new OpenAiService(token);

            List<ChatMessage> messages = new ArrayList<>();
            ChatMessage systemMessage = new ChatMessage(ChatMessageRole.USER.value(), prompt);
            messages.add(systemMessage);

            ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                    .model(model)
                    .messages(messages)
                    .build();

            ChatCompletionResult chatCompletionResult = service.createChatCompletion(chatCompletionRequest);

            ChatResult chatResult = ChatResult.builder()
                    .object(chatCompletionResult.getObject())
                    .created(chatCompletionResult.getCreated())
                    .model(chatCompletionResult.getModel())
                    .message(chatCompletionResult.getChoices().get(0).getMessage().getContent())
                    .build();

            responseRepository.save(chatResult);

            return chatCompletionResult.getChoices().get(0).getMessage();
        } catch (OpenAiHttpException httpException) {
            log.error(httpException.getMessage());
        }
        return null;
    }
}
