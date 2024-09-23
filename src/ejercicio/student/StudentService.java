package ejercicio.student;
import ejercicio.course.Course;
import ejercicio.course.CourseNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;

public class StudentService
{
   private HashMap<String, Course> courseList = new HashMap<>();

   private HashMap<String, Student> students = new HashMap<>();

   private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService()
    {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws StudentNotFoundException , CourseNotFoundException {
        Course course = courseList.get( courseName );
        
        if (!students.containsKey(studentID)) {
            throw new StudentNotFoundException("Id: " + studentID +" Not Found");
        }else  if (!courseList.containsKey(courseName)) {
        	throw new CourseNotFoundException("Course: " + courseName +" Not Found");	
        }else if (!coursesEnrolledByStudents.containsKey( studentID )){
        	coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
            coursesEnrolledByStudents.get( studentID ).add( course );
            System.out.println("You have successfully enrolled Id:" + studentID);
            

}
    public void unEnrollStudents( String courseName, String studentID ) throws StudentNotFoundException, CourseNotFoundException
    {
        Course course = courseList.get( courseName );
        if (!courseList.containsKey(courseName)) {
        	throw new CourseNotFoundException("Course: " + courseName +" Not Found");
        }else  if (!coursesEnrolledByStudents.containsKey(studentID)) {
        	throw new CourseNotFoundException("Id: " + studentID +" Not Found");
        }else if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
            System.out.println("You have successfully unenrolled Id:" + studentID);
        }
    }

    public void showEnrolledStudents(String courseId){
    	Course course = courseList.get(courseId);
        if (course == null) {
        	System.out.println("Course Not Found ");
			
		}else {
	        for (String studentID : coursesEnrolledByStudents.keySet()) {
				Student student = students.get(studentID);
				 System.out.println("Course: " +courseId  + " ID: " + studentID + ", Name: " + student.getName());
	        }
   
    }
    }
    public void showAllCourses(){
       for (String key : courseList.keySet()) { 
    	   System.out.println(courseList.get(key));
		
	}
    }
    
    public void addstudent(String string, Student student) {
    	students.put(string, student);
    	
    }
	
}