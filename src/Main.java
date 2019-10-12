import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        int number = Integer.parseInt(bf.readLine());
        System.out.println(countAmount(number));
    }

    private int countAmount(int number) {
        return 0;
    }
}