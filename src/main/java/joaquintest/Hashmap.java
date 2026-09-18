import java.util.ArrayList;
import java.util.HashMap;

public class Hashmap {

    public static HashMap<Integer, Integer> countIts(ArrayList<Integer> list) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (Integer integer : list) {
            if (hash.containsKey(integer)) {
                hash.put(integer, hash.get(integer) + 1);
            } else {
                hash.put(integer, 1);
            }
        }
        return hash;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        System.out.println(countIts(list));
    }
}
