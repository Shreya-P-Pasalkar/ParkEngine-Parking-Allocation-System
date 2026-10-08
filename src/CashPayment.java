////////////////////////////////////////////////////////////////////////////////////////////////////
//  Step 10 : Create PaymentStrategy class
//  It is used to create a class PaymentStrategy 
//  It supports different types of payment methods
//  Concepts : Strategy Design Pattern
////////////////////////////////////////////////////////////////////////////////////////////////////

class CashPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println("Cash Payment successful : Rs. "+amount);
    }

} // End of CashPayment