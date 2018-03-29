package chatroom.model;

import java.util.Date;

public class User {
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    private Date time;
    public String getName() {
        return name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime() {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", time=" + time +
                '}';
    }
}
