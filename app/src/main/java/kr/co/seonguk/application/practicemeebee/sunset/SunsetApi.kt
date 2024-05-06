package kr.co.seonguk.application.practicemeebee.sunset


import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class SunsetApi(
    @Element(name = "body")
    val body: Body?,
    @Element(name = "header")
    val header: Header?
)

@Xml(name = "header")
data class Header(
    @PropertyElement(name = "resultCode")
    val resultCode: Int?,
    @PropertyElement(name = "resultMsg")
    val resultMsg: String?
)
@Xml(name = "body")
data class Body(
    @Element(name = "items")
    val items: Items?,

    @PropertyElement(name = "numOfRows")
    val numOfRows: Int?,
    @PropertyElement(name = "pageNo")
    val pageNo: Int?,
    @PropertyElement(name = "totalCount")
    val totalCount: Int?
)
@Xml(name = "items")
data class Items(
    @Element(name = "item")
    val item: List<Item>?
)
@Xml(name = "Item")
data class Item(
    @PropertyElement(name = "locdate")
    val locdate: String?,

    @PropertyElement(name = "location")
    val location: String?,

    @PropertyElement(name = "longitudeNum")
    val longitudeNum: String?,

    @PropertyElement(name = "latitudeNum")
    val latitudeNum: String?,

    @PropertyElement(name = "sunrise")
    val sunrise: String?,

    @PropertyElement(name = "suntransit")
    val suntransit: String?,

    @PropertyElement(name = "sunset")
    val sunset: String?
)

































