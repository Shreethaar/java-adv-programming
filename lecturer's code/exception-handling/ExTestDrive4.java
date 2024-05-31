public class ExTestDrive4{
    public static void main(String[] args) throws Exception {
        try {
            throw new MyException("An error occurred.");
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("Finally block.");
        }
    }
}