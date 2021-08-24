package com.spring.hodaessi.scrapboard.category;

import lombok.*;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class CategoryForm {

    @NonNull
    private Long upperBoardId;

    private String categoryName;
}
