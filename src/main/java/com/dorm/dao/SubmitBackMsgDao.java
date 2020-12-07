package com.dorm.dao;

import com.dorm.entity.SubmitBackMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubmitBackMsgDao extends JpaRepository<SubmitBackMsg, Long> {
    SubmitBackMsg findByStudentID(String studentID);

    //@Query("update SubmitBackMsg set code=#{msg.code}, message=#{msg.message} where studentID=#{msg.studentID}")
    //void update(SubmitBackMsg msg);
}
