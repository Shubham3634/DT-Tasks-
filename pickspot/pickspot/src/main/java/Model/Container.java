package Model;

// this Container class represents a container that needs to be placed in a yard.
// amd it holds information such as the container's ID, size, whether it needs a cold unit, and its position (x, y) in the yard.
public class Container {

    private String id; // a unique identifier for the container, used to distinguish different containers
    private String size; // the size of the container (e.g., "small", "big")
    private boolean needsCold; // a flag that indicates if the container needs a cold unit (true if it needs cold, false otherwise)
    private int x, y; // this x and y coordinates in the yard, representing the container's position

    // getter method to retrieve the container's ID
    public String getId() {
        return id;
    }

    // getter method to retrieve the size of the container (for example: "small", "big")
    public String getSize() {
        return size;
    }

    // getter method to check if the container needs a cold unit (true or false)
    public boolean isNeedsCold() {
        return needsCold;
    }

    // getter method to retrieve the x-coordinate of the containers position in the yard
    public int getX() {
        return x;
    }

    // getter method to retrieve the y-coordinate of the containers position in the yard
    public int getY() {
        return y;
    }
}
