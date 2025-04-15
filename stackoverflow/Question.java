package stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable, Voteable {
    private final int id;
    private final String content;
    private final User author;
    private final int score;
    private final List<Answer> answers;
    private final List<Tag> tags;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private final Date createdAt;

    public Question(String content, User author, List<String> tagNames) {
        this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        this.content = content;
        this.author = author;
        this.score = 0;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.createdAt = new Date();
        this.tags = new ArrayList<>();
        for (String tag : tagNames) {
            this.tags.add(new Tag(tag));
        }
    }

    public void addAnswer(Answer answer) {
        if (answer.getContent() == "") {
            throw new IllegalArgumentException("Answer cannot be null");
        }
        answers.add(answer);
    }

    public void vote(User user, int value) {
        if (value != -1 && value != 1) {
            throw new IllegalArgumentException("Vote value must be -1 or 1");
        }
        votes.add(new Vote(user, value));
    }

    public void addComment(Comment comment) {
        if (comment.getComment() == "") {
            throw new IllegalArgumentException("Comment cannot be null");
        }
        comments.add(comment);
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

    public int getScore() {
        int score = 0;
        for (Vote vote : votes) {
            score += vote.getValue();
        }
        return score;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public Date getCreatedAt() {
        return new Date(createdAt.getTime());
    }
}
