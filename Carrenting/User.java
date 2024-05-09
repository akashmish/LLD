public class User {
    String name;
    Integer userId;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public User(String name, Integer userId) {
        this.name = name;
        this.userId = userId;
    }

}