package pl.robertojavadev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private static final BlockImpl BLOCK_1 = new BlockImpl("black", "cotton");
    private static final BlockImpl BLOCK_2 = new BlockImpl("white", "silk");
    private static final BlockImpl BLOCK_3 = new BlockImpl("orange", "cotton");
    private static final BlockImpl BLOCK_4 = new BlockImpl("red", "silk");
    private static final CompositeBlockImpl COMPOSITE_BLOCK_1 =
            new CompositeBlockImpl("white", "cotton");
    private static final CompositeBlockImpl COMPOSITE_BLOCK_2 =
            new CompositeBlockImpl("black", "wool");
    private static final CompositeBlockImpl COMPOSITE_BLOCK_3 =
            new CompositeBlockImpl("orange", "wool");


    private Wall wall;

    @BeforeEach
    void SetUp() {

        wall = new Wall();
    }

    @Test
    void shouldReturnOptionalEmptyWhenNotFoundBlockByColor() {
        //given
        wall.addBlock(BLOCK_2);

        //when
        Optional<Block> result = wall.findBlockByColor("black");

        //then
        assertEquals(result, Optional.empty());
    }

    @Test
    void shouldReturnEmptyBlockListWhenNotFoundBlockByMaterial() {
        //given
        wall.addBlock(BLOCK_2);

        //when
        List<Block> result = wall.findBlocksByMaterial("cotton");

        //then
        assertEquals(result, List.of());
    }

    @Test
    void shouldReturnZeroWhenResourceIsEmpty() {
        //given

        //when
        int result = wall.count();

        //then
        assertEquals(result, 0);
    }

    @Test
    void shouldReturnNumberOfBlocksWhenBlockAdded() {
        //given
        wall.addBlock(BLOCK_1);

        //when
        int result = wall.count();

        //then
        assertEquals(result, 1);
    }

    @Test
    void shouldReturnBlockWhenFindBlockByColor() {
        //given
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);
        BlockImpl block = BLOCK_3;
        wall.addBlock(block);

        //when
        Block result = wall.findBlockByColor("orange").get();

        //then
        assertEquals(result, block);
    }

    @Test
    void shouldReturnListOfBlocksWhenFindBlocksByMaterial() {
        //given
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);
        wall.addBlock(BLOCK_3);
        wall.addBlock(BLOCK_4);

        //when
        List<Block> result = wall.findBlocksByMaterial("silk");

        //then
        assertEquals(result.size(), 2);
    }

    @Test
    void shouldReturnCompositeBlockWhenFindByColor() {
        //given
        wall.addBlock(COMPOSITE_BLOCK_1);
        wall.addBlock(COMPOSITE_BLOCK_2);
        CompositeBlock compositeBlock = COMPOSITE_BLOCK_3;
        wall.addBlock(compositeBlock);

        //when
        Block result = wall.findBlockByColor("orange").get();

        //then
        assertEquals(result, compositeBlock);
    }

    @Test
    void shouldReturnCompositeBlockWhenFindByMaterial() {
        //given
        wall.addBlock(COMPOSITE_BLOCK_1);
        wall.addBlock(COMPOSITE_BLOCK_2);
        wall.addBlock(COMPOSITE_BLOCK_3);

        //when
        List<Block> result = wall.findBlocksByMaterial("wool");

        //then
        assertEquals(result.size(), 2);
    }

    @Test
    void shouldReturnNestedBlockWhenFindByColor() {
        //given
        CompositeBlockImpl compositeBlock = COMPOSITE_BLOCK_1;
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);
        wall.addBlock(compositeBlock);
        compositeBlock.addBlock(BLOCK_3);

        //when
        Block result = wall.findBlockByColor("orange").get();

        //then
        assertEquals(result, BLOCK_3);
    }

    @Test
    void shouldReturnNestedBlockWhenFindByMaterial() {
        //given
        CompositeBlockImpl compositeBlock = COMPOSITE_BLOCK_1;
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);
        wall.addBlock(compositeBlock);
        compositeBlock.addBlock(BLOCK_3);

        //when
        List<Block> result = wall.findBlocksByMaterial("cotton");

        //then
        assertEquals(result.size(), 3);
    }

    @Test
    void shouldReturnProperlySizeWhenBlocksAreNested() {
        //given
        CompositeBlockImpl compositeBlock = COMPOSITE_BLOCK_1;
        wall.addBlock(BLOCK_1);
        wall.addBlock(BLOCK_2);
        wall.addBlock(compositeBlock);
        compositeBlock.addBlock(BLOCK_3);

        //when
        int result = wall.count();

        //then
        assertEquals(result, 4);
    }

    @Test
    void shouldThrowAnExceptionWhenColorIsNull() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(null));
    }

    @Test
    void shouldThrowAnExceptionWhenColorIsEmpty() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(""));
    }

    @Test
    void shouldThrowAnExceptionWhenColorHasWhiteSpaces() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor("    "));
    }

    @Test
    void shouldThrowAnExceptionWhenMaterialIsNull() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(null));
    }

    @Test
    void shouldThrowAnExceptionWhenMaterialIsEmpty() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(""));
    }

    @Test
    void shouldThrowAnExceptionWhenMaterialHasWhiteSpaces() {
        //given
        wall.addBlock(BLOCK_1);

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial("    "));
    }
}