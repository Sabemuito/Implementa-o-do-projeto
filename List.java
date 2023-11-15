import java.util.LinkedList;


public class List {
    
    private LinkedList<Question> questionList = new LinkedList<Question>(); 

    public List(){
    }

    public LinkedList<Question> getQuestions(){
        return questionList;
    }

    public void addQuestion(Question question){
        this.questionList.add(question);
    }

    public void removeQuestion(Question question){
        int i = this.questionList.indexOf(question);
        this.questionList.remove(i);
    }

    
    
}
