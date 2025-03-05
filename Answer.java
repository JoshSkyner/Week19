import java.util.Random;

public class Answer extends Code {
    public Answer(int numSymbols)
    {
        super(numSymbols);

        // Generate random code based on no. of colours
        for (int i = 0; i < numSymbols; i++)
            setValue(new Random().nextInt(CodeBreaker.NO_OF_COLOURS));
    }
}
