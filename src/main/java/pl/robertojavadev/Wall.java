package pl.robertojavadev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks = new ArrayList<>();

    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return Collections.emptyList();
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
