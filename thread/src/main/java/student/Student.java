package student;

public class Student {
    private Integer student_id;
    private String student_name ;
    private Integer student_age;
    private String student_tel ;

    public Student(){

    }
    public Student(Integer student_id, String student_name, Integer student_age, String student_tel) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_age = student_age;
        this.student_tel = student_tel;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public String getStudent_tel() {
        return student_tel;
    }

    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_age=" + student_age +
                ", student_tel='" + student_tel + '\'' +
                '}';
    }
}
