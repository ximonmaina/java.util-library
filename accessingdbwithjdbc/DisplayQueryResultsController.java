package accessingdbwithjdbc;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

// Controller for the DisplayQueryResults app
public class DisplayQueryResultsController {
    @FXML
    private BorderPane borderPane;
    @FXML
    private TextArea queryTextArea;
    @FXML
    private TextField filteredTextField;

    //database URL, username and password
    private static final String DATABASE_URL = "jdbc:derby:books";
    private static final String USERNAME = "simon";
    private static final String PASSWORD = "simon";

    // default query retrieves all data from Authors table
    private static final String DEFAULT_QUERY = "SELECT * FROM AUTHORS";

    //used for configuring JTable to display and sort data
    private ResultSetTableModel tableModel;
    private TableRowSorter<TableModel> sorter;

    public void initialize() {
        queryTextArea.setText(DEFAULT_QUERY);

        // create ResultSetTableModel and display table
        try {
            // create TableModel for results of DEFAULT_QUERY
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

            // create JTable based on the tableModel
            JTable resultTable = new JTable(tableModel);

            // set up row sorting for JTable
            sorter = new TableRowSorter<>(tableModel);
            resultTable.setRowSorter(sorter);

            // configure SwingNode to display JTable, then add to borderPane
            SwingNode swingNode = new SwingNode();
            swingNode.setContent(new JScrollPane(resultTable));
            borderPane.setCenter(swingNode);
        } catch (SQLException e) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",e.getMessage());
            tableModel.disconnectFromDatabase(); // close connection
            System.exit(1);
        }
    }

    // query the database and display results in JTable
    @FXML
    void submitQueryButtonPressed(ActiveEvent event) {
        try {
            tableModel.setQuery(queryTextArea.getText());
        } catch (SQLException e) {
            displayAlert(Alert.AlertType.ERROR,"Database Error", e.getMessage());

            // rey to recover from invalid user query by executing default query
            try {
                tableModel.setQuery(DEFAULT_QUERY);
                queryTextArea.setText(DEFAULT_QUERY);
            } catch (SQLException ex) {
                displayAlert(Alert.AlertType.ERROR,"Database Error", ex.getMessage());
                tableModel.disconnectFromDatabase();
                System.exit(1);
            }
        }
    }

    @FXML
    void applyFilterButtonPressed(ActiveEvent event) {
        String text = filteredTextField.getText();

        if (text.length() == 0) {
            sorter.setRowFilter(null);
        }else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(text));
            }catch (PatternSyntaxException pse) {
                displayAlert(Alert.AlertType.ERROR,"Regex Error", "Bad regex pattern");
            }
        }
    }

    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
