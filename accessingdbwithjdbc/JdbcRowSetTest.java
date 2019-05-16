package accessingdbwithjdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JdbcRowSetTest {

    // JDBC driver name and database URL
    private static final String DATABASE_URL = "jdbc:derby:books";
    private static final String USERNAME = "simon";
    private static final String PASSWORD = "simon";

    public static void  main(String[] args) {
        // connect to a db and query db
        try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()) {
            // specify JdbcRowSet properties
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USERNAME);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("SELECT * FROM Authors"); // set query
            rowSet.execute();


            ResultSetMetaData metaData = rowSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.printf("Authors Table of Books Database:%n%n");

            // display rowset header
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
                System.out.println();

                while (rowSet.next()) {
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-8s\t", rowSet.getObject(i));
                }

                    System.out.println();

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
