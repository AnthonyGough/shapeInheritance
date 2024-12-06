package shapes;

import java.util.Scanner;

public class UserInput {
    private static Scanner input = null;



    public UserInput(){}

    public static Scanner getInstance() {
        if (input == null) {
            synchronized (UserInput.class) {
                if (input==null)
                    input = new Scanner(System.in);

            }

        }
       return input;
    }
}
