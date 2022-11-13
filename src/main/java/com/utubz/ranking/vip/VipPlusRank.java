package com.utubz.ranking.vip;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class VipPlusRank extends Rank {
    public VipPlusRank()
    {
        super("vipplus", Text.green("VIP+"), 3, "rank.member", "rank.vip.plus");
    }
}
