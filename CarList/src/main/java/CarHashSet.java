import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CarHashSet<T> implements CarSet<T> {
    private Map<T, Object> map = new HashMap<>();
    private Object object = new Object();

    @Override
    public boolean add(T car) {
        if (map.containsKey(car)) {
            return false;
        }
        map.put(car, object);
        return true;
    }

    @Override
    public boolean remove(T car) {
        Object removed = map.remove(car);
        return removed != null;
    }

    @Override
    public boolean contains(T car) {
        return map.containsKey(car);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

//    private static final int INITIAL_CAPACITY = 16;
//    private static final double LOAD_FACTOR = 0.75;
//    private int size = 0;
//    private Object[] array = new Object[INITIAL_CAPACITY];
//
//
//
//    @Override
//    public boolean contains(T car) {
////        for(Entry element : array){
//////            Entry entry = element;
////            while (element != null){
////                if(element.value.equals(car)){
////                    return true;
////                }else{
////                    element = element.next;
////                }
////            }
////        }
////        return false;
//        int position = getElementPosition(car, array.length);
////        Entry firstElement = array[position];
//        if (array[position] == null) {
//            return false;
//        }
//        Entry element = (Entry)array[position];
//        Entry nextElement = (Entry) element.next;
//        if (element.value.equals(car)) {
//            return true;
//        }
//        while (nextElement != null) {
//            if (nextElement.value.equals(car)) {
//                return true;
//            } else {
//                nextElement = nextElement.next;
//            }
//        }
//        return false;
//    }
//
//
//
//    @Override
//    public boolean add(T car) {
//        if(size >= array.length * LOAD_FACTOR){
//            increaseArray();
//        }
//        boolean added = add(car,array);
//        if(added){
//            size++;
//        }
//        return added;
//    }
//    public boolean add(T car, Object[] dst){
//        int position = getElementPosition(car, dst.length);
////        Entry last = dst[position];
//        if (dst[position] == null) {
//            Entry entry = new Entry(car, null);
//            dst[position] = entry;
//            return true;
//        } else {
//            Entry existedEntry = (Entry)dst[position];
//            while (true) {
//                if (existedEntry.value.equals(car)) {
//                    return false;
//                } else if (existedEntry.next == null) {
//                    existedEntry.next = new Entry(car, null);
//                    return true;
//                } else {
//                    existedEntry = existedEntry.next;
//                }
//            }
//
//        }
//    }
//
//    @Override
//    public boolean remove(T car) {
//        int position = getElementPosition(car, array.length);
////        Entry firstElement = array[position];
//        if (array[position] == null) {
//            return false;
//        }
//        Entry element = (Entry) array[position];
//        Entry nextElement = element.next;
//        if (element.value.equals(car)) {
//            array[position] = nextElement;
//            size--;
//            return true;
//        }
//        while (nextElement != null) {
//            if (nextElement.value.equals(car)) {
//                element.next = nextElement.next;
//                size--;
//                return true;
//            } else {
//                element = nextElement;
//                nextElement = nextElement.next;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public void clear() {
//        array = new Object[INITIAL_CAPACITY];
//        size = 0;
//    }
//
//    private void increaseArray(){
//        Object[] newArray = new Object[array.length * 2];
//        for(Object entry: array){
//            Entry existedElement = (Entry)entry;
//            while (existedElement != null){
//                add(existedElement.value,newArray);
//                existedElement = existedElement.next;
//            }
//        }
//        array = newArray;
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new Iterator<T>() {
//            int index = 0;
//            int arrayIndex = 0;
//            Entry entry;
//
//            @Override
//            public boolean hasNext() {
//                return index < size;
//            }
//
//            @Override
//            public T next() {
//                while (array[arrayIndex] == null){
//                    arrayIndex++;
//                }
//                if(entry == null){
//                    entry = (Entry)array[arrayIndex];
//                }
//                T result = entry.value;
//                entry = entry.next;
//                if(entry == null){
//                    arrayIndex++;
//                }
//                index++;
//                return result;
//            }
//        };
//    }
//
//    private class Entry {
//        private T value;
//        private Entry next;
//
//        public Entry(T value, Entry next) {
//            this.value = value;
//            this.next = next;
//        }
//    }
//
//    private int getElementPosition(T car, int arrayLength) {
//        return Math.abs(car.hashCode() % arrayLength);
//    }
}
