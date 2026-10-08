////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 9 : Create PricingStrategy class
//  It is used to create a class PricingStrategy 
//  It keeps the pricing algorithm independent of exit logic
//  Concepts : Strategy Design Pattern
////////////////////////////////////////////////////////////////////////////////////////////////////
class WeekendPricingStrategy implements PricingStrategy
{
    @Override
    public double calculatePrice(Vehicle vehicle, long hours)
    {
        if(hours <= 0)
        {
            hours = 1;
        }

        switch(vehicle.getVehicleType())
        {
            case BIKE :
                return hours*40;
            
            case CAR :
                return hours*100;

            case TRUCK :
                return hours*200;

            default :
                return 0;
        }
    }
} // End of WeekendPricingStrategy