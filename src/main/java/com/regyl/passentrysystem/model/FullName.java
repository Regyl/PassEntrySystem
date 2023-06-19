package com.regyl.passentrysystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FullName {

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    public String getFullName() {
        return Stream.of(lastName, firstName, middleName)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" "));
    }
}
