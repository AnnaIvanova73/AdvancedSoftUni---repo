import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab_Task_5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = "";
        ArrayDeque <String> queue = new ArrayDeque<>();


        while(!"print".equals(input = scan.nextLine())){

            if(!"cancel".equals(input)){
                queue.offer(input);
            }else{
                if(queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + queue.poll());
                }
            }
        }

        if(queue.isEmpty()){
            return;
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
