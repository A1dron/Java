package Testing.repositories;

import Testing.entity.User;
import Testing.enums.UserRole;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Service
public class UserAccessServiceImpl {
    @PersistenceContext
    private EntityManager em;

    public boolean authorizationUser(User user){
        TypedQuery<User> query = em.createQuery("Select u.login from User u where u.login = :login and u.password = :password", User.class);
        query.setParameter("login", user.getLogin());
        query.setParameter("password", user.getPassword());
        if (query.getSingleResult()!=null){
            return true;
        }
        return false;
    }

    public User registrationUser(User user) {
        if(authorizationUser(user)){
            em.persist(user);
            return user;
        } else throw new RuntimeException("Find, created other user");
    }

    @Transactional
    public void makeAdmin(User user)
    {
        user = em.find(User.class, user.getId());
        user.setRole(UserRole.ADMIN);
    }
}
