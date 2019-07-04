package aaaa;

/**
 * created by reedfan on 2019/7/2 0002
 */
public class Test {

    public static void main(String[] args) {

        String Str = new String("    www.runoob.com    ");
        System.out.print("原始值 :" );
        System.out.println( Str );

        System.out.print("删除头尾空白 :" );
        System.out.println( Str.trim() );

        String st1 = "hello";
        System.out.println(st1.lastIndexOf('l'));
        String str2 = "hfllo";
        System.out.println(st1.compareToIgnoreCase(str2));

        System.out.println("1      3");

        int a = '0';

        System.out.print(a);
        System.out.print("\n");
        int s = '1';
        System.out.println(s);


        int x1 = 3;

        Integer x2 = 6;
        System.out.println(x2.toString());


        Integer x4 = new Integer("10");

        System.out.println(x4);


       int x5 =  Integer.MAX_VALUE;
        System.out.println(x5+"");
        System.out.println(x5);

        System.out.println(x5+1);

        long x6 = Long.MAX_VALUE;
        System.out.println(x6);



    }
}
