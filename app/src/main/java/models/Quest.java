package models;

public class Quest {
    private int idquest;
    private String questName;
    private String questRequirement;
    private int questGoal;
    private int questStep;
    private Reward questReward;
    private int questExp;
    private int questBonuses;
    private int questCooldown;

    public Quest(int idquest, String questName, String questRequirement, int questGoal,
                 int questStep, Reward questReward, int questExp, int questBonuses,
                 int questCooldown) {
        this.idquest = idquest;
        this.questName = questName;
        this.questRequirement = questRequirement;
        this.questGoal = questGoal;
        this.questStep = questStep;
        this.questReward = questReward;
        this.questExp = questExp;
        this.questBonuses = questBonuses;
        this.questCooldown = questCooldown;
    }

    public Quest() {
    }

    public int getIdquest() {
        return idquest;
    }

    public void setIdquest(int idquest) {
        this.idquest = idquest;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public String getQuestRequirement() {
        return questRequirement;
    }

    public void setQuestRequirement(String questRequirement) {
        this.questRequirement = questRequirement;
    }

    public int getQuestGoal() {
        return questGoal;
    }

    public void setQuestGoal(int questGoal) {
        this.questGoal = questGoal;
    }

    public int getQuestStep() {
        return questStep;
    }

    public void setQuestStep(int questStep) {
        this.questStep = questStep;
    }

    public Reward getQuestReward() {
        return questReward;
    }

    public void setQuestReward(Reward questReward) {
        this.questReward = questReward;
    }

    public int getQuestExp() {
        return questExp;
    }

    public void setQuestExp(int questExp) {
        this.questExp = questExp;
    }

    public int getQuestBonuses() {
        return questBonuses;
    }

    public void setQuestBonuses(int questBonuses) {
        this.questBonuses = questBonuses;
    }

    public int getQuestCooldown() {
        return questCooldown;
    }

    public void setQuestCooldown(int questCooldown) {
        this.questCooldown = questCooldown;
    }
}
