package student;

import java.util.Set;

/**
 * @author zhangyi
 */
public class StudentService {

    StudentDAO sd = new ConcreteStudentDao();

    public int add(Student student)
    {
        return this.sd.addStudent(student);
    }

    public int delete(String name)
    {
        return this.sd.deleteStudent(name);
    }

    public int update(String name)
    {
        return this.sd.updateStudent(name);
    }

    public Student find(String name)
    {
        return this.sd.findStudent(name);
    }

    public Set<Student> findAll()
    {
        return this.sd.findAll();
    }

}