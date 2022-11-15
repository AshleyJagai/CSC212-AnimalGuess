/**
 *  Implements a binary decision tree
 *
 *  @author Ashley Jagai and Janice Salter
 *  @version Spring 2022
 *
 */
public class DecisionTree extends BinaryTree<String> {
  
  /** leaf constructor */
  public DecisionTree(String s) {
    super(s);
  }
  
  /**Constructors, Accessors and Manipulators*/

  /** @override */
  public void setLeft(BinaryTree<String> left) {
    if ((left==null)||(left instanceof DecisionTree)) {
      super.setLeft(left);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /** @override */
  public void setRight(BinaryTree<String> right){
    if((right==null)||(right instanceof DecisionTree)){
      super.setRight(right);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /** @override */
  public DecisionTree getLeft() {
    return (DecisionTree)super.getLeft();
  }

  /** @override*/
  public DecisionTree getRight(){
    return (DecisionTree)super.getRight();
  }

  /**Traces the path through the tree from the root */  
  public DecisionTree followPath(String path){
    DecisionTree node = this;
    for(int i = 0;i < path.length(); i++){
      if(path.charAt(i) == 'Y'){
        node = node.getLeft();
      } if(path.charAt(i) == 'N'){
        node = node.getRight();
      }
    }
    return node;
  }
}
