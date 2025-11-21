
/**
 * Simple implementation of {@code Library} using a Map from titles to counts.
 */
public class Library1L extends LibrarySecondary {

    /**
     * Map of titles to number of available copies.
     */
    private Map<String, Integer> titles;

    /**
     * Helper to create a fresh empty map.
     */
    private void createNewRep() {
        this.titles = new Map1L<>();
    }

    /**
     * Default constructor: starts as an empty library.
     */
    public Library1L() {
        super();
        this.createNewRep();
    }

    // ---------------- Kernel methods ----------------

    @Override
    public final void addTitle(String title, int copiesToAdd) {
        assert title != null : "title is null";
        assert title.length() > 0 : "title is empty";
        assert copiesToAdd > 0 : "copiesToAdd must be > 0";

        if (this.titles.hasKey(title)) {
            int current = this.titles.value(title);
            this.titles.replaceValue(title, current + copiesToAdd);
        } else {
            this.titles.add(title, copiesToAdd);
        }
    }

    @Override
    public final boolean borrow(String title) {
        assert title != null : "title is null";
        assert title.length() > 0 : "title is empty";

        if (this.titles.hasKey(title)) {
            int current = this.titles.value(title);
            if (current > 0) {
                if (current == 1) {
                    // Last copy: remove the title completely
                    this.titles.remove(title);
                } else {
                    this.titles.replaceValue(title, current - 1);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean giveBack(String title) {
        assert title != null : "title is null";
        assert title.length() > 0 : "title is empty";

        if (this.titles.hasKey(title)) {
            int current = this.titles.value(title);
            this.titles.replaceValue(title, current + 1);
            return true;
        }
        // If the title is not tracked, do nothing and return false.
        return false;
    }

    @Override
    public final boolean isAvailable(String title) {
        assert title != null : "title is null";
        assert title.length() > 0 : "title is empty";

        return this.titles.hasKey(title) && this.titles.value(title) > 0;
    }

    @Override
    public final int titleCount() {
        return this.titles.size();
    }

    @Override
    public final int copiesOf(String title) {
        assert title != null : "title is null";
        assert title.length() > 0 : "title is empty";

        if (this.titles.hasKey(title)) {
            return this.titles.value(title);
        } else {
            return 0;
        }
    }

    // ---------------- Standard methods ----------------

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final Library newInstance() {
        return new Library1L();
    }

    @Override
    public final void transferFrom(Library source) {
        assert source != null : "source is null";
        assert source != this : "source is this";
        assert source instanceof Library1L : "source is not a Library1L";

        Library1L src = (Library1L) source;
        this.titles = src.titles;
        src.createNewRep();
    }
}
