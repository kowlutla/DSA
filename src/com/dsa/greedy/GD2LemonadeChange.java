/**
 * 	You are an owner of lemonade island, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by given array bills[]). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
	
	NOTE: At first, you do not have any bill to provide changes with. You can provide changes from the bills that you get from the previous customers.
	
	Given an integer array bills of size N where bills [ i ] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
	
	Example 1:
	Input:
	N = 5
	bills [ ] = {5, 5, 5, 10, 20}
	Output: True
	Explanation: 
	From the first 3 customers, we collect three $5 bills in order.
	From the fourth customer, we collect a $10 bill and give back a $5.
	From the fifth customer, we give a $10 bill and a $5 bill.
	Since all customers got correct change we return true.
	 
	
	Example 2:
	Input:
	N = 5
	bills [ ] = {5, 5, 10, 10, 20}
	Output: False
	Explanation: 
	From the first two customers in order, we collect two $5 bills.
	For the next two customers in order, we collect a $10 bill and give back a $5 bill.
	For the last customer, we can not give the change of $15 back because we only have two $10 bills.
	Since not every customer received the correct change, the answer is false.
	 
 */
package com.dsa.greedy;

/**
 * @author KowlutlaSwamy
 *
 */
public class GD2LemonadeChange {

    /**
     * Determines if it is possible to provide change for each customer in the queue.
     *
     * Time Complexity: O(N)
     * The time complexity is linear since we iterate through the bills array once.
     *
     * Space Complexity: O(1)
     * The space complexity is constant because we are only using a fixed amount of extra space.
     *
     * @param N the number of customers
     * @param bills an array representing the bills given by each customer
     * @return true if it is possible to provide change for each customer, false otherwise
     */
    public static boolean lemonadeChange(int N, int[] bills) {

        // Initialize counters for $5, $10, and $20 bills
        int fives = 0, tens = 0;

        // Iterate through each bill in the array
        for (int i = 0; i < N; i++) {

            if (bills[i] == 5) {
                // If the customer gives a $5 bill, increment the count of $5 bills
                fives++;
            } else if (bills[i] == 10) {
                // If the customer gives a $10 bill
                if (fives == 0) {
                    // If there are no $5 bills to give as change, return false
                    return false;
                }
                // Give one $5 bill as change and increment the count of $10 bills
                fives--;
                tens++;
            } else {
                // If the customer gives a $20 bill
                if (tens >= 1 && fives >= 1) {
                    // Prefer to give one $10 bill and one $5 bill as change
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    // If there are no $10 bills, give three $5 bills as change
                    fives -= 3;
                } else {
                    // If neither condition is met, return false
                    return false;
                }
            }
        }

        // If all customers are provided with the correct change, return true
        return true;
    }
}
