package Arrays_java_course;

/**
 * Created by Artem Konyukhov on 10.04.2017.
 */
public class MultiArray1 {

    public static void main(String[] args) {
        int SIZE = 10;
        char[][] graph = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == 0 || i == SIZE-1 || j == 0 || j == SIZE-1) {
                    graph[i][j] = '#';
                }
                else {
                    graph[i][j] = ' ';
                }
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
