package step1_BPR_RN.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements DAO<T> {
    protected Connection connection;

    public AbstractDao() {
        DbConnection dataBaseConnection = new DbConnection();
        connection = dataBaseConnection.getConnection();
    }

    @Override
    public T get(int id) {
        try {
            getGetStatement().setInt(1, id);//set the id for the select query here 1 is the parameterIndex
            ResultSet resultSet = getGetStatement().executeQuery();
            if(!resultSet.next()){
                return null;
            }
            return getEntity(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("can not get entity with id of " + id, e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }

    public abstract PreparedStatement getGetStatement() throws SQLException;

    public abstract T getEntity(ResultSet resultSet) throws SQLException;

    public abstract PreparedStatement getGetAllStatement() ;

    @Override
    public List<T> getAll() {
        List<T> entities = new ArrayList<>();
        try {

            ResultSet resultSet = getGetAllStatement().executeQuery();

            while (resultSet.next()) {
                entities.add(getEntity(resultSet));
            }
            return entities;

        } catch (SQLException e) {
            throw new RuntimeException("can not get all ratings",e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
