package ss7_abstract.practice.animal;

import ss7_abstract.practice.edible.Edible;
import ss7_abstract.practice.fruit.Apple;
import ss7_abstract.practice.fruit.Fruit;
import ss7_abstract.practice.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
//        Dog tiger=new Tiger();
//        Dog chicken=new Chicken();
//        System.out.println(tiger.makeSound());
//        System.out.println(chicken.makeSound());
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howtoEat());
            }
        }
        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit fruit1 : fruit) {
            System.out.println(fruit1.howtoEat());
        }
    }

}
