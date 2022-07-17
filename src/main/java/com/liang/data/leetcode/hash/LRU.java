package com.liang.data.leetcode.hash;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.logging.Level;

/**
 * @author liangyt
 * @create 2022-07-10 10:14
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 */
public class LRU {
    private int capacity;
    private HashMap<Integer, Node> hashMap = new HashMap();
    private Node head;
    private Node tail;
    
    public LRU(int capacity) {
        this.capacity = capacity;
         head = new Node();
         tail = new Node();
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        if (!hashMap.containsKey(key)){
            return -1;
        }
        Node node = hashMap.get(key);
        //查到Node进行顺序的更新
        remove(node);
        insert(head,node);
        return node.value;

    }

    private void insert(Node head, Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)){
            Node node = new Node();
            node.key = key;
            node.value = value;
            hashMap.put(key,node);
            insert(head,node);
            if (hashMap.size()>capacity){
                hashMap.remove(tail.pre.key);
                remove(tail.pre);
            }
        }else {
            Node node = hashMap.get(key);
            node.value = value;
            remove(node);
            insert(head,node);
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
    }

    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
}
