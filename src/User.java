import java.util.Date;

public abstract class User {

    private int numberOfPurchases;
    private double collectiveSpendingCount;
    private Date dateOfLastPurchase;
    private String firstName;
    private String lastName;
    private String password;
    private String username;

    public User() {

    }

//    public User(String firstName, String lastName, String username, String password, int numberOfPurchases, double collectiveSpending, Date dateOfLastPurchase) {
//        this.username = username;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//        this.numberOfPurchases = numberOfPurchases;
//        this.collectiveSpendingCount = collectiveSpending;
//        this.dateOfLastPurchase = dateOfLastPurchase;
//    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfLastPurchase() {
        return dateOfLastPurchase;
    }

    public void setDateOfLastPurchase(Date dateOfLastPurchase) {
        this.dateOfLastPurchase = dateOfLastPurchase;
    }

    public double getCollectiveSpendingCount() {
        return collectiveSpendingCount;
    }

    public void setCollectiveSpendingCount(double collectiveSpendingCount) {
        this.collectiveSpendingCount = collectiveSpendingCount;
    }

    public int getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(int numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }

    public String toString() {
        return "-full name: " + firstName + " " + lastName + " \n" +
                "-number of purchases: " + numberOfPurchases + "\n" +
                "-collective spending count: " + collectiveSpendingCount + "\n" +
                "-date of last purchase: " + dateOfLastPurchase;
    }
}
