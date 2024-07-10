package id.or.persis.dhr.hisabastronomis.islamicTimes

class NutationAndObliquity {

    val jd = JulianDay()
    val mf = MathFunction()
    ///NUTASI DAN KEMIRINGAN EKLIPTIKA

    // Nutation in Longitude
    fun nutationInLongitude(JD: Double, DeltaT: Double): Double {
        val JDE: Double
        val T: Double
        val T2: Double
        val T3: Double
        val T4: Double
        var L: Double
        var Lp: Double
        var F: Double
        var D: Double
        var Om: Double
        var s: Double
        var dPsiDeg: Double

        JDE = JD + DeltaT / 86400.0
        T = (JDE - 2451545) / 36525.0
        T2 = T * T
        T3 = T * T2
        T4 = T * T3

        //COMPUTE FUNDAMENTAL DELAUNAY ARGUMENTS (L, Lp, F, D, Om)

        L = (485868.249036 + 1717915923.2178 * T + 31.8792 * T2 + 0.051635 * T3 - 0.00024470 * T4) / 3600.0
        Lp = (1287104.79305 + 129596581.0481 * T - 0.5532 * T2 + 0.000136 * T3 - 0.00001149 * T4) / 3600.0
        F = (335779.526232 + 1739527262.8478 * T - 12.7512 * T2 - 0.001037 * T3 + 0.00000417 * T4) / 3600.0
        D = (1072260.70369 + 1602961601.2090 * T - 6.3706 * T2 + 0.006593 * T3 - 0.00003169 * T4) / 3600.0
        Om = (450160.398036 - 6962890.5431 * T + 7.4722 * T2 + 0.007702 * T3 - 0.00005939 * T4) / 3600.0


        L = mf.Rad(mf.Mod(L, 360.0))
        Lp = mf.Rad(mf.Mod(Lp, 360.0))
        F = mf.Rad(mf.Mod(F, 360.0))
        D = mf.Rad(mf.Mod(D, 360.0))
        Om = mf.Rad(mf.Mod(Om, 360.0))

        s = 0.0
        s += (-172064161.0 + -174666.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + 33386.0 * Math.cos(0 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-13170906.0 + -1675.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -13696.0 * Math.cos(0 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-2276413.0 + -234.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 2796.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (2074554.0 + 207.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + -698.0 * Math.cos(0 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (1475877.0 + -3633.0 * T) * Math.sin(0 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om) + 11817.0 * Math.cos(0 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-516821.0 + 1226.0 * T) * Math.sin(0 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om) + -524.0 * Math.cos(0 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (711159.0 + 73.0 * T) * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om) + -872.0 * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-387298.0 + -367.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 380.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (-301461.0 + -36.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 816.0 * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (215829.0 + -494.0 * T) * Math.sin(0 * L + -1 * Lp + 2 * F + -2 * D + 2 * Om) + 111.0 * Math.cos(0 * L + -1 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (128227.0 + 137.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + 181.0 * Math.cos(0 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (123457.0 + 11.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 19.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (156994.0 + 10.0 * T) * Math.sin(-1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + -168.0 * Math.cos(-1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (63110.0 + 63.0 * T) * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + 27.0 * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-57976.0 + -63.0 * T) * Math.sin(-1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -189.0 * Math.cos(-1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-59641.0 + -11.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 149.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-51613.0 + -42.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 129.0 * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (45893.0 + 50.0 * T) * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 31.0 * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (63384.0 + 11.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + -150.0 * Math.cos(0 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-38571.0 + -1.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 158.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (32481.0 + 0.0 * T) * Math.sin(0 * L + -2 * Lp + 2 * F + -2 * D + 2 * Om) + 0.0 * Math.cos(0 * L + -2 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-47722.0 + 0.0 * T) * Math.sin(-2 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + -18.0 * Math.cos(-2 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-31046.0 + -1.0 * T) * Math.sin(2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 131.0 * Math.cos(2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (28593.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -1.0 * Math.cos(1 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (20441.0 + 21.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 10.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (29243.0 + 0.0 * T) * Math.sin(2 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om) + -74.0 * Math.cos(2 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (25887.0 + 0.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + -66.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (-14053.0 + -25.0 * T) * Math.sin(0 * L + 1 * Lp + 0 * F + 0 * D + 1 * Om) + 79.0 * Math.cos(0 * L + 1 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (15164.0 + 10.0 * T) * Math.sin(-1 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + 11.0 * Math.cos(-1 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (-15794.0 + 72.0 * T) * Math.sin(0 * L + 2 * Lp + 2 * F + -2 * D + 2 * Om) + -16.0 * Math.cos(0 * L + 2 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (21783.0 + 0.0 * T) * Math.sin(0 * L + 0 * Lp + -2 * F + 2 * D + 0 * Om) + 13.0 * Math.cos(0 * L + 0 * Lp + -2 * F + 2 * D + 0 * Om)
        s += (-12873.0 + -10.0 * T) * Math.sin(1 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + -37.0 * Math.cos(1 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (-12654.0 + 11.0 * T) * Math.sin(0 * L + -1 * Lp + 0 * F + 0 * D + 1 * Om) + 63.0 * Math.cos(0 * L + -1 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-10204.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 25.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (16707.0 + -85.0 * T) * Math.sin(0 * L + 2 * Lp + 0 * F + 0 * D + 0 * Om) + -10.0 * Math.cos(0 * L + 2 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-7691.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 44.0 * Math.cos(1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-11024.0 + 0.0 * T) * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + -14.0 * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (7566.0 + -21.0 * T) * Math.sin(0 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om) + -11.0 * Math.cos(0 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-6637.0 + -11.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 25.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (-7141.0 + 21.0 * T) * Math.sin(0 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om) + 8.0 * Math.cos(0 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-6302.0 + -11.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + 2.0 * Math.cos(0 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (5800.0 + 10.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + 2.0 * Math.cos(1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (6443.0 + 0.0 * T) * Math.sin(2 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -7.0 * Math.cos(2 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-5774.0 + -11.0 * T) * Math.sin(-2 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + -15.0 * Math.cos(-2 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (-5350.0 + 0.0 * T) * Math.sin(2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 21.0 * Math.cos(2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (-4752.0 + -11.0 * T) * Math.sin(0 * L + -1 * Lp + 2 * F + -2 * D + 1 * Om) + -3.0 * Math.cos(0 * L + -1 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-4940.0 + -11.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + -21.0 * Math.cos(0 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (7350.0 + 0.0 * T) * Math.sin(-1 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om) + -8.0 * Math.cos(-1 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (4065.0 + 0.0 * T) * Math.sin(2 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + 6.0 * Math.cos(2 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (6579.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + -24.0 * Math.cos(1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (3579.0 + 0.0 * T) * Math.sin(0 * L + 1 * Lp + 2 * F + -2 * D + 1 * Om) + 5.0 * Math.cos(0 * L + 1 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (4725.0 + 0.0 * T) * Math.sin(1 * L + -1 * Lp + 0 * F + 0 * D + 0 * Om) + -6.0 * Math.cos(1 * L + -1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-3075.0 + 0.0 * T) * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + -2.0 * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-2904.0 + 0.0 * T) * Math.sin(3 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 15.0 * Math.cos(3 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (4348.0 + 0.0 * T) * Math.sin(0 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om) + -10.0 * Math.cos(0 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-2878.0 + 0.0 * T) * Math.sin(1 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om) + 8.0 * Math.cos(1 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-4230.0 + 0.0 * T) * Math.sin(0 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om) + 5.0 * Math.cos(0 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (-2819.0 + 0.0 * T) * Math.sin(-1 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om) + 7.0 * Math.cos(-1 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-4056.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + 5.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (-2647.0 + 0.0 * T) * Math.sin(0 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om) + 11.0 * Math.cos(0 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-2294.0 + 0.0 * T) * Math.sin(-2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -10.0 * Math.cos(-2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (2481.0 + 0.0 * T) * Math.sin(1 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om) + -7.0 * Math.cos(1 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (2179.0 + 0.0 * T) * Math.sin(2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -2.0 * Math.cos(2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (3276.0 + 0.0 * T) * Math.sin(-1 * L + 1 * Lp + 0 * F + 1 * D + 0 * Om) + 1.0 * Math.cos(-1 * L + 1 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (-3389.0 + 0.0 * T) * Math.sin(1 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om) + 5.0 * Math.cos(1 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (3339.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + -13.0 * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (-1987.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + -6.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-1981.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + 0.0 * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (4026.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om) + -353.0 * Math.cos(-1 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (1660.0 + 0.0 * T) * Math.sin(0 * L + 0 * Lp + 2 * F + 1 * D + 2 * Om) + -5.0 * Math.cos(0 * L + 0 * Lp + 2 * F + 1 * D + 2 * Om)
        s += (-1521.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 2 * F + 4 * D + 2 * Om) + 9.0 * Math.cos(-1 * L + 0 * Lp + 2 * F + 4 * D + 2 * Om)
        s += (1314.0 + 0.0 * T) * Math.sin(-1 * L + 1 * Lp + 0 * F + 1 * D + 1 * Om) + 0.0 * Math.cos(-1 * L + 1 * Lp + 0 * F + 1 * D + 1 * Om)
        s += (-1283.0 + 0.0 * T) * Math.sin(0 * L + -2 * Lp + 2 * F + -2 * D + 1 * Om) + 0.0 * Math.cos(0 * L + -2 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-1331.0 + 0.0 * T) * Math.sin(1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 8.0 * Math.cos(1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (1383.0 + 0.0 * T) * Math.sin(-2 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + -2.0 * Math.cos(-2 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (1405.0 + 0.0 * T) * Math.sin(-1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + 4.0 * Math.cos(-1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (1290.0 + 0.0 * T) * Math.sin(1 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om) + 0.0 * Math.cos(1 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om)
        dPsiDeg = s / 36000000000.0
        return dPsiDeg
    }

    fun nutationInObliquity(JD: Double, DeltaT: Double): Double {
        val JDE: Double
        val T: Double
        val T2: Double
        val T3: Double
        val T4: Double
        var L: Double
        var Lp: Double
        var F: Double
        var D: Double
        var Om: Double
        var s: Double
        var dEpsDeg: Double

        JDE = JD + DeltaT / 86400.0
        T = (JDE - 2451545) / 36525
        T2 = T * T
        T3 = T * T2
        T4 = T * T3

        //COMPUTE FUNDAMENTAL DELAUNAY ARGUMENTS (L, Lp, F, D, Om)

        L = (485868.249036 + 1717915923.2178 * T + 31.8792 * T2 + 0.051635 * T3 - 0.00024470 * T4) / 3600.0
        Lp = (1287104.79305 + 129596581.0481 * T - 0.5532 * T2 + 0.000136 * T3 - 0.00001149 * T4) / 3600.0
        F = (335779.526232 + 1739527262.8478 * T - 12.7512 * T2 - 0.001037 * T3 + 0.00000417 * T4) / 3600.0
        D = (1072260.70369 + 1602961601.2090 * T - 6.3706 * T2 + 0.006593 * T3 - 0.00003169 * T4) / 3600.0
        Om = (450160.398036 - 6962890.5431 * T + 7.4722 * T2 + 0.007702 * T3 - 0.00005939 * T4) / 3600.0


        L = mf.Rad(mf.Mod(L, 360.0))
        Lp = mf.Rad(mf.Mod(Lp, 360.0))
        F = mf.Rad(mf.Mod(F, 360.0))
        D = mf.Rad(mf.Mod(D, 360.0))
        Om = mf.Rad(mf.Mod(Om, 360.0))

        s = 0.0
        s += (92052331.0 + 9086.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + 15377.0 * Math.sin(0 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (5730336.0 + -3015.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -4587.0 * Math.sin(0 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (978459.0 + -485.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 1374.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-897492.0 + 470.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + -291.0 * Math.sin(0 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (73871.0 + -184.0 * T) * Math.cos(0 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om) + -1924.0 * Math.sin(0 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (224386.0 + -677.0 * T) * Math.cos(0 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om) + -174.0 * Math.sin(0 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-6750.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om) + 358.0 * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (200728.0 + 18.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 318.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (129025.0 + -63.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 367.0 * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-95929.0 + 299.0 * T) * Math.cos(0 * L + -1 * Lp + 2 * F + -2 * D + 2 * Om) + 132.0 * Math.sin(0 * L + -1 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-68982.0 + -9.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + 39.0 * Math.sin(0 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-53311.0 + 32.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + -4.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-1235.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + 82.0 * Math.sin(-1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-33228.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -9.0 * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (31429.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -75.0 * Math.sin(-1 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (25543.0 + -11.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 66.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (26366.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 78.0 * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (-24236.0 + -10.0 * T) * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 20.0 * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (-1220.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + 29.0 * Math.sin(0 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (16452.0 + -11.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 68.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-13870.0 + 0.0 * T) * Math.cos(0 * L + -2 * Lp + 2 * F + -2 * D + 2 * Om) + 0.0 * Math.sin(0 * L + -2 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (477.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + -25.0 * Math.sin(-2 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (13238.0 + -11.0 * T) * Math.cos(2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 59.0 * Math.sin(2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-12338.0 + 10.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -3.0 * Math.sin(1 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-10758.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + -3.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (-609.0 + 0.0 * T) * Math.cos(2 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om) + 13.0 * Math.sin(2 * L + 0 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-550.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + 11.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (8551.0 + -2.0 * T) * Math.cos(0 * L + 1 * Lp + 0 * F + 0 * D + 1 * Om) + -45.0 * Math.sin(0 * L + 1 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-8001.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + -1.0 * Math.sin(-1 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (6850.0 + -42.0 * T) * Math.cos(0 * L + 2 * Lp + 2 * F + -2 * D + 2 * Om) + -5.0 * Math.sin(0 * L + 2 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (-167.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + -2 * F + 2 * D + 0 * Om) + 13.0 * Math.sin(0 * L + 0 * Lp + -2 * F + 2 * D + 0 * Om)
        s += (6953.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + -14.0 * Math.sin(1 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (6415.0 + 0.0 * T) * Math.cos(0 * L + -1 * Lp + 0 * F + 0 * D + 1 * Om) + 26.0 * Math.sin(0 * L + -1 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (5222.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 15.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (168.0 + -1.0 * T) * Math.cos(0 * L + 2 * Lp + 0 * F + 0 * D + 0 * Om) + 10.0 * Math.sin(0 * L + 2 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (3268.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + 19.0 * Math.sin(1 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (104.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + 2.0 * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (-3250.0 + 0.0 * T) * Math.cos(0 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om) + -5.0 * Math.sin(0 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (3353.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 14.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (3070.0 + 0.0 * T) * Math.cos(0 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om) + 4.0 * Math.sin(0 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (3272.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + 4.0 * Math.sin(0 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (-3045.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + -1.0 * Math.sin(1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-2768.0 + 0.0 * T) * Math.cos(2 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om) + -4.0 * Math.sin(2 * L + 0 * Lp + 2 * F + -2 * D + 2 * Om)
        s += (3041.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om) + -5.0 * Math.sin(-2 * L + 0 * Lp + 0 * F + 2 * D + 1 * Om)
        s += (2695.0 + 0.0 * T) * Math.cos(2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om) + 12.0 * Math.sin(2 * L + 0 * Lp + 2 * F + 0 * D + 1 * Om)
        s += (2719.0 + 0.0 * T) * Math.cos(0 * L + -1 * Lp + 2 * F + -2 * D + 1 * Om) + -3.0 * Math.sin(0 * L + -1 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (2720.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + -9.0 * Math.sin(0 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (-51.0 + 0.0 * T) * Math.cos(-1 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om) + 4.0 * Math.sin(-1 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-2206.0 + 0.0 * T) * Math.cos(2 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om) + 1.0 * Math.sin(2 * L + 0 * Lp + 0 * F + -2 * D + 1 * Om)
        s += (-199.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om) + 2.0 * Math.sin(1 * L + 0 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (-1900.0 + 0.0 * T) * Math.cos(0 * L + 1 * Lp + 2 * F + -2 * D + 1 * Om) + 1.0 * Math.sin(0 * L + 1 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (-41.0 + 0.0 * T) * Math.cos(1 * L + -1 * Lp + 0 * F + 0 * D + 0 * Om) + 3.0 * Math.sin(1 * L + -1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (1313.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + -1.0 * Math.sin(-2 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (1233.0 + 0.0 * T) * Math.cos(3 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om) + 7.0 * Math.sin(3 * L + 0 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-81.0 + 0.0 * T) * Math.cos(0 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om) + 2.0 * Math.sin(0 * L + -1 * Lp + 0 * F + 2 * D + 0 * Om)
        s += (1232.0 + 0.0 * T) * Math.cos(1 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om) + 4.0 * Math.sin(1 * L + -1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-20.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om) + -2.0 * Math.sin(0 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (1207.0 + 0.0 * T) * Math.cos(-1 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om) + 3.0 * Math.sin(-1 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (40.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + -2.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (1129.0 + 0.0 * T) * Math.cos(0 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om) + 5.0 * Math.sin(0 * L + -1 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (1266.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -4.0 * Math.sin(-2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-1062.0 + 0.0 * T) * Math.cos(1 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om) + -3.0 * Math.sin(1 * L + 1 * Lp + 2 * F + 0 * D + 2 * Om)
        s += (-1129.0 + 0.0 * T) * Math.cos(2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om) + -2.0 * Math.sin(2 * L + 0 * Lp + 0 * F + 0 * D + 1 * Om)
        s += (-9.0 + 0.0 * T) * Math.cos(-1 * L + 1 * Lp + 0 * F + 1 * D + 0 * Om) + 0.0 * Math.sin(-1 * L + 1 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (35.0 + 0.0 * T) * Math.cos(1 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om) + -2.0 * Math.sin(1 * L + 1 * Lp + 0 * F + 0 * D + 0 * Om)
        s += (-107.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om) + 1.0 * Math.sin(1 * L + 0 * Lp + 2 * F + 0 * D + 0 * Om)
        s += (1073.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om) + -2.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (854.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + 0.0 * Math.sin(1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (-553.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om) + -139.0 * Math.sin(-1 * L + 0 * Lp + 0 * F + 1 * D + 0 * Om)
        s += (-710.0 + 0.0 * T) * Math.cos(0 * L + 0 * Lp + 2 * F + 1 * D + 2 * Om) + -2.0 * Math.sin(0 * L + 0 * Lp + 2 * F + 1 * D + 2 * Om)
        s += (647.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 2 * F + 4 * D + 2 * Om) + 4.0 * Math.sin(-1 * L + 0 * Lp + 2 * F + 4 * D + 2 * Om)
        s += (-700.0 + 0.0 * T) * Math.cos(-1 * L + 1 * Lp + 0 * F + 1 * D + 1 * Om) + 0.0 * Math.sin(-1 * L + 1 * Lp + 0 * F + 1 * D + 1 * Om)
        s += (672.0 + 0.0 * T) * Math.cos(0 * L + -2 * Lp + 2 * F + -2 * D + 1 * Om) + 0.0 * Math.sin(0 * L + -2 * Lp + 2 * F + -2 * D + 1 * Om)
        s += (663.0 + 0.0 * T) * Math.cos(1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om) + 4.0 * Math.sin(1 * L + 0 * Lp + 2 * F + 2 * D + 1 * Om)
        s += (-594.0 + 0.0 * T) * Math.cos(-2 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om) + -2.0 * Math.sin(-2 * L + 0 * Lp + 2 * F + 2 * D + 2 * Om)
        s += (-610.0 + 0.0 * T) * Math.cos(-1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om) + 2.0 * Math.sin(-1 * L + 0 * Lp + 0 * F + 0 * D + 2 * Om)
        s += (-556.0 + 0.0 * T) * Math.cos(1 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om) + 0.0 * Math.sin(1 * L + 1 * Lp + 2 * F + -2 * D + 2 * Om)
        dEpsDeg = s / 36000000000.0
        return dEpsDeg
    }

    fun meanObliquityOfEcliptic(
        JD: Double,
        DeltaT: Double
    ): Double {
        val JDE: Double
        val T: Double
        val U: Double
        val Eps0: Double

        JDE = JD + DeltaT / 86400.0
        T = (JDE - 2451545) / 36525
        U = T / 100
        Eps0 = 23.0 + 26.0 / 60 + 21.448 / 3600 + (-4680.93 * U
                - 1.55 * Math.pow(U, 2.0)
                + 1999.25 * Math.pow(U, 3.0)
                - 51.38 * Math.pow(U, 4.0)
                - 249.67 * Math.pow(U, 5.0)
                - 39.05 * Math.pow(U, 6.0)
                + 7.12 * Math.pow(U, 7.0)
                + 27.87 * Math.pow(U, 8.0)
                + 5.79 * Math.pow(U, 9.0)
                + 2.45 * Math.pow(U, 10.0)) / 3600
        return Eps0
    }

    fun trueObliquityOfEcliptic(
        JD: Double,
        DeltaT: Double
    ): Double {
        val Eps0: Double
        val DltEps: Double
        val Eps: Double

        Eps0 = meanObliquityOfEcliptic(JD, DeltaT)
        DltEps = nutationInObliquity(JD, DeltaT)
        Eps = Eps0 + DltEps
        return Eps
    }
}
