package dao;

import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao implements Dao<Subject> {

    public void create(String name) {
        String sql = "insert into subject values (default, ?)";
        try (Connection con = MyDataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Subject getByName(String name) {
        String sql = "select * from subject where name like ?";
        try (Connection con = MyDataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet resultSet = pst.executeQuery();
            Subject subject = null;
            if (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("s_name"));
            }
            return subject;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Subject> getAll() {
        String sql = "select * from subject";
        List<Subject> subjects;
        try (Connection con = MyDataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            subjects = new ArrayList<>();
            Subject subject;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("s_name"));
                subjects.add(subject);
            }
            return subjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject get(long id) {
        String sql = "select * from subject where id = ?";

        try (Connection con = MyDataSource.getConnection()) {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(id));
            ResultSet resultSet = pst.executeQuery();
            Subject subject = null;
            if (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("id"));
                subject.setName(resultSet.getString("s_name"));
            }
            return subject;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(String login) {

    }
}
