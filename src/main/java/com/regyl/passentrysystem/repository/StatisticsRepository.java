package com.regyl.passentrysystem.repository;

import com.regyl.passentrysystem.model.AbstractEntity;
import com.regyl.passentrysystem.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository with huge queries.
 * <p>
 * Extending {@link AbstractRepository} just a crutch, but there is no another way.
 */
@Repository
public interface StatisticsRepository extends AbstractRepository<AbstractEntity> {


    @Query("select s from Student s left join VisitRecord v on s.id = v.student.id order by s.studentGroup.number desc")
    List<Student> getAllStudents();
}
