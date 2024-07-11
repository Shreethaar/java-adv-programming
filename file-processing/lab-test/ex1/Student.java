public class Student {
    private int studentID;
    private String studentName;
    private int numCourses;
    private double gpa;
    

    public Student(int studentID, String studentName, int numCourses, double gpa) {
        this.studentID=studentID;
        this.studentName=studentName;
        this.numCourses=numCourses;
        this.gpa=gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID=studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName=studentName;
    }

    public int getNumCourses() {
        return numCourses;
    }

    public void setNumCourses(int numCourses) {
        this.numCourses=numCourses;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA() {
        this.gpa=gpa;
    }

    public String toString() {
        return "Student Name: " + studentName + "\nStudent ID: " + studentID + "\nNumber of Courses: " + numCourses + "\nGPA: " + gpa;
    }

}

