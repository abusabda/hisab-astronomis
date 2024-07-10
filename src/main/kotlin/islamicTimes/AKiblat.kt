package islamicTimes

class AKiblat {

    val jd = JulianDay()
    val mf = MathFunction()
    val dt = DynamicalTime()
    val sn = SunDatas()

    fun arahQiblatSpherical(
        gLon: Double,
        gLat: Double
    ): Double {
        val gLatKabah: Double = 21.0 + 25.0 / 60.0 + 21.02 / 3600.0
        val gLonKabah: Double = 39.0 + 49.0 / 60.0 + 34.27 / 3600.0

        val a: Double = (90.0 - gLat)
        val b: Double = (90.0 - gLatKabah)
        val c: Double = (gLon - gLonKabah)

        val sB: Double = Math.sin(mf.Rad(b)) * Math.sin(mf.Rad(c))
        val cB: Double =
            Math.cos(mf.Rad(b)) * Math.sin(mf.Rad(a)) - Math.cos(mf.Rad(a)) * Math.sin(mf.Rad(b)) * Math.cos(mf.Rad(c))
        val bB: Double = mf.Deg(Math.atan2(sB, cB))
        val azQ: Double = mf.Mod((360.0 - bB), 360.0)
        return azQ
    }

    fun arahQiblaWithEllipsoidCorrection(
        gLon: Double,
        gLat: Double
    ): Double {
        val gLatKabah = 21.0 + 25.0 / 60.0 + 21.02 / 3600.0
        val gLonKabah = 39.0 + 49.0 / 60.0 + 34.27 / 3600.0

        val e = 0.0066943800229
        val gLatKprime: Double = mf.Deg(Math.atan((1 - e) * Math.tan(mf.Rad(gLatKabah))))
        val gLatPprime: Double = mf.Deg(Math.atan((1 - e) * Math.tan(mf.Rad(gLat))))

        val a: Double = (90.0 - gLatPprime)
        val b: Double = (90.0 - gLatKprime)
        val c: Double = (gLon - gLonKabah)

        val sB: Double = Math.sin(mf.Rad(b)) * Math.sin(mf.Rad(c))
        val cB: Double =
            Math.cos(mf.Rad(b)) * Math.sin(mf.Rad(a)) - Math.cos(mf.Rad(a)) * Math.sin(mf.Rad(b)) * Math.cos(mf.Rad(c))
        val bB: Double = mf.Deg(Math.atan2(sB, cB))
        val azQ: Double = mf.Mod((360.0 - bB), 360.0)
        return azQ
    }

    fun ArahQiblaVincenty(
        gLon: Double,
        gLat: Double,
        OptResult: String
    ): Double {
        var c: Double
        var c2SigmaM: Double
        var sigma: Double
        var sAlpha: Double
        var c2Alpha: Double
        var lambda0: Double
        var lambda: Double
        var sSigma: Double
        var cSigma: Double
        var iterlimit: Double

        val gLatKabah: Double = 21 + 25 / 60.0 + 21.02 / 3600.0
        val gLonKabah: Double = 39 + 49 / 60.0 + 34.27 / 3600.0

        val f = 1.0 / 298.257223563
        val ae = 6378137.000000000
        val be = 6356752.314245180

        val u1: Double = Math.atan((1 - f) * Math.tan(mf.Rad(gLatKabah)))
        val u2: Double = Math.atan((1 - f) * Math.tan(mf.Rad(gLat)))
        val l0: Double = mf.Rad(gLon - gLonKabah)
        iterlimit = 0.0
        lambda = l0
        do {
            iterlimit++
            lambda0 = lambda
            cSigma = Math.sin(u1) * Math.sin(u2) + Math.cos(u1) * Math.cos(u2) * Math.cos(lambda)
            sSigma = Math.sqrt(
                Math.pow(
                    (Math.cos(u2) * Math.sin(lambda)),
                    2.0
                ) + Math.pow((Math.cos(u1) * Math.sin(u2) - Math.sin(u1) * Math.cos(u2) * Math.cos(lambda)), 2.0)
            )
            sigma = Math.atan2(sSigma, cSigma)
            sAlpha = Math.cos(u1) * Math.cos(u2) * Math.sin(lambda) / sSigma
            c2Alpha = 1.0 - Math.pow(sAlpha, 2.0)
            c2SigmaM = cSigma - 2.0 * Math.sin(u1) * Math.sin(u2) / c2Alpha
            c = f / 16.0 * c2Alpha * (4.0 + f * (4.0 - 3.0 * c2Alpha))
            lambda =
                l0 + (1.0 - c) * f * sAlpha * (sigma + c * sSigma * (c2SigmaM + c * cSigma * (-1.0 + 2.0 * Math.pow(
                    c2SigmaM,
                    2.0
                ))))

        } while (Math.abs(lambda - lambda0) > 0.000000000001 || iterlimit < 100.0)

        //Arah dari tempat ke Kiblat dan sebaliknya

        val alpha1: Double = Math.atan2(
            Math.cos(u2) * Math.sin(lambda),
            Math.cos(u1) * Math.sin(u2) - Math.sin(u1) * Math.cos(u2) * Math.cos(lambda)
        )
        val alpha2: Double = Math.atan2(
            Math.cos(u1) * Math.sin(lambda),
            -Math.sin(u1) * Math.cos(u2) + Math.cos(u1) * Math.sin(u2) * Math.cos(lambda)
        )

        //jarak dari tempat ke Kiblat
        val up2: Double = c2Alpha * (Math.pow(ae, 2.0) - Math.pow(be, 2.0)) / Math.pow(be, 2.0)
        val a: Double = 1 + up2 / 16384 * (4096 + up2 * (-768 + up2 * (320 - 175 * up2)))
        val b: Double = up2 / 1024 * (256 + up2 * (-128 + up2 * (74 - 47 * up2)))

        val dSigma: Double =
            b * sSigma * (c2SigmaM + 0.25 * b * (cSigma * (-1 + 2 * Math.pow(c2SigmaM, 2.0)) - 1 / 6 * b * c2SigmaM *
                    (-3 + 4 * Math.pow(sSigma, 2.0)) * (-3 + 4 * Math.pow(c2SigmaM, 2.0))))
        val s: Double = be * a * (sigma - dSigma)

        return when (OptResult) {
            "PtoQ" -> mf.Mod(180 + mf.Deg(alpha2), 360.0)
            "QtoP" -> mf.Mod(mf.Deg(alpha1), 360.0)
            "Dist" -> s
            else -> mf.Mod(180 + mf.Deg(alpha2), 360.0)
        }
    }

    fun bayanganQiblatHarian(
        gLon: Double,
        gLat: Double,
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        tmZn: Double,
        optional: Int
    ): Double {
        var JD: Double
        var jde: Double
        var dm: Double
        var e: Double
        var azQ: Double
        var b: Double
        var p: Double
        var ca: Double
        var bq: Double

        bq = 12.0

        for (i in 1..3) {
            JD = jd.KMJD(tglM, blnM, thnM, bq, tmZn)
            jde = JD + dt.DeltaT(JD) / 86400.0
            dm = sn.sunGeocentricDeclination(jde)
            e = sn.equationOfTime(jde)
            azQ = arahQiblatSpherical(gLon, gLat)
            b = 90 - gLat
            p = mf.Deg(Math.atan(1 / (Math.cos(mf.Rad(b)) * Math.tan(mf.Rad(azQ)))))
            ca = mf.Deg(Math.acos(Math.tan(mf.Rad(dm)) * Math.tan(mf.Rad(b)) * Math.cos(mf.Rad(p))))
            bq = when (optional) {
                1 -> mf.Mod(-(p - ca) / 15 + (12 - e) + ((tmZn * 15) - gLon) / 15, 24.0)
                2 -> mf.Mod(-(p + ca) / 15 + (12 - e) + ((tmZn * 15) - gLon) / 15, 24.0)
                else -> 0.0
            }
        }

        return mf.Mod(bq, 24.0)
    }

    fun jarakQiblatSpherical(
        gLon: Double,
        gLat: Double
    ): Double {
        val gLonK: Double = (39.0 + 49.0 / 60.0 + 34.27 / 3600.0)
        val gLatK: Double = (21.0 + 25.0 / 60.0 + 21.02 / 3600.0)
        val d: Double = mf.Deg(
            Math.acos(
                Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(gLatK)) + Math.cos(mf.Rad(gLat)) * Math.cos(
                    mf.Rad(gLatK)
                ) * Math.cos(mf.Rad(gLonK - gLon))
            )
        )
        val s: Double = 6378.137 * d / 57.2957795
        return s
    }

    fun jarakQiblatEllipsoid(
        gLon: Double,
        gLat: Double
    ): Double {
        val pi = 3.14159265358979

        val u: Double = ((21.0 + 25.0 / 60.0 + 21.02 / 3600.0) + gLat) / 2.0
        val g: Double = ((21.0 + 25.0 / 60.0 + 21.02 / 3600.0) - gLat) / 2.0
        val j: Double = ((39.0 + 49.0 / 60.0 + 34.27 / 3600.0) - gLon) / 2.0
        val m: Double = Math.pow((Math.sin(mf.Rad(g))), 2.0) * Math.pow(
            (Math.cos(mf.Rad(j))),
            2.0
        ) + Math.pow((Math.cos(mf.Rad(u))), 2.0) * Math.pow((Math.sin(mf.Rad(j))), 2.0)
        val n: Double = Math.pow((Math.cos(mf.Rad(g))), 2.0) * Math.pow(
            (Math.cos(mf.Rad(j))),
            2.0
        ) + Math.pow((Math.sin(mf.Rad(u))), 2.0) * Math.pow((Math.sin(mf.Rad(j))), 2.0)
        val w: Double = Math.atan(Math.sqrt(m / n))
        val p: Double = (Math.sqrt(m * n)) / w
        val d: Double = mf.Deg(((2 * w) * 6378.137) / (180.0 / pi))
        val e1: Double = ((3 * p) - 1) / (2 * n)
        val e2: Double = ((3 * p) + 1) / (2 * m)
        val f: Double = 1 / 298.25722
        val s: Double =
            d * (1 + f * e1 * Math.sin(mf.Rad(u)) * Math.sin(mf.Rad(u)) * Math.cos(mf.Rad(g)) * Math.cos(mf.Rad(g)) - f * e2 * Math.cos(
                mf.Rad(u)
            ) * Math.cos(mf.Rad(u)) * Math.sin(mf.Rad(g)) * Math.sin(mf.Rad(g)))
        return s
    }

    fun RashdulQiblat(
        thnM: Long,
        TmZn: Double,
        Opt: Int
    ): String {
        val gLatK: Double = (21.0 + 25.0 / 60.0 + 21.02 / 3600.0)
        val gLonK: Double = (39.0 + 49.0 / 60.0 + 34.27 / 3600.0)
        val TmZnK: Double = 3.0

        var jd01: Double
        var jd02: Double
        var jd03: Double
        var jde1: Double
        var jde2: Double
        var jde3: Double
        var eoT1: Double
        var eoT2: Double
        var eoT3: Double
        var trs1: Double
        var trs2: Double
        var trs3: Double
        var JD: Double

        JD = 0.0
        trs1 = 12.00
        trs2 = 12.00
        trs3 = 12.00

        blnM@ for (n in 1..12) {
            tglM@ for (i in 1..31) {
                for (z in 1..3) {
                    jd01 = jd.KMJD((i + 0).toByte(), n.toByte(), thnM, trs1, TmZnK)
                    jde1 = jd01 + (dt.DeltaT(jd01) / 86400.0)
                    eoT1 = sn.equationOfTime(jde1)
                    trs1 = 12 - eoT1 - (gLonK - (TmZnK * 15)) / 15
                    jd02 = jd.KMJD((i + 1).toByte(), n.toByte(), thnM, trs2, TmZnK)
                    jde2 = jd02 + (dt.DeltaT(jd02) / 86400.0)
                    eoT2 = sn.equationOfTime(jde2)
                    trs2 = 12 - eoT2 - (gLonK - (TmZnK * 15)) / 15
                    jd03 = jd.KMJD((i + 2).toByte(), n.toByte(), thnM, trs3, TmZnK)
                    jde3 = jd03 + (dt.DeltaT(jd03) / 86400.0)
                    eoT3 = sn.equationOfTime(jde3)
                    trs3 = 12 - eoT3 - (gLonK - (TmZnK * 15)) / 15
                }

                val jd1: Double = jd.KMJD((i + 0).toByte(), n.toByte(), thnM, trs1, TmZnK)
                val jd2: Double = jd.KMJD((i + 1).toByte(), n.toByte(), thnM, trs2, TmZnK)
                val jd3: Double = jd.KMJD((i + 2).toByte(), n.toByte(), thnM, trs3, TmZnK)

                val dS01: Double = sn.sunGeocentricDeclination(jd1 + (dt.DeltaT(jd1) / 86400.0))
                val dS02: Double = sn.sunGeocentricDeclination(jd2 + (dt.DeltaT(jd2) / 86400.0))
                val dS03: Double = sn.sunGeocentricDeclination(jd3 + (dt.DeltaT(jd3) / 86400.0))

                val dlt1: Double = Math.abs(gLatK - dS01)
                val dlt2: Double = Math.abs(gLatK - dS02)
                val dlt3: Double = Math.abs(gLatK - dS03)

                if ((dlt1 > dlt2) && (dlt2 < dlt3)) {
                    JD = jd2

                    when (Opt) {
                        1 -> break@blnM
                        2 -> continue@blnM
                    }
                }
            }
        }
        val dm = sn.sunGeocentricDeclination(JD)
        val h = (90.0 - Math.abs(gLatK - dm))

        return jd.JDKM(JD, TmZn) + ", Jam: " + mf.DHHM(
            jd.JDKM(JD, TmZn, "JAM DES").toDouble(),
            "HH:MM",
            0
        ) + ", Tinggi: " + mf.RoundTo(h, 2) + "°, " + "Deklinasi: " + mf.DDDMS(dm, "DDMMSS", 0)
    }

    fun AntipodaKabah(
        thnM: Long,
        TmZn: Double,
        Opt: Int
    ): String {
        val gLatK: Double = -(21.0 + 25.0 / 60.0 + 21.02 / 3600.0)
        val gLonK: Double = (39.0 + 49.0 / 60.0 + 34.27 / 3600.0)
        val TmZnK: Double = 3.0

        var jd01: Double
        var jd02: Double
        var jd03: Double
        var jde1: Double
        var jde2: Double
        var jde3: Double
        var eoT1: Double
        var eoT2: Double
        var eoT3: Double
        var trs1: Double
        var trs2: Double
        var trs3: Double
        var JD: Double

        JD = 0.0
        trs1 = 24.00
        trs2 = 24.00
        trs3 = 24.00

        blnM@ for (n in 1..12) {
            tglM@ for (i in 1..31) {
                for (z in 1..3) {
                    jd01 = jd.KMJD((i + 0).toByte(), n.toByte(), thnM, trs1, TmZnK)
                    jde1 = jd01 + (dt.DeltaT(jd01) / 86400.0)
                    eoT1 = sn.equationOfTime(jde1)
                    trs1 = 24 - eoT1 - (gLonK - (TmZnK * 15)) / 15.0
                    jd02 = jd.KMJD((i + 1).toByte(), n.toByte(), thnM, trs2, TmZnK)
                    jde2 = jd02 + (dt.DeltaT(jd02) / 86400.0)
                    eoT2 = sn.equationOfTime(jde2)
                    trs2 = 24 - eoT2 - (gLonK - (TmZnK * 15)) / 15.0
                    jd03 = jd.KMJD((i + 2).toByte(), n.toByte(), thnM, trs3, TmZnK)
                    jde3 = jd03 + (dt.DeltaT(jd03) / 86400.0)
                    eoT3 = sn.equationOfTime(jde3)
                    trs3 = 24 - eoT3 - (gLonK - (TmZnK * 15)) / 15.0
                }

                val jd1 = jd.KMJD((i + 0).toByte(), n.toByte(), thnM, trs1, TmZnK)
                val jd2 = jd.KMJD((i + 1).toByte(), n.toByte(), thnM, trs2, TmZnK)
                val jd3 = jd.KMJD((i + 2).toByte(), n.toByte(), thnM, trs3, TmZnK)

                val dS01 = sn.sunGeocentricDeclination(jd1 + (dt.DeltaT(jd1) / 86400.0))
                val dS02 = sn.sunGeocentricDeclination(jd2 + (dt.DeltaT(jd2) / 86400.0))
                val dS03 = sn.sunGeocentricDeclination(jd3 + (dt.DeltaT(jd3) / 86400.0))

                val dlt1 = Math.abs(gLatK - dS01)
                val dlt2 = Math.abs(gLatK - dS02)
                val dlt3 = Math.abs(gLatK - dS03)

                if ((dlt1 > dlt2) && (dlt2 < dlt3)) {
                    JD = jd2

                    when (Opt) {
                        1 -> break@blnM
                        2 -> continue@blnM
                    }
                }
            }
        }
        val dm = sn.sunGeocentricDeclination(JD)
        val h = (180.0 - Math.abs(gLatK - dm))

        return jd.JDKM(JD, TmZn) + ", Jam: " + mf.DHHM(
            jd.JDKM(JD, TmZn, "JAM DES").toDouble(),
            "HH:MM",
            0
        ) + ", Tinggi: " + mf.RoundTo(h, 2) + "°, " + "Deklinasi: " + mf.DDDMS(dm, "DDMMSS", 0)
    }
}