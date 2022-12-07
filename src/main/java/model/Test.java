package model;

public class Test {
    private long id;
    private  long subjectId;
    private String text;
    private int difficult;
    private int duration; //DateTime
    private int amountQuestions;

    public Test() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAmountQuestions() {
        return amountQuestions;
    }

    public void setAmountQuestions(int amountQuestions) {
        this.amountQuestions = amountQuestions;
    }
}
