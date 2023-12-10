import java.sql.ResultSet;
import java.sql.SQLException;


import lab6.JDBC_CRUD;
import org.junit.Ignore;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

class JDBC_CRUDTest {
    private static final String ADDRESS = "jdbc:mysql://localhost:3306/jdbctest?serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "FIFA2017nhl2017";
    private static final String TABLE_NAME = "programmers";

    @Test
    void testClass() {
        try {
            new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to connect. SQLException.");
        }
    }


    @Test
    void testCreate() {
        try {
            JDBC_CRUD db = new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
            db.createProgrammer(1, "Vasya", "St.Petersburg", "Junior");
            db.createProgrammer(2, "Maksim", "St.Petersburg", "Middle");
            db.createProgrammer(3, "Vova", "Moscow", "Senior");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to create new programmer. SQLException");
        }
    }

    @Test
    void testDelete() {
        try {
            JDBC_CRUD db = new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
            db.deleteProgrammer(1);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to delete programmer. SQLException");
        }
    }

    @Test
    void testRead() {
        ResultSet rs = null;
        try {
            JDBC_CRUD db = new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
            rs = db.readTable();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to read database. SQLException");
        }
        assertNotNull(rs);
    }

    @Ignore
    @Test
    void truncateTable() {
        try {
            JDBC_CRUD db = new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
            db.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to truncate table. SQLException");
        }
    }

    @Test
    void testUpdate() {
        try {
            JDBC_CRUD db = new JDBC_CRUD(ADDRESS, LOGIN, PASSWORD, TABLE_NAME);
            db.updateProgrammer(2, "Petya", "St.Petersburg", "Junior");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to update database. SQLException");
        }
    }
}
