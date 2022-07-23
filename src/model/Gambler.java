package model;

public class Gambler {

    private int rank;
    private Gambler nextGambler;
    private Gambler previousGambler;
    private boolean chosen;
    private boolean gift;

    public Gambler() {
        this.nextGambler = null;
        this.previousGambler = null;
        this.chosen = false;
        this.gift = false;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Gambler getNextGambler() {
        return this.nextGambler;
    }

    public void setNextGambler(Gambler nextGambler) {
        if (!nextGambler.getChosen()) {
            this.nextGambler = nextGambler;
        } else {
            this.nextGambler = nextGambler.getNextGambler();
        }
    }

    public Gambler getPreviousGambler() {
        return this.previousGambler;
    }

    public void setPreviousGambler(Gambler previousGambler) {
        if (!previousGambler.getChosen()) {
            this.previousGambler = previousGambler;
        } else {
            this.previousGambler = previousGambler.getPreviousGambler();
        }
    }

    public boolean getGift() {
        return this.gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public boolean getChosen() {
        return this.chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

}
