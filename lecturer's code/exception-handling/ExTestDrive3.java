public class ExTestDrive3{
    public static void main(String[] args) {
        try {
            throw new Exception("An error occurred.");// An error occurred. - is a message
        }// try  
        catch (NullPointerException e) {
            System.out.println("NullPointerException occurred.");
        } //NullPointerException
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } // exception
        finally {
            System.out.println("Finally block.");
        }//finally
    } // main
}// main
