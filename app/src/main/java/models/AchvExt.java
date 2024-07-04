package models;

public class AchvExt {
    private Achievement achievement;
    private Title title;

    public AchvExt(Achievement achievement, Title title) {
        this.achievement = achievement;
        this.title = title;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
