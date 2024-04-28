package com.workintech.S17D1.controller;


import com.workintech.S17D1.entity.Animal;
import com.workintech.S17D1.utils.ValidationUtils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Annotation
@RequestMapping(path = "/workintech/animal")

public class AnimalController {

    private Map<Integer, Animal> animals;


    @Value("${project.owner}")
    private String projectOwner;
    @Value("${project.name}")
    private String projectName;


    @PostConstruct
    public void loadAll(){
        System.out.println("project ownder değeri = " + projectOwner);
        System.out.println("project name değeri = " + projectName);
        this.animals = new HashMap<>();
        this.animals.put(1,new Animal(1,"maymun"));
    }

    @GetMapping
    public List<Animal> getAnimals(){
        System.out.println("--- Animals list get triggered ---");
        return new ArrayList<>(this.animals.values());
    }

    @GetMapping("/{id}") // örnek;  localhost: 8585/workintech/animal/1
    public Animal getAnimal(@PathVariable("id") Integer id){
        ValidationUtils.checkId(id);
        System.out.println(" ---- animal get by id triggered ----");
        return this.animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody  Animal animal){

        ValidationUtils.checkAnimal(animal);
        this.animals.put(animal.getId(),animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable("id") Integer id, @RequestBody Animal newAnimal){
        ValidationUtils.checkId(id);
        ValidationUtils.checkAnimal(newAnimal);
        this.animals.replace(id,newAnimal);
        return this.animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Integer id){
        ValidationUtils.checkId(id);
        this.animals.remove(id);
    }
}
