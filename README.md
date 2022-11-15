# CSC212-AnimalGuess

Assignment 8: Decision Trees
This assignment explores an application of binary decision trees. For some background on how decision trees can be used to classify items into categories, I recommend this chapter, up through and including section 4.3.1. (The sections 4.3.2 and beyond talk about how to build a decision tree from a preexisting set of data, which is not what we plan to do.)

Description of the Goal
You will implement a DecisionTree class as a subclass of BinaryTree<String>, and use it to write a program that will play a simple "20 Questions" style guessing game. For this assignment, your program will not have to infer a decision tree from instances. Rather, the user playing the game will help to create the tree. Each time the program guesses wrong, the tree will be extended by one node, as shown in the sample session below.

$ java AnimalGuess
Think of an animal.
I'll try to guess it.
Is your animal a Mouse?
no
I got it wrong.
Please help me to learn.
What was your animal?
Crocodile
Type a yes or no question that would distinguish between a Crocodile and a Mouse
Is it a mammal?
Would you answer yes to this question for the Crocodile?
no
Play again?
yes
Think of an animal.
I''ll try to guess it.
Is it a mammal?
no
Is your animal a Crocodile?
yes
I guessed it!
Play again?
no
$
Your program should try to guess the animal by asking the questions in a stored decision tree, and following the appropriate branch for the answer given by the user. (Yes = left, no = right). The leaves will contain an animal to guess. If the system guesses wrong, it will ask the user to add a question distinguishing the wrong guess from the correct answer. This question will be used to extend the decision tree. Your program should be able to read and write the decision tree from a text file, so that questions added during one session can be saved for later.

Organize your program into two classes, DecisionTree and AnimalGuess. The former is a data class to represent the knowledge used by the program, while the latter will contain static methods (including main) that will run the game. Try to separate tasks between these two classes in a sensible manner, designing DecisionTree as a potentially reusable class that is not too specialized for this particular application. You should design DecisionTree as a subclass of BinaryTree<String> that we developed together as a class.

Phase 1: DecisionTree
Begin by writing the DecisionTree class. This will give you the chance to build a subclass of the BinaryTree class we went over together. Most of the work will be to write revised constructors, accessors, and manipulators.

You should also write and test a function called followPath that will accept a String like YNNYNYY and use it to trace a path through the tree from the root. A Y means to follow the left child and a N means to follow the right child. The method should return the node that is reached after all the characters in the input string have been followed. Note that you can write this function either iteratively or recursively.

Before moving on to the next phase, it is probably a good idea to spend some time becoming accustomed to working with a tree. Write some test code that builds a sample decision tree with at least a half dozen nodes. (You can use the example below for inspiration.) Practice accessing the data at individual nodes via the root. For example, what node is accessed by the expression tree.getLeft().getRight().getData()? Move on to the next phase only when you feel reasonably comfortable with this one.

Phase 2: AnimalGuess
The next step is to write the code that runs the guessing game. The basic structure in main will be a loop, where each time through the loop represents a single guessing round. Beginning at the root you will keep track of the position in the tree as the player makes guesses and their response dictates whether to move left or right. Write the code to play just a single round of the game at first. Later on you can add an outer loop in case the player wants to play again after the first game -- or this can be handled by recursion.

For better clarity in your program, you may wish to define some short utility methods in AnimalGuess. For example, one might read a line of input with a try/catch block to handle possible exceptions or invalid responses. Another might take a prompt and elicit a yes or no answer from the user, returning a boolean. This would have several applications in the program. You should probably accept several forms of responses -- yes, Yes, y and Y for a positive answer, and the equivalent for a negative. Your program should also respond gracefully if the user enters something nonsensical, perhaps due to a typo.

Phase 3: Reading and Writing Trees
Your program should learn as it plays, but it's never going to amount to much if it forgets everything the next time you run it. We'd like to have the program remember what it learned between sessions. To allow for this, your program should be able to read a decision tree in from a text file when it starts up, and write it out again at the end. The name of this file will be specified as a command line argument, but for consistency's sake you should name it AnimalTree.txt. The format of the file is one node per line, in breadth-first order. Each line contains the path string of the node, a space, and the node's value (either a question or an animal name). Here is a simple example:

 Is it a mammal?
Y Does it have hooves?
N Is it a reptile?
YY Does it give milk?
YN Is it a carnivore?
NY Crocodile
NN Mosquito
YYY Cow
YYN Horse
YNY Is it in the dog family?
YNN Mouse
YNYY Dog
YNYN Cat
(Note that the space at the front of the first line is not a typo. It indicates that this is the data for the node with an empty path string -- the root!)

Output
Start by writing the method to write the tree to a file. Put it in class DecisionTree. You can test this using the hard-coded tree you created for phase 1. It should print the tree nodes line by line using breadth-first traversal. In addition to the queue of nodes to be visited, you will also need a paralle queue holding their paths.

We haven't written to files yet, but it's not hard. Create an output channel like so:

PrintWriter out = new PrintWriter(new FileWriter(filename));
Then you can write to it using out.println("Hello World") -- or whatever message you want to send. When you are all done, call out.close() to finish writing the file.

Input
The method to read in the tree will read a line at a time, split the line at the first space character to separate the path string from the node data (using indexOf and substring), and then use all but the final character of the path string to find the parent of the new node-to-be. The final character then determines whether the new node becomes the left child or the right.

Once you have both the reading and the writing, you will call the program as shown below:

java AnimalGuess AnimalTree.txt
It will read the tree in to start. When the user has finished playing the game, your program should write out the tree again using the same file name (overwriting the previous file).
