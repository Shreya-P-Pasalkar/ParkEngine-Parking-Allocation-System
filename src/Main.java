////////////////////////////////////////////////////////////////////////////////////////////////////
//  Required Header  
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    1 : Create ParkingLot Class Object 
//
//    2 : Create Floors
//
//    3 : Add Parking spots
//
//    4 : Create Display Board
//
//    5 : Register Observers
//
//    6 : Add floor to parkingLot
//
//    7 : Create entry exits gates
//
//   8 : Display Menu
////////////////////////////////////////////////////////////////////////////////////////////////////

class Main
{
    public static void main(String A[]) throws Exception
    {
        Scanner sobj = new Scanner(System.in);

        ///////////////////////////////////////////////////////////////////////////
        // Step 1 : Create Single Parking Lot object
        ///////////////////////////////////////////////////////////////////////////

        ParkingLot parkingLot = ParkingLot.getInstance();

        parkingLot.setParkingLotName("Marvellous ParkEngine");

        ///////////////////////////////////////////////////////////////////////////
        // Step 2 : Create Multiple Floors
        ///////////////////////////////////////////////////////////////////////////

        // Add First Floor

        ParkingFloor floor1 = new ParkingFloor(1);

        ///////////////////////////////////////////////////////////////////////////
        // Step 3 : Create Multiple Spots
        ///////////////////////////////////////////////////////////////////////////

        floor1.addParkingSpot(new BikeSpot(101));
        floor1.addParkingSpot(new BikeSpot(102));

        floor1.addParkingSpot(new CarSpot(103));
        floor1.addParkingSpot(new CarSpot(104));
        
        floor1.addParkingSpot(new TruckSpot(105));
        floor1.addParkingSpot(new TruckSpot(106));

        ///////////////////////////////////////////////////////////////////////////
        // Step 4 : Create Display Board
        ///////////////////////////////////////////////////////////////////////////
        ParkingDisplayBoard board1 = new ParkingDisplayBoard(floor1);

        // Register the display board with observer
        floor1.addObserver(board1);

        // Add Second Floor

        ParkingFloor floor2 = new ParkingFloor(2);

        ///////////////////////////////////////////////////////////////////////////
        // Step 3 : Create Multiple Spots
        ///////////////////////////////////////////////////////////////////////////

        floor2.addParkingSpot(new BikeSpot(201));
        floor2.addParkingSpot(new BikeSpot(202));

        floor2.addParkingSpot(new CarSpot(203));
        floor2.addParkingSpot(new CarSpot(204));
        
        floor2.addParkingSpot(new TruckSpot(205));
        floor2.addParkingSpot(new TruckSpot(206));

        ///////////////////////////////////////////////////////////////////////////
        // Step 4 : Create Display Board
        ///////////////////////////////////////////////////////////////////////////
        ParkingDisplayBoard board2 = new ParkingDisplayBoard(floor2);

        // Register the display board with observer
        floor2.addObserver(board2);

        ///////////////////////////////////////////////////////////////////////////
        // Step 6 : Add floors to parking lot
        ///////////////////////////////////////////////////////////////////////////
        
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        ///////////////////////////////////////////////////////////////////////////
        // Step 7 : Create entry gate and exit gate
        ///////////////////////////////////////////////////////////////////////////

        EntryGate entryGate = new EntryGate(1);
        ExitGate exitGate = new ExitGate(1);

        ///////////////////////////////////////////////////////////////////////////
        // Step 8 : Display Menu
        ///////////////////////////////////////////////////////////////////////////

        int iChoice = 0;

        while(true)
        {
            System.out.println("------------------------------------------------------------------");
            System.out.println("---------------------- Marvellous ParkEngine ---------------------");
            System.out.println("------------------------------------------------------------------"); 

            System.out.println("1 : Park Vehicle");
            System.out.println("2 : Exit Vehicle");
            System.out.println("3 : Search Vehicle");
            System.out.println("4 : Display Parking Lot");
            System.out.println("5 : Exit");

            System.out.println("Enter your choice : ");

            iChoice = sobj.nextInt();

            try 
            {
                switch(iChoice)
                {
                    case 1 : // Park Vehicle
                    {
                        System.out.println();

                        System.out.println("Select vehicle type : ");
                        System.out.println("1 : Bike");
                        System.out.println("2 : Car");
                        System.out.println("3 : Truck");

                        int type = sobj.nextInt();

                        System.out.println("Enter vehicle number : ");
                        String number = sobj.next();

                        Vehicle vehicle;

                        // Factory Pattern is used 
                        switch(type)
                        {
                            case 1 : // BIKE
                                vehicle = VehicleFactory.createVehicle(VehicleType.BIKE, number);
                                break;
                            
                            case 2 : // CAR
                                vehicle = VehicleFactory.createVehicle(VehicleType.CAR, number);
                                break;
                            
                            case 3 : //TRUCK
                                vehicle = VehicleFactory.createVehicle(VehicleType.TRUCK, number);
                                break;
                            
                            default :
                                System.out.println("Invalid type of vehicle");
                                continue;
                        }

                        // Park the vehicle and generate the ticket
                        ParkingTicket ticket = parkingLot.parkVehicle(vehicle, entryGate);

                        // Display generated ticket
                        ticket.displayTicket();

                        break;
                    } // End of case 1

                    case 2 : // Exit Vehicle
                    {
                        System.out.println("Enter TicketNumber :");

                        int ticketNumber = sobj.nextInt();

                        System.out.println();
                        System.out.println("Enter the payment option : ");
                        System.out.println("1 : Cash Payment");
                        System.out.println("2 : UPI Payment");
                        System.out.println("3 : Card Payment");

                        int paymentType = sobj.nextInt();

                        PaymentStrategy paymentStrategy;

                        switch(paymentType)
                        {
                            case 1 : // Cash Payment
                            {
                                paymentStrategy = new CashPayment();
                                break;
                            }

                            case 2 : // UPI Payment
                            {
                                paymentStrategy = new UPIPayment();
                                break;
                            }

                            case 3 : // Card Payment
                            {
                                paymentStrategy = new CardPayment();
                                break;
                            }

                            default :
                                System.out.println("Invalid Payment option");
                                continue;
                        } // End of Payment Switch

                        parkingLot.removeVehicle(ticketNumber, exitGate, paymentStrategy);

                        break;
                    }

                    case 3 : // Search Vehicle
                    {
                        System.out.println("Enter Vehicle Number : ");

                        String vehicleNumber = sobj.next();

                        ParkingTicket ticket = parkingLot.searchVehicle(vehicleNumber);

                        if(ticket == null)
                        {
                            System.out.println("This vehicle is not parked");
                        }
                        else 
                        {
                            ticket.displayTicket();
                        }

                        break;
                    }

                    case 4 : // Display Parking Lot
                    {
                        parkingLot.displayParkingLot();

                        break;
                    }

                    case 5 :
                    {
                        System.out.println("Thank you for using Marvellous ParkEngine");

                        sobj.close();

                        return;
                    }

                    default :
                    {
                        System.out.println("Invalid Option");
                    }

                } // End of switch
            } // End of try
            catch(Exception eobj)
            {
                System.out.println("Exception occured : "+eobj);
            } // End of catch

        } // End of while

    } // End of main
} // End of main class