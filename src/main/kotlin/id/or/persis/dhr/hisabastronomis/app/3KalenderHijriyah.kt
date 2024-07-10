package id.or.persis.dhr.hisabastronomis.app

import id.or.persis.dhr.hisabastronomis.islamicTimes.*


fun main() {
    val jd = JulianDay()
    val dt = DynamicalTime()
    val sn = SunDatas()
    val mf = MathFunction()
    val ml = MoonLongitude()
    val mb = MoonLatitude()
    val md = MoonDistance()
    val mo = MoonOtherFunc()

//INPUT
    val nmL: String = "Pelabuhanratu"
    val blnH: Byte = 10
    val thnH: Long = 1444
    val gLon: Double = (106 + 33 / 60.0 + 27.8 / 3600.0)
    val gLat: Double = -(7 + 1 / 60.0 + 44.6 / 3600.0)
    val timeZone: Double = 7.0
    val elev: Double = 52.685
    val pressure: Double = 1010.0
    val temperature: Double = 10.0
    val sdp: Byte = 0
    val tbhHari: Int = 0
    val optional: Int = 1// 1 = Imkan Rukyat, 2 = Wujudul Hilal

//PROSES
    val jdNM: Double
    val jdGS: Double
    val JD: Double
    val dltT: Double
    val jamGS: String
    val jdNM2: Double
    val jdNM3: Double
    val jdNM4: Double
    val jdNM5: Double

    //Ijtimak Geosentris, Ijtimak Toposentris dan Ghurub Matahari
    jdNM = mo.geocentricConjunction(blnH, thnH, 0.0, "Ijtima")
    jdGS = sn.jdGhurubSyams(jdNM, gLat, gLon, elev, timeZone)
    JD = sn.jdGhurubSyams(jdNM + tbhHari, gLat, gLon, elev, timeZone)
    jamGS = jd.JDKM((sn.jdGhurubSyams(jdNM + tbhHari, gLat, gLon, elev, timeZone)), timeZone, "JAMDES")
    dltT = dt.DeltaT(Math.floor(jdNM) + 0.5)
    jdNM2 = mo.geocentricConjunction(blnH, thnH, dltT, "Ijtima") //JDNMGeo + DeltaT
    jdNM3 = mo.topocentricConjunction(blnH, thnH, dltT, gLon, gLat, elev, "Ijtima")
    jdNM4 = mo.geocentricConjunction(blnH, thnH, dltT, "Bujur")
    jdNM5 = mo.topocentricConjunction(blnH, thnH, dltT, gLon, gLat, elev, "Bujur")

    //Terbenam Bulan, Best Time, Crescent Width dan Range q Odeh
    val tglM = jd.JDKM(JD, timeZone, "TglM")
    val blnM = jd.JDKM(JD, timeZone, "BlnM")
    val thnM = jd.JDKM(JD, timeZone, "ThnM")
    val mSet = mo.moonTransitRiseSet(tglM.toByte(), blnM.toByte(), thnM.toLong(), gLon, gLat, elev, timeZone, "SET", 2)
    val jdMset = jd.KMJD(tglM.toByte(), blnM.toByte(), thnM.toLong()) + (mSet.toString().toDouble() - timeZone) / 24.0
    val bTime = jamGS.toDouble() + 4 / 9.0 * ((jdMset - JD) * 24.0)
    val gCw =
        (mo.moonGeocentricSemidiameter(JD, dltT)) * (1 - Math.cos(mf.Rad(mo.moonSunGeocentricElongation(JD, dltT))))
    val tCw = (mo.moonTopocentricSemidiameter(
        JD,
        dltT,
        gLon,
        gLat,
        elev
    )) * (1 - Math.cos(mf.Rad(mo.moonSunTopocentricElongation(JD, dltT, gLon, gLat, elev))))
    val rAltG =
        mo.moonGeocentricAltitude(JD, dltT, gLon, gLat) + Math.abs(sn.sunGeocentricAltitude(JD, dltT, gLon, gLat))
    val rAltT = mo.moonTopocentricAltitude(
        JD,
        dltT,
        gLon,
        gLat,
        elev,
        pressure,
        temperature,
        "htc"
    ) + Math.abs(sn.sunTopocentricAltitude(JD, dltT, gLon, gLat, elev, pressure, temperature, "ht"))
    val qOdeh = rAltT - (-0.1018 * Math.pow((tCw * 60), 3.0) + 0.7319 * Math.pow(
        (tCw * 60),
        2.0
    ) - 6.3226 * (tCw * 60) + 7.1651)

    //Tinggi Hilal dan Elongasi
    val tHilal1: Double = mo.moonTopocentricAltitude(jdGS, dltT, gLon, gLat, elev, pressure, temperature, "htoc")
    val elong01: Double = mo.moonSunTopocentricElongation(jdGS, dltT, gLon, gLat, elev)
    val tHilal2: Double =
        mo.moonTopocentricAltitude(JD, dltT, gLon, gLat, elev, pressure, temperature, "htoc") // JD Ijtimak Tambah hari
    val elong02: Double = mo.moonSunTopocentricElongation(JD, dltT, gLon, gLat, elev) // JD Ijtimak Tambah hari

    //Kesimpulan Kriteria awal Bulan
    val abq: Double
    val iR01: Int
    val iRP1: String
    val iRP2: String
    val wH01: Int
    val wHM1: String
    val wHM2: String
    val visb: String
    val wh: String
    val kr: String
    val kr1: String

    //Imkan Rukyat PERSIS & Pemerintah
    if (tHilal1 >= 3.0 && elong01 >= 6.4) {
        iR01 = 1 // masuk awal bulan
        iRP1 = "Visible" //Bisa terlihat
    } else {
        iR01 = 2 //Belum masuk awal bulan
        iRP1 = "Not Visible" // belum bisa terlihat
    }
    iRP2 = if (tHilal2 >= 3.0 && elong02 >= 6.4) {  //hilal JD Ijtimak tambah hari
        "Visible"
    } else {
        "Not Visible"
    }

    //Wujudul Hilal Muhamadiyah
    if (tHilal1 > 0.0) {
        wH01 = 1 // masuk awal bulan
        wHM1 = "Wujud" //sudah wujudl
    } else {
        wH01 = 2 // belum masuk awal bulan
        wHM1 = "Belum Wujud" //belum wujud
    }
    wHM2 = if (tHilal2 > 0.0) { //hilal JD Ijtimak tambah hari
        "Wujud"
    } else {
        "Belum Wujud"
    }

    //Tambah Hari
    if (tbhHari == 0) {
        visb = iRP1
        wh = wHM1
    } else {
        visb = iRP2
        wh = wHM2
    }

    //Tampilkan pilihan Kriteria dan hasil akhir kriteria
    if (optional == 1) { // pilihan imkan rukyat
        abq = ((Math.floor(jdNM2 + 0.5 + timeZone / 24.0)) - timeZone / 24.0) + iR01
        kr = visb
        kr1 = "Imkan Rukyat"
    } else { // pilihan wujudul hilal
        abq = ((Math.floor(jdNM2 + 0.5 + timeZone / 24.0)) - timeZone / 24.0) + wH01
        kr = wh
        kr1 = "Wujudul Hilal"
    }

    //Nama Bulan Hijriyah
    val NmBlnHDt = listOf(
        "Al-Muharram",
        "Shafar",
        "Rabi‘ul Awwal",
        "Rabi‘ul Akhir",
        "Jumadal Ula",
        "Jumadal Akhirah",
        "Rajab",
        "Sya‘ban",
        "Ramadhan",
        "Syawwal",
        "Dzul Qa‘dah",
        "Dzul Hijjah"
    )
    val NmBlnH = NmBlnHDt.get(blnH - 1)

//Tampilkan data Ijtimak, Ghurub Matahari, data bulan dan Matahari
    println("")
    println("Perhitungan Awal Bulan ${NmBlnH + " " + thnH} H")
    println("")
    println("Nama Lokasi            : ${nmL}")
    println("Bujur Tempat           : ${mf.DDDMS(gLon, "BBBT", 2)}")
    println("Lintang Tempat         : ${mf.DDDMS(gLat, "LULS", 2)}")
    println(
        "Ijtimak Goesentris     : ${
            jd.JDKM(jdNM2, timeZone) + " Jam: " + mf.DHHMS(
                jd.JDKM(jdNM2, timeZone, "Jam D").toDouble(), "", sdp
            )
        } LT"
    )
    println("Pada Bujur Geosentris  : ${mf.DDDMS(jdNM4)}")
    println(
        "Ijtimak Toposentris    : ${
            jd.JDKM(jdNM3, timeZone) + " Jam: " + mf.DHHMS(
                jd.JDKM(jdNM3, timeZone, "Jam D").toDouble(), "", sdp
            )
        } LT"
    )
    println("Pada Bujur Toposentris : ${mf.DDDMS(jdNM5)}")
    println("Ghurub Matahari        : ${mf.DHHMS(jd.JDKM(JD, timeZone, "Jam D").toDouble(), "HH:MM:SS", 0) + " LT"}")
    println("Ghurub Bulan           : ${mf.DHHMS(mSet.toString().toDouble(), "HH:MM:SS", 0) + " LT"}")
    println("Kriteria               : $kr1")
    println("Status                 : $kr")
    println("Awal Bulan             : ${jd.JDKM(abq, timeZone)}")

    println("====================================================")
    println(
        "DATA MATAHARI : ${
            jd.JDKM(JD, timeZone) + " Jam: " + mf.DHHMS(
                jd.JDKM(JD, timeZone, "Jam D").toDouble(),
                "HHMMSS",
                sdp
            )
        }"
    )
    println("====================================================")

    println("Julian Day             : ${mf.RoundTo(JD, 8)}")
    println("Delta T                : ${mf.RoundTo(dltT, 2) + "s"}")
    println("G.Longitude (True)     : ${mf.DDDMS(sn.sunGeocentricLongitude(JD, dltT, "True"), "", sdp)}")
    println("G.Longitude (Appa)     : ${mf.DDDMS(sn.sunGeocentricLongitude(JD, dltT, "Appa"), "", sdp)}")
    println("G.Latitude             : ${mf.DDDMS(sn.sunGeocentricLatitude(JD, dltT), "", sdp)}")
    println(
        "G.Right Ascension      : ${
            mf.DHHMS(
                sn.sunGeocentricRightAscension(JD, dltT) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("G.Declination          : ${mf.DDDMS(sn.sunGeocentricDeclination(JD, dltT), "", sdp)}")
    println("G.Azimuth              : ${mf.DDDMS(sn.sunGeocentricAzimuth(JD, dltT, gLon, gLat), "", sdp)}")
    println("G.Altitude             : ${mf.DDDMS(sn.sunGeocentricAltitude(JD, dltT, gLon, gLat), "", sdp)}")
    println("G.Semidiamater         : ${mf.DDDMS(sn.sunGeocentricSemidiameter(JD, dltT), "", sdp)}")
    println("G.Horizontal Parallax  : ${mf.DDDMS(sn.sunEquatorialHorizontalParallax(JD, dltT), "", sdp)}")
    println("G.Distance (AU)        : ${mf.RoundTo(sn.sunGeocentricDistance(JD, dltT, "AU"), 5)}")
    println("G.Distance (KM)        : ${mf.RoundTo(sn.sunGeocentricDistance(JD, dltT, "KM"), 0)}")
    println("G.Distance (ER)        : ${mf.RoundTo(sn.sunGeocentricDistance(JD, dltT, "ER"), 5)}")
    println(
        "G.Greenwich Hour Angle : ${
            mf.DHHMS(
                sn.sunGeocentricGreenwichHourAngle(JD, dltT) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println(
        "G.Local Hour Angle     : ${
            mf.DHHMS(
                sn.sunGeocentricLocalHourAngel(JD, dltT, gLon) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("T.Longitude            : ${mf.DDDMS(sn.sunTopocentricLongitude(JD, dltT, gLon, gLat, elev), "", sdp)}")
    println("T.Latitude             : ${mf.DDDMS(sn.sunTopocentricLatitude(JD, dltT, gLon, gLat, elev), "", sdp)}")
    println(
        "T.Right Ascension      : ${
            mf.DHHMS(
                sn.sunTopocentricRightAscension(JD, dltT, gLon, gLat, elev) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("T.Declination          : ${mf.DDDMS(sn.sunTopocentricDeclination(JD, dltT, gLon, gLat, elev), "", sdp)}")
    println("T.Azimuth              : ${mf.DDDMS(sn.sunTopocentricAzimuth(JD, dltT, gLon, gLat, elev), "", sdp)}")
    println(
        "T.Altitude (Airless)   : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "ht"
                ), "", sdp
            )
        }"
    )
    println(
        "T.Altitude (Apparent)  : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "hta"
                ), "", sdp
            )
        }"
    )
    println(
        "M.Altitude             : ${
            mf.DDDMS(
                sn.sunTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "hto"
                ), "", sdp
            )
        }"
    )
    println("T.Semidiameter         : ${mf.DDDMS(sn.sunTopocentricSemidiameter(JD, dltT, gLon, gLat, elev), "", sdp)}")
    println(
        "T.Greenwich Hour Angle : ${
            mf.DHHMS(
                sn.sunTopocentricGreenwichHourAngle(JD, dltT, gLon, gLat) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println(
        "T.Local Hour Angle     : ${
            mf.DHHMS(
                sn.sunTopocentricLocalHourAngel(JD, dltT, gLon, gLat) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("Equation of Time       : ${mf.DHHMS(sn.equationOfTime(JD, dltT), "MMSS", sdp, "+-")}")


    println(" ")
    println("====================================================")
    println(
        "DATA BULAN : ${
            jd.JDKM(JD, timeZone) + " Jam: " + mf.DHHMS(
                jd.JDKM(JD, timeZone, "Jam D").toDouble(),
                "HHMMSS",
                sdp
            )
        }"
    )
    println("====================================================")
    println("Julian Day                     : ${mf.RoundTo(JD, 8)}")
    println("DeltaT                         : ${mf.RoundTo(dltT, 2) + "s"}")
    println("G.Longitude (True)             : ${mf.DDDMS(ml.moonGeocentricLongitude(JD, dltT, "True"), "", sdp)}")
    println("G.Longitude (Apparent)         : ${mf.DDDMS(ml.moonGeocentricLongitude(JD, dltT, "Appa"), "", sdp)}")
    println("G.Latitude                     : ${mf.DDDMS(mb.moonGeocentricLatitude(JD, dltT), "", sdp)}")
    println(
        "G.Right Ascension              : ${
            mf.DHHMS(
                mo.moonGeocentricRightAscension(JD, dltT),
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("G.Declination                  : ${mf.DDDMS(mo.moonGeocentricDeclination(JD, dltT), "", sdp)}")
    println("G.Azimuth                      : ${mf.DDDMS(mo.moonGeocentricAzimuth(JD, dltT, gLon, gLat), "", sdp)}")
    println("G.Altitude                     : ${mf.DDDMS(mo.moonGeocentricAltitude(JD, dltT, gLon, gLat), "", sdp)}")
    println("G.Eq Horizontal Parallax       : ${mf.DDDMS(mo.moonEquatorialHorizontalParallax(JD, dltT), "", sdp)}")
    println("G.Semidiameter                 : ${mf.DDDMS(mo.moonGeocentricSemidiameter(JD, dltT), "", sdp)}")
    println("G.Elongation                   : ${mf.DDDMS(mo.moonSunGeocentricElongation(JD, dltT), "", sdp)}")
    println("G.Phase Angle                  : ${mf.DDDMS(mo.moonGeocentricPhaseAngle(JD, dltT), "", sdp)}")
    println("G.Disk Illuminated fraction    : ${mo.moonGeocentricDiskIlluminatedFraction(JD, dltT)}")
    println("G.Bright Limb Angle            : ${mf.DDDMS(mo.moonGeocentricBrightLimbAngle(JD, dltT), "", sdp)}")
    println(
        "G.Greenwich Hour Angle         : ${
            mf.DHHMS(
                sn.sunGeocentricGreenwichHourAngle(JD, dltT) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println(
        "G.Local Hour Angel             : ${
            mf.DHHMS(
                mo.moonGeocentricLocalHourAngel(JD, dltT, gLon) / 15.0,
                "HHMMSS",
                sdp,
                "+-"
            )
        }"
    )
    println("G.Distance (KM)                : ${mf.RoundTo(md.moonGeocentricDistance(JD, dltT, "KM"), 5)}")
    println("G.Distance (AU)                : ${mf.RoundTo(md.moonGeocentricDistance(JD, dltT, "AU"), 5)}")
    println("G.Distance (ER)                : ${mf.RoundTo(md.moonGeocentricDistance(JD, dltT, "ER"), 5)}")
    println("G.Relative Altitude            : ${mf.DDDMS(rAltG, "", 0)}")
    //println("G.Arah Terbenam Bulan          : ${mf.DDDMS(mo.moonGeocentricAzimuth(jdMset,dltT,gLon,gLat),"",sdp)}")
    println("G.Crescent Width               : ${mf.DDDMS(gCw, "", 0)}")
    println(
        "T.Longitude                    : ${
            mf.DDDMS(
                mo.moonTopocentricLongitude(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Latitude                     : ${
            mf.DDDMS(
                mo.moonTopocentricLatitude(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Right Ascension              : ${
            mf.DHHMS(
                mo.moonTopocentricRightAscension(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev
                ) / 15.0, "HHMMSS", sdp, "+-"
            )
        }"
    )
    println(
        "T.Declination                  : ${
            mf.DDDMS(
                mo.moonTopocentricDeclination(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Semidiameter                 : ${
            mf.DDDMS(
                mo.moonTopocentricSemidiameter(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Elongation                   : ${
            mf.DDDMS(
                mo.moonSunTopocentricElongation(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Phase Angle                  : ${
            mf.DDDMS(
                mo.moonTopocentricPhaseAngle(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println("T.Disk Illuminated fraction    : ${mo.moonTopocentricDiskIlluminatedFraction(JD, dltT, gLon, gLat, elev)}")
    println(
        "T.Bright Limb Angel            : ${
            mf.DDDMS(
                mo.moonTopocentricBrightLimbAngle(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Greenwich Hour Angel         : ${
            mf.DHHMS(
                mo.moonTopocentricGreenwichHourAngle(
                    JD,
                    dltT,
                    gLon,
                    gLat
                ) / 15.0, "HHMMSS", sdp, "+-"
            )
        }"
    )
    println(
        "T.Local Hour Angel             : ${
            mf.DHHMS(
                mo.moonTopocentricLocalHourAngel(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev
                ) / 15.0, "HHMMSS", sdp, "+-"
            )
        }"
    )
    println(
        "T.Azimuth                      : ${
            mf.DDDMS(
                mo.moonTopocentricAzimuth(JD, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println(
        "T.Altitude (Airless) Center    : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htc"
                ), "", sdp
            )
        }"
    )
    println(
        "T.Altitude (Apparent) Center   : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htac"
                ), "", sdp
            )
        }"
    )
    println(
        "M.Altitude Center              : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
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
    println(
        "T.Altitude (Airless) Upper     : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htu"
                ), "", sdp
            )
        }"
    )
    println(
        "T.Altitude (Apparent) Upper    : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htau"
                ), "", sdp
            )
        }"
    )
    println(
        "M.Altitude Upper               : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htou"
                ), "", sdp
            )
        }"
    )
    println(
        "T.Altitude (Airless) Lower     : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htl"
                ), "", sdp
            )
        }"
    )
    println(
        "T.Altitude (Apparent) Lower    : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htal"
                ), "", sdp
            )
        }"
    )
    println(
        "M.Altitude Lower Limb          : ${
            mf.DDDMS(
                mo.moonTopocentricAltitude(
                    JD,
                    dltT,
                    gLon,
                    gLat,
                    elev,
                    pressure,
                    temperature,
                    "htol"
                ), "", sdp
            )
        }"
    )
    println("T.Relative Altitude            : ${mf.DDDMS(rAltT, "", 0)}")
    println(
        "T.Arah Terbenam Bulan          : ${
            mf.DDDMS(
                mo.moonTopocentricAzimuth(jdMset, dltT, gLon, gLat, elev),
                "",
                sdp
            )
        }"
    )
    println("T.Crescent Width               : ${mf.DDDMS(tCw, "", sdp)}")
    println("Best Time                      : ${mf.DHHMS(bTime, "HH:MM:SS", sdp) + " LT"} ")
    println("Range q Odeh                   : ${mf.RoundTo(qOdeh, 2)}")
}
