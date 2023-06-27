package com.regyl.passentrysystem.service;

import com.regyl.passentrysystem.api.CsvBuilder;
import com.regyl.passentrysystem.api.StatisticService;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.model.servicetypes.CsvConverter;
import com.regyl.passentrysystem.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticsRepository statisticsRepository;
    private final CsvBuilder csvBuilder;

    @Override
    public byte[] downloadFullStatistics() {
        return csvBuilder.convertToCsv(CsvConverter.STUDENT, getAllStudents()).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public List<Student> getAllStudents() {
        return statisticsRepository.getAllStudents();
    }
}
