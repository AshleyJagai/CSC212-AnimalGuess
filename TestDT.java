public class TestDT {
  public static void main(String[] args) {
    DecisionTree tree = new DecisionTree("Is it a Mammal?");
    tree.setLeft(new DecisionTree("Mouse"));
    tree.setRight(new DecisionTree("Crocodile"));
    System.out.println(tree.getLeft());
  }
}
