package accessingdbwithjdbc;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

// ResultSet rows and columns are counted from 1 and JTable
// rows and columns are counted from 0. When processing
// ResultSet rows or columns for use in a JTable, it is
// necessary to add 1 to the row or column number to manipulate
// the appropriate ResultSet column( i.e  JTable column 0 is
// ResultSet column 1 and JTable row 0 is ResultSet row 1).
public class ResultSetTableModel extends AbstractTableModel {

    private final Connection connection;
    private final Statement statement;
    private  ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private int numberOfRows;

    // keep track of database connection status
    private boolean connectedToDatabase = false;

    //constructor initializes resultSet and obtains its metadata object;
    // determine number of rows
    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
        //connect to database
        connection = DriverManager.getConnection(url,username,password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        connectedToDatabase = true;
        // set query and execute it
        setQuery(query);
    }

    public Class getColumnClass(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw  new IllegalStateException("Not Connected to Database");
        }

        // determine Java class of column
        try {
            String className = resultSetMetaData.getColumnClassName(column + 1);
            // return Class object that represents className
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // if problems occur above, assume type Object
        return  Object.class;
    }

    public int getColumnCount() throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not connected to Database");
        }

        // determine number of columns
        try {
            resultSetMetaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getColumnName(int column) throws IllegalStateException{
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try{
            return resultSetMetaData.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Object getValueAt(int row, int column) throws IllegalStateException{
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        // obtain value at specified ResultSet row and column
        try {
            resultSet.absolute(row + 1);
            return resultSet.getObject(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";
    }

    public void setQuery(String query) throws SQLException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        resultSet = statement.executeQuery(query);

        // obtain metadata for ResultSet
        resultSetMetaData = resultSet.getMetaData();
        // determine number of rows in ResultSet
        resultSet.last(); // move resultSet cursor to last row; maybe slow if rows are many
        numberOfRows = resultSet.getRow(); // obtain number of the current row
        fireTableStructureChanged(); //notify JTable that model has changed
    }

    public void disconnectFromDatabase() {
        if (connectedToDatabase) {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connectedToDatabase = false;
            }
        }
    }



    public int getRowCount() throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    }
}
