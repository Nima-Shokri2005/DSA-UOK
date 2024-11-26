import java.util.Arrays;

public class DieGame {
    public static int[] DieGame(int num, int beginner, int step, int rem) {
        int deathCount = 0;
        int stepCount = 0;
        boolean[] players = new boolean[num];
        Arrays.fill(players, true);
        for (int i = beginner; num - deathCount > rem; i = (i + 1) % num) {
            if (players[i]) {
                stepCount++;
                if (stepCount == step) {
                    deathCount++;
                    stepCount = 0;
                    players[i] = false;
                }
            }

        }
        int[] result = new int[rem];
        int index = 0;
        for (int i = 0; i < num; i++) {
            if (players[i]) {
                System.out.println(i);
                result[index++] = i;
            }
        }
        return result;
    }

}