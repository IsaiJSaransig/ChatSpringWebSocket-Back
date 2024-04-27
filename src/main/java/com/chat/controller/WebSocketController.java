package com.chat.controller;

import com.chat.dto.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Message chat(@DestinationVariable String roomId, Message message) {
        System.out.println(message);
        return new Message(message.getMessage(), message.getUser());
    }
}