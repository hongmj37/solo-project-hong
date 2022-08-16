package com.codestates.entity;

import lombok.*;
import org.springframework.data.domain.Auditable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pw;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Gender sex;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private Type company_type;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location company_location;


    public enum Gender {
        m, w
    }
}
