//Created by Mike Dawicki- 111641998
//CIS 331- Section 1
//Assignment #7
//My submission of this program is of compliance with the JMU Honor code
package assignment7;


public class Video extends Product {
    
    //class member varaibles 
    private String movieType;
    private String movieRate;
    private int movieRT;
    private String movieActors;

    //default constructor
    Video() {
        //calls the super class default constructor 
        super();
        movieType = "Comedy";
        movieRate = "Not Rated";
        movieRT = 0;
        movieActors = "Actors";
    }
    //overloaded constructor that takes parameters 
    Video(String movieName, String movieDesc, int movieQuan, double moviePrice, String movieType, String movieRate, int movieRT, String movieActors) {
        //calls the super class overloaded constructor
        super(movieName, movieDesc, movieQuan, moviePrice);
        //calls set methods for each member variable 
        setMovieType(movieType);
        setMovieRate(movieRate);
        setMovieRT(movieRT);
        setMovieActors(movieActors);
    }

    //method that sets the movie type 
    public void setMovieType(String type) {

        //checks for one of the following movie types and assigns the type to the member variable accordingly 
        if (type.compareToIgnoreCase("Comedy") == 0) {
            movieType = "Comedy";
        } else if (type.compareToIgnoreCase("Drama") == 0) {
            movieType = "Drama";
        } else if (type.compareToIgnoreCase("Action") == 0) {
            movieType = "Action";
        } else if (type.compareToIgnoreCase("Documentary") == 0) {
            movieType = "Documentary";
        } else {
            movieType = "Comedy";
        }
    }

    //method that sets the movie rate 
    public void setMovieRate(String rate) {

        //checks for one of the following movie rates and assigns the rate to the member variable accordingly 
        if (rate.compareToIgnoreCase("G") == 0) {
            movieRate = "G";
        } else if (rate.compareToIgnoreCase("PG") == 0) {
            movieRate = "PG";
        } else if (rate.compareToIgnoreCase("PG-13") == 0) {
            movieRate = "PG=13";
        } else if (rate.compareToIgnoreCase("R") == 0) {
            movieRate = "R";
        } else {
            movieRate = "Not Rated";
        }
    }

    //method that sets the movie running time 
    public void setMovieRT(int time) {

        //checks to see if the valued passed is a valid movie running time 
        if (time >= 30 && time <= 500) {
            movieRT = time;
        } else {
            if (time > 500) {
                movieRT = 500;
            } else if (time < 30) {
                movieRT = 30;
            }
        }
    }

    //method that sets the movie actors 
    public void setMovieActors(String actor) {

        movieActors = actor;
    }
    
    //returns the movie type
    public String getMovieType() {
        return movieType;
    }
    //returns the movie rate
    public String getMovieRate() {
        return movieRate;
    }
    //returns the movie running time
    public int getMovieRT() {
        return movieRT;
    }
    //returns the movie actors 
    public String getMovieActors() {
        return movieActors;
    }
    
    //overriden toString method 
    @Override
    public String toString() {
        return "Video";
    }
    
    //method that checks to see what movies the actor plays in 
    public static String listVideoStarring(String star) {
        
        //variable holds the movie actors for each product 
        String movieActors = "";     
        //variable holds the movie actors returned 
        String movieStars = "";
        
        //loops through the product array
        for (int i = 0; i < products.length; i++) {
            if (products[i] instanceof Video) {                                         //checks to see if the product is instance of a video 
                String starLowerCase = star.toLowerCase();                                  //puts the user input into all lower case 
                movieActors = ((Video)products[i]).getMovieActors().toLowerCase();      //calls the get movie actors method 
                if (movieActors.contains(starLowerCase)) {                                  //checks to see if the star exists 
                    movieStars += products[i].getProductName() + "\n";                  //adds the movie name of the movie the actor is in 
                }
            } 
              
        }
        return movieStars;
    }
    
    //creates and adds a video product to the array 
    public static boolean addVideo(String movieName, String movieDesc, int movieQuan, double moviePrice, String movieType, String movieRate, int movieRT, String movieActors) {
        
        
      for (int i = 0; i < products.length; i++) {                                                                                             
            if (products[i] == null) {                                                                                                        //checks for an element in the array with no value
                products[i] = new Video(movieName, movieDesc, movieQuan, moviePrice, movieType, movieRate, movieRT, movieActors);             //creates a video object and is added into array 
                totProducts++;                                                                                                                //adds 1 to the total products member variable 
                return true;
            }
        }
        return false;
    } 
    
    //overriden full data method 
    @Override
    public String fullData(boolean data) {
        
        //calls the super class full data method 
        String videoData = super.fullData(data);
        
        //adds the additional member variables 
        videoData += ("\nMovie type: " + movieType +
                     "\nRunning Time: " + movieRT +
                     "\nRating: " + movieRate +
                     "\nStars: " + movieActors);
        
        return videoData; 
    }
      
}
