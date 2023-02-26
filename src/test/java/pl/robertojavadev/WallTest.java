package pl.robertojavadev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final BlockImpl BLOCK_1 = new BlockImpl("black", "cotton");
    private static final BlockImpl BLOCK_2 = new BlockImpl("white", "silk");
    private static final BlockImpl BLOCK_3 = new BlockImpl("orange", "wool");

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
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertEquals(wall.count(), 1);
    }

    @Test
    void shouldReturnBlockWhenFindBlockByColor() {
        //given
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);

        //when
        BlockImpl block = BLOCK_3;
        wall.addBlock(block);

        //then
        assertEquals(wall.findBlockByColor("orange").get(), block);
    }
}