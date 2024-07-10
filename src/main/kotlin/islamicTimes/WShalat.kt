package islamicTimes

class WShalat {
    val jd = JulianDay()
    val mf = MathFunction()
    val dt = DynamicalTime()
    val sn = SunDatas()

    fun zuhur(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var zhr: Double

        zhr = 12.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, zhr, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400)
            eoT = sn.equationOfTime(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0
            zhr = 12 - eoT - kwd
        }
        return zhr
    }

    fun ashar(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var dec: Double
        var zm: Double
        var hm: Double
        var tm: Double
        var asr: Double

        asr = 15.0

        for (i in 1..3) {

            JD = jd.KMJD(tglM, blnM, thnM, asr, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400)
            eoT = sn.equationOfTime(jde)
            dec = sn.sunGeocentricDeclination(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0

            zm = Math.abs(gLat - dec)
            hm = mf.Deg(Math.atan(1 / (Math.tan(mf.Rad(zm)) + 1)))
            tm = mf.Deg(
                Math.acos(
                    -Math.tan(mf.Rad(gLat)) * Math.tan(mf.Rad(dec)) + Math.sin(mf.Rad(hm)) / Math.cos(
                        mf.Rad(gLat)
                    ) / Math.cos(mf.Rad(dec))
                )
            )
            asr = (12 - eoT) + tm / 15.0 - kwd
        }
        return asr
    }

    fun maghrib(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        elev: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var dec: Double
        var sd: Double
        var dip: Double
        var hm: Double
        var tm: Double
        var mgr: Double

        mgr = 18.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, mgr, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400.0)
            eoT = sn.equationOfTime(jde)
            dec = sn.sunGeocentricDeclination(jde)
            sd = sn.sunGeocentricSemidiameter(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0

            dip = 1.76 / 60 * Math.sqrt(elev)
            hm = -(sd + 34.5 / 60 + dip)
            tm = mf.Deg(
                Math.acos(
                    -Math.tan(mf.Rad(gLat)) * Math.tan(mf.Rad(dec)) + Math.sin(mf.Rad(hm)) / Math.cos(
                        mf.Rad(gLat)
                    ) / Math.cos(mf.Rad(dec))
                )
            )
            mgr = 12 - eoT + tm / 15.0 - kwd
        }
        return mgr
    }

    fun isya(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var dec: Double
        var hm: Double
        var tm: Double
        var isy: Double

        isy = 19.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, isy, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400.0)
            eoT = sn.equationOfTime(jde)
            dec = sn.sunGeocentricDeclination(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0

            hm = -18.0
            tm = mf.Deg(
                Math.acos(
                    -Math.tan(mf.Rad(gLat)) * Math.tan(mf.Rad(dec)) + Math.sin(mf.Rad(hm)) / Math.cos(
                        mf.Rad(gLat)
                    ) / Math.cos(mf.Rad(dec))
                )
            )
            isy = 12 - eoT + tm / 15.0 - kwd
        }
        return isy
    }

    fun subuh(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var dec: Double
        var hm: Double
        var tm: Double
        var sbh: Double

        sbh = 4.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, sbh, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400.0)
            eoT = sn.equationOfTime(jde)
            dec = sn.sunGeocentricDeclination(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0

            hm = -20.0
            tm = mf.Deg(
                Math.acos(
                    -Math.tan(mf.Rad(gLat)) * Math.tan(mf.Rad(dec)) + Math.sin(mf.Rad(hm)) / Math.cos(
                        mf.Rad(gLat)
                    ) / Math.cos(mf.Rad(dec))
                )
            )
            sbh = 12 - eoT - tm / 15.0 - kwd
        }
        return sbh
    }

    fun syuruk(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        elev: Double,
        tmZn: Double
    ): Double {
        var JD: Double
        var jde: Double
        var kwd: Double
        var eoT: Double
        var dec: Double
        var sd: Double
        var dip: Double
        var hm: Double
        var tm: Double
        var syk: Double

        syk = 6.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, syk, tmZn)
            jde = JD + (dt.DeltaT(JD) / 86400.0)
            eoT = sn.equationOfTime(jde)
            dec = sn.sunGeocentricDeclination(jde)
            sd = sn.sunGeocentricSemidiameter(jde)
            kwd = (gLon - (tmZn * 15.0)) / 15.0

            dip = 1.76 / 60.0 * Math.sqrt(elev)
            hm = -(sd + 34.5 / 60.0 + dip)
            tm = mf.Deg(
                Math.acos(
                    -Math.tan(mf.Rad(gLat)) * Math.tan(mf.Rad(dec)) + Math.sin(mf.Rad(hm)) / Math.cos(
                        mf.Rad(gLat)
                    ) / Math.cos(mf.Rad(dec))
                )
            )
            syk = 12 - eoT - tm / 15.0 - kwd
        }
        return syk
    }

    fun duha(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        elev: Double,
        tmZn: Double
    ): Double {
        val wSyk: Double
        val duh: Double

        wSyk = syuruk(tglM, blnM, thnM, gLon, gLat, elev, tmZn)
        duh = wSyk + 15 / 60.0
        return duh
    }

    fun nisfuLail(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        elev: Double,
        tmZn: Double
    ): Double {
        val wMgb: Double
        val wSbh: Double
        val intr: Double
        val nisf: Double

        wMgb = maghrib(tglM, blnM, thnM, gLon, gLat, elev, tmZn)
        wSbh = subuh(tglM, blnM, thnM, gLon, gLat, tmZn)
        intr = (mf.Mod(wSbh - wMgb, 24.0)) / 2.0
        nisf = wMgb + intr
        return nisf
    }

    fun IhtiyathShalat(
        JamDesWs: Double,
        Ihtiyath: Int
    ): Double {

        val uDHrs: Double
        var uHrs: Double
        val uDMin: Double
        var uMin: Double
        val iht: Double

        uDHrs = JamDesWs
        uHrs = Math.floor(JamDesWs)
        uDMin = (uDHrs - uHrs) * 60.0
        uMin = Math.floor(uDMin) + Ihtiyath

        if (uMin == 60.0) {
            uMin = 0.0
            uHrs = uHrs + 1.0
        } else {
        }
        iht = uHrs + uMin / 60
        return iht
    }
}