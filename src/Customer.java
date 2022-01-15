public class Customer extends User {
    private boolean inCustomerClub;

    public Customer() {
        super();
    }
//    public Customer(String firstName, String lastName, String username, String password, int numberOfPurchases, boolean inCustomerClub, double collectiveSpending, Date dateOfLastPurchase) {
//        super(firstName, lastName, username, password, numberOfPurchases, collectiveSpending, dateOfLastPurchase);
//        this.inCustomerClub = inCustomerClub;
//    }


    public boolean isInCustomerClub() {
        return inCustomerClub;
    }

    public void setInCustomerClub(boolean inCustomerClub) {
        this.inCustomerClub = inCustomerClub;
    }


    public String toString() {
        return super.toString()+"\n" +
                "-is customer club member? " + inCustomerClub + "\n";

    }
}
