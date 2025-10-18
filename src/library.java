import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * proof-of-concept
 */
public final class library {

    private final Map<String, Integer> copies = new Map1L<>();

    public void addTitle(String title, int copiesToAdd) {
        if (title == null || title.trim().length() == 0) {
            throw new IllegalArgumentException("title must be non-empty");
        }
        if (copiesToAdd <= 0) {
            throw new IllegalArgumentException("copiesToAdd must be > 0");
        }

        int current;
        if (this.copies.hasKey(title)) {
            current = this.copies.value(title);
            this.copies.replaceValue(title, current + copiesToAdd);
        } else {
            this.copies.add(title, copiesToAdd);
        }
    }

    public boolean borrow(String title) {
        if (!this.copies.hasKey(title)) {
            return false;
        }
        int n = this.copies.value(title);
        if (n > 0) {
            this.copies.replaceValue(title, n - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean giveBack(String title) {
        if (!this.copies.hasKey(title)) {
            return false;
        }
        int n = this.copies.value(title);
        this.copies.replaceValue(title, n + 1);
        return true;
    }

    public boolean isAvailable(String title) {
        return this.copies.hasKey(title) && this.copies.value(title) > 0;
    }

    public int titleCount() {
        return this.copies.size();
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        library lib = new library();

        lib.addTitle("Harry Potter", 2);
        lib.addTitle("Percy Jackson", 1);

        out.println(lib.titleCount());

        out.println(lib.isAvailable("Harry Potter"));

        lib.borrow("Harry Potter");
        lib.borrow("Harry Potter");

        out.println(lib.isAvailable("Harry Potter"));

        lib.giveBack("Harry Potter");

        out.println(lib.isAvailable("Harry Potter"));

        out.close();
    }
}
