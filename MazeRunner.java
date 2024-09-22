import java.util.*;

public class MazeRunner { Maze myMap = new Maze();

public static void main(String[] args) {
    Maze myMap = new Maze();
    intro();
    myMap.printMap();
    System.out.println("-----------------------------------------");

    int moves = 0;
    while (myMap.didIWin() == false) {
        userMove(myMap);
        movesMessage(moves);
        moves++;
    }

    if (myMap.didIWin() == true) {
        System.out.println("Congratulations, you made it out alive!");
        System.out.println("And you did it in " + moves + " moves.");

    }

}


public static void intro() {
    System.out.println("Welcome to Maze Runner!");
    System.out.println("Here is your current position: ");
}

public static String userMove(Maze myMap) {
    Scanner input = new Scanner(System.in);
    System.out.print("Where would you like to move? (R, L, U, D) ");
    String movement = input.nextLine();

    while (!movement.equalsIgnoreCase("R") && !movement.equalsIgnoreCase("L") &&
            !movement.equalsIgnoreCase("U") && !movement.equalsIgnoreCase("D")) {
        System.out.println("Invalid input.");
        System.out.print("Where would you like to move? R(ight), L(eft), U(p) or D(own)? ");
        movement = input.nextLine();
    }

    if (movement.equalsIgnoreCase("R") && myMap.canIMoveRight() == true) {
        myMap.moveRight();
    } else if (movement.equalsIgnoreCase("L") && myMap.canIMoveLeft() == true) {
        myMap.moveLeft();
    } else if (movement.equalsIgnoreCase("U") && myMap.canIMoveUp() == true) {
        myMap.moveUp();
    } else if (movement.equalsIgnoreCase("D") && myMap.canIMoveDown() == true) {
        myMap.moveDown();
    } else if (myMap.isThereAPit("R") || myMap.isThereAPit("L") || myMap.isThereAPit("U") || myMap.isThereAPit("D")) {
        navigatePit(myMap, movement);
    } else {
        System.out.println("Sorry, you’ve hit a wall.");
    }

    myMap.printMap();
    return movement;

}


public static void movesMessage(int moves) {
    if (moves == 50) {
        System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
    } else if (moves == 75) {
        System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
    } else if (moves == 90) {
        System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
    } else if (moves == 100) {
        System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        System.out.println("Sorry, but you didn't escape in time- you lose!");
        System.exit(0);
    }
}


public static String navigatePit(Maze myMap, String movement) {
    if (movement.equalsIgnoreCase("R") && myMap.isThereAPit("R")) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            myMap.jumpOverPit("R");
        }
    } else if (movement.equalsIgnoreCase("L") && myMap.isThereAPit("L")) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            myMap.jumpOverPit("L");
        }
    } else if (movement.equalsIgnoreCase("U") && myMap.isThereAPit("U")) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            myMap.jumpOverPit("U");
        }
    } else if (movement.equalsIgnoreCase("D") && myMap.isThereAPit("D")) {
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y") || answer.startsWith("Y")) {
            myMap.jumpOverPit("D");
        }
    }
    return movement;
}
}