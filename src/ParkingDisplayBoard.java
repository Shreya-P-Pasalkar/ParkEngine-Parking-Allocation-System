////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 7 : Create ParkingDisplayBoard class
//  It is used to create a class which displays the parking status
//
//  Subject ->  ParkingFloor
//  Observer -> ParkingDisplayBoard
//
//  Note : Any observer is going to observe the subject 
//  There will be multiple observers for one subject
//
//  Concepts : Observer Design Pattern
////////////////////////////////////////////////////////////////////////////////////////////////////
class ParkingDisplayBoard implements ParkingObserver
{
    // Floor whose availability is displayed by this board
    public ParkingFloor floor;

    public ParkingDisplayBoard(ParkingFloor floor)
    {
        this.floor = floor;
    }

    // Automatically called whenever floor availability changes
    @Override
    public void update()
    {
        System.out.println();
        System.out.println("----------------- Display Board -----------------");

        System.out.println("Floor : "+floor.getFloorNumber());

        System.out.println("Available Bike Spots : "+floor.getAvailableCount(SpotType.BIKE));

        System.out.println("Available Car Spots : "+floor.getAvailableCount(SpotType.CAR));

        System.out.println("Available Truck Spots : "+floor.getAvailableCount(SpotType.TRUCK));

        System.out.println("-------------------------------------------------");
        System.out.println();
    }
} // End of ParkingDisplayBoard