import java.util.Date;
import java.util.Scanner;

public class Store {
    private Product[] productsInStore;
    //    private Customer[] customers;
//    private Worker[] workers;
    private User[] users;

//    public Store(Product[] productsInStore,Customer[] customers) {
//        this.productsInStore = productsInStore;
//        this.customers=customers;
//        this.workers=workers;
//        if (customers!=null) {
//            for (int i = 0; i < customers.length; i++) {
//                identifyWorkers(customers[i]);
//            }
//        }
//  }

//    public void identifyWorkers(Customer suspectedWorker){
//        if((Worker)suspectedWorker instanceof Worker){
//                    addWorker((Worker) suspectedWorker);
//                }
//            }


//    public void addWorker(Worker workerToAdd) {
//        Worker[] newArray;
//        if (workers != null) {
//            newArray = new Worker[workers.length + 1];
//            for (int i = 0; i < workers.length; i++) {
//                newArray[i] = workers[i];
//            }
//            newArray[workers.length] = workerToAdd;
//        } else {
//            newArray = new Worker[1];
//            newArray[0] = workerToAdd;
//        }
//        this.workers = newArray;
//    }

//    public void addCustomer(Customer customerToAdd) {
//        Customer[] newArray;
//        if (customers != null) {
//            newArray = new Customer[customers.length + 1];
//            for (int i = 0; i < customers.length; i++) {
//                newArray[i] = customers[i];
//            }
//            newArray[customers.length] = customerToAdd;
//        } else {
//            newArray = new Customer[1];
//            newArray[0] = customerToAdd;
//        }
//        //  identifyWorkers(customerToAdd);
//        this.customers = newArray;
//    }

    public void addUser(User userToAdd) {
        User[] newArray;
        if (users != null) {
            newArray = new User[users.length + 1];
            for (int i = 0; i < users.length; i++) {
                newArray[i] = users[i];
            }
            newArray[users.length] = userToAdd;
        } else {
            newArray = new User[1];
            newArray[0] = userToAdd;
        }
        this.users = newArray;
    }

    public Product[] getProductsInStore() {
        return productsInStore;
    }

    public void addToItems(Product productToAdd) {
        Product[] newArray;
        if (productsInStore != null) {
            newArray = new Product[productsInStore.length + 1];
            for (int i = 0; i < productsInStore.length; i++) {
                newArray[i] = productsInStore[i];
            }
            newArray[productsInStore.length] = productToAdd;
        } else {
            newArray = new Product[1];
            newArray[0] = productToAdd;
        }
        this.productsInStore = newArray;
    }

    public boolean doesItContainDigits(String stringSuspectedInContainingDigits) {
        boolean doesItContainDigit = false;
        for (int i = 0; i < stringSuspectedInContainingDigits.length(); i++) {
            doesItContainDigit = Character.isDigit(stringSuspectedInContainingDigits.charAt(i));
            if (!doesItContainDigit) {
                break;
            }
        }
        return doesItContainDigit;
    }

    public String keepAskingUntilThereIsNoDigits(String answer) {
        Scanner scanner = new Scanner(System.in);
        boolean processSucceed = false;
        boolean didItFailOnce = false;
        while (!processSucceed) {
            processSucceed = false;
            if (didItFailOnce) {
                System.out.println("invalid input... try again, this time without digits...");
                answer = scanner.nextLine();
            }
            if (!doesItContainDigits(answer)) {
                processSucceed = true;
            } else {
                processSucceed = false;
                didItFailOnce = true;
            }
        }
        return answer;
    }

    public void createAccount() {
        final int CREATE_ACCOUNT = 2;
        Scanner scanner = new Scanner(System.in);
        User currentUser = workerOrCustomer(CREATE_ACCOUNT);
        System.out.println("please enter you're first name: ");
        String firstNameAnswer = scanner.nextLine();
        firstNameAnswer = keepAskingUntilThereIsNoDigits(firstNameAnswer);
        currentUser.setFirstName(firstNameAnswer);
        System.out.println("please enter you're last name: ");
        String lastName = scanner.nextLine();
        lastName = keepAskingUntilThereIsNoDigits(lastName);
        currentUser.setLastName(lastName);
        boolean isOriginal = true;
        boolean didItFailOnce = false;
        System.out.println("please enter a username: ");
        String usernameAnswer = scanner.nextLine();
        do {
            if (users != null) {
                if (didItFailOnce) {
                    System.out.println("this username is already taken, please try something else...");
                    usernameAnswer = scanner.nextLine();
                }
                isOriginal = true;
                for (int i = 0; i < users.length; i++) {
                    if (usernameAnswer.equals(users[i].getUsername())) {
                        isOriginal = false;
                        didItFailOnce = true;
                    }
                }
            } else {
                isOriginal = true;
            }
        } while (!isOriginal);
        currentUser.setUsername(usernameAnswer);
        System.out.println("please enter a password: ");
        String passwordAnswer = scanner.nextLine();
        boolean isItAtLeastSixCharters = false;
        didItFailOnce = false;
        while (!isItAtLeastSixCharters) {
            if (didItFailOnce) {
                System.out.println("please enter a password that is at least 6 charters long...");
                passwordAnswer = scanner.nextLine();
            }
            if (passwordAnswer.length() >= 6) {
                isItAtLeastSixCharters = true;
            } else {
                isItAtLeastSixCharters = false;
                didItFailOnce = true;
            }
        }
        currentUser.setPassword(passwordAnswer);
        if (currentUser instanceof Worker) {
            final int REGULAR_WORKER = 1;
            final int MANGER = 2;
            final int ADMINISTRATION_CREW_MEMBER = 3;
            System.out.println("what is you're worker-rank? ");
            int rankAnswer = scanner.nextInt();
            scanner.nextLine();
            didItFailOnce = false;
            boolean isItValid = false;
            while (!isItValid) {
                if (didItFailOnce) {
                    System.out.println("please enter a valid rank...");
                    rankAnswer = scanner.nextInt();
                    scanner.nextLine();
                }
                if (rankAnswer == REGULAR_WORKER || rankAnswer == MANGER || rankAnswer == ADMINISTRATION_CREW_MEMBER) {
                    isItValid = true;
                } else {
                    didItFailOnce = true;
                    isItValid = false;
                }
            }
            ((Worker) currentUser).setWorkerRank(rankAnswer);
        } else {
            final int YES = 1;
            System.out.println("are you a member of the customer club? enter 1 for yes and any other whole number for no: ");
            int customerClubStatusAnswer = scanner.nextInt();
            scanner.nextLine();
            boolean isInCustomerClub = false;
            if (customerClubStatusAnswer == YES) {
                isInCustomerClub = true;
            } else {
                isInCustomerClub = false;
            }
            ((Customer) currentUser).setInCustomerClub(isInCustomerClub);
        }
        addUser(currentUser);
    }

    public User workerOrCustomer(int logInOrCreate) {
        final int LOGIN = 1;
        final int CREATE_ACCOUNT = 2;
        Scanner scanner = new Scanner(System.in);
        User enteredUser;
        if (logInOrCreate == LOGIN) {
            System.out.println("to log in- please enter 1 if you're a customer and any other whole number if you're a worker");
        } else {
            System.out.println("enter 1 if you're a customer and any other whole number if you're a worker");
        }
        int userTypeAnswer = scanner.nextInt();
        scanner.nextLine();
        if (userTypeAnswer == 1) {
            enteredUser = new Customer();
        } else {
            enteredUser = new Worker();
        }
        return enteredUser;
    }

    public User login() {
        final int LOGIN = 1;
        Scanner scanner = new Scanner(System.in);
        User enteredUser = workerOrCustomer(LOGIN);
        System.out.println("please enter your username: ");
        String usernameEntered = scanner.nextLine();
        System.out.println("please enter your password: ");
        String passwordEntered = scanner.nextLine();
        User matchingUser;
        if (enteredUser instanceof Worker) {
            matchingUser = new Worker();
        } else {
            matchingUser = new Customer();
        }
        matchingUser = null;
        if (users != null) {
            for (int i = 0; i < users.length; i++) {
                if (((enteredUser instanceof Worker) == (users[i] instanceof Worker)) && (users[i].getUsername().equals(usernameEntered)) && (users[i].getPassword().equals(passwordEntered))) {
                    {
                        matchingUser = users[i];
                    }
                }
            }
        }
        return matchingUser;
    }

    public void makeAPurchase(User buyer) {
        Scanner scanner = new Scanner(System.in);
        boolean endPurchase = false;
        ShoppingCart shoppingCart = new ShoppingCart();
        while (!endPurchase) {
            Product[] availableProducts = printAndGetAvailableProducts();
            if (availableProducts == null) {
                System.out.println("sorry there's available products right now please check in later ");
                endPurchase = true;
            } else {
                System.out.println("enter the number listed above according to the wanted product, to end the purchase enter -1 ");
                int wantedActionOrProduct = scanner.nextInt();
                scanner.nextLine();
                if (wantedActionOrProduct == -1) {
                    endPurchase = true;
                } else {
                    if (wantedActionOrProduct >= availableProducts.length || ((wantedActionOrProduct <= 0) && (wantedActionOrProduct != (-1)))) {
                        System.out.println("please try a valid number next time...");
                    } else {
                        System.out.println("enter desired amount of: " + availableProducts[wantedActionOrProduct].getProductTitle());
                        int enteredAmount = scanner.nextInt();
                        scanner.nextLine();
                        if (enteredAmount <= 0) {
                            System.out.println("next time enter a positive number... item not added to cart!");
                        } else {
                            ProductAndAmount chosenProductAndAmount = new ProductAndAmount(availableProducts[wantedActionOrProduct-1], enteredAmount);
                            shoppingCart.addProduct(chosenProductAndAmount, buyer);
                            System.out.println(shoppingCart.toString());
                            System.out.println(" ");
                        }
                    }
                }
            }
        }
        System.out.println("final price: " + shoppingCart.getCollectivePrice());
        buyer.setCollectiveSpendingCount(buyer.getCollectiveSpendingCount() + shoppingCart.getCollectivePrice());
        Date dateOfPurchase = new Date();
        buyer.setDateOfLastPurchase(dateOfPurchase);
        buyer.setNumberOfPurchases(buyer.getNumberOfPurchases() + 1);
    }

    public Product[] printAndGetAvailableProducts() {
        Product[] temp;
        Product[] availableProducts;
        int size = 0;
        if (productsInStore != null) {
            temp = new Product[productsInStore.length];
            for (int i = 0; i < productsInStore.length; i++) {
                if (productsInStore[i].isInStock()) {
                    temp[size] = productsInStore[i];
                    size++;
                    System.out.println(size + ". " + productsInStore[i]);
                }
            }
            availableProducts = new Product[size];
            for (int i = 0; i < size; i++) {
                availableProducts[i] = temp[i];
            }
        } else {
            temp = null;
            availableProducts=null;
        }

        return availableProducts;
    }

    public void printAllCustomers() {
        System.out.println("list of customers including workers: ");
        printArrayOfUsers(users);
    }

    public void printClubMembers() {
        User[] emptyArray = null;
        User[] temp;
        User[] clubMembers;
        if (users == null) {
            printArrayOfUsers(emptyArray);
        } else {
            temp = new User[users.length];
            int size = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] instanceof Customer) {
                    if ((((Customer) users[i]).isInCustomerClub())) {
                        temp[size] = users[i];
                        size++;
                    }
                }
            }
            clubMembers = new Customer[size];
            for (int i = 0; i < size; i++) {
                clubMembers[i] = temp[i];
            }
            printArrayOfUsers(clubMembers);
        }
    }

    public void printUsersThatMadeAPurchase() {
        User[] emptyArray = null;
        User[] temp;
        User[] madeAPurchase;
        if (users == null) {
            printArrayOfUsers(emptyArray);
        } else {
            temp = new User[users.length];
            int size = 0;
            for (int i = 0; i < users.length; i++) {
                if ((users[i].getNumberOfPurchases() > 0)) {
                    temp[size] = users[i];
                    size++;
                }
            }
            madeAPurchase = new User[size];
            for (int i = 0; i < size; i++) {
                madeAPurchase[i] = temp[i];
            }
            printArrayOfUsers(madeAPurchase);
        }
    }

    public void printArrayOfUsers(User[] arrayToPrint) {
        if (arrayToPrint == null) {
            System.out.println("there is no relevant data in the system matching your request");
        } else {
            for (int i = 0; i < arrayToPrint.length; i++) {
                System.out.println("  " + arrayToPrint[i].toString());
                if (i < arrayToPrint.length - 1) {
                    System.out.println("**********************************************");
                }
                else {
                    System.out.println(" ");
                }
            }
        }
    }

    public void printMostSpendingUser() {
        if (users == null) {
            System.out.println("there are no users in the system");
        } else {
            User bestSpender = users[0];
            for (int i = 1; i < users.length; i++) {
                if (bestSpender.getCollectiveSpendingCount() < users[i].getCollectiveSpendingCount()) {
                    bestSpender = users[i];
                }
            }
            System.out.println(bestSpender.toString());
        }
    }

    public void addItemToStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter product's title: ");
        String enteredProductTitle = scanner.nextLine();
        System.out.println("please enter product's price: ");
        double enteredPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("please the percentage of discount that customers club members will get: ");
        double enteredPercentageOfDiscountToClubMembers = scanner.nextDouble();
        scanner.nextLine();
        Product productToAdd = new Product(enteredProductTitle, enteredPrice, enteredPercentageOfDiscountToClubMembers);
        addToItems(productToAdd);
        System.out.println("product added successfully! ");
    }

    public void changeStockStatus() {
        Scanner scanner = new Scanner(System.in);
        if (productsInStore != null) {
            System.out.println("please choose a product to modify its status according to the list below (enter the listed number attached to it) : ");
            for (int i = 0; i < productsInStore.length; i++) {
                System.out.println((i+1) + ". " + productsInStore[i].toString());
            }
            int chosenIndex = scanner.nextInt()-1;
            scanner.nextLine();
            System.out.println("please enter the stock status of " + productsInStore[chosenIndex].getProductTitle() + " (enter 1 for 'in stock' and any other whole number for 'out of stock') :");
            int enteredStockStatus = scanner.nextInt();
            scanner.nextLine();
            boolean booleanStockStatus = false;
            if (enteredStockStatus == 1) {
                booleanStockStatus = true;
            }
            productsInStore[chosenIndex].setInStock(booleanStockStatus);
            System.out.println("stock status changed successfully! ");
        } else {
            System.out.println("There are no items in the store yet...");
        }
    }
}
