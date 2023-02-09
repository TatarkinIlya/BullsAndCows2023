package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Logger {
    private final FileWriter writer = new FileWriter("completed_game.log", true);
    private final SimpleDateFormat FORMAT_FOR_DATE_NOW = new SimpleDateFormat();
    private final GameUtils COUNT_TO_STRING = new GameUtils();
    Date dateNow = new Date();

    public Logger() throws IOException {
    }

    void writeStartNewGame(int numberOfGame, int[] machineNumbers) throws IOException {
        this.writer.write("Game #" + numberOfGame + " " + this.FORMAT_FOR_DATE_NOW.format(this.dateNow) + ". Загаданная строка " + Arrays.toString(machineNumbers) + "\n");
    }

    void writeStep(int[] humanNumbers, int bulls, int cows) throws IOException {
        String var10001 = Arrays.toString(humanNumbers);
        this.writer.write("\tЗапрос: " + var10001 + ". Ответ: " + this.COUNT_TO_STRING.getBullToString(bulls) + " и " + this.COUNT_TO_STRING.getCowToString(cows) + "\n");
    }

    public void gameResult(int stepCounter) throws IOException {
        String var10001 = this.COUNT_TO_STRING.getStepToString(stepCounter);
        this.writer.write("Игра была завершена за " + var10001 + "\n\n");
        this.writer.flush();
    }

    public void writerClose() throws IOException {
        this.writer.close();
    }
}
