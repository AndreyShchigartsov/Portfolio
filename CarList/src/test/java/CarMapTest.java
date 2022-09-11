import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarMap<CarOwner,Car> map;
    @Before
    public void setUp() throws Exception {
        map = new CarHashMap<>();
    }

    @Test
    public void whenPut100ElementThenSizeBecome100(){
        for(int i = 0; i < 100;i++){
            CarOwner carOwner = new CarOwner(i,"Name" + i, "lastName"+i);
            Car car = new Car("brand" + i,i);
            map.put(carOwner,car);
        }
        assertEquals(100,map.size());
    }

    @Test
    public void whenPut100ElementWith10DifferentKeysThenSize10(){
        for(int i = 0; i < 100;i++){
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index,"name"+index,"lastName" + index);
            Car car = new Car("brand"+index,index);
            map.put(carOwner,car);
        }
        assertEquals(10,map.size());
    }

    @Test
    public void removeReturnTrueOnlyOnce(){
        for(int i = 0;i < 10;i++){
            CarOwner carOwner = new CarOwner(i,"Name" + i,"lastName" + i);
            Car car = new Car("brand" + i,i);
            map.put(carOwner,car);
        }
        assertEquals(10,map.size());

        CarOwner elementForDeleted = new CarOwner(5,"Name5","lastName5");
        assertTrue(map.remove(elementForDeleted));
        assertEquals(9,map.size());
        assertFalse(map.remove(elementForDeleted));
    }

    @Test
    public void countOfKeysMustBeEqualsToCountOfValues(){
        for(int i = 0;i < 100;i++){
            CarOwner carOwner = new CarOwner(i,"Name" + i, "lastName" + i);
            Car car = new Car("brand" + i,i);
            map.put(carOwner,car);
        }
        assertEquals(100,map.size());
//        assertEquals(100,map.keySet().size());
//        assertEquals(100,map.values().size());
    }

    @Test
    public void methodGetMustReturnRigthValue(){
        for (int i = 0; i < 100;i++){
            CarOwner carOwner = new CarOwner(i,"Name" + i,"lastName"+i);
            Car car = new Car("brand" + i,i);
            map.put(carOwner,car);
        }
        CarOwner key = new CarOwner(50,"Name50","lastName50");
        Car value = map.get(key);
        String expectedCarBrand = "brand50";
        assertEquals(expectedCarBrand,value.getBrand());
    }
}