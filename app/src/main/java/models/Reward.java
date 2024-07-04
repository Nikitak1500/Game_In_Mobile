package models;

public class Reward {
    private int idreward;
    private String rewardValue;
    private Integer rewardCost;

    public Reward(int idreward, String rewardValue, Integer rewardCost) {
        this.idreward = idreward;
        this.rewardValue = rewardValue;
        this.rewardCost = rewardCost;
    }

    public int getIdreward() {
        return idreward;
    }

    public void setIdreward(int idreward) {
        this.idreward = idreward;
    }

    public String getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(String rewardValue) {
        this.rewardValue = rewardValue;
    }

    public Integer getRewardCost() {
        return rewardCost;
    }

    public void setRewardCost(Integer rewardCost) {
        this.rewardCost = rewardCost;
    }
}
