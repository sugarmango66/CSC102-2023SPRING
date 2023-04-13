package linearProbing;

import java.util.*;

abstract class HashTable {
    protected int hash(int key) {
        return key;
    }

    public abstract boolean insert(int key, String value);

    public abstract boolean remove(int key);

    public abstract String search(int key);
}

class HashNode {
    //HashNode类是一个代表键值对的类，它应该包含两个成员变量：
    //    1. int类变量key，代表键。
    //    2. String类变value，代表值。
    //    另外还要包含一个有参构造器。
    protected int key;
    protected String value;

    public HashNode(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class HashTableLinearProbing extends HashTable {

    //HashTableLinearProbing类是一个实现了线性探测的哈希表类。
    //    补全两个成员变量：
    //    1. int类的capacity代表哈希表的长度，也就是容量。
    //    2. HashNode[]类的table，是一个数组的形式，代表哈希表的bucket们。
    //    还要补全一个构造器：
    //    构造器的参数是int类的一个代表哈希表容量的变量，构造器把这个值赋给capacity，然后把table设定为这个长度的数组。
    protected int capacity;
    protected HashNode[] table;
    protected int currNodeCount = 0;

    public HashTableLinearProbing(int capacity) {
        this.capacity = capacity;
        table = new HashNode[capacity];
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
        // 如果不存在，则根据我们讲过的线性探测的插入规则来插入这个新的键值对。
        // 插入成功后返回true。

        //插入的键已经存在 同理search
        int i = hash(key);
        int j = 0;
        while (table[i] != null && j++ < capacity) {
            if (table[i].key == key) {//更新哈希表中该键的值
                table[i].value = value;
                return true;
            } else {
                i = hash(i + 1);
            }
        }

        //插入的键不存在
        //定位
        i = hash(key);
        j = 0;
        while (j++ < capacity) {
            //bucket空 放入node
            if (table[i] == null) {
                table[i] = new HashNode(key, value);
                currNodeCount++;
                return true;
            }
            //bucket非空 探测下个空位
            else {
                i = hash(i + 1);
            }
        }
        //卡槽已满
        System.out.println("table full, insert fail");
        return false;
    }

    public String search(int key) {
        // search是一个搜索方法。
        // 它会搜索一个目标键是否在数组中。
        // 如果在，返回这个键的值；
        // 如果不在，返回null。

        //1定位BUCKET INDEX-i
        //2对比是否等于KEY 如果等于返回value
        //3如果不等于向下一位搜索
        //repeat 2 3
        //直到遇到空的bucket，或者整个table搜索完毕 return null
        int i = hash(key);
        int j = 0;
        while (table[i] != null && j++ < capacity) {
            if (table[i].key == key) {
                return table[i].value;
            } else {
                i = hash(i + 1);
            }
        }
        return null;
    }

    public boolean remove(int key) {
        // remove方法是一个删除方法。
        // 首先要找到我们要删除的键是否在哈希表中
        // 如果在，把这个bucket清空，然后以这个键值对所在的索引为参数做shift方法，最后返回true。
        // 如果不在，返回false。
        int i = hash(key);
        int j = 0;
        while (table[i] != null && j++ < capacity) {
            if (table[i].key == key) {
                //bucket清空
                table[i] = null;
                //善后
                shift(i);
                currNodeCount--;
                return true;
            } else {
                i = hash(i + 1);
            }
        }
        return false;
    }
    //for condition "if preferredIndex ∉ (index, index + shiftAmount] mod N"
    //it's not simple compare expression, so I put the logic in a func
    public boolean isIn(int prefer, int index, int shiftAmount) {
        int wonder = index + shiftAmount;
        if (wonder < capacity) {
            return prefer > (index % capacity) && prefer <= (wonder % capacity);
        } else {
            return prefer < (index % capacity) && prefer >= (wonder % capacity);
        }
    }

    private void shift(int index) {
        // shift 是一个用于在删除元素后重新使数组恢复正常顺序的方法。
        // 它会从第table[index + 1]开始继续探测。
        // 情况1：找到了哈希值先于或等于index的键。
        //       就把找到的这个键值对移动到index的位置。
        //       发生上述移动后，还要对这个由于移动被空出的bucket做同样的操作，直到遍历到一个空bucket
        // 情况2：找到了空bucket。
        //       当探测到一个值为null的bucket时，说明我们已经处理完了全部哈希值先于或等于index，但所在bucket又大于index的bucket。
        //       那么清空单元格i是安全的，删除过程就此终止
        //提示：可以用参考下面的格式来完成这个方法：
        //       shiftAmount ← 1 // 当前遍历的键值对与被删除键值对的距离
        //       while table[(index + shiftAmount) mod capacity] != NULL do // 检测"情况2"
        //           preferredIndex ← hash(table[(i + s) mod N].key)  // 遍历到的键值对的实际哈希值
        //           if preferredIndex ∉ (index, index + shiftAmount] mod N then // 判断该哈希值是否先于或等于index
        //               table[index] ← table[(index + shiftAmount) mod N] // 如果是，补进被删除元素的位置
        //               table[(index + shiftAmount) mod N] ← NULL // 并且把这个被移动的元素的bucket清空
        //               index ← (index + shiftAmount) mod N // 对这个新空出来的bucket做同样的操作
        //               shiftAmount ← 1
        //           else
        //               shiftAmount ← shiftAmount + 1 // 如果当前键值对不符合"情况1"，再次进入循环继续遍历
        int shiftAmount = 1;
        HashNode node = null;
        while ((node = table[hash(index + shiftAmount)]) != null) {
            int preferredIndex = hash(node.key);
            if (!isIn(preferredIndex, index, shiftAmount)) {
                table[index] = node;
                table[hash(index + shiftAmount)] = null;
                index = hash(index + shiftAmount);
                shift(index);
                break;
            } else {
                shiftAmount++;
            }
        }
    }

    /*main方法
        main方法已经是完整的，不需要更改
        它会：
        1. 创建一个长度为5的哈希表
        2. 获取用户输入的一个int值，代表要插入的键的数量n
        3. 获取依次获取用户输入的三个键值对，并插入哈希表
        4. 获取用户输入的一个键key1，代表要被删除的键值对
        5. 删除key1这个键值对。
        6. 打印出整个哈希表
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTableLinearProbing hashTable = new HashTableLinearProbing(5);


//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            int key = scanner.nextInt();
//            String value = scanner.next();
//            hashTable.insert(key, value);
//        }

//        int key1 = scanner.nextInt();
//        hashTable.remove(key1);

        hashTable.insert(4, "a");
        hashTable.insert(5, "p");
        hashTable.insert(6, "b");


//        System.out.println(hashTable.search(33));
/**
 * 0：p，5
 * 1：b，6
 * 2：空
 * 3：空
 * 4：a，4
 */
        hashTable.remove(4);


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
