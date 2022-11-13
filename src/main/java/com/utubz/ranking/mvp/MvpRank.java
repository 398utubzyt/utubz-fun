package com.utubz.ranking.mvp;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class MvpRank extends Rank {
    public MvpRank()
    {
        super("mvp", Text.aqua("MVP"), 4, 
            "rank.member", "rank.vip.plus", "rank.mvp");
    }
}
