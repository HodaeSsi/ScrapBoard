package com.spring.hodaessi.scrapboard.scrap.domain;

import com.spring.hodaessi.scrapboard.scrap.domain.ScrapType;
import com.spring.hodaessi.scrapboard.tag.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ScrapCreateForm {

//    @NonNull //>> 그래서 뭔데 이 어노테이션 기능은(+Nullable)
//    NonNull, Nullable 어노테이션은 jpa기능으로 DDL작동시, 즉 "엔터티"를 대상으로 데이터베이스에 등록할 때 동작하는 어노테이션으로 보임
    private Long affiliatedBoardId;
    private Long affiliatedCategoryId;
    private List<Tag> tagList = new ArrayList<>();

//    @Enumerated >> Only JPA???
    private ScrapType scrapType;
    private String title;
    private String text;
    private String summary;
//    private Integer orderInBoard;
    //새 scrap의 order은 db에서, 기존 scrap의 order변경은 프론트에서???

    private String link;
//    private String fileID;
//    처음 만들때 받는게 아니라 파일서버에 저장하고 파일서버에서 id를 받는거일듯???
}
