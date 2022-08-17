package com.codestates.soloproject.member.controller;

import com.codestates.soloproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity getMembers() {
        return new ResponseEntity<>(memberService.findMembers(), HttpStatus.OK);
    }

    @GetMapping("/add")
    public ResponseEntity getMember(@PathParam("location") String location,
                                    @PathParam("sector") String sector) {
        return new ResponseEntity<>(memberService.findMembersByQuery(location, sector), HttpStatus.OK);
    }
}