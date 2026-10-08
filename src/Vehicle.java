////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 2 : Create Vehicle class hierarchy
//  It is used to create multiple types of classes which represents the types of vehicles
//  Concepts : Abstraction, Inheritance, Polymorphism, Encapsulation
//             (hiding implementation details)
////////////////////////////////////////////////////////////////////////////////////////////////////

// Class which represents a generic vehicle type
abstract class Vehicle
{
    // Abstracted (Hidden) characteristics of class
    private String vehicleNumber;

    private VehicleType vehicleType;

    // Parameterized Constructor
    public Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    // getter methods are written because characteristics are private
    // Concrete Getter Method
    public VehicleType getVehicleType()
    {
        return this.vehicleType;
    }

    // Concrete Getter Method
    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    } 

    // Every concrete class will provide its own definition
    public abstract void display();
}