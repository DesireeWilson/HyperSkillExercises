// write your class here
public class Main{
    public static void main(String[] args) {
        String[] authors = {"John Steinbeck", "Amy Tan"};
        Book book = new Book("Gone With the Wind", 1854, authors);
    }
}
class Book{
    String title;
    int yearOfPublishing;
    String[] authors;

    Book(String title, int publishYear, String[] authors){
        this.title = title;
        this.yearOfPublishing = publishYear;
        this.authors = authors;
    }
}