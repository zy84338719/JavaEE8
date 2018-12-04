package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConcreteStudentDao implements StudentDAO {
    @Override
    public int addStudent(Student student) {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "insert into student(student_name,student_age,tel) values(?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, student.getStudent_name());
            ps.setInt(2, student.getStudent_age());
            ps.setString(3, student.getStudent_tel());

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }
        return i;
    }

    //删除一个学生
    @Override
    public int deleteStudent(String name)
    {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "delete from student where student_name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    @Override
    public int updateStudent(String name) {
        Connection con = null ;
        PreparedStatement ps = null ;
        int i = 0 ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "update student set student_age=student_age+1  where student_name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            i = ps.executeUpdate() ;

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(null, ps, con);
        }

        return i;
    }

    @Override
    public Student findStudent(String name) {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select student_name,student_age,tel from student where stuName =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);

            rs = ps.executeQuery() ;
            stu = new Student();
            while(rs.next())
            {
                stu.setStudent_name(rs.getString(1));
                stu.setStudent_age(rs.getInt(2));
                stu.setStudent_tel(rs.getString(3));
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return stu;
    }

    @Override
    public Set<Student> findAll() {
        Connection con = null ;
        PreparedStatement ps = null ;
        Student stu = null ;
        ResultSet rs = null;
        Set<Student> set = null ;
        try
        {
            con = JDBCUtils.getConnection();
            String sql = "select student_name,student_age,tel from student";
            ps = con.prepareStatement(sql);

            set = new HashSet<Student>() ;
            rs = ps.executeQuery() ;

            while(rs.next())
            {
                stu = new Student();

                stu.setStudent_name(rs.getString(1));
                stu.setStudent_age(rs.getInt(2));
                stu.setStudent_tel(rs.getString(3));
                set.add(stu);
            }

        }
        catch(SQLException e)
        {
            throw new DAOException(e.getMessage(),e);
        }
        finally
        {
            JDBCUtils.free(rs, ps, con);
        }

        return set;
    }
}

