package org.wff.render.world;

import org.wff.render.utils.Emoji;
import org.wff.render.utils.Pair;

import java.util.List;

public interface GlobalWorldInterface {
    List<Emoji> getWorldMap(Pair coords);
}
