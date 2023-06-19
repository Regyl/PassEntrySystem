package com.regyl.passentrysystem.api;

import com.regyl.passentrysystem.model.Student;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface StudentService {

    Student assertStudentExists(UUID studentId);

    void addPhoto(UUID studentId, MultipartFile file);
}
