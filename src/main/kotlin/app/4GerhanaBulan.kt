//GERHANA BULAN

package app

import islamicTimes.*

fun main(args: Array<String>) {

    val jd = JulianDay()
    val mf = MathFunction()
    val mo = MoonOtherFunc()
    val sn = SunDatas()
    val dt = DynamicalTime()

    fun Double.round(decimals: Int = 2): String {
        return "%.${decimals}f".format(this)
    }

    val HijriMonth: Byte = 11
    val HijriYear: Long = 1439
    val gLon: Double = 107 + 36 / 60.0 + 0 / 3600.0
    val gLat: Double = -(7 + 5 / 60.0 + 0 / 3600.0)
    val TmZn: Double = 7.0
    val elev: Double = 730.0

    fun LBesselian(
        HijriMonth: Byte,
        HijriYear: Long,
        OptResult: String
    ): Double {
        val JDELunarEclipse1 = mo.jdeEclipseModified(HijriMonth, HijriYear, 2)
        return if (JDELunarEclipse1 > 0) {
            val JDELunarEclipse2 =
                Math.floor(JDELunarEclipse1) + (((JDELunarEclipse1 - Math.floor(JDELunarEclipse1)) * 24).round(0)).toDouble() / 24.0
            val T0 = mf.Mod((((JDELunarEclipse2 - Math.floor(JDELunarEclipse2)) * 24).round(0).toDouble()), 24.0)
            val DT = dt.DeltaT(JDELunarEclipse2)

            val ARsM2 = sn.sunGeocentricRightAscension(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val ARsM1 = sn.sunGeocentricRightAscension(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val ARs00 = sn.sunGeocentricRightAscension(JDELunarEclipse2).round(7).toDouble()
            val ARsP1 = sn.sunGeocentricRightAscension(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val ARsP2 = sn.sunGeocentricRightAscension(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val dsM2 = sn.sunGeocentricDeclination(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val dsM1 = sn.sunGeocentricDeclination(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val ds00 = sn.sunGeocentricDeclination(JDELunarEclipse2).round(7).toDouble()
            val dsP1 = sn.sunGeocentricDeclination(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val dsP2 = sn.sunGeocentricDeclination(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val SsM2 = sn.sunGeocentricSemidiameter(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val SsM1 = sn.sunGeocentricSemidiameter(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val Ss00 = sn.sunGeocentricSemidiameter(JDELunarEclipse2).round(7).toDouble()
            val SsP1 = sn.sunGeocentricSemidiameter(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val SsP2 = sn.sunGeocentricSemidiameter(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val HPsM2 = sn.sunEquatorialHorizontalParallax(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val HPsM1 = sn.sunEquatorialHorizontalParallax(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val HPs00 = sn.sunEquatorialHorizontalParallax(JDELunarEclipse2).round(7).toDouble()
            val HPsP1 = sn.sunEquatorialHorizontalParallax(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val HPsP2 = sn.sunEquatorialHorizontalParallax(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val ARmM2 = mo.moonGeocentricRightAscension(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val ARmM1 = mo.moonGeocentricRightAscension(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val ARm00 = mo.moonGeocentricRightAscension(JDELunarEclipse2).round(7).toDouble()
            val ARmP1 = mo.moonGeocentricRightAscension(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val ARmP2 = mo.moonGeocentricRightAscension(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val dmM2 = mo.moonGeocentricDeclination(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val dmM1 = mo.moonGeocentricDeclination(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val dm00 = mo.moonGeocentricDeclination(JDELunarEclipse2).round(7).toDouble()
            val dmP1 = mo.moonGeocentricDeclination(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val dmP2 = mo.moonGeocentricDeclination(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val SmM2 = mo.moonGeocentricSemidiameter(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val SmM1 = mo.moonGeocentricSemidiameter(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val Sm00 = mo.moonGeocentricSemidiameter(JDELunarEclipse2).round(7).toDouble()
            val SmP1 = mo.moonGeocentricSemidiameter(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val SmP2 = mo.moonGeocentricSemidiameter(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val HPmM2 = mo.moonEquatorialHorizontalParallax(JDELunarEclipse2 - 2 / 24.0).round(7).toDouble()
            val HPmM1 = mo.moonEquatorialHorizontalParallax(JDELunarEclipse2 - 1 / 24.0).round(7).toDouble()
            val HPm00 = mo.moonEquatorialHorizontalParallax(JDELunarEclipse2).round(7).toDouble()
            val HPmP1 = mo.moonEquatorialHorizontalParallax(JDELunarEclipse2 + 1 / 24.0).round(7).toDouble()
            val HPmP2 = mo.moonEquatorialHorizontalParallax(JDELunarEclipse2 + 2 / 24.0).round(7).toDouble()

            val aM2 = mf.Mod(ARsM2 + 180, 360.0)
            val aM1 = mf.Mod(ARsM1 + 180, 360.0)
            val a00 = mf.Mod(ARs00 + 180, 360.0)
            val aP1 = mf.Mod(ARsP1 + 180, 360.0)
            val aP2 = mf.Mod(ARsP2 + 180, 360.0)

            val dM2 = -(dsM2)
            val dM1 = -(dsM1)
            val d00 = -(ds00)
            val dP1 = -(dsP1)
            val dP2 = -(dsP2)

            val eM2 = 1 / 4.0 * (ARmM2 - aM2) * Math.sin(mf.Rad(2 * dM2)) * Math.sin(mf.Rad(ARmM2 - aM2))
            val eM1 = 1 / 4.0 * (ARmM1 - aM1) * Math.sin(mf.Rad(2 * dM1)) * Math.sin(mf.Rad(ARmM1 - aM1))
            val e00 = 1 / 4.0 * (ARm00 - a00) * Math.sin(mf.Rad(2 * d00)) * Math.sin(mf.Rad(ARm00 - a00))
            val eP1 = 1 / 4.0 * (ARmP1 - aP1) * Math.sin(mf.Rad(2 * dP1)) * Math.sin(mf.Rad(ARmP1 - aP1))
            val eP2 = 1 / 4.0 * (ARmP2 - aP2) * Math.sin(mf.Rad(2 * dP2)) * Math.sin(mf.Rad(ARmP2 - aP2))

            val f1M2 = 1.01 * HPmM2 + HPsM2 + SsM2
            val f1M1 = 1.01 * HPmM1 + HPsM1 + SsM1
            val f100 = 1.01 * HPm00 + HPs00 + Ss00
            val f1P1 = 1.01 * HPmP1 + HPsP1 + SsP1
            val f1P2 = 1.01 * HPmP2 + HPsP2 + SsP2

            val f2M2 = 1.01 * HPmM2 + HPsM2 - SsM2
            val f2M1 = 1.01 * HPmM1 + HPsM1 - SsM1
            val f200 = 1.01 * HPm00 + HPs00 - Ss00
            val f2P1 = 1.01 * HPmP1 + HPsP1 - SsP1
            val f2P2 = 1.01 * HPmP2 + HPsP2 - SsP2

            val xM2 = (ARmM2 - aM2) * Math.cos(mf.Rad(dmM2))
            val xM1 = (ARmM1 - aM1) * Math.cos(mf.Rad(dmM1))
            val x00 = (ARm00 - a00) * Math.cos(mf.Rad(dm00))
            val xP1 = (ARmP1 - aP1) * Math.cos(mf.Rad(dmP1))
            val xP2 = (ARmP2 - aP2) * Math.cos(mf.Rad(dmP2))

            val yM2 = (dmM2 - dM2 + eM2)
            val yM1 = (dmM1 - dM1 + eM1)
            val y00 = (dm00 - d00 + e00)
            val yP1 = (dmP1 - dP1 + eP1)
            val yP2 = (dmP2 - dP2 + eP2)

            return when (OptResult) {
                "JDL" -> JDELunarEclipse2
                "DT" -> DT
                "x0" -> mf.InterpolationFromFiveTabularValues(xM2, xM1, x00, xP1, xP2, 0).round(7).toDouble()
                "x1" -> mf.InterpolationFromFiveTabularValues(xM2, xM1, x00, xP1, xP2, 1).round(7).toDouble()
                "x2" -> mf.InterpolationFromFiveTabularValues(xM2, xM1, x00, xP1, xP2, 2).round(7).toDouble()
                "x3" -> mf.InterpolationFromFiveTabularValues(xM2, xM1, x00, xP1, xP2, 3).round(7).toDouble()
                "x4" -> mf.InterpolationFromFiveTabularValues(xM2, xM1, x00, xP1, xP2, 4).round(7).toDouble()

                "y0" -> mf.InterpolationFromFiveTabularValues(yM2, yM1, y00, yP1, yP2, 0).round(7).toDouble()
                "y1" -> mf.InterpolationFromFiveTabularValues(yM2, yM1, y00, yP1, yP2, 1).round(7).toDouble()
                "y2" -> mf.InterpolationFromFiveTabularValues(yM2, yM1, y00, yP1, yP2, 2).round(7).toDouble()
                "y3" -> mf.InterpolationFromFiveTabularValues(yM2, yM1, y00, yP1, yP2, 3).round(7).toDouble()
                "y4" -> mf.InterpolationFromFiveTabularValues(yM2, yM1, y00, yP1, yP2, 4).round(7).toDouble()

                "d0" -> mf.InterpolationFromFiveTabularValues(dM2, dM1, d00, dP1, dP2, 0).round(7).toDouble()
                "d1" -> mf.InterpolationFromFiveTabularValues(dM2, dM1, d00, dP1, dP2, 1).round(7).toDouble()
                "d2" -> mf.InterpolationFromFiveTabularValues(dM2, dM1, d00, dP1, dP2, 2).round(7).toDouble()
                "d3" -> mf.InterpolationFromFiveTabularValues(dM2, dM1, d00, dP1, dP2, 3).round(7).toDouble()
                "d4" -> mf.InterpolationFromFiveTabularValues(dM2, dM1, d00, dP1, dP2, 4).round(7).toDouble()

                "f10" -> mf.InterpolationFromFiveTabularValues(f1M2, f1M1, f100, f1P1, f1P2, 0).round(7).toDouble()
                "f11" -> mf.InterpolationFromFiveTabularValues(f1M2, f1M1, f100, f1P1, f1P2, 1).round(7).toDouble()
                "f12" -> mf.InterpolationFromFiveTabularValues(f1M2, f1M1, f100, f1P1, f1P2, 2).round(7).toDouble()
                "f13" -> mf.InterpolationFromFiveTabularValues(f1M2, f1M1, f100, f1P1, f1P2, 3).round(7).toDouble()
                "f14" -> mf.InterpolationFromFiveTabularValues(f1M2, f1M1, f100, f1P1, f1P2, 4).round(7).toDouble()

                "f20" -> mf.InterpolationFromFiveTabularValues(f2M2, f2M1, f200, f2P1, f2P2, 0).round(7).toDouble()
                "f21" -> mf.InterpolationFromFiveTabularValues(f2M2, f2M1, f200, f2P1, f2P2, 1).round(7).toDouble()
                "f22" -> mf.InterpolationFromFiveTabularValues(f2M2, f2M1, f200, f2P1, f2P2, 2).round(7).toDouble()
                "f23" -> mf.InterpolationFromFiveTabularValues(f2M2, f2M1, f200, f2P1, f2P2, 3).round(7).toDouble()
                "f24" -> mf.InterpolationFromFiveTabularValues(f2M2, f2M1, f200, f2P1, f2P2, 4).round(7).toDouble()

                "HP0" -> mf.InterpolationFromFiveTabularValues(HPmM2, HPmM1, HPm00, HPmP1, HPmP2, 0).round(7).toDouble()
                "HP1" -> mf.InterpolationFromFiveTabularValues(HPmM2, HPmM1, HPm00, HPmP1, HPmP2, 1).round(7).toDouble()
                "HP2" -> mf.InterpolationFromFiveTabularValues(HPmM2, HPmM1, HPm00, HPmP1, HPmP2, 2).round(7).toDouble()
                "HP3" -> mf.InterpolationFromFiveTabularValues(HPmM2, HPmM1, HPm00, HPmP1, HPmP2, 3).round(7).toDouble()
                "HP4" -> mf.InterpolationFromFiveTabularValues(HPmM2, HPmM1, HPm00, HPmP1, HPmP2, 4).round(7).toDouble()

                "dm0" -> mf.InterpolationFromFiveTabularValues(dmM2, dmM1, dm00, dmP1, dmP2, 0).round(7).toDouble()
                "dm1" -> mf.InterpolationFromFiveTabularValues(dmM2, dmM1, dm00, dmP1, dmP2, 1).round(7).toDouble()
                "dm2" -> mf.InterpolationFromFiveTabularValues(dmM2, dmM1, dm00, dmP1, dmP2, 2).round(7).toDouble()
                "dm3" -> mf.InterpolationFromFiveTabularValues(dmM2, dmM1, dm00, dmP1, dmP2, 3).round(7).toDouble()
                "dm4" -> mf.InterpolationFromFiveTabularValues(dmM2, dmM1, dm00, dmP1, dmP2, 4).round(7).toDouble()

                "Sm0" -> mf.InterpolationFromFiveTabularValues(SmM2, SmM1, Sm00, SmP1, SmP2, 0).round(7).toDouble()
                "Sm1" -> mf.InterpolationFromFiveTabularValues(SmM2, SmM1, Sm00, SmP1, SmP2, 1).round(7).toDouble()
                "Sm2" -> mf.InterpolationFromFiveTabularValues(SmM2, SmM1, Sm00, SmP1, SmP2, 2).round(7).toDouble()
                "Sm3" -> mf.InterpolationFromFiveTabularValues(SmM2, SmM1, Sm00, SmP1, SmP2, 3).round(7).toDouble()
                "Sm4" -> mf.InterpolationFromFiveTabularValues(SmM2, SmM1, Sm00, SmP1, SmP2, 4).round(7).toDouble()

                else -> mf.Mod(T0 + 12, 24.0)
            }
        } else {
            Double.NaN
        }
    }

    //Hisab gerhana Bulan

    var T: Double = 0.0
    var x: Double = 0.0
    var y: Double = 0.0

    var x_: Double = 0.0
    var y_: Double = 0.0

    var n: Double = 0.0
    var n2: Double = 0.0
    var tx: Double = 0.0


    val x0 = LBesselian(HijriMonth, HijriYear, "x0").round(7).toDouble()
    val x1 = LBesselian(HijriMonth, HijriYear, "x1").round(7).toDouble()
    val x2 = LBesselian(HijriMonth, HijriYear, "x2").round(7).toDouble()
    val x3 = LBesselian(HijriMonth, HijriYear, "x3").round(7).toDouble()
    val x4 = LBesselian(HijriMonth, HijriYear, "x4").round(7).toDouble()

    val y0 = LBesselian(HijriMonth, HijriYear, "y0").round(7).toDouble()
    val y1 = LBesselian(HijriMonth, HijriYear, "y1").round(7).toDouble()
    val y2 = LBesselian(HijriMonth, HijriYear, "y2").round(7).toDouble()
    val y3 = LBesselian(HijriMonth, HijriYear, "y3").round(7).toDouble()
    val y4 = LBesselian(HijriMonth, HijriYear, "y4").round(7).toDouble()

    val f10 = LBesselian(HijriMonth, HijriYear, "f10").round(7).toDouble()
    val f11 = LBesselian(HijriMonth, HijriYear, "f11").round(7).toDouble()
    val f12 = LBesselian(HijriMonth, HijriYear, "f12").round(7).toDouble()
    val f13 = LBesselian(HijriMonth, HijriYear, "f13").round(7).toDouble()
    val f14 = LBesselian(HijriMonth, HijriYear, "f14").round(7).toDouble()

    val f20 = LBesselian(HijriMonth, HijriYear, "f20").round(7).toDouble()
    val f21 = LBesselian(HijriMonth, HijriYear, "f21").round(7).toDouble()
    val f22 = LBesselian(HijriMonth, HijriYear, "f22").round(7).toDouble()
    val f23 = LBesselian(HijriMonth, HijriYear, "f23").round(7).toDouble()
    val f24 = LBesselian(HijriMonth, HijriYear, "f24").round(7).toDouble()

    val Sm0 = LBesselian(HijriMonth, HijriYear, "Sm0").round(7).toDouble()
    val Sm1 = LBesselian(HijriMonth, HijriYear, "Sm1").round(7).toDouble()
    val Sm2 = LBesselian(HijriMonth, HijriYear, "Sm2").round(7).toDouble()
    val Sm3 = LBesselian(HijriMonth, HijriYear, "Sm3").round(7).toDouble()
    val Sm4 = LBesselian(HijriMonth, HijriYear, "Sm4").round(7).toDouble()

    val JDELunarEclipse1 = mo.jdeEclipseModified(HijriMonth, HijriYear, 2)
    val JDELunarEclipse2 =
        Math.floor(JDELunarEclipse1) + (((JDELunarEclipse1 - Math.floor(JDELunarEclipse1)) * 24).round(0)).toDouble() / 24.0

    val T0 = ((JDELunarEclipse2 + 0.5 + (0.0 / 24.0) - Math.floor(JDELunarEclipse2 + 0.5 + (0.0 / 24.0))) * 24).round(0)
        .toDouble()

    for (i in 1..4) {
        T = T + tx
        x = x0 + x1 * T + x2 * T * T + x3 * T * T * T + x4 * T * T * T * T
        y = y0 + y1 * T + y2 * T * T + y3 * T * T * T + y4 * T * T * T * T

        x_ = x1 + 2 * x2 * T + 3 * x3 * T * T + 4 * x4 * T * T * T
        y_ = y1 + 2 * y2 * T + 3 * y3 * T * T + 4 * y4 * T * T * T

        n2 = x_ * x_ + y_ * y_
        n = Math.sqrt(n2)
        tx = -1 / n2 * (x * x_ + y * y_)
    }

    val f1 = f10 + f11 * T + f12 * T * T + f13 * T * T * T + f14 * T * T * T * T
    val f2 = f20 + f21 * T + f22 * T * T + f23 * T * T * T + f24 * T * T * T * T
    val Sm = Sm0 + Sm1 * T + Sm2 * T * T + Sm3 * T * T * T + Sm4 * T * T * T * T

    val D = Math.pow(x * x + y * y, 0.5)

    val L1 = f1 + Sm
    val L2 = f2 + Sm
    val L3 = f2 - Sm

    val RadP = L1 - Sm
    val RadU = L2 - Sm

    val MagP = (1 / (2 * Sm)) * (L1 - D)
    val MagU = (1 / (2 * Sm)) * (L2 - D)

    val T1 = 1 / n * Math.pow(L1 * L1 - D * D, 0.5)
    val T2 = 1 / n * Math.pow(L2 * L2 - D * D, 0.5)
    val T3 = 1 / n * Math.pow(L3 * L3 - D * D, 0.5)

    val DurP = T1 * 2
    val DurU = T2 * 2
    val DurT = T3 * 2

    val DeltaT = LBesselian(HijriMonth, HijriYear, "DT")

    val P1 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T - T1) / 24.0) - DeltaT / 86400.0
    val U1 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T - T2) / 24.0) - DeltaT / 86400.0
    val U2 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T - T3) / 24.0) - DeltaT / 86400.0
    val Mx = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T) / 24.0) - DeltaT / 86400.0
    val U3 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T + T3) / 24.0) - DeltaT / 86400.0
    val U4 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T + T2) / 24.0) - DeltaT / 86400.0
    val P4 = Math.floor(JDELunarEclipse2 - 0.5) + 0.5 + ((T0 + T + T1) / 24.0) - DeltaT / 86400.0

    val LEK = if ((Math.pow(L3, 2.0) - Math.pow(D, 2.0)) > 0.0) {
        "GERHANA BULAN TOTAL"
    } else if ((Math.pow(L2, 2.0) - Math.pow(D, 2.0)) > 0.0 && (Math.pow(L3, 2.0) - Math.pow(D, 2.0)) < 0.0) {
        "GERHANA BULAN SEBAGIAN"
    } else if ((Math.pow(L1, 2.0) - Math.pow(D, 2.0)) > 0.0 && (Math.pow(L2, 2.0) - Math.pow(D, 2.0)) < 0.0) {
        "GERHANA BULAN PENUMBRAL"
    } else {
        "TIDAK ADA GERHANA"
    }

    val ARmMx = mo.moonGeocentricRightAscension(Mx, DeltaT)
    val ARmP1 = mo.moonGeocentricRightAscension(P1, DeltaT)
    val ARmP4 = mo.moonGeocentricRightAscension(P4, DeltaT)
    val ARmU1 = mo.moonGeocentricRightAscension(U1, DeltaT)
    val ARmU4 = mo.moonGeocentricRightAscension(U4, DeltaT)
    val ARmU2 = mo.moonGeocentricRightAscension(U2, DeltaT)
    val ARmU3 = mo.moonGeocentricRightAscension(U3, DeltaT)

    val dmMx = mo.moonGeocentricDeclination(Mx, DeltaT)
    val dmP1 = mo.moonGeocentricDeclination(P1, DeltaT)
    val dmP4 = mo.moonGeocentricDeclination(P4, DeltaT)
    val dmU1 = mo.moonGeocentricDeclination(U1, DeltaT)
    val dmU4 = mo.moonGeocentricDeclination(U4, DeltaT)
    val dmU2 = mo.moonGeocentricDeclination(U2, DeltaT)
    val dmU3 = mo.moonGeocentricDeclination(U3, DeltaT)

    val SdmMx = mo.moonGeocentricSemidiameter(Mx, DeltaT)
    val SdmP1 = mo.moonGeocentricSemidiameter(P1, DeltaT)
    val SdmP4 = mo.moonGeocentricSemidiameter(P4, DeltaT)
    val SdmU1 = mo.moonGeocentricSemidiameter(U1, DeltaT)
    val SdmU4 = mo.moonGeocentricSemidiameter(U4, DeltaT)
    val SdmU2 = mo.moonGeocentricSemidiameter(U2, DeltaT)
    val SdmU3 = mo.moonGeocentricSemidiameter(U3, DeltaT)

    val HPmMx = mo.moonEquatorialHorizontalParallax(Mx, DeltaT)
    val HPmP1 = mo.moonEquatorialHorizontalParallax(P1, DeltaT)
    val HPmP4 = mo.moonEquatorialHorizontalParallax(P4, DeltaT)
    val HPmU1 = mo.moonEquatorialHorizontalParallax(U1, DeltaT)
    val HPmU4 = mo.moonEquatorialHorizontalParallax(U4, DeltaT)
    val HPmU2 = mo.moonEquatorialHorizontalParallax(U2, DeltaT)
    val HPmU3 = mo.moonEquatorialHorizontalParallax(U3, DeltaT)

    val HmMx = mo.moonGeocentricLocalHourAngel(Mx, DeltaT, gLon)
    val HmP1 = mo.moonGeocentricLocalHourAngel(P1, DeltaT, gLon)
    val HmP4 = mo.moonGeocentricLocalHourAngel(P4, DeltaT, gLon)
    val HmU1 = mo.moonGeocentricLocalHourAngel(U1, DeltaT, gLon)
    val HmU4 = mo.moonGeocentricLocalHourAngel(U4, DeltaT, gLon)
    val HmU2 = mo.moonGeocentricLocalHourAngel(U2, DeltaT, gLon)
    val HmU3 = mo.moonGeocentricLocalHourAngel(U3, DeltaT, gLon)

    val ARsMx = sn.sunGeocentricRightAscension(Mx, DeltaT)
    val ARsP1 = sn.sunGeocentricRightAscension(P1, DeltaT)
    val ARsP4 = sn.sunGeocentricRightAscension(P4, DeltaT)
    val ARsU1 = sn.sunGeocentricRightAscension(U1, DeltaT)
    val ARsU4 = sn.sunGeocentricRightAscension(U4, DeltaT)
    val ARsU2 = sn.sunGeocentricRightAscension(U2, DeltaT)
    val ARsU3 = sn.sunGeocentricRightAscension(U3, DeltaT)

    val dsMx = sn.sunGeocentricDeclination(Mx, DeltaT)
    val dsP1 = sn.sunGeocentricDeclination(P1, DeltaT)
    val dsP4 = sn.sunGeocentricDeclination(P4, DeltaT)
    val dsU1 = sn.sunGeocentricDeclination(U1, DeltaT)
    val dsU4 = sn.sunGeocentricDeclination(U4, DeltaT)
    val dsU2 = sn.sunGeocentricDeclination(U2, DeltaT)
    val dsU3 = sn.sunGeocentricDeclination(U3, DeltaT)

    val SdsMx = sn.sunGeocentricSemidiameter(Mx, DeltaT)
    val SdsP1 = sn.sunGeocentricSemidiameter(P1, DeltaT)
    val SdsP4 = sn.sunGeocentricSemidiameter(P4, DeltaT)
    val SdsU1 = sn.sunGeocentricSemidiameter(U1, DeltaT)
    val SdsU4 = sn.sunGeocentricSemidiameter(U4, DeltaT)
    val SdsU2 = sn.sunGeocentricSemidiameter(U2, DeltaT)
    val SdsU3 = sn.sunGeocentricSemidiameter(U3, DeltaT)

    val HPsMx = sn.sunEquatorialHorizontalParallax(Mx, DeltaT)
    val HPsP1 = sn.sunEquatorialHorizontalParallax(P1, DeltaT)
    val HPsP4 = sn.sunEquatorialHorizontalParallax(P4, DeltaT)
    val HPsU1 = sn.sunEquatorialHorizontalParallax(U1, DeltaT)
    val HPsU4 = sn.sunEquatorialHorizontalParallax(U4, DeltaT)
    val HPsU2 = sn.sunEquatorialHorizontalParallax(U2, DeltaT)
    val HPsU3 = sn.sunEquatorialHorizontalParallax(U3, DeltaT)

    val HsMx = sn.sunGeocentricLocalHourAngel(Mx, DeltaT, gLon)
    val HsP1 = sn.sunGeocentricLocalHourAngel(P1, DeltaT, gLon)
    val HsP4 = sn.sunGeocentricLocalHourAngel(P4, DeltaT, gLon)
    val HsU1 = sn.sunGeocentricLocalHourAngel(U1, DeltaT, gLon)
    val HsU4 = sn.sunGeocentricLocalHourAngel(U4, DeltaT, gLon)
    val HsU2 = sn.sunGeocentricLocalHourAngel(U2, DeltaT, gLon)
    val HsU3 = sn.sunGeocentricLocalHourAngel(U3, DeltaT, gLon)

    val AzmP1 = mo.moonTopocentricAzimuth(P1, DeltaT, gLon, gLat, elev)
    val AzmU1 = mo.moonTopocentricAzimuth(U1, DeltaT, gLon, gLat, elev)
    val AzmU2 = mo.moonTopocentricAzimuth(U2, DeltaT, gLon, gLat, elev)
    val AzmMx = mo.moonTopocentricAzimuth(Mx, DeltaT, gLon, gLat, elev)
    val AzmU3 = mo.moonTopocentricAzimuth(U3, DeltaT, gLon, gLat, elev)
    val AzmU4 = mo.moonTopocentricAzimuth(U4, DeltaT, gLon, gLat, elev)
    val AzmP4 = mo.moonTopocentricAzimuth(P4, DeltaT, gLon, gLat, elev)

    val AltP1 = mo.moonTopocentricAltitude(P1, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltU1 = mo.moonTopocentricAltitude(U1, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltU2 = mo.moonTopocentricAltitude(U2, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltMx = mo.moonTopocentricAltitude(Mx, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltU3 = mo.moonTopocentricAltitude(U3, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltU4 = mo.moonTopocentricAltitude(U4, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")
    val AltP4 = mo.moonTopocentricAltitude(P4, DeltaT, gLon, gLat, elev, 1010.0, 10.0, "htc")


    fun LunarEclipse(
        HijriMonth: Byte,
        HijriYear: Long,
        gLon: Double,
        gLat: Double,
        OptResult: String
    ): Double {

        val JDEc = JDELunarEclipse1
        return if (JDEc > 0) {
            val ta = T
            val f1a = f1
            val f2a = f2

            val jdP1 = P1
            val jdU1 = U1
            val jdU2 = U2
            val jdMx = Mx
            val jdU3 = U3
            val jdU4 = U4
            val jdP4 = P4

            val DurPn = DurP
            val DurUm = DurU
            val DurTo = DurT

            val MagPn = MagP
            val MagUm = MagU

            val RadPn = RadP
            val RadUm = RadU

            val ARm2Mx = ARmMx
            val ARm2P1 = ARmP1
            val ARm2P4 = ARmP4
            val ARm2U1 = ARmU1
            val ARm2U4 = ARmU4
            val ARm2U2 = ARmU2
            val ARm2U3 = ARmU3

            val dm2Mx = dmMx
            val dm2P1 = dmP1
            val dm2P4 = dmP4
            val dm2U1 = dmU1
            val dm2U4 = dmU4
            val dm2U2 = dmU2
            val dm2U3 = dmU3

            val Sdm2Mx = SdmMx
            val Sdm2P1 = SdmP1
            val Sdm2P4 = SdmP4
            val Sdm2U1 = SdmU1
            val Sdm2U4 = SdmU4
            val Sdm2U2 = SdmU2
            val Sdm2U3 = SdmU3

            val HPm2Mx = HPmMx
            val HPm2P1 = HPmP1
            val HPm2P4 = HPmP4
            val HPm2U1 = HPmU1
            val HPm2U4 = HPmU4
            val HPm2U2 = HPmU2
            val HPm2U3 = HPmU3

            val Hm2Mx = HmMx
            val Hm2P1 = HmP1
            val Hm2P4 = HmP4
            val Hm2U1 = HmU1
            val Hm2U4 = HmU4
            val Hm2U2 = HmU2
            val Hm2U3 = HmU3

            val ARs2Mx = ARsMx
            val ARs2P1 = ARsP1
            val ARs2P4 = ARsP4
            val ARs2U1 = ARsU1
            val ARs2U4 = ARsU4
            val ARs2U2 = ARsU2
            val ARs2U3 = ARsU3

            val ds2Mx = dsMx
            val ds2P1 = dsP1
            val ds2P4 = dsP4
            val ds2U1 = dsU1
            val ds2U4 = dsU4
            val ds2U2 = dsU2
            val ds2U3 = dsU3

            val Sds2Mx = SdsMx
            val Sds2P1 = SdsP1
            val Sds2P4 = SdsP4
            val Sds2U1 = SdsU1
            val Sds2U4 = SdsU4
            val Sds2U2 = SdsU2
            val Sds2U3 = SdsU3

            val HPs2Mx = HPsMx
            val HPs2P1 = HPsP1
            val HPs2P4 = HPsP4
            val HPs2U1 = HPsU1
            val HPs2U4 = HPsU4
            val HPs2U2 = HPsU2
            val HPs2U3 = HPsU3

            val Hs2Mx = HsMx
            val Hs2P1 = HsP1
            val Hs2P4 = HsP4
            val Hs2U1 = HsU1
            val Hs2U4 = HsU4
            val Hs2U2 = HsU2
            val Hs2U3 = HsU3

            val Azm2P1 = AzmP1
            val Azm2U1 = AzmU1
            val Azm2U2 = AzmU2
            val Azm2Mx = AzmMx
            val Azm2U3 = AzmU3
            val Azm2U4 = AzmU4
            val Azm2P4 = AzmP4

            val Alt2P1 = AltP1
            val Alt2U1 = AltU1
            val Alt2U2 = AltU2
            val Alt2Mx = AltMx
            val Alt2U3 = AltU3
            val Alt2U4 = AltU4
            val Alt2P4 = AltP4

            return when (OptResult) {
                "P1" -> jdP1
                "P4" -> jdP4
                "U1" -> jdU1
                "U4" -> jdU4
                "U2" -> jdU2
                "U3" -> jdU3

                "MagP" -> MagPn
                "MagU" -> MagUm

                "RadP" -> RadPn
                "RadU" -> RadUm

                "DurP" -> DurPn
                "DurU" -> DurUm
                "DurT" -> DurTo

                "ARmMx" -> ARm2Mx
                "ARmP1" -> ARm2P1
                "ARmP4" -> ARm2P4
                "ARmU1" -> ARm2U1
                "ARmU4" -> ARm2U4
                "ARmU2" -> ARm2U2
                "ARmU3" -> ARm2U3

                "dmMx" -> dm2Mx
                "dmP1" -> dm2P1
                "dmP4" -> dm2P4
                "dmU1" -> dm2U1
                "dmU4" -> dm2U4
                "dmU2" -> dm2U2
                "dmU3" -> dm2U3

                "SdmMx" -> Sdm2Mx
                "SdmP1" -> Sdm2P1
                "SdmP4" -> Sdm2P4
                "SdmU1" -> Sdm2U1
                "SdmU4" -> Sdm2U4
                "SdmU2" -> Sdm2U2
                "SdmU3" -> Sdm2U3

                "HPmMx" -> HPm2Mx
                "HPmP1" -> HPm2P1
                "HPmP4" -> HPm2P4
                "HPmU1" -> HPm2U1
                "HPmU4" -> HPm2U4
                "HPmU2" -> HPm2U2
                "HPmU3" -> HPm2U3

                "HmMx" -> Hm2Mx
                "HmP1" -> Hm2P1
                "HmP4" -> Hm2P4
                "HmU1" -> Hm2U1
                "HmU4" -> Hm2U4
                "HmU2" -> Hm2U2
                "HmU3" -> Hm2U3

                "ARsMx" -> ARs2Mx
                "ARsP1" -> ARs2P1
                "ARsP4" -> ARs2P4
                "ARsU1" -> ARs2U1
                "ARsU4" -> ARs2U4
                "ARsU2" -> ARs2U2
                "ARsU3" -> ARs2U3

                "dsMx" -> ds2Mx
                "dsP1" -> ds2P1
                "dsP4" -> ds2P4
                "dsU1" -> ds2U1
                "dsU4" -> ds2U4
                "dsU2" -> ds2U2
                "dsU3" -> ds2U3

                "SdsMx" -> Sds2Mx
                "SdsP1" -> Sds2P1
                "SdsP4" -> Sds2P4
                "SdsU1" -> Sds2U1
                "SdsU4" -> Sds2U4
                "SdsU2" -> Sds2U2
                "SdsU3" -> Sds2U3

                "HPsMx" -> HPs2Mx
                "HPsP1" -> HPs2P1
                "HPsP4" -> HPs2P4
                "HPsU1" -> HPs2U1
                "HPsU4" -> HPs2U4
                "HPsU2" -> HPs2U2
                "HPsU3" -> HPs2U3

                "HsMx" -> Hs2Mx
                "HsP1" -> Hs2P1
                "HsP4" -> Hs2P4
                "HsU1" -> Hs2U1
                "HsU4" -> Hs2U4
                "HsU2" -> Hs2U2
                "HsU3" -> Hs2U3

                "AzmMx" -> Azm2Mx
                "AzmP1" -> Azm2P1
                "AzmP4" -> Azm2P4
                "AzmU1" -> Azm2U1
                "AzmU4" -> Azm2U4
                "AzmU2" -> Azm2U2
                "AzmU3" -> Azm2U3

                "AltMx" -> Alt2Mx
                "AltP1" -> Alt2P1
                "AltP4" -> Alt2P4
                "AltU1" -> Alt2U1
                "AltU4" -> Alt2U4
                "AltU2" -> Alt2U2
                "AltU3" -> Alt2U3
                else -> jdMx
            }
        } else {
            Double.NaN
        }
    }


    //Besselian Elements
    println("Besselian Elements of Lunar Eclipse")
    val LBE = arrayOf(
        "JDLE " to "JDL",
        "DT   " to "DT",
        "T0   " to "T0",

        "x0   " to "x0",
        "x1   " to "x1",
        "x2   " to "x2",
        "x3   " to "x3",
        "x4   " to "x4",

        "y0   " to "y0",
        "y1   " to "y1",
        "y2   " to "y2",
        "y3   " to "y3",
        "y4   " to "y4",

        "d0   " to "d0",
        "d1   " to "d1",
        "d2   " to "d2",
        "d3   " to "d3",
        "d4   " to "d4",

        "f10  " to "f10",
        "f11  " to "f11",
        "f12  " to "f12",
        "f13  " to "f13",
        "f14  " to "f14",

        "f20  " to "f20",
        "f21  " to "f21",
        "f22  " to "f22",
        "f23  " to "f23",
        "f24  " to "f24",

        "Sm0  " to "Sm0",
        "Sm1  " to "Sm1",
        "Sm2  " to "Sm2",
        "Sm3  " to "Sm3",
        "Sm4  " to "Sm4",

        "HPm0 " to "HP0",
        "HPm1 " to "HP1",
        "HPm2 " to "HP2",
        "HPm3 " to "HP3",
        "HPm4 " to "HP4"
    )

    for (t in LBE) {
        val tVal = LBesselian(HijriMonth, HijriYear, t.second)
        val tVt: String =
            if (tVal < 0.0) tVal.round(7) else if (t.second == "T0") " " + tVal.round(0) else if (t.second == "DT") " " + tVal.round(
                1
            ) + "s" else " " + tVal.round(7)
        if (!tVal.isNaN()) {
            println(t.first + "  : " + tVt)
        } else {
            println(t.first + "  : -")
        }
    }

    //Jenis Gerhana Bulan
    println("")
    println("$LEK")

    val tLE = arrayOf(
        "P1" to "P1",
        "U1" to "U1",
        "U2" to "U2",
        "Mx" to "Mx",
        "U3" to "U3",
        "U4" to "U4",
        "P4" to "P4"
    )

    for (t in tLE) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        if (!tVal.isNaN()) {
            val tTgl = jd.JDKM(+tVal, TmZn)
            val tJam =
                if (t.second == "Mx") mf.DHHMS(jd.JDKM(tVal, TmZn, "Jam Des").toDouble(), "HH:MM:SS", 1) else mf.DHHMS(
                    jd.JDKM(tVal, TmZn, "Jam Des").toDouble(),
                    "HH:MM:SS",
                    0
                )
            println(t.first + "  : " + tTgl + ", Jam: " + tJam)
        } else {
            println(t.first + "  : -")
        }
    }

    //Magnitude, Radius dan Durasi Gerhana
    println(" ")
    val MagLE = arrayOf(
        "Magnitude Penumbra  " to "MagP",
        "Magnitude Umbra     " to "MagU",
        "Radius Penumbra     " to "RadP",
        "Radius Umbra        " to "RadU"
    )
    for (t in MagLE) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        val tVt: String = if (tVal < 0.0) tVal.round(4) else " " + tVal.round(4)
        if (!tVal.isNaN()) {
            println(t.first + ":" + tVt)
        } else {
            println(t.first + ": -")
        }
    }

    println(" ")
    val tDLE = arrayOf(
        "Durasi Penumbra     " to "DurP",
        "Durasi Umbra        " to "DurU",
        "Durasi Total        " to "DurT"
    )
    for (t in tDLE) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        if (!tVal.isNaN()) {
            println(t.first + ": " + mf.DHHMS(tVal, "HH:MM:SS", 0))
        } else {
            println(t.first + ": -")
        }
    }

    val LEAzmAlt = arrayOf(
        "Azimut P1           " to "AzmP1",
        "Azimut U1           " to "AzmU1",
        "Azimut U2           " to "AzmU2",
        "Azimut Mx           " to "AzmMx",
        "Azimut U3           " to "AzmU3",
        "Azimut U4           " to "AzmU4",
        "Azimut P4           " to "AzmP4",
        "Altitude P1         " to "AltP1",
        "Altitude U1         " to "AltU1",
        "Altitude U2         " to "AltU2",
        "Altitude Mx         " to "AltMx",
        "Altitude U3         " to "AltU3",
        "Altitude U4         " to "AltU4",
        "Altitude P4         " to "AltP4"
    )

    println("")
    println("Altitude dan Azimut tiap kontak gerhana")
    for (t in LEAzmAlt) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        if (!tVal.isNaN()) {
            println(t.first + ": " + mf.DDDMS(tVal, "DDMMSS", 0))
        } else {
            println(t.first + ": -")
        }
    }

    val dLE = arrayOf(
        "R.A" to "ARsMx",
        "Dec" to "dsMx",
        "S.D" to "SdsMx",
        "H.P" to "HPsMx"
    )
    println(" ")
    println("Data Matahari saat puncak gerhana")
    for (t in dLE) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        val tVt: String = if (t.second == "ARsMx") mf.DHHMS(tVal / 15.0, "HHMMSS", 1, "+-") else mf.DDDMS(tVal, "", 1)
        if (!tVal.isNaN()) {
            println(t.first + ": " + tVt)
        } else
            println(t.first + ": -")
    }

    val dLE2 = arrayOf(
        "R.A" to "ARmMx",
        "Dec" to "dmMx",
        "S.D" to "SdmMx",
        "H.P" to "HPmMx"
    )
    println(" ")
    println("Data Bulan saat puncak gerhana")
    for (t in dLE2) {
        val tVal = LunarEclipse(HijriMonth, HijriYear, gLon, gLat, t.second)
        val tVt: String = if (t.second == "ARmMx") mf.DHHMS(tVal / 15.0, "HHMMSS", 1, "+-")
        else mf.DDDMS(tVal, "", 1)
        if (!tVal.isNaN()) {
            println(t.first + ": " + tVt)
        } else
            println(t.first + ": -")
    }

}







