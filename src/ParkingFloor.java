////////////////////////////////////////////////////////////////////////////////////////////////////
//  Required Header  
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*; 

////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 5 : ParkingFloor Class
//  It is used to manage parking floor
//  Concepts : Composition, ArrayList, Object Management
////////////////////////////////////////////////////////////////////////////////////////////////////
class ParkingFloor
{
    // Unique floor number
    private int floorNumber;

    // Collection of all parking spots
    private List<ParkingSpot> parkingspots;

    // Collection of observers registered for the floor
    private List<ParkingObserver> observers;

    public ParkingFloor(int floorNumber) 
    {
        this.floorNumber = floorNumber;

        this.parkingspots = new ArrayList<>();

        this.observers = new ArrayList<>();
    }

    public int getFloorNumber()
    {
        return this.floorNumber;
    }

    public void addParkingSpot(ParkingSpot spot)
    {
        parkingspots.add(spot);
    }

    public void addObserver(ParkingObserver observer)
    {
        observers.add(observer);
    }

    private void notifyObservers()
    {
        for(ParkingObserver observer : observers)
        {
            observer.update();
        }
    }
    
    // Method is going to search parking spot for specific type of vehicle
    public ParkingSpot findAvailableSpot(Vehicle vehicle)
    {
        for(ParkingSpot spot : parkingspots)
        {
            if((!(spot.isOccupied())) && spot.canFitVehicle(vehicle))
            {
                return spot;
            }
        }

        return null;
    }
    
    // Called when new vehicle gets parked
    public void occupySpot(ParkingSpot spot, Vehicle vehicle)
    {
        // allocate spot for the vehicle
        spot.parkVehicle(vehicle);

        // IMP - it notifies to all the observers like display borad, web,etc about the availability of spots
        notifyObservers();
    }

    // Called when vehicle emties the spot 
    public void releaseSpot(ParkingSpot spot)
    {
        // release the already allocated spot
        spot.removeVehicle();

        // IMP - it notifies to all the observers like display borad, web,etc about the availability of spots
        notifyObservers();
    }

    public int getAvailableCount(SpotType type)
    {
        int count = 0;

        for(ParkingSpot spot : parkingspots)
        {
            if(spot.getSpotType() == type && !spot.isOccupied())
            {
                count++;
            }
        }

        return count;
    }

    // Display all parking spots on specific floor
    public void displayFloor()
    {
        System.out.println();

        System.out.println("Floor : "+floorNumber);

        for(ParkingSpot spot : parkingspots)
        {
            spot.display();
        }   
    }
} // End of ParkingFloor  