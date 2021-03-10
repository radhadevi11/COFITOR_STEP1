package step1_BPR_RN.dao;

import org.junit.jupiter.api.Test;
import step1_BPR_RN.app.DbConnection;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DbConnectionTest {

    @Test
    public void testGetConnection(){
        DbConnection connection = new DbConnection();

        Connection actual = connection.getConnection();

        assertNotNull(actual);
    }
}