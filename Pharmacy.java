/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java 
 * to edit this template
 */

/**
 * Course : CSIS215.
 * Object Oriented Programming Project composed of five files. 
 * Current File : Pharmacy.java 
 * Purpose : The purpose of this class is to create pharmacy objects.
 * Methods : Pharmacy constructor takes name to create pharmacy object.
 * getMedicines method returns array of all medicines in pharmacy. 
 * getOverTheCounterQuantity method returns quantity of overTheCounter medicines
 * getPrescriptionQuantity method returns quantity of prescription medicines.
 * getNumberOfMedicines method returns number of medicines in pharmacy.
 * getMaxNumberOfMedicines method returns capacity of medicines in pharmacy.
 * setName method changes name of medicine.
 * setMaxNumberOfMedicines changes capacity of medicines in pharmacy.
 * addMedicine method checks if the medicine not found to add it to pharmacy.
 * raisePrice method raises price by  percentage if positive
 *  and reduces if negative.
 * searchByName method searches for medicines with same name in the pharmacy.
 * searchByNameAndDose method searches for medicine with same name and dose.
 * searchByComposition method searches for medicines with same composition.
 * sellMedicine method sells medicine if available and has enough quantity.
 * restock method restocks medicine if already available.
 */

package OOP_Project;

/**
 *
 * The pharmacy class contains data fields , methods, and constructors to allow
 *  creating pharmacy objects.
 * 
 * @author Ghina Bou Ghannam
 */
public class Pharmacy {
    
    /** name variable represents the name of the pharmacy */
    private String name; 
    
    /* medicines array represents number of medicines in the pharmacy */ 
    private Medicine[] medicines = new Medicine[maxNumberOfMedicines];
    
    /**
     * overTheCounterQuantity variable represents
     * total quantity of the over the counter medicines in the pharmacy
     */
    private int overTheCounterQuantity = 0; 
    
    /**
     * prescriptionQuantity  variable represents 
     * the total quantity of prescription medicines in the pharmacy
     */
    private int prescriptionQuantity = 0; 
    
    /**
     * numberOfMedicines variable represents the number of different 
     * medicines in the medicines array
     */
    private int numberOfMedicines = 0; 
    
    /**
     * MaxNumberOfMedicines variable represents the capacity of the 
     * medicines array
     */
    private static int maxNumberOfMedicines = 100; 
    
    /**
     * argument constructor Pharmacy takes a string, creates new pharmacy 
     * and sets all other data fields to default values 
     * @param name represents the name of the pharmacy
     */
    public Pharmacy(String name) {
        setName(name);
    }
    
    /** 
     * method addMedicine takes an instance of medicine class and checks if
     * the type of medicine exists or not
     * @param medicine represents medicine to be added to pharmacy 
     */
    public void addMedicine (Medicine medicine) {
        
        /** 
         * variable found represents availability of medicine ,so it adds if
         * medicine is not available  or shows error if not available
         */ 
        boolean found = false;
        
        /* loop iterates over the medicines array to find given medicine */
        for( int i=0; i<numberOfMedicines; i++) {
            if (medicines[i].equals(medicine)) { 
                found=true;
                break;
            }
        }
        if (!found) {
            if (maxNumberOfMedicines != numberOfMedicines) { 
                medicines[numberOfMedicines] = medicine;
                numberOfMedicines++;
                
                /**
                 * add the quantity to variable overTheCounterQuantity if 
                 * it's OverTheCounter 
                 */
                if (medicine instanceof OverTheCounter) {
                    overTheCounterQuantity += medicine.getQuantity();
                }  
                
                /**
                 * add the quantity to variable prescriptionQuantity if 
                 * it's Prescription
                 */
                if (medicine instanceof Prescription) {
                    prescriptionQuantity += medicine.getQuantity();
                }    
                System.out.println("New medicine is added successfully");
            } else //if the array is full, error message is displayed
                System.out.println("Error: " + medicine + 
                                        " could not be added.");    
        /** 
         * if medicine already exists,
         * message tells user of medicine's existing 
         */
        } else
            System.out.println(" Failure: " + medicine.getName() +
                                   " already exists.");
    }
    
    /**
     * method raisePrices raises the price of all medicines by specific
     * percentage to reduce the prices by the taken percentage if negative 
     * or raise by percentage if positive
     * @param percentage represents the percentage of raise of prices 
     */
    public void raisePrice(double percentage) {
        
        /** variable newPrice represents price of medicine after raise */
        double newPrice;
                
        if (percentage >= -100 && percentage <= 100) {
            for (int i = 0; i < numberOfMedicines; i++) {
                newPrice = medicines[i].getPrice() + 
                       medicines[i].getPrice()*percentage/100;
                if (newPrice >= 0){
                medicines[i].setPrice(newPrice);
                }                              
            }
        }
    }    
    
    /**
     * method searchByName takes string name to search for all medicines 
     * in array having the given name
     * @param name represents name of medicine
     * @return array of indices of medicines with same name 
     */
    public int[] searchByName(String name) {
        /**
         * array indexOfSameName represents the indices of medicines with 
         * same given name
         */
        int[] indexOfSameName = new int[numberOfMedicines];
        
        /** 
         * array resizedArray has the same role as indexOfSameName with 
         * resizing the array to number of medicines with same name 
         */
        int [] resizedArray;
        
        int count=0; // counts number of medicines with same name 
        
        for (int i =0; i < numberOfMedicines; i++) {
            
            // compares name of given medicine with this medicine
            if (name.equals(medicines[i].getName())) {
                indexOfSameName[count] = i;
                count++;
            } 
        }
        
        resizedArray = new int[count]; // resizing array to actual size
       
        /** copying the elements from array indexOfSameName to resizedArray */
        System.arraycopy(indexOfSameName,0,resizedArray ,
                          0, count);
        
        return resizedArray;                                     
    }
    
    /**
     * method searchByNameAndDose takes string name of specific medicine 
     * and its dose to search in the array for this medicine 
     * @param name represents name of medicine
     * @param dose represents dose of medicine
     * @return index of this medicine in the array or -1 if not found 
     */
    public int searchByNameAndDose(String name, int dose) {
        
        // loop iterates to compare given medicine with all medicines in array
        for (int i = 0; i < numberOfMedicines; i++) {
            
            // compares name and dose of given medicine with this medicine
            if ((name.equals(medicines[i].getName())) && 
                    (dose==medicines[i].getDose()))
                return i;
        }
        return -1;
    }
    
    /**
     * method searchByComposition takes a string composition to search
     * for all medicines in the array having the specific composition
     * @param composition represents composition of medicine 
     * @return array of indices of medicines with the same composition
     */
    public int[] searchByComposition(String composition) {
        /**
         * array indexOfSameComposition represents the indices of medicines 
         * with same given composition 
         */
        int[] indexOfSameComposition = new int[numberOfMedicines];
        
         /** 
         * array resizedArray has the same role as indexOfSameComposition with 
         * resizing the array to number of medicines with same composition
         */
        int [] resizedArray;
        
        int count = 0; // counts number of medicines with same composition
    
        for (int i = 0; i < numberOfMedicines; i++) {
            if (composition.equals(medicines[i].getComposition())) {
                indexOfSameComposition[count] = i;
                count++;
            } 
        }
        
        resizedArray = new int[count];
        
         /** copying the elements from array indexOfSameName to*/
        System.arraycopy(indexOfSameComposition,0,resizedArray ,
                          0, count);
        
        return resizedArray;                                     
    }
    
    /**
     * method sellMedicine takes a string , int for quantity ,and int for dose
     * to search for specific medicine and sell it if the medicine and its 
     * quantity are available or displays message telling the problem 
     * if not enough quantity or not found medicine
     * @param name represents the name of the medicine
     * @param dose represents the dose of the medicine
     * @param quantity represents the required quantity from the medicine
     */ 
    public void sellMedicine(String name, int dose, int quantity) {  
        
        /* variable i represents index of medicine with specific name and dose*/
        int i = searchByNameAndDose(name, dose);
        
        if (i != -1) {
            if (medicines[i].getQuantity() > quantity) {
                medicines[i].setQuantity(medicines[i].getQuantity() - quantity);
                
                // reduces the overTheCounterQuantity ( case of OverTheCounter)
                if (medicines[i] instanceof OverTheCounter) {
                    overTheCounterQuantity -= quantity;    
                }
                
                // reduces the prescriptionQuantity (case of Prescription)
                else if (medicines[i] instanceof Prescription){
                    prescriptionQuantity -= quantity;
                }
                System.out.println("Selling successful.");
            } else // case of not enough quantity
                System.out.println("The quantity is not enough.");
        } else // error message for not finding the medicine
            System.out.println("Medicine not found.");
    }
    
    /**
     * method restock takes string name and int dose to search for medicine and 
     * add the given int quantity to the original quantity of this medicine
     * @param quantity represents quantity to be added to medicine's quantity
     * @param name represents name of medicine
     * @param dose represents dose of medicine
     * @return true if the specific medicine is available and the quantity 
     * added or false if the medicine doesn't exist
     */
    public boolean restock(String name, int dose, int quantity) {
        for (int i = 0; i < numberOfMedicines; i++) {
            if (name.equals(medicines[i].getName()) && 
                    dose == medicines[i].getDose()) {
                medicines[i].setQuantity(medicines[i].getQuantity() + quantity);
                
                // adds the overTheCounterQuantity ( case of OverTheCounter)
                if (medicines[i] instanceof OverTheCounter) {
                    overTheCounterQuantity += quantity;    
                }
                
                // adds the prescriptionQuantity (case of Prescription) 
                else if (medicines[i] instanceof Prescription){
                    prescriptionQuantity += quantity;
                }
                return true;    
            }  
        }
        return false; // medicine not found 
    }
    
    /**
     * ...non-argumentative method getMedicines
     * @return all medicines in the pharmacy in an array
     */
    public Medicine[] getMedicines() {
        return medicines;
    }
    
    /**
     * ...non-argumentative method getOverTheCounterQuantity
     * @return total quantity of the over the counter medicines in the pharmacy
     */
    public int getOverTheCounterQuantity() {
        return overTheCounterQuantity;
    }
    
    /**
     * ...non-argumentative method getPrescriptionQuantity
     * @return total quantity of prescription medicines in the pharmacy
     */
    public int getPrescriptionQuantity() {
        return prescriptionQuantity;
    }
    
    /**
     * ...non-argumentative method getNumberOfMedicines
     * @return number of medicines in the pharmacy 
     */
    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }
    
    /**
     * ...non-argumentative method getMaxNumberOfMedicines
     * @return capacity of medicines in pharmacy
     */
    public static int getMaxNumberOfMedicines() {
        return maxNumberOfMedicines;
    }
    
    /**
     * ...argument method  setName takes a string and set it as the
     * new name of the pharmacy
     * @param name represents the new name of pharmacy
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * ...argument method setMaxNumberOfMedicines takes an int and set it as 
     * the capacity of medicines in pharmacy
     * @param maxNumberOfMedicines represents the new 
     * capacity of medicines in pharmacy
     */
    public static void setMaxNumberOfMedicines(int maxNumberOfMedicines) {
        Pharmacy.maxNumberOfMedicines = maxNumberOfMedicines;
    }
    
    @Override
    /**
     * ...non-argumentative method toString displays the information
     * about the pharmacy in clear form
     * @return all information about the pharmacy 
     */
    public String toString() {
        return "    Pharmacy: "+ name + 
               "\n    Number of Medicines: " + numberOfMedicines +
               "\n    Over the counter quantity: "+ overTheCounterQuantity+
               "\n    Prescription quantity: " + prescriptionQuantity;
               
    }
}
    

