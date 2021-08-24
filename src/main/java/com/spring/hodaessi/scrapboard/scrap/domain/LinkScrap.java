package com.spring.hodaessi.scrapboard.scrap.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LINK")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LinkScrap extends Scrap {

    private String link;

    protected LinkScrap(String link) {
        this.link = link;
    }
}
