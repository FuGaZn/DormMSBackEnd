package com.dorm.utils.mq;

import com.dorm.utils.vo.SelectForm;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MqListener {

    @RabbitListener(queues = "topic.a")
    public void listen(String formMsg) {
        Gson gson = new Gson();
        SelectForm form = gson.fromJson(formMsg, SelectForm.class);
        System.out.println(form);
    }
}
