package com.spring.hodaessi.scrapboard.board.subscribedBoard;

import com.spring.hodaessi.scrapboard.board.Board;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SubscribedBoard {

    @Id @GeneratedValue
    @Column(name = "subscribedBoard_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board subscribedBoard;
}
