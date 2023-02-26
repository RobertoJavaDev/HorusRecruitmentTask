package pl.robertojavadev;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    private Wall wall;

    @Test
    void shouldReturnOptionalEmptyWhenNotFoundBlockByColor() {
        //given
        wall = new Wall();

        //when

        //then
        assertEquals(wall.findBlockByColor("black"), Optional.empty());
    }

    @Test
    void shouldReturnEmptyBlockListWhenNotFoundBlockByMaterial() {
        //given
        wall = new Wall();

        //when

        //then
        assertEquals(wall.findBlocksByMaterial("cotton"), List.of());
    }

    @Test
    void shouldReturnZeroWhenResourceIsEmpty() {
        //given
        wall = new Wall();

        //when

        //then
        assertEquals(wall.count(), 0);
    }
}