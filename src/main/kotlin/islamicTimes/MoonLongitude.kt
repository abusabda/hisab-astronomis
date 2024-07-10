package islamicTimes

class MoonLongitude {
    val jd = JulianDay()
    val l001 = MoonDataL001()
    val l002 = MoonDataL002()
    val l003 = MoonDataL003()
    val l004 = MoonDataL004()
    val l005 = MoonDataL005()
    val l006 = MoonDataL006()
    val l007 = MoonDataL007()
    val l008 = MoonDataL008()
    val l009 = MoonDataL009()
    val l010 = MoonDataL010()
    val l011 = MoonDataL011()
    val l012 = MoonDataL012()
    val l013 = MoonDataL013()

    val l101 = MoonDataL101()
    val l201 = MoonDataL201()
    val l301 = MoonDataL301()

    val mf = MathFunction()
    val nt = NutationAndObliquity()

    fun moonGeocentricLongitude(
        JD: Double,
        deltaT: Double = 0.0,
        opt: String = "Appa"
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val t1: Double = Math.pow(t, 1.0)
        val t2: Double = Math.pow(t, 2.0)
        val t3: Double = Math.pow(t, 3.0)
        val t4: Double = Math.pow(t, 4.0)

        var aa = 0
        var l001sum = 0.0
        while (aa < 1000) {
            l001sum += l001.ELPMPP02_MT_L0[aa][0] *
                    Math.sin(
                        l001.ELPMPP02_MT_L0[aa][1] +
                                l001.ELPMPP02_MT_L0[aa][2] * t1 +
                                l001.ELPMPP02_MT_L0[aa][3] * t2 +
                                l001.ELPMPP02_MT_L0[aa][4] * t3 +
                                l001.ELPMPP02_MT_L0[aa][5] * t4
                    )
            aa++
        }

        var bb = 0
        var l002sum = 0.0
        while (bb < 1000) {
            l002sum += l002.ELPMPP02_MT_L0[bb][0] *
                    Math.sin(
                        l002.ELPMPP02_MT_L0[bb][1] +
                                l002.ELPMPP02_MT_L0[bb][2] * t1 +
                                l002.ELPMPP02_MT_L0[bb][3] * t2 +
                                l002.ELPMPP02_MT_L0[bb][4] * t3 +
                                l002.ELPMPP02_MT_L0[bb][5] * t4
                    )
            bb++

        }

        var cc = 0
        var l003sum = 0.0
        while (cc < 1000) {
            l003sum += l003.ELPMPP02_MT_L0[cc][0] *
                    Math.sin(
                        l003.ELPMPP02_MT_L0[cc][1] +
                                l003.ELPMPP02_MT_L0[cc][2] * t1 +
                                l003.ELPMPP02_MT_L0[cc][3] * t2 +
                                l003.ELPMPP02_MT_L0[cc][4] * t3 +
                                l003.ELPMPP02_MT_L0[cc][5] * t4
                    )
            cc++
        }

        var dd = 0
        var l004sum = 0.0
        while (dd < 1000) {
            l004sum += l004.ELPMPP02_MT_L0[dd][0] *
                    Math.sin(
                        l004.ELPMPP02_MT_L0[dd][1] +
                                l004.ELPMPP02_MT_L0[dd][2] * t1 +
                                l004.ELPMPP02_MT_L0[dd][3] * t2 +
                                l004.ELPMPP02_MT_L0[dd][4] * t3 +
                                l004.ELPMPP02_MT_L0[dd][5] * t4
                    )
            dd++
        }

        var ee = 0
        var l005sum = 0.0
        while (ee < 1000) {
            l005sum += l005.ELPMPP02_MT_L0[ee][0] *
                    Math.sin(
                        l005.ELPMPP02_MT_L0[ee][1] +
                                l005.ELPMPP02_MT_L0[ee][2] * t1 +
                                l005.ELPMPP02_MT_L0[ee][3] * t2 +
                                l005.ELPMPP02_MT_L0[ee][4] * t3 +
                                l005.ELPMPP02_MT_L0[ee][5] * t4
                    )
            ee++
        }

        var ff = 0
        var l006sum = 0.0
        while (ff < 1000) {
            l006sum += l006.ELPMPP02_MT_L0[ff][0] *
                    Math.sin(
                        l006.ELPMPP02_MT_L0[ff][1] +
                                l006.ELPMPP02_MT_L0[ff][2] * t1 +
                                l006.ELPMPP02_MT_L0[ff][3] * t2 +
                                l006.ELPMPP02_MT_L0[ff][4] * t3 +
                                l006.ELPMPP02_MT_L0[ff][5] * t4
                    )
            ff++
        }

        var gg = 0
        var l007sum = 0.0
        while (gg < 1000) {
            l007sum += l007.ELPMPP02_MT_L0[gg][0] *
                    Math.sin(
                        l007.ELPMPP02_MT_L0[gg][1] +
                                l007.ELPMPP02_MT_L0[gg][2] * t1 +
                                l007.ELPMPP02_MT_L0[gg][3] * t2 +
                                l007.ELPMPP02_MT_L0[gg][4] * t3 +
                                l007.ELPMPP02_MT_L0[gg][5] * t4
                    )
            gg++
        }

        var hh = 0
        var l008sum = 0.0
        while (hh < 1000) {
            l008sum += l008.ELPMPP02_MT_L0[hh][0] *
                    Math.sin(
                        l008.ELPMPP02_MT_L0[hh][1] +
                                l008.ELPMPP02_MT_L0[hh][2] * t1 +
                                l008.ELPMPP02_MT_L0[hh][3] * t2 +
                                l008.ELPMPP02_MT_L0[hh][4] * t3 +
                                l008.ELPMPP02_MT_L0[hh][5] * t4
                    )
            hh++
        }

        var ii = 0
        var l009sum = 0.0
        while (ii < 1000) {
            l009sum += l009.ELPMPP02_MT_L0[ii][0] *
                    Math.sin(
                        l009.ELPMPP02_MT_L0[ii][1] +
                                l009.ELPMPP02_MT_L0[ii][2] * t1 +
                                l009.ELPMPP02_MT_L0[ii][3] * t2 +
                                l009.ELPMPP02_MT_L0[ii][4] * t3 +
                                l009.ELPMPP02_MT_L0[ii][5] * t4
                    )
            ii++
        }

        var jj = 0
        var l010sum = 0.0
        while (jj < 1000) {
            l010sum += l010.ELPMPP02_MT_L0[jj][0] *
                    Math.sin(
                        l010.ELPMPP02_MT_L0[jj][1] +
                                l010.ELPMPP02_MT_L0[jj][2] * t1 +
                                l010.ELPMPP02_MT_L0[jj][3] * t2 +
                                l010.ELPMPP02_MT_L0[jj][4] * t3 +
                                l010.ELPMPP02_MT_L0[jj][5] * t4
                    )
            jj++
        }

        var kk = 0
        var l011sum = 0.0
        while (kk < 1000) {
            l011sum += l011.ELPMPP02_MT_L0[kk][0] *
                    Math.sin(
                        l011.ELPMPP02_MT_L0[kk][1] +
                                l011.ELPMPP02_MT_L0[kk][2] * t1 +
                                l011.ELPMPP02_MT_L0[kk][3] * t2 +
                                l011.ELPMPP02_MT_L0[kk][4] * t3 +
                                l011.ELPMPP02_MT_L0[kk][5] * t4
                    )
            kk++
        }

        var ll = 0
        var l012sum = 0.0
        while (ll < 1000) {
            l012sum += l012.ELPMPP02_MT_L0[ll][0] *
                    Math.sin(
                        l012.ELPMPP02_MT_L0[ll][1] +
                                l012.ELPMPP02_MT_L0[ll][2] * t1 +
                                l012.ELPMPP02_MT_L0[ll][3] * t2 +
                                l012.ELPMPP02_MT_L0[ll][4] * t3 +
                                l012.ELPMPP02_MT_L0[ll][5] * t4
                    )
            ll++
        }

        var mm = 0
        var l013sum = 0.0
        while (mm < 337) {
            l013sum += l013.ELPMPP02_MT_L0[mm][0] *
                    Math.sin(
                        l013.ELPMPP02_MT_L0[mm][1] +
                                l013.ELPMPP02_MT_L0[mm][2] * t1 +
                                l013.ELPMPP02_MT_L0[mm][3] * t2 +
                                l013.ELPMPP02_MT_L0[mm][4] * t3 +
                                l013.ELPMPP02_MT_L0[mm][5] * t4
                    )
            mm++
        }

        var nn = 0
        var l101sum = 0.0
        while (nn < 1199) {
            l101sum += l101.ELPMPP02_MT_L1[nn][0] *
                    Math.sin(
                        l101.ELPMPP02_MT_L1[nn][1] +
                                l101.ELPMPP02_MT_L1[nn][2] * t1 +
                                l101.ELPMPP02_MT_L1[nn][3] * t2 +
                                l101.ELPMPP02_MT_L1[nn][4] * t3 +
                                l101.ELPMPP02_MT_L1[nn][5] * t4
                    )
            nn++
        }

        var qq = 0
        var l201sum = 0.0
        while (qq < 219) {
            l201sum += l201.ELPMPP02_MT_L2[qq][0] *
                    Math.sin(
                        l201.ELPMPP02_MT_L2[qq][1] +
                                l201.ELPMPP02_MT_L2[qq][2] * t1 +
                                l201.ELPMPP02_MT_L2[qq][3] * t2 +
                                l201.ELPMPP02_MT_L2[qq][4] * t3 +
                                l201.ELPMPP02_MT_L2[qq][5] * t4
                    )
            qq++
        }

        var rr = 0
        var l301sum = 0.0
        while (rr < 2) {
            l301sum += l301.ELPMPP02_MT_L3[rr][0] *
                    Math.sin(
                        l301.ELPMPP02_MT_L3[rr][1] +
                                l301.ELPMPP02_MT_L3[rr][2] * t1 +
                                l301.ELPMPP02_MT_L3[rr][3] * t2 +
                                l301.ELPMPP02_MT_L3[rr][4] * t3 +
                                l301.ELPMPP02_MT_L3[rr][5] * t4
                    )
            rr++
        }

        val l0: Double =
            l001sum + l002sum + l003sum + l004sum + l005sum + l006sum + l007sum + l008sum + l009sum + l010sum + l011sum + l012sum + l013sum //12337term
        val l1: Double = l101sum //1199term
        val l2: Double = l201sum //219
        val l3: Double = l301sum //2
        val l: Double = l0 + l1 * t1 + l2 * t2 + l3 * t3 //13757

        //MoonMeanLongitude
        val w0 = 3.81034409083088
        val w1 = 8399.68473007193
        val w2 = -0.0000331895204255009
        val w3 = 3.11024944910606E-08
        val w4 = -2.03282376489228E-10
        val w = w0 + w1 * t1 + w2 * t2 + w3 * t3 + w4 * t4

        //Presesi
        val p0 = 0.0
        val p1 = 5029.0966 - 0.29965
        val p2 = 1.112
        val p3 = 0.000077
        val p4 = -0.00002353
        val p = p0 + p1 * t1 + p2 * t2 + p3 * t3 + p4 * t4

        //TrueGeocentricEclipticLongitude
        val moonTrueLon: Double = mf.Mod(mf.Deg(w) + l / 3600.0 + p / 3600.0, 360.0)
        val nutation: Double = nt.nutationInLongitude(JD, deltaT)

        //Aberasi
        val abr: Double = -0.00019524 - 0.00001059 * Math.sin(mf.Rad(225 + 477198.9 * t))

        //ApparentGeocentricEclipticLongitude
        val moonAppaLon: Double = moonTrueLon + nutation + abr

        val mLon: Double = when (opt) {
            "L0" -> l0
            "L1" -> l1
            "L2" -> l2
            "L3" -> l3
            "L" -> l
            "True" -> moonTrueLon
            "Appa" -> moonAppaLon
            else -> moonAppaLon
        }
        return mLon
    }
}