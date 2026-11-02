import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class BookReader {

    String name;
    String surname;
    String phone;
    boolean subscribed;
    ArrayList<Book> favoriteBooks;

}
