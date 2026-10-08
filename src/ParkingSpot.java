////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 4 : Create ParkingSpot Hierarchy
//  It is used to create hierachy of Parking Spots
//  Concepts : Encapsulation, Abstraction, Polymorphism, Inheritance, COMPOSITION
////////////////////////////////////////////////////////////////////////////////////////////////////

abstract class ParkingSpot
{
    // Unique Number for parking spot (Primary Key)
    private int spotNumber;

    // Type of Parking Spot
    private SpotType spotType;

    // Indicated whether spot is currently occupied or not
    private boolean occupied;

    // Stores information about the vehicle (COMPOSITION - achieving reusability using or object of another class)
    private Vehicle vehicle;

    // Parameterised Constructor
    public ParkingSpot(int spotNumber, SpotType spotType)
    {
        this.spotNumber = spotNumber;
        this.spotType = spotType;

        // Initialised with default Values
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSpotNumber()
    {
        return this.spotNumber;
    }

    public SpotType getSpotType()
    {
        return this.spotType;
    }

    public boolean isOccupied()
    {
        return this.occupied;
    }

    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // It is used to park the vehicle
    public void parkVehicle(Vehicle vehicle)
    {   
        if(this.occupied == true)
        {
            // this is written because if in case parking spot is already occupied incase of multithreading
            throw new RuntimeException("Parking spot is already occupied");
        }
        else
        {
            this.vehicle = vehicle;
            this.occupied = true;
        }
    }

    public Vehicle removeVehicle()
    {
        if(this.occupied == true)
        {
            Vehicle temp = vehicle;

            this.vehicle = null;
            this.occupied = false;

            return temp;
        }
        else
        {
            throw new RuntimeException("Parking spot is already empty");
        }
    }

    // this method decides whether we can park it in the spot or not
    public abstract boolean canFitVehicle(Vehicle vehicle);

    public void display()
    {
        System.out.println("Spot : "+spotNumber+" ["+spotType+"]");

        if(this.occupied == true)
        {
            System.out.println("Occupied by "+vehicle.getVehicleNumber());
        }
        else
        {
            System.out.println("Spot is available");
        }
    }
} // End of ParkingSpot Class