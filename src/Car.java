////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 2 : Create Vehicle class hierarchy
//  It is used to create multiple types of classes which represents the types of vehicles
//  Concepts : Abstraction, Inheritance, Polymorphism, Encapsulation
//             (hiding implementation details)
////////////////////////////////////////////////////////////////////////////////////////////////////

// Class which represents Vehicle Type as Car
class Car extends Vehicle
{
    public Car(String vehicleNumber)
    {
        // Calls Vehicle class constructor
        super(vehicleNumber, VehicleType.CAR);
    }

    // Method Overriding
    @Override
    public void display()
    {
        System.out.println("Car : "+getVehicleNumber());
    }
}