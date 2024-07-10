//GERHANA MATAHARI LOKAL
package app

import islamicTimes.*

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
    val gLat: Double = -(2 + 51 / 60.0 + 25 / 3600.0)
    val gLon: Double = (108 + 17 / 60.0 + 50 / 3600.0)
    val elev: Double = 2.0
    val TmZn: Double = 7.0
    val pres: Double = 1010.0
    val temp: Double = 10.0

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
            val deltaT = dt.DeltaT(jdeSolarEclipse2)

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

//Hisab Puncak Gerhana Matahari

    var TMx = 0.0
    var Pi = 0.0 //U
    var S = 0.0 //RhoSinP
    var C = 0.0 //RhoCosP
    var xMx = 0.0
    var yMx = 0.0
    var dMx = 0.0
    var MuMx = 0.0
    var L1Mx = 0.0
    var L2Mx = 0.0
    var xpMx = 0.0
    var ypMx = 0.0
    var HMx = 0.0
    var pMx = 0.0 //Xi
    var qMx = 0.0 //eta
    var rMx = 0.0 //zeta
    var prMx = 0.0 //xi'
    var qpMx = 0.0 //eta'
    var uMx = 0.0
    var vMx = 0.0
    var aMx = 0.0
    var bMx = 0.0
    var nMx = 0.0
    var PPMx = 0.0
    var AMx = 0.0

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

    val jdeSolarEclipse1 = mo.jdeEclipseModified(blnH, thnH, 1)
    val jdeSolarEclipse2 =
        Math.floor(jdeSolarEclipse1) + (((jdeSolarEclipse1 - Math.floor(jdeSolarEclipse1)) * 24).round(0)).toDouble() / 24.0
    val deltaT = dt.DeltaT(jdeSolarEclipse2)
    val t0 = ((jdeSolarEclipse2 + 0.5 + (0.0 / 24.0) - Math.floor(jdeSolarEclipse2 + 0.5 + (0.0 / 24.0))) * 24).round(0)
        .toDouble()

    TMx += PPMx
    for (i in 1..5) {
        Pi = Math.atan(0.99664719 * Math.tan(mf.Rad(gLat)))
        S = 0.99664719 * Math.sin(Pi) + (elev / 6378140) * Math.sin(mf.Rad(gLat))
        C = Math.cos(Pi) + (elev / 6378140) * Math.cos(mf.Rad(gLat))
        xMx = x0 + x1 * TMx + x2 * TMx * TMx + x3 * TMx * TMx * TMx + x4 * TMx * TMx * TMx * TMx
        yMx = y0 + y1 * TMx + y2 * TMx * TMx + y3 * TMx * TMx * TMx + y4 * TMx * TMx * TMx * TMx
        dMx = d0 + d1 * TMx + d2 * TMx * TMx + d3 * TMx * TMx * TMx + d4 * TMx * TMx * TMx * TMx
        MuMx = Mu0 + Mu1 * TMx + Mu2 * TMx * TMx + Mu3 * TMx * TMx * TMx + Mu4 * TMx * TMx * TMx * TMx
        L1Mx = L10 + L11 * TMx + L12 * TMx * TMx + L13 * TMx * TMx * TMx + L14 * TMx * TMx * TMx * TMx
        L2Mx = L20 + L21 * TMx + L22 * TMx * TMx + L23 * TMx * TMx * TMx + L24 * TMx * TMx * TMx * TMx
        xpMx = x1 + 2 * x2 * TMx + 3 * x3 * TMx * TMx + 4 * x4 * TMx * TMx * TMx
        ypMx = y1 + 2 * y2 * TMx + 3 * y3 * TMx * TMx + 4 * y4 * TMx * TMx * TMx
        HMx = mf.Rad(MuMx + gLon - 0.00417807 * deltaT)
        pMx = C * Math.sin(HMx)
        qMx = S * Math.cos(mf.Rad(dMx)) - C * Math.cos(HMx) * Math.sin(mf.Rad(dMx))
        rMx = S * Math.sin(mf.Rad(dMx)) + C * Math.cos(HMx) * Math.cos(mf.Rad(dMx))
        prMx = 0.01745329 * Mu1 * C * Math.cos(HMx)
        qpMx = 0.01745329 * (Mu1 * pMx * Math.sin(mf.Rad(dMx)) - rMx * d1)
        uMx = xMx - pMx
        vMx = yMx - qMx
        aMx = xpMx - prMx
        bMx = ypMx - qpMx
        nMx = aMx * aMx + bMx * bMx
        PPMx = -(uMx * aMx + vMx * bMx) / nMx
        TMx += PPMx
    }
    AMx = t0 + TMx - dt.DeltaT(jdeSolarEclipse2) / 3600.0
    val jdSolarEclipseMx = Math.floor(jdeSolarEclipse2 + 0.5) - 0.5 + (AMx / 24.0)

//Hisab Magnitude dan Obskurasi
    val mm = Math.sqrt(uMx * uMx + vMx * vMx)
    val L1p = L1Mx - rMx * tanf1
    val L2p = L2Mx - rMx * tanf2
    val nn = Math.sqrt(nMx)
    val zz = (aMx * vMx - uMx * bMx) / (nn * L1p)
    val Tau = (L1p / nn) * Math.sqrt(1 - zz * zz)
    val Mag = (L1p - mm) / (L1p + L2p)
    val rpMx = 2 * mm / (L1p + L2p)
    val spMx = (L1p - L2p) / (L1p + L2p)
    val yy = (spMx * spMx + rpMx * rpMx - 1) / (2 * rpMx * spMx)
    val zp = (rpMx * rpMx - spMx * spMx + 1) / (2 * 1 * rpMx)

    val BB = if (yy < -1) {
        3.141592654
    } else if (yy > 1) {
        0.0
    } else Math.cos(yy)

    val CC = if (zp < -1) {
        3.141592654
    } else if (zp > 1) {
        0.0
    } else Math.cos(zz)

    val Obs = ((spMx * spMx * (BB - Math.sin(2 * BB) / 2) + (CC - Math.sin(2 * CC) / 2)) / 3.141592654) * 100


//Hisab Jenis Gerhana Matahari
    var JSE: String

    JSE = if (Mag > 0.0 && mm > Math.abs(L2p)) {
        "GERHANA MATAHARI SEBAGIAN"
    } else if (Mag > 0.0 && mm < Math.abs(L2p) && L2p < 0.0) {
        "GERHANA MATAHARI TOTAL"
    } else if (Mag > 0.0 && mm < Math.abs(L2p) && L2p > 0.0) {
        "GERHANA MATAHARI CINCIN"
    } else {
        "TIDAK TERJADI GERHANA"
    }

    val Mag3: Double
    if (JSE == "GERHANA MATAHARI SEBAGIAN") {
        Mag3 = Mag
    } else {
        Mag3 = spMx
    }

//Hisab Kontak U2 dan U3

    val qq = (aMx * vMx - uMx * bMx) / (nn * L2p)
    val T2 = Math.abs((L2p / nn) * Math.sqrt(1 - qq * qq))
    val AU2 = AMx - T2
    val AU3 = AMx + T2

    val jdSolarEclipseU2 = Math.floor(jdeSolarEclipse2 + 0.5) - 0.5 + (AU2 / 24.0)
    val jdSolarEclipseU3 = Math.floor(jdeSolarEclipse2 + 0.5) - 0.5 + (AU3 / 24.0)

//Hisab Kontak U1
    val jdSolarEclipseU1: Double

    val T: Double = 0.0
    val AU1: Double
    var TU1: Double

    var xU1 = 0.0
    var yU1 = 0.0
    var dU1 = 0.0
    var MuU1 = 0.0
    var L1U1 = 0.0
    var xpU1 = 0.0
    var ypU1 = 0.0
    var HU1 = 0.0
    var pU1 = 0.0
    var qU1 = 0.0
    var rU1 = 0.0
    var prU1 = 0.0
    var qpU1 = 0.0
    var uU1 = 0.0
    var vU1 = 0.0
    var aU1 = 0.0
    var bU1 = 0.0
    var nU1 = 0.0
    var nnU1 = 0.0
    var L1pU1 = 0.0
    var mmU1 = 0.0
    var PPU1 = 0.0

    TU1 = T - Tau
    for (i in 1..5) {
        Pi = Math.atan(0.99664719 * Math.tan(mf.Rad(gLat)))
        S = 0.99664719 * Math.sin(Pi) + (elev / 6378140) * Math.sin(mf.Rad(gLat))
        C = Math.cos(Pi) + (elev / 6378140) * Math.cos(mf.Rad(gLat))
        xU1 = x0 + x1 * TU1 + x2 * TU1 * TU1 + x3 * TU1 * TU1 * TU1 + x4 * TU1 * TU1 * TU1 * TU1
        yU1 = y0 + y1 * TU1 + y2 * TU1 * TU1 + y3 * TU1 * TU1 * TU1 + y4 * TU1 * TU1 * TU1 * TU1
        dU1 = d0 + d1 * TU1 + d2 * TU1 * TU1 + d3 * TU1 * TU1 * TU1 + d4 * TU1 * TU1 * TU1 * TU1
        MuU1 = Mu0 + Mu1 * TU1 + Mu2 * TU1 * TU1 + Mu3 * TU1 * TU1 * TU1 + Mu4 * TU1 * TU1 * TU1 * TU1
        L1U1 = L10 + L11 * TU1 + L12 * TU1 * TU1 + L13 * TU1 * TU1 * TU1 + L14 * TU1 * TU1 * TU1 * TU1
        xpU1 = x1 + 2 * x2 * TU1 + 3 * x3 * TU1 * TU1 + 4 * x4 * TU1 * TU1 * TU1
        ypU1 = y1 + 2 * y2 * TU1 + 3 * y3 * TU1 * TU1 + 4 * y4 * TU1 * TU1 * TU1
        HU1 = mf.Rad(MuU1 + gLon.toDouble() - 0.00417807 * deltaT.toDouble())
        pU1 = C * Math.sin(HU1)
        qU1 = S * Math.cos(mf.Rad(dU1)) - C * Math.cos(HU1) * Math.sin(mf.Rad(dU1))
        rU1 = S * Math.sin(mf.Rad(dU1)) + C * Math.cos(HU1) * Math.cos(mf.Rad(dU1))
        prU1 = 0.01745329 * Mu1 * C * Math.cos(HU1)
        qpU1 = 0.01745329 * (Mu1 * pU1 * Math.sin(mf.Rad(dU1)) - rU1 * d1)
        uU1 = xU1 - pU1
        vU1 = yU1 - qU1
        aU1 = xpU1 - prU1
        bU1 = ypU1 - qpU1
        nU1 = aU1 * aU1 + bU1 * bU1
        nnU1 = Math.sqrt(nU1)
        L1pU1 = L1U1 - rU1 * tanf1
        mmU1 = (aU1 * vU1 - uU1 * bU1) / (nnU1 * L1pU1)
        PPU1 = -(uU1 * aU1 + vU1 * bU1) / nU1 - (L1pU1 / nnU1) * Math.sqrt(1 - mmU1 * mmU1)
        TU1 = TU1 + PPU1
    }
    AU1 = TU1 + PPU1 - deltaT / 3600.0
    jdSolarEclipseU1 = Math.floor(jdeSolarEclipse2 + 0.5) - 0.5 + ((t0 + AU1) / 24.0)

//Hisab Kontak U4

    val jdSolarEclipseU4: Double
    val AU4: Double
    var TU4: Double


    var xU4 = 0.0
    var yU4 = 0.0
    var dU4 = 0.0
    var MuU4 = 0.0
    var L1U4 = 0.0
    var xpU4 = 0.0
    var ypU4 = 0.0
    var HU4 = 0.0
    var pU4 = 0.0
    var qU4 = 0.0
    var rU4 = 0.0
    var prU4 = 0.0
    var qpU4 = 0.0
    var uU4 = 0.0
    var vU4 = 0.0
    var aU4 = 0.0
    var bU4 = 0.0
    var nU4 = 0.0
    var nnU4 = 0.0
    var L1pU4 = 0.0
    var mmU4 = 0.0
    var PPU4 = 0.0

    TU4 = T + Tau
    for (i in 1..5) {
        Pi = Math.atan(0.99664719 * Math.tan(mf.Rad(gLat)))
        S = 0.99664719 * Math.sin(Pi) + (elev / 6378140) * Math.sin(mf.Rad(gLat))
        C = Math.cos(Pi) + (elev / 6378140) * Math.cos(mf.Rad(gLat))
        xU4 = x0 + x1 * TU4 + x2 * TU4 * TU4 + x3 * TU4 * TU4 * TU4 + x4 * TU4 * TU4 * TU4 * TU4
        yU4 = y0 + y1 * TU4 + y2 * TU4 * TU4 + y3 * TU4 * TU4 * TU4 + y4 * TU4 * TU4 * TU4 * TU4
        dU4 = d0 + d1 * TU4 + d2 * TU4 * TU4 + d3 * TU4 * TU4 * TU4 + d4 * TU4 * TU4 * TU4 * TU4
        MuU4 = Mu0 + Mu1 * TU4 + Mu2 * TU4 * TU4 + Mu3 * TU4 * TU4 * TU4 + Mu4 * TU4 * TU4 * TU4 * TU4
        L1U4 = L10 + L11 * TU4 + L12 * TU4 * TU4 + L13 * TU4 * TU4 * TU4 + L14 * TU4 * TU4 * TU4 * TU4
        xpU4 = x1 + 2 * x2 * TU4 + 3 * x3 * TU4 * TU4 + 4 * x4 * TU4 * TU4 * TU4
        ypU4 = y1 + 2 * y2 * TU4 + 3 * y3 * TU4 * TU4 + 4 * y4 * TU4 * TU4 * TU4
        HU4 = mf.Rad(MuU4 + gLon.toDouble() - 0.00417807 * deltaT.toDouble())
        pU4 = C * Math.sin(HU4)
        qU4 = S * Math.cos(mf.Rad(dU4)) - C * Math.cos(HU4) * Math.sin(mf.Rad(dU4))
        rU4 = S * Math.sin(mf.Rad(dU4)) + C * Math.cos(HU4) * Math.cos(mf.Rad(dU4))
        prU4 = 0.01745329 * Mu1 * C * Math.cos(HU4)
        qpU4 = 0.01745329 * (Mu1 * pU4 * Math.sin(mf.Rad(dU4)) - rU4 * d1)
        uU4 = xU4 - pU4
        vU4 = yU4 - qU4
        aU4 = xpU4 - prU4
        bU4 = ypU4 - qpU4
        nU4 = aU4 * aU4 + bU4 * bU4
        nnU4 = Math.sqrt(nU4)
        L1pU4 = L1U4 - rU4 * tanf1
        mmU4 = (aU4 * vU4 - uU4 * bU4) / (nnU4 * L1pU4)
        PPU4 = -(uU4 * aU4 + vU4 * bU4) / nU4 + (L1pU4 / nnU4) * Math.sqrt(1 - mmU4 * mmU4)
        TU4 = TU4 + PPU4
    }
    AU4 = TU4 + PPU4 - deltaT / 3600.0
    jdSolarEclipseU4 = Math.floor(jdeSolarEclipse2 + 0.5) - 0.5 + ((t0 + AU4) / 24.0)

    //Hisab Azimuth tiap kontak
    val azmU1: Double = sn.sunTopocentricAzimuth(jdSolarEclipseU1, deltaT, gLon, gLat, elev)
    val azmU2: Double = sn.sunTopocentricAzimuth(jdSolarEclipseU2, deltaT, gLon, gLat, elev)
    val azmMx: Double = sn.sunTopocentricAzimuth(jdSolarEclipseMx, deltaT, gLon, gLat, elev)
    val azmU3: Double = sn.sunTopocentricAzimuth(jdSolarEclipseU3, deltaT, gLon, gLat, elev)
    val azmU4: Double = sn.sunTopocentricAzimuth(jdSolarEclipseU4, deltaT, gLon, gLat, elev)

    //Hisab Altitude tiap kontak
    val altU1: Double = sn.sunTopocentricAltitude(jdSolarEclipseU1, deltaT, gLon, gLat, elev, pres, temp, "htoc")
    val altU2: Double = sn.sunTopocentricAltitude(jdSolarEclipseU2, deltaT, gLon, gLat, elev, pres, temp, "htoc")
    val altMx: Double = sn.sunTopocentricAltitude(jdSolarEclipseMx, deltaT, gLon, gLat, elev, pres, temp, "htoc")
    val altU3: Double = sn.sunTopocentricAltitude(jdSolarEclipseU3, deltaT, gLon, gLat, elev, pres, temp, "htoc")
    val altU4: Double = sn.sunTopocentricAltitude(jdSolarEclipseU4, deltaT, gLon, gLat, elev, pres, temp, "htoc")

    //Hisab data Matahari & Bulan saat puncak gerhana
    val RAs: Double = sn.sunGeocentricRightAscension(jdSolarEclipseMx, deltaT)
    val DCs: Double = sn.sunGeocentricDeclination(jdSolarEclipseMx, deltaT)
    val SDs: Double = sn.sunGeocentricSemidiameter(jdSolarEclipseMx, deltaT)
    val HPs: Double = sn.sunEquatorialHorizontalParallax(jdSolarEclipseMx, deltaT)

    val RAm: Double = mo.moonGeocentricRightAscension(jdSolarEclipseMx, deltaT)
    val DCm: Double = mo.moonGeocentricDeclination(jdSolarEclipseMx, deltaT)
    val SDm: Double = mo.moonGeocentricSemidiameter(jdSolarEclipseMx, deltaT)
    val HPm: Double = mo.moonEquatorialHorizontalParallax(jdSolarEclipseMx, deltaT)

    //Fungsi gerhana Matahari

    fun solarEclipse(
        hijriMonth: Byte,
        hijriYear: Long,
        gLat: Double,
        gLon: Double,
        elev: Double,
        optResult: String
    ): Double {
        val JDSU1 = jdSolarEclipseU1
        val JDSU2 = jdSolarEclipseU2
        val JDSMx = jdSolarEclipseMx
        val JDSU3 = jdSolarEclipseU3
        val JDSU4 = jdSolarEclipseU4

        val DurG = (JDSU4 - JDSU1) * 24
        val DurT = (JDSU3 - JDSU2) * 24

        val Obs1 = Obs
        val Mag1 = Mag

        val SEAltU1 = altU1
        val SEAltU2 = altU2
        val SEAltMx = altMx
        val SEAltU3 = altU3
        val SEAltU4 = altU4

        val SEAzmU1 = azmU1
        val SEAzmU2 = azmU2
        val SEAzmMx = azmMx
        val SEAzmU3 = azmU3
        val SEAzmU4 = azmU4

        val RAs1 = RAs
        val DCs1 = DCs
        val SDs1 = SDs
        val HPs1 = HPs

        val RAm1 = RAm
        val DCm1 = DCm
        val SDm1 = SDm
        val HPm1 = HPm

        return when (optResult) {
            "JDSU1" -> JDSU1
            "JDSU2" -> JDSU2
            "JDSMx" -> JDSMx
            "JDSU3" -> JDSU3
            "JDSU4" -> JDSU4

            "Mag" -> Mag1
            "Obs" -> Obs1

            "DurG" -> DurG
            "DurT" -> DurT
            "AltU1" -> SEAltU1
            "AzmU1" -> SEAzmU1
            "AltU2" -> SEAltU2
            "AzmU2" -> SEAzmU2
            "AltMx" -> SEAltMx
            "AzmMx" -> SEAzmMx
            "AltU3" -> SEAltU3
            "AzmU3" -> SEAzmU3
            "AltU4" -> SEAltU4
            "AzmU4" -> SEAzmU4

            "RAs" -> RAs1
            "DCs" -> DCs1
            "SDs" -> SDs1
            "HPs" -> HPs1

            "RAm" -> RAm1
            "DCm" -> DCm1
            "SDm" -> SDm1
            "HPm" -> HPm1

            else -> JDSMx
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

    println(" ")
    println("${JSE}")
    println(" ")

    val tSE = arrayOf(
        "U1" to "JDSU1",
        "U2" to "JDSU2",
        "Mx" to "JDSMx",
        "U3" to "JDSU3",
        "U4" to "JDSU4"
    )
    for (t in tSE) {
        val tVal = solarEclipse(blnH, thnH, gLat, gLon, elev, t.second)
        if (!tVal.isNaN()) {
            val tTgl = jd.JDKM(+tVal, TmZn)
            val tJam = mf.DHHMS(jd.JDKM(tVal, TmZn, "Jam Des").toDouble(), "HH:MM:SS", 0)
            println(t.first + "  : " + tTgl + ", Jam: " + tJam)
        } else {
            println(t.first + "  : -")
        }
    }

    println(" ")
    val lSE = arrayOf(
        "Durasi Gerhana      " to "DurG",
        "Durasi Total/Cincin " to "DurT"
    )
    for (t in lSE) {
        val tVal = solarEclipse(blnH, thnH, gLat, gLon, elev, t.second)
        if (!tVal.isNaN()) {
            println(t.first + "  : " + mf.DHHMS(tVal, "HH:MM:SS", 0))
        } else {
            println(t.first + "  : -")
        }
    }

    println(" ")
    val oSE = arrayOf(
        "Magnitude Umbra     " to "Mag",
        "Obskurasi           " to "Obs"
    )
    for (t in oSE) {
        val tVal = solarEclipse(blnH, thnH, gLat, gLon, elev, t.second)
        val tTx: String = if (t.second == "Obs") tVal.round(3) + " %"
        else tVal.round(3)
        if (!tVal.isNaN()) {
            println(t.first + "  : " + tTx)
        } else {
            println(t.first + "  : -")
        }
    }

    println("")
    println("Azimuth & Altitude tiap kontak gerhana")
    val pSE = arrayOf(
        "Azm U1 " to "AzmU1",
        "Azm U2 " to "AzmU2",
        "Azm Mx " to "AzmMx",
        "Azm U3 " to "AzmU3",
        "Azm U4 " to "AzmU4",
        "Alt U1 " to "AltU1",
        "Alt U2 " to "AltU2",
        "Alt Mx " to "AltMx",
        "Alt U3 " to "AltU3",
        "Alt U4 " to "AltU4"
    )
    for (t in pSE) {
        val tVal = solarEclipse(blnH, thnH, gLat, gLon, elev, t.second)
        if (!tVal.isNaN()) {
            println(t.first + "  : " + tVal.round(0) + "°")
        } else {
            println(t.first + "  : -")
        }
    }

    val dSE = arrayOf(
        "RAs " to "RAs",
        "DCs " to "DCs",
        "SDs " to "SDs",
        "HPs " to "HPs",
        "RAm " to "RAm",
        "DCm " to "DCm",
        "SDm " to "SDm",
        "HPm " to "HPm"
    )

    println("")
    println("Data Matahari & Bulan saat puncak Gerhana")
    for (t in dSE) {
        val tVal = solarEclipse(blnH, thnH, gLat, gLon, elev, t.second)
        val tVt: String = if (t.second == "RAs") mf.DHHMS(tVal / 15.0, "HHMMSS", 1)
        else if (t.second == "RAm") mf.DHHMS(tVal / 15.0, "HHMMSS", 1)
        else mf.DDDMS(tVal, "", 1)

        if (!tVal.isNaN()) {
            println(t.first + "  : " + tVt)
        } else {
            println(t.first + "  : -")
        }
    }

}

//Abu Sabda
//Kode dioptimalisasi pada 28 Desember 2023