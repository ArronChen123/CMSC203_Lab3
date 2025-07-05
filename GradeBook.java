package application;

/**
 * GradeBook class — CMSC203 Lab 3
 */
public class GradeBook {

    private double[] scores;
    private int scoresSize;

    /** Constructs a gradebook with given capacity. */
    public GradeBook(int capacity) {
        scores = new double[capacity];
        scoresSize = 0;
    }

    /** Adds a score if there is room. */
    public boolean addScore(double score) {
        if (scoresSize < scores.length) {
            scores[scoresSize] = score;
            scoresSize++;
            return true;
        }
        return false;
    }

    /** @return sum of all stored scores */
    public double sum() {
        double total = 0;
        for (int i = 0; i < scoresSize; i++) {
            total += scores[i];
        }
        return total;
    }

    /** @return minimum score or 0 if empty */
    public double minimum() {
        if (scoresSize == 0) return 0;
        double smallest = scores[0];
        for (int i = 1; i < scoresSize; i++) {
            if (scores[i] < smallest) smallest = scores[i];
        }
        return smallest;
    }

    /** @return final score (sum – lowest) or special cases per spec */
    public double finalScore() {
        if (scoresSize == 0)         return 0;
        if (scoresSize == 1)         return scores[0];
        return sum() - minimum();
    }

    /* ---------- Lab-3 Task #1 new helper methods ---------- */

    /** @return how many scores have been added */
    public int getScoreSize() {
        return scoresSize;
    }

    /** @return all scores separated by a space, with trailing space */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scoresSize; i++) {
            sb.append(scores[i]).append(' ');
        }
        return sb.toString();
    }
}
