package apis.lol.champion

import RegionApiClientFactory
import feign.RequestLine
import values.Region

private const val PATH = "/lol/platform/v3"

class ChampionApi(
    apiKey: String,
    region: Region
) {
    private val apiClient = RegionApiClientFactory
        .create(apiKey, region)
        .createApiClient(ChampionApiClient::class.java)

    fun getChampionRotations(): ChampionResponse = apiClient.getChampionRotations()

    private interface ChampionApiClient {
        @RequestLine("GET /lol/platform/v3/champion-rotations")
        fun getChampionRotations() : ChampionResponse
    }
}