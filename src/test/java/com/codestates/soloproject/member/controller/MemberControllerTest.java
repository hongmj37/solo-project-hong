package com.codestates.soloproject.member.controller;


import com.codestates.soloproject.Data.stub;
import com.codestates.soloproject.member.entity.Member;
import com.codestates.soloproject.member.service.MemberService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static com.codestates.soloproject.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.soloproject.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private Gson gson;

    @Test
    @DisplayName("모든 회원 조회")
    void getMembers() throws Exception {
        // given
        List<Member> members = stub.getMembers();
        given(memberService.findMembers()).willReturn(members);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "get-members",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("회원 성별"),
                                        fieldWithPath("[].company_name").type(JsonFieldType.STRING).description("회원 회사명"),
                                        fieldWithPath("[].company_type").type(JsonFieldType.OBJECT).description("회원 회사 업종 데이터"),
                                        fieldWithPath("[].company_type.companyTypeId").type(JsonFieldType.NUMBER).description("회원 회사 업종 식별자"),
                                        fieldWithPath("[].company_type.type").type(JsonFieldType.STRING).description("회원 회사 업종 종류"),
                                        fieldWithPath("[].company_location").type(JsonFieldType.OBJECT).description("회원 회사 위치 데이터"),
                                        fieldWithPath("[].company_location.companyLocationId").type(JsonFieldType.NUMBER).description("회원 회사 위치 식별자"),
                                        fieldWithPath("[].company_location.location").type(JsonFieldType.STRING).description("회원 회사 위치")
                                )
                        )
                ));
    }

    @Test
    @DisplayName("특정 회원 조회")
    void getMember() throws Exception {
        // given
        String location = "서울";
        String sector = "정보통신";
        List<Member> members = stub.getMembersByLocationAndSector();
        given(memberService.findMembersByQuery(Mockito.anyString(), Mockito.anyString())).willReturn(members);

        // when
        ResultActions actions = mockMvc.perform(
                get("/v1/members/add?location={location}&sector={sector}", location, sector)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        actions
                .andExpect(status().isOk())
                .andDo(document(
                        "get-members-by-location-sector",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                parameterWithName("location").description("위치"),
                                parameterWithName("sector").description("업종")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("[].id").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("[].name").type(JsonFieldType.STRING).description("회원 이름"),
                                        fieldWithPath("[].sex").type(JsonFieldType.STRING).description("회원 성별"),
                                        fieldWithPath("[].company_name").type(JsonFieldType.STRING).description("회원 회사명"),
                                        fieldWithPath("[].company_type").type(JsonFieldType.OBJECT).description("회원 회사 업종 데이터"),
                                        fieldWithPath("[].company_type.companyTypeId").type(JsonFieldType.NUMBER).description("회원 회사 업종 식별자"),
                                        fieldWithPath("[].company_type.type").type(JsonFieldType.STRING).description("회원 회사 업종 종류"),
                                        fieldWithPath("[].company_location").type(JsonFieldType.OBJECT).description("회원 회사 위치 데이터"),
                                        fieldWithPath("[].company_location.companyLocationId").type(JsonFieldType.NUMBER).description("회원 회사 위치 식별자"),
                                        fieldWithPath("[].company_location.location").type(JsonFieldType.STRING).description("회원 회사 위치")
                                )
                        )
                ));
    }
}