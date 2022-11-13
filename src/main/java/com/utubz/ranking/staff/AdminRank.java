package com.utubz.ranking.staff;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class AdminRank extends Rank {
    public AdminRank()
    {
        super("admin", Text.purple("Admin"), 32, "rank.member", "rank.staff.builder", "rank.staff.mod", "rank.staff.admin");
    }
}
