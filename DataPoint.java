// DataPoint.java
// If you chose to put it in a package when creating the file in NetBeans, 
// the first line might look something like: package com.aimodule.week2;
// Otherwise, you can just paste the code starting from 'public class DataPoint'.

public class DataPoint {
    // Features of our data point
    private double sweetness;
    private double colorIntensity;

    // The actual class/label of this data point (e.g., "Apple", "Orange")
    // For now, we'll keep it as a string, but in ML, it's often an integer.
    private String label; 

    //parameterized constructor
    public DataPoint(double sweetness, double colorIntensity, String label){
    this.sweetness = sweetness;
    this.colorIntensity = colorIntensity;
    this.label = label;
    }
    
    //getter methods
    public double getSweetness(){
        return sweetness;
    }
    
    public double getColorIntensity(){
        return colorIntensity;
    }
    
    public String getLabel(){
        return label;
    }
    
    @Override
    public String toString(){
    return "DataPoint: [sweetness: " + sweetness + ", color intensity: " + colorIntensity +  ", label: " + label + "]";
    }
    
    //Euclidean distance
    public double calculateDistance(DataPoint otherPoint){
    double diffInSweetness = otherPoint.getSweetness() - this.sweetness;
    double diffInColorIntensity = otherPoint.getColorIntensity() - this.colorIntensity;
    
    double squaredSweetness = diffInSweetness * diffInSweetness;
    double squaredColorIntensity = diffInColorIntensity * diffInColorIntensity;
    
    //Math.sqrt
    return Math.sqrt(squaredSweetness + squaredColorIntensity);
    }
    
   
    

    // The main method serves as the entry point for this program.
    // We're using it here to demonstrate how to create and print DataPoint objects.
    public static void main (String[] args){
    
        // Create example data points for different 'fruits'
        DataPoint apple1 = new DataPoint(0.8, 0.7, "Apple");
        DataPoint orange1 = new DataPoint(0.6, 0.9, "Orange");
        DataPoint apple2 = new DataPoint(0.75, 0.68, "Apple");
        
        
         // Create an 'unknown' fruit data point that we might want to classify later
        DataPoint unknownFruit = new DataPoint(0.7, 0.8, "Unknown"); 
        
        System.out.println(apple1);
        System.out.println(orange1);
        System.out.println(apple2);
        System.out.println(unknownFruit);
        
        double distApple1Orange1 = apple1.calculateDistance(orange1);
        System.out.println("Distance between apple1 and orange 1: " + String.format("%.4f", distApple1Orange1));
        
        double distApple1Apple2 = apple1.calculateDistance(apple2);
        System.out.println("Distance between Apple1 and Apple 2: " + String.format("%.4f", distApple1Apple2));
        
        
        double distUnknownApple1 = unknownFruit.calculateDistance(apple1);
        System.out.println("Distance between unknown and apple 1: " + String.format("%.4f", distUnknownApple1));
        
        
        double distUnknownOrange1 = unknownFruit.calculateDistance(orange1);
        System.out.println("Distance between unknown and orange 1: " + String.format("%.4f", distUnknownOrange1));
        
        
    }
    
}