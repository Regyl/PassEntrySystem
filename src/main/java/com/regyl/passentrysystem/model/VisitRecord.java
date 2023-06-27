package com.regyl.passentrysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visit")
@EqualsAndHashCode(callSuper = true)
public class VisitRecord extends AbstractEntity {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:SS");

    /**
     * idk.
     * <a href="https://stackoverflow.com/questions/31158509/how-to-generate-custom-id-using-hibernate-while-it-must-be-primary-key-of-table">StackOverflow</a>
     */
/*    @GenericGenerator(name = "", strategy = "")
    @Id
    @GeneratedValue(generator = "FIXME", strategy = "com.regyl.passentrysystem.service.VisitIdGenerator") //FIXME custom id generator
    private String id;*/

    @NotNull
    @Column(nullable = false)
    private OffsetDateTime visitDateTime;

    @ManyToOne(optional = false)
    private Student student;

    public String getFormattedVisitTime() {
        return FORMATTER.format(visitDateTime);
    }
}
