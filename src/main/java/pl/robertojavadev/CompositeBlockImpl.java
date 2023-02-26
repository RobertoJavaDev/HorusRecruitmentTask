package pl.robertojavadev;

import java.util.Collections;
import java.util.List;

public class CompositeBlockImpl implements CompositeBlock{

    private String color;
    private String material;
    private List<Block> blocks;

    CompositeBlockImpl(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }
}
