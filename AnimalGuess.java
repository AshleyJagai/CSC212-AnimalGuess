import java.util.Scanner;
/**
* Class that runs the Guessing Game
* 
* @author Ashley Jagai and Janice Salter
* @version Spring 2022
*
*/

public class AnimalGuess{
  public static void main(String[] args){
    
    /**Node of the first leaf*/
    DecisionTree leaf1 = new DecisionTree("Mouse");

    /**Pointer to the leaf*/
    DecisionTree current = leaf1;

    /**Determines whether the game is being played*/
    boolean playing = true; 

    /**Receives the input from the user*/
    Scanner input = new Scanner(System.in);
    String answer;

    
    while (playing == true) {
      System.out.println("Think of an animal.");
      System.out.println("I'll try to guess it.");
      if (current.isLeaf()) {
        System.out.println("Is the animal a " + current.getData() + "?");
        answer = input.nextLine();
        if (userAnswer(answer)== false) {
          System.out.println("I got it wrong.");
          System.out.println("Please help me to learn.");
          System.out.println("What was your animal?");
          answer = input.nextLine();

          DecisionTree newAnimal = new DecisionTree(answer);
          System.out.println("Type a yes or no question that would distinguish between a " + newAnimal + " and a "+ current);

          answer = input.nextLine();
          DecisionTree leaf2 = new DecisionTree(answer);
          System.out.println("What would your answer to:  " + answer + " , be for the " + newAnimal + "? (yes or no)");
          
          answer = input.nextLine();
          if (userAnswer(answer) == false)
          {
            current = leaf2;
            current.setLeft(leaf1);
            
            System.out.println("Left of leaf: " + current.getLeft().getData());
          }
          else if (userAnswer(answer) == true)
          {
            current = leaf2;
            current.setRight(leaf1);
            System.out.println("Right of leaf: " + current.getRight().getData());
          }
          System.out.println("Great! Do you want to play again?");
          answer = input.nextLine();
          if (answer.equals("No")|| input.equals("no") || input.equals("N")||input.equals("n"))
            break;
        }
        else
        {
          System.out.println("Great! Do you want to play again?");
          answer = input.nextLine();
          if (answer.equals("No")|| input.equals("no") || input.equals("N")||input.equals("n"))
            break;
        }
      }
      else {
        System.out.println(current.getData());
        String answer1  = input.nextLine();
        if(userAnswer(answer1) == true)
        {
          current = current.getLeft();
        }
        else
        {
          current = current.getRight();
        }
      }
    }
  }

  /**A method that returns a boolean based on whether the user input is "Yes" or "No"*/
  public static boolean userAnswer(String input){
     if(input.equals("No")|| input.equals("no") || input.equals("N")||input.equals("n"))
      {
        DecisionTree newleaf = new DecisionTree(input);
        return false;

      }
       if (input.equals("Yes")|| input.equals("yes")|| input.equals("Y") ||input.equals("y"))
      {
        DecisionTree newleaf = new DecisionTree(input);
        return true;

      }
    return false;                                         
  }
}

