package app

import islamicTimes.*

fun main() {
    val jd = JulianDay()
    val dt = DynamicalTime()
    val sn = SunDatas()
    val mf = MathFunction()
    val ml = MoonLongitude()
    val mb = MoonLatitude()
    val md = MoonDistance()
    val mo = MoonOtherFunc()

    val JD: Double
    val deltaT: Double

    val tglM: Byte = 20
    val blnM: Byte = 4
    val thnM: Long = 2023
    val jamDes: Double = (17 + 51 / 60.0 + 27 / 3600.0)
    val timeZone: Double = 7.0
    val gLon: Double = (106 + 33 / 60.0 + 27.8 / 3600.0)
    val gLat: Double = -(7 + 1 / 60.0 + 44.6 / 3600.0)
    val elev: Double = 7.0
    val pressure: Double = 1010.0
    val temperature: Double = 10.0
    val sdp: Byte = 2

    JD = jd.KMJD(tglM, blnM, thnM, jamDes, timeZone)
    deltaT = dt.DeltaT(JD)


    println("==========================")
    println("JAM BINTANG")
    println("==========================")

    println("GST      : ${mf.DHHMS(sn.greenwichApparentSiderialTime(JD, deltaT) / 15, "HHMMSS", sdp)}")
    println("LST      : ${mf.DHHMS(sn.localApparentSiderialTime(JD, deltaT, gLon) / 15, "HHMMSS", sdp)}")

    println(" ")
    println("==========================")
    println("DATA MATAHARI GEOSENTRIS")
    println("==========================")

    println("JD       : ${mf.RoundTo(JD, 4)}")
    println("Delta T  : ${mf.RoundTo(deltaT, 2)}")
    println("GHA      : ${mf.DHHMS(sn.sunGeocentricGreenwichHourAngle(JD, deltaT) / 15, "HHMMSS", sdp)}")
    println("LHA      : ${mf.DHHMS(sn.sunGeocentricLocalHourAngel(JD, deltaT, gLon) / 15, "HHMMSS", sdp)}")
    println("Bujur    : ${mf.DDDMS(sn.sunGeocentricLongitude(JD, deltaT, "Appa"), "", sdp)}")
    println("Lintang  : ${mf.DDDMS(sn.sunGeocentricLatitude(JD, deltaT), "", sdp)}")
    println("RA       : ${mf.DDDMS(sn.sunGeocentricRightAscension(JD, deltaT), "", sdp)}")
    println("Dec      : ${mf.DDDMS(sn.sunGeocentricDeclination(JD, deltaT), "", sdp)}")
    println("Azimuth  : ${mf.DDDMS(sn.sunGeocentricAzimuth(JD, deltaT, gLon, gLat), "", sdp)}")
    println("Altitude : ${mf.DDDMS(sn.sunGeocentricAltitude(JD, deltaT, gLon, gLat), "", sdp)}")

    println(" ")
    println("===========================")
    println("DATA MATAHARI TOPOSENTRIS")
    println("===========================")

    println("JD       : ${mf.RoundTo(JD, 4)}")
    println("Delta T  : ${mf.RoundTo(deltaT, 2)}")
    println("GHA      : ${mf.DHHMS(sn.sunTopocentricGreenwichHourAngle(JD, deltaT, gLon, gLat) / 15, "HHMMSS", sdp)}")
    println("LHA      : ${mf.DHHMS(sn.sunTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev) / 15, "HHMMSS", sdp)}")
    println("GST      : ${mf.DHHMS(sn.greenwichApparentSiderialTime(JD, deltaT) / 15, "HHMMSS", sdp)}")
    println("LST      : ${mf.DHHMS(sn.localApparentSiderialTime(JD, deltaT, gLon) / 15, "HHMMSS", sdp)}")
    println("Bujur    : ${mf.DDDMS(sn.sunTopocentricLongitude(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("Lintang  : ${mf.DDDMS(sn.sunTopocentricLatitude(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("RA       : ${mf.DDDMS(sn.sunTopocentricRightAscension(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("Dec      : ${mf.DDDMS(sn.sunTopocentricDeclination(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("Azimuth  : ${mf.DDDMS(sn.sunTopocentricAzimuth(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println(
        "Altitude : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(JD, deltaT, gLon, gLat, elev, pressure, temperature, "ht"),
                "",
                sdp
            )
        }"
    )


    println(" ")
    println("===========================")
    println("DATA BULAN GEOSENTRIS")
    println("===========================")

    println("JD       : ${mf.RoundTo(JD, 4)}")
    println("Delta T  : ${mf.RoundTo(deltaT, 2)}")
    println("GHA      : ${mf.DHHMS(mo.moonGeocentricGreenwichHourAngle(JD, deltaT) / 15, "HHMMSS", sdp)}")
    println("LHA      : ${mf.DHHMS(mo.moonGeocentricLocalHourAngel(JD, deltaT, gLon) / 15, "HHMMSS", sdp)}")
    println("Bujur    : ${mf.DDDMS(ml.moonGeocentricLongitude(JD, deltaT, "Appa"), "", sdp)}")
    println("Lintang  : ${mf.DDDMS(mb.moonGeocentricLatitude(JD, deltaT), "", sdp)}")
    println("RA       : ${mf.DDDMS(mo.moonGeocentricRightAscension(JD, deltaT), "", sdp)}")
    println("Dec      : ${mf.DDDMS(mo.moonGeocentricDeclination(JD, deltaT), "", sdp)}")
    println("Azimuth  : ${mf.DDDMS(mo.moonGeocentricAzimuth(JD, deltaT, gLon, gLat), "", sdp)}")
    println("Altitude : ${mf.DDDMS(mo.moonGeocentricAltitude(JD, deltaT, gLon, gLat), "", sdp)}")

    println(" ")
    println("===========================")
    println("DATA BULAN TOPOSENTRIS")
    println("===========================")

    println("JD       : ${mf.RoundTo(JD, 4)}")
    println("Delta T  : ${mf.RoundTo(deltaT, 2)}")
    println("GHA      : ${mf.DHHMS(mo.moonTopocentricGreenwichHourAngle(JD, deltaT, gLon, gLat) / 15, "HHMMSS", sdp)}")
    println(
        "LHA      : ${
            mf.DHHMS(
                mo.moonTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev) / 15,
                "HHMMSS",
                sdp
            )
        }"
    )
    println("Bujur    : ${mf.DDDMS(mo.moonTopocentricLongitude(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("Lintang  : ${mf.DDDMS(mo.moonTopocentricLatitude(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("RA       : ${mf.DDDMS(mo.moonTopocentricRightAscension(JD, deltaT, gLon, gLat, elev), " ", sdp)}")
    println("Dec      : ${mf.DDDMS(mo.moonTopocentricDeclination(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println("Azimuth  : ${mf.DDDMS(mo.moonTopocentricAzimuth(JD, deltaT, gLon, gLat, elev), "", sdp)}")
    println(
        "Altitude : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    deltaT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htoc"
                ), "", sdp
            )
        }"
    )
    //println("Altitude : ${mf.DDDMS(mo.moonTopocentricAltitude(JD,deltaT,gLon,gLat,elev,pressure,temperature,"htc"),"",sdp)}")
}