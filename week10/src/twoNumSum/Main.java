package twoNumSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int target = 4;
        System.out.println(Arrays.toString(findTwoNumPos2(array, target)));

    }

    /*in: int[] target
    out: int[] two index
     */

    //O(2N)
    public static Integer[] findTwoNumPos(int[] array, int target) {
        Integer[] res = new Integer[2];
        //store num and index in hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            map.put(array[i], i);
        }
        //traverse hashmap x, search pos of target-x
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int match = target - entry.getKey();
            if (match == target / 2) {
                continue;
            }
            if (map.containsKey(match)) {
                res[0] = entry.getValue();
                res[1] = map.get(match);
                break;
            }
        }
        return res;
    }

    //more simple O(N)
    public static Integer[] findTwoNumPos2(int[] array, int target) {
        Integer[] res = new Integer[2];
        //traverse array each x, search if map contains target-x
        //if does, return both pos
        //if not, put x and index into map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            int match = target - array[i];
            if (map.containsKey(match)) {
                //返回下标的顺序是从小到大
                res[1] = i;
                res[0] = map.get(match);
                break;
            }
            map.put(array[i], i);
        }
        return res;
    }
}
