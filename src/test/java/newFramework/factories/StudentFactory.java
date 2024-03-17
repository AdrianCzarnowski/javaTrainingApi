package newFramework.factories;

import model.MockStudent;
import model.Student;

public class StudentFactory {
    public Student createDealutRegularStudent() {
        return new Student("Adam", "Marek", "Tomek", "01/01/2020");
    }

    public Student createCustomizeRegularStudent(String firstName, String middleName, String lastName, String dateOfBirth) {
        return Student.builder().date_of_birth(dateOfBirth).last_name(lastName).middle_name(middleName).first_name(firstName).build();
    }

    public MockStudent getRandomStudent(String firstName) {
        return new MockStudent(firstName);
    }
}
