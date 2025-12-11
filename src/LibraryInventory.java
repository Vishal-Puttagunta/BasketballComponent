
public final class LibraryInventory {


    private LibraryInventory() {

    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        out.println("Library Inventory Demo");

        Library lib = new Library1L();

        String[] titles = { "Harry Potter", "Percy Jackson", "Dune", "The Hobbit", "1984" };
        lib.addTitle("Harry Potter", 5);
        lib.addTitle("Percy Jackson", 1);
        lib.addTitle("Dune", 0 + 2); // 2 copies
        lib.addTitle("The Hobbit", 1);
        lib.addTitle("1984", 4);
        out.println("Initial inventory loaded.");
        out.println("Distinct titles tracked by library: " + lib.titleCount());
        out.println();

        int totalCopies = 0;
        for (String t : titles) {
            int count = lib.copiesOf(t);
            totalCopies += count;
        }

        out.println("Total physical copies across all titles: " + totalCopies);
        out.println();

        final int lowStockThreshold = 1;

        out.println("Low-stock titles (<= " + lowStockThreshold + " copy):");
        boolean anyLowStock = false;
        for (String t : titles) {
            int count = lib.copiesOf(t);
            if (count <= lowStockThreshold) {
                out.println(" - " + t + " (copies: " + count + ")");
                anyLowStock = true;
            }
        }
        if (!anyLowStock) {
            out.println(" (none)");
        }
        out.println();

        out.println("Simulating a day of borrowing...");
        lib.borrow("Harry Potter");
        lib.borrow("Harry Potter");
        lib.borrow("The Hobbit");
        lib.borrow("Percy Jackson");

        out.println("After borrowing:");
        totalCopies = 0;
        for (String t : titles) {
            int count = lib.copiesOf(t);
            totalCopies += count;
            out.println(" - " + t + " (copies: " + count + ", available: "
                    + lib.isAvailable(t) + ")");
        }
        out.println("Total physical copies now: " + totalCopies);
        out.println();
        out.println("Updated low-stock titles (<= " + lowStockThreshold + " copy):");
        anyLowStock = false;
        for (String t : titles) {
            int count = lib.copiesOf(t);
            if (count <= lowStockThreshold) {
                out.println(" - " + t + " (copies: " + count + ")");
                anyLowStock = true;
            }
        }
        if (!anyLowStock) {
            out.println(" (none)");
        }

        out.close();
    }
}
