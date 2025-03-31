package com.samik.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAiService
@ApplicationScoped
public interface aiService {
    @SystemMessage("You are a Helpful bot designed for a User")

    
    public String chat(@MemoryId long id, @UserMessage String message);
}
