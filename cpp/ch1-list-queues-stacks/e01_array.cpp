/*Programmer: Leslye Hernandez Jimenez
 *        /\_/\
 *       ( o.o )    
 *        > ^ <
 * Array Example
 * * Fecha: 22/01/2025
 * c++ e01_array.cpp -o e01_array.exe
 */

// librerias
#include <iostream>
#include <array>
using namespace std;

int main(){
    std::array<int, 10> arr;

    arr[0] = 1;
    std::cout << "First element:" << arr[0] << std::endl;

    std::array<int, 4> arr2 = {1, 2, 3, 4};
    std::cout << "Elements in second array: ";
    for(int i = 0; i < arr.size(); i++)
        std::cout << arr2[i] << " ";

    // exception
    try{
        std::cout << arr2.at(4);
        std::cout << arr2.at(5);
    }
    catch (const out_of_range& ex){
        std::cerr << "EXCEPTION: " << ex.what();
    }
}

