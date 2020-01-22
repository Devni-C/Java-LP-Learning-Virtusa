public enum Weight {
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    TEN (10),
    TWENTY (20);

    /*ONE = 1,
    TWO = 2,
    THREE = 3,
    FOUR = 4,
    TEN = 10,
    TWENTY = 20;*/


    private int weight = 0;

    Weight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
}
