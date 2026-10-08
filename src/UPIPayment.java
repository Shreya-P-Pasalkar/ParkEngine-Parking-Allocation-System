////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 10 : Create PaymentStrategy class
//  It is used to create a class PaymentStrategy 
//  It supports different types of payment methods
//  Concepts : Strategy Design Pattern
////////////////////////////////////////////////////////////////////////////////////////////////////

class UPIPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("UPI Payment successful : Rs. "+amount);
    }

} // End of UPIPayment