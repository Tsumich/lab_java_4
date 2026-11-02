import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book implements Comparable<Book> {

    String name;
    String author;
    Integer publishingYear;
    String isbn;
    String publisher;

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Book)) return false;
        return this.isbn.equals(((Book)obj).isbn);
    }

    @Override
    public int compareTo(Book book) {
        return publishingYear.compareTo(book.getPublishingYear());
    }
}
