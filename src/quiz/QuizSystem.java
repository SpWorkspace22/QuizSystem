package quiz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuizSystem {
	// Initialize Directory to store papers
	static String dirLoc = "D:/QuizSystem/";
	static QuestionAnswers questionAnswers[];
	public static void main(String[] args) {
		// Start The Quiz System
	
		questionAnswers = new QuestionAnswers[2];
		System.out.println("Enter 2 question");
		for(int i = 0; i<2;i++) {
			questionAnswers[i] =  new QuestionAnswers();
			questionAnswers[i].preparePaper();
		}
			
		//Store Paper
		storePaper();
	}

	private static void storePaper() {
		File f = createStructure();
		FileWriter fileWrite = null;
		
		try {
	
			fileWrite = new FileWriter(f);
			for(int i = 0; i<questionAnswers.length;i++) {
				for(Map.Entry mapElement : questionAnswers[i].getQuestionAnswerList().entrySet()) {
					
					String key = (String)mapElement.getKey();
					fileWrite.write("1) "+key+"\n");
					
					ArrayList options = (ArrayList)mapElement.getValue();
					
					for(int j = 0; j < options.size(); j++) {
						fileWrite.write("A)"+options.get(j)+"\n");
					}
					fileWrite.write("\n");
					
				}
			}
			fileWrite.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
	
	private static File createStructure() {
		
		String path = dirLoc+File.separator+"Test.txt";
		
		File f = new File(path);
		f.getParentFile().mkdirs(); 
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	
	
}
