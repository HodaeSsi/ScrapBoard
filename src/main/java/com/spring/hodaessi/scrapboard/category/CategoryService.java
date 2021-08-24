package com.spring.hodaessi.scrapboard.category;

import com.spring.hodaessi.scrapboard.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    public Long create(Long requestBoardId, String name) {

        Category category = Category.create(boardRepository.findOne(requestBoardId), name);
        categoryRepository.save(category);

        return category.getId();
    }
}
