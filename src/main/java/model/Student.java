package model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
