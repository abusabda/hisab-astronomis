package id.or.persis.dhr.hisabastronomis.islamicTimes

class SunDatas {

    val l000 = SunDataL00()
    val l001 = SunDataL01()
    val l002 = SunDataL02()
    val l003 = SunDataL03()
    val l004 = SunDataL04()
    val l005 = SunDataL05()

    val B000 = SunDataB00()
    val B001 = SunDataB01()
    val B002 = SunDataB02()
    val B003 = SunDataB03()
    val B004 = SunDataB04()

    val R000 = SunDataR00()
    val R001 = SunDataR01()
    val R002 = SunDataR02()
    val R003 = SunDataR03()
    val R004 = SunDataR04()
    val R005 = SunDataR05()


    val jd = JulianDay()
    val mf = MathFunction()
    val nt = NutationAndObliquity()
    val dt = DynamicalTime()

    fun earthHeliocentricLongitude(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0 //Waktu Dalam Dynamical Time (TD)
        val t: Double = jd.JC(jde)
        val tau: Double = jd.JM(t)

        //lo = 559 Terms
        var aa = 0
        var l000sum = 0.0
        while (aa < 559) {
            l000sum += l000.VSOP87D_MT_L0[aa][0] * Math.cos(l000.VSOP87D_MT_L0[aa][1] + l000.VSOP87D_MT_L0[aa][2] * tau)
            aa++
        }

        //l1 = 341 Terms
        var bb = 0
        var l001sum = 0.0
        while (bb < 341) {
            l001sum += l001.VSOP87D_MT_L1[bb][0] * Math.cos(l001.VSOP87D_MT_L1[bb][1] + l001.VSOP87D_MT_L1[bb][2] * tau)
            bb++
        }

        //l2 = 142 Terms
        var cc = 0
        var l002sum = 0.0
        while (cc < 142) {
            l002sum += l002.VSOP87D_MT_L2[cc][0] * Math.cos(l002.VSOP87D_MT_L2[cc][1] + l002.VSOP87D_MT_L2[cc][2] * tau)
            cc++
        }

        //l3 = 22 Terms
        var dd = 0
        var l003sum = 0.0
        while (dd < 22) {
            l003sum += l003.VSOP87D_MT_L3[dd][0] * Math.cos(l003.VSOP87D_MT_L3[dd][1] + l003.VSOP87D_MT_L3[dd][2] * tau)
            dd++
        }

        //l4 = 11 Terms
        var ee = 0
        var l004sum = 0.0
        while (ee < 11) {
            l004sum += l004.VSOP87D_MT_L4[ee][0] * Math.cos(l004.VSOP87D_MT_L4[ee][1] + l004.VSOP87D_MT_L4[ee][2] * tau)
            ee++
        }

        //l5 = 5 Terms
        var ff = 0
        var l005sum = 0.0
        while (ff < 5) {
            l005sum += l005.VSOP87D_MT_L5[ff][0] * Math.cos(l005.VSOP87D_MT_L5[ff][1] + l005.VSOP87D_MT_L5[ff][2] * tau)
            ff++
        }

        val l = mf.Mod(
            mf.Deg(
                (l000sum + l001sum * tau + l002sum * Math.pow(tau, 2.0) + l003sum * Math.pow(
                    tau,
                    3.0
                ) + l004sum * Math.pow(tau, 4.0) + l005sum * Math.pow(tau, 5.0))
            ), 360.0
        )
        return l
    }

    fun earthHeliocentricLatitude(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val tau: Double = jd.JM(t)

        //b0 = 184 Terms
        var aa = 0
        var B000sum = 0.0
        while (aa < 184) {
            B000sum += B000.VSOP87D_MT_B0[aa][0] * Math.cos(B000.VSOP87D_MT_B0[aa][1] + B000.VSOP87D_MT_B0[aa][2] * tau)
            aa++
        }

        //b1 = 99 Terms
        var bb = 0
        var B001sum = 0.0
        while (bb < 99) {
            B001sum += B001.VSOP87D_MT_B1[bb][0] * Math.cos(B001.VSOP87D_MT_B1[bb][1] + B001.VSOP87D_MT_B1[bb][2] * tau)
            bb++
        }

        //b2 = 49 Terms
        var cc = 0
        var B002sum = 0.0
        while (cc < 49) {
            B002sum += B002.VSOP87D_MT_B2[cc][0] * Math.cos(B002.VSOP87D_MT_B2[cc][1] + B002.VSOP87D_MT_B2[cc][2] * tau)
            cc++
        }

        //b3 = 11 Terms
        var dd = 0
        var B003sum = 0.0
        while (dd < 11) {
            B003sum += B003.VSOP87D_MT_B3[dd][0] * Math.cos(B003.VSOP87D_MT_B3[dd][1] + B003.VSOP87D_MT_B3[dd][2] * tau)
            dd++
        }
        //b4 = 5
        var ee = 0
        var B004sum = 0.0
        while (ee < 5) {
            B004sum += B004.VSOP87D_MT_B4[ee][0] * Math.cos(B004.VSOP87D_MT_B4[ee][1] + B004.VSOP87D_MT_B4[ee][2] * tau)
            ee++
        }

        val b = mf.Deg(
            (B000sum + B001sum * tau + B002sum * Math.pow(tau, 2.0) + B003sum * Math.pow(
                tau,
                3.0
            ) + B004sum * Math.pow(tau, 4.0))
        )
        return b
    }

    fun earthRadiusVector(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val tau: Double = jd.JM(t)

        //r0 = 526 Term
        var aa = 0
        var R000sum = 0.0
        while (aa < 526) {
            R000sum += R000.VSOP87D_MT_R0[aa][0] * Math.cos(R000.VSOP87D_MT_R0[aa][1] + R000.VSOP87D_MT_R0[aa][2] * tau)
            aa++
        }

        //r1 = 292 Terms
        var bb = 0
        var R001sum = 0.0
        while (bb < 292) {
            R001sum += R001.VSOP87D_MT_R1[bb][0] * Math.cos(R001.VSOP87D_MT_R1[bb][1] + R001.VSOP87D_MT_R1[bb][2] * tau)
            bb++
        }

        //r2 = 139 Terms
        var cc = 0
        var R002sum = 0.0
        while (cc < 139) {
            R002sum += R002.VSOP87D_MT_R2[cc][0] * Math.cos(R002.VSOP87D_MT_R2[cc][1] + R002.VSOP87D_MT_R2[cc][2] * tau)
            cc++
        }

        //r3 = 27 Terms
        var dd = 0
        var R003sum = 0.0
        while (dd < 27) {
            R003sum += R003.VSOP87D_MT_R3[dd][0] * Math.cos(R003.VSOP87D_MT_R3[dd][1] + R003.VSOP87D_MT_R3[dd][2] * tau)
            dd++
        }

        //r4 = 10
        var ee = 0
        var R004sum = 0.0
        while (ee < 10) {
            R004sum += R004.VSOP87D_MT_R4[ee][0] * Math.cos(R004.VSOP87D_MT_R4[ee][1] + R004.VSOP87D_MT_R4[ee][2] * tau)
            ee++
        }

        //r5 = 3 Terms
        var ff = 0
        var R005sum = 0.0
        while (ff < 3) {
            R005sum += R005.VSOP87D_MT_R5[ff][0] * Math.cos(R005.VSOP87D_MT_R5[ff][1] + R005.VSOP87D_MT_R5[ff][2] * tau)
            ff++
        }

        val r =
            (R000sum + R001sum * tau + R002sum * Math.pow(tau, 2.0) + R003sum * Math.pow(tau, 3.0) + R004sum * Math.pow(
                tau,
                4.0
            ) + +R005sum * Math.pow(tau, 5.0))
        return r
    }

    //DATA-DATA MATAHARI
    fun sunAberration(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val tau: Double = jd.JM(t)

        // 3548.193 untuk Δλ from mean equinox of J2000.0 , dipergunakan misal bila menghitung menggunakan VSOP87B
        // 3548.330 untuk Δλ from mean equinox of the date, dipergunakan misal bila menghitung menggunakan VSOP87D
        val dL = 3548.330 +
                118.568 * Math.sin(mf.Rad(87.5287 + 359993.7286 * tau)) +
                2.476 * Math.sin(mf.Rad(85.0561 + 719987.4571 * tau)) +
                1.376 * Math.sin(mf.Rad(27.8502 + 4452671.1152 * tau)) +
                0.119 * Math.sin(mf.Rad(73.1375 + 450368.8564 * tau)) +
                0.114 * Math.sin(mf.Rad(337.2264 + 329644.6718 * tau)) +
                0.086 * Math.sin(mf.Rad(222.5400 + 659289.3436 * tau)) +
                0.078 * Math.sin(mf.Rad(162.8136 + 9224659.7915 * tau)) +
                0.054 * Math.sin(mf.Rad(82.5823 + 1079981.1857 * tau)) +
                0.052 * Math.sin(mf.Rad(171.5189 + 225184.4282 * tau)) +
                0.034 * Math.sin(mf.Rad(30.3214 + 4092677.3866 * tau)) +
                0.033 * Math.sin(mf.Rad(119.8105 + 337181.4711 * tau)) +
                0.023 * Math.sin(mf.Rad(247.5418 + 299295.6151 * tau)) +
                0.023 * Math.sin(mf.Rad(325.1526 + 315559.5560 * tau)) +
                0.021 * Math.sin(mf.Rad(155.1241 + 675553.2846 * tau)) +
                7.311 * tau * Math.sin(mf.Rad(333.4515 + 359993.7286 * tau)) +
                0.305 * tau * Math.sin(mf.Rad(330.9814 + 719987.4571 * tau)) +
                0.010 * tau * Math.sin(mf.Rad(328.5170 + 1079981.1857 * tau)) +
                0.309 * tau * tau * Math.sin(mf.Rad(241.4518 + 359993.7286 * tau)) +
                0.021 * tau * tau * Math.sin(mf.Rad(205.0482 + 719987.4571 * tau)) +
                0.004 * tau * tau * Math.sin(mf.Rad(297.8610 + 4452671.1152 * tau)) +
                0.010 * tau * tau * tau * Math.sin(mf.Rad(154.7066 + 359993.7286 * tau))

        val r = sunGeocentricDistance(JD, deltaT, "AU")
        val abr = -0.005775518 * r * dL  // ! Hasil dalam satuan arcseconds.
        //   Sebelum dimasukkan ke fungsi DDDMS harus diubah ke degrees dulu dengan dibagi 3600!
        return abr
    }

    fun sunGeocentricLongitude(
        JD: Double,
        deltaT: Double = 0.0,
        optional: String
    ): Double {
        val l: Double = earthHeliocentricLongitude(JD, deltaT)
        val b: Double = earthHeliocentricLatitude(JD, deltaT)
        val theta: Double = mf.Mod(l + 180.0, 360.0)
        val beta: Double = -b

        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)

        val lmbdP: Double = mf.Mod(theta - 1.397 * t - 0.00031 * t * t, 360.0)
        val dltTh: Double = (-0.09033 + 0.03916 * (Math.cos(mf.Rad(lmbdP)) +
                Math.sin(mf.Rad(lmbdP))) * Math.tan(mf.Rad(beta))) / 3600.0
        val thtaFK5: Double = theta + dltTh

        val dltPsi: Double = nt.nutationInLongitude(JD, deltaT)
        val aberr: Double = sunAberration(JD, deltaT) / 3600.0
        val lambd: Double = mf.Mod(thtaFK5 + dltPsi + aberr, 360.0)

        val sunGeoLon = when (optional) {
            "True" -> thtaFK5
            "Appa" -> lambd
            else -> lambd
        }
        return sunGeoLon
    }

    fun sunGeocentricLatitude(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val l: Double = earthHeliocentricLongitude(JD, deltaT)
        val b: Double = earthHeliocentricLatitude(JD, deltaT)
        val theta: Double = mf.Mod(l + 180.0, 360.0)
        val beta: Double = -b

        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JCE(jde)

        val lambdP: Double = theta - 1.397 * t - 0.00031 * t * t
        val dltBta: Double = (0.03916 * (Math.cos(mf.Rad(lambdP)) - Math.sin(mf.Rad(lambdP)))) / 3600.0
        val btaFK5: Double = beta + dltBta
        return btaFK5
    }

    fun sunGeocentricRightAscension(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val lambda: Double = sunGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = sunGeocentricLatitude(JD, deltaT)
        val epsilon: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val alpaFK5: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    Math.sin(mf.Rad(lambda)) * Math.cos(mf.Rad(epsilon)) - Math.tan(mf.Rad(beta)) * Math.sin(
                        mf.Rad(
                            epsilon
                        )
                    ), Math.cos(mf.Rad(lambda))
                )
            ), 360.0
        )
        return alpaFK5
    }

    fun sunGeocentricDeclination(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val lambda: Double = sunGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = sunGeocentricLatitude(JD, deltaT)
        val epsilon: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val dltaFK5: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(beta)) * Math.cos(mf.Rad(epsilon)) + Math.cos(mf.Rad(beta)) * Math.sin(
                    mf.Rad(epsilon)
                ) * Math.sin(mf.Rad(lambda))
            )
        )
        return dltaFK5
    }

    fun greenwichMeanSiderialTime(
        JD: Double
    ): Double {
        val t: Double = jd.JC(JD)
        val gmst: Double = mf.Mod(
            280.46061837 + 360.98564736629 * (JD - 2451545.0) +
                    0.000387933 * Math.pow(t, 2.0) - (Math.pow(t, 3.0) / 38710000), 360.0
        )
        return gmst
    }

    fun greenwichApparentSiderialTime(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val gmst: Double = greenwichMeanSiderialTime(JD)
        val dPsi: Double = nt.nutationInLongitude(JD, deltaT)
        val eps: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val gast: Double = mf.Mod(gmst + dPsi * Math.cos(mf.Rad(eps)), 360.0)
        return gast
    }

    fun localApparentSiderialTime(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double
    ): Double {
        val gast: Double = greenwichApparentSiderialTime(JD, deltaT)
        val last: Double = mf.Mod(gast + gLon, 360.0)
        return last
    }

    fun sunGeocentricGreenwichHourAngle(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val gast: Double = greenwichApparentSiderialTime(JD, deltaT)
        val alpha: Double = sunGeocentricRightAscension(JD, deltaT)
        val gha: Double = mf.Mod(gast - alpha, 360.0)
        return gha
    }

    fun sunGeocentricLocalHourAngel(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double
    ): Double {
        val gast: Double = greenwichApparentSiderialTime(JD, deltaT)
        val alpha: Double = sunGeocentricRightAscension(JD, deltaT)
        val lhaFK5: Double = mf.Mod(gast + gLon - alpha, 360.0)
        return lhaFK5
    }

    fun sunGeocentricAzimuth(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val lha: Double = sunGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = sunGeocentricDeclination(JD, deltaT)
        val azm: Double = mf.Mod(
            (mf.Deg(
                Math.atan2(
                    Math.sin(mf.Rad(lha)),
                    Math.cos(mf.Rad(lha)) * Math.sin(mf.Rad(gLat)) - Math.tan(mf.Rad(dec)) * Math.cos(mf.Rad(gLat))
                )
            )) + 180.0, 360.0
        )
        return azm
    }

    fun sunGeocentricAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val lha: Double = sunGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = sunGeocentricDeclination(JD, deltaT)
        val alt: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(dec)) +
                        Math.cos(mf.Rad(gLat)) * Math.cos(mf.Rad(dec)) * Math.cos(mf.Rad(lha))
            )
        )
        return alt
    }

    fun sunGeocentricDistance(
        JD: Double,
        deltaT: Double = 0.0,
        optional: String = "AU"
    ): Double {
        val r: Double = earthRadiusVector(JD, deltaT)
        val rAU: Double = r
        val rKM: Double = r * 149597870.7
        val rER: Double = r * 149597870.7 / 6371

        val D: Double = when (optional) {
            "AU" -> rAU
            "KM" -> rKM
            "ER" -> rER
            else -> rAU
        }
        return D
    }

    fun sunGeocentricSemidiameter(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val r: Double = earthRadiusVector(JD, deltaT)
        val s0: Double = 15 + 59.63 / 60
        val s: Double = (s0 / r) / 60.0
        return s
    }

    fun sunEquatorialHorizontalParallax(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val er: Double = earthRadiusVector(JD, deltaT)
        val phi: Double = 8.794 / (er * 3600)
        return phi
    }

    fun termU(
        gLat: Double
    ): Double {
        val u: Double = Math.atan(0.99664719 * Math.tan(mf.Rad(gLat)))
        return u
    }

    fun termX(
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val u: Double = termU(gLat)
        val x: Double = Math.cos(u) + (elev / 6378140.0) * Math.cos(mf.Rad(gLat))
        return x
    }

    fun termY(
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val u: Double = termU(gLat)
        val y: Double = 0.99664719 * Math.sin(u) + (elev / 6378140.0) * Math.sin(mf.Rad(gLat))
        return y
    }

    fun termN(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lambda: Double = sunGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = sunGeocentricLatitude(JD, deltaT)
        val theta: Double = localApparentSiderialTime(JD, deltaT, gLon)
        val x: Double = termX(gLat, elev)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val n: Double =
            Math.cos(mf.Rad(lambda)) * Math.cos(mf.Rad(beta)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(theta))
        return n
    }

    fun parallaxInTheSunRightAscension(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val x: Double = termX(gLat, elev)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val ha: Double = sunGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = sunGeocentricDeclination(JD, deltaT)
        val dAlpha: Double = mf.Deg(
            Math.atan2(
                -x * Math.sin(mf.Rad(phi)) * Math.sin(mf.Rad(ha)),
                Math.cos(mf.Rad(dec)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(ha))
            )
        )
        return dAlpha
    }

    fun parallaxInTheSunAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val h: Double = sunGeocentricAltitude(JD, deltaT, gLon, gLat)
        val y: Double = termY(gLat, elev)
        val x: Double = termX(gLat, elev)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val P: Double = mf.Deg(Math.asin((Math.sqrt(y * y + x * x)) * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(h))))
        return P
    }

    fun atmosphericRefractionFromAirlessAltitude(
        airlessAltitude: Double,
        pressure: Double = 1010.0,
        temperature: Double = 10.0
    ): Double {
        val h: Double = airlessAltitude
        val P: Double = pressure
        val t: Double = temperature
        return (1.02 / Math.tan(mf.Rad(h + 10.3 / (h + 5.11))) *
                P / 1010.0 * 283.0 / (273.0 + t) +
                0.0019279204034639303) / 60.0
    }

    fun sunTopocentricLongitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lambda: Double = sunGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = sunGeocentricLatitude(JD, deltaT)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val theta: Double = localApparentSiderialTime(JD, deltaT, gLon)
        val eps: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val x: Double = termX(gLat, elev)
        val y: Double = termY(gLat, elev)
        val n: Double = termN(JD, deltaT, gLon, gLat, elev)
        val lmbdP: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    (Math.sin(mf.Rad(lambda)) * Math.cos(mf.Rad(beta)) - Math.sin(mf.Rad(phi)) * (y * Math.sin(
                        mf.Rad(
                            eps
                        )
                    ) + x * Math.cos(mf.Rad(eps)) * Math.sin(mf.Rad(theta)))), n
                )
            ), 360.0
        )
        return lmbdP
    }

    fun sunTopocentricLatitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lmbdP: Double = sunTopocentricLongitude(JD, deltaT, gLon, gLat, elev)
        val beta: Double = sunGeocentricLatitude(JD, deltaT)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val theta: Double = localApparentSiderialTime(JD, deltaT, gLon)
        val eps: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val x: Double = termX(gLat, elev)
        val y: Double = termY(gLat, elev)
        val n: Double = termN(JD, deltaT, gLon, gLat, elev)
        val btaP: Double = mf.Deg(
            Math.atan(
                Math.cos(mf.Rad(lmbdP)) * (Math.sin(mf.Rad(beta)) - Math.sin(mf.Rad(phi)) * (y * Math.cos(mf.Rad(eps)) -
                        x * Math.sin(mf.Rad(eps)) * Math.sin(mf.Rad(theta)))) / n
            )
        )
        return btaP
    }

    fun sunTopocentricRightAscension(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val alpha: Double = sunGeocentricRightAscension(JD, deltaT)
        val dAlpha: Double = parallaxInTheSunRightAscension(JD, deltaT, gLon, gLat, elev)
        val AlphP: Double = alpha + dAlpha
        return AlphP
    }

    fun sunTopocentricDeclination(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val dec: Double = sunGeocentricDeclination(JD, deltaT)
        val y: Double = termY(gLat, elev)
        val x: Double = termX(gLat, elev)
        val phi: Double = sunEquatorialHorizontalParallax(JD, deltaT)
        val dAlph: Double = parallaxInTheSunRightAscension(JD, deltaT, gLon, gLat, elev)
        val ha: Double = sunGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dltP: Double = mf.Deg(
            Math.atan2(
                (Math.sin(mf.Rad(dec)) - y * Math.sin(mf.Rad(phi))) * Math.cos(mf.Rad(dAlph)),
                Math.cos(mf.Rad(dec)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(ha))
            )
        )
        return dltP
    }

    fun sunTopocentricGreenwichHourAngle(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val gast: Double = greenwichApparentSiderialTime(JD, deltaT)
        val alpha: Double = sunTopocentricRightAscension(JD, deltaT, gLon, gLat)
        val gha: Double = mf.Mod(gast - alpha, 360.0)
        return gha
    }

    fun sunTopocentricLocalHourAngel(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lha: Double = sunGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dAlph: Double = parallaxInTheSunRightAscension(JD, deltaT, gLon, gLat, elev)
        val lhaP: Double = lha - dAlph
        return lhaP
    }

    fun sunTopocentricAzimuth(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lhaP: Double = sunTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev)
        val dltP: Double = sunTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val azmP: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    Math.sin(mf.Rad(lhaP)),
                    Math.cos(mf.Rad(lhaP)) * Math.sin(mf.Rad(gLat)) - Math.tan(mf.Rad(dltP)) * Math.cos(mf.Rad(gLat))
                )
            ) + 180.0, 360.0
        )
        return azmP
    }

    fun sunTopocentricAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0,
        pressure: Double = 1010.0,
        temperature: Double = 10.0,
        optional: String
    ): Double {
        val dec: Double = sunTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val lha: Double = sunTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev)
        val h: Double = sunGeocentricAltitude(JD, deltaT, gLon, gLat)
        val Rfr: Double = atmosphericRefractionFromAirlessAltitude(h, pressure, temperature)
        val Dip: Double = 1.75 / 60 * Math.sqrt(elev)
        val ht: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(dec)) +
                        Math.cos(mf.Rad(gLat)) * Math.cos(mf.Rad(dec)) * Math.cos(mf.Rad(lha))
            )
        ) // Airles Topo Altitude
        val hta: Double = ht + Rfr    // Apparent Topo Altitude
        val hto: Double = hta + Dip   // Observered Topo Altitude

        val alt: Double = when (optional) {
            "ht" -> ht
            "hta" -> hta
            "hto" -> hto
            else -> ht
        }
        return alt
    }

    fun sunTopocentricSemidiameter(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {

        val lmbdP: Double = sunTopocentricLongitude(JD, deltaT, gLon, gLat, elev)
        val betaP: Double = sunTopocentricLatitude(JD, deltaT, gLon, gLat, elev)
        val s: Double = sunGeocentricSemidiameter(JD, deltaT)
        val n: Double = termN(JD, deltaT, gLon, gLat, elev)
        val sP: Double = mf.Deg(Math.asin(Math.cos(mf.Rad(lmbdP)) * Math.cos(mf.Rad(betaP)) * Math.sin(mf.Rad(s)) / n))
        return sP
    }

    fun equationOfTime(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val jde: Double = JD + deltaT / 86400.0
        val t: Double = jd.JC(jde)
        val tau: Double = jd.JM(t)

        val alpha: Double = sunGeocentricRightAscension(JD, deltaT)
        val dPsi: Double = nt.nutationInLongitude(JD, deltaT)
        val epsln: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val lo: Double = mf.Mod(
            280.4664567 + 360007.6982779 * tau +
                    0.03032028 * Math.pow(tau, 2.0) +
                    Math.pow(tau, 3.0) / 49931 -
                    Math.pow(tau, 4.0) / 15300 -
                    Math.pow(tau, 5.0) / 2000000, 360.0
        )
        var e: Double = lo - 0.0057183 - alpha + dPsi * Math.cos(mf.Rad(epsln))

        e = if (Math.abs(e) * 4 < 20) {
            e / 15
        } else if ((Math.abs(e) * 4 >= 20) and (e > 0)) {
            e / 15 - 24
        } else if ((Math.abs(e) * 4 >= 20) and (e < 0)) {
            e / 15 + 24
        } else {
            e / 15
        }
        return e
    }

    fun jdGhurubSyams(
        jdNM: Double,
        gLat: Double,
        gLon: Double,
        elev: Double,
        TmZn: Double
    ): Double {
        var haS: Double
        var kwd: Double
        var jSunSet = 17.0
        val cJDN = Math.floor(jdNM + 0.5 + (TmZn / 24.0))
        for (i in 1..3) {
            var jdGS: Double = cJDN - 0.5 + (jSunSet - TmZn) / 24.0
            var jdeGS: Double = jdGS + dt.DeltaT(jdGS) / 86400.0
            var dltS: Double = sunGeocentricDeclination(jdeGS)
            var sdS: Double = sunGeocentricSemidiameter(jdeGS)
            var eoT: Double = equationOfTime(jdeGS)
            var rfS: Double = 34.16 / 60.0
            var dip: Double = 2.1 * Math.sqrt(elev) / 60.0
            var altS: Double = 0 - sdS - rfS - dip + 0.0024
            var coshaS: Double =
                (Math.sin(mf.Rad(altS)) - Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(dltS))) / (Math.cos(mf.Rad(gLat)) * Math.cos(
                    mf.Rad(dltS)
                ))
            if (Math.abs(coshaS) < 1) {
                haS = mf.Deg(Math.acos(coshaS))
                kwd = gLon / 15.0 - TmZn
                jSunSet = haS / 15.0 + 12.0 - eoT - kwd
            } else {
                jSunSet = Double.NaN
            }
        }
        val jdGS = cJDN - 0.5 + (jSunSet - TmZn) / 24.0
        return jdGS
    }
}
