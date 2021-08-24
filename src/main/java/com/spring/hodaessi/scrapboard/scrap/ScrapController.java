package com.spring.hodaessi.scrapboard.scrap;

import com.spring.hodaessi.scrapboard.category.Category;
import com.spring.hodaessi.scrapboard.category.CategoryRepository;
import com.spring.hodaessi.scrapboard.scrap.domain.ScrapCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ScrapController {

    private final ScrapService scrapService;

    private final CategoryRepository categoryRepository;
    private final ScrapRepository scrapRepository;

    //board > scrapCreateForm
    @GetMapping("/{boardId}/scrap/new")
    public String sendScrapCreateForm(@PathVariable("boardId") Long boardId, Model model) {

        ScrapCreateForm scrapCreateForm = new ScrapCreateForm();
        scrapCreateForm.setAffiliatedBoardId(boardId);
        model.addAttribute("scrapCreateForm", scrapCreateForm);

        List<Category> categoriesInBoard = categoryRepository.findListByBoard(boardId);
        model.addAttribute("categoriesInBoard", categoriesInBoard);

        return "scrap/scrapCreateForm";
    }

    //scrapCreateForm > new Scrap
    @PostMapping("/scrap/new")
    public String createNewScrap(HttpServletRequest request,
                                 @ModelAttribute("scrapCreateForm") ScrapCreateForm scrapCreateForm) {
//        enum 타입을 알아서 매핑 해준다???(프론트에선 그냥 string으로 받아줄텐데???)

        try {
            scrapService.create(scrapCreateForm);
        } catch(FailCreateScrapException e) {
            //Exception 디자인 !!!(생성 실패 유형별로!!!)
            return "redirect:" + request.getHeader("Referer"); //에러 메세지 추가 !!!
        }

        return "redirect:/board/" + scrapCreateForm.getAffiliatedBoardId();
    }

    @GetMapping("/{boardId}/scrap/{scrapId}")
    public String loadScrap(@PathVariable("boardId") Long boardId,
                            @PathVariable("scrapId") Long scrapId, Model model) {

        model.addAttribute("boardId", boardId);
        model.addAttribute("scrap", scrapRepository.findOne(scrapId));

        return "scrap/scrap";
    }
}
