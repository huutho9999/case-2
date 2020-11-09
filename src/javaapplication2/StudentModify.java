package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CRUD (insert, update, delete, findAll)
 * @author Diep.Tran
 */
public class StudentModify {
    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "concakiem12");
            
            String sql = "select * from student_table";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"), 
                        resultSet.getString("email"), resultSet.getString("phone_number"), 
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return studentList;
    }
    
    public static void insert(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "concakiem12");
            
            String sql = "insert into student_table(fullname, gender, age, email, phone_number) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void update(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "concakiem12");
            
            String sql = "update student_table set fullname=?,gender=?,age=?,email=?,phone_number=? where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, std.getFullname());
            statement.setString(2, std.getGender());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setInt(6, std.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "concakiem12");
            
            String sql = "delete from student_table where id = ?";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, id);
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Student> findByFullname(String fullname) {
        List<Student> studentList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "concakiem12");
            
            String sql = "select * from student_table where fullname like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {                
                Student std = new Student(resultSet.getInt("id"), 
                        resultSet.getString("fullname"), resultSet.getString("gender"), 
                        resultSet.getString("email"), resultSet.getString("phone_number"), 
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return studentList;
    }
}