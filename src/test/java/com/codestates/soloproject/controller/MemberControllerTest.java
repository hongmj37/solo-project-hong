package com.codestates.soloproject.controller;

import com.codestates.controller.MemberController;
import com.codestates.entity.Member;
import com.codestates.service.MemberService;
import com.codestates.soloproject.Data.stub;
import com.google.gson.Gson;
import org.h2.store.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.awt.*;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private Gson gson;

    @Test
    @DisplayName("모든 회원 조회하기")
    void getMembers() throws Exception {
        //given
        List<Member> members = stub.getMembers();
        given(memberService.findMembers()).willReturn(members);

        //when
        ResultActions actions = mockMvc.perform(
                get("/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        actions
                .andExpect(status())

    }
}
