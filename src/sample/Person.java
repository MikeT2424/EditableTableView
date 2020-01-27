package sample;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    // When to use StringProperty firstName over String firstName?
    // Use it when this firstName variable is going to be observed by others.
    // You also can observe it by attaching a listener.
    // You can use this variable in bindings with other observable objects of JavaFX.
    // **In some circumstances it is mandatory to use JavaFX Property, like Person list rendered with tableView which is editable.**
    // To reflect the changes immediately in edited cell the underlying bound field should be a property.

    private SimpleStringProperty firstName;
    private SimpleStringProperty middleName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty town;

    //because most programs operate with Strings they are passed into the method.
    public Person(String firstName, String middleName, String lastName,String town) {

        //Because simpleStringProperties are used when observable classes are used, we are converting the String
        // to a simpleStringProperty.
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.town = new SimpleStringProperty(town);
    }

    //Because this uses SimpleStringProperty as data, the get method must be used to return the String value.
    public String getFirstName() {
        return firstName.get();
    }

    //When setting the first name, the method: edittedCell.getNewValue().toString() returns a string,
    // so this setter will take a string and then pass it into the SimpleStringProperty for update in the table.
    // The SimpleStringProperty is needed for automatic updating in the table.
    public void setFirstName(String firstName) {

        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(SimpleStringProperty middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public String getTown() {
        return town.get();
    }

    public void setTown(SimpleStringProperty town) {
        this.town = town;
    }


}
