package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.MessageMapper;
import com.udacity.jwdnd.spring_security_basics.model.ChatForm;
import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {
    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating a MessageService bean");
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageMapper.addMessage(chatMessage);
    }

    public List<ChatMessage> getChatMessages() {
        return messageMapper.getAllMessages();
    }
}
