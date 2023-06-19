package com.regyl.passentrysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EqualsAndHashCode(callSuper = true)
public class Student extends AbstractEntity {

    private FullName fullName;

    @ManyToOne(optional = false)
    private StudentGroup studentGroup;

    @OneToMany(mappedBy = "student")
    private List<VisitRecord> visits;

    @Column
    private byte[] photo;

    public String getLFM() {
        return this.fullName != null ? fullName.getFullName() : "Empty";
    }

    public Optional<VisitRecord> getTodayVisit() {
        return visits == null ? Optional.empty() : visits.stream()
                .filter(item -> item.getVisitDateTime().toLocalDate().equals(LocalDate.now(Clock.systemUTC())))
                .findFirst();
    }
}
