import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class SinglyLinkedList<T> {
  final T data;
  final SinglyLinkedList<T> next;
  private final boolean isDataNull;
  private final boolean isNextNull;

  private SinglyLinkedList(final T data, final SinglyLinkedList<T> next) {
    this.data = data;
    this.next = next;
    this.isDataNull = data == null;
    this.isNextNull = next == null;
  }

  public final static <T> SinglyLinkedList<T> empty() {
    return new SinglyLinkedList<T>(null, null);
  }

  final public SinglyLinkedList<T> insert(final T element) {
    if (element == null)
      throw new NullPointerException("nulls not allowed to be inserted");

    final SinglyLinkedList<T> newTail = new SinglyLinkedList<T>(element, null);

    if (isDataNull)
      return newTail;

    final SinglyLinkedList<T> appendedTail = isNextNull ? newTail : next.insert(element);

    return new SinglyLinkedList<T>(this.data, appendedTail);
  }

  public final void forEach(Consumer<T> element) {
    if (isDataNull)
      return;
    element.accept(this.data);
    if (!isNextNull)
      this.next.forEach(element);
  }

  final public <R> SinglyLinkedList<R> map(final Function<T, R> func) {
    if (isDataNull)
      return empty();

    final SinglyLinkedList<R> mappedNext = isNextNull ? null : next.map(func);

    return new SinglyLinkedList<R>(func.apply(data), mappedNext);

  }

  public final SinglyLinkedList<T> filter(final Predicate<T> predicate) {
    if (isDataNull)
      return empty();

    final SinglyLinkedList<T> filteredNext = isNextNull ? empty() : next.filter(predicate);

    if (predicate.test(data)) {
      return new SinglyLinkedList<>(data, filteredNext);
    } else {
      return filteredNext;
    }
  }

  @Override
  public String toString() {
    String baseString = "SinglyLinkedList(";
    if (isDataNull)
      return baseString + ")";

    return baseString + stringHelper(this, "") + ")";
  }

  private String stringHelper(
      final SinglyLinkedList<T> current,
      final String builtString) {
    String concatinatedString = builtString + current.data.toString();
    return current.isNextNull ? concatinatedString : stringHelper(current.next, concatinatedString + ", ");
  }
}
