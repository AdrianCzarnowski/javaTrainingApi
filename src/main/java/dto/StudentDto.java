package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    public String first_name;
    public String middle_name;
    public String last_name;
    public String date_of_birth;
    public int id;
}
