////////////////////////////////////////////////////////////////////////////////////////////////////
//  Required Header  
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.time.Duration;
import java.time.LocalDateTime;

////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 11 : Create ParkingTicket class

//  It is used to represent one complete transaction
////////////////////////////////////////////////////////////////////////////////////////////////////

class ParkingTicket
{
    // Used for generating unique tickets
    private static int counter = 1000;

    // Ticket Number for unique ticket
    private int ticketNumber;

    // Vehicle associated with that ticket
    private Vehicle vehicle;

    // Floor on which the vehicle is parked
    private ParkingFloor floor;

    // Actual spot on which the vehicle is parked
    private ParkingSpot spot;

    // Time at which vehicle arrived
    private LocalDateTime entryTime;

    // Time at which vehicle exited
    private LocalDateTime exitTime;

    // It maintains the status of the ticket
    private TicketStatus status;

    // Parameterized Constructor
    public ParkingTicket(
                            Vehicle vehicle, 
                            ParkingFloor floor,
                            ParkingSpot spot
                        )
    {
        this.ticketNumber = ++counter;
        this.vehicle = vehicle;
        this.floor = floor;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    // Getter Method for TicketNumber
    public int getTicketNumber()
    {
        return this.ticketNumber;
    }

    // Getter Method for Vehicle
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }

    // Getter Method for floor
    public ParkingFloor getFloor()
    {
        return this.floor;
    }

    // Getter Method for Spot
    public ParkingSpot getSpot()
    {
        return this.spot;
    }

    // Getter Method for EntryTime
    public LocalDateTime getEntryTime()
    {
        return this.entryTime;
    }

    // Getter Method for Exit Time
    public LocalDateTime getExitTime()
    {
        return this.exitTime;
    }

    // Getter Method for Ticket Status
    public TicketStatus getStatus()
    {
        return this.status;
    }

    // Method gets called when vehicle is going out
    public void closeTicket()
    {
        this.exitTime = LocalDateTime.now();

        this.status = TicketStatus.CLOSED;
    }

    // Calculate the total number of hours the vehicle is parked
    public long calculateHours()
    {
        LocalDateTime endTime;

        if(exitTime == null)
        {
            endTime = LocalDateTime.now();
        }
        else
        {
            endTime = this.exitTime;
        }

        // Calculate the actual time 
        long minutes = Duration.between(entryTime, endTime).toMinutes();

        // Converts Minutes to Hours
        long hours = minutes/60;

        if(minutes % 60 != 0)
        {
            hours++;
        }

        if(hours == 0)
        {
            hours = 1;
        }

        return hours;
    }

    // It will display complete ticket on screen
    public void displayTicket()
    {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("----------------- Parking Ticket -----------------");
        System.out.println("--------------------------------------------------");

        System.out.println("Ticket Number : "+this.ticketNumber);

        System.out.println("Vehicle Number : "+this.vehicle.getVehicleNumber());
        
        System.out.println("Vehicle Type : "+this.vehicle.getVehicleType());
        
        System.out.println("Floor Number : "+this.floor.getFloorNumber());
        
        System.out.println("Spot Number : "+this.spot.getSpotNumber());
        
        System.out.println("Entry Time : "+this.entryTime);

        System.out.println("Ticket Status : "+this.status);

        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}