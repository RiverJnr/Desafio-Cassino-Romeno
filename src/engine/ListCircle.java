package engine;

import java.util.ArrayList;
import java.util.List;

import model.Gambler;

public class ListCircle {

    private Gambler firstCursor; // clockwise
    private Gambler secondCursor;// counterclockwise
    private int size;

    public ListCircle() {
        this.size = 0;
        this.firstCursor = null;
        this.secondCursor = null;
    }

    public void add(Gambler gambler) {
        if (this.firstCursor == null) {
            this.firstCursor = gambler;
            this.secondCursor = gambler;
            this.firstCursor.setNextGambler(gambler);
            this.secondCursor.setPreviousGambler(gambler);
            this.size++;
        } else {
            gambler.setPreviousGambler(this.firstCursor);
            gambler.setNextGambler(this.firstCursor.getNextGambler());
            this.firstCursor.setNextGambler(gambler);
            gambler.getNextGambler().setPreviousGambler(gambler);
            this.size++;
        }
        this.clockwise();
    }

    public List<Gambler> remove(int k, int m) {

        List<Gambler> removed = new ArrayList<>();

        if (this.size > 0 && k > 0 && m > 0) {

            for (int i = 0; i < k; i++) {
                this.clockwise();
            }
            this.firstCursor.setChosen(true);

            for (int i = 0; i < m; i++) {
                this.counterClockWise();
            }
            this.secondCursor.setChosen(true);

            if (!this.firstCursor.equals(this.secondCursor)) {

                if (this.size == 2) {
                    removed.add(this.firstCursor);
                    removed.add(this.secondCursor);

                    this.clear();

                    return removed;
                }

                this.firstCursor.getPreviousGambler().setNextGambler(this.firstCursor.getNextGambler());
                this.firstCursor.getNextGambler().setPreviousGambler(this.firstCursor.getPreviousGambler());
                this.size--;

                this.secondCursor.getPreviousGambler().setNextGambler(this.secondCursor.getNextGambler());
                this.secondCursor.getNextGambler().setPreviousGambler(this.secondCursor.getPreviousGambler());
                this.size--;

                removed.add(this.firstCursor);
                removed.add(this.secondCursor);

                this.firstCursor = this.firstCursor.getPreviousGambler();
                this.secondCursor = this.secondCursor.getNextGambler();
            } else {

                this.firstCursor.getPreviousGambler().setNextGambler(this.firstCursor.getNextGambler());
                this.firstCursor.getNextGambler().setPreviousGambler(this.firstCursor.getPreviousGambler());
                this.size--;

                this.firstCursor.setGift(true);
                removed.add(this.firstCursor);
            }

            return removed;
        } else {
            return null;
        }
    }

    public void clear() {
        this.firstCursor = null;
        this.secondCursor = null;
        this.size = 0;
    }

    public Gambler clockwise() {
        this.firstCursor = this.firstCursor.getNextGambler();
        return this.firstCursor;
    }

    public Gambler counterClockWise() {
        this.secondCursor = this.secondCursor.getPreviousGambler();
        return this.secondCursor;
    }

    public Gambler getfirstCursor() {
        return this.firstCursor;
    }

    public Gambler getsecondCursor() {
        return this.secondCursor;
    }

    public int getSize() {
        return this.size;
    }

}