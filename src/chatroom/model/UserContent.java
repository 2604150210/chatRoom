package chatroom.model;

import java.util.Date;

/**
 * Created by jal on 2018/3/28 0028.
 */
public class UserContent {
    private String name;
    private String content;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
