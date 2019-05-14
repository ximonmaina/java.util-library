package StringHandling.modifystring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseTrim {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter State: ");

        do{
            str = br.readLine();
            str = str.trim();

            if(str.equals("Illinois")){
                System.out.println("Capital is Springfield.");
            }else if(str.equals("Missouri")) {
                System.out.println("Capital is Jefferson City");
            }else if(str.equalsIgnoreCase("stop")){
                System.out.println("Exiting program...");
            }
            else {
                System.out.println("Not in database. Try something else");
            }
        }while(!str.equals("stop"));
    }
}
