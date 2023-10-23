package com.websocket.wstutorial;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config
			.setApplicationDestinationPrefixes("/app")
			.enableStompBrokerRelay("/topic")
			.setRelayHost("localhost")
			.setRelayPort(61613)
			.setClientLogin("guest")
			.setClientPasscode("guest");
	}

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setHandshakeHandler(new UserHandshakeHandler())
                .withSockJS();
    }
}
