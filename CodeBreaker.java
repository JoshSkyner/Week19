public class CodeBreaker {
    public static final int NO_OF_COLOURS = 7;

    // The guesses for the game
    private Code[] guesses;
    
    // A position for the current guess
    private int attempt;
    
    // The code to break
    private Answer answer;
    
    // The scoring algorithm (how many matches)
    private Scorer scorer;

    public CodeBreaker(int codeLength, int noOfAttempts)
    {
        attempt = 0;
        answer = new Answer(codeLength);

        guesses = new Code[noOfAttempts];

        for (int i = 0; i < noOfAttempts; i++)
            guesses[i] = new Code(codeLength);

        scorer = new Scorer();
    }

    public int[] updateGuess(int colour)
    {
        int updatedPosition = guesses[attempt].setValue(colour);
        return new int[] { attempt, updatedPosition };
    }

    public void updateAttempt()
    {
        attempt++;
    }

    public int getAttempt()
    {
        return attempt;
    }

    public Code getAnswer()
    {
        return answer;
    }

    public boolean isGuessComplete()
    {
        return guesses[attempt].isComplete();
    }

    public int[] calculateScore()
    {
        int partiallyCorrectCount = 0;

        // Get the number of completely correct code values and update the icons
        int correctCount = scorer.compareCorrect(guesses[attempt], answer);

        // If they're not all correct, then check for partially correct answers
        if (correctCount < answer.getLength())
            partiallyCorrectCount = scorer.comparePartiallyCorrect(guesses[attempt], answer);

        return new int[] { correctCount, partiallyCorrectCount };
    }
}
