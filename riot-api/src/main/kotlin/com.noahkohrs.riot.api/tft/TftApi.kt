package com.noahkohrs.riot.api.tft

import com.noahkohrs.riot.api.values.GlobalRegion
import com.noahkohrs.riot.api.values.Platform

public class TftApi(
    apiKey: String,
    platform: Platform,
    globalRegion: GlobalRegion,
){
    @JvmField
    public val league: LeagueApi = LeagueApi(apiKey, platform)
}
