/*Programmer: Leslye Hernandez Jimenez
 *        /\_/\
 *       ( o.o )    
 *        > ^ <
 * Array Example
 * * Fecha: 22/01/2025
 * c++ e01_array.cpp -o e01_array.exe
 */

public class E01Array {
    public static void main(String[] args) {
        int[] arr = new int[10];

        arr[0] = 1;
        System.out.println("First element: " + arr[0]);
        
        int[] arr2 = {1, 2, 3, 4};
        System.out.println("Elements in second array: ");
        for (int i = 0; i < arr2.length; i++)
            System.out.print(arr2[i] + " ");
        System.out.println();
        
        try {
            int a = arr2[4];
            int b = arr2[5];
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}