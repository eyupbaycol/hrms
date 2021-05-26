package kodlamaio.humanresources.business.concretes;

import kodlamaio.humanresources.business.abstracts.UserService;
import kodlamaio.humanresources.dataAccess.abstracts.UserDao;
import kodlamaio.humanresources.entities.concretes.User;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public void addUser(User user) {
        this.userDao.save(user);
    }
}
