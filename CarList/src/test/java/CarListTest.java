import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    CarList<Car> carList;
    @Before
    public void setUp() throws Exception{
        carList = new CarArrayList<>();
        for(int i = 0; i < 100;i++){
            carList.add(new Car("brand" + i,i));
        }
    }
    @Test
    public void whenAdded100ElementThenSizeMustBe100(){
        assertEquals(100,carList.size());
    }
    @Test
    public void whenElementRemoveByIndexThenSizeMustBeDecreased(){
        assertEquals(100,carList.size());
        assertTrue(carList.removeAt(5));
        assertEquals(99,carList.size());
    }
    @Test
    public void whenElementRemoveThenSizeMustBeDecreased(){
        Car car = new Car("Toyota", 123);
        carList.add(car);
        assertEquals(101,carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100,carList.size());
    }
    @Test
    public void whenNoExistentElementRemovedThenReturnFalse(){
        Car car = new Car("car",3);
        assertFalse(carList.remove(car));
        assertEquals(100,carList.size());
    }
    @Test
    public void whenListClearedThenSizeMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException(){
        carList.get(100);
    }

    @Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("brand0",car.getBrand());
    }

    @Test
    public void InsertIntoMiddle(){
        Car car = new Car("BMW",12);
        carList.add(car,12);
//        assertEquals(101,carList.size());
        Car car1 = carList.get(12);
        assertEquals("BMW",car1.getBrand());
    }

    @Test
    public void InsertIntoFirstPosition(){
        Car car = new Car("BMW",12);
        carList.add(car,0);
//        assertEquals(101,carList.size());
        Car car1 = carList.get(0);
        assertEquals("BMW",car1.getBrand());
    }

    @Test
    public void InsertIntoLastPosition(){
        Car car = new Car("BMW",12);
        carList.add(car,100);
//        assertEquals(101,carList.size());
        Car car1 = carList.get(100);
        assertEquals("BMW",car1.getBrand());
    }

    @Test
    public void whenContains(){
        Car car = new Car("BMW X5",14);
        Car car1 = new Car("Audi A5",1234);
        carList.add(car);
        assertEquals(101,carList.size());
        assertTrue(carList.contains(car));
        assertFalse(carList.contains(car1));
    }
}