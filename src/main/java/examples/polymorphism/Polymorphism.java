package examples.polymorphism;

public class Polymorphism {

    public static void main(String[] args) {

        // object doesn't use methods of declared type but of instantiated object

        Animal animal = new Animal();
        Animal dog = new Dog();
        Dog anotherDog = new Dog();

        animal.makeSound();
        dog.makeSound();
        anotherDog.makeSound();
    }
}
