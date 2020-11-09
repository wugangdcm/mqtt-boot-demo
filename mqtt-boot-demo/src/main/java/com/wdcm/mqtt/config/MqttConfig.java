package com.wdcm.mqtt.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@IntegrationComponentScan
public class MqttConfig {
    @Value("${spring.mqtt.username}")
    String username;

    @Value("${spring.mqtt.password}")
    String password;

    @Value("${spring.mqtt.url}")
    String hostUrl;

    @Value("${spring.mqtt.client.id}")
    String clientId;

    @Value("${spring.mqtt.default.topic}")
    String defaultTopic;

    @Value("${spring.mqtt.completionTimeout}")
    int completionTimeout;   //连接超时

    @Value("${spring.mqtt.keepAlive}")
    int keepAlive;   //连接超时
}
