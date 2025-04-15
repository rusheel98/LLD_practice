package stackoverflow;

import java.util.Date;

public class Comment {
    private final int id;
    private final String text;
    private final User author;
    private final Date createdAt;

    public Comment(String text, User user) {
        this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        ;
        this.text = text;
        this.author = user;
        this.createdAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return text;
    }

    public User getUser() {
        return author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
