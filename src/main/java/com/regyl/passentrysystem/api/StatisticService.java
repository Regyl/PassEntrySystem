package com.regyl.passentrysystem.api;

import com.regyl.passentrysystem.model.Student;

import java.util.List;

public interface StatisticService {

    List<Student> getPagedStatistics();

    byte[] downloadFullStatistics();
}
