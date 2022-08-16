package com.codestates.controller;

import com.codestates.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import javax.websocket.server.PathParam;
import java.util.List;

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
                                    @PathParam("type") String type){
        return new ResponseEntity<>(memberService.findMembersByAdd(location, type), HttpStatus.OK);
    }
}