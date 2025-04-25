package Dto;

import java.util.List; // this imports List to store multiple yard slots
import Model.Container; // this imports the Container class which represents the container to be placed
import Model.Slot; // this imports the Slot class which represents the slots in the yard

// this class is used to encapsulate the request data that contains details about the container
// and the available yard slots where the container might be placed.
public class PickRequest {

    private Container container; // its a field to store the container that needs to be placed
    private List<Slot> yardMap; //  field to store a list of yard slots where the container can be placed

    // this method returns the container object. 
    //  and it helps other parts of the code access the container details from the request.
    public Container getContainer() {
        return container;
    }

    // this method is returns the list of yard slots (yardMap). 
    // and it allows other parts of the code to access the available slots where the container can be placed.
    public List<Slot> getYardMap() {
        return yardMap;
    }
}
