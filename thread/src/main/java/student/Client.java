package student;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Client {
    public static void main(String[] args)
    {
        Student stu = new Student();
        Set<Student> set = new HashSet<Student>();
        StudentService ss = new StudentService();
//        stu.setStudent_name("晓七");
//        stu.setStudent_age(33);
//        stu.setStudent_tel("18779157911");

//        System.out.println(ss.add(stu));
//        System.out.println(ss.delete("晓七"));
//        System.out.println(ss.update("晓七"));
        //stu = ss.find("cc");
        //System.out.println(stu.getStuName() +" " +stu.getStuAge()+" "+stu.getStuTel()+" "+stu.getStuAddress()+" "+stu.getGroupId());


        set = ss.findAll() ;
        for(Student student:set){
            System.out.println(student.toString());
        }
    }
}
