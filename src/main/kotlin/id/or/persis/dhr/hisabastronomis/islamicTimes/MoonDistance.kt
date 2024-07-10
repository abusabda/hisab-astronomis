package id.or.persis.dhr.hisabastronomis.islamicTimes

class MoonDistance {
    val jd = JulianDay()
    val R001 = MoonDataR001()
    val R002 = MoonDataR002()
    val R003 = MoonDataR003()
    val R004 = MoonDataR004()
    val R005 = MoonDataR005()
    val R006 = MoonDataR006()
    val R007 = MoonDataR007()
    val R008 = MoonDataR008()
    val R009 = MoonDataR009()
    val R010 = MoonDataR010()
    val R011 = MoonDataR011()
    val R012 = MoonDataR012()
    val R013 = MoonDataR013()

    val R101 = MoonDataR101()
    val R201 = MoonDataR201()
    val R301 = MoonDataR301()

    val mf = MathFunction()

    fun moonGeocentricDistance(
        JD: Double,
        deltaT: Double = 0.0,
        opt: String = "KM"
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val t1: Double = Math.pow(t, 1.0)
        val t2: Double = Math.pow(t, 2.0)
        val t3: Double = Math.pow(t, 3.0)
        val t4: Double = Math.pow(t, 4.0)

        var aa = 0
        var R001sum = 0.0
        while (aa < 1000) {
            R001sum += R001.ELPMPP02_MT_R0[aa][0] *
                    Math.sin(
                        R001.ELPMPP02_MT_R0[aa][1] +
                                R001.ELPMPP02_MT_R0[aa][2] * t1 +
                                R001.ELPMPP02_MT_R0[aa][3] * t2 +
                                R001.ELPMPP02_MT_R0[aa][4] * t3 +
                                R001.ELPMPP02_MT_R0[aa][5] * t4
                    )
            aa++
        }

        var bb = 0
        var R002sum = 0.0
        while (bb < 1000) {
            R002sum += R002.ELPMPP02_MT_R0[bb][0] *
                    Math.sin(
                        R002.ELPMPP02_MT_R0[bb][1] +
                                R002.ELPMPP02_MT_R0[bb][2] * t1 +
                                R002.ELPMPP02_MT_R0[bb][3] * t2 +
                                R002.ELPMPP02_MT_R0[bb][4] * t3 +
                                R002.ELPMPP02_MT_R0[bb][5] * t4
                    )
            bb++
        }

        var cc = 0
        var R003sum = 0.0
        while (cc < 1000) {
            R003sum += R003.ELPMPP02_MT_R0[cc][0] *
                    Math.sin(
                        R003.ELPMPP02_MT_R0[cc][1] +
                                R003.ELPMPP02_MT_R0[cc][2] * t1 +
                                R003.ELPMPP02_MT_R0[cc][3] * t2 +
                                R003.ELPMPP02_MT_R0[cc][4] * t3 +
                                R003.ELPMPP02_MT_R0[cc][5] * t4
                    )
            cc++
        }

        var dd = 0
        var R004sum = 0.0
        while (dd < 1000) {
            R004sum += R004.ELPMPP02_MT_R0[dd][0] *
                    Math.sin(
                        R004.ELPMPP02_MT_R0[dd][1] +
                                R004.ELPMPP02_MT_R0[dd][2] * t1 +
                                R004.ELPMPP02_MT_R0[dd][3] * t2 +
                                R004.ELPMPP02_MT_R0[dd][4] * t3 +
                                R004.ELPMPP02_MT_R0[dd][5] * t4
                    )
            dd++
        }

        var ee = 0
        var R005sum = 0.0
        while (ee < 1000) {
            R005sum += R005.ELPMPP02_MT_R0[ee][0] *
                    Math.sin(
                        R005.ELPMPP02_MT_R0[ee][1] +
                                R005.ELPMPP02_MT_R0[ee][2] * t1 +
                                R005.ELPMPP02_MT_R0[ee][3] * t2 +
                                R005.ELPMPP02_MT_R0[ee][4] * t3 +
                                R005.ELPMPP02_MT_R0[ee][5] * t4
                    )
            ee++
        }

        var ff = 0
        var R006sum = 0.0
        while (ff < 1000) {
            R006sum += R006.ELPMPP02_MT_R0[ff][0] *
                    Math.sin(
                        R006.ELPMPP02_MT_R0[ff][1] +
                                R006.ELPMPP02_MT_R0[ff][2] * t1 +
                                R006.ELPMPP02_MT_R0[ff][3] * t2 +
                                R006.ELPMPP02_MT_R0[ff][4] * t3 +
                                R006.ELPMPP02_MT_R0[ff][5] * t4
                    )
            ff++
        }

        var gg = 0
        var R007sum = 0.0
        while (gg < 1000) {
            R007sum += R007.ELPMPP02_MT_R0[gg][0] *
                    Math.sin(
                        R007.ELPMPP02_MT_R0[gg][1] +
                                R007.ELPMPP02_MT_R0[gg][2] * t1 +
                                R007.ELPMPP02_MT_R0[gg][3] * t2 +
                                R007.ELPMPP02_MT_R0[gg][4] * t3 +
                                R007.ELPMPP02_MT_R0[gg][5] * t4
                    )
            gg++
        }

        var hh = 0
        var R008sum = 0.0
        while (hh < 1000) {
            R008sum += R008.ELPMPP02_MT_R0[hh][0] *
                    Math.sin(
                        R008.ELPMPP02_MT_R0[hh][1] +
                                R008.ELPMPP02_MT_R0[hh][2] * t1 +
                                R008.ELPMPP02_MT_R0[hh][3] * t2 +
                                R008.ELPMPP02_MT_R0[hh][4] * t3 +
                                R008.ELPMPP02_MT_R0[hh][5] * t4
                    )
            hh++
        }

        var ii = 0
        var R009sum = 0.0
        while (ii < 1000) {
            R009sum += R009.ELPMPP02_MT_R0[ii][0] *
                    Math.sin(
                        R009.ELPMPP02_MT_R0[ii][1] +
                                R009.ELPMPP02_MT_R0[ii][2] * t1 +
                                R009.ELPMPP02_MT_R0[ii][3] * t2 +
                                R009.ELPMPP02_MT_R0[ii][4] * t3 +
                                R009.ELPMPP02_MT_R0[ii][5] * t4
                    )
            ii++
        }

        var jj = 0
        var R010sum = 0.0
        while (jj < 1000) {
            R010sum += R010.ELPMPP02_MT_R0[jj][0] *
                    Math.sin(
                        R010.ELPMPP02_MT_R0[jj][1] +
                                R010.ELPMPP02_MT_R0[jj][2] * t1 +
                                R010.ELPMPP02_MT_R0[jj][3] * t2 +
                                R010.ELPMPP02_MT_R0[jj][4] * t3 +
                                R010.ELPMPP02_MT_R0[jj][5] * t4
                    )
            jj++
        }

        var kk = 0
        var R011sum = 0.0
        while (kk < 1000) {
            R011sum += R011.ELPMPP02_MT_R0[kk][0] *
                    Math.sin(
                        R011.ELPMPP02_MT_R0[kk][1] +
                                R011.ELPMPP02_MT_R0[kk][2] * t1 +
                                R011.ELPMPP02_MT_R0[kk][3] * t2 +
                                R011.ELPMPP02_MT_R0[kk][4] * t3 +
                                R011.ELPMPP02_MT_R0[kk][5] * t4
                    )
            kk++
        }

        var ll = 0
        var R012sum = 0.0
        while (ll < 1000) {
            R012sum += R012.ELPMPP02_MT_R0[ll][0] *
                    Math.sin(
                        R012.ELPMPP02_MT_R0[ll][1] +
                                R012.ELPMPP02_MT_R0[ll][2] * t1 +
                                R012.ELPMPP02_MT_R0[ll][3] * t2 +
                                R012.ELPMPP02_MT_R0[ll][4] * t3 +
                                R012.ELPMPP02_MT_R0[ll][5] * t4
                    )
            ll++
        }

        var mm = 0
        var R013sum = 0.0
        while (mm < 819) {
            R013sum += R013.ELPMPP02_MT_R0[mm][0] *
                    Math.sin(
                        R013.ELPMPP02_MT_R0[mm][1] +
                                R013.ELPMPP02_MT_R0[mm][2] * t1 +
                                R013.ELPMPP02_MT_R0[mm][3] * t2 +
                                R013.ELPMPP02_MT_R0[mm][4] * t3 +
                                R013.ELPMPP02_MT_R0[mm][5] * t4
                    )
            mm++
        }

        var nn = 0
        var R101sum = 0.0
        while (nn < 1165) {
            R101sum += R101.ELPMPP02_MT_R1[nn][0] *
                    Math.sin(
                        R101.ELPMPP02_MT_R1[nn][1] +
                                R101.ELPMPP02_MT_R1[nn][2] * t1 +
                                R101.ELPMPP02_MT_R1[nn][3] * t2 +
                                R101.ELPMPP02_MT_R1[nn][4] * t3 +
                                R101.ELPMPP02_MT_R1[nn][5] * t4
                    )
            nn++
        }

        var qq = 0
        var R201sum = 0.0
        while (qq < 210) {
            R201sum += R201.ELPMPP02_MT_R2[qq][0] *
                    Math.sin(
                        R201.ELPMPP02_MT_R2[qq][1] +
                                R201.ELPMPP02_MT_R2[qq][2] * t1 +
                                R201.ELPMPP02_MT_R2[qq][3] * t2 +
                                R201.ELPMPP02_MT_R2[qq][4] * t3 +
                                R201.ELPMPP02_MT_R2[qq][5] * t4
                    )
            qq++
        }

        var rr = 0
        var R301sum = 0.0
        while (rr < 2) {
            R301sum += R301.ELPMPP02_MT_R3[rr][0] *
                    Math.sin(
                        R301.ELPMPP02_MT_R3[rr][1] +
                                R301.ELPMPP02_MT_R3[rr][2] * t1 +
                                R301.ELPMPP02_MT_R3[rr][3] * t2 +
                                R301.ELPMPP02_MT_R3[rr][4] * t3 +
                                R301.ELPMPP02_MT_R3[rr][5] * t4
                    )
            rr++
        }

        val r0: Double =
            R001sum + R002sum + R003sum + R004sum + R005sum + R006sum + R007sum + R008sum + R009sum + R010sum + R011sum + R012sum + R013sum//12819terrm
        val r1: Double = R101sum //1165term
        val r2: Double = R201sum //210term
        val r3: Double = R301sum //2term
        val rp: Double = r0 + r1 * t1 + r2 * t2 + r3 * t3
        val abr: Double = 0.0708 * Math.cos(mf.Rad(225.0 + 477198.9 * t))

        val r: Double = r0 + r1 * t1 + r2 * t2 + r3 * t3 + abr//14196term
        val rKM: Double = r
        val rAU: Double = r / 149597870.7
        val rER: Double = r / 6371

        val md: Double = when (opt) {
            "R0" -> r0
            "R1" -> r1
            "R2" -> r2
            "R3" -> r3
            "Rp" -> rp
            "R" -> r
            "KM" -> rKM
            "AU" -> rAU
            "ER" -> rER
            else -> rKM
        }
        return md
    }
}
