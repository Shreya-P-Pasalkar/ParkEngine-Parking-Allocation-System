////////////////////////////////////////////////////////////////////////////////////////////////////
//  Required Header  
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 13 : Create ParkingLot class
//
//  This class is the main controller of complete parking system

//  Concept : Singleton Pattern
//
////////////////////////////////////////////////////////////////////////////////////////////////////
class ParkingLot
{
    // Instance of class
    private static ParkingLot instance;

    // Store the ParkingLot name
    private String parkingLotName;

    // Store all floors of the parkingLot
    private List<ParkingFloor> floors;

    // Maps the ticket number with active parking slot
    private Map<Integer, ParkingTicket> activeTickets;

    // Maps vehicle number with active tickets
    // Used for searching vehicle
    // It prevents duplicate parking
    private Map<String, ParkingTicket> vehicleTicketMap;

    // Algorithm used for selecting parking spot
    private ParkingStrategy parkingStrategy;

    // Algorithm used for calculating parking charges
    private PricingStrategy pricingStrategy;

    // Private constructor for singleton class
    private ParkingLot()
    {
        floors = new ArrayList<>();

        activeTickets = new HashMap<>();

        vehicleTicketMap = new HashMap<>();

        // Default parking Strategy
        parkingStrategy = new FirstAvailableParkingStrategy();

        // Default Pricing Strategy
        pricingStrategy = new NormalPricingStrategy();
    }

    // It gives only one single object of this class as it follows Singleton DP
    public static synchronized ParkingLot getInstance()
    {
        if(instance == null)
        {
            instance = new ParkingLot();
        }

        return instance;
    }

    // Used to set name for complete parking lot
    public void setParkingLotName(String parkingLotName)
    {
        this.parkingLotName = parkingLotName;
    }

    // Used to add new parking floor
    public void addFloor(ParkingFloor floor)
    {
        // Insert in ArrayList
        floors.add(floor);
    }

    // this method returns list of all floors of the parking lot
    public List<ParkingFloor> getFloors()
    {
        return floors;
    }

    // This method can be used to change the default parking strategy
    public void setParkingStrategy(ParkingStrategy strategy)
    {
        this.parkingStrategy = strategy;
    }

    // This method can be used to change the default pricing strategy
    public void setPricingStrategy(PricingStrategy strategy)
    {
        this.pricingStrategy = strategy;
    }

    /*
        Alogorithm for parking the vehicle

        Check Duplicate Vehicle
                |
        Find Available spot
                |
        Identify Floor
                |
        Occupy Spot for vehicle
                |
        Generate ticket for vehicle
                |
        Store the final ticket
    */
    public ParkingTicket parkVehicle(
                                        Vehicle vehicle,
                                        EntryGate entryGate
                                    )
    {
        // Step 1 : Prevent the same vehicle for being parked multiple times
        if(vehicleTicketMap.containsKey(vehicle.getVehicleNumber()))
        {
            System.out.println("This vehicle is already parked");

            throw new RuntimeException("This vehicle is already parked");
        }

        // Step 2 : Find the available spot
        ParkingSpot spot = parkingStrategy.findSpot(floors, vehicle);

        // If there is no empty spot
        if(spot == null)
        {
            throw new RuntimeException("Parking is full");
        }

        // Step 3 : Identify the exact floor for the vehicle
        ParkingFloor selectedFloor = null;

        for(ParkingFloor floor : floors)
        {
            ParkingSpot temp = floor.findAvailableSpot(vehicle);

            if(temp == spot)
            {
                selectedFloor = floor;
                break;
            }
        }

        if(selectedFloor == null)
        {
            throw new RuntimeException("Unable to identify floor");
        }

        // Step 4 : Occupy the spot
        selectedFloor.occupySpot(spot, vehicle);

        // Step 5 : Generate parking ticket from entry gate
        ParkingTicket ticket = entryGate.generateTicket(vehicle, selectedFloor, spot);

        // Step 6 : Store the ticket using ticket number
        activeTickets.put(ticket.getTicketNumber(), ticket);

        // Step 7 : Store the ticket using vehicle number
        vehicleTicketMap.put(vehicle.getVehicleNumber(), ticket);

        return ticket;
    } // End of method parkVehicle


    /*
        Find ticket
            |
        Process Exit
            |
        Calculate Charges
            |
        Payment
            |
        Release Spot
            | 
        Remove active records
    */
    public void removeVehicle(
                                int ticketNumber,
                                ExitGate exitGate,
                                PaymentStrategy paymentStrategy
                            )
    {
        // Step 1 : Find active ticket using ticket number
        ParkingTicket ticket = activeTickets.get(ticketNumber);

        if(ticket == null)
        {
            throw new RuntimeException("There is no such ticket");
        }

        // Step 2 : Perform billing and payment
        exitGate.processExit(ticket, pricingStrategy, paymentStrategy);

        // Step 3 : Release the occupied spot
        ticket.getFloor().releaseSpot(ticket.getSpot());

        // Step 4 : Remove ticket
        activeTickets.remove(ticketNumber);

        // Step 5 : Remove vehicle from active vehicle
        vehicleTicketMap.remove(ticket.getVehicle().getVehicleNumber());

        System.out.println("Vehicle removed successfully!");
    } // End of method removeVehicle


    // Search the specific vehicle
    public ParkingTicket searchVehicle(String vehicleNumber)
    {
        return vehicleTicketMap.get(vehicleNumber);
    }

    // Display complete parking lot information
    public void displayParkingLot()
    {
        System.out.println();

        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------Parking Lot Details-----------------------");
        System.out.println("------------------------------------------------------------------");

        for(ParkingFloor floor : floors)
        {
            floor.displayFloor();
        }
    }

} // End of ParkingLot Class
