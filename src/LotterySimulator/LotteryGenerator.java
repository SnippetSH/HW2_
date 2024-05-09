package LotterySimulator;

import java.util.Random;
public class LotteryGenerator {
    private final Random ran = new Random();
    public int[] GenNums() { //generate 6 random numbers
        int[] LotNumbers = new int[6];
        int i = 0;

        while(true) {
            LotNumbers[i] = ran.nextInt(20) + 1;
            boolean ck = false;
            for(int j = 0; j < i; j++) {
                if(LotNumbers[i] == LotNumbers[j]) {
                    LotNumbers[i] = ran.nextInt(20) + 1;
                    ck = true;
                    break;
                }
            }
            if(ck) {
                continue;
            }

            i++;

            if(i == 6) {
                break;
            }
        }
        return LotNumbers;
    }

    public int GenLastNum(int[] arr) { //generate bonus number of winning number
        int num = ran.nextInt(20) + 1;
        while(true) {
            boolean ck = false;
            for (int i = 0; i < 6; i++) {
                if (num == arr[i]) {
                    num = ran.nextInt(20) + 1;
                    ck = true;
                }
            }
            if(ck) {
                continue;
            }
            break;
        }
        return num;
    }
}
