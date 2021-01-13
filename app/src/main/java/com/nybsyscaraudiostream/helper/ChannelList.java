package com.nybsyscaraudiostream.helper;

import com.nybsyscaraudiostream.R;
import com.nybsyscaraudiostream.model.Channel;

import java.util.ArrayList;
import java.util.List;

public class ChannelList {
    private final String CHANNEL_STYLE_AMBIENT = "Ambient";
    private final String CHANNEL_STYLE_BASS = "Bass";
    private final String CHANNEL_STYLE_CHILLOUT = "Chillout";
    private final String CHANNEL_STYLE_CLASSIC = "Classic";
    private final String CHANNEL_STYLE_DANCE = "Dance";
    private final String CHANNEL_STYLE_DEEP = "Deep";
    private final String CHANNEL_STYLE_EDM = "EDM";
    private final String CHANNEL_STYLE_HARD = "Hard";
    private final String CHANNEL_STYLE_HOUSE = "House";
    private final String CHANNEL_STYLE_LOUNGE = "Lounge";
    private final String CHANNEL_STYLE_SYNTH = "Synth";
    private final String CHANNEL_STYLE_TECHNO = "Techno";
    private final String CHANNEL_STYLE_TRANCE = "Trance";
    private final String CHANNEL_STYLE_VOCAL = "Vocal";

    List<String> getStyles() {
        List<String> styles = new ArrayList<>();
        styles.add(CHANNEL_STYLE_AMBIENT);
        styles.add(CHANNEL_STYLE_BASS);
        styles.add(CHANNEL_STYLE_CHILLOUT);
        styles.add(CHANNEL_STYLE_CLASSIC);
        styles.add(CHANNEL_STYLE_DANCE);
        styles.add(CHANNEL_STYLE_DEEP);
        styles.add(CHANNEL_STYLE_EDM);
        styles.add(CHANNEL_STYLE_HARD);
        styles.add(CHANNEL_STYLE_HOUSE);
        styles.add(CHANNEL_STYLE_LOUNGE);
        styles.add(CHANNEL_STYLE_SYNTH);
        styles.add(CHANNEL_STYLE_TECHNO);
        styles.add(CHANNEL_STYLE_TRANCE);
        styles.add(CHANNEL_STYLE_VOCAL);
        return styles;
    }

    private List<Channel> ambientChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("ambient", "Ambient", R.drawable.ambient));
        list.add(new Channel("chillout", "Chillout", R.drawable.chillout));
        list.add(new Channel("chilloutdreams", "Chillout Dreams", R.drawable.chilloutdreams));
        list.add(new Channel("electronicpioneers", "Electronic Pioneers", R.drawable.electronicpioneers));
        list.add(new Channel("futuregarage", "Future Garage", R.drawable.futuregarage));
        list.add(new Channel("spacemusic", "Space Dreams", R.drawable.spacedreams));
        list.add(new Channel("psybient", "Psybient", R.drawable.psybient));
        list.add(new Channel("psychill", "Psychill", R.drawable.psychill));
        return list;
    }

    private List<Channel> bassChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("atmosphericbreaks", "Atmospheric Breaks", R.drawable.atmposphericbreaks));
        list.add(new Channel("bassline", "Bassline", R.drawable.bassline));
        list.add(new Channel("bassnjackinhouse", "Bass & Jackin' House", R.drawable.bassnjackinhouse));
        list.add(new Channel("bigbeat", "Big Beat", R.drawable.bigbeat));
        list.add(new Channel("breaks", "Breaks", R.drawable.breaks));
        list.add(new Channel("chillstep", "Chillstep", R.drawable.chillstep));
        list.add(new Channel("clubdubstep", "Club Dubstep", R.drawable.clubdubstep));
        list.add(new Channel("darkdnb", "Dark DNB", R.drawable.darkdnb));
        list.add(new Channel("drumandbass", "Drum and Bass", R.drawable.drumandbass));
        list.add(new Channel("drumstep", "Drumstep", R.drawable.drumstep));
        list.add(new Channel("dub", "Dub", R.drawable.dub));
        list.add(new Channel("dubstep", "Dubstep", R.drawable.dubstep));
        list.add(new Channel("edm", "EDM Hits", R.drawable.edmhits));
        list.add(new Channel("futurebass", "Future Bass", R.drawable.futurebass));
        list.add(new Channel("futuregarage", "Future Garage", R.drawable.futuregarage));
        list.add(new Channel("glitchhop", "Glitch Hop", R.drawable.glitchhop));
        list.add(new Channel("jungle", "Jungle", R.drawable.jungle));
        list.add(new Channel("liquiddnb", "Liquid DNB", R.drawable.liquiddnb));
        list.add(new Channel("liquiddubstep", "Liquid Dubstep", R.drawable.liquiddubstep));
        list.add(new Channel("liquidtrap", "Liquid Trap", R.drawable.liquidtrap));
        list.add(new Channel("mainstage", "Mainstage", R.drawable.mainstage));
        list.add(new Channel("trap", "Trap", R.drawable.trap));
        return list;
    }

    private List<Channel> chilloutChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }

    private List<Channel> edmChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }

    private List<Channel> danceChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }

    private List<Channel> deepChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }

    private List<Channel> hardChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }
    private List<Channel> houseChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }
    private List<Channel> loungeChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }
    private List<Channel> synthChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel());
        return list;
    }
}
