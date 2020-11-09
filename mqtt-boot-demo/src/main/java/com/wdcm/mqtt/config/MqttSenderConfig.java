//package com.wdcm.mqtt.config;
//
//import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
//import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class MqttSenderConfig extends MqttConfig {
//
//    @Bean
//    public DefaultMqttPahoClientFactory mqttClientFactory() {
//        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
//        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
//        mqttConnectOptions.setCleanSession(false);
//        mqttConnectOptions.setUserName(username);
//        mqttConnectOptions.setPassword(password.toCharArray());
//        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
//        mqttConnectOptions.setConnectionTimeout(completionTimeout);
//        mqttConnectOptions.setKeepAliveInterval(keepAlive);
//        factory.setConnectionOptions(mqttConnectOptions);
//        return factory;
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "mqttOutboundChannel")
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId, mqttClientFactory());
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic(defaultTopic);
//        return messageHandler;
//    }
//
//    @Bean
//    public MessageChannel mqttOutboundChannel() {
//        return new DirectChannel();
//    }
//
//
//}
