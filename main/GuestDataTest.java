package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuestDataTest {

    @Test
    public void testAddGuest() {
        GuestData guestData = new GuestData();
        Guest guest = new Guest(1, "Joe Lane", "joe@fake.com", "111-222-4444", "123 FakeStreet");
        guestData.addGuest(guest);
        Guest retrievedGuest = guestData.getGuestID(1);
        assertNotNull(retrievedGuest);
        assertEquals("Joe Lane", retrievedGuest.getName());
    }

    @Test
    public void testGetGuestById() {
        GuestData guestData = new GuestData();
        Guest guest = guestData.getGuestID(1);
        assertNotNull(guest);
        assertEquals(1, guest.getGuestID());
    }

    @Test
    public void testUpdateGuest() {
        GuestData guestData = new GuestData();
        Guest guest = guestData.getGuestID(1);
        guest.setPhone("333-444-5555");
        guestData.updateGuest(guest);
        Guest updatedGuest = guestData.getGuestID(1);
        assertEquals("333-444-5555", updatedGuest.getPhone());
    }

    @Test
    public void testDeleteGuest() {
        GuestData guestData = new GuestData();
        guestData.delGuest(1);
        Guest guest = guestData.getGuestID(1);
        assertNull(guest);
    }
}
