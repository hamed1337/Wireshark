/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireshark;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TitledPane;

/**
 *
 * @author Ahmed
 */
public class FXMLDocumentController implements Initializable {

    @FXML

    private Label label;
    @FXML
    private ListView list;
    @FXML
    private VBox captureVBox;
    @FXML
    private VBox vbox2;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView table;

    private static int MENUHEIGHT = 25;

    private ObservableList<String[]> tableData;
    @FXML
    private Accordion accordion;
    @FXML
    private TextArea hexView;

    @FXML
    private void handleMouseClicked(MouseEvent click) {
        if (click.getClickCount() == 2) {
            //choose device by index
            label.setText(list.getSelectionModel().getSelectedIndex() + "");
            captureVBox.setVisible(false);
            vbox2.setVisible(true);
            anchorPane.setPrefSize(vbox2.getPrefWidth(), vbox2.getPrefHeight() + MENUHEIGHT); //majornelson <3
            anchorPane.getScene().getWindow().sizeToScene();
            anchorPane.getScene().getWindow().centerOnScreen();
            addToTable(new String[]{"1", "1", "2", "2", "3", "3", "4"});
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //function that returns a list of devices
        list.setItems(FXCollections.observableArrayList("Single", "Double", "Suite", "Family App"));
        vbox2.setVisible(false);
        anchorPane.setPrefSize(captureVBox.getPrefWidth(), captureVBox.getPrefHeight() + MENUHEIGHT);
        tableData = FXCollections.observableList(new ArrayList<String[]>());
        table.setItems(tableData);

    }

    private void addToTable(String[] row) {
        tableData.add(row);
    }

    private void setAccordion(String[][] detailedData) {
        int i = 0;
        for (TitledPane titledPane : accordion.getPanes()) {
            if (i < detailedData.length) {
                titledPane.setText(detailedData[i][0]);
                ((TextArea) titledPane.getContent()).setText(detailedData[i][1]);
                titledPane.setVisible(true);
            } else {
                titledPane.setVisible(false);
            }
            i++;
        }
    }

}
