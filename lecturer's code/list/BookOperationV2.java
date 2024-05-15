
import java.util.ArrayList;
import java.util.Scanner;


public class BookOperationV2 
{
    private ArrayList <Book> books ;
    
    
    public BookOperationV2() 
    {
        books = new ArrayList<Book>();
    }
    
    public void addBook(Book book)
    {
        books.add(book);
    }
    
    public void displayAllBooks()
    {
        for (int i=0; i<books.size(); i++)
        {
            System.out.println("Title = "+books.get(i).getTitle());
            System.out.println("Author = "+books.get(i).getAuthor());
            System.out.println("Year = "+books.get(i).getYear());
            System.out.println("");
        }
    }
    
    public void searchBookTitle(String titleName)
    {
        for (int i=0; i<books.size(); i++)
        {
            if (books.get(i).getTitle().equalsIgnoreCase(titleName))
            {
                System.out.println("The title name is found");
                System.out.println("Title = "+books.get(i).getTitle());
                System.out.println("Author = "+books.get(i).getAuthor());
                System.out.println("Year = "+books.get(i).getYear());
                System.out.println("");
            }
        }
    }
    
    public void removeBook(String titleName)
    {
        for (int i=0; i<books.size(); i++)
        {
            if (books.get(i).getTitle().equalsIgnoreCase(titleName))
            {
                books.remove(i);
            }
        }
    }
    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Book book;
        BookOperationV2 ope = new BookOperationV2();
    
        book = new Book("Java Language", "Ali",2022);
        ope.addBook(book);
        
        book = new Book("C Language", "Abu",2023);
        ope.addBook(book);
        
        book = new Book("C++ Language", "Ani",2020);
        ope.addBook(book);
        
        ope.displayAllBooks();
        
        System.out.print("Please enter an title name to be searched = ");
        String titleName = scan.nextLine();
        ope.searchBookTitle(titleName);
        
        System.out.print("Please enter an title name to be removed = ");
        titleName = scan.nextLine();
        ope.removeBook(titleName);
        System.out.println("After removing second book");
        ope.displayAllBooks();
        
    }
    
}
