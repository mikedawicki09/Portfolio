//Created by Mike Dawicki- 111641998
//CIS 331- Section 1
//Assignment #7
//My submission of this program is of compliance with the JMU Honor code
package assignment7;

import java.util.Scanner;
import java.io.*;
import java.text.*;

public class ProductApplication {

    public static void main(String[] args) {
        
        //formats number into currency
        NumberFormat dollar = NumberFormat.getCurrencyInstance();

        //create a scanner object
        Scanner input = new Scanner(System.in);

        try {
            //holds the value of users selection 
            int userInput = 0;

            //loops the programs menu 
            do {

                System.out.println("\nWelcome to the user menu.");
                System.out.println("Enter a number for your choice: "
                        + "\n\t1) Read Product File "
                        + "\n\t2) List Products and Show Total Inventory Value "
                        + "\n\t3) Display Product Information "
                        + "\n\t4) List videos with a given star "
                        + "\n\t5) Show Graph of Inventory Values "
                        + "\n\t6) Quit ");
                System.out.println("What is your choice? ");
                userInput = input.nextInt();
                switch (userInput) {
                    //reads the product file 
                    case 1:
                        System.out.println("Enter Product File: ");
                        String fileObject = new Scanner(System.in).next();                          //holds user input
                        boolean fileStatus = readProducts(fileObject);                              //calls the read product method 
                        if (fileStatus) {                                                           //checks the status of the file being read 
                            System.out.println("\nFile read Successfully. ");
                        } else {
                            System.out.println("\nError while reading file. ");
                        }
                        break;
                    //lists the products and displays the total inventory value 
                    case 2:
                        System.out.println("\nProducts: ");
                        System.out.println(Product.listProducts());                                                             //calls the list product method 
                        System.out.println("\nThe total inventory value is " + dollar.format(Product.totInventoryValue()));     //calls the total inventory value                                                    
                        break;
                    //displays the product information 
                    case 3:
                        System.out.println("Enter the name of the product: ");
                        String userProd = input.nextLine();                                             //holds user input                      
                        userProd += input.nextLine();   
                        int prodElement = Product.findProduct(userProd);                                //calls the find product method 
                        if (prodElement < 0) {                                                          //checks to see if product exists in the array 
                            System.out.println("\nProduct was not found. ");
                        } else {   
                            System.out.println(Product.getProduct(prodElement).fullData(true));         //prints out all the product information 
                        }   
                        break;
                    //displays the movies a given actor is in     
                    case 4: 
                        System.out.println("Enter the name of the star to search for ");
                        String inputStar = input.nextLine();                                            //holds user input 
                        inputStar += input.nextLine();      
                        String returnedActors = Video.listVideoStarring(inputStar);                     //calls the list video starring method
                        System.out.println("\nVideos starring " + inputStar);           
                        System.out.println(returnedActors);                                             //prints out the actors 
                        break;
                    case 5:
                        // set up data
                        int[] values = new int[Product.totProducts];                                //holds each products total value 
                        String[] labels = new String[Product.totProducts];                          //holds each products name 
                        String[] info = new String[Product.totProducts];                            //holds each products information
                        for (int i = 0; i < Product.products.length; i++) { 
                            if (Product.products[i] != null) {                                      //makes sure element in the array is not null
                                values[i] = (int)Product.products[i].totalValue();                  //calls the total value method
                                labels[i] = Product.products[i].getProductName();                   //calls the get product name method            
                                info[i] = Product.products[i].fullData(true);                       //get the get full data method 
                            }
                        }
                        BarChartFrame bcf = new BarChartFrame("Product Inventory Values ", values,labels, info);        //creates a barchart frame object
                       break;
                    //exits the program
                    case 6: 
                            System.out.println("Goodbye!");
                            System.exit(0);
                }
            } while (userInput != 6);

        } catch (Exception ex) {
            System.out.println("\nInvalid choice.");
        }

    }

    //method that reads the file contents into an array 
    public static boolean readProducts(String productFile) {
        
        //variable indicates if the file was read successfully
        boolean success = false;                                    
        try {
            File newFile = new File(productFile);                                                                //creates a file object
            Scanner prodFileContent = new Scanner(newFile);                                                      //creates a scanner object 

            //loops through the file 
            while (prodFileContent.hasNext()) {
                String prodType = prodFileContent.nextLine();                                                    //variable that holds the product type 
                String prodName = prodFileContent.nextLine();                                                    //varaible holds the product name 
                String prodDesc = prodFileContent.nextLine();                                                    //variable holds the product description 
                int prodQuan = prodFileContent.nextInt();                                                        //variable holds the product quantity
                double prodPrice = prodFileContent.nextDouble();                                                 //variable holds the product price  
                prodFileContent.nextLine();
                if (prodType.equalsIgnoreCase("Product")) {                                                      //checks to see what type of product it is                   
                    Product.addProduct(prodName, prodDesc, prodQuan, prodPrice);                                 //calls the add product method
                    success = true;
                } else if (prodType.equalsIgnoreCase("Video")) {
                    String movieType = prodFileContent.nextLine();                                               //variable holds the movie type
                    String movieRate = prodFileContent.nextLine();                                               //variable holds the movie rating 
                    int movieRT = prodFileContent.nextInt();                                                     //variable holds the movie time      
                    String movieActors = prodFileContent.nextLine();                                             //variable holds the movie actors 
                    movieActors += prodFileContent.nextLine();
                    Video.addVideo(prodName, prodDesc, prodQuan, prodPrice, movieType, movieRate, movieRT, movieActors);        //calls the add video method                  
                    success = true;
                } else if (prodType.equalsIgnoreCase("Automobile")) {;              
                    int year = prodFileContent.nextInt();                                                                       //variable holds the car year
                    String model = prodFileContent.nextLine();                                                                  //variable holds the car model
                    model += prodFileContent.nextLine();    
                    Automobile.addAutomobile(prodName, prodDesc, prodQuan, prodPrice, year, model);                             //calls the add automobile method                    
                    success = true;
                }      
            }            
        } catch (IOException ex) {
            return success;
        }       
       return success;
    }
}
