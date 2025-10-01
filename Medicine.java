/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 * to edit this template
 */

/**
 * Course : CSIS215.
 * Object Oriented Programming Project composed of five files. 
 * Current File : Medicine.java .
 * Purpose : The purpose of this class is to create medicine objects.
 * Methods : Medicine constructor  creates object of medicine class
 * Another Medicine object takes less variables ( set others to default)
 * getName method returns name of medicine while setName method changes it
 * getComposition method returns active element of medicine while 
 * setComposition method changes it
 * getDose method  returns dose of medicine in mg while setDose changes it
 * getPrice method returns price of medicine while setPrice method  changes it
 * getQuantity method returns quantity of medicine while setQuantity changes it
 * toString  returns string of all information of Medicine object
 * equals method compares between 2 medicines according to name and dose
 * 
 */

package OOP_Project;

/**
 *
 * The class Medicine contains data fields , methods, and constructors to allow
 * creating Medicine objects
 * 
 * @author Ghina Bou Ghannam
 */
public class Medicine {
    
    /** variable name represents name of medicine */
    private String name; 
    
    /** variable composition represents active element of medicine */
    private String composition;
    
    /** variable dose represents dose of medicine in mg */
    private int dose = 1000;   
    
    /** variable price represents price of medicine */
    private double  price = 10;
    
    /** variable quantity represents quantity of medicine */
    private int quantity = 0;  
   
    
    /**
     * argument constructor Medicine takes string name ,String composition, 
     * int dose, double price,and int quantity to create new medicine
     * @param name represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     * @param price represents price of medicine
     * @param quantity represents quantity of medicine
     */
    public Medicine(String name, String composition, int dose, double price, 
                    int quantity) {
        setName(name);
        setComposition(composition);
        setDose(dose);
        setPrice(price);
        setQuantity(quantity);
    }
    
    /**
     * ...argument constructor Medicine takes string name ,String composition, 
     * and int dose to create Medicine by calling another constructor
     * and setting the other data fields to default values
     * @param name represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     */
    public Medicine(String name, String composition, int dose) {
        this(name, composition, dose, 10, 0);
    }
    
    /**
     * ...non-argumentative method getName
     * @return name of medicine
     */
    public String getName() { 
        return name;
    }
    
    /**
     * ...argument method  setName takes a string and sets it as the new name
     * of the medicine 
     * @param name represents the new name of medicine 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * ...non-argumentative method getComposition
     * @return active element of medicine
     */
    public String getComposition() {
        return composition;
    }
    
    /**
     * ...argument method setComposition takes a string and sets it as
     * the new active element of medicine
     * @param composition represents the new active element of medicine
     */
    public void setComposition(String composition) {
        this.composition = composition;
    }
    
    /**
     * ...non-argumentative method getDose
     * @return  dose of medicine in mg
     */
    public int getDose() {
        return dose;
    }
    
    /**
     * ...argument method setDose takes an int and sets it as dose of medicine
     * in mg
     * @param dose represents the dose of medicine in mg
     */
    public void setDose(int dose) {
        this.dose = dose;
    }
    
    /**
     * ...non-argumentative method getPrice
     * @return price of medicine
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * ...argument method  setPrice takes a string and set it as the new price
     * of medicine
     * @param price represents price of medicine
     */
    public void setPrice(double price) { 
        this.price = price;
    }
    
    /**
     * ...non-argumentative method getQuantity
     * @return quantity of medicine
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * ...argument method setQuantity takes a string and set it as  
     * quantity of medicine
     * @param quantity represents quantity of medicine
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
    /**
    * ...non-argumentative method toString displays the information about the 
    * medicine in  clear form
    * @return all information about the medicine 
    */
    @Override 
    public String toString() {
      return "     name: " + name +
              "\n     composition: " + composition +
              "\n     dose: " + dose + "mg" +
              "\n     price: " + price +
              "\n     quantity: " + quantity;
    }
    
    /**
     * method equals takes Medicine medicine and compares it 
     * with this medicine name and dose
     * @param medicine represents a medicine 
     * @return true if given medicine is equal to this medicine 
     * or it return false 
     */
    public boolean equals(Medicine medicine) {
       return this.name.equals(medicine.name) && 
              this.dose == medicine.dose;
    }  
}

    
    

