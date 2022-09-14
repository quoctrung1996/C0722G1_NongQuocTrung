package ss7_abstract.practice.animalList;

public class AnimalList {
    private Dog[] animals = new Dog[5];
    private int nextIndex = 0;

    public Dog get(int index) {
        return this.animals[index];
    }

    public void add(Dog animal) {
    if(nextIndex< animals.length){
        animals[nextIndex]=animal;
        System.out.println("Dog add at "+nextIndex);
        nextIndex++;
    }
    }
}
