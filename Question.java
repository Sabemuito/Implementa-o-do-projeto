import java.util.LinkedList;

public class Question {

    private int id;
    private String title;
    private String subject;
    private LinkedList<String> answerList = new LinkedList<String>(); 
    private int correctAnswer; 
    private int difficulty;

    public Question(int id, String title, String subject, LinkedList<String> answerList, int correctAnswer, int difficulty){
        
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.answerList = answerList;
        this.correctAnswer = correctAnswer;
        this.difficulty = difficulty;

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public void addAnswer(String answer){
        this.answerList.add(answer);
    }

    public void removeAnswer(int i){
        this.answerList.remove(i);
    }

    public LinkedList<String> getAnswers(){
        return answerList;
    }
}

