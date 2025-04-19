package BinarySearchTree;

import java.util.function.Consumer;

public class Traverse {
  final Node node;

  public Traverse(Node node) {
    this.node = node;
  }

  void inorder(Consumer<Integer> traverser) {
    if (node.isNull())
      return;

    node.left.traverse.inorder(traverser);
    traverser.accept(node.data);
    node.right.traverse.inorder(traverser);
  }

  void preorder(Consumer<Integer> traverser) {
    if (node.isNull())
      return;
    traverser.accept(node.data);
    node.left.traverse.preorder(traverser);
    node.right.traverse.preorder(traverser);
  }

  void postorder(Consumer<Integer> traverser) {
    if (node.isNull())
      return;
    node.left.traverse.postorder(traverser);
    node.right.traverse.postorder(traverser);
    traverser.accept(node.data);
  }
}
