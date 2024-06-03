//Predicate Lambda Expression

import java.util.*;
public class Lambda001{
    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);

        String status;
        boolean availability = false;

        try{
            System.out.print("Are you single? (yes/no): ");
            status = sc.next();

            if(status.equalsIgnoreCase("yes")){
                availability = true;
            } else if(status.equalsIgnoreCase("no")){
                availability = false;
            } else{
                throw new InputMismatchException("Invalid input");
            }
        } catch(InputMismatchException e){
            System.out.print(e.getMessage());
            return;
        }

        Predicate<Boolean> isSingle = (value) -> value;

        if(isSingle.test(availability)){
            System.out.println("HAHAHAHA SINGLE PADAN MUKA");
        } else {
            System.out.println("Ambiklah bumi ni");
        }
    }

    interface  Predicate<T>{
        boolean test(T value);
    }
}
