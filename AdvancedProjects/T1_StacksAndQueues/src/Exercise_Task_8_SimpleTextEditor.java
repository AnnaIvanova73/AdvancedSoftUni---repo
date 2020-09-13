import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise_Task_8_SimpleTextEditor  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countOfOperations = Integer.parseInt(reader.readLine());

        StringBuilder text = new StringBuilder();
        Deque<String> history = new ArrayDeque<>();

        while(countOfOperations-- > 0){
            String[] tokens = reader.readLine().split(" ");
            String operation = tokens[0];
            String commandArgument = "";

            if(tokens.length > 1){
                commandArgument = tokens[1];
            }

            switch (operation){
                case"1":
                    history.push(text.toString());
                    text.append(commandArgument);
                    break;
                case"2":
                    history.push(text.toString());
                    int count = Integer.parseInt(commandArgument);
                    int endIndex = text.length();
                    int startIndex = endIndex - count;
                    text.delete(startIndex,endIndex);
                    break;
                case"3":
                    int indexOfChar = Integer.parseInt(commandArgument) - 1;
                    if(text.length() <= indexOfChar || indexOfChar <  0){
                        break;
                    }
                    System.out.println(text.charAt(indexOfChar));
                    break;
                case"4":
                    if(!history.isEmpty()){
                        text.setLength(0);
                        text.append(history.pop());
                        break;
                    }
            }

        }
    }
}
