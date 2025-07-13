package com.lumiday.springboot.core.controller;

import com.lumiday.springboot.core.controller.dto.PersonBasicInfoResponse;
import com.lumiday.springboot.core.service.PersonInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invitations")
public class PersonInfoController {

    private final PersonInfoService personInfoService;

    @GetMapping("/{invitationId}/person-info")
    public ResponseEntity<PersonBasicInfoResponse> getPersonInfo(@PathVariable String invitationId) {
        PersonBasicInfoResponse personInfoResponses = personInfoService.getPersonInfoListByInvitationId(invitationId);
        return ResponseEntity.ok(personInfoResponses);
    }
}
