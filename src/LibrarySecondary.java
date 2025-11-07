/**
 * Layered implementations of secondary methods for {@code Library}.
 */
public abstract class LibrarySecondary implements Library {

    /**
     * Constructs a {@code LibrarySecondary}.
     */
    public LibrarySecondary() {

    }

    /**
     * Reports whether this library has no titles.
     *
     * @return true if this library is empty
     */
    @Override
    public final boolean isEmpty() {
        return this.titleCount() == 0;
    }

    /**
     * Returns a brief description of this library.
     *
     * @return a string representation of this
     */
    @Override
    public String toString() {
        return "Library[titleCount=" + this.titleCount() + "]";
    }
}
