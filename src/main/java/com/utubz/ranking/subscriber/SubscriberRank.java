package com.utubz.ranking.subscriber;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class SubscriberRank extends Rank {
    public SubscriberRank()
    {
        super("subscriber", Text.gold("MVP++"), 6, 
            "rank.member", "rank.vip.plus", "rank.mvp.plus", "rank.subscriber");
    }
}
