package newFramework.test;

import dto.StudentDto;
import model.Student;
import newFramework.base.NewFrameworkTestBase;
import newFramework.client.ApiClient;
import newFramework.factories.StudentFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NewFrameworkStudentApiTest extends NewFrameworkTestBase {
    private final String baseUrl = "https://thetestingworldapi.com";
    private ApiClient api;
    private StudentFactory studentFactory;

    @BeforeEach
    public void setupClient() {
        api = createApiClient(baseUrl);
        studentFactory = new StudentFactory();
    }


    @Test
    public void shouldGetStudent() {
        //10093344 //10093375 //10093384
        assertThat(api.getRealStudent("10093384").execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void shouldCreateNewStudent() {
        Student requestedStudent = studentFactory.createDealutRegularStudent();
//        Student customStudent = studentFactory.createCustomizeRegularStudent("dfsd0", "erer","sdfsdf", "01/05/2022");
        StudentDto actualStudent = api.postRealStudent(requestedStudent).saveAsDto();
//        assertThat(actualStudent.getId()).isNotZero();
//        assertThat(actualStudent.getMiddle_name().length()).isNotZero();
        assertThat(actualStudent).usingRecursiveComparison()
                .ignoringFieldsOfTypes(Integer.class)
                .isEqualTo(requestedStudent);
//        assertThat(actualStudent).usingRecursiveComparison()
//                .ignoringFieldsOfTypes(Integer.class)
//                .isEqualTo(customStudent);
    }
}
