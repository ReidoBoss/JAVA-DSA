import java.util.function.Function;

public class SinglyLinkedList<T> {
  private T data;
  private SinglyLinkedList<T> next;

  private SinglyLinkedList(T data) {
    this.data = data;
    this.next = null;
  }

  public static <T> SinglyLinkedList<T> empty() {
    return new SinglyLinkedList<>(null);
  }

  public <R> SinglyLinkedList<R> map(Function<T, R> transform) {
    if (this.data == null) {
      return new SinglyLinkedList<>(null);
    }
    SinglyLinkedList<R> newHead = new SinglyLinkedList<>(transform.apply(this.data));
    SinglyLinkedList<R> currentNew = newHead;
    SinglyLinkedList<T> currentOld = this.next;

    while (currentOld != null && currentOld.data != null) {
      currentNew.next = new SinglyLinkedList<>(transform.apply(currentOld.data));
      currentNew = currentNew.next;
      currentOld = currentOld.next;
    }

    return newHead;
  }

  public SinglyLinkedList<T> insert(T e) {
    if (this.data == null) {
      return new SinglyLinkedList<T>(e);
    } else if (this.next == null) {
      SinglyLinkedList<T> result = new SinglyLinkedList<>(this.data);
      result.next = new SinglyLinkedList<>(e);
      return result;
    } else {
      SinglyLinkedList<T> result = new SinglyLinkedList<>(this.data);
      result.next = this.next.insert(e);
      return result;
    }
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder("SinglyLinkedList(");
    SinglyLinkedList<T> current = this;

    while (current != null && current.data != null) {
      sb.append(current.data);
      current = current.next;
      if (current != null && current.data != null) {
        sb.append(", ");
      }
    }

    sb.append(")");
    return sb.toString();
  }

}
