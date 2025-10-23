/**
 * Enhanced interface for Library.
 */
public interface Library extends LibraryKernel {

    /**
     * Is the library empty?
     *
     * @ensures isEmpty = (titleCount() == 0)
     * @return true iff empty
     */
    boolean isEmpty();
}
