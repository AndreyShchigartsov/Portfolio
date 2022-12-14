import java.util.Objects;

public class Car {
    private String brand;
    private int number;
    Car(String brand, int number){
        this.brand = brand;
        this.number = number;
    }
    public String getBrand(){
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }

    public int getNumber(){
        return number;
    }
}
