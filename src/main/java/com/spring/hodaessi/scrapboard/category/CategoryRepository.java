package com.spring.hodaessi.scrapboard.category;

import com.spring.hodaessi.scrapboard.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    private final BoardRepository boardRepository;

    public void save(Category category) { em.persist(category); }

    public List<Category> findListByBoard(Long boardId) {
        return em.createQuery("select c from Category c where c.affiliatedBoard = :board", Category.class)
                .setParameter("board", boardRepository.findOne(boardId))
                //꼭 board엔티티로? boardId로 조회못하나???
                .getResultList();
    }

    public Category findOne(Long id) {
        return em.find(Category.class, id);
    }
}
