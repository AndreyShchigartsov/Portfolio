public interface CarList<T> extends CarCollections<T> {
    T get(int index);
    boolean removeAt(int index);
    boolean add(T car,int index);
    boolean add(T car);
    boolean remove(T car);
    int size();
    void clear();
    boolean contains(T car);
}
