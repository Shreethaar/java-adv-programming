
import java.util.ArrayList;
import java.util.Scanner;


public class BookOperationStatic 
{
    private static ArrayList <Book> books = new ArrayList<Book>(); ;
    
    public static void addBook(Book book)
    {
        books.add(book);
    }
    
    public static String displayAllBooks()
    {
        String output="";
        for (int i=0; i<books.size(); i++)
        {
            output+= "Title = "+books.get(i).getTitle()+"\n"+
                    "Author = "+books.get(i).getAuthor()+"\n"+
                     "Year = "+books.get(i).getYear()+"\n\n";
            
        }
        return output;
    }
    
    public static Book searchBookTitle(String titleName)
    {
        Book book=null;
        for (int i=0; i<books.size(); i++)
        {
            if (books.get(i).getTitle().equalsIgnoreCase(titleName))
            {
                String title = books.get(i).getTitle();
                String author = books.get(i).getAuthor();
                int year = books.get(i).getYear();
                book = new Book(title,author,year);
            }
        }
        return book;
    }
    
    public static boolean removeBook(String titleName)
    {
        boolean success = false;
        for (int i=0; i<books.size(); i++)
        {
            if (books.get(i).getTitle().equalsIgnoreCase(titleName))
            {
                books.remove(i);
                success = true;
            }
        }
        return success;
    }
       
    
}
