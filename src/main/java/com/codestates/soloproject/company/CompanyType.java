package com.codestates.soloproject.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CompanyType {
    @Id
    private long companyTypeId;

    @Enumerated(value = EnumType.STRING)
    private types type;

    public enum types {
        정보통신,
        도소매,
        전자공학,
        의료,
        건축,
        광고
    }
}