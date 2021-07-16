/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mohammad
 */
public class MysqlConnect {

    private final String DBname = "student_db";
    private final String url = "jdbc:mysql://localhost:3306/"+DBname+"?zeroDateTimeBehavior=convertToNull";
    private final String password = "12345";
    private final String user = "root";
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    private static Statement statement;
    private String Sql;
    private PreparedStatement ps;

    public MysqlConnect() {
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            System.out.println("Connecting DB");
        } catch (Exception e) {
            throw new RuntimeException("Error in Connect DB");
        }
    }
    
        public TableModel findAll () throws Exception{
         Sql="select * from student ";
        ResultSet resultSet=statement.executeQuery(Sql);
        return DbUtils.resultSetToTableModel(resultSet);
    }
    public String save(Student student) {

        try {
            Sql = "insert into student (fullname,age,department)values(?,?,?)";
            ps = connection.prepareStatement(Sql);
            ps.setString(1, student.getFullName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDepartment());
            ps.executeUpdate();
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        return "Save successfully";

    }
       public String update(Student student) {

        try {

            Sql = "update student set fullname=? , age=? , department=? where id=?";

            ps = connection.prepareStatement(Sql);
             ps.setString(1, student.getFullName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getDepartment());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        return "Update successfully";

    }
       public String deleteById(int id) throws SQLException {
            Sql = "delete from student where id=?";
            ps = connection.prepareStatement(Sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return "Delete successfully";
        
       }
       
       public TableModel findByName(String fullname) throws Exception {
        Student student=null;
        Sql = "select * from student where fullname='"+fullname+"'";
        ResultSet resultSet = statement.executeQuery(Sql);
         return DbUtils.resultSetToTableModel(resultSet);
    }
      public Student findById(int id) throws Exception {
        Student student=null;
        Sql = "select * from student where id="+id+"";
        ResultSet resultSet = statement.executeQuery(Sql);
        while (resultSet.next()) {
            student=new Student(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getString(4));
        }
        return student;
    }
}
