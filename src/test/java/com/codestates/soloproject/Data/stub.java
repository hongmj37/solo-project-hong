package com.codestates.soloproject.Data;
import com.codestates.soloproject.company.CompanyType;
import com.codestates.soloproject.location.CompanyLocation;
import com.codestates.soloproject.member.entity.Member;

import java.util.ArrayList;
import java.util.List;

public class stub {
    private static List<CompanyLocation> companyLocations = new ArrayList<>(List.of(
            new CompanyLocation(1L, CompanyLocation.Locations.서울),
            new CompanyLocation(2L, CompanyLocation.Locations.경기),
            new CompanyLocation(3L, CompanyLocation.Locations.부산),
            new CompanyLocation(4L, CompanyLocation.Locations.광주),
            new CompanyLocation(5L, CompanyLocation.Locations.울산),
            new CompanyLocation(6L, CompanyLocation.Locations.강원도),
            new CompanyLocation(7L, CompanyLocation.Locations.전라도),
            new CompanyLocation(9L, CompanyLocation.Locations.경상도),
            new CompanyLocation(9L, CompanyLocation.Locations.제주도),
            new CompanyLocation(10L, CompanyLocation.Locations.인천)
    ));

    private static List<CompanyType> companyTypes = new ArrayList<>(List.of(
            new CompanyType(1L, CompanyType.types.정보통신),
            new CompanyType(2L, CompanyType.types.도소매),
            new CompanyType(3L, CompanyType.types.전자공학),
            new CompanyType(4L, CompanyType.types.의료),
            new CompanyType(5L, CompanyType.types.건축),
            new CompanyType(6L, CompanyType.types.광고)
    ));

    public static Member getMember() {
        return new Member(1L,
                "강감찬",
                "HappyComp",
                "kang123",
                Member.Sex.m,
                companyTypes.get(0),
                companyLocations.get(0));
    }

    public static List<Member> getMembers() {
        return new ArrayList<>(List.of(
                getMember(),
                new Member(2L, "홍길동", "ABC Company", "hong123", Member.Sex.w, companyTypes.get(1), companyLocations.get(2)),
                new Member(3L, "이길동", "BYC", "lee123", Member.Sex.m, companyTypes.get(3), companyLocations.get(1))
        ));
    }

    public static List<Member> getMembersByLocationAndSector() {
        return new ArrayList<>(List.of(
                getMember()
        ));
    }
}