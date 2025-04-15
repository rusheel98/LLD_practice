package stackoverflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Answer implements Voteable, Commentable {
    private final int id;
    private final String content;
    private final User author;
    private final List<Comment> comments;
    private final Question question;
    private final List<Vote> votes;
    private final Date creationDate;
    private boolean isAccepted;

    public Answer(String content, User user, Question question) {
        this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        this.content = content;
        this.author = user;
        this.question = question;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.creationDate = new Date();
        this.isAccepted = false;
    }

    public void addComment(Comment comment) {
        if (comment.getComment() == "") {
            throw new IllegalArgumentException("Comment content cannot be empty");
        }
        addComment(comment);
    }

    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException("Vote value must be 1 or -1");
        }
        votes.add(new Vote(user, value));
    }

    public int getScore() {
        int score = 0;
        for (Vote vote : votes) {
            score += vote.getValue();
        }
        return score;
    }

    public void setAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("Answer is already accepted");
        }
        isAccepted = true;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getQuestion() {
        return question.getContent();
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

}
