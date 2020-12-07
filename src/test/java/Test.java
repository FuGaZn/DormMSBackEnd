import com.dorm.dao.DormDao;
import com.dorm.dao.UserDao;
import com.dorm.entity.Dorm;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.UserService;
import com.dorm.service.impl.DormServiceImpl;
import com.dorm.service.impl.UserServiceImpl;
import com.dorm.utils.MyMD5;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ComponentScan("com.dorm")
@MapperScan("com.dorm.dao")
public class Test {

    @Autowired
    DormDao dormDao;

    @org.junit.Test
    public void create13() {
        for (int i = 0; i < 25; i++) {
            Dorm dorm = new Dorm();
            dorm.setBuilding("13");
            String name = "E3";
            int floor = (new Random().nextInt(5) + 1);
            name += "" + floor;
            name += "" + (new Random().nextInt(5));
            name += "" + new Random().nextInt(10);
            dorm.setDormName(name);
            dorm.setEmptyBed(new Random().nextInt(5)+1);
            dorm.setGender(1);
            dorm.setFloor(floor);
            dorm.setTotalBed(dorm.getEmptyBed());
            dormDao.save(dorm);
        }
        // {"key":"","buildingID":"13","firstStudent":"2001210106","gender":1,"studentIDs":["2001210107","2001210108",]}
    }
}
