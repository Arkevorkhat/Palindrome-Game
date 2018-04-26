package data;

import communications.CommLink;
import communications.CommLink.listable;

public class Word implements listable<Word>{
	public static int lastID;
	private int ID;
	private String content;
	private boolean isPalindrome;
	private int iLength;
	public Word(String iContent, Boolean iIsPalindrome) {
		content = iContent;
		isPalindrome = iIsPalindrome;
		iLength = iContent.length();
		ID = ++lastID;
	}
	public String getContent() {
		return this.content;
	}
	public boolean getIsPalindrome() {
		return this.isPalindrome;
	}
	public int length() {
		return this.iLength;
	}
	@Override
	public void addToSet() throws IllegalAccessException {
		if (CommLink.words.add(this)) {
			
		}
		else throw new IllegalAccessException();
	}
	@Override
	public Word getFromSet(long ID) throws IllegalArgumentException {
		for (Word i : CommLink.words) {
			if( i.ID==ID) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}
}
