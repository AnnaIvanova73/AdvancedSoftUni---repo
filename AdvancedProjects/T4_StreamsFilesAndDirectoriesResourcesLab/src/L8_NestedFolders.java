import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class L8_NestedFolders {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        File file = new File("D:\\Advanced\\T4_StreamsFilesAndDirectoriesResourcesLab\\Files-and-Streams");

        Deque<File> queue = new ArrayDeque<>();

        queue.offer(file);

        while (!queue.isEmpty()) {
            File poll = queue.poll();
            System.out.println(poll.getName());
            File[] files = poll.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    queue.offer(f);
                }
            }

        }
    }
}
