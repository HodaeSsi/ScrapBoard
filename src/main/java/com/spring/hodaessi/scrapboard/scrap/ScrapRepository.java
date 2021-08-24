package com.spring.hodaessi.scrapboard.scrap;

import com.spring.hodaessi.scrapboard.board.Board;
import com.spring.hodaessi.scrapboard.board.BoardRepository;
import com.spring.hodaessi.scrapboard.scrap.domain.Scrap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScrapRepository {

    private final EntityManager em;

    private final BoardRepository boardRepository;

    public void save(Scrap scrap) {
        em.persist(scrap);
    }

    public Scrap findOne(Long boardId) {
        return em.find(Scrap.class, boardId);
    }

    public List<Scrap> findListByBoard(Long boardId) {
        return em.createQuery("select s from Scrap s where s.affiliatedBoard = :board", Scrap.class)
                .setParameter("board", boardRepository.findOne(boardId))
                .getResultList();
    }

}
