package hello.dto;

import java.util.HashSet;
import java.util.Set;

public class Cat extends Animal {


    public static void main(String[] args) {
        Set<Animal> animals = new HashSet<>();
        Animal animal = new Animal();
        animal.setId(1);
        animal.setName("a");

        animals.add(animal);
        System.out.println(animals.remove(animal));
        System.out.println("size: "+animals.size());


        animals.add(animal);
        animal.setName("b");
        System.out.println(animals.remove(animal));
        System.out.println("size: "+animals.size());

        Animal animal1 = animal;
        animals.add(animal);
        animal.setId(2);
        System.out.println(animals.remove(animal));
        System.out.println("size: "+animals.size());
        System.out.println(animal.equals(animal1));
    }

}
