package Model;

// this Slot class represents a slot in the yard where a container can be placed.
// and it contains information such as the slots position, its size capacity, whether it has a cold unit, and if its already occupied by a container.
public class Slot {
    
    private int x; // the x-coordinate of the slots position in the yard (horizontal position)
    private int y; // the y-coordinate of the slots position in the yard (vertical position)
    private String sizeCap; // the size capacity of the slot (for example: "small", "big")
    private boolean hasColdUnit; // this flag indicating if the slot has a cold storage unit (true if it has, false if not)
    private boolean occupied; // this flag indicating if the slot is currently occupied by a container (true if occupied, false if empty)

    // default constructor for creating a Slot without setting any initial values
    public Slot() {
    }

    // constructors to initialize a Slot with given values for its position, size, cold unit availability, and occupancy status
    public Slot(int x, int y, String sizeCap, boolean hasColdUnit, boolean occupied) {
        this.x = x; // set the x-coordinate of the slot's position
        this.y = y; // set the y-coordinate of the slot's position
        this.sizeCap = sizeCap; // set the size capacity of the slot (for example: "small", "big")
        this.hasColdUnit = hasColdUnit; // set whether the slot has a cold unit (true or false)
        this.occupied = occupied; // set the occupancy status (true if occupied, false if empty)
    }

    // getter method to retrieve the x-coordinate of the slot's position in the yard
    public int getX() { 
        return x; 
    }

    // setter method to set the x-coordinate of the slot's position
    public void setX(int x) { 
        this.x = x; 
    }

    // getter method to retrieve the y-coordinate of the slot's position in the yard
    public int getY() { 
        return y; 
    }

    // setter method to set the y-coordinate of the slot's position
    public void setY(int y) { 
        this.y = y; 
    }

    // getter method to retrieve the size capacity of the slot (e.g., "small", "big")
    public String getSizeCap() { 
        return sizeCap; 
    }

    // Setter method to set the size capacity of the slot
    public void setSizeCap(String sizeCap) { 
        this.sizeCap = sizeCap; 
    }

    // getter method to check if the slot has a cold unit (true if it has, false if it does not)
    public boolean isHasColdUnit() { 
        return hasColdUnit; 
    }

    // setter method to set whether the slot has a cold unit or not
    public void setHasColdUnit(boolean hasColdUnit) { 
        this.hasColdUnit = hasColdUnit; 
    }

    // getter method to check if the slot is occupied by a container (true if occupied, false if empty)
    public boolean isOccupied() { 
        return occupied; 
    }

    // Setter method to set the occupancy status of the slot (true if occupied, false if empty)
    public void setOccupied(boolean occupied) { 
        this.occupied = occupied; 
    }
}
