////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 4 : Create ParkingSpot Hierarchy
//  It is used to create hierachy of Parking Spots
//  Concepts : Encapsulation, Abstraction, Polymorphism, Inheritance, COMPOSITION
////////////////////////////////////////////////////////////////////////////////////////////////////

class TruckSpot extends ParkingSpot
{
    public TruckSpot(int spotNumber)
    {
        super(spotNumber, SpotType.TRUCK);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        //return vehicle.getVehicleType() == VehicleType.TRUCK;

        if(vehicle.getVehicleType() == VehicleType.TRUCK)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}