import java.util.Iterator;

 /*
 * Simple but somewhat efficient implementation of IDnaStrand. \ This
 * implementation uses StringBuilders to represent genomic/DNA data.
 */

public class StringBuilderStrand implements IDnaStrand {
	
	private StringBuilder myInfo;
	private int myAppends;

	public StringBuilderStrand(){
		this("");
	}
	/**
	 * Create a strand representing s. No error checking is done to see if s
	 * represents valid genomic/DNA data.
	 * 
	 * @param s
	 *            is the source of cgat data for this strand
	 */

	/**
	 * Constructor for this class
	 * Creates a new object
	 * Calls initialize() method
	 * @param s
	 */
	public StringBuilderStrand(String s) {
		initialize(s);
	}

	/**
	 * Initialize this strand so that it represents the value of source. No
	 * error checking is performed.
	 * 
	 * @param source
	 *            is the source of this enzyme
	 */
	@Override 
	public void initialize(String source) {
		myInfo = new StringBuilder(source);
		myAppends = 0;
	}

	/**
	 * 'Get' method
	 * @return number of base-pairs in this strand
	 */
	@Override
	public long size() {
		return myInfo.length();
	}

	/**
	 * Converts to type String
	 * @return myInfo.toString();
	 */
	@Override
	public String toString() {
		return myInfo.toString();
	}

	/**
	 * Simply append a strand of dna data to this strand. No error checking is
	 * done. This method isn't efficient; it doesn't use a StringBuilder or a
	 * StringBuffer.
	 * 
	 * @param dna
	 *            is the String appended to this strand
	 */
	public IDnaStrand append(String dna) {
		myInfo.append(dna);
		myAppends++;
		return this;
	}

	/**
	 * Reverses the DNA strand
	 * @return ss
	 */
	public IDnaStrand reverse() {
		StringBuilder copy = new StringBuilder(myInfo);
		StringBuilderStrand ss = new StringBuilderStrand("replace");
		copy.reverse();
		ss.myInfo = copy;
		return ss;
	}

	/**
	 * 'Get' method that returns the total number of appends made
	 * @return myAppends (instance variable)
	 */
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	/**
	 * Gets the char at the index specified
	 * @param index specifies which character will be returned
	 * @return myInfo.charAt(index)
	 */
	public char charAt(int index) {
		return myInfo.charAt(index);
	}

	/**
	 * Creates a new instance of this object with values from source.
	 * @param source is data from which object constructed
	 * @return new StringBuilderStrand(source)
	 */
	@Override
	public IDnaStrand getInstance(String source) {
		return new StringBuilderStrand(source);
	}
}
