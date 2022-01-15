public class ShoppingCart {
    private ProductAndAmount[] itemsInShoppingCart;
    private double collectivePrice;

    public void addProduct(ProductAndAmount productToAdd, User buyer) {
        boolean continueToAddToItems = true;
        if (itemsInShoppingCart != null) {
            for (int i = 0; i < itemsInShoppingCart.length; i++) {
                if (itemsInShoppingCart[i] == productToAdd) {
                    continueToAddToItems = false;
                    break;
                }
            }
        } else {
            continueToAddToItems = true;
        }
        if (continueToAddToItems) {
            addToItems(productToAdd, buyer);
        }
    }

    private void addToItems(ProductAndAmount productToAdd, User buyer) {
        ProductAndAmount[] newArray;
        if (itemsInShoppingCart != null) {
            newArray = new ProductAndAmount[itemsInShoppingCart.length + 1];
            for (int i = 0; i < itemsInShoppingCart.length; i++) {
                newArray[i] = itemsInShoppingCart[i];
            }
            newArray[itemsInShoppingCart.length] = productToAdd;
        } else {
            newArray = new ProductAndAmount[1];
            newArray[0] = productToAdd;
        }
        this.itemsInShoppingCart = newArray;
        this.collectivePrice = collectivePrice + ((productToAdd.getProduct().getPrice(buyer)) * productToAdd.getAmount());
    }

    public double getCollectivePrice() {
        return collectivePrice;
    }

    public ProductAndAmount[] getItemsInShoppingCart() {
        return itemsInShoppingCart;
    }

    public String toString() {
        String returnedString = "";
        for (int i = 0; i < itemsInShoppingCart.length; i++) {
            returnedString = returnedString + itemsInShoppingCart[i].toString() + " \n";
        }
        returnedString = returnedString + "-Shopping cart price: " + collectivePrice;
        return returnedString;
    }
}
