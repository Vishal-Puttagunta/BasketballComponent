
/**
 * Kernel interface for a Library. Keeps track of book titles and how many
 * copies there are.
 */
public interface LibraryKernel extends Standard<Library> {

    /**
     * Adds more copies of a title.
     *
     * @param title
     *            the book title
     * @param copiesToAdd
     *            how many copies to add
     * @ensures increases the copy count for that title or adds it if new
     */
    void addTitle(String title, int copiesToAdd);

    /**
     * Tries to borrow one copy of a title.
     *
     * @param title
     *            the book title
     * @updates this
     */
    boolean borrow(String title);

    /**
     * Returns a borrowed copy.
     *
     * @param title
     *            the book title
     * @updates this
     * @return true if title exists and false otherwise
     */
    boolean giveBack(String title);

    /**
     * Checks if a title has at least one copy available.
     *
     * @param title
     *            the book title
     * @return true if there is at least one copy and false otherwise
     */
    boolean isAvailable(String title);

    /**
     * Counts how many different titles the library tracks.
     *
     * @return the number of titles stored
     */
    int titleCount();

    /**
     * Shows how many copies a title has.
     *
     * @param title
     *            the book title
     * @return how many copies there are
     */
    int copiesOf(String title);
}
