
import java.util.ArrayList;
import java.util.Scanner;


public class BookOperation 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Book book;
        ArrayList <Book> books = new ArrayList<Book>();
    
        book = new Book("Java Language", "Ali",2022);
        books.add(book);
        book = new Book("C Language", "Abu",2023);
        books.add(book);
        book = new Book("C++ Language", "Ani",2020);
        books.add(book);
        
        for (int i=0; i<books.size(); i++)
        {
            System.out.println("Title = "+books.get(i).getTitle());
            System.out.println("Author = "+books.get(i).getAuthor());
            System.out.println("Year = "+books.get(i).getYear());
            System.out.println("");
        }
        
        books.remove(1);
        System.out.println("After removing second book");
        for (int i=0; i<books.size(); i++)
        {
            System.out.println("Title = "+books.get(i).getTitle());
            System.out.println("Author = "+books.get(i).getAuthor());
            System.out.println("Year = "+books.get(i).getYear());
            System.out.println("");
        }
        
        System.out.print("Please enter a title name to be searched = ");
        String titleName = scan.nextLine();
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
    
}
