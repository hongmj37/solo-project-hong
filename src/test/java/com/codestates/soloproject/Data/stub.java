package com.codestates.soloproject.Data;

import com.codestates.entity.Location;
import com.codestates.entity.Member;
import com.codestates.entity.Type;

import java.util.ArrayList;
import java.util.List;

public class stub {
    private static List<Location> companyLocation = new ArrayList<>(List.of(
            new Location(1L, Location.Area.서울),
            new Location(2L, Location.Area.경기),
            new Location(3L, Location.Area.강원도),
            new Location(4L, Location.Area.충청도),
            new Location(5L, Location.Area.경상도),
            new Location(6L, Location.Area.전라도),
            new Location(7L, Location.Area.부산),
            new Location(8L, Location.Area.울산),
            new Location(9L, Location.Area.광주),
            new Location(10L, Location.Area.제주),
    ));

    private static List<Type> companyType = new ArrayList<>(List.of(
            new Type(1L, Type.Types.도소매),
            new Type(2L, Type.Types.의료),
            new Type(3L, Type.Types.광고),
            new Type(4L, Type.Types.정보통신),
            new Type(5L, Type.Types.전자),
            new Type(6L, Type.Types.식품)
    ));

    public static Member getMember() {
        return new Member(
                1L,
                "hh12345",
                "홍길동",
                Member.Gender.m,
                "ABC Company",
                companyType.get(4),
                companyLocation.get(8));
    }

    public static List<Member> getMembers() {
        return new ArrayList<>(List.of(getMember(),
                new Member(2L, "kk12345","김개똥",Member.Gender.w, "FGH Company", companyType.get(3), companyLocation.get(2)),
                new Member(3L, "ll12345","이말숙",Member.Gender.w, "IJK Company", companyType.get(1), companyLocation.get(5))
                ));
    }

    public static List<Member> getMemberByLocationAndType() {
        return new ArrayList<>(List.of(getMember()));
    }
 }
