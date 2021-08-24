package com.spring.hodaessi.scrapboard.category;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category/new")
    public String createNewCategory(HttpServletRequest request,
                                    @ModelAttribute("categoryForm") CategoryForm categoryForm) {

        categoryService.create(categoryForm.getUpperBoardId(), categoryForm.getCategoryName());

        return "redirect:" + request.getHeader("Referer");
    }
}
