package mybean.data;

public class test_Bean {
	String stuId;                  //学生信息
	String stuPassword;
	String stuName;
	float score;
	
	char [][]question;             //试题信息
	float []sum;
	float []yourAnswer;            //学生答案
	int currentNumber;            //答对题数
	String [][]scoreSort;            //排行榜
	int stuSort;                     //当前排名
	String mess;
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public char[][] getQuestion() {
		return question;
	}
	public void setQuestion(char[][] question) {
		this.question = question;
	}
	public float[] getSum() {
		return sum;
	}
	public void setSum(float[] sum) {
		this.sum = sum;
	}
	public float[] getYourAnswer() {
		return yourAnswer;
	}
	public void setYourAnswer(float[] yourAnswer) {
		this.yourAnswer = yourAnswer;
	}
	public int getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	public String[][] getScoreSort() {
		return scoreSort;
	}
	public void setScoreSort(String[][] scoreSort) {
		this.scoreSort = scoreSort;
	}
	public int getStuSort() {
		return stuSort;
	}
	public void setStuSort(int stuSort) {
		this.stuSort = stuSort;
	}
	
	
	
}
