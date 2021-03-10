package step1_BPR_RN.app;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingsDaoImpl extends AbstractDao<Ratings> {

    private PreparedStatement getStatement;
    private PreparedStatement getAllStatement;

    public RatingsDaoImpl() {
        createGetStatement();
        createGetAllStatement();
    }

    private  void createGetStatement() {
        try {
            getStatement = connection.prepareStatement("select * from ratings where rating_id=?");
        } catch (SQLException e) {
            throw new RuntimeException("Can not create PreparedStatement to get ratings");
        }
    }
    @Override
    public PreparedStatement getGetStatement() {
        return getStatement;
    }

    @Override
    public Ratings getEntity(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        int itemId = resultSet.getInt("movie_id");
        double rating = resultSet.getDouble("rating");
        String timeStamp = resultSet.getString("time_stamp");
        return new Ratings(userId,itemId,rating,timeStamp);
    }
    private  void createGetAllStatement() {
        try {
            getAllStatement = connection.prepareStatement("select * from ratings");
        } catch (SQLException e) {
            throw new RuntimeException("Can not create PreparedStatement to get all ratings");
        }
    }
    @Override
    public PreparedStatement getGetAllStatement() {
        return getAllStatement;
    }
}
