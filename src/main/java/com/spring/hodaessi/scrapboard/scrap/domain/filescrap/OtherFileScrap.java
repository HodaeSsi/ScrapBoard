package com.spring.hodaessi.scrapboard.scrap.domain.filescrap;

import com.spring.hodaessi.scrapboard.scrap.domain.filescrap.FileScrap;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("OTHER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OtherFileScrap extends FileScrap {

}
