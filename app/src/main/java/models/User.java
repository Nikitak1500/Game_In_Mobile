package models;

public class User {
    private int iduser;
    private String userName;
    private String email;
    private String password;
    private String login;
    private int experience;
    private int userBonuses;
    private String userRole;

    public User(int iduser, String userName,
                String email, String password,
                String login, int experience,
                int userBonuses, String userRole) {
        this.iduser = iduser;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.login = login;
        this.experience = experience;
        this.userBonuses = userBonuses;
        this.userRole = userRole;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getUserBonuses() {
        return userBonuses;
    }

    public void setUserBonuses(int userBonuses) {
        this.userBonuses = userBonuses;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
