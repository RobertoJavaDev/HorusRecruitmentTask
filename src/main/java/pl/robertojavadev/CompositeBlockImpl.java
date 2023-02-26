package pl.robertojavadev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(
                super.toStream(),
                blocks.stream().flatMap(Block::toStream)
        );
    }
}
