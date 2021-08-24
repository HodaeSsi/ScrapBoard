package com.spring.hodaessi.scrapboard.user;

import com.spring.hodaessi.scrapboard.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

//public interface UserRepository extends JpaRepository<User, Long> {
//
//    Optional<User> findByEmail(String email);
//}

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) { em. persist(user); }

    public User findByEmail(String email) {
        try {
            return em.createQuery("select m from User m where m.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
