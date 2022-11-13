package com.utubz.ranking.staff;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class OwnerRank extends Rank {
    public OwnerRank()
    {
        super("owner", Text.yellow("Owner"), 32, "rank.member", "rank.staff.builder", "rank.staff.mod", "rank.staff.admin", "rank.staff.owner");
    }
}
