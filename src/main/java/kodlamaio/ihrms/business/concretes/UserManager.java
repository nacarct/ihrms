package kodlamaio.ihrms.business.concretes;

import kodlamaio.ihrms.business.abstracts.UserService;
import kodlamaio.ihrms.dataAccess.abstracts.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }
}
