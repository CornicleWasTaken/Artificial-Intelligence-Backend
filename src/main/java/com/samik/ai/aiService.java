package com.samik.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface aiService {
    @SystemMessage("You are a Helpful bot designed for a User")

    
    public String chat(@UserMessage String message);
}
