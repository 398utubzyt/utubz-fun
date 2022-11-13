package com.utubz.ranking.mvp;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class MvpPlusRank extends Rank {
    public MvpPlusRank()
    {
        super("mvp", Text.aqua("MVP+"), 5, 
            "rank.member", "rank.vip.plus", "rank.mvp.plus");
    }
}
