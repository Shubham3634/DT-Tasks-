package Dto;

// This class is used to represent the response that will be sent back 
// when the container is successfully placed in a yard slot.
// it contains information about the container and its target location (x, y) in the yard.
public class PickResponse {

    private String containerId; // it stores the ID of the container that has been processed
    private int targetX, targetY; // and it stores the target coordinates (x, y) where the container should be placed

    // this Constructor to initialize the PickResponse with the container ID and its target location (x, y)
    public PickResponse(String containerId, int targetX, int targetY) {
        this.containerId = containerId; // set the container ID
        this.targetX = targetX; // set the x-coordinate of the target location
        this.targetY = targetY; // set the y-coordinate of the target location
    }

    // getter method to retrieve the container ID
    public String getContainerId() {
        return containerId;
    }

    // getter method to retrieve the target x-coordinate of the placement location
    public int getTargetX() {
        return targetX;
    }

    // getter method to retrieve the target y-coordinate of the placement location
    public int getTargetY() {
        return targetY;
    }
}
