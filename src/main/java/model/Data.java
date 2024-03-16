package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String date_of_birth;
}
