package com.dekamaru.bangserver.game.data;

import com.dekamaru.bangserver.game.models.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroData {
    public static final List<Hero> list = new ArrayList<>(Arrays.asList(
            new Hero(Hero.Type.KILLER, 4),
            new Hero(Hero.Type.JANET, 4),
            new Hero(Hero.Type.BLACK_JACK, 4),
            new Hero(Hero.Type.SAM, 4),
            new Hero(Hero.Type.PEDRO, 4),
            new Hero(Hero.Type.KIT, 4),
            new Hero(Hero.Type.PAUL, 3),
            new Hero(Hero.Type.GRINGO, 3),
            new Hero(Hero.Type.JESSY, 4),
            new Hero(Hero.Type.ROSE, 4),
            new Hero(Hero.Type.JORDONNAS, 4),
            new Hero(Hero.Type.WILLY, 4),
            new Hero(Hero.Type.SUZIE, 4),
            new Hero(Hero.Type.SID, 4),
            new Hero(Hero.Type.BART, 4),
            new Hero(Hero.Type.DUKE, 4)
    ));
}
