import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book(103, "Java Programming", "James Gosling"),
                new Book(101, "Python Basics", "Guido Rossum"),
                new Book(102, "Data Structures", "Robert Lafore"),
                new Book(104, "Algorithms", "Thomas Cormen")
        };
        System.out.println("Linear Search:");
        Book result1 =
                linearSearch(
                        books,
                        "Data Structures"
                );
        if(result1 != null)
            result1.display();
        else
            System.out.println("Book not found");
        // Sorting books before Binary Search
        Arrays.sort(
                books,
                Comparator.comparing(
                        book -> book.title
                )
        );
        System.out.println("\nBinary Search:");
        Book result2 =
                binarySearch(
                        books,
                        "Data Structures"
                );


        if(result2 != null)
            result2.display();

        else
            System.out.println("Book not found");




        System.out.println(
                "\nTime Complexity Analysis:"
        );


        System.out.println(
                "Linear Search: Best O(1), Average O(n), Worst O(n)"
        );


        System.out.println(
                "Binary Search: Best O(1), Average O(log n), Worst O(log n)"
        );


        System.out.println(
                "Binary Search is better for large sorted data, Linear Search is suitable for small or unsorted data."
        );

    }





    // Linear Search
    public static Book linearSearch(
            Book[] books,
            String title
    ) {


        for(Book book : books) {


            if(
                book.title.equals(title)
            ) {


                return book;

            }

        }


        return null;

    }






    // Binary Search
    public static Book binarySearch(
            Book[] books,
            String title
    ) {


        int left = 0;

        int right =
                books.length - 1;



        while(left <= right) {


            int mid =
                    (left + right) / 2;



            int compare =
                    books[mid]
                    .title
                    .compareTo(title);



            if(compare == 0) {


                return books[mid];

            }


            else if(compare < 0) {


                left =
                        mid + 1;

            }


            else {


                right =
                        mid - 1;

            }

        }


        return null;

    }

}





// Book Class
class Book {


    int bookId;

    String title;

    String author;



    public Book(
            int bookId,
            String title,
            String author
    ) {


        this.bookId =
                bookId;


        this.title =
                title;


        this.author =
                author;

    }




    public void display() {


        System.out.println(
                "Book ID: "
                + bookId
        );


        System.out.println(
                "Title: "
                + title
        );


        System.out.println(
                "Author: "
                + author
        );

    }

}
