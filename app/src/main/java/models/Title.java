package models;

public class Title {
    private int idtitle;
    private String titleName;
    private int userID;
    private int achvID;

    public Title(int idtitle, String titleName, int userID, int achvID) {
        this.idtitle = idtitle;
        this.titleName = titleName;
        this.userID = userID;
        this.achvID = achvID;
    }

    public int getIdtitle() {
        return idtitle;
    }

    public void setIdtitle(int idtitle) {
        this.idtitle = idtitle;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAchvID() {
        return achvID;
    }

    public void setAchvID(int achvID) {
        this.achvID = achvID;
    }
}
