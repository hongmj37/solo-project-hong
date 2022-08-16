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
public class Type {
    @Id
    private Long TypeId;

    @Enumerated(value = EnumType.STRING)
    private Types type;

    public enum Types{
        도소매,
        의료,
        광고,
        정보통신,
        전자,
        식품
    }
}
