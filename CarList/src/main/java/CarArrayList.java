import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList<T> implements CarList<T>{

    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    @Override
    public boolean add(T car) {
        increaseArray();
//            Car [] arrayCar = new Car[array.length*2];
//            for(int i = 0; i < size; i++){
//                arrayCar[i] = array[i];
//            }
//            array = arrayCar;

        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean remove(T car) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(car)){
                return removeAt(i);
            }
        }
//        size--;
        return false;
    }

    @Override
    public boolean contains(T car) {
        for(int i = 0; i < size;i++){
            if(array[i].equals(car)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for(int i = index; i < size - 1; i++){
            array[i] = array[i + 1];
        }

        if(size - index >= 0){
            System.arraycopy(array,index,array,index+1,size - index);
        }
        size--;
        return true ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[10];
        size = 0;
    }

    @Override
    public boolean add(T car, int index) {
        increaseArray();
        if (index < 0 || index > array.length){
            throw new IndexOutOfBoundsException();
        }
        if (size() - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size() - index);
        }
        array[index] = car;
        size++;
        return true;
    }

    private void increaseArray(){
        if(size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T)array[index++];
            }
        };
    }
}
