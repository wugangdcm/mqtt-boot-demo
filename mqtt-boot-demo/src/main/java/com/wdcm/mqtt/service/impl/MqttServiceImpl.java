package com.wdcm.mqtt.service.impl;

import com.wdcm.mqtt.service.MqttService;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttServiceImpl implements MqttService {
    @Autowired
    private MqttClient mqttClient;

    @Override
    public void publish(String topic, String message) throws MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setQos(2);
        mqttMessage.setRetained(true);
        mqttMessage.setPayload(message.getBytes());

        MqttTopic mqttTopic = mqttClient.getTopic(topic);
        MqttDeliveryToken token = mqttTopic.publish(mqttMessage);
//        token.waitForCompletion();
        System.out.println("message is published completely! " + token.isComplete());
    }

}
