package com.spring.hodaessi.scrapboard.board;

import com.spring.hodaessi.scrapboard.user.UserRepository;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) { em.persist(board); }

    public Board findByUser(User user) {
        try {
            return em.createQuery("select b from Board b where b.owner = :owner", Board.class)
                    .setParameter("owner", user)
                    .getSingleResult();
        } catch (Exception e) {
//            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public Board findOne(Long id) { return em.find(Board.class, id); }
}
