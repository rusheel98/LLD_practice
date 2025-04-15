package stackoverflow;

import java.util.HashMap;
import java.util.List;

public class StackOverflow {
    HashMap<Integer, User> users;
    HashMap<Integer, Question> questions;
    HashMap<Integer, Answer> answers;
    HashMap<String, Tag> tags;

    public StackOverflow() {
        users = new HashMap<>();
        questions = new HashMap<>();
        answers = new HashMap<>();
        tags = new HashMap<>();
    }

    public void addUser(String name, String username) {
        User user = new User(name, username);
        users.put(user.getId(), user);
    }

    public void askQuestion(User user, String content, List<String> Tags) {
        for (Question question : questions.values()) {
            if (question.getContent().equals(content)) {
                throw new IllegalArgumentException("Question already exists");
            }
        }
        Question question = new Question(content, user, Tags);
        questions.put(question.getId(), question);
        for (Tag tag : question.getTags()) {
            tags.putIfAbsent(tag.getName(), tag);
        }
    }

    public void answerQuestion(User user, Question question, String content) {
        Answer answer = new Answer(content, user, question);
        user.answerQuestion(question, content);
        answers.put(answer.getId(), answer);
    }

    public void addComment(Commentable commentable, User user, String content) {
        user.addComment(commentable, content);
    }

    public void voteQuestion(Question question, User user, int value) {
        question.vote(user, value);
    }

    public void voteAnswer(Answer answer, User user, int value) {
        answer.vote(user, value);
    }

    public void acceptAnswer() {
    }

    public Question getQuestion(String query) {
        for (Question question : questions.values()) {
            if (question.getContent().contains(query)) {
                return question;
            }
        }
        return null;
    }

    public List<Question> getQuestions() {
        return List.copyOf(questions.values());
    }

    public List<Answer> getAnswers(String query) {
        for (Question q : questions.values()) {
            if (q.getContent().equals(query)) {
                return q.getAnswers();
            }
        }
        return null;
    }

    public User getUser(int id) {
        return users.get(id);
    }

}