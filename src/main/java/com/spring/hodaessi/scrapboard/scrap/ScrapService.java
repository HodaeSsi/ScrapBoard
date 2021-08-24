package com.spring.hodaessi.scrapboard.scrap;

import com.spring.hodaessi.scrapboard.board.BoardRepository;
import com.spring.hodaessi.scrapboard.category.Category;
import com.spring.hodaessi.scrapboard.category.CategoryRepository;
import com.spring.hodaessi.scrapboard.scrap.domain.Scrap;
import com.spring.hodaessi.scrapboard.scrap.domain.ScrapCreateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ScrapService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final ScrapRepository scrapRepository;

    public Long create(ScrapCreateForm form) throws FailCreateScrapException {
        //service > 외부 도메인(카테고리 및 게시판)에 대한 null 체크 & 생성 요청
        //Scrap.simpleFactory > 외부 도메인이외에 대한 null 체크 & 생성

        Category category = null;
        if(form.getAffiliatedCategoryId() != null) {
            category = categoryRepository.findOne(form.getAffiliatedCategoryId());
        }

        Scrap scrap = Scrap.simpleFactory(form, boardRepository.findOne(form.getAffiliatedBoardId()),
                category);

        scrapRepository.save(scrap);

        return scrap.getId();
    }

//    public List<Scrap> >>> "jpa페이징!!!"
}
