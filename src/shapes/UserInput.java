package shapes;

import java.util.Scanner;

public class UserInput {
   private static final Scanner input = new Scanner( System.in );



    private UserInput(){}

    public static boolean hasNext()         { return UserInput.hasNext();         }
    public static boolean hasNextBoolean()  { return UserInput.hasNextBoolean();  }
    public static boolean hasNextDouble()   { return UserInput.hasNextDouble();   }
    public static boolean hasNextInt()      { return UserInput.hasNextInt();      }
    public static boolean hasNextLine()     { return UserInput.hasNextLine();     }
    public static boolean hasNextLong()     { return UserInput.hasNextLong();     }
    public static String next()             { return UserInput.next();            }
    public static boolean nextBoolean()     { return UserInput.nextBoolean();     }
    public static double nextDouble()       { return UserInput.nextDouble();      }
    public static int nextInt()             { return UserInput.nextInt();         }
    public static long nextLong()           { return UserInput.nextLong();        }
    public static String nextLine()         { return UserInput.nextLine();        }
}


