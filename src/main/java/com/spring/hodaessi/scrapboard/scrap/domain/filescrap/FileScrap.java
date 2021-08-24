package com.spring.hodaessi.scrapboard.scrap.domain.filescrap;

import com.spring.hodaessi.scrapboard.scrap.domain.Scrap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class FileScrap extends Scrap {

    private String fileID;
}
