package com.regyl.passentrysystem.service;

import com.regyl.passentrysystem.api.StudentService;
import com.regyl.passentrysystem.api.VisitService;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.model.VisitRecord;
import com.regyl.passentrysystem.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final StudentService studentService;

    @Override
    public VisitRecord captureVisit(UUID studentId) {
        Student student = studentService.assertStudentExists(studentId);

        VisitRecord record = VisitRecord.builder()
                .student(student)
                .visitDateTime(OffsetDateTime.now(Clock.systemUTC()))
                .build();
        visitRepository.save(record);

        return record;
    }
}
