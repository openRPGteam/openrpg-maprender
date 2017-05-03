package org.wff.render.world;

import com.google.inject.Inject;
import org.wff.render.utils.Pair;

public class GlobalWorldLocalImpl implements GlobalWorldInterface {
    private byte world[][] = new byte[10][10];
    private Pair hero;

    @Inject
    public GlobalWorldLocalImpl() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                this.world[i][j] = 55;
            }
        }

    }

    @Override
    public byte[][] getWorldMap(Pair coords) {
        this.world[coords.getX() - 1][coords.getY() - 1] = 23;
        return this.world;
    }
}
