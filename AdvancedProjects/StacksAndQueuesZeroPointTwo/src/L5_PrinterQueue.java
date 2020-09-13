import java.util.ArrayDeque;
import java.util.Scanner;

public class L5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        while(!"print".equals(input)){

            if(!input.equals("cancel")){
                printerQueue.offer(input);
            }else{
                if(printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + printerQueue.poll());
                }
            }
            input = scan.nextLine();
        }

        while (printerQueue.size() > 0){
            System.out.println(printerQueue.poll());
        }
    }
}
