import java.util.*;
import javax.swing.*;
import BreezySwing.*;

public class change {
	private Queue<Integer> m = new LinkedList<>();
	private Queue<Integer> k = new LinkedList<>();
	
	public String encrypt (String msg, String key) {
		setup(msg, key);
		for(int i = 0; i < m.size(); i++) {
			int currKey = k.remove();
			int newChar = currKey + m.remove();

			if (newChar > 127) {
				newChar = newChar - 127;
			}
			m.add(newChar);
			k.add(currKey);
		}		
		String encryptedMsg = "";
		while (m.size() != 0) {
			encryptedMsg += (char) ((int) m.remove());
		}
		return encryptedMsg;
	}
	public String decrypt (String msg, String key) {
		setup(msg, key);
		for(int i = 0; i < m.size(); i++) {
			int currKey = k.remove();
			int newChar = m.remove() - currKey;
			if (newChar < 0) {
				newChar = newChar + 127;
			}
			m.add(newChar);
			k.add(currKey);
		}
		String decryptedMsg = "";
		while (m.size() != 0) {
			decryptedMsg += (char) ((int) m.remove());
		}
		return decryptedMsg;
	}
	public void setup (String msg, String key) {
		m = new LinkedList<>();
		k = new LinkedList<>();
		for(int i = 0; i < msg.length(); i++) {
			int asciiCurrent = (int) msg.charAt(i);
			m.add(asciiCurrent);
		}
		
		String s[] = key.split(" ");
		for(int i = 0; i < s.length; i++) {
			k.add((int) (Integer.valueOf(s[i])));
		}
	}
}