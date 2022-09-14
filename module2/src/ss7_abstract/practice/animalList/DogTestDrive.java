package ss7_abstract.practice.animalList;

public class DogTestDrive {
    public static void main(String[] args) {
        AnimalList animalList = new AnimalList();
        Dog dog = new Dog();
        animalList.add(dog);

        Dog animal = animalList.get(0);
        Dog dog2 = (Dog) animal; // <--- ép kiểu từ Object trở về kiểu Dog
        dog2.roam();
        dog2.chaseCat();
    }
}
