package com.regyl.passentrysystem.controller;

import com.regyl.passentrysystem.api.VisitService;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.model.VisitRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/capture/{studentId}")
    public ModelAndView captureVisit(@PathVariable("studentId") UUID studentId) {
        VisitRecord visit = visitService.captureVisit(studentId);
        ModelAndView mav = new ModelAndView("student-after-visit-view");
        var attributes = mav.getModel();
        Student s = visit.getStudent();
        attributes.put("student", s);
        attributes.put("photo", Base64.getMimeEncoder().encodeToString(s.getPhoto()));
        return mav;
    }
}
