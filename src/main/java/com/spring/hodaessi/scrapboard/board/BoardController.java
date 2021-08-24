package com.spring.hodaessi.scrapboard.board;

import com.spring.hodaessi.scrapboard.category.CategoryForm;
import com.spring.hodaessi.scrapboard.category.CategoryRepository;
import com.spring.hodaessi.scrapboard.scrap.ScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final ScrapRepository scrapRepository;

//        <a href="#" th:href="@{/board/{boardId} (boardId=${userBoardId})}" role="button">개인 게시판</a>
    @GetMapping(value = "/board/{boardId}")
    public String loadBoard(@PathVariable("boardId") Long boardId, Model model) {

        model.addAttribute("board", boardRepository.findOne(boardId));

        model.addAttribute("categories", categoryRepository.findListByBoard(boardId));
        //이거 맞아??? 진짜 board컨트롤러에서 category고 scrap이고 다 참조해야돼???
        model.addAttribute("categoryForm", new CategoryForm(boardId));

        model.addAttribute("scraps", scrapRepository.findListByBoard(boardId));

        return "board";
    }
}
