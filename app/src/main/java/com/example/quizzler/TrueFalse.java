package com.example.quizzler;

public class TrueFalse {
    private int nQuestionsID;
    private boolean nAnswer;

    public TrueFalse(int nQuestionsID, boolean nAnswer){
        this.nAnswer = nAnswer;
        this.nQuestionsID = nQuestionsID;
    }

    public int getnQuestionsID() {
        return nQuestionsID;
    }

    public void setnQuestionsID(int nQuestionsID) {
        this.nQuestionsID = nQuestionsID;
    }

    public boolean isnAnswer() {
        return nAnswer;
    }

    public void setnAnswer(boolean nAnswer) {
        this.nAnswer = nAnswer;
    }
}
