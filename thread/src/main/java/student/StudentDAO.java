package student;

import java.util.Set;

public interface StudentDAO {
    public int addStudent(Student student);

    public int deleteStudent(String name);

    public int updateStudent(String name);

    public Student findStudent(String name);

    public Set<Student> findAll();
}
