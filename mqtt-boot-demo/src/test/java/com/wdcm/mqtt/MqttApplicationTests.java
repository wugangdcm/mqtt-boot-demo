package com.wdcm.mqtt;

import com.wdcm.mqtt.mqttgateway.MqttGateway;
import com.wdcm.mqtt.service.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = MqttApplication.class)
@WebAppConfiguration
class MqttApplicationTests {
    @Autowired
    private MqttGateway mqttGateway;
    @Autowired
    private MqttService mqttService;

    @Test
    void contextLoads() {
//        mqttGateway.sendToMqtt("aaaaaaaaaaaaaaaaaaaa", "toclient/124");
        String topic = "toclient/124";
        String message = "aaaaa2222";
        try {
            mqttService.publish(topic, message);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

}
