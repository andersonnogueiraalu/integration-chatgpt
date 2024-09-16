package com.unifor.integration_chatgpt.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class ChatResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String object;
    long created;
    String model;
    String message;
}
