package app

import islamicTimes.*

fun main() {
    val jd = JulianDay()
    val dt = DynamicalTime()
    val sn = SunDatas()
    val mf = MathFunction()
    val ml = MoonLongitude()
    val mb = MoonLatitude()
    val mo = MoonOtherFunc()

    val JD: Double
    val deltaT: Double

    val tglM: Byte = 27
    val blnM: Byte = 7
    val thnM: Long = 2018
    val jamDes: Double = 20.0
    val timeZone: Double = 0.0
    val sdp: Byte = 0

    JD = jd.KMJD(tglM, blnM, thnM, jamDes, timeZone)
    deltaT = 0.0

    println("====================================================")
    println("DATA MATAHARI")
    println("====================================================")

    println("Julian Day                 : ${mf.RoundTo(JD, 4)}")
    println("Delta T                    : ${mf.RoundTo(dt.DeltaT(JD), 2)}")
    println("Apparent Longitude         : ${mf.DDDMS(sn.sunGeocentricLongitude(JD, deltaT, "Appa"), "", sdp)}")
    println("Apparent Latitude          : ${mf.DDDMS(sn.sunGeocentricLatitude(JD, deltaT), "SS", 2)}")
    println("Apparent Right Ascension   : ${mf.DDDMS(sn.sunGeocentricRightAscension(JD, deltaT), "", sdp)}")
    println("Apparent Declination       : ${mf.DDDMS(sn.sunGeocentricDeclination(JD, deltaT), "", sdp)}")
    println("Horizontal Parallax        : ${mf.DDDMS(sn.sunEquatorialHorizontalParallax(JD, deltaT), "SS", 7)}")
    println("Semidiamater               : ${mf.DDDMS(sn.sunGeocentricSemidiameter(JD, deltaT), "MMSS", 2)}")
    println("Equation of Time           : ${mf.DHHMS(sn.equationOfTime(JD, deltaT), "MMSS", 0)}")
    println("Distance                   : ${mf.RoundTo(sn.sunGeocentricDistance(JD, deltaT, "AU"), 8)}")
    println("GHA                        : ${mf.DDDMS(sn.sunGeocentricGreenwichHourAngle(JD, deltaT), "", sdp)}")


    println(" ")
    println("====================================================")
    println("DATA BULAN")
    println("====================================================")
    println("Julian Day                 : ${mf.RoundTo(JD, 4)}")
    println("Delta T                    : ${mf.RoundTo(dt.DeltaT(JD), 2)}")
    println("Apparent Longitude         : ${mf.DDDMS(ml.moonGeocentricLongitude(JD, deltaT, "Appa"), "", sdp)}")
    println("Apparent Latitude          : ${mf.DDDMS(mb.moonGeocentricLatitude(JD, deltaT), "", sdp)}")
    println("Apparent Right Ascension   : ${mf.DDDMS(mo.moonGeocentricRightAscension(JD, deltaT), "", sdp)}")
    println("Apparent Declination       : ${mf.DDDMS(mo.moonGeocentricDeclination(JD, deltaT), "", sdp)}")
    println("Horizontal Parallax        : ${mf.DDDMS(mo.moonEquatorialHorizontalParallax(JD, deltaT), "", sdp)}")
    println("Semidiameter               : ${mf.DDDMS(mo.moonGeocentricSemidiameter(JD, deltaT), "MMSS", 2)}")
    println("Angle Bright Limb          : ${mf.DDDMS(mo.moonGeocentricBrightLimbAngle(JD, deltaT), "", sdp)}")
    println(
        "Fraction Illumination      : ${
            mf.RoundTo(
                mo.moonGeocentricDiskIlluminatedFraction(JD, deltaT) / 100.0,
                10
            )
        }"
    )
    println("GHA                        : ${mf.DDDMS(mo.moonGeocentricGreenwichHourAngle(JD, deltaT), "", sdp)}")

}