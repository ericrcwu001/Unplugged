public class Main {
    public static void main(String[] args) {
        //
        String commonWords = "src/commonWords.txt";
        String textOne = "src/textOne.txt";
        String textTwo = "src/textTwo.txt";

        // Text One
        Counter counter = new Counter(commonWords, textOne);
        String[] topFiveWords = counter.getTopFiveWords();
        int[] topFiveFrequencies = counter.getTopFiveFrequencies();

        System.out.println("The top " + topFiveWords.length + " words in text one and their frequencies are:");
        int tCnt = 0;
        printTopFive(topFiveWords, topFiveFrequencies, tCnt);

        System.out.println();

        // Text Two
        Counter counter2 = new Counter(commonWords, textTwo);
        topFiveWords = counter2.getTopFiveWords();
        topFiveFrequencies = counter2.getTopFiveFrequencies();

        System.out.println("The top " + topFiveWords.length + " words in text two and their frequencies are:");
        tCnt = 0;
        printTopFive(topFiveWords, topFiveFrequencies, tCnt);
    }

    /**
     * @param topFiveWords String[] array of the top-N-words (N can change depending on ties)
     * @param topFiveFrequencies int[] array of the top-N-words (N can change depending on ties)
     * @param tCnt int value of a temporary count
     */
    private static void printTopFive(String[] topFiveWords, int[] topFiveFrequencies, int tCnt) {
        for (int i = 0; i < topFiveWords.length; ++i) {
            if (i == 0)
                System.out.println(i+1 + ") " + topFiveWords[i] + ": " + topFiveFrequencies[i]);
            else {
                if (topFiveFrequencies[i] == topFiveFrequencies[i-1]) {
                    tCnt++;
                    System.out.println(i+1-tCnt + ") " + topFiveWords[i] + ": " + topFiveFrequencies[i]);
                } else {
                    tCnt = 0;
                    System.out.println(i+1 + ") " + topFiveWords[i] + ": " + topFiveFrequencies[i]);
                }
            }
        }
    }
}