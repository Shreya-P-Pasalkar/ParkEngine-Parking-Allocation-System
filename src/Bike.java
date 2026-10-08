////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 2 : Create Vehicle class hierarchy
//  It is used to create multiple types of classes which represents the types of vehicles
//  Concepts : Abstraction, Inheritance, Polymorphism, Encapsulation
//             (hiding implementation details)
////////////////////////////////////////////////////////////////////////////////////////////////////

// Class which represents Vehicle Type as Bike
class Bike extends Vehicle
{
    public Bike(String vehicleNumber)
    {
        // Calls Vehicle class constructor
        super(vehicleNumber, VehicleType.BIKE);
    }

    // Method Overriding
    @Override
    public void display()
    {
        System.out.println("Bike : "+getVehicleNumber());
    }
}