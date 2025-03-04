import Game_1.BrickBreaker;
import Game_2.Snake;
import utils.Game;

import java.util.*;

public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            System.out.println("Choose game by pressing button.");
            System.out.println("utils.Game 1: Brick Breaker");
            System.out.println("utils.Game 2: Snake");
            System.out.println("utils.Game 3: Pac-Man");
            System.out.println("utils.Game 4: Puzzle");
            System.out.println("utils.Game 5: Tetris");
            System.out.println("utils.Game 6: Move the Balls");
            System.out.println("utils.Game 7: Starship Defender");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    startGame(new BrickBreaker());
                    break;
                case 2:
                    startGame(new Snake());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }

    private static void startGame(Game game) {
        game.init();
    }
}
