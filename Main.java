import Game_1.BrickBreaker;
import Game_2.Snake;
import Game_3.PacMan;
import Game_4.Puzzle;
import Game_5.Tetris;
import Game_6.com.MoveTheBalls;
import Game_7.cam.StarshipDefender;
import utils.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while(run) {
            printMenu();
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    run = false;
                    System.out.println("End of the program.");
                    break;
                case 1:
                    startGame(new BrickBreaker());
                    break;
                case 2:
                    startGame(new Snake());
                    break;
                case 3:
                    startGame(new PacMan());
                    break;
                case 4:
                    startGame(new Puzzle());
                    break;
                case 5:
                    startGame(new Tetris());
                    break;
                case 6:
                    startGame(new MoveTheBalls());
                    break;
                case 7:
                    startGame(new StarshipDefender());
                    break;
                default:
                    System.out.println("Wrong choice. Try again please.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose your game:");
        System.out.println("1: Brick Breaker");
        System.out.println("2: Snake");
        System.out.println("3: Pac-Man");
        System.out.println("4: Puzzle");
        System.out.println("5: Tetris");
        System.out.println("6: Move the Balls");
        System.out.println("7: Starship Defender");
        System.out.println("0: Exit");
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void startGame(Game game) {
        game.init();

        // Find current game window
        JFrame gameFrame = null;
        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof JFrame && frame.isDisplayable()) {
                gameFrame = (JFrame) frame;
                break;
            }
        }

        if (gameFrame != null) {
            final Object lock = new Object();
            // Listener notifying about close of the window
            gameFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    synchronized (lock) {
                        lock.notify();
                    }
                }
            });
            // block main thread untill the game is closed
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        clearConsole();
    }
}
