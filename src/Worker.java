public class Worker extends User {
    private int workerRank;

    public Worker() {
        super();
    }

//    public Worker(String firstName, String lastName, String username, int numberOfPurchases, boolean inCustomerClub, double collectiveSpending, Date dateOfLastPurchase, String password, int workerRank) {
//        super(firstName, lastName, username, password, numberOfPurchases, collectiveSpending, dateOfLastPurchase);
//        this.workerRank = workerRank;
//    }

    public int getWorkerRank() {
        return workerRank;
    }

    public void setWorkerRank(int workerRank) {
        this.workerRank = workerRank;
    }

    public String workerRankToString() {
        final int REGULAR_WORKER = 1;
        final int MANGER = 2;
        final int ADMINISTRATION_CREW_MEMBER = 3;
        String workerRankToString = "";
        switch (workerRank) {
            case REGULAR_WORKER: {
                workerRankToString = "regular worker";
                break;
            }
            case MANGER: {
                workerRankToString = "manger";
                break;
            }
            case ADMINISTRATION_CREW_MEMBER: {
                workerRankToString = "administration crew member";
                break;
            }
        }
        return workerRankToString;
    }

    public String toString() {
        return super.toString() + " \n " +
                "-worker rank: " + workerRankToString() + " ";
    }
}
