import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inNumber = Integer.parseInt(bf.readLine());
        print(countAmount(inNumber));
    }

    private void print(int[] result) {
        System.out.println(result.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int elem :
                result) {
            sb.append(elem);
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private int[] countAmount(int numToCountStepsBefore) {
        int[] dynamics = getArrayForDyn(numToCountStepsBefore);
        int[] paths = new int[numToCountStepsBefore + 1];
        for (int i = 1; i < numToCountStepsBefore; i++) {
            int currentStepAmount = dynamics[i] + 1;
            for (int val :
                    getNewValues(i)) {
                if ((val <= numToCountStepsBefore) && (dynamics[val] > currentStepAmount)) {
                    dynamics[val] = currentStepAmount;
                    paths[val] = i;
                }
            }
        }

        return restoResult(numToCountStepsBefore, dynamics[numToCountStepsBefore], paths);
    }

    private int[] restoResult(int numToCountStepsBefore, int stepAmount, int[] paths) {
        int[] result = new int[stepAmount + 1];
        int restoreIndex = result.length - 1;
        int curRestoreNumber = numToCountStepsBefore;
        while (curRestoreNumber != 0) {
            result[restoreIndex--] = curRestoreNumber;
            curRestoreNumber = paths[curRestoreNumber];
        }
        return result;
    }

    private int[] getArrayForDyn(int lastElementIndex) {
        int[] result = new int[lastElementIndex + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[1] = 0;
        return result;
    }

    private int[] getNewValues(int curNum) {
        return new int[] { curNum + 1, curNum * 2, curNum * 3 };
    }
}