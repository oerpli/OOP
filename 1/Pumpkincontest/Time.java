package Pumpkincontest;

abstract class Time {
	private static int Day = 0;

	public static int day() {
		return Day;
	}

	public static void nextDay() {
		Day++;
	}
}
