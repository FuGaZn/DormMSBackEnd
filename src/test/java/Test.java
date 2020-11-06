import com.dorm.dao.UserDao;
import com.dorm.entity.RoleUser;
import com.dorm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class Test {
    @Autowired
    UserDao userDao;

    @org.junit.Test
    public void test(){
        User user = userDao.findByUid(7);
        Set<RoleUser> roleUsers = user.getRoleUsers();
        System.out.println(roleUsers==null);
        System.out.println(roleUsers.size());

        for (RoleUser r: roleUsers)
            System.out.println(r);
    }
}
