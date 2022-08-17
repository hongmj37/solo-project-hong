package com.codestates.soloproject.location;

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
public class CompanyLocation {
    @Id
    private long companyLocationId;

    @Enumerated(value = EnumType.STRING)
    private Locations location;

    public enum Locations {
        서울,
        경기,
        부산,
        광주,
        울산,
        강원도,
        전라도,
        경상도,
        제주도,
        인천
    }
}