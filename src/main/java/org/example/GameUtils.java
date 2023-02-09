package org.example;

public class GameUtils {
    private String str = "";

    public GameUtils() {
    }

    public String getBullToString(int bullCounter) {
        if (bullCounter != 0 && bullCounter < 4) {
            if (bullCounter >= 2) {
                this.str = "" + bullCounter + " быка";
            } else if (bullCounter == 1) {
                this.str = "" + bullCounter + " бык";
            }
        } else {
            this.str = "" + bullCounter + " быков";
        }

        return this.str;
    }

    public String getCowToString(int cowCounter) {
        if (cowCounter != 0 && cowCounter < 4) {
            if (cowCounter >= 2) {
                this.str = "" + cowCounter + " коровы";
            } else if (cowCounter == 1) {
                this.str = "" + cowCounter + " корова";
            }
        } else {
            this.str = "" + cowCounter + " коров";
        }

        return this.str;
    }

    public String getStepToString(int stepCounter) {
        this.str = "" + stepCounter + " ходов";
        int rem = stepCounter % 100;
        if (rem < 11 || rem > 14) {
            rem = stepCounter % 10;
            if (rem == 1) {
                this.str = "" + stepCounter + " ход";
            }

            if (rem >= 2 && rem <= 4) {
                this.str = "" + stepCounter + " хода";
            }
        }

        return this.str;
    }
}
