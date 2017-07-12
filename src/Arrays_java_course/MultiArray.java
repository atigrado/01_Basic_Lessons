package Arrays_java_course;

/**
 * Created by Artem Konyukhov on 10.04.2017.
 */
public class MultiArray {

    public static void main(String[] args) {
        int SIZE = 10;
        char[][] graph = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                graph[i][j] = '#';
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
}
