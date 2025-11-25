import java.util.Enumeration;

public class HtmlStatement extends Statement {

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
      return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
   }

   protected String eachRentalString(Rental aRental) {
      return aRental.getMovie().getTitle() + ": " +
             aRental.getCharge() + "<BR>\n";
   }

   protected String footerString(Customer aCustomer) {
      return "<P>You owe <EM>" + aCustomer.getTotalCharge() + "</EM><P>\n" +
             "On this rental you earned <EM>" +
             aCustomer.getTotalFrequentRenterPoints() +
             "</EM> frequent renter points<P>";
   }
}
