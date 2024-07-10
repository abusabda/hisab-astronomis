package id.or.persis.dhr.hisabastronomis.islamicTimes

class MoonLatitude {
    val jd = JulianDay()
    val B001 = MoonDataB001()
    val B002 = MoonDataB002()
    val B003 = MoonDataB003()
    val B004 = MoonDataB004()
    val B005 = MoonDataB005()
    val B006 = MoonDataB006()
    val B007 = MoonDataB007()
    val B008 = MoonDataB008()

    val B101 = MoonDataB101()
    val B201 = MoonDataB201()

    val mf = MathFunction()

    fun moonGeocentricLatitude(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val t1: Double = Math.pow(t, 1.0)
        val t2: Double = Math.pow(t, 2.0)
        val t3: Double = Math.pow(t, 3.0)
        val t4: Double = Math.pow(t, 4.0)

        var aa = 0
        var B001sum = 0.0
        while (aa < 1000) {
            B001sum += B001.ELPMPP02_MT_B0[aa][0] *
                    Math.sin(
                        B001.ELPMPP02_MT_B0[aa][1] +
                                B001.ELPMPP02_MT_B0[aa][2] * t1 +
                                B001.ELPMPP02_MT_B0[aa][3] * t2 +
                                B001.ELPMPP02_MT_B0[aa][4] * t3 +
                                B001.ELPMPP02_MT_B0[aa][5] * t4
                    )
            aa++
        }

        var bb = 0
        var B002sum = 0.0
        while (bb < 1000) {
            B002sum += B002.ELPMPP02_MT_B0[bb][0] *
                    Math.sin(
                        B002.ELPMPP02_MT_B0[bb][1] +
                                B002.ELPMPP02_MT_B0[bb][2] * t1 +
                                B002.ELPMPP02_MT_B0[bb][3] * t2 +
                                B002.ELPMPP02_MT_B0[bb][4] * t3 +
                                B002.ELPMPP02_MT_B0[bb][5] * t4
                    )
            bb++

        }

        var cc = 0
        var B003sum = 0.0
        while (cc < 1000) {
            B003sum += B003.ELPMPP02_MT_B0[cc][0] *
                    Math.sin(
                        B003.ELPMPP02_MT_B0[cc][1] +
                                B003.ELPMPP02_MT_B0[cc][2] * t1 +
                                B003.ELPMPP02_MT_B0[cc][3] * t2 +
                                B003.ELPMPP02_MT_B0[cc][4] * t3 +
                                B003.ELPMPP02_MT_B0[cc][5] * t4
                    )
            cc++
        }

        var dd = 0
        var B004sum = 0.0
        while (dd < 1000) {
            B004sum += B004.ELPMPP02_MT_B0[dd][0] *
                    Math.sin(
                        B004.ELPMPP02_MT_B0[dd][1] +
                                B004.ELPMPP02_MT_B0[dd][2] * t1 +
                                B004.ELPMPP02_MT_B0[dd][3] * t2 +
                                B004.ELPMPP02_MT_B0[dd][4] * t3 +
                                B004.ELPMPP02_MT_B0[dd][5] * t4
                    )
            dd++
        }

        var ee = 0
        var B005sum = 0.0
        while (ee < 1000) {
            B005sum += B005.ELPMPP02_MT_B0[ee][0] *
                    Math.sin(
                        B005.ELPMPP02_MT_B0[ee][1] +
                                B005.ELPMPP02_MT_B0[ee][2] * t1 +
                                B005.ELPMPP02_MT_B0[ee][3] * t2 +
                                B005.ELPMPP02_MT_B0[ee][4] * t3 +
                                B005.ELPMPP02_MT_B0[ee][5] * t4
                    )
            ee++
        }


        var ff = 0
        var B006sum = 0.0
        while (ff < 1000) {
            B006sum += B006.ELPMPP02_MT_B0[ff][0] *
                    Math.sin(
                        B006.ELPMPP02_MT_B0[ff][1] +
                                B006.ELPMPP02_MT_B0[ff][2] * t1 +
                                B006.ELPMPP02_MT_B0[ff][3] * t2 +
                                B006.ELPMPP02_MT_B0[ff][4] * t3 +
                                B006.ELPMPP02_MT_B0[ff][5] * t4
                    )
            ff++
        }

        var gg = 0
        var B007sum = 0.0
        while (gg < 1000) {
            B007sum += B007.ELPMPP02_MT_B0[gg][0] *
                    Math.sin(
                        B007.ELPMPP02_MT_B0[gg][1] +
                                B007.ELPMPP02_MT_B0[gg][2] * t1 +
                                B007.ELPMPP02_MT_B0[gg][3] * t2 +
                                B007.ELPMPP02_MT_B0[gg][4] * t3 +
                                B007.ELPMPP02_MT_B0[gg][5] * t4
                    )
            gg++
        }

        var hh = 0
        var B008sum = 0.0
        while (hh < 380) {
            B008sum += B008.ELPMPP02_MT_B0[hh][0] *
                    Math.sin(
                        B008.ELPMPP02_MT_B0[hh][1] +
                                B008.ELPMPP02_MT_B0[hh][2] * t1 +
                                B008.ELPMPP02_MT_B0[hh][3] * t2 +
                                B008.ELPMPP02_MT_B0[hh][4] * t3 +
                                B008.ELPMPP02_MT_B0[hh][5] * t4
                    )
            hh++
        }

        var ii = 0
        var B101sum = 0.0
        while (ii < 516) {
            B101sum += B101.ELPMPP02_MT_B1[ii][0] *
                    Math.sin(
                        B101.ELPMPP02_MT_B1[ii][1] +
                                B101.ELPMPP02_MT_B1[ii][2] * t1 +
                                B101.ELPMPP02_MT_B1[ii][3] * t2 +
                                B101.ELPMPP02_MT_B1[ii][4] * t3 +
                                B101.ELPMPP02_MT_B1[ii][5] * t4
                    )
            ii++
        }

        var jj = 0
        var B201sum = 0.0
        while (jj < 52) {
            B201sum += B201.ELPMPP02_MT_B2[jj][0] *
                    Math.sin(
                        B201.ELPMPP02_MT_B2[jj][1] +
                                B201.ELPMPP02_MT_B2[jj][2] * t1 +
                                B201.ELPMPP02_MT_B2[jj][3] * t2 +
                                B201.ELPMPP02_MT_B2[jj][4] * t3 +
                                B201.ELPMPP02_MT_B2[jj][5] * t4
                    )
            jj++
        }

        val b0: Double = B001sum + B002sum + B003sum + B004sum + B005sum + B006sum + B007sum + B008sum//7380term
        val b1: Double = B101sum //516term
        val b2: Double = B201sum //52term

        val b: Double = b0 + b1 * t1 + b2 * t2 //7948term

        val abr: Double = -0.00001754 * Math.sin(mf.Rad(183.3 + 483202.0 * t))

        //MoonGeocentricEclipticLatitude
        val moonLat: Double = b / 3600.0 + abr

        return moonLat

    }
}
