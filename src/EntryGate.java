////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 12 : Create EntryGate class
//
//  It is used to used to handle entry of vehicle and its ticket generation
//
////////////////////////////////////////////////////////////////////////////////////////////////////
class EntryGate
{
    private int gateNumber;
    
    public EntryGate(int gateNumber)
    {
        this.gateNumber = gateNumber;
    }

    public int getGateNumber()
    {
        return this.gateNumber;
    }

    // It generates a new parking ticket when vehicle enters
    public ParkingTicket generateTicket(Vehicle vehicle, ParkingFloor floor, ParkingSpot spot)
    {
        System.out.println("Vehicle entering from gate : "+this.gateNumber);

        // New parking ticket gets generated for the vehicle
        return new ParkingTicket(vehicle, floor, spot);

    }
} // End of EntryGate Class