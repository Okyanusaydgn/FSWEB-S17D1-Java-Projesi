package com.workintech.S17D1.utils;

import com.workintech.S17D1.entity.Animal;

public class ValidationUtils {

    public static void checkId(Integer id){
        if(id == null){
            System.out.println("id null olamaz");
        }
    }

    public static void checkAnimal(Animal animal){

        if (animal == null){
            System.out.println("animal null olamaz.");
        }

        else if(animal.getId() == null){
            System.out.println("Animal id  null olamaz.");
        }

       else  if (animal.getName()== null || animal.getName().isEmpty()){
            System.out.println("name null yada empty olamaz.");
        }
    }

}
