package org.wff.render.world;

import org.wff.render.utils.Emoji;
import org.wff.render.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class GlobalWorldLocalImpl implements GlobalWorldInterface {
    @Override
    public List<Emoji> getWorldMap(Pair coords) {
        List<Emoji> res = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            res.add(Emoji.randomEmoji());
        }
        return res;
    }
}
