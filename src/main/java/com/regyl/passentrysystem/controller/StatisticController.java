package com.regyl.passentrysystem.controller;

import com.regyl.passentrysystem.api.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/table")
    public ModelAndView getFullPagedStatistics() {
        ModelAndView mav = new ModelAndView("statistics-table");
        var attributes = mav.getModel();
        attributes.put("entities", statisticService.getAllStudents());
        return mav;
    }

    @ResponseBody
    @GetMapping(value = "/download", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] download() {
        return statisticService.downloadFullStatistics();
    }
}
