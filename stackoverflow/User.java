package stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final String username;
    private final List<Answer> answers;
    private final List<Question> questions;
    private final List<Comment> comments;

    public User(String name, String username) {
        this.id = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
        this.name = name;
        this.username = username;
        this.answers = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void askQuestion(String question, List<String> tags) {
        Question newQuestion = new Question(question, this, tags);
        questions.add(newQuestion);
    }

    public void answerQuestion(Question question, String answer) {
        Answer newAnswer = new Answer(answer, this, question);
        question.addAnswer(newAnswer);
        answers.add(newAnswer);
    }

    public void addComment(Commentable commentable, String content) {
        Comment comment = new Comment(content, this);
        commentable.addComment(comment);
        comments.add(comment);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

}
