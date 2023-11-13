package fi.tuni.prog3.wordgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordGame {
    private static WordGameState gameState;
    private static String wo;
    private final ArrayList<String> strs = new ArrayList<>();

    public static class WordGameState {
        private String word;
        private int mistakes;
        private int mistakeLimit;
        private int missingChars;

        // Package-private constructor
        private WordGameState(String word, int mistakeLimit, int missingChars) {
            this.word = word;
            this.mistakes = 0;
            this.mistakeLimit = mistakeLimit;
            this.missingChars = missingChars;
        }

        public String getWord() {
            if (getMistakes() > getMistakeLimit()) {
                return wo;
            }
            return word;
        }

        public int getMistakes() {
            if (mistakes > getMistakeLimit()) {
                gameState = null;
            }
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            if (missingChars == 0) gameState = null;
            return missingChars;
        }
    }

    public WordGame(String wordFilename) throws IOException {
        try (var file = new BufferedReader(new FileReader(wordFilename))) {
            String line;
            while ((line = file.readLine()) != null) {
                strs.add(line);
            }
        }
    }

    public void initGame(int wordIndex, int mistakeLimit) {
        wo = strs.get(wordIndex % strs.size());
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < wo.length(); i++) {
            wordBuilder.append("_");
        }
        gameState = new WordGameState(wordBuilder.toString(), mistakeLimit, wo.length());
    }

    public boolean isGameActive() {
        return gameState != null;
    }

    public WordGameState getGameState() throws GameStateException {
        if (gameState == null) {
            throw new GameStateException("There is currently no active word game!");
        }
        return gameState;
    }

    public WordGameState guess(char c) throws GameStateException {
        if (gameState == null) {
            throw new GameStateException("There is currently no active word game!");
        } else {
            boolean flag = false;
            int target = 0;
            if (gameState.word.contains(String.valueOf(Character.toLowerCase(c)))) {
                gameState.mistakes = gameState.getMistakes() + 1;
            } else {
                for (int i = 0; i < wo.length(); i++) {
                    if (wo.toLowerCase().charAt(i) == Character.toLowerCase(c)) {
                        StringBuilder stringBuffer = new StringBuilder(gameState.word);
                        stringBuffer.setCharAt(i, Character.toLowerCase(c));
                        gameState.word = stringBuffer.toString();
                        target++;
                        flag = true;
                    }
                }
                if (flag) {
                    gameState.missingChars = gameState.getMissingChars() - target;
                } else {
                    gameState.mistakes = gameState.getMistakes() + 1;
                }
            }
        }
        return gameState;
    }

    public WordGameState guess(String word) throws GameStateException {
        if (gameState == null) {
            throw new GameStateException("There is currently no active word game!");
        } else {
            if (wo.equals(word)) {
                gameState.missingChars = 0;
                gameState.word = wo;
            } else {
                gameState.mistakes = gameState.getMistakes() + 1;
            }
            return gameState;
        }
    }
}
