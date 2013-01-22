package classdiagramtojavadoc;

/**
 * A tool used for travel, and transportation of goods and people.
 * 
 * @author Paul English
 */
public abstract class Vehicle {

    /**
     * Note: Construction of a vehicle usually requires a factory, or assembly line.
     */
    public Vehicle() {
        
    }
    
    /**
     * Translate a vehicle in a one-dimensional distance.
     * 
     * @param distance Distance in nanometers.
     */
    public void Move(double distance) {
        
    }
    
    /**
     * Ensure brakes are appropriately applied to a vehicle, allowing it to slow
     * to a halt.
     */
    public void Stop() {
        
    }
    
    /**
     * Adjust steering and direction of a vehicle by degrees.
     * 
     * @param degrees A positive or negative value to indicate left & right turns.
     */
    public void Turn(double degrees) {
        
    }
}
