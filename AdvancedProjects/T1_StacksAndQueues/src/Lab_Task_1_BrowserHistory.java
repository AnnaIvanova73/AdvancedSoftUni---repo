import java.util.ArrayDeque;
import java.util.Scanner;

public class Lab_Task_1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> stackOfUrl = new ArrayDeque<>();

        String input= "";
        while(!"Home".equals(input=scan.nextLine())){

            if(input.equals("back")){
                if(stackOfUrl.size()>1){
                    stackOfUrl.pop();
                    System.out.println(stackOfUrl.peek());
                }else{
                    System.out.println("no previous URLs");
                }
            }else{
                stackOfUrl.push(input);
                System.out.println(input);
            }
        }
    }
}
