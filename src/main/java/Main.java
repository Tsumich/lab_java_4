import com.google.gson.*;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] arg) throws FileNotFoundException {
        Gson gson = new Gson();
        //BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\student\\Desktop\\14\\lab_java_3\\src\\main\\java\\book.json"));
        BufferedReader reader = new BufferedReader(new FileReader("book.json"));
        BookReader[] users = gson.fromJson(reader, BookReader[].class);

        //ex_1_count_readers(users);
        //C:\Users\student\Desktop\14\lab_java_3\src\main\java\book.json
        //ex_2(users);
        //ex_3(users);
        //ex_4(users);
        //ex_5(users);
        ex_6(users);

    }

    public static void check_read_buffer(BufferedReader reader) throws IOException {

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line + "\n");
        }
    }

    public static void ex_1_count_readers(BookReader[] users){
        int count = 0;

        for (int i = 0; i < users.length; i++) {
            count ++;
            System.out.println(i + 1 + ")" + users[i].getName());
        }

        System.out.println("Всего читателей: " + count);

    }

    public static void ex_2(BookReader[] users){
        for (BookReader user : users) {
            System.out.println('\t' + user.getName());
            ArrayList<String> check_dublicates = new ArrayList<>();
            int count = 0;
            for (int j = 0; j < user.getFavoriteBooks().size(); j++) {
                String current_book_isbn = user.getFavoriteBooks().get(j).getIsbn();
                if (!check_dublicates.contains(current_book_isbn)) {
                    count++;
                    check_dublicates.add(user.getFavoriteBooks().get(j).getIsbn());
                    System.out.println(j + 1 + " - " + user.getFavoriteBooks().get(j).getName());
                }
            }
            System.out.println("Всего книг: " + count + '\n');
        }
    }

    public static void ex_3(BookReader[] users){
        HashSet<Book> books_list = new HashSet<Book>();

        for (BookReader user : users) {
            books_list.addAll(user.getFavoriteBooks());
        }

        ArrayList<Book> sortedList = new ArrayList<>(books_list);
        Collections.sort(sortedList);

        for (Book book : sortedList) {
            System.out.println(book.getName() + " - " + book.getPublishingYear());
        }
    }

    public static void ex_4(BookReader[] users){
        for (BookReader user : users) {
            for(Book book : user.getFavoriteBooks()){
                if(Objects.equals(book.getAuthor(), "Jane Austen")){
                    System.out.println("Джейн Остин есть у " + user.getName());
                }
            }
        }
    }

    public static void ex_5(BookReader[] users){
        int max_book_amount = 0;
        for (BookReader user : users) {
            int current_user_amount = user.getFavoriteBooks().size();
            if(current_user_amount > max_book_amount){
                max_book_amount = current_user_amount;
            }
        }
        System.out.println("Максимальное количество книг: " + max_book_amount);
    }

    public static void ex_6(BookReader[] users){

        double AVG = 0.0;
        int favorite_book_amount = 0;
        int people_amount = users.length;

        for (BookReader user : users) {
            favorite_book_amount += user.favoriteBooks.size();
        }

        AVG = favorite_book_amount/people_amount;
        System.out.println("Среднее количество книг : " + AVG);

        for (BookReader user : users) {
            if(user.isSubscribed()){
                SMS_for_readers sms;
                if(user.getFavoriteBooks().size() > AVG){
                    sms = new SMS_for_readers(user.getPhone(), "you are a bookworm");
                }
                else if(user.getFavoriteBooks().size() == AVG){
                    sms = new SMS_for_readers(user.getPhone(), "fine");
                }else{
                    sms = new SMS_for_readers(user.getPhone(), "read more");
                }
                sms.sendMessaege();
            }
        }
    }
}


