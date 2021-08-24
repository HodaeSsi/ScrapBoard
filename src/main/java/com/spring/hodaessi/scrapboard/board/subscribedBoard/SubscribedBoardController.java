package com.spring.hodaessi.scrapboard.board.subscribedBoard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SubscribedBoardController {

    @PostMapping("/subScribedBoard/subscribeBoard")
    public String subscribeBoard(HttpServletRequest request,
                                 @RequestParam("userId") Long subscriberId,
                                 @RequestParam("boardId") Long boardId) {

        //service.subscribe

        String referer = request.getHeader("Referer");

        return "redirect:" + referer;
    }
}
