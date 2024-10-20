package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        int indx1 = coord1.indexOf(","); // finds index of comma to find where x ends and y begins
        x1 = Integer.parseInt(coord1.substring(1,indx1));  // takes a substring of just the variable value
        y1 = Integer.parseInt(coord1.substring(indx1+1,coord1.length()-1));  // parses that substring into an int value to store
        int indx2 = coord2.indexOf(",");
        x2 = Integer.parseInt(coord2.substring(1,indx2)); 
        y2 = Integer.parseInt(coord2.substring(indx2+1,coord2.length()-1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;} // returns the variable value
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int num){x1 = num;} // takes a parameter for new value number and replaces the variable value with the new one
    public void setY1(int num){y1 = num;}
    public void setX2(int num){x2 = num;}
    public void setY2(int num){y2 = num;}


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow(x2 - x1,2)+Math.pow(y2 - y1,2)); // distance formula
        return roundedToHundredth(distance); // returns distance rounded to the nearest hundredth 
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if (slope() == -999.99) {return -999.99;} // checks if slope is undefined b/c then yInt would be too
        double yint = (slope()* -x1) + y1; // uses slope method to calculate y int
        return roundedToHundredth(yint); // returns yint rounded to nearest hundredth
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if (x1 == x2){return -999.99;} // slope is undefined when x2 - x1 = 0 which means x2 = x1
        double slope = (double) (y2 - y1) / (x2 - x1); // slope formula
        return roundedToHundredth(slope); // returns slope rounded to nearest hundredth
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99) {return "undefined" ;} // checks if slope is undefined and if so returns undefined
        String eqn = "y="; // concatenates tgt the eqn string by calling to other methods
        if (slope() != 0.0) { // if slope is not equal to 0, it will append the slope(x)
            eqn += slope() + "x"; // to prevent 0.0x
        }
        if (yInt() != 0.0) { // if yInt is just 0, it wont append otherwise, it will
            if (slope() != 0.0) {
                if (yInt() > 0) {
                    eqn += "+";
                }
            }
            eqn += yInt();
        }
        return eqn; // returns the string equation
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return (Math.round(x * 100.0) / 100.0); // Math.round() method 
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below


    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")"; // initalizes string to have the first coordinate in coord form
        str += " and " + "(" + x2 + "," + y2 + ")"; // second coord
        str += "\nThe equation of the line between these points is: " + equation() ; // concatenates the equation of the line by calling to eqn method
        str += "\nThe slope of this line is: " + slope(); // concatenates the slope using slope method
        str += "\nThe y-intercept of the line is: " + yInt() ; // concatenates the yInt by using yInt method
        str += "\nThe distance between the two points is: " + distance(); // concatenates distance using distance method
        str += "\n" + findSymmetry();
        str += "\n" + Midpoint();

        return str;
    }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        String str = "";
        if ((x1 == x2)&&(y1 == -y2)) {
            str = "x-axis";
        }
        else if ((x1 == -x2)&&(y1 == y2)) {
            str = "y-axis";
        }
        else if ((x1 == -x2)&&(y1 == -y2)) {
            str = "origin";
        }
        if (str.equals("")) {
            str = "No symmetry";
        }
        else {
            str = "Symmetric about the " + str;
        }
        return str;
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        double x = (x1 + x2)/2.0;
        double y = (y1 + y2)/2.0;
        return "The midpoint of this line is: (" + x + "," + y + ")";
    }

}



