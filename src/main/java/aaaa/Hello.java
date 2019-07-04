package aaaa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * created by reedfan on 2019/6/25 0025
 */
public class Hello {


    public static void main(String[] args) {

        int[] num = new int[5];

        int[] num1 = {1,2,3};

        String str = "123x";



        for (int j = 0; j < 5; j++) {
           num[j] = j;

        }

        for (int i = 0; i < 5; i++) {

            if(num[i] %2 ==0){
                System.out.println(num[i]);
            }

        }



        int[][] erwei = new int[2][2];

        int k = 1;
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                erwei[row][col] = k++;

            }

        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(erwei[row][col]);
                System.out.print(" ");

            }
            System.out.println();

        }


        ArrayList<String> list = new ArrayList<String>();

        list.add("ss");
        list.add("aa");
        list.remove("ss");
        //  System.out.println(list.size());
        list.add("ss");
        list.add("ss");

     /*   for (int i = 0; i < list.size() ; i++) {
           String str11 = list.get(i)
            System.out.println(str11);
        }
*/
        for (String str11 : list) {
            System.out.println(str11);

        }

      /*  HashSet<String> set = new HashSet<String>();
        set.add("aa11");
        set.add("aa11");
        set.add("ss11");
*/

      /*  HashMap<String,Integer> hashMap = new HashMap<String, Integer>();

        for (String str : list) {
            if (hashMap.containsKey(str)) {
                Integer n = hashMap.get(str);
                hashMap.put(str, ++n);

            } else {
                hashMap.put(str, 1);

            }
        }

        for(String  str11 :hashMap.keySet()){
            if(hashMap.get(str11)>1){
                System.out.println(str11);
            }


        }*/

        int i1 = 3;
        int i2 = 2;
        if (i1 > i2 || i1 == i2) {
            System.out.println(i1);
        } else {
            System.out.println(i2);
        }


        boolean res = false;
        if (!res) {

        }

        int x = 123;
        int n1 = 0;
        while (x > 0) {
            x = x / 10;
            n1++;
        }
        System.out.println(n1);


    }


}
