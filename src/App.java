import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import engine.Gambling;
import model.Gambler;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();
        String[] str = input.split(" ");

        while (!(str[0].equals("0") && str[1].equals("0") && str[2].equals("0"))) {
            int N = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int m = Integer.parseInt(str[2]);
            List<Gambler> removed = new ArrayList<>();

            Gambling gambling = new Gambling(N, k, m);
            gambling.startGamblers();

            while (gambling.getList().getSize() > 0) {
                removed.addAll(gambling.startBets());
            }

            showRemoved(removed, N);

            input = scn.nextLine();
            str = input.split(" ");
        }

        scn.close();
    }

    public static void showRemoved(List<Gambler> gamblers, int N) {
        boolean mod2 = false;
        for (int i = 0; i < N - 1; i++) {
            if (mod2) {
                System.out.printf("  %d,", gamblers.get(i).getRank());
                mod2 = false;
            } else if (gamblers.get(i).getGift()) {
                System.out.printf(" %d,", gamblers.get(i).getRank());
                mod2 = false;
            } else {
                mod2 = true;
                System.out.printf("  %d", gamblers.get(i).getRank());
            }
        }
        System.out.printf("  %d\n", gamblers.get(gamblers.size() - 1).getRank());
    }
}
