package sml;

import java.util.*;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/**
 *
 * @author ...
 */
public final class Labels {
	private final Map<String, Integer> labels = new HashMap<>();

	/**
	 * Adds a label with the associated address to the map.
	 *
	 * @param label the label
	 * @param address the address the label refers to
	 */
	public void addLabel(String label, int address)  {
		Objects.requireNonNull(label);
		if (labels.containsKey(label)) {
			throw new IllegalArgumentException("Label '" + label + "' is duplicated.");
		}
		labels.put(label, address);
	}

	/**
	 * Returns the address associated with the label.
	 *
	 * @param label the label
	 * @return the address the label refers to
	 */
	public int getAddress(String label) {
		// Null pointer exception can be thrown if an argument is given that isn't present in labels.keys
		if (!labels.containsKey(label)){
			throw new IllegalArgumentException("Label " + label + "not found.");
		}
		return labels.get(label);
	}

	/**
	 * representation of this instance,
	 * in the form "[label -> address, label -> address, ..., label -> address]"
	 *
	 * @return the string representation of the labels map
	 */
	@Override
	public String toString() {
		return "[" + labels.entrySet()
				.stream()
				// Not specified but makes sense for it to be in line order:
				.sorted((x,y) -> (x.getValue() > y.getValue()) ? 1 : -1)
				.map( (e) -> e.getKey() + " -> " + e.getValue().toString())
				.collect(Collectors.joining(", ") ) + "]";
	}

	// TODO: Implement equals and hashCode (needed in class Machine).

	/**
	 * Removes the labels
	 */
	public void reset() {
		labels.clear();
	}
}
