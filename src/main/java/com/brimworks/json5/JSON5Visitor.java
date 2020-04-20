package com.brimworks.json5;

/**
 * Called by JSON5Ragel when tokens are found within the source.
 */
interface JSON5Visitor {
    /**
     * Indicates a null value was found.
     */
    default void visitNull(int line, long offset) {}
    /**
     * Indicates a boolean value was found.
     */
    default void visit(boolean val, int line, long offset) {}
    /**
     * Indicates a string value was found.
     */
    default void visit(String val, int line, long offset) {}
    /**
     * Indicates a numeric value was found, this number is
     * always in "smallest" form, so the number "125" fits
     * within a Byte and therefore will be returned as such.
     */
    default void visit(Number val, int line, long offset) {}
    /**
     * Indicates a "}" was found.
     */
    default void endObject(int line, long offset) {}
    /**
     * Indicates a "{" was found.
     */
    default void startObject(int line, long offset) {}
    /**
     * Indicates a "]" was found.
     */
    default void endArray(int line, long offset) {}
    /**
     * Indicates a "[" was found.
     */
    default void startArray(int line, long offset) {}
    /**
     * Indicates a ":" was found.
     */
    default void endObjectKey(int line, long offset) {}
    /**
     * Indicates a "," was found.
     */
    default void append(int line, long offset) {}
    /**
     * Indicates an unexpected character found in the input.
     */
    default void unexpectedByte(byte ch, int line, long offset) {}
}