package com.unifor.integration_chatgpt.repository;

import com.unifor.integration_chatgpt.model.ChatResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<ChatResult, Long> {
}
