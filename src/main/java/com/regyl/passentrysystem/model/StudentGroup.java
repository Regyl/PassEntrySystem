package com.regyl.passentrysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_group")
@EqualsAndHashCode(callSuper = true)
public class StudentGroup extends AbstractEntity {

    @Column(name = "number")
    private int number;

    @OneToMany(mappedBy = "studentGroup")
    private List<Student> students;
}
