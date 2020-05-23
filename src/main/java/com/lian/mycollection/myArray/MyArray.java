package com.lian.mycollection.myArray;

import com.lian.mycollection.MyLink.MyLink;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author Ted
 * @version 1.0
 * @date 2020/5/23 13:14
 */
@Slf4j
public class MyArray {

    private Integer initialCapacity = 100000000;
    private Integer arrayRealSize = 0;

    private String dataType = "Object";
    private Object[] myArray = new Object[initialCapacity];

    public MyArray(String dataType,int initialCapacity){
            this.dataType = dataType;
            this.initialCapacity = initialCapacity;
    }

    public int capacity(){
        return initialCapacity;
    }

    public int size(){
        return arrayRealSize;
    }

    public Object get(int index){
        return myArray[index];
    }

    public  Object add(int index,Object element){
        if(arrayRealSize<initialCapacity){
            for (int i = arrayRealSize;i>index;i--){
                myArray[i]=myArray[i-1];
            }
            myArray[index] = element;
            arrayRealSize++;
        }else{
            arrayRealSize++;
            Object[] newArray = new Object[arrayRealSize];
            for(int i = 0;i<arrayRealSize-1;i++){
                newArray[i] = myArray[i];
            }
            for (int i = arrayRealSize-1;i>index;i--){
                newArray[i] = newArray[i-1];
            }
            newArray[index] = element;
            myArray = newArray;
        }
        return myArray[index];
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray("Integer", 10000000);
        Long initialStartTime = System.currentTimeMillis();
        for(int i = 0;i<10000000;i++){
            myArray.add(i,i);
        }
        Long initialEndTime = System.currentTimeMillis();
        MyLink<Integer> myLink = new MyLink<>();
        long initialLinkStartTime = System.currentTimeMillis();
        for(int i = 0;i<10000000;i++){
            myLink.add(i);
        }
        long initialLinkEndTime = System.currentTimeMillis();
        Long startTime = System.currentTimeMillis();
        Object add = myArray.add(5000000, 520);
        Long endTime = System.currentTimeMillis();
        long linkStartTime = System.currentTimeMillis();
        Object o = myLink.addByIndex(5000000, 520);
        long linkEndTime = System.currentTimeMillis();
        long queryArrayStartTime = System.currentTimeMillis();
        Object o1 = myArray.get(5000000);
        long queryArrayEndTime = System.currentTimeMillis();
        long queryLinkStartTime = System.currentTimeMillis();
        Object o2 = myLink.get(5000001);
        long queryLinkEndTime = System.currentTimeMillis();
        log.info("数组初始化用时{},数组插入用时{},得到数据{},数组查询用时{},得到数据{}",(initialEndTime-initialStartTime),(endTime-startTime),add,(queryArrayEndTime-queryArrayStartTime),o1);
        log.info("链表初始化用时{},链表插入用时{},得到数据{},链表查询用时{},得到数据{}",(initialLinkEndTime-initialLinkStartTime),(linkEndTime-linkStartTime),o,(queryLinkEndTime-queryLinkStartTime),o2);
    }
}
