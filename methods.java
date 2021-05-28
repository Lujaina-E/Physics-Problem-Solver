
import java.util.Scanner;

public class methods {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static double g = 9.81;
    public static double density = 1.29; //density of air at STP (in grams/litre)

    public static String projectileTeacherStudent() {
        System.out.println("Enter the initial velocity. (In meters per second)");
        String initialVelocity = wordscan.nextLine();
        System.out.println();
        if (!initialVelocity.equals("?")) {
            while (Double.parseDouble(initialVelocity) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the initial velocity in meters per second.");
                initialVelocity = wordscan.nextLine();
                System.out.println();
            }//end while
        }
        System.out.println("Enter the launch angle. (In degrees)");
        String angle = wordscan.nextLine();
        System.out.println();
        if (!angle.equals("?")) {
            while (Double.parseDouble(angle) <= 0 && Double.parseDouble(angle) > 90) {
                System.out.println("Your input was an invalid number, please correctly enter the angle in degrees.");
                angle = wordscan.nextLine();
                System.out.println();
            }//end while
        }
        System.out.println("Enter the distance. (In meters)");
        String distance = wordscan.nextLine();
        System.out.println();
        if (!distance.equals("?")) {
            while (Double.parseDouble(distance) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the distance in meters.");
                distance = wordscan.nextLine();
                System.out.println();
            }//end while
        }
        double t;
        double d;
        double Vi;
        double ang;
        double radians;

        if (distance.equals("?")) {//solving for distance
            ang = Double.parseDouble(angle);
            radians = Math.toRadians(ang);
            Vi = Double.parseDouble(initialVelocity);
            t = 2 * Math.sin(radians) * Vi / g;
            d = t * Vi * Math.cos(radians);
            System.out.println("The projectile traveled " + d + " meters horizontally.");
            System.out.println();
            System.out.println("Would you also like to know the total time of flight?");
            if (wordscan.nextLine().equalsIgnoreCase("yes")) {
                System.out.println();
                System.out.println("The projectile was in the air for " + t + " seconds.");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
            }
            return d + " meters";
        } else if (angle.equals("?")) {
            Vi = Double.parseDouble(initialVelocity);
            d = Double.parseDouble(distance);
            ang = Math.toDegrees(Math.asin(g * d / Math.pow(Vi, 2)) / 2);
            System.out.println("The projectile had a launch angle of " + ang + ". This angle is the smaller one, as there there two angular possibilities to every projectile question.");
            System.out.println();
            System.out.println("Would you like to know the other angle?");
            if (wordscan.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("The other possible angle is " + (90 - ang) + " degrees.");
                System.out.println();
            } else {
                System.out.println();
            }
            System.out.println("Would you like to know the total time of flight?");
            t = d / (Vi * Math.cos(Math.toRadians(ang)));
            if (wordscan.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("The projectile was in the air for " + t + " seconds.");
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
            }
            return ang + " degrees";
        } else if (initialVelocity.equals("?")) {
            d = Double.parseDouble(distance);
            ang = Double.parseDouble(angle);
            radians = Math.toRadians(ang);
            Vi = Math.pow((g * d / Math.sin(2 * radians)), 0.5);
            System.out.println("The projectile had a initial velocity of " + Vi + " meters per second.");
            System.out.println();
            System.out.println("Would you like to know the total time of flight?");
            t = d / (Vi * Math.cos(radians));
            if (wordscan.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("The projectile was in the air for " + t + " seconds.");
                System.out.println();
            }
            return Vi + " meters per second";
        } else {
            System.out.println("Something went wrong. Please try again and remember to input a question mark on the variable that you want to solve.");
            System.out.println();
            System.out.println();
            return "null";
        }

    }//end projectile_TeacherStudent

    public static String projectileResistance() {

        System.out.println("This mode will only solve for distance. (You must input all the values asked for)");
        System.out.println();
        System.out.println();

        System.out.println("What is the coefficient of drag of the object?");
        double Cd = numscan.nextDouble();
        System.out.println();

        while (Cd <= 0) {
            System.out.println("Your input was an invalid number (negative), please retry.");
            Cd = numscan.nextDouble();
            System.out.println();
        }

        System.out.println("What is the diameter of the object (in metres)? (this program only works for ciruclar objects in flight)");
        double diameter = numscan.nextDouble();
        System.out.println();
        while (diameter < 0) {
            System.out.println("Your input was an invalid number, please retry.");
            diameter = numscan.nextDouble();
            System.out.println();
        }
        double CS_area = 0.25 * Math.PI * diameter * diameter;
        System.out.println("Enter the initial velocity. (In meters per second)");
        double Vi = numscan.nextDouble();
        System.out.println();

        while (Vi <= 0) {
            System.out.println("Your input was an invalid number (negative), please retry.");
            Vi = numscan.nextDouble();
            System.out.println();
        }

        System.out.println("What is the mass of the object? (in kg)");
        double mass = numscan.nextDouble();
        System.out.println();
        while (mass <= 0) {
            System.out.println("Your input was an invalid number (negative), please retry.");
            mass = numscan.nextDouble();
            System.out.println();
        }
        System.out.println("Enter the launch angle. (In degrees)");
        double ang = numscan.nextDouble();
        System.out.println();
        while (ang <= 0) {
            System.out.println("Your input was an invalid number (negative), please retry.");
            ang = numscan.nextDouble();
            System.out.println();
        }
        double radians = Math.toRadians(ang);
        double Vh = Math.cos(radians) * Vi;
        double Fd = 0.5 * density * Cd * CS_area * Vh * Vh; //formula for drag force due to resistance
        System.out.println("The force of drag due to air resistance is " + Fd + " N.");
        System.out.println();
        System.out.println();

        double t;
        double d;

        t = 2 * Math.sin(radians) * Vi / g;
        double aDrag = -1 * Fd / mass;
        d = t * Vi * Math.cos(radians) + 0.5 * aDrag * Math.pow(t, 2);
        System.out.println("The projectile traveled approximately " + d + " meters horizontally.");
        System.out.println();
        System.out.println("Would you also like to know the total time of flight?");
        if (wordscan.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("The projectile was in the air for approximately " + t + " seconds.");
            System.out.println();
            System.out.println();
        } else {
            System.out.println();
        }

        return d + " meters";
    }//end projectileResistance

    public static String inclinedTeacherStudent() {
        System.out.println("What is the mass of the block? (Mass cannot be solved for so it must be provided in kilograms)");
        String mass = wordscan.nextLine();
        while (mass.equals("?")) {
            System.out.println("Your input was invalid. Please retry.");
            mass = wordscan.nextLine();
        }//end while
        double massdouble = Double.parseDouble(mass);
        System.out.println();
        while (massdouble <= 0) {
            System.out.println("Your input was an invalid number (negative), please correctly enter the mass in kilograms.");
            massdouble = numscan.nextDouble();
            System.out.println();
        }//end while

        System.out.println("What is the angle of inclination? (In degrees)");
        System.out.println("The angle MUST be given.");
        String angle = wordscan.nextLine();
        System.out.println();
        while (angle.equals("?")) {
            System.out.println("Your input was invalid, please correctly enter a number for the angle.");
            angle = wordscan.nextLine();
            System.out.println();
        }
        double ang = Double.parseDouble(angle);
        while (ang <= 0 && ang > 90) {
            System.out.println("Your input was an invalid number, please correctly enter the angle in degrees.");
            ang = numscan.nextDouble();
            System.out.println();
        }//end while

        System.out.println("What is the acceleration of the block? (In meters per second per second)");
        String acceleration = wordscan.nextLine();
        System.out.println();
        if (!acceleration.equals("?")) {
            while (Double.parseDouble(acceleration) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the acceleration in meters per second per second.");
                acceleration = wordscan.nextLine();
                System.out.println();
            }//end while
        }
        System.out.println("Is friction negligible?");
        String friction = wordscan.nextLine();
        System.out.println();
        double fparallel;
        double a;

        if (acceleration.equals("?")) {
            if (friction.equalsIgnoreCase("yes")) {//no friction
                double massValue = Double.parseDouble(mass);
                fparallel = (massValue * g) * (Math.sin(Math.toRadians(ang)));
                a = fparallel / massValue;
                System.out.println("The block will slide down the inclined plane with an acceleration of " + a + " m/s/s and with a force of " + fparallel + " N.");
                System.out.println();
                System.out.println();
                return a + " meters per second per second";
            } else {//friction exists
                //when friction isnt negligable solve for acceleration
                System.out.println("What is coefficient of friction?");
                double mew = numscan.nextDouble();
                System.out.println();
                a = g * (Math.sin(Math.toRadians(ang)) - ((Math.cos(Math.toRadians(ang))) * mew));
                System.out.println("The acceleration of the block down the slide is " + a + " m/s/s.");
                System.out.println();
                System.out.println();

                return a + " meters per second per second";
            }
        } else if (mass.equals("?")) {
            System.out.println("The mass can't be solved for because it cancels out from the equation.");
            System.out.println();
            return "N/A";
        } else {
            System.out.println("Something went wrong. Please try again and remember to input a question mark on the variable that you want to solve.");
            System.out.println();
            return "N/A";
        }
    }//end inclinedTeacherStudent   

    public static String elevatorTeacherStudent() {
        System.out.println("Enter the acceleration of the elevator. (In meters per second per second)");
        String acceleration = wordscan.nextLine();
        System.out.println();

        if (!acceleration.equals("?")) {
            while (Double.parseDouble(acceleration) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the acceleration in meters per second per second.");
                acceleration = wordscan.nextLine();
                System.out.println();

            }//end while
        }
        System.out.println("Enter the apparent weight of the person. (In Newtons)");
        String apparentWeight = wordscan.nextLine();
        System.out.println();

        if (!apparentWeight.equals("?")) {
            while (Double.parseDouble(apparentWeight) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the apparent weight in newtons.");
                apparentWeight = wordscan.nextLine();
                System.out.println();

            }//end while
        }
        System.out.println("Enter the mass of the person. (In kilograms)");
        String mass = wordscan.nextLine();
        System.out.println();

        if (!mass.equals("?")) {
            while (Double.parseDouble(mass) <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the mass in kilograms.");
                mass = wordscan.nextLine();
                System.out.println();

            }//end while
        }
        double a;
        double Fn;
        double m;

        if (acceleration.equals("?")) {
            Fn = Double.parseDouble(apparentWeight);
            m = Double.parseDouble(mass);
            a = (Fn - m * g) / m;
            if (a > 0) {
                System.out.println("The acceleration of the elevator is " + a + " meters per second in the upwards direction.");
                System.out.println();
                System.out.println();
                return a + " meters per second up";
            }
            if (a < 0) {
                System.out.println("The acceleration of the elevator is " + -1 * a + " meters per second in the downwards direction.");
                System.out.println();
                System.out.println();
                return -1 * a + " meters per second down";
            } else {
                System.out.println("The acceleration of the elevator is zero.");
                System.out.println();
                System.out.println();
                return "zero acceleration";
            }
        } else if (apparentWeight.equals("?")) {
            m = Double.parseDouble(mass);
            a = Double.parseDouble(acceleration);
            Fn = m * g + m * a;
            System.out.println("The apparent weight of the person is " + Fn + " Newtons.");
            System.out.println();
            System.out.println();
            return Fn + " Newtons";
        } else if (mass.equals("?")) {
            a = Double.parseDouble(acceleration);
            Fn = Double.parseDouble(apparentWeight);
            m = Fn / (g + a);
            System.out.println("The mass of the person is " + m + " kilograms.");
            System.out.println();
            System.out.println();
            return m + " kilograms";
        } else {
            System.out.println("Something went wrong. Please try again and remember to input a question mark on the variable that you want to solve.");
            System.out.println();
            System.out.println();
            return "N/A";
        }
    }//end elevator_TeacherStudent

    public static void programmerEdit() {
        System.out.println("What would you like to change the gravity variable to? (Do not include a negative sign)");
        g = numscan.nextDouble();
        System.out.println();

        while (g <= 0) {
            System.out.println("Your input was an invalid number (negative), please correctly enter the acceleration in meters per second per second.");
            g = numscan.nextDouble();
            System.out.println();

        }//end while
        System.out.println("What would you like to change the variable for the density of air too?");
        String dchoice = wordscan.nextLine();
        System.out.println();
        if (dchoice.equalsIgnoreCase("yes")) {
            System.out.println("Insert your new value for the desnity of air.");
            density = numscan.nextDouble();
            System.out.println();
            System.out.println();
            while (density <= 0) {
                System.out.println("Your input was an invalid number (negative), please correctly enter the acceleration in meters per second per second.");
                density = numscan.nextDouble();
                System.out.println();
                System.out.println();
            }//end while
        }

    }//end programmer_edit

}//end methods
