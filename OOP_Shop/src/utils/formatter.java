package utils;

public class formatter {
	public static <T> T coalesce(T a, T b) {
	    return a == null ? b : a;
	}
}
