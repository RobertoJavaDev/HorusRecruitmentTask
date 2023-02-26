package pl.robertojavadev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeBlockImpl extends BlockImpl implements CompositeBlock{

    private List<Block> blocks = new ArrayList<>();

    CompositeBlockImpl(String color, String material) {
        super(color, material);
    }

    public void addBlock(Block block){
        blocks.add(block);
    }

    @Override
    public List<Block> getBlocks() {
        return Collections.unmodifiableList(blocks);
    }
}
