


public class Scorer
{
    private boolean checked[];
    private boolean checkedI[];


    public int compareCorrect(Code code, Answer answer){
        int score = 0;
        for(int i=0; i<answer.getLength(); i++ ){
            if(code.getCode()[i] == answer.getCode()[i]){
                System.out.println("ONE ABSOLUTE CORRECT\n\n");
                score+=1;
            }
        }
        return(score);
    }

    public int comparePartiallyCorrect(Code code, Answer answer){
        int score = 0;
        checked = new boolean[answer.getLength()];
        checkedI = new boolean[answer.getLength()];
        for(int i=0; i<answer.getLength(); i++ ){
            for(int j=0; j<answer.getLength(); j++){
                if((code.getCode()[j] == answer.getCode()[i]) && !checked[j] && (j!=i) && !checkedI[i]){
                    score+=1;
                    System.out.println("ONE PARTIAL CORRECT");
                    checked[j] = true;
                    checkedI[i] = true;
                    
                    break;
                }
            }
        }
        
        return(score);
    }








}





