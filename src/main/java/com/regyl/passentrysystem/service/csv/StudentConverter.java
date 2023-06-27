package com.regyl.passentrysystem.service.csv;

import com.regyl.passentrysystem.api.CsvEntityConverter;
import com.regyl.passentrysystem.model.VisitRecord;
import com.regyl.passentrysystem.model.servicetypes.CsvConverter;
import com.regyl.passentrysystem.model.Student;
import com.regyl.passentrysystem.util.CsvUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentConverter implements CsvEntityConverter<Student> {

    public static final String DELIMITER = ",";

    private final CsvEntityConverter<VisitRecord> visitRecordCsvEntityConverter;

    @Override
    public CsvConverter getType() {
        return CsvConverter.STUDENT;
    }

    @Override
    public String getHeader() {
        return String.join(DELIMITER,  "Взвод", "ФИО");
    }

    @Override
    public String convert(Student obj) {

        String student = String.join(DELIMITER,
                CsvUtils.getOrDefault(obj.getStudentGroup().getNumber()),
                obj.getLFM());
        StringBuilder sb = new StringBuilder();
        for (VisitRecord visitRecord : obj.getVisits()) {
            sb.append(DELIMITER).append(visitRecordCsvEntityConverter.convert(visitRecord));
        }

        return student + sb.toString();
    }
}
