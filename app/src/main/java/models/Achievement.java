package models;

public class Achievement {
    private int idachievement;
    private String achvName;
    private String achvRequirement;
    private int achvGoal;
    private int achvStep;
    private Reward achvReward;
    private int achvExp;
    private int achvBonuses;
    private String achvTitle;

    public Achievement(int idachievement, String achvName,
                       String achvRequirement, int achvGoal,
                       int achvStep, Reward achvReward,
                       int achvExp, int achvBonuses,
                       String achvTitle) {
        this.idachievement = idachievement;
        this.achvName = achvName;
        this.achvRequirement = achvRequirement;
        this.achvGoal = achvGoal;
        this.achvStep = achvStep;
        this.achvReward = achvReward;
        this.achvExp = achvExp;
        this.achvBonuses = achvBonuses;
        this.achvTitle = achvTitle;
    }

    public int getIdachievement() {
        return idachievement;
    }

    public void setIdachievement(int idachievement) {
        this.idachievement = idachievement;
    }

    public String getAchvName() {
        return achvName;
    }

    public void setAchvName(String achvName) {
        this.achvName = achvName;
    }

    public String getAchvRequirement() {
        return achvRequirement;
    }

    public void setAchvRequirement(String achvRequirement) {
        this.achvRequirement = achvRequirement;
    }

    public int getAchvGoal() {
        return achvGoal;
    }

    public void setAchvGoal(int achvGoal) {
        this.achvGoal = achvGoal;
    }

    public int getAchvStep() {
        return achvStep;
    }

    public void setAchvStep(int achvStep) {
        this.achvStep = achvStep;
    }

    public Reward getAchvReward() {
        return achvReward;
    }

    public void setAchvReward(Reward achvReward) {
        this.achvReward = achvReward;
    }

    public int getAchvExp() {
        return achvExp;
    }

    public void setAchvExp(int achvExp) {
        this.achvExp = achvExp;
    }

    public int getAchvBonuses() {
        return achvBonuses;
    }

    public void setAchvBonuses(int achvBonuses) {
        this.achvBonuses = achvBonuses;
    }

    public String getAchvTitle() {
        return achvTitle;
    }

    public void setAchvTitle(String achvTitle) {
        this.achvTitle = achvTitle;
    }
}
