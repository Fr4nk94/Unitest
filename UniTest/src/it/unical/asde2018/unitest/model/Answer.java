package it.unical.asde2018.unitest.model;

public class Answer {
	
		private int questionID;  			//The id of the question associated to this answer
		private int id; 					//The id of the current answer
		private boolean isCorrect;			//This value shows if this answer is correct or not
		private String answer_content;		//This is the content of the answer, showed to the student
		
		public Answer(int questionID, int id, boolean isCorrect, String answer_content) {
			super();
			this.questionID = questionID;
			this.id = id;
			this.isCorrect = isCorrect;
			this.answer_content = answer_content;
		}

		public Answer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getQuestionID() {
			return questionID;
		}

		public void setQuestionID(int questionID) {
			this.questionID = questionID;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public boolean isCorrect() {
			return isCorrect;
		}

		public void setCorrect(boolean isCorrect) {
			this.isCorrect = isCorrect;
		}

		public String getAnswer_content() {
			return answer_content;
		}

		public void setAnswer_content(String answer_content) {
			this.answer_content = answer_content;
		}
		
}
