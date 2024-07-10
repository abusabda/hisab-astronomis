package app

import islamicTimes.DynamicalTime
import islamicTimes.JulianDay
import islamicTimes.MathFunction
import islamicTimes.SunDatas

// Variations Seculaires des Orbites Planetetaries (VSOP) adalah model matematika yang menggambarkan
// perubahan jangka panjang (variasi sekuler) dalam orbit planet-planet dari Merkurius hingga Neptunus (termasuk Bumi).
// Algoritma atau teori VSOP dikembangkan oleh P. Bretagnon dan G. Francou
// Teori VSOP sering digunakan untuk perhitungan posisi Matahari dilihat dari Bumi. Versi pertama dari
// VSOP adalah VSOP1982, kemudian dikembangkan menjadi VSOP1987. Seri terakhir dari VSOP adalah VSOP2000.
// VSOP87 (1987) di buat dalam beberapa versi yaitu: seri VSOP87A, VSOP87B, VSOP87C, dan VSOP87D.
// Koding dalam bahasa Kotlin ini dibuat berdasarkan seri VSOP87D.
// VSOP87D memuat 2425 term (komponen periodik), yaitu 1080 term untuk bujur Bumi (L), 348 term untuk lintang (B)
// dan 997 term untuk vektor radius (R).
// Sumber : makalah “Planetary Theories in rectangular and spherical variables: VSOP87 solution” (1988) yang ditulis
// oleh P. Bretagnon dan G. Francou
fun main() {
    val jd = JulianDay()
    val dt = DynamicalTime()
    val sn = SunDatas()
    val mf = MathFunction()

    val JD: Double
    val JDE: Double
    val DeltaT: Double

    val TglM: Byte = 20
    val BlnM: Byte = 4
    val ThnM: Long = 2023
    val JamDes: Double = (17 + 51 / 60.0 + 27 / 3600.0)
    val TimeZone: Double = 7.0
    val GLon: Double = (106 + 33 / 60.0 + 27.8 / 3600.0)
    val GLat: Double = -(7 + 1 / 60.0 + 44.6 / 3600.0)
    val Elev: Double = 52.685
    val Pressure: Double = 1010.0
    val Temperature: Double = 10.0
    val SDP: Byte = 2

    JD = jd.KMJD(TglM, BlnM, ThnM, JamDes, TimeZone)
    DeltaT = dt.DeltaT(JD)
    JDE = jd.JDE(JD, DeltaT)

    println("Julian Day                             : $JD")
    println("Delta T                                : $DeltaT")
    println("JDE                                    : $JDE")
    println(
        "sun True Geocentric Longitude          : ${
            mf.DDDMS(
                sn.sunGeocentricLongitude(JD, DeltaT, "True"),
                "",
                SDP
            )
        }"
    )
    println(
        "sun Apparent Geocentric Longitude      : ${
            mf.DDDMS(
                sn.sunGeocentricLongitude(JD, DeltaT, "Appa"),
                "",
                SDP
            )
        }"
    )
    println("sun Geocentric Latitude                : ${mf.DDDMS(sn.sunGeocentricLatitude(JD, DeltaT), "", SDP)}")
    println("sun Geocentric Right Ascension         : ${mf.DDDMS(sn.sunGeocentricRightAscension(JD, DeltaT), "", SDP)}")
    println("sun Geocentric Declination             : ${mf.DDDMS(sn.sunGeocentricDeclination(JD, DeltaT), "", SDP)}")
    println(
        "sun Geocentric Azimut                  : ${
            mf.DDDMS(
                sn.sunGeocentricAzimuth(JD, DeltaT, GLon, GLat),
                "",
                SDP
            )
        }"
    )
    println(
        "sun Geocentric Altitude                : ${
            mf.DDDMS(
                sn.sunGeocentricAltitude(JD, DeltaT, GLon, GLat),
                "",
                SDP
            )
        }"
    )
    println("sun Geocentric Semidiamater            : ${mf.DDDMS(sn.sunGeocentricSemidiameter(JD, DeltaT), "", SDP)}")
    println(
        "sun Geocentris Horizontal Parallax     : ${
            mf.DDDMS(
                sn.sunEquatorialHorizontalParallax(JD, DeltaT),
                "",
                SDP
            )
        }"
    )
    println("sun Aberration                         : ${mf.DDDMS(sn.sunAberration(JD, DeltaT) / 3600.0, "SS")}")
    println(
        "sun Topocentric ecliptic Longitude     : ${
            mf.DDDMS(
                sn.sunTopocentricLongitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ), "", SDP
            )
        }"
    )
    println(
        "sun Topocentric ecliptic Latitude      : ${
            mf.DDDMS(
                sn.sunTopocentricLatitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ), "", SDP
            )
        }"
    )
    println(
        "sun Topocentric Right Ascension        : ${
            mf.DDDMS(
                sn.sunTopocentricRightAscension(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ), "", SDP
            )
        }"
    )
    println(
        "sun Topocentric Declination            : ${
            mf.DDDMS(
                sn.sunTopocentricDeclination(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ), "", SDP
            )
        }"
    )
    println(
        "sun Topocentric Azimuth                : ${
            mf.DDDMS(
                sn.sunTopocentricAzimuth(JD, DeltaT, GLon, GLat, Elev),
                "",
                SDP
            )
        }"
    )
    println(
        "sun Airless Topocentric Altitude       : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "ht"
                ), "", SDP
            )
        }"
    )
    println(
        "sun Apparent Topocentric Altitude      : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "hta"
                ), "", SDP
            )
        }"
    )
    println(
        "sun Observered Altitude                : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "hto"
                ), "", SDP
            )
        }"
    )
    println(
        "sun Topocentric Semidiameter           : ${
            mf.DDDMS(
                sn.sunTopocentricSemidiameter(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ), "", SDP
            )
        }"
    )
    println("Equation of Time                       : ${mf.DHHMS(sn.equationOfTime(JD, DeltaT))}")

}
