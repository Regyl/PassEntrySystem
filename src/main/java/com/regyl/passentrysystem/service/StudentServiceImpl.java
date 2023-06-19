package com.regyl.passentrysystem.service;

import com.regyl.passentrysystem.api.StudentService;
import com.regyl.passentrysystem.exception.PassEntrySystemException;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student assertStudentExists(UUID studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new PassEntrySystemException(String.format(
                        "Пользователь с идентификатором %s не найден", studentId)));
    }

    @Override
    public void addPhoto(UUID studentId, MultipartFile file) {
        Student s = assertStudentExists(studentId);
        try {
            s.setPhoto(file.getBytes());
            studentRepository.save(s);
        } catch (IOException e) {
            throw new PassEntrySystemException(e.getMessage());
        }
    }
}
