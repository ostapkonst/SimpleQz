package com.android.smplqz;

/**
 * Created by Ostap on 27.03.2016.
 */
public class QuizResult {

    enum State {DONE, FAILED, SKIPPED}

    private static int done;
    private static int skipped;
    private static int count;
    private static State[] status;

    public static void setValue(int num, int val, int ans) {
        if (status[num] == State.SKIPPED) {
            status[num] = State.FAILED;
            skipped--;
        } else if (status[num] == State.DONE) {
            status[num] = State.FAILED;
            done--;
        }

        if (val == ans) {
            status[num] = State.DONE;
            done++;
        }
    }

    public static State getState(int num) {
        return status[num];
    }

    public static int getCount() {
        return count;
    }

    public static int getDone() {
        return done;
    }

    public static int getSkipped() {
        return skipped;
    }

    public static int getFailed() {
        return count - done - skipped;
    }

    public static void setSize(int size) {
        done = 0;
        skipped = count = size;
        status = new State[count];
        for (int i = 0; i < count; i++) {
            status[i] = State.SKIPPED;
        }
    }
}
