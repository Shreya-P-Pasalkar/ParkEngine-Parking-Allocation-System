////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 4 : Create ParkingSpot Hierarchy
//  It is used to create hierachy of Parking Spots
//  Concepts : Encapsulation, Abstraction, Polymorphism, Inheritance, COMPOSITION
////////////////////////////////////////////////////////////////////////////////////////////////////

class BikeSpot extends ParkingSpot
{
    public BikeSpot(int spotNumber)
    {
        super(spotNumber, SpotType.BIKE);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        //return vehicle.getVehicleType() == VehicleType.BIKE;

        if(vehicle.getVehicleType() == VehicleType.BIKE)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}