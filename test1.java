import java.util.Scanner;

public class test1 {

    private static void moveSpacecraft(char command, int[] position, char direction) {
        int step = (command == 'f') ? 1 : -1;
        switch (direction) {
            case 'N':
                position[1] += step;
                break;
            case 'S':
                position[1] -= step;
                break;
            case 'E':
                position[0] += step;
                break;
            case 'W':
                position[0] -= step;
                break;
            case 'U':
                position[2] += step;
                break;
            case 'D':
                position[2] -= step;
                break;
        }
    }

    // Function to turn the spacecraft left or right
    private static char turnSpacecraft(char command, char direction) {
        char[] directions = {'N', 'E', 'S', 'W'};
        int index = 0;
        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == direction) {
                index = i;
                break;
            }
        }
        if (command == 'l') {
            index = (index + 3) % 4; // Left rotation
        } else if (command == 'r') {
            index = (index + 1) % 4; // Right rotation
        }
        return directions[index];
    }

    // Function to turn the spacecraft up or down
    private static char tiltSpacecraft(char command, char tilt) {
    switch (command) {
        case 'u':
            return 'U'; // Rotate upwards
        case 'd':
            return 'D'; // Rotate downwards
        default:
            return tilt; // Invalid command, no change in tilt direction
    }
}



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial position and direction of the spacecraft
        int[] position = {0, 0, 0};
        char direction = 'N';
        char exitCommand = '0';

        while (true) {
            System.out.println("\nEnter a command for Chandrayaan 3 (f/b/l/r/u/d) or press 0 to exit: ");
            String input = scanner.nextLine();

            if (input.length() == 1) {
                char command = input.charAt(0);
                if (command == exitCommand) {
                    System.out.println("Exiting the program...");
                    break;
                } else if (command == 'f' || command == 'b') {
                    moveSpacecraft(command, position, direction);
                    System.out.println("Current position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");
                    System.out.println("Current direction: " + direction);
                } else if (command == 'l' || command == 'r') {
                    direction = turnSpacecraft(command, direction);
                    System.out.println("Current position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");
                     System.out.println("Current direction: " + direction);
                } else if (command == 'u' || command == 'd') {
                    direction = tiltSpacecraft(command, direction);
                    System.out.println("Current position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");
                     System.out.println("Current direction: " + direction);
                } else {
                    System.out.println("Invalid command! Try again.");
                }
            } else {
                System.out.println("Invalid command! Try again.");
            }
        }
        // Print the final position and direction of the spacecraft
        System.out.println("Final position: (" + position[0] + ", " + position[1] + ", " + position[2] + ")");
        System.out.println("Final direction: " + direction);

        scanner.close();
    }
}