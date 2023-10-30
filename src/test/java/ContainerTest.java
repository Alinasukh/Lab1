import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContainerTest {
    private Container<String> container;

    @Before
    public void setUp() {
        container = new Container<>();
    }

    @Test
    public void testAddAtBeginning() {
        container.AddAtBeginning("A");
        container.AddAtBeginning("B");

        assertEquals("B", container.Get(0));
        assertEquals("A", container.Get(1));
    }

    @Test
    public void testAddAtEnd() {
        container.AddAtEnd("A");
        container.AddAtEnd("B");

        assertEquals("A", container.Get(0));
        assertEquals("B", container.Get(1));
    }

    @Test
    public void testAddAtIndex() {
        container.AddAtEnd("A");
        container.AddAtEnd("C");
        container.AddAtIndex("B", 1);

        assertEquals("A", container.Get(0));
        assertEquals("B", container.Get(1));
        assertEquals("C", container.Get(2));
    }

    @Test
    public void testRemoveAtBeginning() {
        container.AddAtEnd("A");
        container.AddAtEnd("B");

        String removed = container.RemoveAtBeginning();

        assertEquals("A", removed);
        assertEquals("B", container.Get(0));
    }

    @Test
    public void testRemoveAtIndex() {
        container.AddAtEnd("A");
        container.AddAtEnd("B");
        container.AddAtEnd("C");

        String removed = container.RemoveAtIndex(1);

        assertEquals("B", removed);
        assertEquals("A", container.Get(0));
        assertEquals("C", container.Get(1));
    }

    @Test
    public void testRemoveAtEnd() {
        container.AddAtEnd("A");
        container.AddAtEnd("B");

        String removed = container.RemoveAtEnd();

        assertEquals("B", removed);
        assertEquals("A", container.Get(0));
    }

    @Test
    public void testSize() {
        container.AddAtEnd("A");
        container.AddAtEnd("B");

        assertEquals(2, container.GetSize());
    }
}
