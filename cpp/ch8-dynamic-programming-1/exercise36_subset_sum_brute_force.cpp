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
 * File: exercise36_subset_sum_brute_force.cpp
 * Compiled: c++ exercise36_subset_sum_brute_force.cpp -o exercise36_subset_sum_brute_force.exe
 * Date: 23/01/2025
 * 
 * Description: 
 * This program demonstrates a brute-force approach to solving the subset sum problem. 
 * It explores all possible subsets of a given set of integers and calculates the sum for
 * each subset to determine the possible sums that can be formed. While this approach is straightforward,
 * it is computationally expensive for large input sizes due to its exponential complexity.
 */


#include <iostream>
#include <vector>
#include <algorithm>

#define DEBUG 1

#if DEBUG
#define PRINT(x) cerr << x
#else
#define PRINT(x)
#endif

using namespace std;

void GetAllSubsets(vector<int> set, vector<int> subset, int index, vector<vector<vector<int>>> &allSubsets)
{
	if(index == set.size())
	{
		allSubsets[subset.size()].push_back(subset);
		return;
	}
	GetAllSubsets(set, subset, index + 1, allSubsets);

	subset.push_back(set[index]);

	GetAllSubsets(set, subset, index + 1, allSubsets);
}

bool SubsetSum_BruteForce(vector<int> set, int target)
{
	vector<vector<vector<int>>> allSubsets(set.size() + 1);

	GetAllSubsets(set, {}, 0, allSubsets);

	for(int size = 0; size <= set.size(); size++)
	{
		PRINT("SIZE = " << size << endl);

		for(auto subset : allSubsets[size])
		{
			PRINT("\t{ ");

			int sum = 0;

			for(auto number : subset)
			{
				sum += number;

				PRINT(number << " ");
			}
			PRINT("} = " << sum << endl);

			if(sum == target) return true;
		}
	}
	return false;
}

int main()
{
	vector<int> set = { 13, 79, 45, 29, 22, 45, 12, 33, 76, 9 };

	int target = 46;

	bool found = SubsetSum_BruteForce(set, target);

	if(found)
	{
		cout << "Subset with sum " << target << " was found in the set." << endl;
	}
	else
	{
		cout << "Subset with sum " << target << " was not found in the set." << endl;
	}

	return 0;
}