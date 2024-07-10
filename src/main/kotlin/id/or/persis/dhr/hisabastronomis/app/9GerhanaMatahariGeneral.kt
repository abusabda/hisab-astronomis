package id.or.persis.dhr.hisabastronomis.app

import id.or.persis.dhr.hisabastronomis.islamicTimes.*

fun main() {
    val jd = JulianDay()
    val dt = DynamicalTime()
    val mf = MathFunction()
    val mo = MoonOtherFunc()
    val md = MoonDistance()
    val sn = SunDatas()

    fun Double.round(decimals: Int = 2): String {
        return "%.${decimals}f".format(this)
    }

    //Input
    val blnH: Byte = 5
    val thnH: Long = 1437

    // Solar Besselian Element
    fun SBesselian(
        hijriMonth: Byte,
        hijriYear: Long,
        optResult: String
    ): Double {
        val jdeSolarEclipse1 = mo.jdeEclipseModified(hijriMonth, hijriYear, 1)
        return if (jdeSolarEclipse1 > 0) {
            val jdeSolarEclipse2 =
                Math.floor(jdeSolarEclipse1) + (((jdeSolarEclipse1 - Math.floor(jdeSolarEclipse1)) * 24).round(0)).toDouble() / 24.0
            val t0 = mf.Mod((((jdeSolarEclipse2 - Math.floor(jdeSolarEclipse2)) * 24).round(0).toDouble()), 24.0)
            val deltaT = (dt.DeltaT2(jdeSolarEclipse2)).round(1).toDouble()

            val arSm2 = sn.sunGeocentricRightAscension(jdeSolarEclipse2 - 2 / 24.0)
            val arSm1 = sn.sunGeocentricRightAscension(jdeSolarEclipse2 - 1 / 24.0)
            val arS00 = sn.sunGeocentricRightAscension(jdeSolarEclipse2)
            val arSp1 = sn.sunGeocentricRightAscension(jdeSolarEclipse2 + 1 / 24.0)
            val arSp2 = sn.sunGeocentricRightAscension(jdeSolarEclipse2 + 2 / 24.0)

            val dSm2 = sn.sunGeocentricDeclination(jdeSolarEclipse2 - 2 / 24.0)
            val dSm1 = sn.sunGeocentricDeclination(jdeSolarEclipse2 - 1 / 24.0)
            val dS00 = sn.sunGeocentricDeclination(jdeSolarEclipse2)
            val dSp1 = sn.sunGeocentricDeclination(jdeSolarEclipse2 + 1 / 24.0)
            val dSp2 = sn.sunGeocentricDeclination(jdeSolarEclipse2 + 2 / 24.0)

            val rSm2 = sn.sunGeocentricDistance(jdeSolarEclipse2 - 2 / 24.0)
            val rSm1 = sn.sunGeocentricDistance(jdeSolarEclipse2 - 1 / 24.0)
            val rS00 = sn.sunGeocentricDistance(jdeSolarEclipse2)
            val rSp1 = sn.sunGeocentricDistance(jdeSolarEclipse2 + 1 / 24.0)
            val rSp2 = sn.sunGeocentricDistance(jdeSolarEclipse2 + 2 / 24.0)

            val ghaSm2 = sn.sunGeocentricGreenwichHourAngle(jdeSolarEclipse2 - 2 / 24.0)
            val ghaSm1 = sn.sunGeocentricGreenwichHourAngle(jdeSolarEclipse2 - 1 / 24.0)
            val ghaS00 = sn.sunGeocentricGreenwichHourAngle(jdeSolarEclipse2)
            val ghaSp1 = sn.sunGeocentricGreenwichHourAngle(jdeSolarEclipse2 + 1 / 24.0)
            val ghaSp2 = sn.sunGeocentricGreenwichHourAngle(jdeSolarEclipse2 + 2 / 24.0)

            val arMm2 = mo.moonGeocentricRightAscension(jdeSolarEclipse2 - 2 / 24.0)
            val arMm1 = mo.moonGeocentricRightAscension(jdeSolarEclipse2 - 1 / 24.0)
            val arM00 = mo.moonGeocentricRightAscension(jdeSolarEclipse2)
            val arMp1 = mo.moonGeocentricRightAscension(jdeSolarEclipse2 + 1 / 24.0)
            val arMp2 = mo.moonGeocentricRightAscension(jdeSolarEclipse2 + 2 / 24.0)

            val dMm2 = mo.moonGeocentricDeclination(jdeSolarEclipse2 - 2 / 24.0)
            val dMm1 = mo.moonGeocentricDeclination(jdeSolarEclipse2 - 1 / 24.0)
            val dM00 = mo.moonGeocentricDeclination(jdeSolarEclipse2)
            val dMp1 = mo.moonGeocentricDeclination(jdeSolarEclipse2 + 1 / 24.0)
            val dMp2 = mo.moonGeocentricDeclination(jdeSolarEclipse2 + 2 / 24.0)

            val rMm2 = (md.moonGeocentricDistance(jdeSolarEclipse2, deltaT, "AU") - 2 / 24.0)
            val rMm1 = (md.moonGeocentricDistance(jdeSolarEclipse2, deltaT, "AU") - 1 / 24.0)
            val rM00 = md.moonGeocentricDistance(jdeSolarEclipse2, deltaT, "AU")
            val rMp1 = (md.moonGeocentricDistance(jdeSolarEclipse2, deltaT, "AU") + 1 / 24.0)
            val rMp2 = (md.moonGeocentricDistance(jdeSolarEclipse2, deltaT, "AU") + 2 / 24.0)

            val hpMm2 = mo.moonEquatorialHorizontalParallax(jdeSolarEclipse2 - 2 / 24.0)
            val hpMm1 = mo.moonEquatorialHorizontalParallax(jdeSolarEclipse2 - 1 / 24.0)
            val hpM00 = mo.moonEquatorialHorizontalParallax(jdeSolarEclipse2)
            val hpMp1 = mo.moonEquatorialHorizontalParallax(jdeSolarEclipse2 + 1 / 24.0)
            val hpMp2 = mo.moonEquatorialHorizontalParallax(jdeSolarEclipse2 + 2 / 24.0)

            val bm2 = Math.sin(mf.Rad(8.794 / 3600.0)) / rSm2 / Math.sin(mf.Rad(hpMm2))
            val bm1 = Math.sin(mf.Rad(8.794 / 3600.0)) / rSm1 / Math.sin(mf.Rad(hpMm1))
            val b00 = Math.sin(mf.Rad(8.794 / 3600.0)) / rS00 / Math.sin(mf.Rad(hpM00))
            val bp1 = Math.sin(mf.Rad(8.794 / 3600.0)) / rSp1 / Math.sin(mf.Rad(hpMp1))
            val bp2 = Math.sin(mf.Rad(8.794 / 3600.0)) / rSp2 / Math.sin(mf.Rad(hpMp2))

            val g1m2 =
                Math.cos(mf.Rad(dSm2)) * Math.cos(mf.Rad(arSm2)) - bm2 * Math.cos(mf.Rad(dMm2)) * Math.cos(mf.Rad(arMm2))
            val g1m1 =
                Math.cos(mf.Rad(dSm1)) * Math.cos(mf.Rad(arSm1)) - bm1 * Math.cos(mf.Rad(dMm1)) * Math.cos(mf.Rad(arMm1))
            val g100 =
                Math.cos(mf.Rad(dS00)) * Math.cos(mf.Rad(arS00)) - b00 * Math.cos(mf.Rad(dM00)) * Math.cos(mf.Rad(arM00))
            val g1p1 =
                Math.cos(mf.Rad(dSp1)) * Math.cos(mf.Rad(arSp1)) - bp1 * Math.cos(mf.Rad(dMp1)) * Math.cos(mf.Rad(arMp1))
            val g1p2 =
                Math.cos(mf.Rad(dSp2)) * Math.cos(mf.Rad(arSp2)) - bp2 * Math.cos(mf.Rad(dMp2)) * Math.cos(mf.Rad(arMp2))

            val g2m2 =
                Math.cos(mf.Rad(dSm2)) * Math.sin(mf.Rad(arSm2)) - bm2 * Math.cos(mf.Rad(dMm2)) * Math.sin(mf.Rad(arMm2))
            val g2m1 =
                Math.cos(mf.Rad(dSm1)) * Math.sin(mf.Rad(arSm1)) - bm1 * Math.cos(mf.Rad(dMm1)) * Math.sin(mf.Rad(arMm1))
            val g200 =
                Math.cos(mf.Rad(dS00)) * Math.sin(mf.Rad(arS00)) - b00 * Math.cos(mf.Rad(dM00)) * Math.sin(mf.Rad(arM00))
            val g2p1 =
                Math.cos(mf.Rad(dSp1)) * Math.sin(mf.Rad(arSp1)) - bp1 * Math.cos(mf.Rad(dMp1)) * Math.sin(mf.Rad(arMp1))
            val g2p2 =
                Math.cos(mf.Rad(dSp2)) * Math.sin(mf.Rad(arSp2)) - bp2 * Math.cos(mf.Rad(dMp2)) * Math.sin(mf.Rad(arMp2))

            val g3m2 = Math.sin(mf.Rad(dSm2)) - bm2 * Math.sin(mf.Rad(dMm2))
            val g3m1 = Math.sin(mf.Rad(dSm1)) - bm1 * Math.sin(mf.Rad(dMm1))
            val g300 = Math.sin(mf.Rad(dS00)) - b00 * Math.sin(mf.Rad(dM00))
            val g3p1 = Math.sin(mf.Rad(dSp1)) - bp1 * Math.sin(mf.Rad(dMp1))
            val g3p2 = Math.sin(mf.Rad(dSp2)) - bp2 * Math.sin(mf.Rad(dMp2))

            val am2 = mf.Mod(mf.Deg(Math.atan2(g2m2, g1m2)), 360.0)
            val am1 = mf.Mod(mf.Deg(Math.atan2(g2m1, g1m1)), 360.0)
            val a00 = mf.Mod(mf.Deg(Math.atan2(g200, g100)), 360.0)
            val ap1 = mf.Mod(mf.Deg(Math.atan2(g2p1, g1p1)), 360.0)
            val ap2 = mf.Mod(mf.Deg(Math.atan2(g2p2, g1p2)), 360.0)

            val dm2 = mf.Deg(Math.atan(g3m2 / Math.sqrt(g1m2 * g1m2 + g2m2 * g2m2)))
            val dm1 = mf.Deg(Math.atan(g3m1 / Math.sqrt(g1m1 * g1m1 + g2m1 * g2m1)))
            val d00 = mf.Deg(Math.atan(g300 / Math.sqrt(g100 * g100 + g200 * g200)))
            val dp1 = mf.Deg(Math.atan(g3p1 / Math.sqrt(g1p1 * g1p1 + g2p1 * g2p1)))
            val dp2 = mf.Deg(Math.atan(g3p2 / Math.sqrt(g1p2 * g1p2 + g2p2 * g2p2)))

            val gm2 = Math.sqrt(g1m2 * g1m2 + g2m2 * g2m2 + g3m2 * g3m2)
            val gm1 = Math.sqrt(g1m1 * g1m1 + g2m1 * g2m1 + g3m1 * g3m1)
            val g00 = Math.sqrt(g100 * g100 + g200 * g200 + g300 * g300)
            val gp1 = Math.sqrt(g1p1 * g1p1 + g2p1 * g2p1 + g3p1 * g3p1)
            val gp2 = Math.sqrt(g1p2 * g1p2 + g2p2 * g2p2 + g3p2 * g3p2)

            val xm2 = (Math.cos(mf.Rad(dMm2)) * Math.sin(mf.Rad(arMm2 - am2))) / Math.sin(mf.Rad(hpMm2))
            val xm1 = (Math.cos(mf.Rad(dMm1)) * Math.sin(mf.Rad(arMm1 - am1))) / Math.sin(mf.Rad(hpMm1))
            val x00 = (Math.cos(mf.Rad(dM00)) * Math.sin(mf.Rad(arM00 - a00))) / Math.sin(mf.Rad(hpM00))
            val xp1 = (Math.cos(mf.Rad(dMp1)) * Math.sin(mf.Rad(arMp1 - ap1))) / Math.sin(mf.Rad(hpMp1))
            val xp2 = (Math.cos(mf.Rad(dMp2)) * Math.sin(mf.Rad(arMp2 - ap2))) / Math.sin(mf.Rad(hpMp2))

            val ym2 =
                (Math.sin(mf.Rad(dMm2)) * Math.cos(mf.Rad(dm2)) - Math.cos(mf.Rad(dMm2)) * Math.sin(mf.Rad(dm2)) * Math.cos(
                    mf.Rad(arMm2 - am2)
                )) / Math.sin(mf.Rad(hpMm2))
            val ym1 =
                (Math.sin(mf.Rad(dMm1)) * Math.cos(mf.Rad(dm1)) - Math.cos(mf.Rad(dMm1)) * Math.sin(mf.Rad(dm1)) * Math.cos(
                    mf.Rad(arMm1 - am1)
                )) / Math.sin(mf.Rad(hpMm1))
            val y00 =
                (Math.sin(mf.Rad(dM00)) * Math.cos(mf.Rad(d00)) - Math.cos(mf.Rad(dM00)) * Math.sin(mf.Rad(d00)) * Math.cos(
                    mf.Rad(arM00 - a00)
                )) / Math.sin(mf.Rad(hpM00))
            val yp1 =
                (Math.sin(mf.Rad(dMp1)) * Math.cos(mf.Rad(dp1)) - Math.cos(mf.Rad(dMp1)) * Math.sin(mf.Rad(dp1)) * Math.cos(
                    mf.Rad(arMp1 - ap1)
                )) / Math.sin(mf.Rad(hpMp1))
            val yp2 =
                (Math.sin(mf.Rad(dMp2)) * Math.cos(mf.Rad(dp2)) - Math.cos(mf.Rad(dMp2)) * Math.sin(mf.Rad(dp2)) * Math.cos(
                    mf.Rad(arMp2 - ap2)
                )) / Math.sin(mf.Rad(hpMp2))

            val zm2 =
                (Math.sin(mf.Rad(dMm2)) * Math.sin(mf.Rad(dm2)) + Math.cos(mf.Rad(dMm2)) * Math.cos(mf.Rad(dm2)) * Math.cos(
                    mf.Rad(arMm2 - am2)
                )) / Math.sin(mf.Rad(hpMm2))
            val zm1 =
                (Math.sin(mf.Rad(dMm1)) * Math.sin(mf.Rad(dm1)) + Math.cos(mf.Rad(dMm1)) * Math.cos(mf.Rad(dm1)) * Math.cos(
                    mf.Rad(arMm1 - am1)
                )) / Math.sin(mf.Rad(hpMm1))
            val z00 =
                (Math.sin(mf.Rad(dM00)) * Math.sin(mf.Rad(d00)) + Math.cos(mf.Rad(dM00)) * Math.cos(mf.Rad(d00)) * Math.cos(
                    mf.Rad(arM00 - a00)
                )) / Math.sin(mf.Rad(hpM00))
            val zp1 =
                (Math.sin(mf.Rad(dMp1)) * Math.sin(mf.Rad(dp1)) + Math.cos(mf.Rad(dMp1)) * Math.cos(mf.Rad(dp1)) * Math.cos(
                    mf.Rad(arMp1 - ap1)
                )) / Math.sin(mf.Rad(hpMp1))
            val zp2 =
                (Math.sin(mf.Rad(dMp2)) * Math.sin(mf.Rad(dp2)) + Math.cos(mf.Rad(dMp2)) * Math.cos(mf.Rad(dp2)) * Math.cos(
                    mf.Rad(arMp2 - ap2)
                )) / Math.sin(mf.Rad(hpMp2))

            val sinf1m2 = 0.004664026 / (gm2 * rSm2)
            val sinf1m1 = 0.004664026 / (gm1 * rSm1)
            val sinf100 = 0.004664026 / (g00 * rS00)
            val sinf1p1 = 0.004664026 / (gp1 * rSp1)
            val sinf1p2 = 0.004664026 / (gp2 * rSp2)

            val sinf2m2 = 0.004640784 / (gm2 * rSm2)
            val sinf2m1 = 0.004640784 / (gm1 * rSm1)
            val sinf200 = 0.004640784 / (g00 * rS00)
            val sinf2p1 = 0.004640784 / (gp1 * rSp1)
            val sinf2p2 = 0.004640784 / (gp2 * rSp2)

            val tanf1m2 = Math.tan(Math.asin(sinf1m2))
            val tanf1m1 = Math.tan(Math.asin(sinf1m1))
            val tanf100 = Math.tan(Math.asin(sinf100))
            val tanf1p1 = Math.tan(Math.asin(sinf1p1))
            val tanf1p2 = Math.tan(Math.asin(sinf1p2))

            val tanf2m2 = Math.tan(Math.tan(sinf2m2))
            val tanf2m1 = Math.tan(Math.tan(sinf2m1))
            val tanf200 = Math.tan(Math.tan(sinf200))
            val tanf2p1 = Math.tan(Math.tan(sinf2p1))
            val tanf2p2 = Math.tan(Math.tan(sinf2p2))

            val c1m2 = zm2 + 0.2724880 / sinf1m2  //K1
            val c1m1 = zm1 + 0.2724880 / sinf1m1
            val c100 = z00 + 0.2724880 / sinf100
            val c1p1 = zp1 + 0.2724880 / sinf1p1
            val c1p2 = zp2 + 0.2724880 / sinf1p2

            val c2m2 = zm2 - 0.2722810 / sinf2m2 //K2
            val c2m1 = zm1 - 0.2722810 / sinf2m1
            val c200 = z00 - 0.2722810 / sinf200
            val c2p1 = zp1 - 0.2722810 / sinf2p1
            val c2p2 = zp2 - 0.2722810 / sinf2p2

            val l1m2 = c1m2 * tanf1m2
            val l1m1 = c1m1 * tanf1m1
            val l100 = c100 * tanf100
            val l1p1 = c1p1 * tanf1p1
            val l1p2 = c1p2 * tanf1p2

            val l2m2 = c2m2 * tanf2m2
            val l2m1 = c2m1 * tanf2m1
            val l200 = c200 * tanf200
            val l2p1 = c2p1 * tanf2p1
            val l2p2 = c2p2 * tanf2p2

            val gastm2 = sn.greenwichApparentSiderialTime(jdeSolarEclipse2 - 2 / 24.0)
            val gastm1 = sn.greenwichApparentSiderialTime(jdeSolarEclipse2 - 1 / 24.0)
            val gast00 = sn.greenwichApparentSiderialTime(jdeSolarEclipse2)
            val gastp1 = sn.greenwichApparentSiderialTime(jdeSolarEclipse2 + 1 / 24.0)
            val gastp2 = sn.greenwichApparentSiderialTime(jdeSolarEclipse2 + 2 / 24.0)

            val mum2 = mf.Mod(gastm2 - am2, 360.0)
            val mum1 = mf.Mod(gastm1 - am1, 360.0)
            val mu00 = mf.Mod(gast00 - a00, 360.0)
            val mup1 = mf.Mod(gastp1 - ap1, 360.0)
            val mup2 = mf.Mod(gastp2 - ap2, 360.0)

            return when (optResult) {
                "JDS" -> jdeSolarEclipse2
                "DT" -> deltaT
                "x0" -> mf.InterpolationFromFiveTabularValues(xm2, xm1, x00, xp1, xp2, 0)
                "x1" -> mf.InterpolationFromFiveTabularValues(xm2, xm1, x00, xp1, xp2, 1)
                "x2" -> mf.InterpolationFromFiveTabularValues(xm2, xm1, x00, xp1, xp2, 2)
                "x3" -> mf.InterpolationFromFiveTabularValues(xm2, xm1, x00, xp1, xp2, 3)
                "x4" -> mf.InterpolationFromFiveTabularValues(xm2, xm1, x00, xp1, xp2, 4)

                "y0" -> mf.InterpolationFromFiveTabularValues(ym2, ym1, y00, yp1, yp2, 0)
                "y1" -> mf.InterpolationFromFiveTabularValues(ym2, ym1, y00, yp1, yp2, 1)
                "y2" -> mf.InterpolationFromFiveTabularValues(ym2, ym1, y00, yp1, yp2, 2)
                "y3" -> mf.InterpolationFromFiveTabularValues(ym2, ym1, y00, yp1, yp2, 3)
                "y4" -> mf.InterpolationFromFiveTabularValues(ym2, ym1, y00, yp1, yp2, 4)

                "d0" -> mf.InterpolationFromFiveTabularValues(dm2, dm1, d00, dp1, dp2, 0)
                "d1" -> mf.InterpolationFromFiveTabularValues(dm2, dm1, d00, dp1, dp2, 1)
                "d2" -> mf.InterpolationFromFiveTabularValues(dm2, dm1, d00, dp1, dp2, 2)
                "d3" -> mf.InterpolationFromFiveTabularValues(dm2, dm1, d00, dp1, dp2, 3)
                "d4" -> mf.InterpolationFromFiveTabularValues(dm2, dm1, d00, dp1, dp2, 4)

                "L10" -> mf.InterpolationFromFiveTabularValues(l1m2, l1m1, l100, l1p1, l1p2, 0)
                "L11" -> mf.InterpolationFromFiveTabularValues(l1m2, l1m1, l100, l1p1, l1p2, 1)
                "L12" -> mf.InterpolationFromFiveTabularValues(l1m2, l1m1, l100, l1p1, l1p2, 2)
                "L13" -> mf.InterpolationFromFiveTabularValues(l1m2, l1m1, l100, l1p1, l1p2, 3)
                "L14" -> mf.InterpolationFromFiveTabularValues(l1m2, l1m1, l100, l1p1, l1p2, 4)

                "L20" -> mf.InterpolationFromFiveTabularValues(l2m2, l2m1, l200, l2p1, l2p2, 0)
                "L21" -> mf.InterpolationFromFiveTabularValues(l2m2, l2m1, l200, l2p1, l2p2, 1)
                "L22" -> mf.InterpolationFromFiveTabularValues(l2m2, l2m1, l200, l2p1, l2p2, 2)
                "L23" -> mf.InterpolationFromFiveTabularValues(l2m2, l2m1, l200, l2p1, l2p2, 3)
                "L24" -> mf.InterpolationFromFiveTabularValues(l2m2, l2m1, l200, l2p1, l2p2, 4)

                "Mu0" -> mf.InterpolationFromFiveTabularValues(mum2, mum1, mu00, mup1, mup2, 0)
                "Mu1" -> mf.InterpolationFromFiveTabularValues(mum2, mum1, mu00, mup1, mup2, 1)
                "Mu2" -> mf.InterpolationFromFiveTabularValues(mum2, mum1, mu00, mup1, mup2, 2)
                "Mu3" -> mf.InterpolationFromFiveTabularValues(mum2, mum1, mu00, mup1, mup2, 3)
                "Mu4" -> mf.InterpolationFromFiveTabularValues(mum2, mum1, mu00, mup1, mup2, 4)

                "f1" -> tanf100
                "f2" -> tanf200

                "dSm2" -> dSm2
                "dSm1" -> dSm1
                "dS00" -> dS00
                "dSp1" -> dSp1
                "dSp2" -> dSp2

                "arSm2" -> arSm2
                "arSm1" -> arSm1
                "arS00" -> arS00
                "arSp1" -> arSp1
                "arSp2" -> arSp2

                "rSm2" -> rSm2
                "rSm1" -> rSm1
                "rS00" -> rS00
                "rSp1" -> rSp1
                "rSp2" -> rSp2

                "ghaSm2" -> ghaSm2
                "ghaSm1" -> ghaSm1
                "ghaS00" -> ghaS00
                "ghaSp1" -> ghaSp1
                "ghaSp2" -> ghaSp2

                "dMm2" -> dMm2
                "dMm1" -> dMm1
                "dM00" -> dM00
                "dMp1" -> dMp1
                "dMp2" -> dMp2

                "arMm2" -> arMm2
                "arMm1" -> arMm1
                "arM00" -> arM00
                "arMp1" -> arMp1
                "arMp2" -> arMp2

                "rMm2" -> rMm2
                "rMm1" -> rMm1
                "rM00" -> rM00
                "rMp1" -> rMp1
                "rMp2" -> rMp2

                "hpMm2" -> hpMm2
                "hpMm1" -> hpMm1
                "hpM00" -> hpM00
                "hpMp1" -> hpMp1
                "hpMp2" -> hpMp2

                "bm2" -> bm2
                "bm1" -> bm1
                "b00" -> b00
                "bp1" -> bp1
                "bp2" -> bp2

                "g1m2" -> g1m2
                "g1m1" -> g1m1
                "g100" -> g100
                "g1p1" -> g1p1
                "g1p2" -> g1p2

                "g2m2" -> g2m2
                "g2m1" -> g2m1
                "g200" -> g200
                "g2p1" -> g2p1
                "g2p2" -> g2p2

                "g3m2" -> g3m2
                "g3m1" -> g3m1
                "g300" -> g300
                "g3p1" -> g3p1
                "g3p2" -> g3p2

                else -> mf.Mod(t0 + 12, 24.0)
            }
        } else {
            Double.NaN
        }

    }

    //Puncak Gerhana Matahari General
    val T0 = SBesselian(blnH, thnH, "T0")
    val DT = SBesselian(blnH, thnH, "DT")

    val x0 = SBesselian(blnH, thnH, "x0")
    val x1 = SBesselian(blnH, thnH, "x1")
    val x2 = SBesselian(blnH, thnH, "x2")
    val x3 = SBesselian(blnH, thnH, "x3")
    val x4 = SBesselian(blnH, thnH, "x4")

    val y0 = SBesselian(blnH, thnH, "y0")
    val y1 = SBesselian(blnH, thnH, "y1")
    val y2 = SBesselian(blnH, thnH, "y2")
    val y3 = SBesselian(blnH, thnH, "y3")
    val y4 = SBesselian(blnH, thnH, "y4")

    val d0 = SBesselian(blnH, thnH, "d0")
    val d1 = SBesselian(blnH, thnH, "d1")
    val d2 = SBesselian(blnH, thnH, "d2")
    val d3 = SBesselian(blnH, thnH, "d3")
    val d4 = SBesselian(blnH, thnH, "d4")

    val Mu0 = SBesselian(blnH, thnH, "Mu0")
    val Mu1 = SBesselian(blnH, thnH, "Mu1")
    val Mu2 = SBesselian(blnH, thnH, "Mu2")
    val Mu3 = SBesselian(blnH, thnH, "Mu3")
    val Mu4 = SBesselian(blnH, thnH, "Mu4")
    val L10 = SBesselian(blnH, thnH, "L10")
    val L11 = SBesselian(blnH, thnH, "L11")
    val L12 = SBesselian(blnH, thnH, "L12")
    val L13 = SBesselian(blnH, thnH, "L13")
    val L14 = SBesselian(blnH, thnH, "L14")
    val L20 = SBesselian(blnH, thnH, "L20")
    val L21 = SBesselian(blnH, thnH, "L21")
    val L22 = SBesselian(blnH, thnH, "L22")
    val L23 = SBesselian(blnH, thnH, "L23")
    val L24 = SBesselian(blnH, thnH, "L24")

    val tanf1 = SBesselian(blnH, thnH, "f1")
    val tanf2 = SBesselian(blnH, thnH, "f2")

    var xMx: Double = 0.0
    var yMx: Double = 0.0
    var dMx: Double = 0.0
    var MuMx: Double = 0.0
    var xpMx: Double = 0.0
    var ypMx: Double = 0.0
    var mbMx: Double
    var msMx: Double = 0.0
    var nbMx: Double
    var nsMx: Double
    var tuMx: Double = 0.0
    var tMx: Double = 0.0
    val mXTD: Double
    val mXUT: Double

    tMx += tuMx
    for (i in 1..7) {
        xMx = x0 + x1 * tMx + x2 * tMx * tMx + x3 * tMx * tMx * tMx + x4 * tMx * tMx * tMx * tMx
        yMx = y0 + y1 * tMx + y2 * tMx * tMx + y3 * tMx * tMx * tMx + y4 * tMx * tMx * tMx * tMx

        dMx = d0 + d1 * tMx + d2 * tMx * tMx + d3 * tMx * tMx * tMx + d4 * tMx * tMx * tMx * tMx
        MuMx = Mu0 + Mu1 * tMx + Mu2 * tMx * tMx + Mu3 * tMx * tMx * tMx + Mu4 * tMx * tMx * tMx * tMx

        xpMx = x1 + 2 * x2 * tMx + 3 * x3 * tMx * tMx + 4 * x4 * tMx * tMx * tMx
        ypMx = y1 + 2 * y2 * tMx + 3 * y3 * tMx * tMx + 4 * y4 * tMx * tMx * tMx

        mbMx = mf.Mod(mf.Deg(Math.atan2(yMx, xMx)), 360.0)
        msMx = Math.pow((xMx * xMx + yMx * yMx), 0.5)

        nbMx = mf.Mod(mf.Deg(Math.atan2(ypMx, xpMx)), 360.0)
        nsMx = Math.pow((xpMx * xpMx + ypMx * ypMx), 0.5)

        tuMx = -(msMx * Math.cos(mf.Rad(mbMx - nbMx)) / nsMx)
        tMx = tMx + tuMx
    }

    mXTD = mf.Mod(T0 + tMx, 24.0)
    mXUT = mf.Mod(mXTD - DT / 3600.0, 24.0)

    //Tipe, Jenis dan Durasi Gerhana
    val L1Mx = L10 + L11 * tuMx + L12 * tuMx * tuMx + L13 * tuMx * tuMx * tuMx + L14 * tuMx * tuMx * tuMx * tuMx
    val L2Mx = L20 + L21 * tuMx + L22 * tuMx * tuMx + L23 * tuMx * tuMx * tuMx + L24 * tuMx * tuMx * tuMx * tuMx

    var jn01: String = when {
        msMx < 0.9972 -> when {
            L2Mx < 0 -> "Sentral Total"
            L2Mx > 0.0047 -> "Sentral Cincin"
            else -> "Sentral Hybrid"
        }

        msMx > 0.9972 -> when {
            L2Mx < 0 && msMx < (Math.abs(L2Mx) + 0.9972) -> "Non Sentral Total"
            L2Mx > 0 && msMx < (Math.abs(L2Mx) + 0.9972) -> "Non Sentral Cincin"
            msMx < (Math.abs(L2Mx) + 1.5433) -> "Non Sentral Sebagian"
            else -> ""
        }

        msMx > (Math.abs(L2Mx) + 1.5433) -> "Tidak ada gerhana"
        else -> "Tidak ada gerhana"
    }

    //Koordinat saat puncak gerhana
    val a = 6378137.0
    val b = 6356752.0
    val f: Double = (a - b) / a
    val e2: Double = (2 * f) - (f * f)

    val ba: Double = b / a
    val ab: Double = a / b

    val rho0: Double = Math.pow((1 - e2 * Math.cos(mf.Rad(dMx))), 0.5)
    val d1Mx: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dMx))) / (Math.cos(mf.Rad(dMx)) * ba)))
    val y1Mx: Double = yMx / rho0
    val m1Mx: Double = Math.pow(((xMx * xMx) + (y1Mx * y1Mx)), 0.5)
    val y2Mx: Double = y1Mx / m1Mx
    val bBig: Double = Math.pow((1 - xMx * xMx - y1Mx * y1Mx), 0.5)
    val pi1Mx: Double =
        if (msMx < 0.9972) mf.Deg(Math.asin(y1Mx * Math.cos(mf.Rad(d1Mx)) + bBig * Math.sin(mf.Rad(d1Mx)))) else mf.Deg(
            Math.asin(y2Mx * Math.cos(mf.Rad(d1Mx)))
        )
    val piMx: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1Mx))))
    val x2Mx: Double =
        if (msMx < 0.9972) -y1Mx * Math.sin(mf.Rad(d1Mx)) + bBig * Math.cos(mf.Rad(d1Mx)) else -y1Mx * Math.sin(
            mf.Rad(d1Mx)
        )
    val HAMx: Double = mf.Mod(mf.Deg(Math.atan2(xMx, x2Mx)), 360.0)
    val LdMx: Double
    val calc = HAMx - MuMx + (0.004178 * DT)
    LdMx = when {
        calc > 180 -> calc - 360
        calc < -180 -> calc + 360
        else -> calc
    }

    val L1pMx = L1Mx - bBig * tanf1
    val L2pMx = L2Mx - bBig * tanf2

    val pp: Double = mf.Rad(Mu1)
    val aa: Double = ypMx - pp * xMx * Math.sin(mf.Rad(dMx))
    val bb: Double = xpMx + pp * yMx * Math.sin(mf.Rad(dMx))
    val cc: Double = bb - pp * bBig * Math.cos(mf.Rad(dMx))
    val ns1: Double = Math.sqrt(cc * cc + aa * aa)
    val Dur: Double = (Math.abs(7200 * L2pMx / ns1)) / 60.0

    //Azimuth dan Altitude saat puncak gerhana
    val altMx: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piMx)) * Math.sin(mf.Rad(dMx)) + Math.cos(mf.Rad(piMx)) * Math.cos(mf.Rad(dMx)) * Math.cos(
                mf.Rad(HAMx)
            )
        )
    )
    val azmMx: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAMx)),
                Math.cos(mf.Rad(HAMx)) * Math.sin(mf.Rad(piMx)) - Math.tan(mf.Rad(dMx)) * Math.cos(mf.Rad(piMx))
            )
        ) + 180, 360.0
    )

    val rho: Double = msMx / m1Mx
    val DDD: Double = msMx - rho
    val Mag1: Double = (L1pMx - L2pMx) / (L1pMx + L2pMx)
    val Mag2: Double = (L1Mx - DDD) / (L1Mx + L2Mx)
    val Mag: Double = if (msMx < 0.9972) Mag1 else Mag2

    //lebar gerhana
    val kk: Double = Math.sqrt(bBig * bBig + Math.pow((xMx * cc + yMx * aa) / ns1, 2.0))
    val wd: Double = (Math.abs(12756 * L2pMx / kk))

    //Obskurasi (belum beres)
    val cBg: Double =
        if (msMx < 0.9972) Math.acos((L1pMx * L1pMx + L2pMx * L2pMx - 2 * DDD * DDD) / (L1pMx * L1pMx - L2pMx * L2pMx)) else Math.acos(
            (L1Mx * L1Mx + L2Mx * L2Mx - 2 * DDD * DDD) / (L1Mx * L1Mx - L2Mx * L2Mx)
        )
    val bBg: Double =
        if (msMx < 0.9972) Math.acos((L1pMx * L2pMx + DDD * DDD) / DDD * (L1pMx * L2pMx)) else Math.acos((L1Mx * L2Mx + DDD * DDD) / (DDD * (L1Mx * L2Mx)))
    val aBg: Double = Math.PI - (bBg + cBg)
    val sSm: Double = if (msMx < 0.9972) (L1pMx - L2pMx) / (L1pMx + L2pMx) else (L1Mx - L2Mx) / (L1Mx + L2Mx)
    val spB: Double =
        if (L2Mx < 0) 1.0 else if (L2Mx > 0.0 && L2Mx < 0.0047) sSm * sSm else if (L2Mx > 0.0 && L2Mx > 0.0047) sSm * sSm else ((sSm * sSm) * aBg + sSm - bBg * Math.sin(
            cBg
        )) / Math.PI


    //Penumbral First External Contact (P1)

    var xP1: Double = 0.0
    var yP1: Double = 0.0
    var dP1: Double = 0.0
    var MuP1: Double = 0.0
    var xpP1: Double = 0.0
    var ypP1: Double = 0.0
    var L1P1: Double = 0.0
    var omP1: Double = 0.0
    var msP1: Double = 0.0
    var y1P1: Double = 0.0
    var m1P1: Double = 0.0
    var roP1: Double = 0.0
    var n2P1: Double = 0.0
    var nsP1: Double = 0.0
    var psP1: Double = 0.0

    var tuP1: Double = 0.0
    var tP1: Double = 0.0

    tP1 += tuP1
    for (i in 1..5) {
        xP1 = x0 + x1 * tP1 + x2 * tP1 * tP1 + x3 * tP1 * tP1 * tP1 + x4 * tP1 * tP1 * tP1 * tP1
        yP1 = y0 + y1 * tP1 + y2 * tP1 * tP1 + y3 * tP1 * tP1 * tP1 + y4 * tP1 * tP1 * tP1 * tP1
        dP1 = d0 + d1 * tP1 + d2 * tP1 * tP1 + d3 * tP1 * tP1 * tP1 + d4 * tP1 * tP1 * tP1 * tP1
        MuP1 = Mu0 + Mu1 * tP1 + Mu2 * tP1 * tP1 + Mu3 * tP1 * tP1 * tP1 + Mu4 * tP1 * tP1 * tP1 * tP1

        xpP1 = x1 + 2 * x2 * tP1 + 3 * x3 * tP1 * tP1 + 4 * x4 * tP1 * tP1 * tP1
        ypP1 = y1 + 2 * y2 * tP1 + 3 * y3 * tP1 * tP1 + 4 * y4 * tP1 * tP1 * tP1

        L1P1 = L10 + L11 * tP1 + L12 * tP1 * tP1 + L13 * tP1 * tP1 * tP1 + L14 * tP1 * tP1 * tP1 * tP1

        omP1 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dP1)) * Math.cos(mf.Rad(dP1)))
        msP1 = Math.sqrt(xP1 * xP1 + yP1 * yP1)

        y1P1 = yP1 * omP1
        m1P1 = Math.sqrt(xP1 * xP1 + y1P1 * y1P1)
        roP1 = msP1 / m1P1

        n2P1 = (xpP1 * xpP1 + ypP1 * ypP1)
        nsP1 = Math.sqrt(n2P1)
        psP1 = Math.asin((xP1 * ypP1 - xpP1 * yP1) / (nsP1 * (L1P1 + roP1)))

        tuP1 = ((L1P1 + roP1) / nsP1) * -Math.cos(psP1) - (xP1 * xpP1 + yP1 * ypP1) / (nsP1 * nsP1)
        tP1 = tP1 + tuP1
    }

    val p1TD: Double = mf.Mod(T0 + tP1, 24.0)
    val p1UT: Double = mf.Mod(p1TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak P1
    val d1P1: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dP1))) / (Math.cos(mf.Rad(dP1)) * ba)))
    val rhP1: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dP1)), 2.0) + Math.pow(Math.cos(mf.Rad(dP1)) * ba, 2.0)), 0.5)
    val yIP1: Double = yP1 / rhP1
    val mIP1: Double = Math.pow(((xP1 * xP1) + (yIP1 * yIP1)), 0.5)
    val x1P1: Double = xP1 / mIP1
    val y2P1: Double = yIP1 / mIP1
    val pi1P1: Double = mf.Deg(Math.asin(y2P1 * Math.cos(mf.Rad(d1P1))))
    val piP1: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1P1))))
    val x2P1: Double = -y2P1 * Math.sin(mf.Rad(dP1))
    val HAP1: Double = mf.Mod(mf.Deg(Math.atan2(x1P1, x2P1)), 360.0)
    var LdP1: Double
    val caP1 = HAP1 - MuP1 + (0.004178 * DT)
    LdP1 = when {
        caP1 > 180 -> caP1 - 360
        caP1 < -180 -> caP1 + 360
        else -> caP1
    }

    //Azimuth dan Altitude saat kontak P1
    val altP1: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piP1)) * Math.sin(mf.Rad(dP1)) + Math.cos(mf.Rad(piP1)) * Math.cos(mf.Rad(dP1)) * Math.cos(
                mf.Rad(HAP1)
            )
        )
    )
    val azmP1: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAP1)),
                Math.cos(mf.Rad(HAP1)) * Math.sin(mf.Rad(piP1)) - Math.tan(mf.Rad(dP1)) * Math.cos(mf.Rad(piP1))
            )
        ) + 180, 360.0
    )


    //Penumbral Last External Contact (P4)

    var xP4: Double = 0.0
    var yP4: Double = 0.0
    var dP4: Double = 0.0
    var MuP4: Double = 0.0
    var xpP4: Double = 0.0
    var ypP4: Double = 0.0
    var L1P4: Double = 0.0
    var omP4: Double = 0.0
    var msP4: Double = 0.0
    var y1P4: Double = 0.0
    var m1P4: Double = 0.0
    var roP4: Double = 0.0
    var n2P4: Double = 0.0
    var nsP4: Double = 0.0
    var psP4: Double = 0.0

    var tuP4: Double = 0.0
    var tP4: Double = 0.0

    tP4 += tuP4
    for (i in 1..5) {
        xP4 = x0 + x1 * tP4 + x2 * tP4 * tP4 + x3 * tP4 * tP4 * tP4 + x4 * tP4 * tP4 * tP4 * tP4
        yP4 = y0 + y1 * tP4 + y2 * tP4 * tP4 + y3 * tP4 * tP4 * tP4 + y4 * tP4 * tP4 * tP4 * tP4
        dP4 = d0 + d1 * tP4 + d2 * tP4 * tP4 + d3 * tP4 * tP4 * tP4 + d4 * tP4 * tP4 * tP4 * tP4
        MuP4 = Mu0 + Mu1 * tP4 + Mu2 * tP4 * tP4 + Mu3 * tP4 * tP4 * tP4 + Mu4 * tP4 * tP4 * tP4 * tP4

        xpP4 = x1 + 2 * x2 * tP4 + 3 * x3 * tP4 * tP4 + 4 * x4 * tP4 * tP4 * tP4
        ypP4 = y1 + 2 * y2 * tP4 + 3 * y3 * tP4 * tP4 + 4 * y4 * tP4 * tP4 * tP4

        L1P4 = L10 + L11 * tP4 + L12 * tP4 * tP4 + L13 * tP4 * tP4 * tP4 + L14 * tP4 * tP4 * tP4 * tP4

        omP4 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dP4)) * Math.cos(mf.Rad(dP4)))
        msP4 = Math.sqrt(xP4 * xP4 + yP4 * yP4)

        y1P4 = yP4 * omP4
        m1P4 = Math.sqrt(xP4 * xP4 + y1P4 * y1P4)
        roP4 = msP4 / m1P4

        n2P4 = (xpP4 * xpP4 + ypP4 * ypP4)
        nsP4 = Math.sqrt(n2P4)
        psP4 = Math.asin((xP4 * ypP4 - xpP4 * yP4) / (nsP4 * (L1P4 + roP4)))

        tuP4 = ((L1P4 + roP4) / nsP4) * Math.cos(psP4) - (xP4 * xpP4 + yP4 * ypP4) / (nsP4 * nsP4)
        tP4 = tP4 + tuP4
    }

    val p4TD: Double = mf.Mod(T0 + tP4, 24.0)
    val p4UT: Double = mf.Mod(p4TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak P4
    val d1P4: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dP4))) / (Math.cos(mf.Rad(dP4)) * ba)))
    val rhP4: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dP4)), 2.0) + Math.pow(Math.cos(mf.Rad(dP4)) * ba, 2.0)), 0.5)
    val yIP4: Double = yP4 / rhP4
    val mIP4: Double = Math.pow(((xP4 * xP4) + (yIP4 * yIP4)), 0.5)
    val x1P4: Double = xP4 / mIP4
    val y2P4: Double = yIP4 / mIP4
    val pi1P4: Double = mf.Deg(Math.asin(y2P4 * Math.cos(mf.Rad(d1P4))))
    val piP4: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1P4))))
    val x2P4: Double = -y2P4 * Math.sin(mf.Rad(dP4))
    val HAP4: Double = mf.Mod(mf.Deg(Math.atan2(x1P4, x2P4)), 360.0)
    var LdP4: Double
    val caP4 = HAP4 - MuP4 + (0.004178 * DT)
    LdP4 = when {
        caP4 > 180 -> caP4 - 360
        caP4 < -180 -> caP4 + 360
        else -> caP4
    }

    //Azimuth dan Altitude saat kontak P4
    val altP4: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piP4)) * Math.sin(mf.Rad(dP4)) + Math.cos(mf.Rad(piP4)) * Math.cos(mf.Rad(dP4)) * Math.cos(
                mf.Rad(HAP4)
            )
        )
    )
    val azmP4: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAP4)),
                Math.cos(mf.Rad(HAP4)) * Math.sin(mf.Rad(piP4)) - Math.tan(mf.Rad(dP4)) * Math.cos(mf.Rad(piP4))
            )
        ) + 180, 360.0
    )


    //Penumbral First Internal Contact (P2)

    var xP2: Double = 0.0
    var yP2: Double = 0.0
    var dP2: Double = 0.0
    var MuP2: Double = 0.0
    var xpP2: Double = 0.0
    var ypP2: Double = 0.0
    var L1P2: Double = 0.0
    var omP2: Double = 0.0
    var msP2: Double = 0.0
    var y1P2: Double = 0.0
    var m1P2: Double = 0.0
    var roP2: Double = 0.0
    var n2P2: Double = 0.0
    var nsP2: Double = 0.0
    var psP2: Double = 0.0

    var tuP2: Double = 0.0
    var tP2: Double = 0.0

    tP2 += tuP2
    for (i in 1..5) {
        xP2 = x0 + x1 * tP2 + x2 * tP2 * tP2 + x3 * tP2 * tP2 * tP2 + x4 * tP2 * tP2 * tP2 * tP2
        yP2 = y0 + y1 * tP2 + y2 * tP2 * tP2 + y3 * tP2 * tP2 * tP2 + y4 * tP2 * tP2 * tP2 * tP2
        dP2 = d0 + d1 * tP2 + d2 * tP2 * tP2 + d3 * tP2 * tP2 * tP2 + d4 * tP2 * tP2 * tP2 * tP2
        MuP2 = Mu0 + Mu1 * tP2 + Mu2 * tP2 * tP2 + Mu3 * tP2 * tP2 * tP2 + Mu4 * tP2 * tP2 * tP2 * tP2

        xpP2 = x1 + 2 * x2 * tP2 + 3 * x3 * tP2 * tP2 + 4 * x4 * tP2 * tP2 * tP2
        ypP2 = y1 + 2 * y2 * tP2 + 3 * y3 * tP2 * tP2 + 4 * y4 * tP2 * tP2 * tP2

        L1P2 = L10 + L11 * tP2 + L12 * tP2 * tP2 + L13 * tP2 * tP2 * tP2 + L14 * tP2 * tP2 * tP2 * tP2

        omP2 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dP2)) * Math.cos(mf.Rad(dP2)))
        msP2 = Math.sqrt(xP2 * xP2 + yP2 * yP2)

        y1P2 = yP2 * omP2
        m1P2 = Math.sqrt(xP2 * xP2 + y1P2 * y1P2)
        roP2 = msP2 / m1P2

        n2P2 = (xpP2 * xpP2 + ypP2 * ypP2)
        nsP2 = Math.sqrt(n2P2)
        psP2 = Math.asin((xP2 * ypP2 - xpP2 * yP2) / (nsP2 * (L1P2 - roP2)))

        tuP2 = ((roP2 - L1P2) / nsP2) * -Math.cos(psP2) - (xP2 * xpP2 + yP2 * ypP2) / (nsP2 * nsP2)
        tP2 = tP2 + tuP2
    }

    val p2TD: Double = mf.Mod(T0 + tP2, 24.0)
    val p2UT: Double = mf.Mod(p2TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak P2
    val d1P2: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dP2))) / (Math.cos(mf.Rad(dP2)) * ba)))
    val rhP2: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dP2)), 2.0) + Math.pow(Math.cos(mf.Rad(dP2)) * ba, 2.0)), 0.5)
    val yIP2: Double = yP2 / rhP2
    val mIP2: Double = Math.pow(((xP2 * xP2) + (yIP2 * yIP2)), 0.5)
    val x1P2: Double = xP2 / mIP2
    val y2P2: Double = yIP2 / mIP2
    val pi1P2: Double = mf.Deg(Math.asin(y2P2 * Math.cos(mf.Rad(d1P2))))
    val piP2: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1P2))))
    val x2P2: Double = -y2P2 * Math.sin(mf.Rad(dP2))
    val HAP2: Double = mf.Mod(mf.Deg(Math.atan2(x1P2, x2P2)), 360.0)
    var LdP2: Double
    val caP2 = HAP2 - MuP2 + (0.004178 * DT)
    LdP2 = when {
        caP2 > 180 -> caP2 - 360
        caP2 < -180 -> caP2 + 360
        else -> caP2
    }

    //Azimuth dan Altitude saat kontak P2
    val altP2: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piP2)) * Math.sin(mf.Rad(dP2)) + Math.cos(mf.Rad(piP2)) * Math.cos(mf.Rad(dP2)) * Math.cos(
                mf.Rad(HAP2)
            )
        )
    )
    val azmP2: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAP2)),
                Math.cos(mf.Rad(HAP2)) * Math.sin(mf.Rad(piP2)) - Math.tan(mf.Rad(dP2)) * Math.cos(mf.Rad(piP2))
            )
        ) + 180, 360.0
    )


//Penumbral Last Internal Contact (P3)

    var xP3: Double = 0.0
    var yP3: Double = 0.0
    var dP3: Double = 0.0
    var MuP3: Double = 0.0
    var xpP3: Double = 0.0
    var ypP3: Double = 0.0
    var L1P3: Double = 0.0
    var omP3: Double = 0.0
    var msP3: Double = 0.0
    var y1P3: Double = 0.0
    var m1P3: Double = 0.0
    var roP3: Double = 0.0
    var n2P3: Double = 0.0
    var nsP3: Double = 0.0
    var psP3: Double = 0.0

    var tuP3: Double = 0.0
    var tP3: Double = 0.0

    tP3 += tuP3
    for (i in 1..5) {
        xP3 = x0 + x1 * tP3 + x2 * tP3 * tP3 + x3 * tP3 * tP3 * tP3 + x4 * tP3 * tP3 * tP3 * tP3
        yP3 = y0 + y1 * tP3 + y2 * tP3 * tP3 + y3 * tP3 * tP3 * tP3 + y4 * tP3 * tP3 * tP3 * tP3
        dP3 = d0 + d1 * tP3 + d2 * tP3 * tP3 + d3 * tP3 * tP3 * tP3 + d4 * tP3 * tP3 * tP3 * tP3
        MuP3 = Mu0 + Mu1 * tP3 + Mu2 * tP3 * tP3 + Mu3 * tP3 * tP3 * tP3 + Mu4 * tP3 * tP3 * tP3 * tP3

        xpP3 = x1 + 2 * x2 * tP3 + 3 * x3 * tP3 * tP3 + 4 * x4 * tP3 * tP3 * tP3
        ypP3 = y1 + 2 * y2 * tP3 + 3 * y3 * tP3 * tP3 + 4 * y4 * tP3 * tP3 * tP3

        L1P3 = L10 + L11 * tP3 + L12 * tP3 * tP3 + L13 * tP3 * tP3 * tP3 + L14 * tP3 * tP3 * tP3 * tP3

        omP3 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dP3)) * Math.cos(mf.Rad(dP3)))
        msP3 = Math.sqrt(xP3 * xP3 + yP3 * yP3)

        y1P3 = yP3 * omP3
        m1P3 = Math.sqrt(xP3 * xP3 + y1P3 * y1P3)
        roP3 = msP3 / m1P3

        n2P3 = (xpP3 * xpP3 + ypP3 * ypP3)
        nsP3 = Math.sqrt(n2P3)
        psP3 = Math.asin((xP3 * ypP3 - xpP3 * yP3) / (nsP3 * (L1P3 - roP3)))

        tuP3 = ((roP3 - L1P3) / nsP3) * Math.cos(psP3) - (xP3 * xpP3 + yP3 * ypP3) / (nsP3 * nsP3)
        tP3 = tP3 + tuP3
    }

    val p3TD: Double = mf.Mod(T0 + tP3, 24.0)
    val p3UT: Double = mf.Mod(p3TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak P3
    val d1P3: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dP3))) / (Math.cos(mf.Rad(dP3)) * ba)))
    val rhP3: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dP3)), 2.0) + Math.pow(Math.cos(mf.Rad(dP3)) * ba, 2.0)), 0.5)
    val yIP3: Double = yP3 / rhP3
    val mIP3: Double = Math.pow(((xP3 * xP3) + (yIP3 * yIP3)), 0.5)
    val x1P3: Double = xP3 / mIP3
    val y2P3: Double = yIP3 / mIP3
    val pi1P3: Double = mf.Deg(Math.asin(y2P3 * Math.cos(mf.Rad(d1P3))))
    val piP3: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1P3))))
    val x2P3: Double = -y2P3 * Math.sin(mf.Rad(dP3))
    val HAP3: Double = mf.Mod(mf.Deg(Math.atan2(x1P3, x2P3)), 360.0)
    var LdP3: Double
    val caP3 = HAP3 - MuP3 + (0.004178 * DT)
    LdP3 = when {
        caP3 > 180 -> caP3 - 360
        caP3 < -180 -> caP3 + 360
        else -> caP3
    }

    //Azimuth dan Altitude saat kontak P3
    val altP3: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piP3)) * Math.sin(mf.Rad(dP3)) + Math.cos(mf.Rad(piP3)) * Math.cos(mf.Rad(dP3)) * Math.cos(
                mf.Rad(HAP3)
            )
        )
    )
    val azmP3: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAP3)),
                Math.cos(mf.Rad(HAP3)) * Math.sin(mf.Rad(piP3)) - Math.tan(mf.Rad(dP3)) * Math.cos(mf.Rad(piP3))
            )
        ) + 180, 360.0
    )

    //Umbral First External Contact (U1)

    var xU1: Double = 0.0
    var yU1: Double = 0.0
    var dU1: Double = 0.0
    var MuU1: Double = 0.0
    var xpU1: Double = 0.0
    var ypU1: Double = 0.0
    var L2U1: Double = 0.0
    var omU1: Double = 0.0
    var msU1: Double = 0.0
    var y1U1: Double = 0.0
    var m1U1: Double = 0.0
    var roU1: Double = 0.0
    var n2U1: Double = 0.0
    var nsU1: Double = 0.0
    var psU1: Double = 0.0

    var tuU1: Double = 0.0
    var tU1: Double = 0.0

    tU1 += tuU1
    for (i in 1..5) {
        xU1 = x0 + x1 * tU1 + x2 * tU1 * tU1 + x3 * tU1 * tU1 * tU1 + x4 * tU1 * tU1 * tU1 * tU1
        yU1 = y0 + y1 * tU1 + y2 * tU1 * tU1 + y3 * tU1 * tU1 * tU1 + y4 * tU1 * tU1 * tU1 * tU1
        dU1 = d0 + d1 * tU1 + d2 * tU1 * tU1 + d3 * tU1 * tU1 * tU1 + d4 * tU1 * tU1 * tU1 * tU1
        MuU1 = Mu0 + Mu1 * tU1 + Mu2 * tU1 * tU1 + Mu3 * tU1 * tU1 * tU1 + Mu4 * tU1 * tU1 * tU1 * tU1

        xpU1 = x1 + 2 * x2 * tU1 + 3 * x3 * tU1 * tU1 + 4 * x4 * tU1 * tU1 * tU1
        ypU1 = y1 + 2 * y2 * tU1 + 3 * y3 * tU1 * tU1 + 4 * y4 * tU1 * tU1 * tU1

        L2U1 = L20 + L21 * tU1 + L22 * tU1 * tU1 + L23 * tU1 * tU1 * tU1 + L24 * tU1 * tU1 * tU1 * tU1

        omU1 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dU1)) * Math.cos(mf.Rad(dU1)))
        msU1 = Math.sqrt(xU1 * xU1 + yU1 * yU1)

        y1U1 = yU1 * omU1
        m1U1 = Math.sqrt(xU1 * xU1 + y1U1 * y1U1)
        roU1 = msU1 / m1U1

        n2U1 = (xpU1 * xpU1 + ypU1 * ypU1)
        nsU1 = Math.sqrt(n2U1)

        psU1 =
            if (L2U1 < 0.0) Math.asin((xU1 * ypU1 - xpU1 * yU1) / (nsU1 * (L2U1 - roU1))) else Math.asin((xU1 * ypU1 - xpU1 * yU1) / (nsU1 * (L2U1 + roU1)))

        tuU1 =
            if (L2U1 < 0.0) ((roU1 - L2U1) / nsU1) * -Math.cos(psU1) - (xU1 * xpU1 + yU1 * ypU1) / (nsU1 * nsU1) else ((roU1 + L2U1) / nsU1) * -Math.cos(
                psU1
            ) - (xU1 * xpU1 + yU1 * ypU1) / (nsU1 * nsU1)
        tU1 = tU1 + tuU1
    }

    val u1TD: Double = mf.Mod(T0 + tU1, 24.0)
    val u1UT: Double = mf.Mod(u1TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak U1
    val d1U1: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dU1))) / (Math.cos(mf.Rad(dU1)) * ba)))
    val rhU1: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dU1)), 2.0) + Math.pow(Math.cos(mf.Rad(dU1)) * ba, 2.0)), 0.5)
    val yIU1: Double = yU1 / rhU1
    val mIU1: Double = Math.pow(((xU1 * xU1) + (yIU1 * yIU1)), 0.5)
    val x1U1: Double = xU1 / mIU1
    val y2U1: Double = yIU1 / mIU1
    val pi1U1: Double = mf.Deg(Math.asin(y2U1 * Math.cos(mf.Rad(d1U1))))
    val piU1: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1U1))))
    val x2U1: Double = -y2U1 * Math.sin(mf.Rad(dU1))
    val HAU1: Double = mf.Mod(mf.Deg(Math.atan2(x1U1, x2U1)), 360.0)
    var LdU1: Double
    val caU1 = HAU1 - MuU1 + (0.004178 * DT)
    LdU1 = when {
        caU1 > 180 -> caU1 - 360
        caU1 < -180 -> caU1 + 360
        else -> caU1
    }

    //Azimuth dan Altitude saat kontak U1
    val altU1: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piU1)) * Math.sin(mf.Rad(dU1)) + Math.cos(mf.Rad(piU1)) * Math.cos(mf.Rad(dU1)) * Math.cos(
                mf.Rad(HAU1)
            )
        )
    )
    val azmU1: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAU1)),
                Math.cos(mf.Rad(HAU1)) * Math.sin(mf.Rad(piU1)) - Math.tan(mf.Rad(dU1)) * Math.cos(mf.Rad(piU1))
            )
        ) + 180, 360.0
    )


    //Umbral Last External Contact (U4)

    var xU4: Double = 0.0
    var yU4: Double = 0.0
    var dU4: Double = 0.0
    var MuU4: Double = 0.0
    var xpU4: Double = 0.0
    var ypU4: Double = 0.0
    var L2U4: Double = 0.0
    var omU4: Double = 0.0
    var msU4: Double = 0.0
    var y1U4: Double = 0.0
    var m1U4: Double = 0.0
    var roU4: Double = 0.0
    var n2U4: Double = 0.0
    var nsU4: Double = 0.0
    var psU4: Double = 0.0

    var tuU4: Double = 0.0
    var tU4: Double = 0.0

    tU4 += tuU4
    for (i in 1..5) {
        xU4 = x0 + x1 * tU4 + x2 * tU4 * tU4 + x3 * tU4 * tU4 * tU4 + x4 * tU4 * tU4 * tU4 * tU4
        yU4 = y0 + y1 * tU4 + y2 * tU4 * tU4 + y3 * tU4 * tU4 * tU4 + y4 * tU4 * tU4 * tU4 * tU4
        dU4 = d0 + d1 * tU4 + d2 * tU4 * tU4 + d3 * tU4 * tU4 * tU4 + d4 * tU4 * tU4 * tU4 * tU4
        MuU4 = Mu0 + Mu1 * tU4 + Mu2 * tU4 * tU4 + Mu3 * tU4 * tU4 * tU4 + Mu4 * tU4 * tU4 * tU4 * tU4

        xpU4 = x1 + 2 * x2 * tU4 + 3 * x3 * tU4 * tU4 + 4 * x4 * tU4 * tU4 * tU4
        ypU4 = y1 + 2 * y2 * tU4 + 3 * y3 * tU4 * tU4 + 4 * y4 * tU4 * tU4 * tU4

        L2U4 = L20 + L21 * tU4 + L22 * tU4 * tU4 + L23 * tU4 * tU4 * tU4 + L24 * tU4 * tU4 * tU4 * tU4

        omU4 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dU4)) * Math.cos(mf.Rad(dU4)))
        msU4 = Math.sqrt(xU4 * xU4 + yU4 * yU4)

        y1U4 = yU4 * omU4
        m1U4 = Math.sqrt(xU4 * xU4 + y1U4 * y1U4)
        roU4 = msU4 / m1U4

        n2U4 = (xpU4 * xpU4 + ypU4 * ypU4)
        nsU4 = Math.sqrt(n2U4)
        psU4 =
            if (L2U4 < 0.0) Math.asin((xU4 * ypU4 - xpU4 * yU4) / (nsU4 * (L2U4 - roU4))) else Math.asin((xU4 * ypU4 - xpU4 * yU4) / (nsU4 * (L2U4 + roU4)))

        tuU4 =
            if (L2U4 < 0.0) ((roU4 - L2U4) / nsU4) * Math.cos(psU4) - (xU4 * xpU4 + yU4 * ypU4) / (nsU4 * nsU4) else ((roU4 + L2U4) / nsU4) * Math.cos(
                psU4
            ) - (xU4 * xpU4 + yU4 * ypU4) / (nsU4 * nsU4)
        tU4 = tU4 + tuU4
    }

    val u4TD: Double = mf.Mod(T0 + tU4, 24.0)
    val u4UT: Double = mf.Mod(u4TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak U4
    val d1U4: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dU4))) / (Math.cos(mf.Rad(dU4)) * ba)))
    val rhU4: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dU4)), 2.0) + Math.pow(Math.cos(mf.Rad(dU4)) * ba, 2.0)), 0.5)
    val yIU4: Double = yU4 / rhU4
    val mIU4: Double = Math.pow(((xU4 * xU4) + (yIU4 * yIU4)), 0.5)
    val x1U4: Double = xU4 / mIU4
    val y2U4: Double = yIU4 / mIU4
    val pi1U4: Double = mf.Deg(Math.asin(y2U4 * Math.cos(mf.Rad(d1U4))))
    val piU4: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1U4))))
    val x2U4: Double = -y2U4 * Math.sin(mf.Rad(dU4))
    val HAU4: Double = mf.Mod(mf.Deg(Math.atan2(x1U4, x2U4)), 360.0)
    var LdU4: Double
    val caU4 = HAU4 - MuU4 + (0.004178 * DT)
    LdU4 = when {
        caU4 > 180 -> caU4 - 360
        caU4 < -180 -> caU4 + 360
        else -> caU4
    }

    //Azimuth dan Altitude saat kontak U4
    val altU4: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piU4)) * Math.sin(mf.Rad(dU4)) + Math.cos(mf.Rad(piU4)) * Math.cos(mf.Rad(dU4)) * Math.cos(
                mf.Rad(HAU4)
            )
        )
    )
    val azmU4: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAU4)),
                Math.cos(mf.Rad(HAU4)) * Math.sin(mf.Rad(piU4)) - Math.tan(mf.Rad(dU4)) * Math.cos(mf.Rad(piU4))
            )
        ) + 180, 360.0
    )


    //Umbral First Internal Contact (U2)

    var xU2: Double = 0.0
    var yU2: Double = 0.0
    var dU2: Double = 0.0
    var MuU2: Double = 0.0
    var xpU2: Double = 0.0
    var ypU2: Double = 0.0
    var L2U2: Double = 0.0
    var omU2: Double = 0.0
    var msU2: Double = 0.0
    var y1U2: Double = 0.0
    var m1U2: Double = 0.0
    var roU2: Double = 0.0
    var n2U2: Double = 0.0
    var nsU2: Double = 0.0
    var psU2: Double = 0.0

    var tuU2: Double = 0.0
    var tU2: Double = 0.0

    tU2 += tuU2
    for (i in 1..5) {
        xU2 = x0 + x1 * tU2 + x2 * tU2 * tU2 + x3 * tU2 * tU2 * tU2 + x4 * tU2 * tU2 * tU2 * tU2
        yU2 = y0 + y1 * tU2 + y2 * tU2 * tU2 + y3 * tU2 * tU2 * tU2 + y4 * tU2 * tU2 * tU2 * tU2
        dU2 = d0 + d1 * tU2 + d2 * tU2 * tU2 + d3 * tU2 * tU2 * tU2 + d4 * tU2 * tU2 * tU2 * tU2
        MuU2 = Mu0 + Mu1 * tU2 + Mu2 * tU2 * tU2 + Mu3 * tU2 * tU2 * tU2 + Mu4 * tU2 * tU2 * tU2 * tU2

        xpU2 = x1 + 2 * x2 * tU2 + 3 * x3 * tU2 * tU2 + 4 * x4 * tU2 * tU2 * tU2
        ypU2 = y1 + 2 * y2 * tU2 + 3 * y3 * tU2 * tU2 + 4 * y4 * tU2 * tU2 * tU2

        L2U2 = L20 + L21 * tU2 + L22 * tU2 * tU2 + L23 * tU2 * tU2 * tU2 + L24 * tU2 * tU2 * tU2 * tU2

        omU2 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dU2)) * Math.cos(mf.Rad(dU2)))
        msU2 = Math.sqrt(xU2 * xU2 + yU2 * yU2)

        y1U2 = yU2 * omU2
        m1U2 = Math.sqrt(xU2 * xU2 + y1U2 * y1U2)
        roU2 = msU2 / m1U2

        n2U2 = (xpU2 * xpU2 + ypU2 * ypU2)
        nsU2 = Math.sqrt(n2U2)

        psU2 =
            if (L2U2 < 0.0) Math.asin((xU2 * ypU2 - xpU2 * yU2) / (nsU2 * (L2U2 + roU2))) else Math.asin((xU2 * ypU2 - xpU2 * yU2) / (nsU2 * (L2U2 - roU2)))

        tuU2 =
            if (L2U2 < 0.0) ((roU2 + L2U2) / nsU2) * -Math.cos(psU2) - (xU2 * xpU2 + yU2 * ypU2) / (nsU2 * nsU2) else ((roU2 - L2U2) / nsU2) * -Math.cos(
                psU2
            ) - (xU2 * xpU2 + yU2 * ypU2) / (nsU2 * nsU2)
        tU2 = tU2 + tuU2
    }

    val u2TD: Double = mf.Mod(T0 + tU2, 24.0)
    val u2UT: Double = mf.Mod(u2TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak U2
    val d1U2: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dU2))) / (Math.cos(mf.Rad(dU2)) * ba)))
    val rhU2: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dU2)), 2.0) + Math.pow(Math.cos(mf.Rad(dU2)) * ba, 2.0)), 0.5)
    val yIU2: Double = yU2 / rhU2
    val mIU2: Double = Math.pow(((xU2 * xU2) + (yIU2 * yIU2)), 0.5)
    val x1U2: Double = xU2 / mIU2
    val y2U2: Double = yIU2 / mIU2
    val pi1U2: Double = mf.Deg(Math.asin(y2U2 * Math.cos(mf.Rad(d1U2))))
    val piU2: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1U2))))
    val x2U2: Double = -y2U2 * Math.sin(mf.Rad(dU2))
    val HAU2: Double = mf.Mod(mf.Deg(Math.atan2(x1U2, x2U2)), 360.0)
    var LdU2: Double
    val caU2 = HAU2 - MuU2 + (0.004178 * DT)
    LdU2 = when {
        caU2 > 180 -> caU2 - 360
        caU2 < -180 -> caU2 + 360
        else -> caU2
    }

    //Azimuth dan Altitude saat kontak U2
    val altU2: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piU2)) * Math.sin(mf.Rad(dU2)) + Math.cos(mf.Rad(piU2)) * Math.cos(mf.Rad(dU2)) * Math.cos(
                mf.Rad(HAU2)
            )
        )
    )
    val azmU2: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAU2)),
                Math.cos(mf.Rad(HAU2)) * Math.sin(mf.Rad(piU2)) - Math.tan(mf.Rad(dU2)) * Math.cos(mf.Rad(piU2))
            )
        ) + 180, 360.0
    )


//Umbral Last Internal Contact (U3)

    var xU3: Double = 0.0
    var yU3: Double = 0.0
    var dU3: Double = 0.0
    var MuU3: Double = 0.0
    var xpU3: Double = 0.0
    var ypU3: Double = 0.0
    var L2U3: Double = 0.0
    var omU3: Double = 0.0
    var msU3: Double = 0.0
    var y1U3: Double = 0.0
    var m1U3: Double = 0.0
    var roU3: Double = 0.0
    var n2U3: Double = 0.0
    var nsU3: Double = 0.0
    var psU3: Double = 0.0

    var tuU3: Double = 0.0
    var tU3: Double = 0.0

    tU3 += tuU3
    for (i in 1..5) {
        xU3 = x0 + x1 * tU3 + x2 * tU3 * tU3 + x3 * tU3 * tU3 * tU3 + x4 * tU3 * tU3 * tU3 * tU3
        yU3 = y0 + y1 * tU3 + y2 * tU3 * tU3 + y3 * tU3 * tU3 * tU3 + y4 * tU3 * tU3 * tU3 * tU3
        dU3 = d0 + d1 * tU3 + d2 * tU3 * tU3 + d3 * tU3 * tU3 * tU3 + d4 * tU3 * tU3 * tU3 * tU3
        MuU3 = Mu0 + Mu1 * tU3 + Mu2 * tU3 * tU3 + Mu3 * tU3 * tU3 * tU3 + Mu4 * tU3 * tU3 * tU3 * tU3

        xpU3 = x1 + 2 * x2 * tU3 + 3 * x3 * tU3 * tU3 + 4 * x4 * tU3 * tU3 * tU3
        ypU3 = y1 + 2 * y2 * tU3 + 3 * y3 * tU3 * tU3 + 4 * y4 * tU3 * tU3 * tU3

        L2U3 = L20 + L21 * tU3 + L22 * tU3 * tU3 + L23 * tU3 * tU3 * tU3 + L24 * tU3 * tU3 * tU3 * tU3

        omU3 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dU3)) * Math.cos(mf.Rad(dU3)))
        msU3 = Math.sqrt(xU3 * xU3 + yU3 * yU3)

        y1U3 = yU3 * omU3
        m1U3 = Math.sqrt(xU3 * xU3 + y1U3 * y1U3)
        roU3 = msU3 / m1U3

        n2U3 = (xpU3 * xpU3 + ypU3 * ypU3)
        nsU3 = Math.sqrt(n2U3)

        psU3 =
            if (L2U3 < 0.0) Math.asin((xU3 * ypU3 - xpU3 * yU3) / (nsU3 * (L2U3 + roU3))) else Math.asin((xU3 * ypU3 - xpU3 * yU3) / (nsU3 * (L2U3 - roU3)))

        tuU3 =
            if (L2U3 < 0.0) ((roU3 + L2U3) / nsU3) * Math.cos(psU3) - (xU3 * xpU3 + yU3 * ypU3) / (nsU3 * nsU3) else ((roU3 - L2U3) / nsU3) * Math.cos(
                psU3
            ) - (xU3 * xpU3 + yU3 * ypU3) / (nsU3 * nsU3)
        tU3 = tU3 + tuU3
    }

    val u3TD: Double = mf.Mod(T0 + tU3, 24.0)
    val u3UT: Double = mf.Mod(u3TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak U3
    val d1U3: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dU3))) / (Math.cos(mf.Rad(dU3)) * ba)))
    val rhU3: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dU3)), 2.0) + Math.pow(Math.cos(mf.Rad(dU3)) * ba, 2.0)), 0.5)
    val yIU3: Double = yU3 / rhU3
    val mIU3: Double = Math.pow(((xU3 * xU3) + (yIU3 * yIU3)), 0.5)
    val x1U3: Double = xU3 / mIU3
    val y2U3: Double = yIU3 / mIU3
    val pi1U3: Double = mf.Deg(Math.asin(y2U3 * Math.cos(mf.Rad(d1U3))))
    val piU3: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1U3))))
    val x2U3: Double = -y2U3 * Math.sin(mf.Rad(dU3))
    val HAU3: Double = mf.Mod(mf.Deg(Math.atan2(x1U3, x2U3)), 360.0)
    var LdU3: Double
    val caU3 = HAU3 - MuU3 + (0.004178 * DT)
    LdU3 = when {
        caU3 > 180 -> caU3 - 360
        caU3 < -180 -> caU3 + 360
        else -> caU3
    }

    //Azimuth dan Altitude saat kontak U3
    val altU3: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piU3)) * Math.sin(mf.Rad(dU3)) + Math.cos(mf.Rad(piU3)) * Math.cos(mf.Rad(dU3)) * Math.cos(
                mf.Rad(HAU3)
            )
        )
    )
    val azmU3: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAU3)),
                Math.cos(mf.Rad(HAU3)) * Math.sin(mf.Rad(piU3)) - Math.tan(mf.Rad(dU3)) * Math.cos(mf.Rad(piU3))
            )
        ) + 180, 360.0
    )


    //Extreme Central Line Limit 1 (C1)

    var xC1: Double = 0.0
    var yC1: Double = 0.0
    var dC1: Double = 0.0
    var MuC1: Double = 0.0
    var xpC1: Double = 0.0
    var ypC1: Double = 0.0
    var omC1: Double = 0.0
    var uC1: Double = 0.0
    var vC1: Double = 0.0
    var aC1: Double = 0.0
    var bC1: Double = 0.0
    var n2C1: Double = 0.0
    var nsC1: Double = 0.0
    var psC1: Double = 0.0
    var tuC1: Double = 0.0
    var tC1: Double = 0.0

    tC1 += tuC1
    for (i in 1..5) {
        xC1 = x0 + x1 * tC1 + x2 * tC1 * tC1 + x3 * tC1 * tC1 * tC1 + x4 * tC1 * tC1 * tC1 * tC1
        yC1 = y0 + y1 * tC1 + y2 * tC1 * tC1 + y3 * tC1 * tC1 * tC1 + y4 * tC1 * tC1 * tC1 * tC1
        dC1 = d0 + d1 * tC1 + d2 * tC1 * tC1 + d3 * tC1 * tC1 * tC1 + d4 * tC1 * tC1 * tC1 * tC1
        MuC1 = Mu0 + Mu1 * tC1 + Mu2 * tC1 * tC1 + Mu3 * tC1 * tC1 * tC1 + Mu4 * tC1 * tC1 * tC1 * tC1

        xpC1 = x1 + 2 * x2 * tC1 + 3 * x3 * tC1 * tC1 + 4 * x4 * tC1 * tC1 * tC1
        ypC1 = y1 + 2 * y2 * tC1 + 3 * y3 * tC1 * tC1 + 4 * y4 * tC1 * tC1 * tC1

        omC1 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dC1)) * Math.cos(mf.Rad(dC1)))

        uC1 = xC1
        vC1 = yC1 * omC1
        aC1 = xpC1
        bC1 = ypC1 * omC1

        n2C1 = (aC1 * aC1 + bC1 * bC1)
        nsC1 = Math.sqrt(n2C1)

        psC1 = (aC1 * vC1 - uC1 * bC1) / nsC1

        tuC1 = -(uC1 * aC1 + vC1 * bC1) / (n2C1) - Math.sqrt(1 - psC1 * psC1) / nsC1
        tC1 = tC1 + tuC1
    }

    val c1TD: Double = mf.Mod(T0 + tC1, 24.0)
    val c1UT: Double = mf.Mod(c1TD - DT / 3600.0, 24.0)

    //Koordinat saat kontak C1
    val d1C1: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dC1))) / (Math.cos(mf.Rad(dC1)) * ba)))
    val rhC1: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dC1)), 2.0) + Math.pow(Math.cos(mf.Rad(dC1)) * ba, 2.0)), 0.5)
    val yIC1: Double = yC1 / rhC1
    val mIC1: Double = Math.pow(((xC1 * xC1) + (yIC1 * yIC1)), 0.5)
    val x1C1: Double = xC1 / mIC1
    val y2C1: Double = yIC1 / mIC1
    val pi1C1: Double = mf.Deg(Math.asin(y2C1 * Math.cos(mf.Rad(d1C1))))
    val piC1: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1C1))))
    val x2C1: Double = -y2C1 * Math.sin(mf.Rad(dC1))
    val HAC1: Double = mf.Mod(mf.Deg(Math.atan2(x1C1, x2C1)), 360.0)
    var LdC1: Double
    val caC1 = HAC1 - MuC1 + (0.004178 * DT)
    LdC1 = when {
        caC1 > 180 -> caC1 - 360
        caC1 < -180 -> caC1 + 360
        else -> caC1
    }

    //Azimuth dan Altitude saat kontak C1
    val altC1: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piC1)) * Math.sin(mf.Rad(dC1)) + Math.cos(mf.Rad(piC1)) * Math.cos(mf.Rad(dC1)) * Math.cos(
                mf.Rad(HAC1)
            )
        )
    )
    val azmC1: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAC1)),
                Math.cos(mf.Rad(HAC1)) * Math.sin(mf.Rad(piC1)) - Math.tan(mf.Rad(dC1)) * Math.cos(mf.Rad(piC1))
            )
        ) + 180, 360.0
    )


    //Extreme Central Line Limit 2 (C2)

    var xC2: Double = 0.0
    var yC2: Double = 0.0
    var dC2: Double = 0.0
    var MuC2: Double = 0.0
    var xpC2: Double = 0.0
    var ypC2: Double = 0.0
    var omC2: Double = 0.0
    var uC2: Double = 0.0
    var vC2: Double = 0.0
    var aC2: Double = 0.0
    var bC2: Double = 0.0
    var n2C2: Double = 0.0
    var nsC2: Double = 0.0
    var psC2: Double = 0.0
    var tuC2: Double = 0.0
    var tC2: Double = 0.0

    tC2 += tuC2
    for (i in 1..5) {
        xC2 = x0 + x1 * tC2 + x2 * tC2 * tC2 + x3 * tC2 * tC2 * tC2 + x4 * tC2 * tC2 * tC2 * tC2
        yC2 = y0 + y1 * tC2 + y2 * tC2 * tC2 + y3 * tC2 * tC2 * tC2 + y4 * tC2 * tC2 * tC2 * tC2
        dC2 = d0 + d1 * tC2 + d2 * tC2 * tC2 + d3 * tC2 * tC2 * tC2 + d4 * tC2 * tC2 * tC2 * tC2
        MuC2 = Mu0 + Mu1 * tC2 + Mu2 * tC2 * tC2 + Mu3 * tC2 * tC2 * tC2 + Mu4 * tC2 * tC2 * tC2 * tC2

        xpC2 = x1 + 2 * x2 * tC2 + 3 * x3 * tC2 * tC2 + 4 * x4 * tC2 * tC2 * tC2
        ypC2 = y1 + 2 * y2 * tC2 + 3 * y3 * tC2 * tC2 + 4 * y4 * tC2 * tC2 * tC2

        omC2 = 1 / Math.sqrt(1 - e2 * Math.cos(mf.Rad(dC2)) * Math.cos(mf.Rad(dC2)))

        uC2 = xC2
        vC2 = yC2 * omC2
        aC2 = xpC2
        bC2 = ypC2 * omC2

        n2C2 = (aC2 * aC2 + bC2 * bC2)
        nsC2 = Math.sqrt(n2C2)

        psC2 = (aC2 * vC2 - uC2 * bC2) / nsC2

        tuC2 = -(uC2 * aC2 + vC2 * bC2) / (n2C2) + Math.sqrt(1 - psC2 * psC2) / nsC2
        tC2 = tC2 + tuC2
    }

    val c2TD: Double = mf.Mod(T0 + tC2, 24.0)
    val c2UT: Double = mf.Mod(c2TD - DT / 3600.0, 24.0)

//Koordinat saat kontak C2
    val d1C2: Double = mf.Deg(Math.atan((Math.sin(mf.Rad(dC2))) / (Math.cos(mf.Rad(dC2)) * ba)))
    val rhC2: Double = Math.pow((Math.pow(Math.sin(mf.Rad(dC2)), 2.0) + Math.pow(Math.cos(mf.Rad(dC2)) * ba, 2.0)), 0.5)
    val yIC2: Double = yC2 / rhC2
    val mIC2: Double = Math.pow(((xC2 * xC2) + (yIC2 * yIC2)), 0.5)
    val x1C2: Double = xC2 / mIC2
    val y2C2: Double = yIC2 / mIC2
    val pi1C2: Double = mf.Deg(Math.asin(y2C2 * Math.cos(mf.Rad(d1C2))))
    val piC2: Double = mf.Deg(Math.atan(ab * Math.tan(mf.Rad(pi1C2))))
    val x2C2: Double = -y2C2 * Math.sin(mf.Rad(dC2))
    val HAC2: Double = mf.Mod(mf.Deg(Math.atan2(x1C2, x2C2)), 360.0)
    var LdC2: Double
    val caC2 = HAC2 - MuC2 + (0.004178 * DT)
    LdC2 = when {
        caC2 > 180 -> caC2 - 360
        caC2 < -180 -> caC2 + 360
        else -> caC2
    }

    //Azimuth dan Altitude saat kontak C2
    val altC2: Double = mf.Deg(
        Math.asin(
            Math.sin(mf.Rad(piC2)) * Math.sin(mf.Rad(dC2)) + Math.cos(mf.Rad(piC2)) * Math.cos(mf.Rad(dC2)) * Math.cos(
                mf.Rad(HAC2)
            )
        )
    )
    val azmC2: Double = mf.Mod(
        mf.Deg(
            Math.atan2(
                Math.sin(mf.Rad(HAC2)),
                Math.cos(mf.Rad(HAC2)) * Math.sin(mf.Rad(piC2)) - Math.tan(mf.Rad(dC2)) * Math.cos(mf.Rad(piC2))
            )
        ) + 180, 360.0
    )

//JD Gerhana Matahari
    val jdEclipse = SBesselian(blnH, thnH, "JDS")

    val jdSolarEclipseMx = Math.floor(jdEclipse - 0.5) + 0.5 + mXTD / 24.0

    val jdSolarEclipseP1 = Math.floor(jdEclipse - 0.5) + 0.5 + p1TD / 24.0
    val jdSolarEclipseP2 = Math.floor(jdEclipse - 0.5) + 0.5 + p2TD / 24.0
    val jdSolarEclipseP3 = Math.floor(jdEclipse - 0.5) + 0.5 + p3TD / 24.0
    val jdSolarEclipseP4 = Math.floor(jdEclipse - 0.5) + 0.5 + p4TD / 24.0

    val jdSolarEclipseU1 = Math.floor(jdEclipse - 0.5) + 0.5 + u1TD / 24.0
    val jdSolarEclipseU2 = Math.floor(jdEclipse - 0.5) + 0.5 + u2TD / 24.0
    val jdSolarEclipseU3 = Math.floor(jdEclipse - 0.5) + 0.5 + u3TD / 24.0
    val jdSolarEclipseU4 = Math.floor(jdEclipse - 0.5) + 0.5 + u4TD / 24.0

    val jdSolarEclipseC1 = Math.floor(jdEclipse - 0.5) + 0.5 + c1TD / 24.0
    val jdSolarEclipseC2 = Math.floor(jdEclipse - 0.5) + 0.5 + c2TD / 24.0


    fun solarEclipse2(
        BlnH: Byte,
        ThnH: Long,
        Optn: String
    ): Double {
        val Mx: Double = jdSolarEclipseMx
        val P1: Double = jdSolarEclipseP1
        val P2: Double = jdSolarEclipseP2
        val P3: Double = jdSolarEclipseP3
        val P4: Double = jdSolarEclipseP4
        val U1: Double = jdSolarEclipseU1
        val U2: Double = jdSolarEclipseU2
        val U3: Double = jdSolarEclipseU3
        val U4: Double = jdSolarEclipseU4
        val C1: Double = jdSolarEclipseC1
        val C2: Double = jdSolarEclipseC2

        val lmdMx: Double = LdMx
        val lmdP1: Double = LdP1
        val lmdP2: Double = LdP2
        val lmdP3: Double = LdP3
        val lmdP4: Double = LdP4
        val lmdU1: Double = LdU1
        val lmdU2: Double = LdU2
        val lmdU3: Double = LdU3
        val lmdU4: Double = LdU4
        val lmdC1: Double = LdC1
        val lmdC2: Double = LdC2

        val AzmMx: Double = azmMx
        val AzmP1: Double = azmP1
        val AzmP2: Double = azmP2
        val AzmP3: Double = azmP3
        val AzmP4: Double = azmP4
        val AzmU1: Double = azmU1
        val AzmU2: Double = azmU2
        val AzmU3: Double = azmU3
        val AzmU4: Double = azmU4
        val AzmC1: Double = azmC1
        val AzmC2: Double = azmC2

        val AltMx: Double = altMx
        val AltP1: Double = altP1
        val AltP2: Double = altP2
        val AltP3: Double = altP3
        val AltP4: Double = altP4
        val AltU1: Double = altU1
        val AltU2: Double = altU2
        val AltU3: Double = altU3
        val AltU4: Double = altU4
        val AltC1: Double = altC1
        val AltC2: Double = altC2

        return when (Optn) {
            "Mx" -> Mx
            "P1" -> P1
            "P2" -> P2
            "P3" -> P3
            "P4" -> P4
            "U1" -> U1
            "U2" -> U2
            "U3" -> U3
            "U4" -> U4
            "C1" -> C1
            "C2" -> C2

            "lmdMx" -> lmdMx
            "lmdP1" -> lmdP1
            "lmdP2" -> lmdP2
            "lmdP3" -> lmdP3
            "lmdP4" -> lmdP4
            "lmdU1" -> lmdU1
            "lmdU2" -> lmdU2
            "lmdU3" -> lmdU3
            "lmdU4" -> lmdU4
            "lmdC1" -> lmdC1
            "lmdC2" -> lmdC2

            "phiMx" -> piMx
            "phiP1" -> piP1
            "phiP2" -> piP2
            "phiP3" -> piP3
            "phiP4" -> piP4
            "phiU1" -> piU1
            "phiU2" -> piU2
            "phiU3" -> piU3
            "phiU4" -> piU4
            "phiC1" -> piC1
            "phiC2" -> piC2

            "AzmMx" -> AzmMx
            "AzmP1" -> AzmP1
            "AzmP2" -> AzmP2
            "AzmP3" -> AzmP3
            "AzmP4" -> AzmP4
            "AzmU1" -> AzmU1
            "AzmU2" -> AzmU2
            "AzmU3" -> AzmU3
            "AzmU4" -> AzmU4
            "AzmC1" -> AzmC1
            "AzmC2" -> AzmC2

            "AltMx" -> AltMx
            "AltP1" -> AltP1
            "AltP2" -> AltP2
            "AltP3" -> AltP3
            "AltP4" -> AltP4
            "AltU1" -> AltU1
            "AltU2" -> AltU2
            "AltU3" -> AltU3
            "AltU4" -> AltU4
            "AltC1" -> AltC1
            "AltC2" -> AltC2

            else -> 0.0

        }
    }


    //Print hasil hisab

    val SBE = arrayOf(
        "JD " to "JDS",
        "DT " to "DT",
        "t0 " to "t0",
        "x0 " to "x0",
        "x1 " to "x1",
        "x2 " to "x2",
        "x3 " to "x3",
        "x4 " to "x4",
        "y0 " to "y0",
        "y1 " to "y1",
        "y2 " to "y2",
        "y3 " to "y3",
        "y4 " to "y4",
        "d0 " to "d0",
        "d1 " to "d1",
        "d2 " to "d2",
        "d3 " to "d3",
        "d4 " to "d4",
        "L10" to "L10",
        "L11" to "L11",
        "L12" to "L12",
        "L13" to "L13",
        "L14" to "L14",
        "L20" to "L20",
        "L21" to "L21",
        "L22" to "L22",
        "L23" to "L23",
        "L24" to "L24",
        "Mu0" to "Mu0",
        "Mu1" to "Mu1",
        "Mu2" to "Mu2",
        "Mu3" to "Mu3",
        "Mu4" to "Mu4",
        "f1 " to "f1",
        "f2 " to "f2"
    )

    println("Besselian Element of Solar Eclipse")
    for (t in SBE) {
        val tVal = SBesselian(blnH, thnH, t.second)
        val tVt: String = if (tVal < 0.0) tVal.round(7)
        else if (t.second == "JDS") " " + tVal.round(10)
        else if (t.second == "t0") " " + tVal.round(0)
        else if (t.second == "DT") " " + tVal.round(1) + "s"
        else " " + tVal.round(7)
        if (!tVal.isNaN()) {
            println(t.first + "  : " + tVt)
        } else {
            println(t.first + "  : -")
        }
    }

    println("")
    println("Gerhana Matahari ${jn01 + " " + jd.JDKM(jdSolarEclipseMx, 0.0, "THNMHYNS")}")
    println("")
    println("waktu kontak-kontak gerhana")

    val tSE = arrayOf(
        "P1" to "P1",
        "U1" to "U1",
        "C1" to "C1",
        "U2" to "U2",
        "P2" to "P2",
        "Mx" to "Mx",
        "P3" to "P3",
        "U3" to "U3",
        "C2" to "C2",
        "U4" to "U4",
        "P4" to "P4"
    )

    for (t in tSE) {
        val tVal1 = solarEclipse2(blnH, thnH, t.second)
        val tVal2 = solarEclipse2(blnH, thnH, t.second)
        if (!tVal1.isNaN()) {
            val tJam1 = mf.DHHMS(jd.JDKM(tVal1, 0.0, "Jam Des").toDouble(), "HH:MM:SS", 1)
            val tJam2 = mf.DHHMS(jd.JDKM(tVal2 - dt.DeltaT(tVal2) / 86400.0, 0.0, "Jam Des").toDouble(), "HH:MM:SS", 1)
            println(t.first + "  : " + tJam1 + " TD / " + tJam2 + " UT")
        } else {
            println(t.first + "  : -")
        }
    }

    println("")
    println("Koordinat saat kontak-kontak gerhana")

    val CSE = arrayOf(
        "λ P1" to "lmdP1",
        "λ U1" to "lmdU1",
        "λ C1" to "lmdC1",
        "λ U2" to "lmdU2",
        "λ P2" to "lmdP2",
        "λ Mx" to "lmdMx",
        "λ P3" to "lmdP3",
        "λ U3" to "lmdU3",
        "λ C2" to "lmdC2",
        "λ U4" to "lmdU4",
        "λ P4" to "lmdP4",
        "φ P1" to "phiP1",
        "φ U1" to "phiU1",
        "φ C1" to "phiC1",
        "φ U2" to "phiU2",
        "φ P2" to "phiP2",
        "φ Mx" to "phiMx",
        "φ P3" to "phiP3",
        "φ U3" to "phiU3",
        "φ C2" to "phiC2",
        "φ U4" to "phiU4",
        "φ P4" to "phiP4",

        "Azm P1" to "AzmP1",
        "Azm U1" to "AzmU1",
        "Azm C1" to "AzmC1",
        "Azm U2" to "AzmU2",
        "Azm P2" to "AzmP2",
        "Azm Mx" to "AzmMx",
        "Azm P3" to "AzmP3",
        "Azm U3" to "AzmU3",
        "Azm C2" to "AzmC2",
        "Azm U4" to "AzmU4",
        "Azm P4" to "AzmP4",

        "Alt P1" to "AltP1",
        "Alt U1" to "AltU1",
        "Alt C1" to "AltC1",
        "Alt U2" to "AltU2",
        "Alt P2" to "AltP2",
        "Alt Mx" to "AltMx",
        "Alt P3" to "AltP3",
        "Alt U3" to "AltU3",
        "Alt C2" to "AltC2",
        "Alt U4" to "AltU4",
        "Alt P4" to "AltP4"
    )

    for (t in CSE) {
        val tVal = solarEclipse2(blnH, thnH, t.second)
        if (!tVal.isNaN()) {
            val lmd = mf.DDDMS(tVal, "DDDMMSS", 0)
            println(t.first + "  :  " + lmd)
        } else {
            println(t.first + "  : -")
        }
    }


} // terakhir
