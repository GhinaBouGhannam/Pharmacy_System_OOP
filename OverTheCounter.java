/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */

/**
 * Course : CSIS215.
 * Object Oriented Programming Project composed of five files. 
 * Current File : OverTheCounter.java 
 * Purpose : The purpose of this class is to create overTheCounter 
 * objects by using superclass Medicine 
 * Methods :  OverTheCounter constructor to create prescription  object.
 * Another OverTheCounter constructor takes less variables(set other default)
 * getMinAge to return minimum age for medicine to allow to be given
 * setMinAge takes string to change minimum age for medicine
 * toString  returns string of all information of overTheCounter object
 */

package OOP_Project;

/**
 * 
 * The class OverTheCounter is an extension of the Medicine Class that adds 
 * more details about the medicine object
 *  
 * @author Ghina Bou Ghannam
 */
public class OverTheCounter extends Medicine {
    
    /**
     * variable minAge represents the minimum age for this medicine 
     * to allow to be given
     */
    private int minAge = 18;
    
    /**
     * ... argument constructor OverTheCounter takes name , composition , dose,
     * quantity, price to create instance of the parent class medicine by 
     * calling medicine class constructor using super keyword and adds the 
     * minAge by using setMinAge method
     * @param name  represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     * @param quantity represents quantity of medicine
     * @param minAge the minimum age for this medicine to allow to be given
     * @param price represents price of medicine
     */
    public OverTheCounter(String name, String composition, int dose, 
            double price, int quantity, int minAge) {
        super(name, composition, dose, price, quantity);
        setMinAge(minAge);
    }
    
    /**
     * ..argument constructor OverTheCounter takes String name, String 
     * composition, int dose, int minAge to create an instance of the parent 
     * class, OverTheCounter by calling another constructor and setting the 
     * other data fields to default values
     * @param name  represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     * @param minAge the minimum age for this medicine to allow to be given
     */
    public OverTheCounter(String name, String composition,
                            int dose, int minAge) {
        this(name, composition, dose, 10, 0,minAge);
    }
    
    /**
     * ...non-argumentative method getMinAge
     * @return the minimum age for this medicine to allow to be given
     */
    public int getMinAge() {
        return minAge;
    }
    
    /**
     * ...argument method setMinAge takes an int and set it as the minimum age
     * for this medicine to allow to be given
     * @param  minAge represents the minimum age for this medicine 
     * to allow to be given
     */
    public void setMinAge(int minAge) {
        if (minAge >= 0)
            this.minAge = minAge;
    }
    
    /**
     * ...non-argumentative method toString that overrides the ToString method 
     * from parent class(Medicine) by adding specific information
     * about OverTheCounter
     * @return edited information about the medicine
     */
    @Override
    public String toString() {
        return "Over the Counter:\n"+ super.toString() +
               "\n     minimum Age: " + minAge;
    }
}
