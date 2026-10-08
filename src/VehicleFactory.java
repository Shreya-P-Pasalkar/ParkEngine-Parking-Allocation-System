////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 3 : Create VehicleFactory Class
//  It is used to centralise the creation of Vehicle Objects
//  Concepts : Factory Design Pattern 
////////////////////////////////////////////////////////////////////////////////////////////////////

class VehicleFactory
{
    // Creates and return the desired class object 
    public static Vehicle createVehicle(VehicleType type, String Number)
    {
        switch(type)
        {
            case BIKE:
                return new Bike(Number);
            
            case CAR :
                return new Car(Number);

            case TRUCK : 
                return new Truck(Number);

            default :
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }
    }
}