


public class Code
{

    private int numSymbols;
    private int code[];


    public Code(int numSymbols){
        this.numSymbols = numSymbols;
        code = new int[numSymbols];
        for(int i=0; i<numSymbols;i++){
            code[i] = -1;
        }
        
    }

    public int setValue(int x){

        for(int i=0; i<numSymbols;i++){
            if(code[i] == -1){
                code[i] = x;
                return(x);
            }
        }


        return(x);

    }

    public int getLength(){
        return(code.length);

    }

    public int[] getCode(){
        return(code);
    }
    
    public boolean isComplete(){
        int count = 0;
        int[] testArray = this.getCode();
        
        for(int i=0; i<numSymbols; i++){
            System.out.println(testArray[i]);
            if(testArray[i] != -1){

                count+=1;
            }
        }
        if(count == numSymbols){
            return(true);
        }
        else{
            return(false);
        }
    }

    public String getCodeAsString(){


        String string = new String();
        for(int i=0; i<this.getLength() ; i++){
            string = string + this.code[i];
        }
        return(string);
        
    }



}