package skill;

//import org.junit.Test;

import org.junit.jupiter.api.Test;

/**
 * Main
 */
public class Main {

	public static void main(String[] args) {

	}

	@Test
	public void testChar() {
		char a = 'A', b = (char) ((int) a + 1);
		System.out.println(a + b);
		System.out.println(a + "," + b);
	}
	@Test
	public void testInt(){
		int a=254;
		byte b=(byte)a;
		System.out.println(b);
	}
}