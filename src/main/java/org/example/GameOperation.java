package org.example;

import java.util.Scanner;

public class GameOperation {
    static final Scanner SC;
    private final StringToConsole STRING_TO_CONSOLE = new StringToConsole();
    private int[] humanNumbers = new int[4];

    public GameOperation() {
    }

    public int[] getMachineNumbers() {
        int[] machineNumbers = new int[4];

        for(int i = 0; i < 4; ++i) {
            machineNumbers[i] = (int)(Math.random() * 10.0);

            for(int j = 0; j < i; ++j) {
                if (machineNumbers[i] == machineNumbers[j]) {
                    --i;
                }
            }
        }

        return machineNumbers;
    }

    public void setHumanNumbers() {
        int[] humanNumbers = new int[4];
        this.humanNumbers = humanNumbers;
        boolean flag = false;

        while(true) {
            while(!flag) {
                String humanMessage = SC.nextLine();
                if (humanMessage.length() != 4) {
                    this.STRING_TO_CONSOLE.incorrectInput();
                } else {
                    String[] arrayString = humanMessage.split("");

                    try {
                        for(int i = 0; i < 4; ++i) {
                            humanNumbers[i] = Integer.parseInt(arrayString[i]);
                        }

                        flag = true;
                    } catch (Exception var6) {
                        this.STRING_TO_CONSOLE.incorrectInput();
                    }
                }
            }

            return;
        }
    }

    public int[] getHumanNumbers() {
        this.setHumanNumbers();
        return this.humanNumbers;
    }

    static {
        SC = new Scanner(System.in);
    }
}
