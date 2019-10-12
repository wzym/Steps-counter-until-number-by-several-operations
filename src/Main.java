import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        int inNumber = Integer.parseInt(bf.readLine());
        print(countAmount(inNumber));
    }

    private void print(int[] result) {
        System.out.println(result.length);
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
        for (int i = 1; i < numToCountStepsBefore; i++) {
            int currentStepAmount = dynamics[i] + 1;
            for (int val :
                    getNewValues(i)) {
                if ((val <= numToCountStepsBefore) && (dynamics[val] > currentStepAmount)) {
                    dynamics[val] = currentStepAmount;
                }
            }
        }
        return new int[dynamics[numToCountStepsBefore]];
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