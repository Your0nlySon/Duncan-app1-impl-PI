package baseline;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


public class FXMLController {

    @FXML private ToggleGroup group;
    @FXML private RadioButton allV;
    @FXML private RadioButton completedV;
    @FXML private RadioButton inCompletedV;
    @FXML private MenuItem save;
    @FXML private MenuItem open;
    @FXML private MenuItem close;
    @FXML private TableColumn<Items, String> desc;
    @FXML private TableColumn<Items, String> date;
    @FXML private TableColumn<Items, Boolean> completed;
    @FXML private TableView<Items> tableList;
    @FXML private TextField descriptionBox;
    @FXML private DatePicker dueDatePicker;
    @FXML private Button addButton;

    ObservableList<Items> list = FXCollections.observableArrayList();
    ObservableList<Items> compList = FXCollections.observableArrayList();
    ObservableList<Items> inCompList = FXCollections.observableArrayList();

    public void addTextFields(ActionEvent event) {
        FXMLController cont = new FXMLController();
        Boolean validateItems = cont.validateItems(descriptionBox);
        if (validateItems == true) {
            String dateToString = cont.dateToString(dueDatePicker);
            cont.addItems(descriptionBox,dateToString);
        }
        else {
            //clear values in textbox
        }
    }

    public String dateToString(DatePicker dueDatePicker) {
        ////if the date picker is null then set date as "" else String date = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //return dateString
        return null;
    }

    public Boolean validateItems(TextField descriptionBox) {
        //get the length of descriptionBox and if it is less than one or over the limit of 256 characters make a substring and return that
        //else return the string
        return null;
    }

    private void addItems(TextField descriptionBox, String dueDatePicker) {
        //Item newItem = new Item(descriptionBox,dueDatePicker, false)
        //tableList.getItems().add(Item)
        //clear items in the textfields and datepicker
    }

    public void removeSelectedList(ActionEvent event) {
        //get the list and define two variables selectedRows, allItems
        // ObservableList<Items> selectedRows, allItems;
        //allItems = tableList.getItems();
        //selectedRows = tableList.getSelectionModel().getSelectedItems();
        //for (Items item : selectedRows) {allItems.remove(item);}
    }

    public void clearList(ActionEvent event) {
        //tableList.getItems().clear();
    }

    public void initialize() {

        FXMLController cont = new FXMLController();


        list.add(new Items("Going to School", "2021-05-18"));
        list.add(new Items("Lax Practice", "2020-03-04"));

        //set up the columns in the table
        desc.setCellValueFactory(new PropertyValueFactory<Items, String>("desc"));
        date.setCellValueFactory(new PropertyValueFactory<Items, String>("date"));
        completed.setCellValueFactory(new PropertyValueFactory<Items, Boolean>("completed"));
        completed.setCellFactory(CheckBoxTableCell.forTableColumn(completed));


        //load dummy data
        tableList.setItems(list);
        group.selectedToggleProperty().addListener(
                (observable, oldToggle, newToggle) -> {
                    if (newToggle == allV) {
                        compList.clear();
                        inCompList.clear();
                        tableList.setItems(list);
                    }
                    else if (newToggle == completedV) {
                        compList.clear();
                        inCompList.clear();
                        for (Items items : list) {
                            if (items.isCompleted() == true) {
                                compList.add(items);
                            }
                        }
                        tableList.setItems(compList);
                    }
                    else if (newToggle == inCompletedV) {
                        compList.clear();
                        inCompList.clear();
                        for (Items items : list) {
                            if (items.isCompleted() == false) {
                                inCompList.add(items);
                            }
                        }
                        tableList.setItems(inCompList);
                    }
                }
        );

        //Update the table to allow for the first and last name fields
        //to be editable
        tableList.setEditable(true);
        desc.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setCellFactory(TextFieldTableCell.forTableColumn());

        //This will allow the table to select single rows
        tableList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }


    public void saveList(ActionEvent event) {
        //open file save but only allow it to save to .txt files
        //get the absolute path of that file
        //write the observablelist to that file
    }

    public void openList(ActionEvent event) {
        //open filechooser and get the absolute path from the .txt file
        //clear all values in the tableList
        //use buffered reader to read the .txt file and add it to the list for the tableView (tableList)
    }

    public void closeList(ActionEvent event) {
        Platform.exit();
    }

    public void editDesc(TableColumn.CellEditEvent<Items, String> itemsStringCellEditEvent) {
        FXMLController cont = new FXMLController();
        Boolean validateEditItems = cont.validateEditItems(itemsStringCellEditEvent.toString());
        //if validateEditItems == false then cancel the edit
    }

    public Boolean validateEditItems(String toString) {
        //check if the string is greater than 0 and less than 256
        //return false
        //else
        //return true
        return true;
    }

    public void editDate(TableColumn.CellEditEvent<Items, String> itemsStringCellEditEvent) {
        FXMLController cont = new FXMLController();
        Boolean validateEditDate = cont.validateEditDate(itemsStringCellEditEvent.toString());
        //if validateEditDate == false then cancel the edit
    }

    public Boolean validateEditDate(String toString) {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //dateFormat.setLenient(false);
        //try {
        //     dateFormat.parse(inDate.trim());
        //     } catch (ParseException pe) {
        //      return false;
        //     }
                return true;
        //
    }
}
