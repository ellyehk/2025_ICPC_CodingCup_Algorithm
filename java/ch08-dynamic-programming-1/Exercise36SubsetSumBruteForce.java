/* 
 * Programmer: Leslye Hernandez Jimenez
 * Email: hernandezleslye45@gmail.com
 * Instagram: @hku_ls
 * 
 *        /\_/\
 *       ( o.o )  <-- Bunny Approved Code!
 *        > ^ <
 * 
 * Project: Dynamic Programming DEMO - Part 1
 * Topic: Subset Sum - Brute Force Approach (Exercise 36)
 * File: Exercise36SubsetSumBruteForce.java
 * Compiled: javac Exercise36SubsetSumBruteForce.java
 * Date: 23/01/2025
 * 
 * Description: 
 * This program demonstrates a brute-force approach to solving the subset sum problem. 
 * It explores all possible subsets of a given set of integers and calculates the sum for
 * each subset to determine the possible sums that can be formed. While this approach is straightforward,
 * it is computationally expensive for large input sizes due to its exponential complexity.
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class Exercise36SubsetSumBruteForce {
 
     public static void getAllSubsets(List<Integer> set, List<Integer> subset, int index, List<List<List<Integer>>> allSubsets) {
         if (index == set.size()) {
             allSubsets.get(subset.size()).add(new ArrayList<>(subset));
             return;
         }
 
         getAllSubsets(set, subset, index + 1, allSubsets);
 
         subset.add(set.get(index));
         getAllSubsets(set, subset, index + 1, allSubsets);
 
         subset.remove(subset.size() - 1);
     }
 
     public static boolean subsetSumBruteForce(List<Integer> set, int target) {
         List<List<List<Integer>>> allSubsets = new ArrayList<>();
         for (int i = 0; i <= set.size(); i++) {
             allSubsets.add(new ArrayList<>());
         }
 
         getAllSubsets(set, new ArrayList<>(), 0, allSubsets);
 
         // Check each subset for the target sum
         for (int size = 0; size <= set.size(); size++) {
             for (List<Integer> subset : allSubsets.get(size)) {
                 int sum = subset.stream().mapToInt(Integer::intValue).sum();
                 if (sum == target) {
                     return true;
                 }
             }
         }
 
         return false;
     }
 
     public static void main(String[] args) {
         List<Integer> set = List.of(13, 79, 45, 29, 22, 45, 12, 33, 76, 9);
         int target = 46;
 
         boolean found = subsetSumBruteForce(set, target);
 
         if (found) {
             System.out.println("Subset with sum " + target + " was found in the set.");
         } else {
             System.out.println("Subset with sum " + target + " was not found in the set.");
         }
     }
 }
 