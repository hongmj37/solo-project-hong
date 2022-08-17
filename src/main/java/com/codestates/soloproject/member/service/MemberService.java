package com.codestates.soloproject.member.service;

import com.codestates.soloproject.member.entity.Member;
import com.codestates.soloproject.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public List<Member> findMembersByQuery(String location, String sector) {
        return memberRepository.findAllByLocationAndSector(location, sector);
    }
}