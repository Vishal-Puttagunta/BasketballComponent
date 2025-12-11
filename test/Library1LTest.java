public import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public final class Library1LTest {

    private Library createLibrary() {
        return new Library1L();
    }

    @Test
    public void testAddTitleNewTitle() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 3);

        assertEquals(1, lib.titleCount());
        assertEquals(3, lib.copiesOf("Harry Potter"));
    }

    @Test
    public void testAddTitleExistingIncreasesCopies() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 2);
        lib.addTitle("Harry Potter", 1);

        assertEquals(1, lib.titleCount());
        assertEquals(3, lib.copiesOf("Harry Potter"));
    }

    @Test
    public void testBorrowSuccessDecrementCopies() {
        Library lib = this.createLibrary();
        lib.addTitle("Percy Jackson", 2);

        boolean borrowed = lib.borrow("Percy Jackson");
        assertTrue(borrowed);
        assertEquals(1, lib.copiesOf("Percy Jackson"));
    }

    @Test
    public void testBorrowLastCopyRemovesTitle() {
        Library lib = this.createLibrary();
        lib.addTitle("Percy Jackson", 1);

        boolean borrowed = lib.borrow("Percy Jackson");
        assertTrue(borrowed);
        assertFalse(lib.isAvailable("Percy Jackson"));
        assertEquals(0, lib.copiesOf("Percy Jackson"));
        assertEquals(0, lib.titleCount());
    }

    @Test
    public void testBorrowNonexistentReturnsFalse() {
        Library lib = this.createLibrary();
        assertFalse(lib.borrow("Lord of the Rings"));
    }


    @Test
    public void testGiveBackExistingTitle() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 2);

        boolean returned = lib.giveBack("Harry Potter");
        assertTrue(returned);
        assertEquals(3, lib.copiesOf("Harry Potter"));
    }

    @Test
    public void testGiveBackNonexistentTitleReturnsFalse() {
        Library lib = this.createLibrary();
        assertFalse(lib.giveBack("Narnia"));
    }--------------------------------------------------------

    @Test
    public void testIsAvailableTrue() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 1);
        assertTrue(lib.isAvailable("Harry Potter"));
    }

    @Test
    public void testIsAvailableFalseZeroCopies() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 1);
        lib.borrow("Harry Potter");
        assertFalse(lib.isAvailable("Harry Potter"));
    }

    @Test
    public void testIsAvailableFalseNonexistent() {
        Library lib = this.createLibrary();
        assertFalse(lib.isAvailable("Unknown"));
    }

    @Test
    public void testClear() {
        Library lib = this.createLibrary();
        lib.addTitle("Harry Potter", 3);
        lib.clear();

        assertEquals(0, lib.titleCount());
        assertTrue(lib.isEmpty());
    }

    @Test
    public void testNewInstanceIsEmptyLibrary() {
        Library lib = this.createLibrary();
        Library newLib = lib.newInstance();

        assertTrue(newLib.isEmpty());
        assertEquals(0, newLib.titleCount());
    }

    @Test
    public void testTransferFromMovesData() {
        Library lib1 = this.createLibrary();
        Library lib2 = this.createLibrary();

        lib1.addTitle("Book A", 2);

        lib2.transferFrom(lib1);

        assertEquals(0, lib1.titleCount());
        assertEquals(1, lib2.titleCount());
        assertEquals(2, lib2.copiesOf("Book A"));
    }
}

