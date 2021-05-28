
import java.util.Scanner;
import javax.swing.JOptionPane;


public class MainFiles {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int option;
        boolean restart = true;

        String memory[] = new String[99];
        int answerNumber = 0;
        String displayMemory[] = new String[5];

        System.out.println("Welcome to the physics problem solver. Please select the number of an option to continue.");
        while (restart == true) {
            System.out.println("1. Projectile Motion Problems");
            System.out.println("2. Inclined Plane Problems");
            System.out.println("3. Elevator Dynamic Problems");
            System.out.println("4. Access Memory");
            System.out.println("5. Programmer mode (Change Variables)");
            System.out.println("At no point can you input more than one '?' for one question or the program will break.");
            option = numscan.nextInt();
            System.out.println();

            switch (option) {
                case 1:

                    System.out.println("Does your calculation neglect air resistance?");
                    String airResist = wordscan.nextLine();
                    if (airResist.startsWith("y")) {
                        //run projectile problems for teachers/students
                        memory[answerNumber] = methods.projectileTeacherStudent();
                        answerNumber++;
                    } else {
                        //run method for teachers/students with resistance
                        memory[answerNumber] = methods.projectileResistance();
                        answerNumber++;
                    }
                    break;
                case 2:
                    memory[answerNumber] = methods.inclinedTeacherStudent();
                    answerNumber++;

                    break;
                case 3:
                    memory[answerNumber] = methods.elevatorTeacherStudent();
                    answerNumber++;
                    break;
                case 4:

                    for (int i = answerNumber - 1; i >= answerNumber - 5 && i >= 0; i = i - 1) {
                        displayMemory[answerNumber - i -1] = ((answerNumber - i) + ". " + memory[i]);
                    }

                    JOptionPane.showMessageDialog(null, "Here are your last 5 answers:\n " + displayMemory[0] + "\n " + displayMemory[1] + "\n " + displayMemory[2] + "\n " + displayMemory[3] + "\n " + displayMemory[4]);

                    System.out.println();
                    break;
                case 5:
                    methods.programmerEdit();
                    break;
                default:
                    System.out.println("You have chosen an option that our program does not offer. Would you like to try again?");
                    String tryAgain = wordscan.nextLine();
                    if (!(tryAgain.equalsIgnoreCase("yes"))) {
                        System.out.println("Understandable. Have a nice day.");
                        restart = false;
                    }
                    break;
            }//end switch
            if (answerNumber == 100) {
                answerNumber = 0;
            }
        }//end while
    }//end main
}//end class
