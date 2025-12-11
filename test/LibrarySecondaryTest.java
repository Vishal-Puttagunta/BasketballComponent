
public final class LibrarySecondaryTest {

    private Library createLibrary() {
        return new Library1L();
    }

    @Test
    public void testIsEmptyTrueInitially() {
        Library lib = this.createLibrary();
        assertTrue(lib.isEmpty());
    }

    @Test
    public void testIsEmptyFalseAfterAdd() {
        Library lib = this.createLibrary();
        lib.addTitle("Book", 1);
        assertTrue(!lib.isEmpty());
    }

    @Test
    public void testIsEmptyTrueAfterClear() {
        Library lib = this.createLibrary();
        lib.addTitle("Title", 2);
        lib.clear();
        assertTrue(lib.isEmpty());
    }

    @Test
    public void testToStringContainsTitleCount() {
        Library lib = this.createLibrary();
        lib.addTitle("Test", 5);

        String s = lib.toString();
        assertTrue(s.contains("titleCount"));
        assertTrue(s.contains("1"));
    }
}

