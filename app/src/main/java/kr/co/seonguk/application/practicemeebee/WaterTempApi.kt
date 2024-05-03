package kr.co.seonguk.application.practicemeebee

data class WaterTempApi(
    val response: WaterResponse?
)

data class WaterItems(
    val item: List<WaterItem?>?
)

data class WaterResponse(
    val body: WaterBody?,
    val header: WaterHeader?
)

data class WaterBody(
    val dataType: String?,
    val items: WaterItems?,
    val numOfRows: Int?,
    val pageNo: Int?,
    val totalCount: Int?
)

data class WaterHeader(
    val resultCode: String?,
    val resultMsg: String?
)

data class WaterItem(
    val beachNum: String?,
    val tm: String?,
    val tw: String?
)