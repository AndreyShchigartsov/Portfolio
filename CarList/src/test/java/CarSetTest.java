import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {
    private CarSet<Car> carSet;
    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet<>();
        for(int i = 0; i < 100; i++){
            carSet.add(new Car("brand" + i,i));
        }
    }

    @Test
    public void whenAdd3SimilarObjectThenSizeIncreaseBy1(){
        assertEquals(100,carSet.size());
        assertTrue(carSet.add(new Car("Audi",101)));
        assertFalse(carSet.add(new Car("Audi",101)));
        assertFalse(carSet.add(new Car("Audi",101)));
        int result = 101;
        assertEquals(result,carSet.size());
    }

    @Test
    public void whenSetClearedThenSize0(){
        carSet.clear();
        assertEquals(0,carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased(){
        Car car = new Car("BMV",123);
        carSet.add(car);
        assertEquals(101,carSet.size());
        assertTrue(carSet.remove(car));
        assertEquals(100,carSet.size());
    }

    @Test
    public void whenContains(){
        Car car = new Car("Audi A6" , 135);
        Car car1 = new Car("Audi A7" , 135);
        carSet.add(car);
        assertEquals(101,carSet.size());
        assertTrue(carSet.contains(car));
        assertFalse(carSet.contains(car1));
    }
}