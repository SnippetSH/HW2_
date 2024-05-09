package LotterySimulator;

public class LotteryChecker {
    public int rank;
    public int prize;
    public LotteryChecker(int rank, int prize) {
        this.rank = rank;
        this.prize = prize;
    }
    public static int[] record = new int[4];
    public LotteryChecker checkNum(int[] WinNum, int[] UserNum) { //decide the rank and prize
        int cnt = 0;

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(WinNum[i] == UserNum[j]) {
                    cnt++;
                }
            }
        }

        if(cnt == 4 || cnt == 5) {
            for(int i = 0; i < 6; i++) {
                if(WinNum[6] == UserNum[i]) {
                    cnt++;
                }
            }
        }

        if(cnt == 3) {
            rank = 4;
            prize = 10;
        } else if(cnt == 4) {
            rank = 3;
            prize = 20;
        } else if(cnt == 5) {
            rank = 2;
            prize = 50;
        } else if(cnt == 6) {
            rank = 1;
            prize = 100;
        } else {
            rank = 0;
            prize = 0;
        }

        if(rank > 0) {
            LotteryChecker.record[rank - 1]++;
        }
        return new LotteryChecker(rank, prize);
    }
}