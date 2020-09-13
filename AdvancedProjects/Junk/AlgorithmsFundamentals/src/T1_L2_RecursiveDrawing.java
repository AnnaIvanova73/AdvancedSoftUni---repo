import java.util.Scanner;

public class T1_L2_RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int symbolsCount = Integer.parseInt(scan.nextLine());

        drawFigure(symbolsCount);
    }

    private static void drawFigure(int symbolsCount) {
        if (symbolsCount == 0) {
            return;
        }
        for (int i = 0; i < symbolsCount; i++) {
            System.out.print('*');
        }
        System.out.println();

        drawFigure(symbolsCount - 1);

        for (int i = 0; i < symbolsCount; i++) {
            System.out.print('#');
        }
        System.out.println();
    }
}
