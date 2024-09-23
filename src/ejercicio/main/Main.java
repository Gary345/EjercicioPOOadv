package ejercicio.main;
import ejercicio.student.*;
import ejercicio.course.*;

public class Main {

    public static void main(String[] args) throws StudentNotFoundException , CourseNotFoundException {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
        studentService.addstudent( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.addstudent( "1040", new Student( "Ian", "1020", 28 ) );
        studentService.addstudent( "1050", new Student( "Elise", "1020", 26 ) );
        studentService.addstudent( "1020", new Student( "Santiago", "1020", 33 ) );
        studentService.enrollStudents( "Math", "1020" );
        studentService.enrollStudents( "Math", "1040" );
        try {
        	
            studentService.enrollStudents( "Spanish", "1030" );
            
			
		} catch (StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (CourseNotFoundException e2) {
			System.out.println(e2.getMessage());
		}
		
        
        studentService.showEnrolledStudents("Math");
        studentService.showAllCourses();
        try {
        studentService.unEnrollStudents("Math", "1020");
        } catch (StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        }catch (CourseNotFoundException e2) {
			System.out.println(e2.getMessage());
			
        }
    }
}