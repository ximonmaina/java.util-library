package StringHandling.stringconstructor;

public class MakeString {
    public static void main(String args[]) {
        char chars[] = {'J','a','v','a'};
        String s1 = new String(chars);
        String s2 = new String(s1);

        System.out.println(s1);
        System.out.println(s2);

    }
}
