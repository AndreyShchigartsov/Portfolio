import java.util.Iterator;

public class CarLinkedList<T> implements CarList<T>{

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public T get(int index) {
//        checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public boolean add(T car) {
        if(size == 0){
            last = new Node(null, car, null);
            first = last;
        }else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
         size++;
        return true;
    }

    @Override
    public boolean contains(T car) {
        return findElement(car) != -1;
    }

    private int findElement(T car){
        Node node = first;
        for(int i = 0; i < size;i++){
            if(node.value.equals(car)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }
    @Override
    public boolean remove(T car) {
        int index = findElement(car);
        if(index == -1){
            return false;
        }
        return removeAt(index);
    }

    @Override
    public boolean removeAt(int index) {
//        if(index < 0 || index < size){
//            throw new IndexOutOfBoundsException();
//        }
//        checkIndex(index);
        Node Node = getNode(index);
        Node NodeNext = Node.next;
        Node NobePrevious = Node.previous;
        if(NodeNext != null){
            NodeNext.previous = NobePrevious;
        }else {
            last = NobePrevious;
        }
        if(NobePrevious != null){
            NobePrevious.next = NodeNext;
        }else {
            first = NodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean add(T car, int index) {
//        checkIndex(index);
        if(index == size) {
            return add(car);
//            return true;
        }
//        Node getNode = getNode(index);
//        Node nextGetNote = getNode.next;
//        Node newNode = new Node(getNode.next, car,nextGetNote.previous);
//        getNode.next = newNode;
//        nextGetNote.previous = newNode;
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious,car,nodeNext);
        nodeNext.previous = newNode;
        if(nodePrevious != null){
            nodePrevious.next = newNode;
        }else{
            first = newNode;
        }



        size++;
        return true;
    }

    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0;i < index;i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
//            int index = 0;
            Node newNode = first;
            @Override
            public boolean hasNext() {

                return newNode != null;
            }

            @Override
            public T next() {
                T car = newNode.value;
                newNode = newNode.next;
                return car;
            }
        };
    }

    private class Node{
        private Node previous;
        private T value;
        private Node next;
        Node(Node previous, T value, Node next){
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
