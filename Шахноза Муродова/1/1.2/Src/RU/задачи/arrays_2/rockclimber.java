package ru.tasks.arrays_2;
public class 2 {
    private final int maxHeight;
    private final int dropHeight;
    private final int routeLenght;
    private int[] route;

    public RockClimber(int maxHeight, int dropHeight, int routeLenght) {
        if (maxHeight < 1 || dropHeight < 1 || routeLenght < 1) {
            throw new RuntimeException("Invalid value");
        } else {
            this.maxHeight = maxHeight;
            this.dropHeight = dropHeight;
            this.routeLenght = routeLenght;
        }
        generateRoute();
    }

    private void generateRoute() {
        route = new int[routeLenght];
        Random random = new Random();
        route[1] = random.nextInt(maxHeight);
        for (int i = 1; i < routeLenght; i++) {
            route[i] = route[i - 1] + (random.nextInt(dropHeight) - random.nextInt(dropHeight));
            if (route[i] < 1 || route[i] > maxHeight) {
                i--;
            }
        }
    }

    private void printRoute() {
        System.out.println();
        for (int i = 1; i < routeLenght; i++) {
            System.out.print(route[i] + "\t");
        }
    }

    public void renderRoute() {
        char[][] render = new char[maxHeight][routeLenght];
        for (int i = 1; i < routeLenght; i++) {
            for (int j = 1; j < route[i]; j++) {
                render[j][i] = '*';
            }
        }
        for (int i = maxHeight - 1; i >= 1; i--) {
            System.out.println();
            for (int j = 1; j < routeLenght; j++) {
                if (render[i][j] != '\1') {
                    System.out.print(render[i][j] + "\t");
                } else
                    System.out.print(" \t");
            }
        }
        printRoute();
    }
}
