package app

import islamicTimes.*

// ELP/MPP02 yang merupakan solusi semi-analitik untuk gerakan bulan yang
// dikembangkan oleh J. Chapront dan G. Francou pada tahun 2002
// ELP/MPP02 merupakan penyempurnaan dari teori gerak bulan ELP2000-82B
// ELP/MPP02 terdiri dari 35901 suku koreksi (term) yaitu: L = 13757 term B = 7948 term R = 14196 term
// Sumber : The lunar theory ELP revisited. Introduction of new planetary perturbations by J. Chapront and G. Francou,
// Astronomy and Astrophysics, v.404, p.735-742 (2003). https://ui.adsabs.harvard.edu/abs/2003A%26A...404..735C/abstract
// Dalam perhitungan ELP/MPP02 ini dimasukkan koreksi aberasi pada Longitude, Latitude dan Distance yang merujuk pada
// buku “Lunar Table and Program from 4000 B.C. to A.D. 8000” (1991) tulisan Jean Chapront dan Michelle Chapront-Touze
// Disalin kedalam bahasa Kotlin oleh: Abu Sabda, 28 Desember 2022

fun main(args: Array<String>) {

    val jd = JulianDay()
    val dt = DynamicalTime()
    val mf = MathFunction()
    val ml = MoonLongitude()
    val mb = MoonLatitude()
    val md = MoonDistance()
    val mo = MoonOtherFunc()

    var JD: Double
    val JDE: Double
    var DeltaT: Double

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

    println("JD                                                              : $JD")
    println("DeltaT                                                          : $DeltaT")
    println(
        "Moon True Geocentric Longitude            					    : ${
            mf.DDDMS(
                ml.moonGeocentricLongitude(
                    JD,
                    DeltaT,
                    "True"
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Apparent Geocentric Longitude        						: ${
            mf.DDDMS(
                ml.moonGeocentricLongitude(
                    JD,
                    DeltaT,
                    "Appa"
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Latitude                  						: ${
            mf.DDDMS(
                mb.moonGeocentricLatitude(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Right Ascension           						: ${
            mf.DDDMS(
                mo.moonGeocentricRightAscension(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Declination               						: ${
            mf.DDDMS(
                mo.moonGeocentricDeclination(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Local Hour Angel          						: ${
            mf.DHHMS(
                mo.moonGeocentricLocalHourAngel(
                    JD,
                    DeltaT,
                    GLon
                ) / 15, "HHMMSS", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Azimuth                   						: ${
            mf.DDDMS(
                mo.moonGeocentricAzimuth(
                    JD,
                    DeltaT,
                    GLon,
                    GLat
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Altitude                  						: ${
            mf.DDDMS(
                mo.moonGeocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Distance (KM)             						: ${
            md.moonGeocentricDistance(
                JD,
                DeltaT,
                "KM"
            )
        }"
    )
    println(
        "Moon Geocentric Distance (AU)             						: ${
            md.moonGeocentricDistance(
                JD,
                DeltaT,
                "AU"
            )
        }"
    )
    println(
        "Moon Geocentric Distance (ER)             						: ${
            md.moonGeocentricDistance(
                JD,
                DeltaT,
                "ER"
            )
        }"
    )
    println(
        "Moon G.Equatorial Horizontal Parallax     						: ${
            mf.DDDMS(
                mo.moonEquatorialHorizontalParallax(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Semidiameter              						: ${
            mf.DDDMS(
                mo.moonGeocentricSemidiameter(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Elongation                						: ${
            mf.DDDMS(
                mo.moonSunGeocentricElongation(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Phase Angle               						: ${
            mf.DDDMS(
                mo.moonGeocentricPhaseAngle(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Geocentric Disk Illuminated fraction 						: ${
            mo.moonGeocentricDiskIlluminatedFraction(
                JD,
                DeltaT
            )
        }"
    )
    println(
        "Moon Geocentric Bright Limb Angle         						: ${
            mf.DDDMS(
                mo.moonGeocentricBrightLimbAngle(
                    JD,
                    DeltaT
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Topocentric Ecliptic Longitude       						: ${
            mf.DDDMS(
                mo.moonTopocentricLongitude(
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
        "Moon Topocentric Ecliptic Latitude        						: ${
            mf.DDDMS(
                mo.moonTopocentricLatitude(
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
        "Moon Topocentric Right Ascension          						: ${
            mf.DHHMS(
                mo.moonTopocentricRightAscension(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ) / 15, "HHMMSS", SDP
            )
        }"
    )
    println(
        "Moon Topocentric Declination              						: ${
            mf.DDDMS(
                mo.moonTopocentricDeclination(
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
        "Moon Topocentric Local Hour Angel         						: ${
            mf.DHHMS(
                mo.moonTopocentricLocalHourAngel(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev
                ) / 15, "HHMMSS", SDP
            )
        }"
    )
    println(
        "Moon Topocentric Semidiameter             						: ${
            mf.DDDMS(
                mo.moonTopocentricSemidiameter(
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
        "Moon Topocentric Elongation               						: ${
            mf.DDDMS(
                mo.moonSunTopocentricElongation(
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
        "Moon Topocentric Phase Angle              						: ${
            mf.DDDMS(
                mo.moonTopocentricPhaseAngle(
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
        "Moon Topocentric Disk Illuminated fraction						: ${
            mo.moonTopocentricDiskIlluminatedFraction(
                JD,
                DeltaT,
                GLon,
                GLat,
                Elev
            )
        }"
    )
    println(
        "Moon Topocentric Bright Limb Angle        						: ${
            mf.DDDMS(
                mo.moonTopocentricBrightLimbAngle(
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
        "Moon Topocentric Azimuth                  						: ${
            mf.DDDMS(
                mo.moonTopocentricAzimuth(
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
        "Moon Airless topocentric altitude of The Moon’s Center Limb     : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htc"
                ), "", SDP
            )
        }"
    )
    println(
        "Moon Apparent topocentric altitude of The Moon’s Center Limb    : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htac"
                ), "", SDP
            )
        }"
    )
    println(
        "Observed altitude of The Moon’s Center Limb                     : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htoc"
                ), "", SDP
            )
        }"
    )
    println(
        "Airles topocentric altitude of The Moon’s Upper Limb            : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htu"
                ), "", SDP
            )
        }"
    )
    println(
        "Apparent topocentric altitude of The Moon’s Upper Limb          : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htau"
                ), "", SDP
            )
        }"
    )
    println(
        "Observed altitude of The Moon’s Upper Limb                      : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htou"
                ), "", SDP
            )
        }"
    )
    println(
        "Airles topocentric altitude of The Moon’s Lower Limb            : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htl"
                ), "", SDP
            )
        }"
    )
    println(
        "Apparent topocentric altitude of The Moon’s Lower Limb          : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htal"
                ), "", SDP
            )
        }"
    )
    println(
        "Observed altitude of The Moon’s Lower Limb                      : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    DeltaT,
                    GLon,
                    GLat,
                    Elev,
                    Pressure,
                    Temperature,
                    "htol"
                ), "", SDP
            )
        }"
    )

}