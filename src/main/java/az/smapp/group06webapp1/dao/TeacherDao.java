package az.smapp.group06webapp1.dao;

import az.smapp.group06webapp1.DB.DBConfig;
import az.smapp.group06webapp1.entity.Teacher;
import az.smapp.group06webapp1.util.ApplicationUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherDao {
    public static void addTeacher(Teacher teacher) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConfig.getConnection2(); //database ile yaratdigimiz connection-a qosuluruq
            String sql = "INSERT INTO TMAppOne.teacher(namess,surname,email,phone) VALUES(?,?,?,?)";
            if (Objects.nonNull(connection)) //Connection eger null deyilse ishlesin
            {
                statement = connection.prepareStatement(sql); //sql-i connection ucun hazirla ve menimset statement-a
                statement.setString(1, teacher.getName());
                statement.setString(2, teacher.getSurname());
                statement.setString(3, teacher.getEmail());
                statement.setString(4, teacher.getPhone());
                statement.execute(); //icini doldurduqdan sonra statement-i play et
            }
        } catch (Exception ex) {
            ApplicationUtil.printError("Telebe elave edilmedi");
        } finally {
            connection.close();
            statement.close(); // xeta bash verse de bash vermese de finally bloku hemishe ishe dushur
        }
    }



    public static List<Teacher> getAllTeacher() throws SQLException {
        List<Teacher> teachers = new ArrayList<Teacher>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  //Bu bizim javadaki cedvelimizdir.
        String sql = "SELECT t.id,t.namess, t.surname, t.email, t.phone FROM tmappone.teacher t";
        try {
            connection = DBConfig.getConnection2();
            if (Objects.nonNull(connection)) {
                statement = connection.prepareStatement(sql); //string-i sql scriptine cevirir
                resultSet = statement.executeQuery(); //buda eynile statement-i play edir.
                //hemin melumatlar resulSet obyektine yigildi. indide onun icinden ashaghidaki shekilde oxuyacaghiq:
                while (resultSet.next()) {
                   Teacher teacher = new Teacher();
                    teacher.setId(resultSet.getLong("ID"));
                    teacher.setName(resultSet.getString("NAMESS"));
                    teacher.setSurname(resultSet.getString("SURNAME"));
                    teacher.setEmail(resultSet.getString("EMAIL"));
                    teacher.setPhone(resultSet.getString("PHONE"));
                    teachers.add(teacher);
                }
            }

        } catch (Exception ex) {
            ApplicationUtil.printError("Bazaya qoshulmada xeta yarandi");
            ex.printStackTrace(); //problemin ne oldugunu gosterir
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }

        return teachers;
    }
    public static Teacher getTeacherById(Long id) throws SQLException {
        Teacher teacher = new Teacher();
        List<Teacher> teachers = new ArrayList<Teacher>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  //Bu bizim javadaki cedvelimizdir.
        String sql = "SELECT t.id,t.namess, t.surname, t.email, t.phone FROM tmappone.teacher t WHERE t.id=?";
        try {
            connection = DBConfig.getConnection2();
            if (Objects.nonNull(connection)) {
                statement = connection.prepareStatement(sql); //string-i sql scriptine cevirir
                statement.setLong(1, id); //filan id-li melumat gelmelidi
                resultSet = statement.executeQuery(); //buda eynile statement-i play edir.
                //hemin melumatlar resulSet obyektine yigildi. indide onun icinden ashaghidaki shekilde oxuyacaghiq:

                while (resultSet.next()) { //Cedveli oxuyuruq

                    teacher.setId(resultSet.getLong("ID"));
                    teacher.setName(resultSet.getString("NAMESS"));
                    teacher.setSurname(resultSet.getString("SURNAME"));
                    teacher.setEmail(resultSet.getString("EMAIL"));
                    teacher.setPhone(resultSet.getString("PHONE"));
                    teachers.add(teacher); // cedveli yigiriq obyektin icine
                }

            }

        } catch (Exception ex) {
            ApplicationUtil.printError("Bazaya qoshulmada xeta yarandi");
        } finally {
            connection.close();
            statement.close();
            resultSet.close();
        }

        return teacher;
    }


    public static boolean updateTeacherById(Teacher teacher) throws Exception {

        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE tmappone.teacher t Set t.namess=?, t.surname=?, t.email=?, t.phone=? Where t.id=?";

        try{
            connection = DBConfig.getConnection2(); //database ile yaratdigimiz connection-a qosuluruq
            if (Objects.nonNull(connection)) //Connection eger null deyilse ishlesin
            {
                statement = connection.prepareStatement(sql); //sql-i connection ucun hazirla ve menimset statement-a
                statement.setString(1, teacher.getName());
                statement.setString(2, teacher.getSurname());
                statement.setString(3, teacher.getEmail());
                statement.setString(4, teacher.getPhone());
                statement.setLong(5,teacher.getId());
                statement.execute(); //icini doldurduqdan sonra statement-i play et
                isUpdated = true;
            }

        }catch(Exception ex){
            ApplicationUtil.printError("Bazada melumat tapilmadi ");
        }finally{
            connection.close();
            statement.close();

        }  return isUpdated;
    }
}
