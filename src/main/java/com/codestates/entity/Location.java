package com.codestates.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    private Long LocationId;

    @Enumerated(value = EnumType.STRING)
    private Area area;

    public enum Area {
        서울,
        경기,
        강원도,
        충청도,
        경상도,
        전라도,
        부산,
        울산,
        광주,
        제주
    }
}
