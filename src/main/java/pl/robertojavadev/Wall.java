package pl.robertojavadev;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks = new ArrayList<>();

    public void addBlock(Block block) {
        blocks.add(block);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null || color.trim().equals("")) {
            throw new IllegalArgumentException("The provided value is incorrect");
        }
        return blocks.stream()
                .flatMap(Block::toStream)
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null || material.trim().equals("")) {
            throw new IllegalArgumentException("The provided value is incorrect");
        }
        return blocks.stream()
                .flatMap(Block::toStream)
                .filter(block -> block.getMaterial().equals(material))
                .toList();
    }

    @Override
    public int count() {
        return (int) blocks.stream()
                .flatMap(Block::toStream)
                .count();
    }
}
