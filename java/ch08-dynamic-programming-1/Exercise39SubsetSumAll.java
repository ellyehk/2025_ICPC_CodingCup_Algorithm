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
 * Topic: Subset Sum - Sum All (Exercise 39)
 * File: Exercise39SubsetSumAll.java
 * Compiled: javac Exercise39SubsetSumAll.java
 * Date: 23/01/2025
 * 
 * Description: 
 * This program demonstrates the use of dynamic programming to solve 
 * the subset sum problem, where the goal is to find all possible sums 
 * that can be formed using subsets of a given set of integers.
 */

 import java.util.*;

 public class Exercise39SubsetSumAll {
     private static final int UNKNOWN = -1;
 
     public static List<Integer> subsetSumTabulation(List<Integer> set) {
         int totalSum = set.stream().mapToInt(Integer::intValue).sum();
         boolean[][] dp = new boolean[set.size() + 1][totalSum + 1];
         
         for (int i = 0; i <= set.size(); i++) {
             dp[i][0] = true; 
         }
         
         for (int i = 1; i <= set.size(); i++) {
             for (int sum = 1; sum <= totalSum; sum++) {
                 dp[i][sum] = dp[i - 1][sum];
                 if (sum >= set.get(i - 1)) {
                     dp[i][sum] |= dp[i - 1][sum - set.get(i - 1)];
                 }
             }
         }
         
         List<Integer> subsetSums = new ArrayList<>();
         for (int sum = 1; sum <= totalSum; sum++) {
             if (dp[set.size()][sum]) {
                 subsetSums.add(sum);
             }
         }
         return subsetSums;
     }
 
     public static void measureTime(Runnable task, String description) {
         long startTime = System.nanoTime();
         task.run();
         long endTime = System.nanoTime();
         System.out.printf("TIME TAKEN USING %s: %.5f seconds%n", description, (endTime - startTime) / 1e9);
     }
 
     public static void main(String[] args) {
         // Input set and target
         List<Integer> set = Arrays.asList(16, 1058, 22, 13, 46, 55, 3, 92, 47, 7, 98, 367, 807, 106, 333, 85, 577, 9, 3059);
         int target = 6076;
 
         Collections.sort(set);
 
         measureTime(() -> {
             List<Integer> subsetSums = subsetSumTabulation(set);
             System.out.println("The set contains the following " + subsetSums.size() + " subset sums: " + subsetSums);
 
             if (subsetSums.contains(target)) {
                 System.out.println("Subset with sum " + target + " was found in the set.");
             } else {
                 System.out.println("Subset with sum " + target + " was not found in the set.");
             }
         }, "TABULATION");
     }
 }
 