package Testing.repositories;

import Testing.entity.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service
public class UserAccessServiceImpl {
    @PersistenceContext
    private EntityManager em;
//    @Autowired
//    private User user;

    public boolean authorizationUser(User user){
        TypedQuery<User> query = em.createQuery("Select u.login from User u where u.login = :login and u.password = :password", User.class);
        query.setParameter("login", user.getLogin());
        query.setParameter("password", user.getPassword());
        if (query.getSingleResult()!=null){
            return true;
        }
        return false;
    }

    public void registrationUser(User user) throws Exception {
        if(!new UserAccessServiceImpl().authorizationUser(user)){
            em.persist(user);
        } else throw new Exception("Find, created other user");
    }
}
