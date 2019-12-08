package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
    static Database dbMySql;
    static Logger logger = Logger.getLogger(TestDB.class);

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySql = new Database("MySQL_PADB_DB","MySQL");
        logger.info("MySql DB connected");
    }

    @After
    public void tearDown() throws SQLException {
        dbMySql.quit();
    }

    @Test
    public void testDB() throws SQLException {
        // List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable");   // показивает всю базу
        List<ArrayList> dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'qwerty'");
            dbMySql.changeTable("INSERT INTO seleniumTable VALUES (7, 'qwerty', 'pass')");
        dataFromSeleniumTable = dbMySql.selectTable("select * from seleniumTable where login = 'qwerty'");
        for (ArrayList line :dataFromSeleniumTable
                ) {
            logger.info(line); // для красивого вивода в столбец
        }
        // logger.info(dataFromSeleniumTable);  // для вивода таблици в одну строку
    }
}
