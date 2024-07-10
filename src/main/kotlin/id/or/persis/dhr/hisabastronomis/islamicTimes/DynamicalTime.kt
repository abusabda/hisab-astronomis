package id.or.persis.dhr.hisabastronomis.islamicTimes

class DynamicalTime {
    // Delta T
    fun DeltaT(
        JD: Double
    ): Double {
        val TlM: Long
        val JDTlMAw: Double
        val JDTlMAk: Double
        val JHrlTlM: Double
        val JHrTlM: Double
        val dY: Double
        val kU: Double
        var dltT: Double
        val sCorr: Double

        val jd = JulianDay()

        //Rumus Desimal Years 2
        TlM = ((jd.JDKM(JD, 0.0, "ThnM"))).toLong()
        JDTlMAw = jd.KMJD(1, 1, TlM, 0.0, 0.0)
        JDTlMAk = jd.KMJD(31, 12, TlM, 24.0, 0.0)
        JHrlTlM = JD - JDTlMAw
        JHrTlM = JDTlMAk - JDTlMAw

        dY = TlM + JHrlTlM / JHrTlM

        if (dY <= -500) {
            kU = (dY - 1820) / 100
            dltT = -20 + 32 * (kU * kU)
        } else if ((dY > -500) && (dY <= 500)) {
            kU = dY / 100
            dltT =
                10583.6 - 1014.41 * kU + 33.78311 * (kU * kU) - 5.952053 * (kU * kU * kU) - 0.1798452 * (kU * kU * kU * kU) + 0.022174192 * (kU * kU * kU * kU * kU) + 0.0090316521 * (kU * kU * kU * kU * kU * kU)
        } else if ((dY > 500) && (dY <= 1600)) {
            kU = (dY - 1000) / 100
            dltT =
                1574.2 - 556.01 * kU + 71.23472 * (kU * kU) + 0.319781 * (kU * kU * kU) - 0.8503463 * (kU * kU * kU * kU) - 0.005050998 * (kU * kU * kU * kU * kU) + 0.0083572073 * (kU * kU * kU * kU * kU * kU)
        } else if ((dY > 1600) && (dY <= 1700)) {
            kU = (dY - 1600) / 100
            dltT = 120 - 98.08 * kU - 153.2 * (kU * kU) + (kU * kU * kU) / 0.007129
        } else if ((dY > 1700) && (dY <= 1800)) {
            kU = (dY - 1700) / 100
            dltT = 8.83 + 16.03 * kU - 59.285 * (kU * kU) + 133.36 * (kU * kU * kU) - (kU * kU * kU * kU) / 0.01174
        } else if ((dY > 1800) && (dY <= 1860)) {
            kU = (dY - 1800) / 100
            dltT =
                13.72 - 33.2447 * kU + 68.612 * (kU * kU) + 4111.6 * (kU * kU * kU) - 37436 * (kU * kU * kU * kU) + 121272 * (kU * kU * kU * kU * kU) - 1699000 * (kU * kU * kU * kU * kU * kU) + 87500 * (kU * kU * kU * kU * kU * kU * kU)
        } else if ((dY > 1860) && (dY <= 1900)) {
            kU = (dY - 1860) / 100
            dltT =
                7.62 + 57.37 * kU - 2517.54 * (kU * kU) + 16806.68 * (kU * kU * kU) - 44736.24 * (kU * kU * kU * kU) + (kU * kU * kU * kU * kU) / 0.00000233174
        } else if ((dY > 1900) && (dY <= 1920)) {
            kU = (dY - 1900) / 100
            dltT = -2.79 + 149.4119 * kU - 598.939 * (kU * kU) + 6196.6 * (kU * kU * kU) - 19700 * (kU * kU * kU * kU)
        } else if ((dY > 1920) && (dY <= 1941)) {
            kU = (dY - 1920) / 100
            dltT = 21.20 + 84.493 * kU - 761.00 * (kU * kU) + 2093.6 * (kU * kU * kU)
        } else if ((dY > 1941) && (dY <= 1961)) {
            kU = (dY - 1950) / 100
            dltT = 29.07 + 40.7 * kU - (kU * kU) / 0.0233 + (kU * kU * kU) / 0.002547
        } else if ((dY > 1961) && (dY <= 1986)) {
            kU = (dY - 1975) / 100
            dltT = 45.45 + 106.7 * kU - (kU * kU) / 0.026 - (kU * kU * kU) / 0.000718
        } else if ((dY > 1986) && (dY <= 2005)) {
            kU = (dY - 2000) / 100
            dltT =
                63.86 + 33.45 * kU - 603.74 * (kU * kU) + 1727.5 * (kU * kU * kU) + 65181.4 * (kU * kU * kU * kU) + 237359.9 * (kU * kU * kU * kU * kU)
        } else if ((dY > 2005) && (dY <= 2015)) { //'Tambahan
            kU = dY - 2005
            dltT = 64.69 + 0.293 * kU
        } else if ((dY > 2015) && (dY <= 3000)) { //Tambahan
            kU = dY - 2015
            dltT = 67.62 + 0.3645 * kU + 0.0039755 * (kU * kU)
        } else {
            dltT = 0.0 // biar tidak error harus ada else tanpa if
        }

        if (dY < 1955 || dY > 2005) {
            sCorr = -0.000012932 * Math.pow((dY - 1955), 2.0)
            dltT = dltT + sCorr
        } else {
            sCorr = 0.0
        }



        return dltT
    }

    // Delta T
    fun DeltaT2(
        JD: Double
    ): Double {
        val jd = JulianDay()
        var dltT: Double
        val sCorr: Double
        var kU: Double

        //Rumus Desimal Years 1
        val thnM = jd.JDKM(JD, 0.0, "ThnM").toLong()
        val blnM = jd.JDKM(JD, 0.0, "BlnM").toInt()
        val dY = thnM + (blnM - 0.5) / 12

        if (dY <= -500) {
            kU = (dY - 1820) / 100
            dltT = -20 + 32 * (kU * kU)
        } else if ((dY > -500) && (dY <= 500)) {
            kU = dY / 100
            dltT =
                10583.6 - 1014.41 * kU + 33.78311 * (kU * kU) - 5.952053 * (kU * kU * kU) - 0.1798452 * (kU * kU * kU * kU) + 0.022174192 * (kU * kU * kU * kU * kU) + 0.0090316521 * (kU * kU * kU * kU * kU * kU)
        } else if ((dY > 500) && (dY <= 1600)) {
            kU = (dY - 1000) / 100
            dltT =
                1574.2 - 556.01 * kU + 71.23472 * (kU * kU) + 0.319781 * (kU * kU * kU) - 0.8503463 * (kU * kU * kU * kU) - 0.005050998 * (kU * kU * kU * kU * kU) + 0.0083572073 * (kU * kU * kU * kU * kU * kU)
        } else if ((dY > 1600) && (dY <= 1700)) {
            kU = (dY - 1600) / 100
            dltT = 120 - 98.08 * kU - 153.2 * (kU * kU) + (kU * kU * kU) / 0.007129
        } else if ((dY > 1700) && (dY <= 1800)) {
            kU = (dY - 1700) / 100
            dltT = 8.83 + 16.03 * kU - 59.285 * (kU * kU) + 133.36 * (kU * kU * kU) - (kU * kU * kU * kU) / 0.01174
        } else if ((dY > 1800) && (dY <= 1860)) {
            kU = (dY - 1800) / 100
            dltT =
                13.72 - 33.2447 * kU + 68.612 * (kU * kU) + 4111.6 * (kU * kU * kU) - 37436 * (kU * kU * kU * kU) + 121272 * (kU * kU * kU * kU * kU) - 1699000 * (kU * kU * kU * kU * kU * kU) + 87500 * (kU * kU * kU * kU * kU * kU * kU)
        } else if ((dY > 1860) && (dY <= 1900)) {
            kU = (dY - 1860) / 100
            dltT =
                7.62 + 57.37 * kU - 2517.54 * (kU * kU) + 16806.68 * (kU * kU * kU) - 44736.24 * (kU * kU * kU * kU) + (kU * kU * kU * kU * kU) / 0.00000233174
        } else if ((dY > 1900) && (dY <= 1920)) {
            kU = (dY - 1900) / 100
            dltT = -2.79 + 149.4119 * kU - 598.939 * (kU * kU) + 6196.6 * (kU * kU * kU) - 19700 * (kU * kU * kU * kU)
        } else if ((dY > 1920) && (dY <= 1941)) {
            kU = (dY - 1920) / 100
            dltT = 21.20 + 84.493 * kU - 761.00 * (kU * kU) + 2093.6 * (kU * kU * kU)
        } else if ((dY > 1941) && (dY <= 1961)) {
            kU = (dY - 1950) / 100
            dltT = 29.07 + 40.7 * kU - (kU * kU) / 0.0233 + (kU * kU * kU) / 0.002547
        } else if ((dY > 1961) && (dY <= 1986)) {
            kU = (dY - 1975) / 100
            dltT = 45.45 + 106.7 * kU - (kU * kU) / 0.026 - (kU * kU * kU) / 0.000718
        } else if ((dY > 1986) && (dY <= 2005)) {
            kU = (dY - 2000) / 100
            dltT =
                63.86 + 33.45 * kU - 603.74 * (kU * kU) + 1727.5 * (kU * kU * kU) + 65181.4 * (kU * kU * kU * kU) + 237359.9 * (kU * kU * kU * kU * kU)
        } else if ((dY > 2005) && (dY <= 2015)) { //'Tambahan
            kU = dY - 2005
            dltT = 64.69 + 0.293 * kU
        } else if ((dY > 2015) && (dY <= 3000)) { //Tambahan
            kU = dY - 2015
            dltT = 67.62 + 0.3645 * kU + 0.0039755 * (kU * kU)
        } else {
            dltT = 0.0 // biar tidak error harus ada else tanpa if
        }

        return dltT
    }

    fun JDE(
        JD: Double,
        DeltaT: Double = 0.0
    ): Double {
        val JD = JD
        val DeltaT = DeltaT
        val JDE = (JD + DeltaT / 86400.0)

        return JDE
    }

    fun JC(
        JD: Double
    ): Double {
        val T: Double = (JD - 2451545) / 36525
        return T
    }

    fun JCE(
        JDE: Double
    ): Double {
        val T: Double = (JDE - 2451545) / 36525
        return T
    }

    fun JM(
        JC: Double
    ): Double {
        val Tau: Double = JC / 10.0
        return Tau
    }

    fun JME(
        JCE: Double
    ): Double {
        val Tau: Double = JCE / 10.0
        return Tau
    }

}

