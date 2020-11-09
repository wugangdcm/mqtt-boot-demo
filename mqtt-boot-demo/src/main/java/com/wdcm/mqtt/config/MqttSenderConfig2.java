package com.wdcm.mqtt.config;

import com.wdcm.mqtt.callback.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class MqttSenderConfig2 extends MqttConfig {

    @Bean
    public MqttClient mqttClient() {
        try {
            MqttClient client = new MqttClient(hostUrl, clientId, new MemoryPersistence());
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setCleanSession(false);
            mqttConnectOptions.setUserName(username);
            mqttConnectOptions.setPassword(password.toCharArray());
            mqttConnectOptions.setServerURIs(new String[]{hostUrl});
            mqttConnectOptions.setConnectionTimeout(completionTimeout);
            mqttConnectOptions.setKeepAliveInterval(keepAlive);
            client.setCallback(new PushCallback());
            client.connect(mqttConnectOptions);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
