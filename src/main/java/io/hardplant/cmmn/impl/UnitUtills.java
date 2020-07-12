package io.hardplant.cmmn.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitUtills {
    private final static List<String> idolList = Arrays.asList("櫻木真乃", "風野灯織", "八宮めぐる",

            "月岡恋鐘", "幽谷霧子", "白瀬咲耶", "田中摩美々", "三峰結華",

            "小宮果穂", "杜野凛世", "園田智代子", "有栖川夏葉", "西城樹里",

            "大崎甘奈", "大崎甜花", "桑山千雪",

            "芹沢あさひ", "黛冬優子", "和泉愛依",

            "浅倉透", "樋口円香", "福丸小糸", "市川雛菜");

    public static String getUnitByName(String nameJP) {
        final String[] unitName = { "illumi", "antica", "afterschool", "alstromeria", "straylight", "noctchill" };

        int idx = idolList.indexOf(nameJP);

        if (idx < 3) return unitName[0]; // illumi
        if (idx < 8) return unitName[1]; // antica
        if (idx < 13) return unitName[2]; // afterschool
        if (idx < 16) return unitName[3]; // alsme
        if (idx < 19) return unitName[4]; // stray
        if (idx < 23) return unitName[5]; // notchill
        
        return "";
    }
}