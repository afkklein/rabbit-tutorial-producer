package com.afkklein.rabbittutorialproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer collegeCompletedYear;
    private LocalDate bornAt;
    private Boolean active;
}
