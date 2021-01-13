package com.nybsyscaraudiostream.helper;

import com.nybsyscaraudiostream.R;
import com.nybsyscaraudiostream.model.Channel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ChannelList {
    private static final String CHANNEL_STYLE_AMBIENT = "Ambient";
    private static final String CHANNEL_STYLE_BASS = "Bass";
    private static final String CHANNEL_STYLE_CHILLOUT = "Chillout";
    private static final String CHANNEL_STYLE_CLASSIC = "Classic";
    private static final String CHANNEL_STYLE_DANCE = "Dance";
    private static final String CHANNEL_STYLE_DEEP = "Deep";
    private static final String CHANNEL_STYLE_EDM = "EDM";
    private static final String CHANNEL_STYLE_HARD = "Hard";
    private static final String CHANNEL_STYLE_HOUSE = "House";
    private static final String CHANNEL_STYLE_LOUNGE = "Lounge";
    private static final String CHANNEL_STYLE_SYNTH = "Synth";
    private static final String CHANNEL_STYLE_TECHNO = "Techno";
    private static final String CHANNEL_STYLE_TRANCE = "Trance";
    private static final String CHANNEL_STYLE_VOCAL = "Vocal";

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

    public static List<Channel> getChannelsForStyle(String category)
    {
        List<Channel> channelList = new ArrayList<>();
        //TODO chillout and classic channel data should be update
        switch (category)
        {
            case CHANNEL_STYLE_AMBIENT:
                channelList.addAll(ambientChannels());
                break;
            case CHANNEL_STYLE_BASS:
                channelList.addAll(ambientChannels());
                break;
            case CHANNEL_STYLE_CHILLOUT:
                channelList.addAll(chilloutChannels());
                break;
            case CHANNEL_STYLE_CLASSIC:
                channelList.addAll(classicChannels());
                break;
            case CHANNEL_STYLE_EDM:
                channelList.addAll(edmChannels());
                break;
            case CHANNEL_STYLE_HARD:
                channelList.addAll(hardChannels());
                break;
            case CHANNEL_STYLE_HOUSE:
                channelList.addAll(houseChannels());
                break;
            case CHANNEL_STYLE_DANCE:
                channelList.addAll(danceChannels());
                break;
            case CHANNEL_STYLE_DEEP:
                channelList.addAll(deepChannels());
                break;
            case CHANNEL_STYLE_LOUNGE:
                channelList.addAll(loungeChannels());
                break;
            case CHANNEL_STYLE_SYNTH:
                channelList.addAll(synthChannels());
                break;
            case CHANNEL_STYLE_TECHNO:
                channelList.addAll(technoChannels());
                break;
            case CHANNEL_STYLE_TRANCE:
                channelList.addAll(tranceChannels());
                break;
            case CHANNEL_STYLE_VOCAL:
                channelList.addAll(vocalChannels());
                break;
            default:classicChannels();
            break;

        }
        return channelList;
    }

    private static List<Channel> vocalChannels() {
        return ambientChannels();
    }

    private static List<Channel> tranceChannels() {
        return bassChannels();
    }

    private static List<Channel> technoChannels() {
        return chilloutChannels();
    }

    private static List<Channel> ambientChannels() {
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

    private static List<Channel> bassChannels() {
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

    private static List<Channel> chilloutChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("chillhop", "Chillhop", R.drawable.chillhop));
        list.add(new Channel("chillntropicalhouse", "Chill & Tropical House", R.drawable.chilltropicalhouse));
        list.add(new Channel("deephouse", "Deep House", R.drawable.deephouse));
        list.add(new Channel("deepnudisco", "Deep Nu-Disco", R.drawable.deepnudisco));
        list.add(new Channel("downtempolounge", "Downtempo Lounge", R.drawable.downtempolounge));
        list.add(new Channel("dubtechno", "Dub Techno", R.drawable.dubtechno));
        return list;
    }
    private static List<Channel> classicChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        list.add(new Channel("classiceurodance", "Classic Eurodance", R.drawable.classiceurodance));
        list.add(new Channel("classiceurodisco", "Classic Eurodisco", R.drawable.classiceurodisco));
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        return list;
    }

    private static List<Channel> edmChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("ambient", "Ambient", R.drawable.ambient));
        list.add(new Channel("chillout", "Chillout", R.drawable.chillout));
        list.add(new Channel("chilloutdreams", "Chillout Dreams", R.drawable.chilloutdreams));
        list.add(new Channel("chillstep", "Chillstep", R.drawable.chillstep));
        list.add(new Channel("chillhop", "Chillhop", R.drawable.chillhop));
        list.add(new Channel("chillntropicalhouse", "Chill & Tropical House", R.drawable.chilltropicalhouse));
        list.add(new Channel("deephouse", "Deep House", R.drawable.deephouse));
        list.add(new Channel("deepnudisco", "Deep Nu-Disco", R.drawable.deepnudisco));
        list.add(new Channel("downtempolounge", "Downtempo Lounge", R.drawable.downtempolounge));
        list.add(new Channel("dubtechno", "Dub Techno", R.drawable.dubtechno));
        list.add(new Channel("electronicpioneers", "Electronic Pioneers", R.drawable.electronicpioneers));
        list.add(new Channel("futuregarage", "Future Garage", R.drawable.futuregarage));
        list.add(new Channel("indiebeats", "Indie Beats", R.drawable.indiebeats));
        list.add(new Channel("lofihiphop", "Lofi Hip-Hop", R.drawable.lofihophop));
        list.add(new Channel("lounge", "Lounge", R.drawable.lounge));
        list.add(new Channel("melodicprogressive", "Melodic Progressive", R.drawable.melodicprogressive));
        list.add(new Channel("spacemusic", "Space Dreams", R.drawable.spacedreams));
        list.add(new Channel("psybient", "Psybient", R.drawable.psybient));
        list.add(new Channel("psychill", "Psychill", R.drawable.psychill));
        list.add(new Channel("vocalchillout", "Vocal Chillout", R.drawable.vocalchillout));
        return list;
    }

    private static List<Channel> danceChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        list.add(new Channel("bassnjackinhouse", "Bass & Jackin' House", R.drawable.bassnjackinhouse));
        list.add(new Channel("bigroomhouse", "Big Room House", R.drawable.bigroomhouse));
        list.add(new Channel("chillntropicalhouse", "Chill & Tropical House", R.drawable.chilltropicalhouse));
        list.add(new Channel("classiceurodance", "Classic Eurodance", R.drawable.classiceurodance));
        list.add(new Channel("classiceurodisco", "Classic Eurodisco", R.drawable.classiceurodisco));
        list.add(new Channel("classicvocaltrance", "Classic Vocal Trance", R.drawable.classicvocaltrance));
        list.add(new Channel("club", "Club Sounds", R.drawable.clubsounds));
        list.add(new Channel("discohouse", "Disco House", R.drawable.discohouse));
        list.add(new Channel("djmixes", "DJ Mixes", R.drawable.djmixes));
        list.add(new Channel("edm", "EDM Hits", R.drawable.edmhits));
        list.add(new Channel("electrohouse", "Electro House", R.drawable.electrohouse));
        list.add(new Channel("electropop", "Electropop", R.drawable.electropop));
        list.add(new Channel("epictrance", "Epic Trance", R.drawable.epictrance));
        list.add(new Channel("eurodance", "Eurodance", R.drawable.eurodance));
        list.add(new Channel("handsup", "Hands Up", R.drawable.handsup));
        list.add(new Channel("harddance", "Hard Dance", R.drawable.harddance));
        list.add(new Channel("indiedance", "Indie Dance", R.drawable.indiedance));
        list.add(new Channel("mainstage", "Mainstage", R.drawable.mainstage));
        list.add(new Channel("nightcore", "Nightcore", R.drawable.nightcore));
        list.add(new Channel("nudisco", "Nu Disco", R.drawable.nudisco));
        list.add(new Channel("russianclubhits", "Russian Club Hits", R.drawable.russianclubhits));
        list.add(new Channel("trance", "Trance", R.drawable.trance));
        list.add(new Channel("vocaltrance", "Vocal Trance", R.drawable.vocaltrance));
        return list;
    }

    private static List<Channel> deepChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("deephouse", "Deep House", R.drawable.deephouse));
        list.add(new Channel("deepnudisco", "Deep Nu-Disco", R.drawable.deepnudisco));
        list.add(new Channel("deeptech", "Deep Tech", R.drawable.deeptech));
        list.add(new Channel("dub", "Dub", R.drawable.dub));
        list.add(new Channel("dubtechno", "Dub Techno", R.drawable.dubtechno));
        return list;
    }

    private static List<Channel> hardChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("bigroomhouse", "Big Room House", R.drawable.bigroomhouse));
        list.add(new Channel("clubdubstep", "Club Dubstep", R.drawable.clubdubstep));
        list.add(new Channel("darkdnb", "Dark DNB", R.drawable.darkdnb));
        list.add(new Channel("darkpsytrance", "Dark Psy Trance", R.drawable.darkpsytrance));
        list.add(new Channel("dubstep", "Dubstep", R.drawable.dubstep));
        list.add(new Channel("edm", "EDM Hits", R.drawable.edmhits));
        list.add(new Channel("gabber", "Gabber", R.drawable.gabber));
        list.add(new Channel("goapsy", "Goa-Psy Trance", R.drawable.goapsytrance));
        list.add(new Channel("hardcore", "Hardcore", R.drawable.hardcore));
        list.add(new Channel("harddance", "Hard Dance", R.drawable.harddance));
        list.add(new Channel("hardstyle", "Hardstyle", R.drawable.hardstyle));
        list.add(new Channel("jungle", "Jungle", R.drawable.jungle));
        list.add(new Channel("nightcore", "Nightcore", R.drawable.nightcore));
        list.add(new Channel("hardtechno", "Hard Techno", R.drawable.hardtechno));
        list.add(new Channel("oldschoolacid", "Oldschool Acid", R.drawable.oldschoolacid));
        list.add(new Channel("oldschoolrave", "Oldschool Rave", R.drawable.oldschoolrave));
        list.add(new Channel("techno", "Techno", R.drawable.techno));
        list.add(new Channel("trap", "Trap", R.drawable.trap));
        return list;
    }

    private static List<Channel> houseChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("bassline", "Bassline", R.drawable.bassline));
        list.add(new Channel("bassnjackinhouse", "Bass & Jackin' House", R.drawable.bassnjackinhouse));
        list.add(new Channel("bigroomhouse", "Big Room House", R.drawable.bigroomhouse));
        list.add(new Channel("00sclubhits", "00s Club Hits", R.drawable.clubhits));
        list.add(new Channel("chillntropicalhouse", "Chill & Tropical House", R.drawable.chilltropicalhouse));
        list.add(new Channel("deephouse", "Deep House", R.drawable.deephouse));
        list.add(new Channel("deepnudisco", "Deep Nu-Disco", R.drawable.deepnudisco));
        list.add(new Channel("deeptech", "Deep Tech", R.drawable.deeptech));
        list.add(new Channel("detroithousentechno", "Detroit House & Techno", R.drawable.detroit_house_techno));
        list.add(new Channel("discohouse", "Disco House", R.drawable.discohouse));
        list.add(new Channel("djmixes", "DJ Mixes", R.drawable.djmixes));
        list.add(new Channel("downtempolounge", "Downtempo Lounge", R.drawable.downtempolounge));
        list.add(new Channel("edm", "EDM Hits", R.drawable.edmhits));
        list.add(new Channel("electrohouse", "Electro House", R.drawable.electrohouse));
        list.add(new Channel("electropop", "Electropop", R.drawable.electropop));
        list.add(new Channel("electroswing", "Electroswing", R.drawable.electroswing));
        list.add(new Channel("funkyhouse", "Funky House", R.drawable.funkyhouse));
        list.add(new Channel("house", "House", R.drawable.house));
        list.add(new Channel("jazzhouse", "Jazz House", R.drawable.jazzhouse));
        list.add(new Channel("latinhouse", "Latin House", R.drawable.latinhouse));
        list.add(new Channel("mainstage", "Mainstage", R.drawable.mainstage));
        list.add(new Channel("melodicprogressive", "Melodic Progressive", R.drawable.melodicprogressive));
        list.add(new Channel("nudisco", "Nu Disco", R.drawable.nudisco));
        list.add(new Channel("oldschoolacid", "Oldschool Acid", R.drawable.oldschoolacid));
        list.add(new Channel("oldschoolhouse", "Oldschool House", R.drawable.oldschoolhouse));
        list.add(new Channel("progressive", "Progressive", R.drawable.progressive));
        list.add(new Channel("soulfulhouse", "Soulful House", R.drawable.soulfulhouse));
        list.add(new Channel("techhouse", "Tech House", R.drawable.tech_house));
        list.add(new Channel("tribalhouse", "Tribal House", R.drawable.tribalhouse));
        list.add(new Channel("vocalhouse", "Vocal House", R.drawable.vocalhouse));
        return list;
    }

    private static List<Channel> loungeChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("chillhop", "Chillhop", R.drawable.chillhop));
        list.add(new Channel("chillntropicalhouse", "Chill & Tropical House", R.drawable.chilltropicalhouse));
        list.add(new Channel("chillout", "Chillout", R.drawable.chillout));
        list.add(new Channel("chilloutdreams", "Chillout Dreams", R.drawable.chilloutdreams));
        list.add(new Channel("chillstep", "Chillstep", R.drawable.chillstep));
        list.add(new Channel("deephouse", "Deep House", R.drawable.deephouse));
        list.add(new Channel("deepnudisco", "Deep Nu-Disco", R.drawable.deepnudisco));
        list.add(new Channel("downtempolounge", "Downtempo Lounge", R.drawable.downtempolounge));
        list.add(new Channel("funkyhouse", "Funky House", R.drawable.funkyhouse));
        list.add(new Channel("futurebass", "Future Bass", R.drawable.futurebass));
        list.add(new Channel("futuregarage", "Future Garage", R.drawable.futuregarage));
        list.add(new Channel("indiedance", "Indie Dance", R.drawable.indiedance));
        list.add(new Channel("jazzhouse", "Jazz House", R.drawable.jazzhouse));
        list.add(new Channel("liquiddnb", "Liquid DNB", R.drawable.liquiddnb));
        list.add(new Channel("liquiddubstep", "Liquid Dubstep", R.drawable.liquiddubstep));
        list.add(new Channel("liquidtrap", "Liquid Trap", R.drawable.liquidtrap));
        list.add(new Channel("lofihiphop", "Lofi Hip-Hop", R.drawable.lofihophop));
        list.add(new Channel("lounge", "Lounge", R.drawable.lounge));
        list.add(new Channel("melodicprogressive", "Melodic Progressive", R.drawable.melodicprogressive));
        list.add(new Channel("nudisco", "Nu Disco", R.drawable.nudisco));
        list.add(new Channel("soulfulhouse", "Soulful House", R.drawable.soulfulhouse));
        list.add(new Channel("vocallounge", "Vocal Lounge", R.drawable.vocallounge));
        return list;
    }

    private static List<Channel> synthChannels() {
        List<Channel> list = new ArrayList<>();
        list.add(new Channel("electronicpioneers", "Electronic Pioneers", R.drawable.electronicpioneers));
        list.add(new Channel("futuresynthpop", "Future Synthpop", R.drawable.futuresynthwave));
        list.add(new Channel("indiedance", "Indie Dance", R.drawable.indiedance));
        list.add(new Channel("synthwave", "Synthwave", R.drawable.synthwave));
        return list;
    }
}
