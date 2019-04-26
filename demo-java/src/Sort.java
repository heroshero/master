import java.util.*;

/**
 * @author xinli9
 * @date 16:58
 * @version 1.0
 */
public class Sort {
    public void getCommon(String s1, String s2){
        String[] res1 = s1.split(" ");
        String[] res2 = s2.split(" ");
        //比较数组长度标志符号，供后面排序排序使用
        Boolean flag = res1.length>res2.length;
        HashSet set=new HashSet<>();
        //匹配公共字符串
        for(String temp:flag == true ?res1:res2){
            for(String temp1: flag == true ?res2:res1){
                    if(temp.equals(temp1)){
                        set.add(temp);
                    }
            }
        }
        System.out.println(getOrderBylength(set));
     }
    public String getOrderBylength(Set set){
        List<String> result = new ArrayList<>(set);
        //排序
        Collections.sort(result,new SortbyLength());
        if(result.size()>=  2){
            return result.get(1);
        }
        return null;
    }
    class SortbyLength implements Comparator{
        @Override
        public int compare(Object o1, Object o2) {
            String str1 = o1.toString();
            String str2 = o2.toString();
            if(str1.length()>str2.length()){
                return -1;
            }else{
                return 1;
            }
        }
    }
}

