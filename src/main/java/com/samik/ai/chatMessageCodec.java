package com.samik.ai;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import dev.langchain4j.data.message.ChatMessage;
import io.quarkiverse.langchain4j.QuarkusJsonCodecFactory;
import io.quarkus.redis.datasource.codecs.Codec;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class chatMessageCodec implements Codec{
     private static final TypeReference<List<ChatMessage>> MESSAGE_LIST_TYPE = new TypeReference<>() {
        };

    @Override
    public boolean canHandle(Type clazz) {
        return MESSAGE_LIST_TYPE.getType().equals(clazz);
    }

    @Override
    public byte[] encode(Object item) {
       try {
            return QuarkusJsonCodecFactory.ObjectMapperHolder.MAPPER.writeValueAsString(item).getBytes();
    } catch (JsonProcessingException e) {
        throw new RuntimeException(e);
    }
    }

    @Override
    public Object decode(byte[] item) {
        if (item == null) {
                return Collections.emptyList();
            }
            try {
                return QuarkusJsonCodecFactory.ObjectMapperHolder.MAPPER.readValue(item, MESSAGE_LIST_TYPE);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    
}