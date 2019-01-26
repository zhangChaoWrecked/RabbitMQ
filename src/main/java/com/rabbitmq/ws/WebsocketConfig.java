package com.rabbitmq.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author ZhangChao
 * @date 2019.01.25  16:11
 */
@EnableWebSocket
@Configuration
@Component
public class WebsocketConfig implements WebSocketConfigurer {
    @Autowired
    WebsocketHandler websocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(websocketHandler,"/wrecked").setAllowedOrigins("*");
    }
}
