package classdiagramtojavadoc;

/**
 * An engine powered vehicle with 1 or many axles.
 * @author Paul English
 */
public class Car extends Vehicle {
    
    /**
     * Associated axles for this vehicle.
     */
    public Axle[] axles;
    
    /**
     * Public Car constructor.
     */
    public Car() {
        
    }
    
    /**
     * A representation of total miles this vehicle has traveled.
     */
    private double m_Mileage;

    /**
     * A representation of this vehicles present speed.
     */
    private double m_Speed;
    
    /**
     * A basic setter for speed using a miles per hour convention.
     */
    public void SetSpeedMPH() {
        
    }
    
    /**
     * A getter for speed, output in miles per hour.
     * 
     * @return Vehicle speed in MPH.
     */
    public double GetSpeedMPH() {
        return 0.0;
    }
    
    /**
     * A getter for vehicles speed, output using metric measurements.
     * 
     * @return Vehicle speed in KPH.
     */
    public double GetSpeedKPH() {
        return 0.0;
    }
    
    /**
     * An internal setter for total vehicle mileage.
     * 
     * @param mileage Number of miles the vehicle has traveled.
     */
    private void SetMileage(double mileage) {
        
    }
}
