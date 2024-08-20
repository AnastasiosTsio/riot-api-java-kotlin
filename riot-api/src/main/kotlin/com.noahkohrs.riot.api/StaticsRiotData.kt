package com.noahkohrs.riot.api

import feign.RequestLine

internal object StaticsRiotData {
    private val staticApi =
        StaticRiotDragoonFactory
            .create()
    val queues = staticApi.getQueues().associateBy { it.queueId }

    val maps = staticApi.getMaps().associateBy { it.mapId }

    internal interface StaticDragoonApi {
        @RequestLine("GET /docs/lol/queues.json")
        fun getQueues(): List<Queue>

        @RequestLine("GET /docs/lol/maps.json")
        fun getMaps(): List<Map>
    }
}

public data class Queue(
    val queueId: Int,
    val map: String,
    val description: String?,
    val notes: String?,
) {
    public companion object {
        public fun fromId(queueId: Int): Queue {
            return StaticsRiotData.queues[queueId] ?: error("Queue $queueId not found")
        }
    }
}

public data class Map(
    val mapId: Int,
    val mapName: String,
    val notes: String,
)
