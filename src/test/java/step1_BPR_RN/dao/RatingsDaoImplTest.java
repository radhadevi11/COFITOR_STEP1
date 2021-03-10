package step1_BPR_RN.dao;

import java.util.*;

import org.junit.jupiter.api.Test;
import step1_BPR_RN.app.RatingsDaoImpl;
import step1_BPR_RN.app.Ratings;

import static org.junit.jupiter.api.Assertions.*;

class RatingsDaoImplTest
{
@Test
    public void testGet() {

    RatingsDaoImpl ratingsDao = new RatingsDaoImpl();
    Ratings actual = ratingsDao.get(1);
    assertEquals(296, actual.getMovieId());
}
    @Test
    public void testGetAll() {

        RatingsDaoImpl ratingsDao = new RatingsDaoImpl();
        List<Ratings> actual = ratingsDao.getAll();
        assertEquals(100, actual.size());
    }
}