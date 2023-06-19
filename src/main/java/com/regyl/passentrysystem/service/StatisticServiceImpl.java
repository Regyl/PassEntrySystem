package com.regyl.passentrysystem.service;

import com.regyl.passentrysystem.api.StatisticService;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final StatisticsRepository statisticsRepository;

    @Override
    public byte[] downloadFullStatistics() {
        return new byte[0];
    }

    @Override
    public List<Student> getPagedStatistics() {
        return statisticsRepository.getPagedStatistics();
    }
}
