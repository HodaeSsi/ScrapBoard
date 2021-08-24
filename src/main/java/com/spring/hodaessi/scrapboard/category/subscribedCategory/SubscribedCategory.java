package com.spring.hodaessi.scrapboard.category.subscribedCategory;

import com.spring.hodaessi.scrapboard.category.Category;
import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class SubscribedCategory {

    @Id @GeneratedValue
    @Column(name = "subscribedCategory_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User subscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category subscribedCategory;
}
