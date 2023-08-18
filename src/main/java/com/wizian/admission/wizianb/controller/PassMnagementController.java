package com.wizian.admission.wizianb.controller;

import com.wizian.admission.wizianb.dto.ToastUiResponseDto;
import com.wizian.admission.wizianb.service.PassManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PassMnagementController {

    private final PassManagementService passManagementService;

    // 최종 합격
    @GetMapping("/pass/listAll")
    public ResponseEntity<ToastUiResponseDto> passListAll(){
        ToastUiResponseDto passAllList = passManagementService.findAll();
        return ResponseEntity.ok(passAllList);
    }

    // 서류&면접 합격 사정 내용 출력
    @GetMapping("/pass/list")
    public ResponseEntity<ToastUiResponseDto> passList(@RequestParam("rcrtNo") String rcrtNo){
        ToastUiResponseDto passList = passManagementService.findByRcrtNo(rcrtNo);
        return ResponseEntity.ok(passList);
    }

}