import components.standard.Standard;

/**
 * Kernel interface for a Library. Keeps track of book titles and how many
 * copies there are.
 */
public interface LibraryKernel extends Standard<Library> {

    /**
     * Adds more copies of a title.
     *
     * @param title
     *            the book title (must not be empty)
     * @param copiesToAdd
     *            how many copies to add (> 0)
     * @ensures increases the copy count for that title, or adds it if new
     */
    void addTitle(String title, int copiesToAdd);

    /**
     * Tries to borrow one copy of a title.
     *
     * @param title
     *            the book title
     * @updates this
     * @ensures if there was at least one copy, one is borrowed and returns
     *          true; otherwise nothing changes and returns false
     */
    boolean borrow(String title);

    /**
     * Returns a borrowed copy.
     *
     * @param title
     *            the book title
     * @updates this
     * @ensures if the title exists, one copy is added and returns true,
     *          otherwise nothing changes and returns false
     */
    boolean giveBack(String title);

    /**
     * Checks if a title has at least one copy available.
     *
     * @param title
     *            the book title
     * @ensures returns true if there is at least one copy, false otherwise
     */
    boolean isAvailable(String title);

    /**
     * Counts how many different titles the library tracks.
     *
     * @ensures returns the number of titles stored
     */
    int titleCount();

    /**
     * Shows how many copies a title has.
     *
     * @param title
     *            the book title
     * @ensures returns how many copies there are, or 0 if it’s not tracked
     */
    int copiesOf(String title);
}
