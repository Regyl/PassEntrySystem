package com.regyl.passentrysystem.controller;

import com.regyl.passentrysystem.api.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PutMapping(value = "/photo/{studentId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void idk(@PathVariable("studentId") UUID studentId, @RequestParam("photo") MultipartFile photo) {
        studentService.addPhoto(studentId, photo);
    }
}
