package com.android.smplqz;

/**
 * Created by Ostap on 26.03.2016.
 */
public class Question {
    private String text;
    private int ans;
    private String[] psb_ans;

    public Question(String text, int ans, String... psb_ans) {
        this.text = text;
        this.ans = ans;

        this.psb_ans = new String[psb_ans.length];
        for (int i = 0; i < psb_ans.length; i++) {
            this.psb_ans[i] = psb_ans[i];
        }
    }

    public String getText() {
        return text;
    }

    public String[] getPsbAns() {
        return psb_ans;
    }

    public int getAns() {
        return ans;
    }
}
