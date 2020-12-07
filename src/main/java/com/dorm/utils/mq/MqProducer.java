package com.dorm.utils.mq;

import com.dorm.utils.vo.SelectForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(SelectForm form) throws JsonProcessingException {
        Gson gson = new Gson();
        rabbitTemplate.convertAndSend("topic.e", "r",gson.toJson(form));
    }
}
