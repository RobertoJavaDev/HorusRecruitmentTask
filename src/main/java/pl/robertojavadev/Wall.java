package pl.robertojavadev;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(final String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(final String material) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
