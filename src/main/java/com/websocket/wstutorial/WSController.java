package com.websocket.wstutorial;

import com.websocket.wstutorial.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WSController {

    @Autowired
    private WSService service;

    @PostMapping("/send-global-message")
    public void sendGlobalMessage(@RequestBody final Message message) {
        service.notifyGlobalFrontend(message.getMessageContent(),message.getTopic());
    }
    
    @PostMapping("/send-user-message")
    public void sendUserMessage(@RequestBody final Message message) {
        service.notifyUserFrontend(message.getMessageContent(),message.getTopic());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@PathVariable final String id,
                                   @RequestBody final Message message) {
        service.notifyUser(id, message.getMessageContent());
    }
}