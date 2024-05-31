/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

/**
 *
 * @author DELL
 */
public class ExceptionWithCatch_3 
{
    public static void main(String[] args) 
    {
        int [] matrikc = new int[3]; // indeks 0..2
        
        try
        {
            matrikc[1] = 20;
            System.out.println("Display content in matrikc[1] = "+matrikc[1]);
            matrikc[4] = 10; // ArrayIndexOutOfBoundException
            System.out.println("Display content in matrikc[4] = "+matrikc[4]);
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Our message = the index is out of bound."
                              +"It means that the index < 0 or  > the last index ");
            System.out.println("System message - toString() = "+ex.toString());
            System.out.println("System message - getMessage()= "+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
