package BinarySearchTree;

public class Node {
  final Node left;
  final Integer data;
  final Node right;
  final Traverse traverse = new Traverse(this);;

  public Node(
      Node left,
      Integer data,
      Node right) {
    this.left = left;
    this.data = data;
    this.right = right;
  }

  public static Node lonely(Integer data) {
    return new Node(empty(), data, empty());
  }

  public Boolean isNull() {
    return data == null;
  }

  public static Node empty() {
    return new Node(null, null, null);
  }

  public Node insert(final Integer element) {
    if (isNull()) {
      return lonely(element);
    } else if (element < data) {
      return new Node(left.insert(element), data, right);
    } else {
      return new Node(left, data, right.insert(element));
    }
  }
}
