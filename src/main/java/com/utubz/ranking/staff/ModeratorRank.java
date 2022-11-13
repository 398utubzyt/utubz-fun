package com.utubz.ranking.staff;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class ModeratorRank extends Rank {
    public ModeratorRank()
    {
        super("moderator", Text.darkPurple("Moderator"), 28, "rank.member", "rank.staff.mod");
    }
}
