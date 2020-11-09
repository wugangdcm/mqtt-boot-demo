package com.wdcm.mqtt.service;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface MqttService {

    void publish(String topic, String message) throws MqttException;
}
