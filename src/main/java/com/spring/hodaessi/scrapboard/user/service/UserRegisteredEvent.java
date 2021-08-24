package com.spring.hodaessi.scrapboard.user.service;

import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.Getter;

@Getter
public class UserRegisteredEvent {

    private User user;

    public UserRegisteredEvent(User user) {
        this.user = user;
    }
}
