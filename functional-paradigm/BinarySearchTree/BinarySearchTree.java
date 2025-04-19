package BinarySearchTree;

public class BinarySearchTree {
  final Node node;
  final Traverse traverse;

  public BinarySearchTree() {
    this.node = Node.empty();
    this.traverse = this.node.traverse;
  }

  public BinarySearchTree(Node node) {
    this.node = node;
    this.traverse = this.node.traverse;
  }

  public BinarySearchTree insert(final Integer element) {
    return new BinarySearchTree(node.insert(element));
  }

}
