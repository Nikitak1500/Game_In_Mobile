package models;

public class Raiting {
    private int idraiting;
    private String raitingName;
    private String raitingRequirement;
    private int raitingStep;
    private String raitingRewards;
    private String raitingWinners;

    public Raiting(int idraiting, String raitingName,
                   String raitingRequirement, int raitingStep,
                   String raitingRewards, String raitingWinners) {
        this.idraiting = idraiting;
        this.raitingName = raitingName;
        this.raitingRequirement = raitingRequirement;
        this.raitingStep = raitingStep;
        this.raitingRewards = raitingRewards;
        this.raitingWinners = raitingWinners;
    }

    public int getIdraiting() {
        return idraiting;
    }

    public void setIdraiting(int idraiting) {
        this.idraiting = idraiting;
    }

    public String getRaitingName() {
        return raitingName;
    }

    public void setRaitingName(String raitingName) {
        this.raitingName = raitingName;
    }

    public String getRaitingRequirement() {
        return raitingRequirement;
    }

    public void setRaitingRequirement(String raitingRequirement) {
        this.raitingRequirement = raitingRequirement;
    }

    public int getRaitingStep() {
        return raitingStep;
    }

    public void setRaitingStep(int raitingStep) {
        this.raitingStep = raitingStep;
    }

    public String getRaitingRewards() {
        return raitingRewards;
    }

    public void setRaitingRewards(String raitingRewards) {
        this.raitingRewards = raitingRewards;
    }

    public String getRaitingWinners() {
        return raitingWinners;
    }

    public void setRaitingWinners(String raitingWinners) {
        this.raitingWinners = raitingWinners;
    }
}
