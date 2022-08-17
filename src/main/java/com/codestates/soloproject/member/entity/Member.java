package com.codestates.soloproject.member.entity;

import com.codestates.soloproject.company.CompanyType;
import com.codestates.soloproject.location.CompanyLocation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private long id;

    private String name;

    private String company_name;
    @JsonIgnore
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "COMPANY_TYPE_ID")
    private CompanyType company_type;
    @ManyToOne
    @JoinColumn(name = "COMPANY_LOCATION_ID")
    private CompanyLocation company_location;

    public enum Sex {
        m, w
    }


}