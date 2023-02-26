package pl.robertojavadev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final BlockImpl BLOCK = new BlockImpl("black", "cotton");

    private Wall wall;

    @BeforeEach
    void SetUp() {

        wall = new Wall();
    }

    @Test
    void shouldReturnOptionalEmptyWhenNotFoundBlockByColor() {
        //given

        //when

        //then
        assertEquals(wall.findBlockByColor("black"), Optional.empty());
    }

    @Test
    void shouldReturnEmptyBlockListWhenNotFoundBlockByMaterial() {
        //given

        //when

        //then
        assertEquals(wall.findBlocksByMaterial("cotton"), List.of());
    }

    @Test
    void shouldReturnZeroWhenResourceIsEmpty() {
        //given

        //when

        //then
        assertEquals(wall.count(), 0);
    }

    @Test
    void shouldReturnNumberOfBlocksWhenBlockAdded() {
        //given
        wall.addBlock(BLOCK);

        //when

        //then
        assertEquals(wall.count(), 1);
    }
}