import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        final int CREATE_AN_ACCOUNT = 1;
        final int LOGIN_TO_AN_EXISTING_ACCOUNT = 2;
        final int EXIT = 3;
        Store store = new Store();

        Scanner scanner = new Scanner(System.in);
        boolean finishProgram = false;
        int userChoice = 0;
        while (!finishProgram) {
            System.out.println("please enter the listed number of the action you want to make from the list below: \n" +
                    " 1. Create an account \n" +
                    " 2. Login to an existing account \n" +
                    " 3. Exit");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case CREATE_AN_ACCOUNT: {
                    store.createAccount();
                    break;
                }
                case LOGIN_TO_AN_EXISTING_ACCOUNT: {
                    User loggedInUser = store.login();
                    if (loggedInUser == null) {
                        System.out.println("there is no registered user with this combination of username, user type and password...");
                    } else {
                        if (loggedInUser instanceof Customer) {
                            System.out.println("Hello " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName() + " " + (((Customer) loggedInUser).isInCustomerClub() ? "(VIP)" : "") + "!");
                            store.makeAPurchase(loggedInUser);
                        } else {
                            System.out.println("Hello " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName() + " (" + ((Worker) loggedInUser).workerRankToString() + ")! ");
                            boolean logOut = false;
                            final int PRINT_ALL_CUSTOMERS = 1;
                            final int PRINT_CLUB_MEMBERS = 2;
                            final int PRINT_ALL_CUSTOMER_THAT_MADE_A_PURCHASE = 3;
                            final int PRINT_MOST_SPENDING_CUSTOMER = 4;
                            final int ADD_NEW_PRODUCT = 5;
                            final int STOCK_STATUS_UPDATE = 6;
                            final int MAKE_A_PURCHASE = 7;
                            final int LOG_OUT = 8;

                            while (!logOut) {
                                System.out.println("please enter the listed number of the action you want to make from the list below: " + "\n" +
                                        " 1. Print customer list (including workers) " + "\n" +
                                        " 2. Print customer club members list " + "\n" +
                                        " 3. Print customers that made a purchase (including workers) \n" +
                                        " 4. Print the Customer that has spent the most money in the store \n" +
                                        " 5. Add new product \n" +
                                        " 6. 'In stock' status modifications for a product \n" +
                                        " 7. Make a purchase \n" +
                                        " 8. Log out");
                                int workerChoice = scanner.nextInt();
                                scanner.nextLine();
                                switch (workerChoice) {
                                    case PRINT_ALL_CUSTOMERS: {
                                        store.printAllCustomers();
                                        break;
                                    }
                                    case PRINT_CLUB_MEMBERS: {
                                        store.printClubMembers();
                                        break;
                                    }
                                    case PRINT_ALL_CUSTOMER_THAT_MADE_A_PURCHASE: {
                                        store.printUsersThatMadeAPurchase();
                                        break;
                                    }
                                    case PRINT_MOST_SPENDING_CUSTOMER: {
                                        store.printMostSpendingUser();
                                        break;
                                    }
                                    case ADD_NEW_PRODUCT: {
                                        store.addItemToStore();
                                        break;
                                    }
                                    case STOCK_STATUS_UPDATE: {
                                        store.changeStockStatus();
                                        break;
                                    }
                                    case MAKE_A_PURCHASE: {
                                        store.makeAPurchase(loggedInUser);
                                        break;
                                    }
                                    case LOG_OUT: {
                                        logOut = true;
                                        break;
                                    }
                                }

                            }
                        }
                    }
                    break;
                }
                case EXIT: {
                    finishProgram = true;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
