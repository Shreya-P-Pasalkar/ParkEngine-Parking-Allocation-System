////////////////////////////////////////////////////////////////////////////////////////////////////
//  Required Header  
////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 8 : Create ParkingStrategy class
//  It is used to create a class ParkingStategy which is responsible to decide the Parking spot 
//  selection.
//  Concepts : Strategy Design Pattern
////////////////////////////////////////////////////////////////////////////////////////////////////

// Selects the first available parking spot 
class FirstAvailableParkingStrategy implements ParkingStrategy
{
    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle)
    {
        // Iterate over all available floors
        for(ParkingFloor floor : floors)
        {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);

            if(spot != null)
            {
                return spot;
            }
        }

        return null;
    }
} // End of FirstAvailableParkingStrategy