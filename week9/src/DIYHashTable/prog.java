package DIYHashTable;

import java.util.Scanner;

/*
    HashTable类是一个哈希表抽象类，它对其子类制定以下规则：
    1. hash方法：
        获取键的哈希值。
    2. insert方法：
        所有子类必须有自己的insert方法用于插入。参数为键值对的键和值。
    3. remove方法：
        所有子类必须有自己的remove方法用于删除元素。参数为被删除元素的键。
    4. search方法：
        所有子类必须有自己的search方法用于查找元素。参数为被查找元素的键。
 */
abstract class HashTable {
    public abstract int hash(int key);

    public abstract boolean insert(int key, String value);

    public abstract boolean remove(int key);

    public abstract String search(int key);
}


/*
    ChainingHashTableItem类是使用了链表法的哈希表中每个元素的类。
    它与单链表节点类的格式相似，但区别是每个节点的值有两部分，键和值。
*/
class ChainingHashTableItem {

    //    在这里补全它的三个公有成员变量：
    //        1. int类型的键
    //        2. String类型的值
    //        3. 和ChainingHashTableItem类型的next
    //
    public int itemKey;
    public String itemValue;
    public ChainingHashTableItem next;

    ChainingHashTableItem(int itemKey, String itemValue) {

        //在这里补全ChainingHashTableItem类的构造器
        this.itemKey = itemKey;
        this.itemValue = itemValue;
        this.next = null;
    }
//    @Override
//    public String toString() {
//        return "ChainingHashTableItem{" +
//                "itemKey=" + itemKey +
//                ", itemValue='" + itemValue + '\'' +
//                ", next=" + next +
//                '}';
//    }
}


/*
    ChainingHashTable类继承自抽象类HashTable。
    它规定了使用链表法的哈希表中插入，删除，搜索三个方法应该如何实现。
    这里的ChainingHashTableItem[]是ChainingHashTable的一个私有变量，
    它是一个由ChainingHashTableItem组成的数组，用于存储哈希表的所有数据。
    由于ChainingHashTableItem是一个类似链表节点的类，数组的每个元素都是一个链表，这帮助我们解决了哈希表冲突。
*/
class ChainingHashTable extends HashTable {

    protected ChainingHashTableItem[] table;

    @Override
    public int hash(int key) {
        //定义哈希函数为【键 % 表长】。
        return key % table.length;
    }

    public ChainingHashTable(int initialCapacity) {
        table = new ChainingHashTableItem[initialCapacity];
    }

    public ChainingHashTable() {
        this(5);
    }

    @Override
    public boolean insert(int key, String value) {

        // 遍历索引为bucketIndex的bucket的链表，查找我们要插入的键是否已经存在。
        // 如果存在，更新它的值。
        // 如果不存在，加入这个新的对象。
        // 如果成功更新或添加，返回false。 //todo true？
        // 提示：可以参考链表中的插入方法是怎么做的。

        //定位bucket
        int bucketIndex = hash(key);
        ChainingHashTableItem bucket = table[bucketIndex];

        //在链表中查找
        //链表为空 加入新对象，链表head存入table
        if (bucket == null) {
            bucket = new ChainingHashTableItem(key, value);
            table[bucketIndex] = bucket;
        } else {
            //链表不为空 遍历查找是否存在
            ChainingHashTableItem curr = bucket;
            ChainingHashTableItem temp = null;
            while (curr != null) {
                if (curr.itemKey == key) {//找到匹配的key
                    //替换value
                    curr.itemValue = value;
                    return true;
                }
                temp = curr;//整个链表都不存在匹配时 最后一次循环 暂存tail
                curr = curr.next;
            }
            temp.next = new ChainingHashTableItem(key, value);//添加节点到链表最后

        }
        return true;
    }

    @Override
    public boolean remove(int key) {

        //remove方法制定了在哈希表中删除元素的规则。
        //首先确定要删除的键应该在哪个bucket中找，
        //然后确定这个bucket是否包含该对象：
        //如果是，删除哈希表中这个键值对，并返回true；
        //如果不是，返回false。
        //提示：可以参考链表中的删除方法是怎么做的。

        //定位bucket
        int bucketIndex = hash(key);
        ChainingHashTableItem bucket = table[bucketIndex];

        //在链表中查找
        if (bucket != null) {
            //链表不为空 遍历查找是否存在
            //head匹配
            if (bucket.itemKey == key) {
                table[bucketIndex] = bucket.next;//head后移
                bucket.next = null; //help gc
                return true;
            }
            //head以后item匹配
            ChainingHashTableItem curr = bucket;
            while (curr.next != null) {
                if (curr.next.itemKey == key) {
                    //删除item
                    ChainingHashTableItem temp = curr.next;
                    curr.next = curr.next.next;
                    temp.next = null;
                    return true;
                }
                curr = curr.next;
            }
        }
        return false;
    }

    @Override
    public String search(int key) {

        //search方法制定了在哈希表中查找元素的规则。
        //如果要查找的键在哈希表中，返回true；如果不在，返回false。
        //如果要查找的键在哈希表中，返回查找结果；如果不在，返回null。 //todo ？
        //提示：上面两个方法中我们是如何查找的？
        //在这里补全search方法

        //定位bucket
        int bucketIndex = hash(key);
        ChainingHashTableItem bucket = table[bucketIndex];

        //在链表中查找
        //链表为空
        if (bucket == null) {
            return null;
        }
        //链表不为空 遍历
        ChainingHashTableItem curr = bucket;
        while (curr != null) {
            if (curr.itemKey == key) {//找到匹配
                return curr.itemValue;
            }
            curr = curr.next;
        }
        return null;
    }
//    @Override
//    public String toString() {
//        return "ChainingHashTable{" +
//                "table=" + Arrays.toString(table) +
//                '}';
//    }

}

public class prog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ChainingHashTable hashTable = new ChainingHashTable();

        //获取三组对象
//        for (int i = 0; i < 3; i++) {
//            int key = scanner.nextInt();
//            String value = scanner.next();
//
//            hashTable.insert(key, value);
//        }
        hashTable.insert(11, "cool");
        hashTable.insert(1, "hi");
        hashTable.insert(2, "hiii");
        hashTable.insert(3, "ohhhi");
        hashTable.insert(6, "woo");
        hashTable.insert(2, "233");

        System.out.println(hashTable.search(2));
        System.out.println(hashTable.search(5));
        System.out.println(hashTable.search(11));
        System.out.println(hashTable.search(6));

        System.out.println(hashTable.remove(11));
        for (int i = 0; i < hashTable.table.length; i++) {
            System.out.print(i + ": ");
            ChainingHashTableItem item = hashTable.table[i];
            while (item != null) {
                System.out.print(item.itemValue);
                if (item.next != null) {
                    System.out.print("->");
                }
                item = item.next;
            }
            System.out.println();
        }
    }
}
