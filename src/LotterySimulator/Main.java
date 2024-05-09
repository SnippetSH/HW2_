package LotterySimulator;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N; //user's money
        int M; //the number of ticket

        System.out.println("Enter your money:");
        System.out.print("<< ");
        N = sc.nextInt();
        if(N < 10) {
            System.out.println(">> You don't have enough money to buy a ticket\n>> End of program");
            return;
        } //input N, and check the N is bigger than 10

        while(true) { //almost logics active in this loop
            System.out.println(">> Enter the number of tickets to buy (0 to exit):");
            System.out.print("<< ");
            M = sc.nextInt();
            if(M == 0) {
                System.out.println(">> End of program");
                return;
            } else if(M > N/10) {
                System.out.println(">> You don't have enough money to buy that many tickets.\n>> Enter the number of tickets to buy:");
                do {
                    System.out.print("<< ");
                    M = sc.nextInt();
                    System.out.println(">> You don't have enough money to buy that many tickets.\n>> Enter the number of tickets to buy:");
                } while (M > N / 10);
            } //input M, and check the M is smaller than N/10

            N -= (M*10);

            LotteryGenerator GenLot = new LotteryGenerator();
            int[] WinNum = new int[7];
            int[][] UserNum = new int[M][6];
            int[] tmp = GenLot.GenNums();
            int lastNum = GenLot.GenLastNum(tmp);

            System.arraycopy(tmp, 0, WinNum, 0, 6);
            WinNum[6] = lastNum; //generate a Winning Number

            System.out.print(">> Round Winning numbers: ");
            for(int i = 0; i < 6; i++) {
                System.out.printf("%d ", WinNum[i]);
            }
            System.out.println("+ " + WinNum[6]); //print out Winning Number


            for(int i = 0; i < M; i++) {
                UserNum[i] = GenLot.GenNums();
                Arrays.sort(UserNum[i]);
            } //generate all the User Number, and make this array are sorted

            for(int i = 0; i < 4; i++) {
                LotteryChecker.record[i] = 0;
            } //initialize the array of record that define in LotteryChecker

            LotteryChecker[] rankCheck = new LotteryChecker[M];
            LotteryChecker Checker = new LotteryChecker(0, 0);

            int totalPrize = 0;
            for(int i = 0; i < M; i++) { //the loop of checking ranks and prizes
                rankCheck[i] = Checker.checkNum(WinNum, UserNum[i]); //check the rank
                System.out.print(">> Lottery number: ");
                for(int j = 0; j < 6; j++) {
                    System.out.printf("%d ", UserNum[i][j]);
                } //print out the User Number

                switch(rankCheck[i].rank) {
                    case 0:
                        System.out.println("Lose");
                        break;
                    case 1:
                        System.out.println("Winner (1st place)");
                        break;
                    case 2:
                        System.out.println("Winner (2nd place)");
                        break;
                    case 3:
                        System.out.println("Winner (3rd place)");
                        break;
                    case 4:
                        System.out.println("Winner (4th place)");
                        break;
                } //and, that Number's rank
                totalPrize += rankCheck[i].prize; //decide the Prize of that rank
            }

            System.out.println(">> The number of 1st place: " + LotteryChecker.record[0]);
            System.out.println(">> The number of 2nd place: " + LotteryChecker.record[1]);
            System.out.println(">> The number of 3rd place: " + LotteryChecker.record[2]);
            System.out.println(">> The number of 4th place: " + LotteryChecker.record[3]);
            //print out the number of ranks

            System.out.println(">> Total winnings: " + totalPrize);
            N += totalPrize;
            System.out.println(">> Current funds: " + N); //print out winning result and funds
            if(N < 10) {
                System.out.println(">> You don't have enough money to buy a ticket.\nEnd of program");
                return;
            } //if user has not enough money, terminate this program
        }
    }
}
