package com.utubz.ranking.staff;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class BuilderRank extends Rank {
    public BuilderRank()
    {
        super("builder", Text.blue("Builder"), 16, "rank.member", "rank.staff.builder");
    }
}
