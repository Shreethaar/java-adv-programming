
public class ExTestDrive {

    public static void main(String[] args) {
        String test = "no";
        try {
            System.out.print("t");
            doRisky(test);
            System.out.print("o");
        } catch (IllegalArgumentException e) {
            System.out.print("a");
        } finally {
            System.out.print("w");
        }
        System.out.println("s");
    }

    static void doRisky(String t) throws IllegalArgumentException {
        System.out.print("h");
        if ("yes".equals(t)) {
            throw new IllegalArgumentException();
        }
        System.out.print("r");
    }
}
