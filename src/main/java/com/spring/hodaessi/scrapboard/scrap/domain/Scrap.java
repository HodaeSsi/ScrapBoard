package com.spring.hodaessi.scrapboard.scrap.domain;

import com.spring.hodaessi.scrapboard.board.Board;
import com.spring.hodaessi.scrapboard.category.Category;
import com.spring.hodaessi.scrapboard.comment.Comment;
import com.spring.hodaessi.scrapboard.scrap.FailCreateScrapException;
import com.spring.hodaessi.scrapboard.scrap.domain.filescrap.ImageScrap;
import com.spring.hodaessi.scrapboard.tag.Tag;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class Scrap {

    @Id @GeneratedValue
    @Column(name = "scrap_id")
    private Long id;
    //notNull

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
//    @NotNull 써봐???
    private Board affiliatedBoard;
    //notNull

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
//    @Nullable 써봐???
    private Category affiliatedCategory;
    //nullable

    @OneToMany(mappedBy = "affiliatedScrap", cascade = CascadeType.ALL)
    private List<Tag> tagList = new ArrayList<>();
    //nullable

    @OneToMany(mappedBy = "affiliatedScrap", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
    //nullable

    @Enumerated(EnumType.STRING)
    private ScrapType type; //notNull
    private String title; //notNull
    private String text; //nullable
    private String summary; //nullable
    private Integer orderInBoard; //!!! jpa에 순서 관련 있는듯 !!!
    //viewNum
    //commentNum

    /**
     * 생성메서드
     */
    public static Scrap simpleFactory(ScrapCreateForm scrapCreateForm,
                                      Board affiliatedBoard, Category affiliatedCategory) {
//                                      List<Tag> tags) { 태그 나중에

        Scrap scrap;

        ScrapType scrapType = scrapCreateForm.getScrapType();
        if(scrapType == ScrapType.TEXT) {
            scrap = new TextScrap();
        } else if(scrapType == ScrapType.LINK) {
            scrap = new LinkScrap(scrapCreateForm.getLink()); //스크랩 유형에 따른 notNull변수들 !!!
//      } else if(scrapType == ScrapType.IMAGE) {
//            scrap = new ImageScrap();
//            scrap = new ImageScrap(String fileID);
//            파일서버 구성하고!!!
        } else {
            throw new FailCreateScrapException("create scrap was fail!");
        }

        scrap.affiliatedBoard = affiliatedBoard;
        scrap.affiliatedCategory = affiliatedCategory;

//        if(tags != null)
//            scrap.tagList = tags;

        scrap.type = scrapCreateForm.getScrapType();
        scrap.title = scrapCreateForm.getTitle();
        scrap.text = scrapCreateForm.getText();
        scrap.summary = scrapCreateForm.getSummary();

        return scrap;
    }
}
