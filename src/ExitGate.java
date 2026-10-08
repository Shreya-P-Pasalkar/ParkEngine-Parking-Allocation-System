////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 12 : Create ExitGate class
//
//  It is used to used to handle billing and payment during the vehicle exit
//
////////////////////////////////////////////////////////////////////////////////////////////////////
class ExitGate
{
    private int gateNumber;

    public ExitGate(int gateNumber)
    {
        this.gateNumber = gateNumber;
    }

    public int getGateNumber()
    {
        return this.gateNumber;
    }

    // this performs complete exit operations
    public void processExit(
                                ParkingTicket ticket, 
                                PricingStrategy pricingStrategy,
                                PaymentStrategy paymentStrategy
                            )
    {
        // Step 1 : Close ticket and record the exit time
        ticket.closeTicket();

        // Step 2 : Calculate the parking duration
        long hours = ticket.calculateHours();

        // Step 3 : Calculate the parking charges
        double amount = pricingStrategy.calculatePrice(ticket.getVehicle(), hours);

        System.out.println();

        System.out.println("Vehicle exiting from gate : "+this.gateNumber);
        System.out.println("Parking Duration : "+hours);
        System.out.println("Parking Charges : "+amount);

        // Step 4 : Process the payment using selected payment strategy
        paymentStrategy.pay(amount);
    }
} // End of ExitGate Class