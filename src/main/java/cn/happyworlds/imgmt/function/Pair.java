package cn.happyworlds.imgmt.function;

import java.util.*;

/*******************************************************************************
 * Program Name : Pair.java
 * Purpose      : Provides a data structure for a key-value pair.
 *
 * Related Database Table
 * 1.
 *
 * Object used  :
 *
 * Used By	:
 *
 * History
 * =======
 * Ver	 Owner	   Create Date	  Remarks
 * ---	 -----	   ------------	 --------
 * 0.1	Lily YU     2003-03-10	  create
 *
*******************************************************************************/
public class Pair implements java.io.Serializable,
                             java.lang.Cloneable {

    private Object key = null, value = null;
    private transient final boolean[] MUTEX = new boolean[0];

    /**
     * Constructs a key, value pair.
     *
     * @param    key    key of this pair
     * @param    value  value of this pair
     */
    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the value object of this pair.
     *
     * @return    value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Returns the key object of this pair.
     *
     * @return    key
     */
    public Object getKey() {
        return key;
    }

    /**
     * Sets key and value for this pair.
     *
     * @param    key    key of this pair
     * @param    value  value of this pair
     */
    public void setPair(Object key, Object value) {
        synchronized (MUTEX) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Sets key and value for this pair.
     *
     * @param    pair    Pair to be copied into this object
     */
    public void setPair(Pair pair) {
        synchronized (MUTEX) {
            this.key   = pair.getKey();
            this.value = pair.getValue();
        }
    }

    /**
     * Performs a shallow copy to this object. The key and value objects of
     * this pair are not cloned.
     *
     * @return    cloned pair
     */
    public Object clone() throws CloneNotSupportedException {
        Pair newObject = (Pair)super.clone();

        synchronized (MUTEX) {
            newObject.setPair(key, value);
        }

        return newObject;
    }

    /**
     * Returns a textual representation of this object. Calls
     * <code>toString</code> methods of both key and value objects
     * to build the text string.
     *
     * @return    textual representation of a pair object
     */
    public String toString() {
        return this.getClass().getName() + "(" + key.toString() +
                ", " + value.toString() + ")";
    }

    /**
     * Returns true if this Pair is equal to the specified Pair.
     * Two Pair objects are considered same if and only if all corresponding
     * field values within the Pair objects are same.
     * @param  that   The Pair object to compare to.
     * @return  True if this Pair is equal to that one, false otherwise.
     */
	public boolean equals(Pair that) {
        if(this.key.equals(that.getKey()) && this.value.equals(that.getValue()))
            return true;
        else
            return false;
    }

	/**
     * Tests if the passed-in object is equal to this Pair object.
     * @param   that   The objec to compair.
     * @return  True if and only the passed-in object is an instance of
     *          Pair and all fields are same, false otherwise.
     */
	public boolean equals(Object that) {
        if(that instanceof Pair)
            return equals((Pair)that);
        else
            return false;
    }

	/**
     *<code>getPairsIds</code> is a convenience method that parses ArrayList of pairs
     *that contains ids and values.
     *@param collection of pairs
     *@return collection of ids
     *
     */
    public static ArrayList getPairsIds(ArrayList _pairs)
    {
		Pair p[] = new Pair[_pairs.size()];
		System.arraycopy(_pairs.toArray(), 0, p, 0, _pairs.size());
        return getPairsIds(p);
    }

	/**
     *<code>getPairsIds</code> is a convenience method that parses ArrayList of pairs
     *that contains ids and values.
     *@param array of pairs
     *@return collection of ids
     *
     */
    public static ArrayList getPairsIds(Pair[] _pairs)
    {
        ArrayList ids = new ArrayList();

        for(int i = 0; i < _pairs.length; i++)
        {
            Pair pair = (Pair)_pairs[i];
            ids.add(pair.getKey().toString());
        }
        return ids;
    }

	 /**
     *<code>getPairsIds</code> is a convenience method that parses ArrayList of pairs
     *that contains ids and values.
     *@param collection of pairs
     *@return collection of values
     *
     */
    public static ArrayList getPairsValues(ArrayList _pairs)
    {
        Pair p[] = new Pair[_pairs.size()];
		System.arraycopy(_pairs.toArray(), 0, p, 0, _pairs.size());
        return getPairsValues(p);
    }

     /**
     *<code>getPairsIds</code> is a convenience method that parses
     * an array of pairs that contains ids and values.
     *@param arrPairs  an array of Pair objects.
     *@return   a collection of values.
     *
     */
    public static ArrayList getPairsValues(Pair[] arrPairs)
    {
		ArrayList values = new ArrayList();

        if(arrPairs == null || arrPairs.length == 0)
            return values;


        for(int i = 0; i < arrPairs.length; i++)
        {
            Pair pair = arrPairs[i];
            values.add(pair.getValue().toString());
        }
        return values;
    }

}

