import java.util.*;
import java.util.concurrent.*;

public class SlitherIOConsole {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static final char EMPTY = '.';
    private static final char SNAKE = 'O';
    private static final char FOOD = '*';

    private static int score = 0;
    private static LinkedList<int[]> snake = new LinkedList<>();
    private static int[] food = new int[2];
    private static char[][] board = new char[HEIGHT][WIDTH];

    public static void main(String[] args) {
        initGame();

        while (true) {
            clearConsole();
            printBoard();
            System.out.println("Score: " + score);
            System.out.print("Move (W/A/S/D): ");

            char direction = getInputWithTimeout();
            if (!moveSnake(direction)) {
                System.out.println("Game Over! Final Score: " + score);
                break;
            }
        }
    }

    private static void initGame() {
        for (int i = 0; i < HEIGHT; i++) {
            Arrays.fill(board[i], EMPTY);
        }

        // Initialize snake in the middle of the board
        snake.add(new int[]{HEIGHT / 2, WIDTH / 2});
        board[HEIGHT / 2][WIDTH / 2] = SNAKE;

        // Place the first piece of food
        placeFood();
    }

    private static void printBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void placeFood() {
        Random random = new Random();
        int foodX, foodY;
        do {
            foodX = random.nextInt(HEIGHT);
            foodY = random.nextInt(WIDTH);
        } while (board[foodX][foodY] != EMPTY);

        food[0] = foodX;
        food[1] = foodY;
        board[foodX][foodY] = FOOD;
    }

    private static boolean moveSnake(char direction) {
        int[] head = snake.getFirst();
        int newHeadX = head[0];
        int newHeadY = head[1];

        switch (direction) {
            case 'W': newHeadX--; break; // Up
            case 'S': newHeadX++; break; // Down
            case 'A': newHeadY--; break; // Left
            case 'D': newHeadY++; break; // Right
            default: return true; // Invalid input, ignore
        }

        // Check boundaries
        if (newHeadX < 0 || newHeadX >= HEIGHT || newHeadY < 0 || newHeadY >= WIDTH) {
            return false; // Game over
        }

        // Check collision with itself
        if (board[newHeadX][newHeadY] == SNAKE) {
            return false; // Game over
        }

        // Check if food is eaten
        boolean ateFood = (newHeadX == food[0] && newHeadY == food[1]);

        // Move the snake
        snake.addFirst(new int[]{newHeadX, newHeadY});
        board[newHeadX][newHeadY] = SNAKE;

        if (!ateFood) {
            int[] tail = snake.removeLast();
            board[tail[0]][tail[1]] = EMPTY;
        } else {
            score++;
            placeFood();
        }

        return true;
    }

    private static char getInputWithTimeout() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        });

        try {
            return future.get(5, TimeUnit.SECONDS).toUpperCase().charAt(0);
        } catch (TimeoutException e) {
            System.out.println("\nNo input detected. Defaulting to no move.");
            return ' '; // Default no move
        } catch (Exception e) {
            return ' '; // Handle other exceptions
        } finally {
            executor.shutdownNow();
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
