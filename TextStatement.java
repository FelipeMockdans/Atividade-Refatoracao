import java.util.Enumeration;

public class TextStatement extends Statement {

   public String value(Customer aCustomer) {
      String result = headerString(aCustomer);

      Enumeration rentals = aCustomer.getRentals();
      while (rentals.hasMoreElements()) {
         result += eachRentalString((Rental) rentals.nextElement());
      }

      result += footerString(aCustomer);

      return result;
   }

   protected String headerString(Customer aCustomer) {
      return "Rental Record for " + aCustomer.getName() + "\n";
   }

   protected String eachRentalString(Rental aRental) {
      return "\t" + aRental.getMovie().getTitle() + "\t" +
             aRental.getCharge() + "\n";
   }

   protected String footerString(Customer aCustomer) {
      return "Amount owed is " + aCustomer.getTotalCharge() + "\n" +
             "You earned " + aCustomer.getTotalFrequentRenterPoints() +
             " frequent renter points";
   }
}
