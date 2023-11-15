import java.util.Scanner;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) {
        
        Boolean loop = true;
        Scanner scan = new Scanner(System.in);

        // Criando Lista de perguntas e pergunta de exemplo
        LinkedList<Question> questionList = new LinkedList<Question>();
        LinkedList<String> exampleAnswers = new LinkedList<String>();
        exampleAnswers.add("Earth");
        exampleAnswers.add("Venus");
        exampleAnswers.add("Mars");
        Question exampleQuestion = new Question(
            1, 
            "What planet is the closest to the Sun?", 
            "Cience", 
            exampleAnswers,
            2, 
            1
        );
        questionList.add(exampleQuestion);
        // final
        
        System.out.println("\nWelcome to the Best Software in the world!");

        while(loop){
            System.out.println("\n################### SISTEM MENU ###################\n");
            System.out.println("Please choose one of the following options:\n");
            System.out.println("Add new Question (1)");
            System.out.println("Show list of Questions added (2)");
            System.out.println("Remove Question (3)"); 
            System.out.println("Edit Question (4)"); // Fazendo
            System.out.println("Simulate a Test (4)"); // Falta fazer
            System.out.println("End (6)");
            System.out.println("\n###################################################\n");
            int x = scan.nextInt();
            switch(x){
                case 1: // Adicionar pergunta nova
                    int id = questionList.size() + 1;
                    System.out.println("\nInform the title:");
                    scan.nextLine();
                    String title = scan.nextLine();
                    System.out.println("\nInform the subject:");
                    String subject = scan.nextLine();
                    LinkedList<String> answerList = new LinkedList<String>();
                    System.out.println("\nIt is required to add at least 2 answers:");
                    Boolean addQuestionLoop = true;
                    while(addQuestionLoop){
                        System.out.println("\nDo you wish to add a new Answer? \n(1) - Yes \n(2) - No");
                        int b = scan.nextInt();
                        if(b == 1){
                            System.out.println("\nInform the Answer:");
                            scan.nextLine();
                            String newAnswer = scan.nextLine();
                            answerList.add(newAnswer);
                        }
                        else if(b == 2){
                            if(answerList.size() >= 2){
                                addQuestionLoop = false;
                            }
                            else{
                                System.out.println("\nERROR!!! You haven't informed the minimum amount of answers!");
                            }
                        }
                    }
                    System.out.println(answerList); 
                    System.out.println("\nInform the numeral position of the Correct Answer:");
                    int correctAnswer = scan.nextInt();
                    System.out.println("\nInform the level of Difficulty:");
                    int difficulty = scan.nextInt();
                    Question addQuestion = new Question(id, title, subject, answerList, correctAnswer, difficulty);
                    questionList.add(addQuestion);
                    break;
                case 2: // Listar todas as perguntas adicionadas
                    System.out.println("\n################ LIST OF QUESTIONS ################");
                    int listPosition = 0;
                    while(listPosition < questionList.size()){
                        Question showQuestion = questionList.get(listPosition);
                        System.out.println("\nQuestion Number " + showQuestion.getId());
                        System.out.println("\nQuestion Subject: " + showQuestion.getSubject());
                        System.out.println("Question Title: " + showQuestion.getTitle());
                        System.out.println("Answers: " + showQuestion.getAnswers());
                        System.out.println("Correct Answer: " + showQuestion.getCorrectAnswer());
                        System.out.println("Difficulty: " + showQuestion.getDifficulty());
                        listPosition++;
                    }
                    System.out.println("\n###################################################\n");
                    break;
                case 3: // Remover pergunta
                    System.out.println("\n################# REMOVE QUESTION #################\n");
                    Boolean removeLoop = true;
                    while(removeLoop){
                        System.out.println("Informe the ID from the Question you want to remove:");
                        System.out.println("\n###################################################\n");
                        int questionId = scan.nextInt();
                        scan.nextLine();
                        for (int i = 0; i < questionList.size(); i++){
                            if (questionId == questionList.get(i).getId()){
                                System.out.println("\nRemoving Question Number: " + questionList.get(i).getId());
                                questionList.remove(i);
                                removeLoop = false;
                            }
                        }
                        if(removeLoop){
                            System.out.println("\nThe ID was not found!\n");
                        }
                    }
                    System.out.println("\n###################################################\n");
                    break;
                case 4: // Editar pergunta
                    System.out.println("\n################## EDIT QUESTION ##################\n");
                    Boolean editLoop = true;
                    while(editLoop){
                        System.out.println("Informe the ID from the Question you want to edit:");
                        System.out.println("\n###################################################\n");
                        int questionId = scan.nextInt();
                        scan.nextLine();
                        for (int i = 0; i < questionList.size(); i++){
                            if (questionId == questionList.get(i).getId()){
                                System.out.println("\n################## EDIT QUESTION ##################\n");
                                System.out.println("What do you wish to edit?");
                                System.out.println("Subject (1)");
                                System.out.println("Title (2)");
                                System.out.println("Add Answer (3)");
                                System.out.println("Remove Answer (4)");
                                System.out.println("Correct Answer (5)");
                                System.out.println("Difficulty (6)");
                                System.out.println("Cancel (7)");
                                System.out.println("\n###################################################\n");
                                int y = scan.nextInt();
                                scan.nextLine();
                                switch(y){
                                    case 1:
                                        System.out.println("\nInform the new Subject:\n");
                                        String newSubject = scan.nextLine();
                                        questionList.get(i).setSubject(newSubject);
                                        System.out.println("The Subject was altered with success!");
                                        break;
                                    case 2:
                                        System.out.println("\nInform the new Title:\n");
                                        String newTitle = scan.nextLine();
                                        questionList.get(i).setTitle(newTitle);
                                        System.out.println("The Title was altered with success!");
                                        break;
                                    case 3: 
                                        System.out.println("\nInform the new Answer to be added:\n");
                                        String newAnswer = scan.nextLine();
                                        questionList.get(i).addAnswer(newAnswer);
                                        System.out.println("The Answer was added with success!");
                                        break;
                                    case 4:
                                        System.out.println("\nInform the numeral position of the Answer you want to remove:\n");
                                        int removeAnswer = scan.nextInt();
                                        questionList.get(i).removeAnswer(removeAnswer);
                                        System.out.println("The Answer was removed with success!");
                                        break;
                                    case 5: // Não está pronto
                                        System.out.println("\nInform the new numeral position of the Correct Answer:\n");
                                        int newCorrectAnswer = scan.nextInt();
                                        questionList.get(i).setCorrectAnswer(newCorrectAnswer);
                                        System.out.println("The Correct Answer was altered with success!");
                                        break;
                                    case 6:
                                        System.out.println("\nInform the new Difficulty:\n");
                                        String newDifficulty = scan.nextLine();
                                        questionList.get(i).setTitle(newDifficulty);
                                        System.out.println("The Difficulty was altered with success!");
                                        break;
                                    case 7:
                                        System.out.println("\nOperation canceled!");
                                        break;
                                        
                                }
                                editLoop = false;
                            }
                        }
                        if(editLoop){
                            System.out.println("\nThe ID was not found!\n");
                        }
                    }
                    System.out.println("\n###################################################\n");
                    break;
                case 5: // Simular Prova
                    System.out.println("\nExcluido");
                    break;
                case 6: // Finalizar sistema
                    System.out.println("\nFechando o sistema... Tchau tchau");
                    loop = false;
                    break;
                default:
                    System.out.println("\nERROR!\n");
                    System.out.println("Type a valid number!! ");
            }
        }        
    }
}




//     float price = 1.5f;
//     float quantity, total, x, y;
//     System.out.println("\n##############################################");
//     System.out.println("### Seja Bem Vindo ao Pão de Queijo do Zé! ###");
//     System.out.println("##############################################");
//     System.out.println("\nQuantos pãos de queijo gostaria?");
//     quantity = scan.nextFloat();
//     System.out.println("\nGostaria de parcelas em quantas vezes?");
//     x = scan.nextInt();
//     total = quantity * price;
//     y = total / x;
//     System.out.println("\n######### NOTA FISCAL #########");
//     System.out.println("\nValor total: R$" + total);
//     System.out.println("\nValor do produto: R$" + price);
//     System.out.println("Quantidade: " + quantity);
//     System.out.println("\nQuantidade de parcelas: " + x);
//     System.out.println("Valor das parcelas: R$" + y);
//     System.out.println("\n###############################");