
package fi.tuni.prog3.json;

/**
 * An abstract super class for different types of JSON nodes.
 */
public abstract class Node {
    /**
     * The only constructor. Will be invoked, usually implicitly, by subclass constructors.
     */
    protected Node() {
    }

    /**
     * Checks whether this node represents a JSON object.
     *
     * @return true if this node represents a JSON object, otherwise false.
     */
    public boolean isObject() {
        // Implementation for checking if it's an object
        return false;
    }

    /**
     * Checks whether this node represents a JSON array.
     *
     * @return true if this node represents a JSON array, otherwise false.
     */
    public boolean isArray() {
        // Implementation for checking if it's an array
        return false;
    }

    /**
     * Checks whether this node represents a JSON value.
     *
     * @return true if this node represents a JSON value, otherwise false.
     */
    public boolean isValue() {
        // Implementation for checking if it's a value
        return false;
    }

    /**
     * Prints the JSON data to the screen.
     */
    public void printJson() {
        // Implementation for printing JSON data
    }
}