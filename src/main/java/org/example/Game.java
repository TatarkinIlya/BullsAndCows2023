package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    private final StringToConsole STRING_TO_CONSOLE = new StringToConsole();
    private final Counter COUNTER = new Counter();
    private final GameOperation ARRAY_CREATOR = new GameOperation();
    private final Logger LOGGER = new Logger();
    private final Scanner SCANNER;
    private boolean endOfProgram;

    public Game() throws IOException {
        this.SCANNER = new Scanner(System.in);
    }

    public void start() throws IOException {
        while(!this.endOfProgram) {
            this.STRING_TO_CONSOLE.selectAction();
            switch (this.SCANNER.nextLine()) {
                case "1":
                    int numberOfGame = this.COUNTER.getGameNumber();
                    int bulls = 0;
                    int stepCounter = 0;
                    int[] machineNumbers = this.ARRAY_CREATOR.getMachineNumbers();
                    this.STRING_TO_CONSOLE.getGameNumber(numberOfGame);
                    this.LOGGER.writeStartNewGame(numberOfGame, machineNumbers);
                    this.STRING_TO_CONSOLE.getSayEnterYourValue();

                    while(bulls != 4) {
                        int[] humanNumbers = this.ARRAY_CREATOR.getHumanNumbers();
                        bulls = this.COUNTER.getBullCounts(machineNumbers, humanNumbers);
                        int cows = this.COUNTER.getCowCounts(machineNumbers, humanNumbers);
                        this.STRING_TO_CONSOLE.getSayMoveResult(bulls, cows);
                        if (bulls != 4) {
                            this.STRING_TO_CONSOLE.getSayNextMove();
                        }

                        ++stepCounter;
                        this.LOGGER.writeStep(humanNumbers, bulls, cows);
                    }

                    this.LOGGER.gameResult(stepCounter);
                    this.STRING_TO_CONSOLE.getSayIfWin(stepCounter);
                    break;
                case "2":
                    this.STRING_TO_CONSOLE.getSayRules();
                    break;
                case "3":
                    this.STRING_TO_CONSOLE.endGame();
                    this.endOfProgram = true;
                    break;
                default:
                    this.STRING_TO_CONSOLE.incorrectAction();
            }
        }

        GameOperation.SC.close();
        this.LOGGER.writerClose();
    }
}
