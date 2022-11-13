package com.utubz.ranking;

import com.utubz.util.Text;

public class DefaultRank extends Rank {
    public DefaultRank()
    {
        super("default", Text.darkGray("Unranked"), 0);
    }
}
