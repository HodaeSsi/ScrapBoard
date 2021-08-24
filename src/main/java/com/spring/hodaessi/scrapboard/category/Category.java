package com.spring.hodaessi.scrapboard.category;

import com.spring.hodaessi.scrapboard.board.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board affiliatedBoard;

    public static Category create(Board requestBoard, String name) {
        Category category = new Category();
        category.name = name;
        category.affiliatedBoard = requestBoard;

        return category;
    }
}
