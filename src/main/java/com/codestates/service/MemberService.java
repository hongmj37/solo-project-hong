package com.codestates.service;

import com.codestates.entity.Member;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public List<Member> findMembersByAdd(String location, String type) {
        return memberRepository.findAllByLocationAndType(location, type);
    }
}


