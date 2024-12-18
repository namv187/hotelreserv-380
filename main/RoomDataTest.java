package main;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class RoomDataTest {
    private RoomData roomData;
    private Room testRoom;

    @BeforeEach
    public void init() {
        roomData = new RoomData();
        testRoom = new Room(300, "300", Room.RoomType.SINGLE, 99.99, true);
    }

    

    @Test
    public void testAddRoom() {
        roomData.addRoom(testRoom);
        Room retrievedRoom = roomData.getRoomID(testRoom.getRoomID());
        assertNotNull(retrievedRoom, "Room should be added to the database.");
        assertEquals(testRoom.getRoomNum(), retrievedRoom.getRoomNum(), "Room number should match.");
        assertEquals(testRoom.getRoomType(), retrievedRoom.getRoomType(), "Room type should match.");
    }

    @Test
    public void testUpdateRoom() {
        roomData.addRoom(testRoom);
        testRoom.setPrice(129.99);
        roomData.updateRoom(testRoom);

        Room updatedRoom = roomData.getRoomID(testRoom.getRoomID());
        assertEquals(129.99, updatedRoom.getPrice(), "Room price should be updated.");
    }

    @Test
    public void testDeleteRoom() {
        roomData.addRoom(testRoom);
        roomData.delRoom(testRoom.getRoomID());

        Room deletedRoom = roomData.getRoomID(testRoom.getRoomID());
        assertNull(deletedRoom, "Room should be deleted from the database.");
    }
}