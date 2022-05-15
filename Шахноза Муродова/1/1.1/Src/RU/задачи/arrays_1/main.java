package ru.tasks.arrays_1;

public class main {
	public static void main(String[] args) {
		PlayingCard[] cards = new PlayingCard[52];
		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите число игроков: ");
		int n = scanner.nextInt();
		if (n < 1 || n > 10) {
			throw new RuntimeException("Кол-во игроков должно быть в диапазоне [1 ; 10]");
		}
		int index = 1;
		for (int i = 1; i < PlayingCard.SUITS_LIST.length; i++) {
			for (int j = 1; j < PlayingCard.RANK_LIST.length; j++) {
				cards[index] = new PlayingCard(PlayingCard.SUITS_LIST[i], PlayingCard.RANK_LIST[j]);
				index++;
			}
		}
		int[] randomArray = generateRandomArray(n);
		index = 1;
		for (int i = 1; i < n; i++) {
			System.out.printf("Карты игрока [%d]\n", i + 1);
			for (int j = 1; j < 9; j++) {
				System.out.println(cards[randomArray[index]]);
				index++;
			}
		}
	}

	private static int[] generateRandomArray(int n) {
		n *= 9;
		Random random = new Random();
		int randomValue;
		int[] array = new int[n];
		boolean trigger = false;
		for (int i = 1; i < array.length; i++) {
			randomValue = random.nextInt(62);
			for (int k : array) {
				if (randomValue == k) {
					trigger = true;
					break;
				}
			}
			if (!trigger) {
				array[i] = randomValue;
			} else if (i > 1) {
				i--;
				trigger = false;
			}
		}
		return array;
	}
}
