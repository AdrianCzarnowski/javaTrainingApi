package tests;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@DisplayName("Student service is up and running")
public class NestedJunitTrainingTest {

    @Test
    @DisplayName("When student object is created")
    void createdNewStudent() {
        System.out.println("Student object is created");
    }


    @Nested
    @Order(1)
    @DisplayName("I can perform")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class GetStudentTest {
        @Order(1)
        @Test
        @DisplayName("Get student details")
        void getStudentId() {
            System.out.println("Student id verify");
        }

        @Order(2)
        @Test
        @DisplayName("Update student details")
        void getUpdatedStudentID() {
            System.out.println("Student is Updated");
        }
    }

    @Nested
    @Order(2)
    @DisplayName("I can persist data")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class PersistDataTest {
        @Order(1)
        @Test
        @DisplayName("In Postgres DB")
        void saveStudentToPostgres() {
            System.out.println("Student is persisted in Postgres");
        }

        @Order(2)
        @Test
        @DisplayName("In Kafka")
        void saveStudentInKafka() {
            System.out.println("Student is persisted in Kafka");
        }
    }

    @Nested
    @Order(3)
    @DisplayName("I can run University service")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class UniversityServiceTest {
        @Order(1)
        @Test
        @DisplayName("And present data in university dashboard")
        void shouldPresentStudentInDashboard() {
            System.out.println("Student is presented in dashboard");
        }

        @Order(2)
        @Test
        @DisplayName("and send object to downstream")
        void shouldSendObjectToDownstream() {
            System.out.println("Student has been send to downstream");
        }

        @Order(3)
        @Test
        @DisplayName("and deleted student object")
        void shouldDeleteStudentObject() {
            System.out.println("Student has been deleted");
        }
    }
}
