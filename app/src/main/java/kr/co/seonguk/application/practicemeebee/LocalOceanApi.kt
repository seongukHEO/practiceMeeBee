package kr.co.seonguk.application.practicemeebee

data class LocalOceanApi(
    val getOceansBeachInfo: GetOceansBeachInfo?
)

data class GetOceansBeachInfo(
    val header: LocalHeader?,
    val item: List<LocalItem>?,
    val numOfRows: Int?,
    val pageNo: Int?,
    val rows: Any?,
    val totalCount: Int?
)

data class LocalHeader(
    val code: String?,
    val message: String?
)

data class LocalItem(
    val beach_img: Any?,
    val beach_knd: String?,
    val beach_len: Int?,
    val beach_wid: Int?,
    val gugun_nm: String?,
    val lat: String?,
    val link_addr: String?,
    val link_nm: String?,
    val link_tel: Any?,
    val lon: String?,
    val num: Int?,
    val sido_nm: String?,
    val sta_nm: String?
)