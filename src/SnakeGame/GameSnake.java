package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Artem Konyukhov on 13.07.2017.
 */
public class GameSnake {

    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER = "GAME OVER";
    final int POINT_RADIUS = 20;            //in pixels
    final int FIELD_HEIGHT = 20;            //in points
    final int FIELD_WIDTH = 30;             //in points
    final int FIELD_DX = 6;
    final int FIELD_DY = 32;
    final int START_LOCATION = 200;

    final int START_SNAKE_SIZE = 6;     //in points
    final int START_SNAKE_X = 10;
    final int START_SNAKE_Y = 10;
    final int SHOW_DELAY = 150;         //in ms

    //коды клавиш для обработчика клавиатуры:
    final int LEFT = 37;
    final int UP = 38;
    final int RIGHT = 39;
    final int DOWN = 40;
    final int START_DIRECTION = RIGHT;

    final Color DEFAULT_COLOR = Color.black;
    final Color FOOD_COLOR = Color.green;
    final Color POISON_COLOR = Color.red;

    Snake snake;
    Food food;
    Poison poison;
    JFrame frame;
    Canvas canvasPanel;
    Random random = new Random();
    boolean gameOver = false;

    public static void main(String[] args) {
        new GameSnake().go();
    }

    public void go() {

        frame = new JFrame(TITLE_OF_PROGRAM + " : " + START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(POINT_RADIUS * FIELD_WIDTH + FIELD_DX, POINT_RADIUS * FIELD_HEIGHT + FIELD_DY);
        frame.setLocation(START_LOCATION, START_LOCATION);
        frame.setResizable(false);

        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.lightGray);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });

        frame.setVisible(true);

        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, START_DIRECTION);
        food = new Food();
        poison = new Poison();

        while (!gameOver) {
            snake.move();

            if (food.isEaten()) {
                food.next();
                poison.add();
            }

            canvasPanel.repaint();
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Snake {
        ArrayList<Point> snake = new ArrayList<Point>();
        int direction;

        public Snake(int x, int y, int length, int direction) {
            for (int i = 0; i < length; i++) {
                Point point = new Point(x - i, y, DEFAULT_COLOR);
                snake.add(point);
            }
            this.direction = direction;
        }

        boolean isFood(Point food) {
            return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
        }

        boolean isInsideSnake(int x, int y) {
            for (Point point : snake) {
                if ((point.getX() == x) && (point.getY() == y)) {
                    return true;
                }
            }
            return false;
        }

        public void move() {
            int x = snake.get(0).getX();
            int y = snake.get(0).getY();
            if (direction == LEFT) {
                x--;
            }
            if (direction == RIGHT) {
                x++;
            }
            if (direction == UP) {
                y--;
            }
            if (direction == DOWN) {
                y++;
            }

            if (x > FIELD_WIDTH - 1) {
                x = 0;
            }
            if (x < 0) {
                x = FIELD_WIDTH - 1;
            }
            if (y > FIELD_HEIGHT - 1) {
                y = 0;
            }
            if (y < 0) {
                y = FIELD_HEIGHT - 1;
            }

            gameOver = isInsideSnake(x, y) || poison.isPoison(x, y);     //check for self crossing and poison eating

            snake.add(0, new Point(x, y, DEFAULT_COLOR));              //new position for head

            if (isFood(food)) {
                food.eat();
                frame.setTitle(TITLE_OF_PROGRAM + " : " + snake.size());
            } else {
                snake.remove(snake.size() - 1);
            }
        }

        public void setDirection(int direction) {
            if ((direction >= LEFT) && (direction <= DOWN)) {
                if (Math.abs(this.direction - direction) != 2) {
                    this.direction = direction;
                }
            }
        }

        public void paint(Graphics g) {
            for (Point point : snake) {
                point.paint(g);
            }
        }
    }

    class Food extends Point {

        public Food() {
            super(-1, -1, FOOD_COLOR);
        }

        public void eat() {
            this.setXY(-1, -1);
        }

        boolean isEaten() {
            return this.getX() == -1;
        }

        boolean isFood(int x, int y) {
            return (this.x == x) && (this.y == y);
        }

        public void next() {
            int x, y;
            do {
                x = random.nextInt(FIELD_WIDTH);
                y = random.nextInt(FIELD_HEIGHT);
            } while (snake.isInsideSnake(x, y) || poison.isPoison(x, y));
            this.setXY(x, y);
        }
    }

    class Poison {
        ArrayList<Point> poison = new ArrayList<Point>();
        Color color = POISON_COLOR;
        int count = 1;

        boolean isPoison(int x, int y) {
            for (Point point : poison) {
                if ((point.getX() == x) && point.getY() == y) {
                    return true;
                }
            }
            return false;
        }

        public void add() {
            int x, y;
            if (count <= 15) {
                do {
                    x = random.nextInt(FIELD_WIDTH);
                    y = random.nextInt(FIELD_HEIGHT);
                } while (isPoison(x, y) || snake.isInsideSnake(x, y) || food.isFood(x, y));
                poison.add(new Point(x, y, POISON_COLOR));
                count++;
            }
        }

        public void paint(Graphics g) {
            for (Point point : poison) {
                point.paint(g);
            }
        }
    }

    //создаем базовый объект для прорисовки
    class Point {
        int x, y;
        Color color = DEFAULT_COLOR;

        public Point(int x, int y, Color color) {
            this.setXY(x, y);
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public class Canvas extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            snake.paint(g);
            food.paint(g);
            poison.paint(g);

            if (gameOver) {
                g.setColor(Color.red);
                g.setFont(new Font("Arial", Font.BOLD, 40));
                FontMetrics fm = g.getFontMetrics();
                g.drawString(GAME_OVER, (FIELD_WIDTH * POINT_RADIUS + FIELD_DX - fm.stringWidth(GAME_OVER)) / 2,
                        (FIELD_HEIGHT * POINT_RADIUS + FIELD_DY) / 2);
            }
        }
    }
}
