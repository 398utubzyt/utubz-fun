package com.utubz.ranking.subscriber;

import com.utubz.ranking.Rank;
import com.utubz.util.Text;

public class SubscriberPlusRank extends Rank {
    public SubscriberPlusRank()
    {
        super("youtube", Text.red("Youtube"), 7, 
            "rank.member", "rank.vip.plus", "rank.mvp.plus", "rank.subscriber.plus");
    }
}
