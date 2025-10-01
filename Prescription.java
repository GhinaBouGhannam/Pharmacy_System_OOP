/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */

/**
 * Course : CSIS215.
 * Object Oriented Programming Project composed of five files. 
 * Current File : Prescription.java 
 * Purpose : The purpose of this class is to create prescription 
 * objects by using superclass Medicine 
 * Methods :  Prescription constructor to create prescription  object.
 * Another Prescription constructor that takes less variables(set other default)
 * getDoctorSpecialization to return specialization of doctor
 * setDoctorSpecialization takes string to change specialization of doctor
 * toString (override  method) returns string of all information of prescription
 */

package OOP_Project;

/**
 * The class Prescription is an extension of the Medicine class that adds more 
 * details about the Medicine object
 * 
 * @author Ghina Bou Ghannam
 */
public class Prescription extends Medicine {
    
    /** 
     * variable doctorSpecialization represents the specialization of the 
     * doctor allowed prescribing this medicine
     */
    private String doctorSpecialization;
    
    /**
     * ...argument constructor Prescription creates an instance of the Medicine
     * class by using parent class constructor using super keyword and adds 
     * doctorSpecialization using setDoctorSpecialization method 
     * @param name  represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     * @param quantity represents quantity of medicine
     * @param doctorSpecialization  the specialization of the doctor 
     * @param price represents price of medicine
     */
    public Prescription(String name, String composition, int dose, int quantity,
                        double price, String doctorSpecialization) {
        super(name, composition, dose, price, quantity);
        setDoctorSpecialization(doctorSpecialization);    
    }
    
    /**
     * ..argument constructor Prescription takes String name, 
     * String composition, int dose, String doctorSpecialization to create an 
     * instance of the parent class , Prescription by calling another
     * constructor and setting the other data fields to default values
     * @param name  represents name of medicine
     * @param composition represents active element of medicine
     * @param dose represents dose of medicine in mg
     * @param doctorSpecialization the specialization of the doctor 
     */
     public Prescription(String name, String composition, int dose, 
             String doctorSpecialization) {
         this(name,composition,dose,0,10,doctorSpecialization);
    }
     
    /**
     * ...non-argumentative method getDoctorSpecialization
     * @return  specialization of the doctor allowed prescribing this medicine
     */
    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    
    /**
     * ...argument method setDoctorSpecialization takes a string and set it as  
     * specialization of the doctor 
     * @param doctorSpecialization represents specialization of the doctor 
     */
    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }
    
    /**
     * ...non-argumentative method toString that overrides the ToString method 
     * from parent class(Medicine) by adding information about Prescription
     * @return edited information about the medicine
     */
    @Override 
    public String toString() {
        return "Prescription: \n" + super.toString() + 
               "\n     doctor specialization: "+ doctorSpecialization;
    } 
}
