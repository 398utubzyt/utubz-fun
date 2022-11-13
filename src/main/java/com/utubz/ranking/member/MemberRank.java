package com.utubz.ranking.member;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class MemberRank extends Rank {
    public MemberRank()
    {
        super("member", Text.gray("Member"), 1, "rank.member");
    }
}
