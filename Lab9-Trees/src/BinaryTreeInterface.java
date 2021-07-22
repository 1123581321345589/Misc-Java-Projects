public interface BinaryTreeInterface <T> extends TreeInterface <T>, TreeIteratorInterface <T> {

  public void setTree (T t);

 
  public void setTree (T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);  
  
}
