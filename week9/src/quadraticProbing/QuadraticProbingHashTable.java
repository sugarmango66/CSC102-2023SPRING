package quadraticProbing;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

abstract class HashTable {
    public abstract int hash(int key);

    public abstract boolean insert(int key, String value);

    public abstract boolean remove(int key);

    public abstract String search(int key);
}

class HashNode {
    //HashNode类是一个代表键值对的类，它应该包含两个成员变量：
    //    1. int类变量key，代表键。
    //    2. String类变value，代表值。
    //    另外还要包含一个有参构造器。
    int key;
    String value;

    public HashNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

//class QueueNode {
//    int key;
//    int j;
//
//    public QueueNode(int key, int j) {
//        this.key = key;
//        this.j = j;
//    }
//}
//class LastPass {
//    int key;
//    int j;
//
//    public LastPass(int key, int j) {
//        this.key = key;
//        this.j = j;
//    }
//}

public class QuadraticProbingHashTable extends HashTable {
    //QuadraticProbingHashTable类是一个实现了二次探测的哈希表类。
    //    补全两个成员变量：
    //    1. int类的capacity代表哈希表的长度，也就是容量。
    //    2. HashNode[]类的table，是一个数组的形式，代表哈希表的bucket们。
    //    还要补全一个构造器：
    //    构造器的参数是int类的一个代表哈希表容量的变量，构造器把这个值赋给capacity，然后把table设定为这个长度的数组。

    private int capacity;
    private HashNode[] table;
//    private Queue<QueueNode>[] refTable;
    private Integer[] refTable;

    public QuadraticProbingHashTable(int capacity) {
        this.capacity = capacity;
        table = new HashNode[capacity];
//        refTable = new Queue[capacity];
        refTable = new Integer[capacity];
    }

    @Override
    public int hash(int key) {
        // hash方法也就是哈希函数，把key映射到数组中的一个bucket。
        // 这里我们要写的哈希函数式[key % capacity]。
        return key % capacity;
    }

    @Override
    public boolean insert(int key, String value) {
        // insert是一个插入方法。
        // 首先检测要插入的键是否已经存在于哈希表，如果是，就要更改哈希表中该键的值。
        // 如果不存在，则根据我们讲过的二次探测的插入规则来插入这个新的键值对。
        // 这里我们使用的规则是【(H + i + (i*i)) % capacity】。
        // 插入成功后返回true。
        int origin = hash(key);
        int i = hash(key);
        int j = 1;
        while (table[i] != null && j<capacity*2) {
            //插入的键已经存在
            if (table[i].key == key) {
                //更改哈希表中该键的值
                table[i].value = value;
                return true;
            } else {
                i = hash(origin + j + j * j);
                j++;
            }
        }
        //插入的键不存在
        /*
         *1定位bucket
         *2如果是空放入新节点
         *如果不是空，按照二次序列向后移动 直到找到一个空槽
         */

        i = hash(key);
        j = 1;
        while (table[i] != null) {
            refTable[i] = key;
            i = hash(origin + j + j * j);
            j++;
        }
        table[i] = new HashNode(key, value);
        return true;
    }

    @Override
    public String search(int key) {
        // search是一个搜索方法。
        // 它会搜索一个目标键是否在数组中。
        // 如果在，返回这个键的值；
        // 如果不在，返回null。

        /*1定位
         *2判断是否匹配搜索目标
         * 如果匹配返回value
         * 如果不匹配，按照二次序列向后移动
         * 3repeat2 until bucket empty
         * ?when to stop if it never comes across empty
         */
        int i = hash(key);
        int j = 1;
        //j < capacity * 2 对never found empty bucket模糊的解决方法
//        while (table[i] != null && j < capacity * 2) {
        while (table[i] != null) {
//            System.out.println(refTable[i]);
            if (table[i].key == key) {
                return table[i].value;
            } else {
                //对never found empty bucket的解决方法
//                if (refTable[i] == null || refTable[i].isEmpty()) {
                if (refTable[i] == null) {
                    break;
                }
                i = hash(hash(key) + j + j * j);
                j++;
            }
        }
        return null;
    }


    @Override
    public boolean remove(int key) {
        // 根据目标键计算哈希值，定位该键应该在哪个bucket。
        // 从这个bucket开始，按二次探测序列对后续的bucket进行遍历，如果找到一个bucket键等于目标键，删除它，继续遍历。
        // 直到找到一个空bucket，停止遍历。
        // 如果删除成功，返回true；否则，返回false。

        /*
         * 1定位
         * 2 按二次探测序列依次对比
         * if 匹配key 删除 并recover
         *
         */
        int i = hash(key);
        int origin = i;
        int j = 1;
        while (table[i] != null) {

            if (table[i].key == key) {
                table[i] = null;
                recover(i);
                return true;
            } else {
                i = hash(origin + j + j * j);
                j++;
            }
        }
        return false;
    }

//    public void recover(int i) {
//
//        Queue<QueueNode> passes = refTable[i];
//        if (passes == null || passes.isEmpty()) {
//            return;
//        }
//        QueueNode queueNode = passes.poll();
//        int nextKey = queueNode.key;
//        int j = queueNode.j;
//        int posOfNextKey = hash(hash(nextKey) + j + j * j);
//        String nextValue = table[posOfNextKey].value;//!!! search(nextKey) not work because table[i] == null
//        table[i] = new HashNode(nextKey, nextValue);
//        table[posOfNextKey] = null;
//        recover(posOfNextKey);
//    }

    //not necessary to use Queue, this is how simplify
    public void recover(int i) {
        if (refTable[i] == null) {
            return;
        }
        int nextKey = refTable[i];
        int j = 1;
        int posOfNextKey;
        while (true) {
            posOfNextKey = hash(hash(nextKey) + j + j * j);
            if (table[posOfNextKey] == null) {
                j++;
                continue;
            }
            if (table[posOfNextKey].key == nextKey) {
                break;
            }
            j++;
        }
        String nextValue = table[posOfNextKey].value;//!!! search(nextKey) not work because table[i] == null

        if (hash(nextKey) == i) {//nextKey 是 i的同二次序列
            table[i] = new HashNode(nextKey, nextValue);
            refTable[i] = refTable[posOfNextKey];//!!! must update, otherwise fall in dead loop

            table[posOfNextKey] = null;
            recover(posOfNextKey);
        }
        else {//23 不是 5的同二次序列
            //rehash nextkey
            int idx = hash(nextKey);
            int origin = idx;
            int k = 1;
            while (table[idx] != null) {
                if (idx == posOfNextKey) {
                    break;
                }
                refTable[idx] = nextKey;
                idx = hash(origin + k + k * k);
                k++;
            }
            if (idx != posOfNextKey) {
                table[idx] = new HashNode(nextKey, nextValue);
                table[posOfNextKey] = null;
                recover(posOfNextKey);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(10);

        hashTable.insert(13, "swim");
        hashTable.insert(15, "jump");
        hashTable.insert(23, "climb");
//        hashTable.insert(25, "run");
        hashTable.insert(18, "walk");
        hashTable.insert(20,"sleep");
        /**
         *
         * 0：sleep，20
         * 1：空
         * 2：空
         * 3：swim，13
         * 4：空
         * 5：jump，15
         * 6：空
         * 7：空
         * 8：walk，18
         * 9：climb，23
         */

        System.out.println(hashTable.remove(13));
        /**
         * expected:
         * 0：sleep，20
         * 1：空
         * 2：空
         * 3：climb，23
         * 4：空
         * 5：jump，15
         * 6：空
         * 7：空
         * 8：walk，18
         * 9：空
         */
        System.out.println(hashTable.remove(15));
        /**
         * expected:
         * 0：sleep，20
         * 1：空
         * 2：空
         * 3：climb，23
         * 4：空
         * 5：空
         * 6：空
         * 7：空
         * 8：walk，18
         * 9：空
         */

        System.out.println(hashTable.search(23));

//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            int key = scanner.nextInt();
//            String value = scanner.next();
//            hashTable.insert(key, value);
//        }

//        int key1 = scanner.nextInt();
//        hashTable.remove(key1);


        for (int i = 0; i < hashTable.capacity; i++) {
            if (hashTable.table[i] != null) {
                System.out.println(i + "：" + hashTable.table[i].value + "，" + hashTable.table[i].key);
            }
            if (hashTable.table[i] == null) {
                System.out.println(i + "：空");
            }
        }
    }
}

