//Created by Mike Dawicki- 111641998
//CIS 331- Section 1
//Assignment #7
//My submission of this program is of compliance with the JMU Honor code
package assignment7;

public class Automobile extends Product {

    //class member variables
    private int autoYear;
    private String autoModel;

    //default constructor 
    Automobile() {
        //calls the super class default constuctor 
        super();
        autoYear = 0;
        autoModel = "Model";
    }

    //overloaded constructor that takes parameters 
    Automobile(String autoName, String autoDesc, int autoQuan, double autoPrice, int autoYear, String autoModel) {

        //calls the super class overloaded constructor 
        super(autoName, autoDesc, autoQuan, autoPrice);
        //calls the set automobile model mutator method 
        setAutoModel(autoModel);
        setAutoYear(autoYear);

    }

    //sets the autmobile year and checks to make sure the year is valid 
    public void setAutoYear(int year) {

        //checks to see if the year is between 1950 and 2020
        if (year >= 1950 && year <= 2020) {
            autoYear = year;
        } else {
            autoYear = 0;
        }
    }

    //sets the automobile model and checks to make sure the model is valid 
    public void setAutoModel(String model) {

        //checks to make sure the parameter is not null
        if (model != null) {
            autoModel = model;
        } else {
            autoModel = "Unknown";
        }
    }

    //returns the automobile year 
    public int getAutoYear() {
        return autoYear;
    }

    //returns the automobile model
    public String getAutoModel() {
        return autoModel;
    }

    //overriden toString method 
    @Override
    public String toString() {
        return "Automobile";
    }

    //overriden full data method 
    @Override
    public String fullData(boolean autoData) {
        
        //calls the super class full data method 
        String prodInfo = super.fullData(autoData);
        
        //adds the additional member variables 
        prodInfo += ("\nYear: " + autoYear + 
                     "\nModel: " + autoModel);

        return prodInfo;
    }

    //creates and adds a automobile product to the array 
    public static boolean addAutomobile(String pName, String pDesc, int pQuan, double pPrice, int year, String model) {

        for (int i = 0; i < products.length; i++) {                                             
            if (products[i] == null) {                                                              //checks for an element in the array with no value
                products[i] = new Automobile(pName, pDesc, pQuan, pPrice, year, model);             //creates a automobile object and is added into array 
                totProducts++;                                                                   //adds 1 to the total products member variable 
                return true;
            }
        }
        return false;
    }
}
