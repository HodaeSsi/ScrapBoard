package com.spring.hodaessi.scrapboard.comment;

import com.spring.hodaessi.scrapboard.scrap.domain.Scrap;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scrap_id")
    private Scrap affiliatedScrap;

    @OneToMany(mappedBy = "affiliatedComment")
    private List<Comment> nestedComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_comment_id")
    private Comment affiliatedComment;

    //created Date
    private String text;
}
