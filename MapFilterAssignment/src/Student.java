import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Devni", 78));
        studentList.add(new Student("Manuri", 84));
        studentList.add(new Student("Kasun", 90));
        studentList.add(new Student("Dilki", 56));
        studentList.add(new Student("Ramesh", 62));

        return studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
