//Created by Mike Dawicki- 111641998
//CIS 331- Section 1
//Assignment #7
//My submission of this program is of compliance with the JMU Honor code
package assignment7;

import java.text.NumberFormat;
import java.util.*;

class Product {

    //class member variables 
    private String productName;
    private String productDesc;
    private int quantity;
    private double unitPrice;

    //static member variables 
    protected static final int MAXPRODUCTS = 20;
    protected static Product[] products = new Product[MAXPRODUCTS];
    protected static int totProducts = 0;

    //constructor that sets default values and takes no parameters  
    Product() {
        productName = "PRODUCT";
        productDesc = "DESCRIPTION";
        quantity = 0;
        unitPrice = 0;
    }

    //constructor that takes parameters and calls the set methods 
    Product(String name, String desc, int amount, double price) {
        setProductDesc(desc);
        setQuantity(amount);
        setUnitPrice(price);
        setProductName(name);
    }

    //return product name 
    public String getProductName() {
        return productName;
    }

    //return product description 
    public String getProductDesc() {
        return productDesc;
    }

    //return quantity on hand 
    public int getQuantity() {
        return quantity;
    }

    //return unit price
    public double getUnitPrice() {
        return unitPrice;
    }

    //sets a new product name while capitalizing the first letter and makes the rest lowercase 
    public void setProductName(String name) {

        //holds the formated name 
        String combine = "";
        //splits the string at whitespaces 
        String[] words = name.split(" ");
        for (int i = 0; i < words.length; i++) {                                    //loops through each of the words 
            String upper = words[i].substring(0, 1).toUpperCase();                  //changes the first letter to a capital
            String lower = words[i].substring(1, words[i].length()).toLowerCase();  //changes the rest of the letters to lower case 
            combine += upper.concat(lower) + " ";                                    //combines the substrings 
        }
        productName = combine;
    }

    //sets a new product description
    public void setProductDesc(String desc) {
        productDesc = desc;
    }

    //sets a new quantity on hand
    public void setQuantity(int amount) {
        quantity = (amount >= 0) ? amount : 0;
    }

    //sets a new unit price
    public void setUnitPrice(double price) {
        unitPrice = (price >= 0) ? price : 0;
    }

    //method that returns all the information about the product 
    public String fullData(boolean data) {

        //formats number into currency
        NumberFormat dollar = NumberFormat.getCurrencyInstance();
    
        String allData = ("\nInfomation: " 
                + "\nProduct Type: " + toString()
                + "\nProduct Name: " + productName + "\n"                           //string that holds all the information
                + "Product Description: " + productDesc + "\n"
                + "Quantity on Hand: " + quantity + "\n"
                + "Unit Price: " + dollar.format(unitPrice) + "\n"
                + "Total Value: " + dollar.format((quantity * unitPrice)));
        if (data) {                                                                 //checks to see if data is true 
            return allData;
        } else {
            return getProductName();
        }

    }

    //method that checks if the string parameter matches the value of the products name
    public boolean equals(String equalName) {

        return equalName.equalsIgnoreCase(productName);
    }

    //method that returns the total value of the product 
    public double totalValue() {

        double totalPrice = (quantity * unitPrice);                                 //calculates the total value of the product

        return totalPrice;
    }

    //method to create a product object 
    public static boolean addProduct(String pName, String pDesc, int pQuan, double pPrice) {

        for (int i = 0; i < products.length; i++) {                                 
            if (products[i] == null) {                                              //checks for an element in the array with no value
                products[i] = new Product(pName, pDesc, pQuan, pPrice);             //creates a product object and is added into array 
                totProducts++;                                                      //adds 1 to the total products member variable 
                return true;
            }
        }
        return false;
    }

    //method that returns all of the products in the array
    public static String listProducts() {

        //holds the names of all the products 
        String productList = " ";

        for (int i = 0; i < products.length; i++) {                                 //loops through each product name in the array and adds them to a string 
            if (products[i] != null) {
                productList += "\t" + products[i].toString() + " " + products[i].getProductName() + "\n";
            }
        }
        return productList;
    }

    //method that checks to see if the users string matches an existing product 
    public static int findProduct(String userProdName) {

        
        //variable holds array element index 
        int returned = 0;
        //loops through the products array
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {  
                String prodName = products[i].getProductName().toLowerCase();                  //puts the product name into all lower case 
                String lowerCaseInput = userProdName.toLowerCase();                            //puts the user input into all lower case 
                if (prodName.contains(lowerCaseInput)) {                                       //checks to see if the user input matches an existing product
                    returned = i;
                    break;
                } else {
                    returned = -1;                  
                }

            }
        }
        return returned;
    }

    //returns the product in the specified element in the array 
    public static Product getProduct(int arrayElement) {

        return products[arrayElement];
    }

    //calculates the total inventory value 
    public static double totInventoryValue() {

        //format into currency 
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        //holds the total inventory value
        double totalProdValue = 0;

        //loops through the products array 
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {                                          //checks to make sure the value in the array is not null
                double prodValue = products[i].totalValue();                    //calls the total value method for each product in the array 
                totalProdValue += prodValue;                                    //adds the total value of each product together 
                nf.format(totalProdValue);
            }
        }
        return totalProdValue;
    }

    //overriden toString method
    @Override
    public String toString() {

        return "Product";
    }
}
