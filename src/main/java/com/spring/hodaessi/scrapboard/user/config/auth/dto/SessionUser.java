package com.spring.hodaessi.scrapboard.user.config.auth.dto;

import com.spring.hodaessi.scrapboard.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

//    private static final long serialVersionUID = 1L;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
