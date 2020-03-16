package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Contest_Us_HackerRank {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int tc = scanner.nextInt();
        for (int tcItr = 0; tcItr < tc; tcItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0].trim());

            int n = Integer.parseInt(mn[1].trim());

            int t = Integer.parseInt(mn[2].trim());

            int[][] charm = new int[m][n];

            for (int charmRowItr = 0; charmRowItr < m; charmRowItr++) {
                String[] charmRowItems = scanner.nextLine().split(" ");

                for (int charmColumnItr = 0; charmColumnItr < n; charmColumnItr++) {
                    int charmItem = Integer.parseInt(charmRowItems[charmColumnItr].trim());
                    charm[charmRowItr][charmColumnItr] = charmItem;
                }
            }

            int tem = Integer.parseInt(scanner.nextLine().trim());

            for (int tItr = 0; tItr < tem; tItr++) {
                int x = Integer.parseInt(scanner.nextLine().trim());
                int[] generosities = new int[x];
                String[] generositiesItems = scanner.nextLine().split(" ");
                for (int generositiesItr = 0; generositiesItr < x; generositiesItr++) {
                    int generositiesItem = Integer.parseInt(generositiesItems[generositiesItr].trim());
                    generosities[generositiesItr] = generositiesItem;
                }

                guestTable(m , n , t ,charm , x,  generosities );
            }
            int k = Integer.parseInt(scanner.nextLine().trim());
            solve(k);
        }
    }

        static void guestTable(int m , int n ,int t ,int[][] charm , int x, int[] generosities ) {
            System.out.println("m = " + m + ", n = " + n + ", t = " + t + ", charm = " + Arrays.deepToString(charm) + ", x = " + x + ", generosities = " + Arrays.toString(generosities));

        }
        static void solve(int k) {
            System.out.println("k = " + k);

            /*
             * Write your code here.
             */

        }


    public static int getStrength(String password, int weight_a) {
        // Complete the function
        if (weight_a >25 ||weight_a < 0  )
            return 0;
        int sum = 0;
        for (int  i = 0;  i < password.length();  i++) {
            int val = password.charAt(i) - 'a' + weight_a;
            if(val > 25 ){
                sum +=(val % 26) ;
            }
            else {
                sum+=val ;
            }
        }
        return sum;
    }


    public static List<Integer> getMaxStreaks(List<String> toss) {

        List<Integer> temp = new ArrayList<>();
        int countForHeads = 0; // initialize countForHeads
        int resultForHeads = 0; //initialize max
        temp.add(resultForHeads);

        // to count heads
        for (int i = 0; i < toss.size(); i++)
        {
            // Reset count when 0 is found
            if (toss.get(i).equals("Tails"))
                countForHeads = 0;
            else
            {
                countForHeads++;//increase count
                resultForHeads = (int) Math.max(resultForHeads, countForHeads);
                temp.set(0,resultForHeads);
            }
        }

        int countForTails = 0; // initialize countForTails
        int resultForTails = 0; //initialize max
        temp.add(resultForTails);
        // to count Tails
        for (int i = 0; i < toss.size(); i++)
        {
            // Reset count when 0 is found
            if (toss.get(i).equals("Heads"))
                countForTails = 0;
            else
            {
                countForTails++;//increase count
                resultForTails = (int) Math.max(resultForTails, countForTails);
                temp.set(1,resultForTails);
            }
        }


        return temp;
    }

    public static String getRoundResult(char winning_suit, char suit1, int number1, char suit2, int number2) {
        // Write your code here
        String result = "Draw";

        if(winning_suit == suit1 && winning_suit != suit2  ){
            result = "Player 1 wins";
        }else if(winning_suit == suit2 && winning_suit != suit1  ){
            result = "Player 2 wins";
        }else {
            if(number1 > number2)
                result = "Player 1 wins";
            else if(number2 > number1)
                result ="Player 2 wins";
            else if(number1 == number1)
                result = "Draw";
        }
        return result;
    }
}
