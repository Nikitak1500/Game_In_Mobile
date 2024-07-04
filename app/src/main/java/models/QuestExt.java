package models;

public class QuestExt {
    private Quest quest;
    private int remaining_time;

    public QuestExt() {
    }

    public QuestExt(Quest quest, int remaining_time) {
        this.quest = quest;
        this.remaining_time = remaining_time;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public int getRemaining_time() {
        return remaining_time;
    }

    public void setRemaining_time(int remaining_time) {
        this.remaining_time = remaining_time;
    }
}
