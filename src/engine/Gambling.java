package engine;

import java.util.List;

import model.Gambler;

public class Gambling {

    private int N;
    private int k;
    private int m;
    private ListCircle list;

    public Gambling(int N, int k, int m) {
        this.N = N;
        this.k = k;
        this.m = m;
        this.list = new ListCircle();
    }

    public void startGamblers() {
        int rank = 1;
        for (int i = 0; i < this.N; i++) {
            Gambler gambler = new Gambler();
            gambler.setRank(rank);
            list.add(gambler);
            rank++;
        }
    }

    public List<Gambler> startBets() {
        return list.remove(k, m);
    }

    public ListCircle getList() {
        return this.list;
    }
}
