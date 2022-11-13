package com.utubz.ranking.vip;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class VipRank extends Rank {
    public VipRank()
    {
        super("vip", Text.green("VIP"), 2, "rank.member", "rank.vip");
    }
}
