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
    val nmL: String = "Lhok Nga"
    val blnH: Byte = 9
    val thnH: Long = 1445
    val gLon: Double = (95 + 14 / 60.0 + 32.4 / 3600.0) //sumber BMKG
    val gLat: Double = (5 + 28 / 60.0) //sumber BMKG
    val timeZone: Double = 7.0
    val elev: Double = 10.0
    val pressure: Double = 1010.0
    val temperature: Double = 10.0
    val sdp: Byte = 0
    val tbhHari: Byte = 0
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
    jdNM2 = mo.geocentricConjunction(blnH, thnH, dltT, "Ijtima")
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
    val tHilal2: Double = mo.moonTopocentricAltitude(JD, dltT, gLon, gLat, elev, pressure, temperature, "htoc")
    val elong02: Double = mo.moonSunTopocentricElongation(JD, dltT, gLon, gLat, elev)

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
        iR01 = 1
        iRP1 = "sudah bisa dilihat"
    } else {
        iR01 = 2
        iRP1 = "belum bisa dilihat"
    }
    iRP2 = if (tHilal2 >= 3.0 && elong02 >= 6.4) {
        "sudah bisa dilihat"
    } else {
        "belum bisa dilihat"
    }

    //Wujudul Hilal Muhamadiyah
    if (tHilal1 > 0.0) {
        wH01 = 1
        wHM1 = "Wujud"
    } else {
        wH01 = 2
        wHM1 = "Belum Wujud"
    }
    wHM2 = if (tHilal2 > 0.0) {
        "Wujud"
    } else {
        "Belum Wujud"
    }

    //Tambah Hari
    if (tbhHari > 0 || tbhHari < 0) {
        visb = iRP2
        wh = wHM2
    } else {
        visb = iRP1
        wh = wHM1
    }

    //Tampilkan pilihan Kriteria dan hasil akhir kriteria
    if (optional == 1) {
        abq = ((Math.floor(jdNM2 + 0.5 + timeZone / 24.0)) - timeZone / 24.0) + iR01
        kr = visb
        kr1 = "Imkan Rukyat"
    } else {
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
    println("Data menjelang awal ${NmBlnH + " " + thnH} H")
    println(
        "Ijtimak Goesentris terjadi pada ${
            jd.JDKM(jdNM2, timeZone) + " Jam " + mf.DHHMS(
                jd.JDKM(
                    jdNM2,
                    timeZone,
                    "Jam D"
                ).toDouble(), "", sdp
            )
        } LT"
    )
    println(
        "Tinggi hilal ${
            mf.DDDMS2(
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
            ) + ", Beda Tinggi Bulan-Matahari ${mf.DDDMS2(rAltT, "", 0)}"
        }."
    )
    println(
        "Elongasi Geosentris ${
            mf.DDDMS2(
                mo.moonSunGeocentricElongation(JD, dltT),
                "",
                sdp
            ) + ", Elongasi Toposentris ${
                mf.DDDMS2(
                    mo.moonSunTopocentricElongation(JD, dltT, gLon, gLat, elev),
                    "",
                    sdp
                )
            }"
        }."
    )
    println("Saat Maghrib ${jd.JDKM(jdNM2, timeZone) + ", secara hisab hilal $kr"}.")
    println("Maka 1 ${NmBlnH + " " + thnH} H" + " secara hisab ditetapkan ${jd.JDKM(abq, timeZone)}.")
}
