package app

import islamicTimes.MathFunction
import islamicTimes.WShalat

fun main() {
    val ws = WShalat()
    val mf = MathFunction()

//input
    val tglM: Byte = 17
    val blnM: Byte = 1
    val thnM: Long = 2023
    val gLon: Double = (107 + 31 / 60.0 + 12 / 3600.0)
    val gLat: Double = -(6 + 58 / 60.0 + 10 / 3600.0)
    val elev: Double = 0.0
    val tmZn: Double = 7.0
    val ihty: Int = 2

    println("Zuhur      : ${mf.DHHMS(ws.IhtiyathShalat(ws.zuhur(tglM, blnM, thnM, gLon, tmZn), ihty), "HH:MM", 0)}")
    println(
        "Ashar      : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.ashar(tglM, blnM, thnM, gLon, gLat, tmZn), ihty),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Magrib     : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.maghrib(tglM, blnM, thnM, gLon, gLat, elev, tmZn), ihty),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Isya       : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.isya(tglM, blnM, thnM, gLon, gLat, tmZn), ihty),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Akhir Isya : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.nisfuLail(tglM, blnM, thnM, gLon, gLat, elev, tmZn), ihty),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Subuh      : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.subuh(tglM, blnM, thnM, gLon, gLat, tmZn), ihty),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Akhir Subuh: ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.syuruk(tglM, blnM, thnM, gLon, gLat, elev, tmZn), -2),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Dhuha      : ${
            mf.DHHMS(
                ws.IhtiyathShalat(ws.duha(tglM, blnM, thnM, gLon, gLat, elev, tmZn), -2),
                "HH:MM",
                0
            )
        }"
    )

}