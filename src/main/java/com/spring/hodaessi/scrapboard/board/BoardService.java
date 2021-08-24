package com.spring.hodaessi.scrapboard.board;

import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long createUserBoard(User owner) {

        Board board = Board.createBoardWithOwner(owner);
        boardRepository.save(board);

        return board.getId();
    }
}
