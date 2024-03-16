package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
