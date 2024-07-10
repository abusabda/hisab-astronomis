package app

import islamicTimes.*

fun main() {
    val mf = MathFunction()
    val aq = AKiblat()
    val sn = SunDatas()
    val mo = MoonOtherFunc()
    val jd = JulianDay()
    val dt = DynamicalTime()

//input
    val tglM: Byte = 17
    val blnM: Byte = 1
    val thnM: Long = 2023
    val gLon: Double = (107 + 36 / 60.0 + 0 / 3600.0)
    val gLat: Double = -(7 + 5 / 60.0 + 0 / 3600.0)
    val JamD: Double = (4 + 29 / 60.0 + 15 / 3600.0)
    val tmZn: Double = 7.0
    val sdp: Byte = 2

    val JD: Double = jd.KMJD(tglM, blnM, thnM, JamD, tmZn)
    val dltT: Double = dt.DeltaT(JD)

//Cetak
    println("Arah Kiblat Spherical      : ${mf.DDDMS(aq.arahQiblatSpherical(gLon, gLat), "DDMMSS", sdp)}")
    println("Arah Kiblat Ellipsoid      : ${mf.DDDMS(aq.arahQiblaWithEllipsoidCorrection(gLon, gLat), "DDMMSS", sdp)}")
    println("Arah Kiblat Vincenty       : ${mf.DDDMS(aq.ArahQiblaVincenty(gLon, gLat, "PtoQ"), "DDMMSS", sdp)}")
    println("")
    println("Jarak Kiblat Spherical     : ${mf.RoundTo(aq.jarakQiblatSpherical(gLon, gLat), 3)}")
    println("Jarak Kiblat Ellipsoid     : ${mf.RoundTo(aq.jarakQiblatEllipsoid(gLon, gLat), 3)}")
    println("Jarak Kiblat Vincenty      : ${mf.RoundTo(aq.ArahQiblaVincenty(gLon, gLat, "Dist") / 1000.0, 3)}")
    println("")
    println("Azimuth Matahari           : ${mf.DDDMS(sn.sunGeocentricAzimuth(JD, dltT, gLon, gLat), "DDMMSS", 0)}")
    println("Azimuth Bulan              : ${mf.DDDMS(mo.moonGeocentricAzimuth(JD, dltT, gLon, gLat), "DDMMSS", 0)}")
    println(
        "Bayangan Matahari          : ${
            mf.DDDMS(
                mf.Mod(
                    sn.sunGeocentricAzimuth(JD, dltT, gLon, gLat) + 180.0,
                    360.0
                ), "DDMMSS", 0
            )
        }"
    )
    println(
        "Bayangan Bulan             : ${
            mf.DDDMS(
                mf.Mod(
                    mo.moonGeocentricAzimuth(JD, dltT, gLon, gLat) + 180.0,
                    360.0
                ), "DDMMSS", 0
            )
        }"
    )
    println("")
    println(
        "Bayangan Kiblat Harian 1   : ${
            mf.DHHM(
                aq.bayanganQiblatHarian(gLon, gLat, tglM, blnM, thnM, tmZn, 1),
                "HH:MM",
                0
            )
        }"
    )
    println(
        "Bayangan Kiblat Harian 2   : ${
            mf.DHHM(
                aq.bayanganQiblatHarian(gLon, gLat, tglM, blnM, thnM, tmZn, 2),
                "HH:MM",
                0
            )
        }"
    )
    println("")
    println("Rashdul Qiblat 1           : ${aq.RashdulQiblat(thnM, tmZn, 1)}")
    println("Rashdul Qiblat 2           : ${aq.RashdulQiblat(thnM, tmZn, 2)}")
    println("")
    println("Antipoda Ka'bah 1          : ${aq.AntipodaKabah(thnM, tmZn, 1)}")
    println("Antipoda Ka'bah 2          : ${aq.AntipodaKabah(thnM, tmZn, 2)}")

}