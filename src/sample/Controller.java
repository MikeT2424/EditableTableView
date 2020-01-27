package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.annotation.Resource;
import java.net.URL;
import java.util.*;

   // https://www.youtube.com/watch?v=uh5R7D_vFto

   // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.html
   // https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html

   // Observable List:
   // https://www.developer.com/java/data/understanding-java-observable-and-javafx-observable.html

public class Controller implements Initializable {

    @FXML
    public TableView<Person> tableview1;

    @FXML public TableColumn<Person , String> firstnamecol;
    @FXML public TableColumn<Person , String> middlenamecol;
    @FXML public TableColumn<Person , String> lastnamecol;
    @FXML public TableColumn<Person , String> towncol;

    @FXML public Button button1;



    ArrayList<SimpleStringProperty> arraylist1 = new ArrayList<SimpleStringProperty>();


    ObservableList<Person> teamList;



    //an initializable controller class must implement this method.
    @Override
    public void initialize(URL url ,ResourceBundle rb){

        //In order to change tableview values, this must be set to editable:
        tableview1.setEditable(true);

        //This allows for an entry of text directly in the cell, so that the names can be changed.

        // firstnamecol.setCellFactory(TextFieldTableCell.forTableColumn());
        // lastnamecol.setCellFactory(TextFieldTableCell.forTableColumn());

        // This sets up each column in the tables.
        // The setCellValueFactory method takes in a PropertyValueFactory method named after the Person fields.
        // The PropertyValueFactory method was designed specifically with the tableColumn FX feature in mind, as it
        // implements the Observable interface , so that it automatically tracks changes in table data.
        firstnamecol.setCellValueFactory(new PropertyValueFactory<Person , String>("firstName"));
        middlenamecol.setCellValueFactory(new PropertyValueFactory<Person , String>("middleName"));
        lastnamecol.setCellValueFactory(new PropertyValueFactory<Person , String>("lastName"));
        towncol.setCellValueFactory(new PropertyValueFactory<Person , String>("town"));


        tableview1.setItems(getPeople());
    }

    // This mehtod will return an observableList of People objects.

    public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();

        people.add(new Person("Mark" , "Richard" , "Hammil" , "Oakland"));
        people.add(new Person("Joaquim" ,"Rafael" ,"Pheonix" , "San Juan"));
        people.add(new Person("Emma" , "Jean" , "Stone" , "Scottsdale"));
        people.add(new Person("" , "" , "" , ""));

        return people;

    }

    //This can also be used to
    public void changeFirstNameCellEvent(TableColumn.CellEditEvent edittedCell){
        //This returns the selected person and then edits the selected cell
        Person personSelected = tableview1.getSelectionModel().getSelectedItem();

        personSelected.setFirstName(edittedCell.getNewValue().toString());
    }

    public void xMark(){

        Person personSelected = tableview1.getSelectionModel().getSelectedItem();

        personSelected.setFirstName("X");

        //These next two lines are used to refresh the tableview.
        tableview1.getColumns().get(0).setVisible(false);
        tableview1.getColumns().get(0).setVisible(true);



    }


}
