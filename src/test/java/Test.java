import com.dorm.dao.UserDao;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import com.dorm.service.UserService;
import com.dorm.service.impl.UserServiceImpl;
import com.dorm.utils.MyMD5;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
public class Test {
    @Autowired
    UserServiceImpl userService;

    @org.junit.Test
    public void test(){
        userService.register(new User("admin","111111"));
    }
}
