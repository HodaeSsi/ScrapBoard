package com.spring.hodaessi.scrapboard.user.service;

import com.spring.hodaessi.scrapboard.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegisteredEventHandler {

    private final BoardService boardService;

    @EventListener
    public void makeUserBoard(UserRegisteredEvent event) {
        boardService.createUserBoard(event.getUser());
    }
}
