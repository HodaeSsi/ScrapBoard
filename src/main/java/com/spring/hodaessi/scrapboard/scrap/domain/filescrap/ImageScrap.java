package com.spring.hodaessi.scrapboard.scrap.domain.filescrap;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("IMAGE")
@Getter
public class ImageScrap extends FileScrap {

    private String thumbnailID;
}
