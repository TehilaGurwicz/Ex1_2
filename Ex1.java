//package assignments.ex1;
// Basa"d!
/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
//En algorithm that calculates a number by a power.
public class Ex1 {
    public static int po (int x, int y){
        int ans =1;
        for (int i = 0; i<y; i++){
            ans = ans *x;
        }
        return ans;
    }
    //this algorithm convert a char to its index in order to get its numerical value.
    public static int char2Int(char c)
    {
        char[] nums = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
        for (int i = 0; i<nums.length;i++)
        {
            if(nums[i]==c){return i;}//I created an array and by looping on its chars I convert them to be their index's value.
        }
        return -1;// If the char doesn't belong to the array the algorithm will return -1 as requested.
     }
     //This algorithm gets a number and returns the char which stands in the index that equals to the number.
     public static char int2char(int x)
     {   if (x >= 0 && x <= 16)//it will work as long as the number is greater than 0 but smaller/equals to the array's length.
     {
         char[] nums = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
         return nums[x];}

         return 'X';
     }
     //This algorithm checks if all the chars in an array are digits.
     public static boolean is_digits (String c)
     {
         for (char s: c.toCharArray())//looping on the array checking the chars one by one.
         {
            if(!Character.isDigit((s)))//an outer method for checking if a char is a digit.
            {  return false;} // If the method found a char that is not a digit return false.
         }
         return true;
     }
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    //This function gets a number and converts it to a decimal representation.
    public static int number2Int(String num) {
        if (!isNumber(num)){return  -1;}// if the "isNumber" function returns false the number is not in the format.
        if(is_digits(num)){return Integer.parseInt(num);}// returns the string as integers
        String num_Value = num.substring(0,num.indexOf("b"));//referring to a part of the string from index 0 to b.
        char base = num.charAt(num.indexOf("b")+1);//defined the base by referring to the char in the last index.
        int sum = 0;
        int power = num_Value.length()-1;
        for (char c: num_Value.toCharArray())//a method that convert a string to an array.
        {
            sum = sum + (char2Int(c)*po(char2Int(base),power));//using the "char2Int" function to calculate
                                                               //a number*base in the power of the digit's index.
            power--;// so it will match the index of the number's digits.
        }
        return sum;
    }
    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param num1 a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String num1) {
        boolean ans = true;
        if (is_digits(num1)){return true;}// return true if only digits (decimal)
        if (num1.indexOf("b")!=num1.length()-2){return false;}//return false if b is not in the right index.
        char base = num1.charAt(num1.indexOf("b")+1);
        String num_Value = num1;
        if(num1.contains("b"))// a method that checks if a string contains a specific char.
        { num_Value = num1.substring(0,num1.indexOf("b"));}
        int countb = 0;
        if(num_Value.isEmpty()){return false;}//a method that checks if a string is empty.
        for (char c: num_Value.toCharArray())// loop on string and checks different statements
        {   if(char2Int(c)==-1){return false;}
            if(char2Int(c)>=char2Int(base)) {return false;}
            if (c=='b'){countb++;}
            if (countb>1){return false;}
            //if(char2Int(c)==-1&&c=='b'){return false;}
        }
        //if (num1.indexOf("b")!=num1.length()-2){return false;}
        if(char2Int(base)==-1){return false;}
        return ans;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (base <2){return "";}// not in the format
        StringBuilder bld = new StringBuilder();//defining a variable that build a string
        //String temp_str = String.valueOf(num);
        while (num!=0)
        {
            int temp = num%base;
           bld.append(int2char(temp));
           num =  num/base;
        }
        bld.reverse();//a method that reverses the chars in a string
        bld.append("b");// a method that adds a chars to a string
        bld.append(int2char(base));
        if (!isNumber((bld.toString()))){return "";}//this method returns the string's value without casting is to string.
        return bld.toString();
    }
    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1)==number2Int(n2);
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr)
    {
        int ans = 0;

        for(int i = 0; i<=arr.length-1;i++)
        {
            if (number2Int(arr[i])>number2Int(arr[ans]))//looping on string checking which char is the greatest
                                                        //using the " number2Int" function
            {
                ans = i;
            }
        }
        return ans;
    }
}
