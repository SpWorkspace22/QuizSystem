package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to store question and answers;
public class QuestionAnswers{

	private String question;
	private HashMap<String, ArrayList<String>> questionAnswers;
	private ArrayList<String>  optionList;
	
	
	QuestionAnswers(){
		
		questionAnswers = new HashMap<String, ArrayList<String>>();
		optionList = new ArrayList<String>();
	}
	
	
	public void preparePaper() {
	
		preapareQuestion();
		prepareAnswers();
	}
	
	public void showPaper() {
		System.out.println("Questions are...");
		
		for(Map.Entry mapElement : questionAnswers.entrySet()) {
			String key = (String)mapElement.getKey();
			
			optionList = (ArrayList)mapElement.getValue();
			
			System.out.println(key);
			System.out.println(optionList);
			
		}
	}
	
	public HashMap<String, ArrayList<String>> getQuestionAnswerList() {
		return questionAnswers;
	}
	
	private void preapareQuestion() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter A Question...");
		question=sc.nextLine();
			
	}
	
	private void prepareAnswers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 4 options");
		for(int i=0;i<4;i++) {
			optionList.add(sc.next());
		}
	
		questionAnswers.put(question,optionList);
	}
	
}
