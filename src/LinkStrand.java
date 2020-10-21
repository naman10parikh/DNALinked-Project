/**
 * @author Naman Parikh
 * @author Sharan Sokhi
 */

public class LinkStrand implements IDnaStrand {

    private class Node {
        String info;
        Node next;

        /**
         * Constructor that creates a new node
         * Instance variable 'info' is set to 's'
         * Instance variable 'next' is set to 'n'
         * @param s is a String
         * @param n is the node it points toward
         */
        public Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast, myCurrent;
    private long mySize;
    private int myAppends, myIndex, myLocalIndex;

    /**
     * Constructor that creates a LinkStrand based on the parameter s
     * @param s is a String
     */
    public LinkStrand(String s) {
        initialize(s);
    }

    /**
     * Constructor that creates an empty LinkStrand object
     */
    public LinkStrand() {
        this("");
    }

    /**
     * Initializes instance variables for LinkStrand object
     * myFirst references the first node in the LinkedList
     * myLast references the last node in the LinkedList
     * mySize stores the total number of characters in the LinkedList (not the total number of nodes)
     * myAppends stores the total number of times the method 'append()' is called
     * @param source is a String that gives information for the LinkStrand
     */
    @Override
    public void initialize(String source) {
        myFirst = new Node(source, null);
        myLast = myFirst;
        mySize = source.length();
        myAppends = 0;
        myCurrent = myFirst;
        myIndex = 0;
        myLocalIndex = 0;
    }

    /**
     * Uses the data from the parameter 'source' to create a new LinkStrand object
     * @param source is a String that gives information for the LinkStrand
     * @return a LinkStrand object based on 'source'
     */
    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    /**
     * A 'get' method that gets the size of the LinkStrand object (i.e. total number of characters)
     * @return mySize (integer)
     */
    @Override
    public long size() {
        return mySize;
    }

    /**
     * This is a mutator method.
     * It creates a new node at the end of the current LinkStrand object
     * @param dna to be added
     * @return this
     */
    @Override
    public IDnaStrand append(String dna) {
        // Create a new node
        myLast.next = new Node (dna,null);

        // Point myLast to newly created node
        myLast = myLast.next;

        // Add length of new dna strand to mySize
        mySize = mySize + dna.length();

        // Increase number of appends by one (because the method 'append()' has been called
        myAppends++;

        // Return the modified IDnaStrand object
        return this;
    }

    /**
     * Reverses this current LinkStrand object and returns a new LinkStrand object
     * @return reverseLinkStrand
     */
    @Override
    public IDnaStrand reverse() {
        StringBuilder reverseString = new StringBuilder();
        Node list = this.myFirst;

        while(list != null){
            StringBuilder inner = new StringBuilder(list.info);
            inner.reverse();
            reverseString.insert(0, inner.toString());
            list = list.next;
        }

        LinkStrand reverseLinkStrand = new LinkStrand(reverseString.toString());
        return reverseLinkStrand;
    }

    /**
     * 'Get' method for instance variable myAppends that stores the total number of appends made
     * @return myAppends (integer instance variable)
     */
    @Override
    public int getAppendCount() {
        return myAppends;
    }

    /**
     * Gives the character at a given index
     * myIndex is the overall index (counter)
     * myLocalIndex is the index (i.e. counter) within the node
     * myCurrent references the node in which the character that we are looking for is
     * @param index is the index to be searched
     * @return myCurrent.info.charAt(myLocalIndex) (a LinkStrand object)
     */
    @Override
    public char charAt(int index) {
        // For invalid indices, throw an exception
        if(index < 0 | index >= mySize){
            throw new IndexOutOfBoundsException("Out of Bounds");
        }

        if(index < myIndex){
            myCurrent = myFirst;
            myIndex = 0;
            myLocalIndex = 0;
        }

        while(myIndex != index){
            myLocalIndex++;
            myIndex++;
            if(myLocalIndex >= myCurrent.info.length()){
                myLocalIndex = 0;
                myCurrent = myCurrent.next;
            }
        }

        // Return the char at the position myLocalIndex in the node that 'myCurrent' points to.
        return myCurrent.info.charAt(myLocalIndex);
    }

    /**
     * Returns a string representation of the LinkStrand object
     * @return stringRepresentation.toString
     */
    @Override
    public String toString() {
        Node list = myFirst;
        StringBuilder stringRepresentation = new StringBuilder();

        while (list != null) {
            stringRepresentation.append(list.info);
            list = list.next;
        }

        return stringRepresentation.toString();
    }
}