/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java 
 * to edit this template
 */

/**
 * Course : CSIS215.
 * Object Oriented Programming Project composed of five files. 
 * Current File : OOP_Project.java (Main)
 * Purpose : Designing pharmacy system to add information by implementing
 *           the class pharmacy and superclass medicine and its
 *           subclasses OverThecounter and  prescription 
 * Methods : menu (return choice of the user from the options displayed) and 
 * usage of methods from the other classes
 */


package OOP_Project;

import java.util.Scanner;

/**
 * 
 * This class ( main) has a method menu to display options to user, calls 
 *  methods to add information to the pharmacy system.
 * 
 * 
 * @author Ghina Bou Ghannam
 */
public class OOP_Project {
    public static void main(String[] args) {
        
        /** variable name represents name of medicine */
        String name;   
        
        /** variable composition represents active element of medicine */
        String composition;
        
        /** variable dose represents active element of medicine */
        int dose;         
       
        /** variable quantity represents quantity of medicine */
        int quantity;  
           
        /** variable medicines represents number of medicines in the pharmacy */
        Medicine [] medicines;
        
        /** variable exit represents the status of system to help to stop  */
        boolean exit = false; 
       
        
        Scanner input = new Scanner(System.in);
        
        // Create an instance object of pharmacy
        Pharmacy pharmacy = new Pharmacy("myPharma");
        
        System.out.println("\nWelcome to \" myPharma \" pharmacy system."
                    + "\n------------------------------------------------\n");
        
        /**
         * loop iterates to add information to pharmacy until the user enters 8
         * so exit variable turns true which breaks the loop
         */
        while (!exit) {
            switch (menu()) { 
            
            /**
             * case 1 asks the user to enter the information of medicine,
             * choose the type of medicine according to subclasses of parent
             * class medicine,and adds the medicine by calling addMedicine
             * method from pharmacy class
             */
            case 1:
                
                /** variable price represents price of medicine */
                double price;
                
                /** represents the minimum age for medicine to be given */
                int minAge;        
                
                /**
                 * variable doctorSpecialization represents specialization 
                 * of the doctor allowed prescribing this medicine
                 */
                String doctorSpecialization; 
                
                /** variable medicine represents medicine in pharmacy */
                Medicine medicine;
                
                /**
                 * variable medicineType represents one of subclasses of
                 * parent class medicine either OverTheCounter or Prescription
                 */
                char medicineType;
        
                
                System.out.print("\nEnter the information of the new medicine: "
                + "\n\nChoose O or o for over the counter medicine and p or P" 
                + " for prescription medicine: ");                  
                medicineType = input.next().charAt(0);
                /** 
                 * adds the information of medicine: name, dose, composition, 
                 * price, and  quantity
                 */
                
                System.out.print("Name: ");     
                name = input.next();
                
                // change letters to small letters (unified format)
                name = name.toLowerCase();
                
                System.out.print("Composition: ");
                composition = input.next();
                
                // change letters to small letters (unified format)
                composition = composition.toLowerCase();
                
                System.out.print("Dose: ");
                dose = input.nextInt();
                
                System.out.print("Price: ");
                price = input.nextDouble();
                
                System.out.print("Quantity: ");
                quantity = input.nextInt();
                
                
                // Adds minimum age of medicine(case of overTheCounter medicine) 
                if ((medicineType == 'O') || (medicineType == 'o')) {
                System.out.print("Enter the minimum age for this medicine: ");
                minAge = input.nextInt();
                
                medicine = new OverTheCounter(name, composition, dose, price,
                                                  quantity, minAge);
                pharmacy.addMedicine(medicine);
                }
                
                //Adds doctor specialization (case of prescription medicine)
                else if ((medicineType == 'P') || (medicineType == 'p')) {
                System.out.print("Enter the doctor specialization for "
                                       + "this medicine: ");
                doctorSpecialization = input.next();
                
                /** 
                 * change doctorSpecialization's letters to small letters 
                 * as a unified format 
                 */
                doctorSpecialization =  doctorSpecialization.toLowerCase();
                
                medicine = new Prescription(name, composition, dose, quantity,
                                                price, doctorSpecialization);
                pharmacy.addMedicine(medicine);
                } else  // displays error message when char is entered wrong
                    System.out.println("Error: Enter valid character ");
                    break;
                
            /**
             * case 2 asks for name of medicines , searches for it by using
             * searchByName method from pharmacy class, 
             * and displays the medicine's information
             */
            case 2:
                
                /**
                 * arrayOfIndices variable represents indices of medicines 
                 * with same name
                 */
                int[] arrayOfIndices;
                
                System.out.print("Enter name of the medicine to be found: ");
                name = input.next();
                
                // change name's letters to small letters as a unified format 
                name = name.toLowerCase(); 
                
                
                arrayOfIndices = pharmacy.searchByName(name);
                medicines = pharmacy.getMedicines();
                
                System.out.println(arrayOfIndices.length + 
                      ((arrayOfIndices.length > 1) ? " medicines" : " medicine")
                       + " found matching this name.");
                
                //loop iterates to print information of medicines with this name
                for (int i = 0; i < arrayOfIndices.length; i++) {
                  System.out.print((i+1)+"- ");
                  System.out.println(medicines[arrayOfIndices[i]].toString());
                } 
                  break;
                  
            /**
             * case 3 asks for composition of medicines, searches for
             * medicines with same composition by using searchByComposition
             * method from pharmacy class and displays their information
             */
            case 3:
                /**
                 * indicesOfSameComposition represents indices of medicines
                 * with same composition
                 */
                int[] indicesOfSameComposition ;
               
                System.out.print("Enter the composition to be found:");
                composition = input.next();
                
                // change composition's letters to small letters(unified format) 
                composition = composition.toLowerCase();
                
                
                indicesOfSameComposition =
                        pharmacy.searchByComposition(composition);
                
                // gets all medicines using method getMedicines from pharmacy 
                medicines = pharmacy.getMedicines();
                
                System.out.println(indicesOfSameComposition.length + 
                    ((indicesOfSameComposition.length > 1) ? " medicines" :
                    " medicine") + " found matching this composition.");
                
                // loop iterates to print the medicines' information
                for (int i = 0; i < indicesOfSameComposition.length; i++) {
                System.out.println( (i+1)+"- "+
                        medicines[indicesOfSameComposition[i]].toString());
                }
                break;
            
            /**
             * case 4 asks for name, dose, and quantity of medicine, then calls 
             * sellMedicine from class pharmacy to sell this medicine (this 
             * method  shows success or fail of selling)
             */    
            case 4:
                System.out.print("Enter the name of the medicine: ");
                name = input.next();
                
                // change name's letters to small letters(unified format)
                name = name.toLowerCase();
                
                System.out.print("Enter the dose: ");
                dose = input.nextInt();
                
                System.out.print("Enter the quantity: ");
                quantity = input.nextInt();
                
                
                pharmacy.sellMedicine(name, dose, quantity);
                break;
            
            /**
             * case 5 asks for name, dose, and quantity of medicine, then calls
             * restock method from class medicine to restock this medicine 
             */
            case 5:
                System.out.print("Enter the name of the medicine: ");
                name = input.next();
                
                // change name's letters to small letters(unified format)
                name = name.toLowerCase();
                
                System.out.print("Enter the dose: ");
                dose = input.nextInt();
                
                System.out.print("Enter the quantity: ");
                quantity = input.nextInt();
                
                
                // restock method returns true for success and false for fail
                if (pharmacy.restock(name, dose, quantity)) {
                    System.out.println("Restock Successful");
                } else
                    System.out.println("Restock Failure");
                break;
            
            /**
             * case 6 displays all information about all medicines in the 
             * pharmacy 
             */
            case 6:
                medicines = pharmacy.getMedicines();
                
                // loop iterates to print medicines' information
                for(int i = 0; i < pharmacy.getNumberOfMedicines(); i++) {
                    System.out.println("Medicine " + (i+1) + " : " +
                            medicines[i].toString() + "\n----");   
                }
                break;
            
            /**
             * case 7 prints all information about the pharmacy 
             */
            case 7:
                System.out.println(pharmacy.toString());
                break; 
            
            /**
             * case 8 exits the system ,so it stops taking choices and adding
             * information 
             */
            case 8:
                exit = true; // shows that adding information ends
                System.out.println("Exiting the system...");
                break;
            
            /**
             *  default case for entering wrong choice 
             * , it shows error message
             */
            default:
                System.out.println("Enter valid number between 1 and 8");
                break;
            }
            
            // optimizing the display of pharmacy system
            System.out.println("------------------------------------------");
        }       
    }
    
    
    /**
     * non-argumentative method displays options about the medicines 
     * in the pharmacy for user to choose
     * @return number of the option chosen by the user
     */
    public static int menu() {
        int choice; // variable answer represents choice of the user 
        
        
        Scanner input = new Scanner(System.in);
      
        System.out.print( "Choose one of the following options:\n"+
                          "1- Add a new medicine\n" +
                          "2- Search for a medicine by name\n" +
                          "3- Search for a medicine by composition\n" +
                          "4- Sell a medicine\n" +
                          "5- Restock a medicine\n" +
                          "6- Display all medicines\n" +
                          "7- Display information\n" +
                          "8- Exit\n"+
                          "Enter your choice (between 1 and 8): ");
        
        // enters choice between 1 and 8 
        choice = input.nextInt();
        
        return choice;
    }    
}

       
              
               
             
           
    
