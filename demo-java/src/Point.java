import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @Description: TODO
 * @author xinli9
 * @date Sum 9:47
 * @version 1.0
 */

public class Point{
    public  void sum() {
        //全局变量
        Boolean flag =false;
        //输入一个整
        Scanner in =new Scanner(System.in);
        //读取一个整数
        int a=in.nextInt();
        System.out.printf("输入数字为=%d\n", a);
        // n1为最开头的数
        for(int n1=1; n1<=a/2; n1++)
        {
            // n2为最末尾的数
            for(int n2=n1+1; n2<a; n2++)
            {
                // 用等差数列公式算和
                if((n1+n2)*(n2-n1+1) == a*2)
                {
                    //如果相等就输出结果
                    for(int t=n1; t<=n2; t++)
                    {
                        System.out.printf("%d,", t);
                    }
                    System.out.printf("\n");
                    flag =true;
                }
            }
        }
        if(!(flag)){
            System.out.println("NONE");
        }
    }
}