public class MainChallange {
    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int highScore = calculateScore(true, 800, 5, 100);

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        calculateScore(gameOver, score, levelCompleted, bonus);
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        int finalScore = score;

        if (gameOver) /*best practice is (gameOver) cause (gameOver===true is always true)*/ {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }
        return finalScore;
    }
}
        //FIRST WAY
        //rename variables names
//        boolean newGameOver = true;
//        int newScore = 10000;
//        int newLevelCompleted = 8;
//        int newBonus = 200;
//
//        int newFinalScore = newScore;
//
//        if (newGameOver == true /*best practice is (gameOver) cause is true by default */) {
//            newFinalScore += (newLevelCompleted * newBonus);
//            System.out.println("Your Final score was " + newFinalScore);
//        }

        //ANOTHER WAY
//            score = 10000;
//            levelCompleted = 8;
//            bonus = 200;
//
//            finalScore = score;
//
//            if (gameOver == true /*best practice is (gameOver) cause is true by default */) {
//                finalScore += (levelCompleted * bonus);
//                System.out.println("Your Final score was " + finalScore);
//            }

