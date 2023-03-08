package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    Car(){
        this.tyres = 4;
        this.doors = 4;
    }

    void displayCharacteristics(){
        System.out.println("Color: " + color);
        System.out.println("Transmission: " + transmission);
        System.out.println("Make: " + make);
        System.out.println("Tyres: " + tyres);
        System.out.println("Doors: " + doors);
    }

    void accelarate(){
        System.out.println("Car is moving forward.");
    }

    void brake(){
        System.out.println("Car has stopped.");
    }
}
