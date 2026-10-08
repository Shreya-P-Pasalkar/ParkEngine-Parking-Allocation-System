////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 4 : Create ParkingSpot Hierarchy
//  It is used to create hierachy of Parking Spots
//  Concepts : Encapsulation, Abstraction, Polymorphism, Inheritance, COMPOSITION
////////////////////////////////////////////////////////////////////////////////////////////////////

class CarSpot extends ParkingSpot
{
    public CarSpot(int spotNumber)
    {
        super(spotNumber, SpotType.CAR);
    }

    @Override
    public boolean canFitVehicle(Vehicle vehicle)
    {
        //return vehicle.getVehicleType() == VehicleType.CAR;

        if(vehicle.getVehicleType() == VehicleType.CAR)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}