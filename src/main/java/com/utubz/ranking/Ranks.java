package com.utubz.ranking;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.utubz.Main;
import com.utubz.ranking.member.MemberRank;
import com.utubz.ranking.mvp.MvpPlusRank;
import com.utubz.ranking.mvp.MvpRank;
import com.utubz.ranking.staff.AdminRank;
import com.utubz.ranking.staff.BuilderRank;
import com.utubz.ranking.staff.ModeratorRank;
import com.utubz.ranking.staff.OwnerRank;
import com.utubz.ranking.subscriber.SubscriberRank;
import com.utubz.ranking.subscriber.SubscriberPlusRank;
import com.utubz.ranking.vip.VipPlusRank;
import com.utubz.ranking.vip.VipRank;

import net.minestom.server.entity.Player;

public class Ranks {
    public static final Rank DEFAULT = new DefaultRank();
    public static final Rank MEMBER = new MemberRank();
    public static final Rank VIP = new VipRank();
    public static final Rank VIP_PLUS = new VipPlusRank();
    public static final Rank MVP = new MvpRank();
    public static final Rank MVP_PLUS = new MvpPlusRank();
    public static final Rank MVP_PLUS_PLUS = new SubscriberRank();
    public static final Rank YOUTUBE = new SubscriberPlusRank();
    public static final Rank BUILDER = new BuilderRank();
    public static final Rank MODERATOR = new ModeratorRank();
    public static final Rank ADMIN = new AdminRank();
    public static final Rank OWNER = new OwnerRank();

    private static Rank[] __cachedAllRanks;

    public static final Rank[] getAllRanks()
    {
        if (__cachedAllRanks == null)
        {
            final Field[] fields = Ranks.class.getFields();
            List<Rank> ranks = new ArrayList<Rank>();
    
            try {
                for (int i = 0; i < fields.length; i++)
                {
                    if (fields[i].canAccess(null) && fields[i].get(null) instanceof Rank rank)
                        ranks.add(rank);
                }
            } catch(IllegalAccessException iae) {
                Main.logger.error("Could not search all ranks, illegal access exception was thrown.");
            }

            __cachedAllRanks = new Rank[ranks.size()];
            __cachedAllRanks = ranks.toArray(__cachedAllRanks);
        }

        return __cachedAllRanks;
    }

    public static final Rank fromId(String id)
    {
        for (int i = 0; i < __cachedAllRanks.length; i++)
        {
            if (__cachedAllRanks[i].getId().matches(id))
                return __cachedAllRanks[i];
        }
        return null;
    }

    public static final Rank fromPlayer(Player player)
    {
        return fromId(player.getPermission("rank").getNBTData().getString("id"));
    }
}
