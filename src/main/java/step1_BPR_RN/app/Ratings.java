package step1_BPR_RN.app;

public class Ratings {
    private int ratingId;
    private int userId;
    private int movieId;
    private double rating;
    private String timeStamp;

    public Ratings(int userId, int movieId, double ratings, String timeStamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = ratings;
        this.timeStamp = timeStamp;
    }

    public int getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public double getRating() {
        return rating;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getRatingId() {
        return ratingId;
    }
}
