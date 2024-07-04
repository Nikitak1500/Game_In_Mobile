package models;

public class Level {
    private int idlevel;
    private String levelName;
    private int expAmount;
    private Reward levelReward;

    public Level(int idlevel, String levelName, int expAmount, Reward levelReward) {
        this.idlevel = idlevel;
        this.levelName = levelName;
        this.expAmount = expAmount;
        this.levelReward = levelReward;
    }

    public int getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(int idlevel) {
        this.idlevel = idlevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getExpAmount() {
        return expAmount;
    }

    public void setExpAmount(int expAmount) {
        this.expAmount = expAmount;
    }

    public Reward getLevelReward() {
        return levelReward;
    }

    public void setLevelReward(Reward levelReward) {
        this.levelReward = levelReward;
    }
}
