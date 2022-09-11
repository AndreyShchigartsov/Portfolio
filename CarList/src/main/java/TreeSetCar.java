import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetCar {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
//                if(o1 < o2){
//                    return 1;
//                }else if(o1 > o2){
//                    return -1;
//                }else{
//                    return 0;
//                }
            }
        });
        for(int i = 0;i < 100;i++){
            numbers.add((int)(Math.random()*10));
        }
        for(int number:numbers){
            System.out.println(number);
        }
    }
}
