import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        String result = headerString(aCustomer);

        Enumeration rentals = aCustomer.getRentals();
        while (rentals.hasMoreElements()) {
            result += eachRentalString((Rental) rentals.nextElement());
        }

        result += footerString(aCustomer);

        return result;
    }

    protected abstract String headerString(Customer aCustomer);
    protected abstract String eachRentalString(Rental aRental);
    protected abstract String footerString(Customer aCustomer);
}
