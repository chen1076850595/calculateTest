package myservlet.control;
import java.util.Random;
public class Question {
	float sum[];
	float thisSum;
	char[][]Question;
	public  Question(int n){
		Question = new char[n][];
		sum = new float[n];
		for(int i=0;i<n;i++){
			Question[i] = getQ();
			sum[i] = (float)(Math.round(thisSum*100))/100;;
		}
	}
	public char[] getQ(){
		char operator[] = {'+','-','*','/'};
		int Qlength =new Random().nextInt(3)+2;    //算式的长度
		int Qnumber[] = new int[Qlength];
		char Qoperator[] = new char[Qlength-1];
		char Q[] = new char[Qlength+Qlength-1];
		for(int i=0;i<Qlength;i++){
			Qnumber[i] = new Random().nextInt(9)+1;
		}
		for(int i=0;i<Qlength-1;i++){
			Qoperator[i] = operator[(int)new Random().nextInt(4)];
		}
		for(int j=0;j<Qlength+Qlength-1;j++){
			if(j%2==0){
				Q[j] = (char)(Qnumber[j/2]+48);
			}
			if(j%2==1){
				Q[j] = Qoperator[j/2];
			}
		}
		//求和
		float Qnum[] = new float[Qnumber.length];
		for(int i=0;i<Qnumber.length;i++){
			Qnum[i] = (float)Qnumber[i];
		}
		for(int i=0;i<Qlength-1;i++){
			if(Qoperator[i]=='*'||Qoperator[i]=='/'){
				switch(Qoperator[i]){
				case '*':
					Qnum[i+1]=Qnum[i]*Qnum[i+1];
					Qnum[i]=0;
					if(i>0) Qoperator[i]=Qoperator[i-1];
					else Qoperator[i]='+';
					break;
				case '/':
					Qnum[i+1]=Qnum[i]/Qnum[i+1];
					Qnum[i]=0;
					if(i>0) Qoperator[i]=Qoperator[i-1];
					else Qoperator[i]='+';
					break;
				}
			}
			
		}
		for(int i=0;i<Qlength-1;i++){
			switch(Qoperator[i]){
			case '+':
				Qnum[i+1]=Qnum[i]+Qnum[i+1];
				break;
			case '-':
				Qnum[i+1]=Qnum[i]-Qnum[i+1];
				break;
			}
		}
		thisSum = Qnum[Qlength-1];
		for(int i=0;i<Qlength+Qlength-1;i++){
			System.out.print(Q[i]);
		}
		System.out.println(" ");
		return Q;		
	}
	public float[] getSum(){
		return sum;
	}
	public char[][] getQuestion(){
		return Question;
	}
}
