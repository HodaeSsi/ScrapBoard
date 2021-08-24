package com.spring.hodaessi.scrapboard.board;

import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    //String thumbnailID """file id(파일 종류) + 경로"""
    private String title;
    private static final String DEFAULT_SUFFIX = "의 게시판";

    private String summary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;
    //int visitNum;

    /**
     * 생성메서드
     */
    public static Board createBoardWithOwner(User owner) {
        Board board = new Board();

        board.title = owner.getName() + DEFAULT_SUFFIX;
        board.summary = "";

        board.owner = owner;

        return board;
    }
}
