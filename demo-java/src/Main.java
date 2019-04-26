public class Main {

    public static void main(String[] args) {
        String s1= "This is C programming text";
        String s2 = "This is a text for C programming";
        System.out.println("-------第二长公共单词开始提取----------");
        new Sort().getCommon(s1,s2);
        System.out.println("-------第二长公共单词提取完毕----------");
        new Point().sum();
    }
}
