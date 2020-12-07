package com.dorm.utils.mq;

import com.dorm.service.StudentService;
import com.dorm.service.impl.StudentServiceImpl;
import com.dorm.utils.vo.SelectForm;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqConsumer {

    @Autowired
    StudentServiceImpl studentService;

    @RabbitListener(queues = "topic.a")
    public void listen(String formMsg) {
        Gson gson = new Gson();
        SelectForm form = gson.fromJson(formMsg, SelectForm.class);
        studentService.handleSelectForm(form.getBuildingID(),form.getGender(),form.getFirstStudent(),form.getStudentIDs());
    }
}
