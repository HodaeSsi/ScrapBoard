package com.spring.hodaessi.scrapboard.tag;

import com.spring.hodaessi.scrapboard.scrap.domain.Scrap;
import com.spring.hodaessi.scrapboard.board.Board;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Tag {

    @Id @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board affiliatedBoard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scrap_id")
    private Scrap affiliatedScrap;

    private String name;
}
