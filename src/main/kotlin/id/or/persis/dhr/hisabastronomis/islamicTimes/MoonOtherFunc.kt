package id.or.persis.dhr.hisabastronomis.islamicTimes

class MoonOtherFunc {
    val ml = MoonLongitude()
    val mb = MoonLatitude()
    val md = MoonDistance()
    val mf = MathFunction()
    val sn = SunDatas()
    val nt = NutationAndObliquity()
    val jd = JulianDay()
    val dt = DynamicalTime()

    fun moonGeocentricRightAscension(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val lmbd: Double = ml.moonGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = mb.moonGeocentricLatitude(JD, deltaT)
        val epsln: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val alpha: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    Math.sin(mf.Rad(lmbd)) * Math.cos(mf.Rad(epsln)) -
                            Math.tan(mf.Rad(beta)) * Math.sin(mf.Rad(epsln)), Math.cos(mf.Rad(lmbd))
                )
            ), 360.0
        )
        return alpha
    }

    fun moonGeocentricDeclination(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val lmbd: Double = ml.moonGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = mb.moonGeocentricLatitude(JD, deltaT)
        val epsln: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val delta: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(beta)) * Math.cos(mf.Rad(epsln)) +
                        Math.cos(mf.Rad(beta)) * Math.sin(mf.Rad(epsln)) * Math.sin(mf.Rad(lmbd))
            )
        )
        return delta
    }

    fun moonGeocentricGreenwichHourAngle(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val gast = sn.greenwichApparentSiderialTime(JD, deltaT)
        val alpha = moonGeocentricRightAscension(JD, deltaT)
        val gha = mf.Mod(gast - alpha, 360.0)
        return gha
    }

    fun moonGeocentricLocalHourAngel(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double
    ): Double {
        val gast: Double = sn.greenwichApparentSiderialTime(JD, deltaT)
        val alpha: Double = moonGeocentricRightAscension(JD, deltaT)
        val lhaFK5: Double = mf.Mod(gast + gLon - alpha, 360.0)
        return lhaFK5
    }

    fun moonGeocentricAzimuth(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val lha: Double = moonGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = moonGeocentricDeclination(JD, deltaT)
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

    fun moonGeocentricAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val lha: Double = moonGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = moonGeocentricDeclination(JD, deltaT)
        val alt: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(dec)) +
                        Math.cos(mf.Rad(gLat)) * Math.cos(mf.Rad(dec)) * Math.cos(mf.Rad(lha))
            )
        )
        return alt
    }

    fun moonEquatorialHorizontalParallax(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val r: Double = md.moonGeocentricDistance(JD, deltaT, "KM")
        val phi: Double = mf.Deg(Math.asin(6378.14 / r))
        return phi
    }

    fun moonGeocentricSemidiameter(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val k = 0.272481
        val pi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val s: Double = mf.Deg(Math.asin(k * Math.sin(mf.Rad(pi))))
        return s
    }

    fun moonSunGeocentricElongation(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val deltaSun: Double = sn.sunGeocentricDeclination(JD, deltaT)
        val alphaSun: Double = sn.sunGeocentricRightAscension(JD, deltaT)
        val deltaMoon: Double = moonGeocentricDeclination(JD, deltaT)
        val alphaMoon: Double = moonGeocentricRightAscension(JD, deltaT)

        val d: Double = mf.Deg(
            Math.acos(
                Math.sin(mf.Rad(deltaSun)) * Math.sin(mf.Rad(deltaMoon)) +
                        Math.cos(mf.Rad(deltaSun)) * Math.cos(mf.Rad(deltaMoon)) * Math.cos(mf.Rad(alphaSun - alphaMoon))
            )
        )
        return d
    }

    fun moonGeocentricPhaseAngle(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val rSun: Double = sn.sunGeocentricDistance(JD, deltaT, "KM")
        val rMoon: Double = md.moonGeocentricDistance(JD, deltaT, "KM")
        val d: Double = moonSunGeocentricElongation(JD, deltaT)
        val i: Double = mf.Deg(Math.atan2(rSun * Math.sin(mf.Rad(d)), rMoon - rSun * Math.cos(mf.Rad(d))))
        return i
    }

    fun moonGeocentricDiskIlluminatedFraction(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val rSun: Double = sn.sunGeocentricDistance(JD, deltaT, "KM")
        val rMoon: Double = md.moonGeocentricDistance(JD, deltaT, "KM")
        val d: Double = moonSunGeocentricElongation(JD, deltaT)
        val i: Double = mf.Deg(Math.atan2(rSun * Math.sin(mf.Rad(d)), rMoon - rSun * Math.cos(mf.Rad(d))))
        val k: Double = ((1 + Math.cos(mf.Rad(i))) / 2) * 100.0
        return k
    }

    fun moonGeocentricBrightLimbAngle(
        JD: Double,
        deltaT: Double = 0.0
    ): Double {
        val deltaSun: Double = sn.sunGeocentricDeclination(JD, deltaT)
        val alphaSun: Double = sn.sunGeocentricRightAscension(JD, deltaT)
        val deltaMoon: Double = moonGeocentricDeclination(JD, deltaT)
        val alphaMoon: Double = moonGeocentricRightAscension(JD, deltaT)
        val x: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    Math.cos(mf.Rad(deltaSun)) * Math.sin(mf.Rad(alphaSun - alphaMoon)),
                    Math.sin(mf.Rad(deltaSun)) * Math.cos(mf.Rad(deltaMoon)) - Math.cos(mf.Rad(deltaSun)) *
                            Math.sin(mf.Rad(deltaMoon)) * Math.cos(mf.Rad(alphaSun - alphaMoon))
                )
            ), 360.0
        )
        return x
    }

    fun term_N(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lambda: Double = ml.moonGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = mb.moonGeocentricLatitude(JD, deltaT)
        val thta: Double = sn.localApparentSiderialTime(JD, deltaT, gLon)
        val x: Double = sn.termX(gLat, elev)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val n: Double =
            Math.cos(mf.Rad(lambda)) * Math.cos(mf.Rad(beta)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(thta))
        return n
    }

    fun parallaxInTheMoonRightAscension(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val x: Double = sn.termX(gLat, elev)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val ha: Double = moonGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dec: Double = moonGeocentricDeclination(JD, deltaT)
        val dAlpha: Double = mf.Deg(
            Math.atan2(
                -x * Math.sin(mf.Rad(phi)) * Math.sin(mf.Rad(ha)),
                Math.cos(mf.Rad(dec)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(ha))
            )
        )
        return dAlpha
    }

    fun atmosphericRefractionFromApparentAltitude(
        apparentAltitude: Double,
        pressure: Double = 1010.0,
        temperature: Double = 10.0
    ): Double {
        val h: Double = apparentAltitude
        val P: Double = pressure
        val T: Double = temperature
        return (1.0 / Math.tan(mf.Rad(h + 7.31 / (h + 4.4))) *
                P / 1010.0 * 283.0 / (273.0 + T) +
                0.0013515216737560731) / 60.0
    }

    fun parallaxInTheMoonAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val h: Double = moonGeocentricAltitude(JD, deltaT, gLon, gLat)
        val y: Double = sn.termY(gLat, elev)
        val x: Double = sn.termX(gLat, elev)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val par = mf.Deg(Math.asin((Math.sqrt(y * y + x * x)) * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(h))))
        return par
    }

    fun moonTopocentricLongitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lmbd: Double = ml.moonGeocentricLongitude(JD, deltaT, "Appa")
        val beta: Double = mb.moonGeocentricLatitude(JD, deltaT)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val thta: Double = sn.localApparentSiderialTime(JD, deltaT, gLon)
        val Eps: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val x: Double = sn.termX(gLat, elev)
        val y: Double = sn.termY(gLat, elev)
        val n: Double = term_N(JD, deltaT, gLon, gLat, elev)
        val lmbdP: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    (Math.sin(mf.Rad(lmbd)) * Math.cos(mf.Rad(beta)) - Math.sin(mf.Rad(phi)) * (y * Math.sin(mf.Rad(Eps)) + x * Math.cos(
                        mf.Rad(Eps)
                    ) * Math.sin(mf.Rad(thta)))), n
                )
            ), 360.0
        )
        return lmbdP
    }

    fun moonTopocentricLatitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lmbdP: Double = moonTopocentricLongitude(JD, deltaT, gLon, gLat, elev)
        val beta: Double = mb.moonGeocentricLatitude(JD, deltaT)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val thta: Double = sn.localApparentSiderialTime(JD, deltaT, gLon)
        val Eps: Double = nt.trueObliquityOfEcliptic(JD, deltaT)
        val x: Double = sn.termX(gLat, elev)
        val y: Double = sn.termY(gLat, elev)
        val n: Double = term_N(JD, deltaT, gLon, gLat, elev)
        val betaP: Double = mf.Deg(
            Math.atan(
                Math.cos(mf.Rad(lmbdP)) * (Math.sin(mf.Rad(beta)) - Math.sin(mf.Rad(phi)) * (y * Math.cos(mf.Rad(Eps)) -
                        x * Math.sin(mf.Rad(Eps)) * Math.sin(mf.Rad(thta)))) / n
            )
        )
        return betaP
    }

    fun moonTopocentricRightAscension(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val alpha: Double = moonGeocentricRightAscension(JD, deltaT)
        val dAlph: Double = parallaxInTheMoonRightAscension(JD, deltaT, gLon, gLat, elev)
        val alphP: Double = alpha + dAlph
        return alphP
    }

    fun moonTopocentricDeclination(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val dec: Double = moonGeocentricDeclination(JD, deltaT)
        val y: Double = sn.termY(gLat, elev)
        val x: Double = sn.termX(gLat, elev)
        val phi: Double = moonEquatorialHorizontalParallax(JD, deltaT)
        val dAlph: Double = parallaxInTheMoonRightAscension(JD, deltaT, gLon, gLat, elev)
        val ha: Double = moonGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dltaP: Double = mf.Deg(
            Math.atan2(
                (Math.sin(mf.Rad(dec)) - y * Math.sin(mf.Rad(phi))) * Math.cos(mf.Rad(dAlph)),
                Math.cos(mf.Rad(dec)) - x * Math.sin(mf.Rad(phi)) * Math.cos(mf.Rad(ha))
            )
        )
        return dltaP
    }

    fun moonTopocentricGreenwichHourAngle(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double
    ): Double {
        val gast: Double = sn.greenwichApparentSiderialTime(JD, deltaT)
        val alph: Double = moonTopocentricRightAscension(JD, deltaT, gLon, gLat)
        val gha: Double = mf.Mod(gast - alph, 360.0)
        return gha
    }

    fun moonTopocentricLocalHourAngel(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lha: Double = moonGeocentricLocalHourAngel(JD, deltaT, gLon)
        val dAlph: Double = parallaxInTheMoonRightAscension(JD, deltaT, gLon, gLat, elev)
        val lhaP: Double = lha - dAlph
        return lhaP
    }

    fun moonTopocentricAzimuth(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lhaP: Double = moonTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev)
        val dltP: Double = moonTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
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

    fun moonTopocentricAltitude(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0,
        pressure: Double = 1010.0,
        temperature: Double = 10.0,
        opt: String
    ): Double {
        val dec: Double = moonTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val lHA: Double = moonTopocentricLocalHourAngel(JD, deltaT, gLon, gLat, elev)
        val htc: Double = mf.Deg(
            Math.asin(
                Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(dec)) + Math.cos(mf.Rad(gLat)) * Math.cos(
                    mf.Rad(dec)
                ) * Math.cos(mf.Rad(lHA))
            )
        )
        val Dip: Double = 1.75 / 60 * Math.sqrt(elev)
        val sdc: Double = moonTopocentricSemidiameter(JD, deltaT, gLon, gLat, elev)
        val Rhtc: Double = sn.atmosphericRefractionFromAirlessAltitude(htc, pressure, temperature)
        val htac: Double = htc + Rhtc
        val htoc: Double = htac + Dip
        val htu: Double = htc + sdc
        val Rhtu: Double = sn.atmosphericRefractionFromAirlessAltitude(htu, pressure, temperature)
        val htau: Double = htu + Rhtu
        val htou: Double = htau + Dip
        val htl: Double = htc - sdc
        val Rhtl: Double = sn.atmosphericRefractionFromAirlessAltitude(htl, pressure, temperature)
        val htal: Double = htl + Rhtl
        val htol: Double = htal + Dip

        val ht = when (opt) {
            "htc" -> htc
            "htac" -> htac
            "htoc" -> htoc
            "htu" -> htu
            "htau" -> htau
            "htou" -> htou
            "htl" -> htl
            "htal" -> htal
            "htol" -> htol
            "Rhtc" -> Rhtc
            "Rhtu" -> Rhtu
            "Rhtl" -> Rhtl
            "Dip" -> Dip
            else -> htc
        }
        return ht
    }
    //Keterangan:
    //htc  = Airless topocentric altitude of The Moon’s Center Limb
    //htac = Apparent topocentric altitude of The Moon’s Center Limb
    //htoc = Observed altitude of The Moon’s Center Limb
    //htu  = Airles topocentric altitude of The Moon’s Upper Limb
    //htau = Apparent topocentric altitude of The Moon’s Upper Limb
    //htou = Observed altitude of The Moon’s Upper Limb
    //htl  = Airles topocentric altitude of The Moon’s Lower Limb
    //htal = Apparent topocentric altitude of The Moon’s Lower Limb
    //htol = Observed altitude of The Moon’s Lower Limb

    fun moonTopocentricSemidiameter(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val lmbdP: Double = moonTopocentricLongitude(JD, deltaT, gLon, gLat, elev)
        val betaP: Double = moonTopocentricLatitude(JD, deltaT, gLon, gLat, elev)
        val s: Double = moonGeocentricSemidiameter(JD, deltaT)
        val n: Double = term_N(JD, deltaT, gLon, gLat, elev)
        val sP: Double = mf.Deg(Math.asin(Math.cos(mf.Rad(lmbdP)) * Math.cos(mf.Rad(betaP)) * Math.sin(mf.Rad(s)) / n))
        return sP
    }

    fun moonSunTopocentricElongation(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val dltaS: Double = sn.sunTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val alphS: Double = sn.sunTopocentricRightAscension(JD, deltaT, gLon, gLat, elev)
        val dltaM: Double = moonTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val alphM: Double = moonTopocentricRightAscension(JD, deltaT, gLon, gLat, elev)
        val d: Double = mf.Deg(
            Math.acos(
                Math.sin(mf.Rad(dltaS)) * Math.sin(mf.Rad(dltaM)) +
                        Math.cos(mf.Rad(dltaS)) * Math.cos(mf.Rad(dltaM)) * Math.cos(mf.Rad(alphS - alphM))
            )
        )
        return d
    }

    fun moonTopocentricPhaseAngle(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double
    ): Double {
        val rSn: Double = sn.sunGeocentricDistance(JD, deltaT, "KM")
        val rMn: Double = md.moonGeocentricDistance(JD, deltaT, "KM")
        val d: Double = moonSunTopocentricElongation(JD, deltaT, gLon, gLat, elev)
        val i: Double = mf.Deg(Math.atan2(rSn * Math.sin(mf.Rad(d)), rMn - rSn * Math.cos(mf.Rad(d))))
        return i
    }

    fun moonTopocentricDiskIlluminatedFraction(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val rSn: Double = sn.sunGeocentricDistance(JD, deltaT, "KM")
        val rMn: Double = md.moonGeocentricDistance(JD, deltaT, "KM")
        val d: Double = moonSunTopocentricElongation(JD, deltaT, gLon, gLat, elev)
        val i: Double = mf.Deg(Math.atan2(rSn * Math.sin(mf.Rad(d)), rMn - rSn * Math.cos(mf.Rad(d))))
        val k: Double = ((1 + Math.cos(mf.Rad(i))) / 2) * 100.0
        return k
    }

    fun moonTopocentricBrightLimbAngle(
        JD: Double,
        deltaT: Double = 0.0,
        gLon: Double,
        gLat: Double,
        elev: Double = 0.0
    ): Double {
        val dltaSn: Double = sn.sunTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val alphSn: Double = sn.sunTopocentricRightAscension(JD, deltaT, gLon, gLat, elev)
        val dltaMn: Double = moonTopocentricDeclination(JD, deltaT, gLon, gLat, elev)
        val alphMn: Double = moonTopocentricRightAscension(JD, deltaT, gLon, gLat, elev)
        val x: Double = mf.Mod(
            mf.Deg(
                Math.atan2(
                    Math.cos(mf.Rad(dltaSn)) * Math.sin(mf.Rad(alphSn - alphMn)),
                    Math.sin(mf.Rad(dltaSn)) * Math.cos(mf.Rad(dltaMn)) - Math.cos(mf.Rad(dltaSn)) *
                            Math.sin(mf.Rad(dltaMn)) * Math.cos(mf.Rad(alphSn - alphMn))
                )
            ), 360.0
        )
        return x
    }

    fun moonPhasesModified(
        hijriMonth: Byte,
        hijriYear: Long,
        MoonPhaseKind: Int
    ): Double {
        var k: Double = hijriMonth.toDouble() + 12 * hijriYear.toDouble() - 17050
        val kII: Double = when (MoonPhaseKind) {
            1 -> 0.0
            2 -> 0.25
            3 -> 0.5
            4 -> 0.75
            else -> 0.0
        }
        k = Math.floor(k) + kII

        val t: Double = k / 1236.85

        val jdeMMP: Double = 2451550.09766 + 29.530588861 * k +
                0.00015437 * Math.pow(t, 2.0) -
                0.00000015 * Math.pow(t, 3.0) +
                0.00000000073 * Math.pow(t, 4.0)

        val e: Double = 1 - 0.002516 * t - 0.0000074 * Math.pow(t, 2.0)

        var m: Double = 2.5534 + 29.1053567 * k -
                0.0000014 * Math.pow(t, 2.0) -
                0.00000011 * Math.pow(t, 3.0)
        m = mf.Rad(mf.Mod(m, 360.0))

        var mp: Double = 201.5643 + 385.81693528 * k +
                0.0107582 * Math.pow(t, 2.0) +
                0.00001238 * Math.pow(t, 3.0) -
                0.000000058 * Math.pow(t, 4.0)
        mp = mf.Rad(mf.Mod(mp, 360.0))

        var f: Double = 160.7108 + 390.67050284 * k -
                0.0016118 * Math.pow(t, 2.0) -
                0.00000227 * Math.pow(t, 3.0) +
                0.000000011 * Math.pow(t, 4.0)
        f = mf.Rad(mf.Mod(f, 360.0))

        var Om: Double = 124.7746 - 1.56375588 * k +
                0.0020672 * Math.pow(t, 2.0) +
                0.00000215 * Math.pow(t, 3.0)
        Om = mf.Rad(mf.Mod(Om, 360.0))

        val a1 = mf.Rad(mf.Mod(299.77 + 0.107408 * k - 0.009173 * t * t, 360.0))
        val a2 = mf.Rad(mf.Mod(251.88 + 0.016321 * k, 360.0))
        val a3 = mf.Rad(mf.Mod(251.83 + 26.651886 * k, 360.0))
        val a4 = mf.Rad(mf.Mod(349.42 + 36.412478 * k, 360.0))
        val a5 = mf.Rad(mf.Mod(84.66 + 18.206239 * k, 360.0))
        val a6 = mf.Rad(mf.Mod(141.74 + 53.303771 * k, 360.0))
        val a7 = mf.Rad(mf.Mod(207.14 + 2.453732 * k, 360.0))
        val a8 = mf.Rad(mf.Mod(154.84 + 7.30686 * k, 360.0))
        val a9 = mf.Rad(mf.Mod(34.52 + 27.261239 * k, 360.0))
        val a10 = mf.Rad(mf.Mod(207.19 + 0.121824 * k, 360.0))
        val a11 = mf.Rad(mf.Mod(291.34 + 1.844379 * k, 360.0))
        val a12 = mf.Rad(mf.Mod(161.72 + 24.198154 * k, 360.0))
        val a13 = mf.Rad(mf.Mod(239.56 + 25.513099 * k, 360.0))
        val a14 = mf.Rad(mf.Mod(331.55 + 3.592518 * k, 360.0))

        var jdeCorr1: Double
        when (MoonPhaseKind) {
            1 -> jdeCorr1 = -0.4072 * Math.sin(mp) +
                    0.17241 * e * Math.sin(m) +
                    0.01608 * Math.sin(2 * mp) +
                    0.01039 * Math.sin(2 * f) +
                    0.00739 * e * Math.sin(mp - m) -
                    0.00514 * e * Math.sin(mp + m) +
                    0.00208 * Math.pow(e, 2.0) * Math.sin(2 * m) -
                    0.00111 * Math.sin(mp - 2 * f) -
                    0.00057 * Math.sin(mp + 2 * f) +
                    0.00056 * e * Math.sin(2 * mp + m) -
                    0.00042 * Math.sin(3 * mp) +
                    0.00042 * e * Math.sin(m + 2 * f) +
                    0.00038 * e * Math.sin(m - 2 * f) -
                    0.00024 * e * Math.sin(2 * mp - m) -
                    0.00017 * Math.sin(Om) -
                    0.00007 * Math.sin(mp + 2 * m) +
                    0.00004 * Math.sin(2 * mp - 2 * f) +
                    0.00004 * Math.sin(3 * m) +
                    0.00003 * Math.sin(mp + m - 2 * f) +
                    0.00003 * Math.sin(2 * mp + 2 * f) -
                    0.00003 * Math.sin(mp + m + 2 * f) +
                    0.00003 * Math.sin(mp - m + 2 * f) -
                    0.00002 * Math.sin(mp - m - 2 * f) -
                    0.00002 * Math.sin(3 * mp + m) +
                    0.00002 * Math.sin(4 * mp)

            3 -> jdeCorr1 = -0.40614 * Math.sin(mp) +
                    0.17302 * e * Math.sin(m) +
                    0.01614 * Math.sin(2 * mp) +
                    0.01043 * Math.sin(2 * f) +
                    0.00734 * e * Math.sin(mp - m) -
                    0.00514 * e * Math.sin(mp + m) +
                    0.00209 * Math.pow(e, 2.0) * Math.sin(2 * m) -
                    0.00111 * Math.sin(mp - 2 * f) -
                    0.00057 * Math.sin(mp + 2 * f) +
                    0.00056 * e * Math.sin(2 * mp + m) -
                    0.00042 * Math.sin(3 * mp) +
                    0.00042 * e * Math.sin(m + 2 * f) +
                    0.00038 * e * Math.sin(m - 2 * f) -
                    0.00024 * e * Math.sin(2 * mp - m) -
                    0.00017 * Math.sin(Om) -
                    0.00007 * Math.sin(mp + 2 * m) +
                    0.00004 * Math.sin(2 * mp - 2 * f) +
                    0.00004 * Math.sin(3 * m) +
                    0.00003 * Math.sin(mp + m - 2 * f) +
                    0.00003 * Math.sin(2 * mp + 2 * f) -
                    0.00003 * Math.sin(mp + m + 2 * f) +
                    0.00003 * Math.sin(mp - m + 2 * f) -
                    0.00002 * Math.sin(mp - m - 2 * f) -
                    0.00002 * Math.sin(3 * mp + m) +
                    0.00002 * Math.sin(4 * mp)

            2, 4 -> jdeCorr1 = -0.62801 * Math.sin(mp) +
                    0.17172 * e * Math.sin(m) -
                    0.01183 * e * Math.sin(mp + m) +
                    0.00862 * Math.sin(2 * mp) +
                    0.00804 * Math.sin(2 * f) +
                    0.00454 * e * Math.sin(mp - m) +
                    0.00204 * Math.pow(e, 2.0) * Math.sin(2 * m) -
                    0.0018 * Math.sin(mp - 2 * f) -
                    0.0007 * Math.sin(mp + 2 * f) -
                    0.0004 * Math.sin(3 * mp) -
                    0.00034 * e * Math.sin(2 * mp - m) +
                    0.00032 * e * Math.sin(m + 2 * f) +
                    0.00032 * e * Math.sin(m - 2 * f) -
                    0.00028 * Math.pow(e, 2.0) * Math.sin(mp + 2 * m) +
                    0.00027 * e * Math.sin(2 * mp + m) -
                    0.00017 * Math.sin(Om) -
                    0.00005 * Math.sin(mp - m - 2 * f) +
                    0.00004 * Math.sin(2.0 * mp + 2 * f) -
                    0.00004 * Math.sin(mp + m + 2 * f) +
                    0.00004 * Math.sin(mp - 2 * m) +
                    0.00003 * Math.sin(mp + m - 2 * f) +
                    0.00003 * Math.sin(3 * m) +
                    0.00002 * Math.sin(2 * mp - 2 * f) +
                    0.00002 * Math.sin(mp - m + 2 * f) -
                    0.00002 * Math.sin(3 * mp + m)

            else -> jdeCorr1 = 0.0
        }

        jdeCorr1 = if ((MoonPhaseKind == 2) || (MoonPhaseKind == 4)) {
            val w: Double = 0.00306 - 0.00038 * e * Math.cos(m) + 0.00026 * Math.cos(mp) - 0.00002 * Math.cos(mp - m) +
                    0.00002 * Math.cos(mp + m) + 0.00002 * Math.cos(2 * f)
            when (MoonPhaseKind) {
                2 -> jdeCorr1 + w
                4 -> jdeCorr1 - w
                else -> jdeCorr1
            }
        } else {
            jdeCorr1
        }

        val jdeCorr2: Double = 0.000325 * Math.sin(a1) +
                0.000165 * Math.sin(a2) +
                0.000164 * Math.sin(a3) +
                0.000126 * Math.sin(a4) +
                0.00011 * Math.sin(a5) +
                0.000062 * Math.sin(a6) +
                0.00006 * Math.sin(a7) +
                0.000056 * Math.sin(a8) +
                0.000047 * Math.sin(a9) +
                0.000042 * Math.sin(a10) +
                0.00004 * Math.sin(a11) +
                0.000037 * Math.sin(a12) +
                0.000035 * Math.sin(a13) +
                0.000023 * Math.sin(a14)

        val result = jdeMMP + jdeCorr1 + jdeCorr2
        return result
    }

    fun jdeEclipseModified(
        HijriMonth: Byte, HijriYear: Long, EclipseKind: Int
    ): Double {
//        var k       : Double
//        var t       : Double
//        var jdeMMP  : Double
//        var e       : Double
//        var m       : Double
//        var mp      : Double
//        var f       : Double
//        var omg     : Double
//        var f1      : Double
//        var a1      : Double
//        var jdeCorr : Double

        val k: Double = when (EclipseKind) {
            1 -> Math.floor(HijriMonth.toDouble() + 12 * HijriYear.toDouble() - 17048.5) + 0.0
            2 -> Math.floor(HijriMonth.toDouble() + 12 * HijriYear.toDouble() - 17049.5) + 0.5
            else -> Math.floor(HijriMonth.toDouble() + 12 * HijriYear.toDouble() - 17048.5) + 0.0
        }
        val t: Double = k / 1236.85
        val jdeMMP: Double = 2451550.09766 + 29.530588861 * k +
                0.00015437 * t * t -
                0.000000150 * t * t * t +
                0.00000000073 * t * t * t * t
        val e: Double = 1 - 0.002516 * t - 0.0000074 * t * t
        var m: Double = 2.5534 + 29.1053567 * k -
                0.0000014 * t * t -
                0.00000011 * t * t * t
        m = mf.Rad(mf.Mod(m, 360.0))

        var mp: Double = 201.5643 + 385.81693528 * k +
                0.0107582 * t * t +
                0.00001238 * t * t * t -
                0.000000058 * t * t * t * t

        mp = mf.Rad(mf.Mod(mp, 360.0))

        var f: Double = 160.7108 + 390.67050284 * k -
                0.0016118 * t * t -
                0.00000227 * t * t * t +
                0.000000011 * t * t * t * t
        f = mf.Rad(mf.Mod(f, 360.0))

        var omg: Double = 124.7746 - 1.56375588 * k +
                0.0020672 * t * t +
                0.00000215 * t * t * t
        omg = mf.Rad(mf.Mod(omg, 360.0))

        var f1: Double
        var a1: Double
        var jdeCorr: Double

        if (Math.abs(Math.sin(f)) > 0.36) {
            return 0.0
        } else {
            f1 = mf.Deg(f) - 0.02665 * Math.sin(omg)
            f1 = mf.Rad(mf.Mod(f1, 360.0))
            a1 = 299.77 + 0.107408 * k - 0.009173 * t * t
            a1 = mf.Rad(mf.Mod(a1, 360.0))

            jdeCorr = when (EclipseKind) {
                1 -> -0.4075 * Math.sin(mp) +
                        0.1721 * e * Math.sin(m)

                2 -> -0.4065 * Math.sin(mp) +
                        0.1727 * e * Math.sin(m)

                else -> -0.4075 * Math.sin(mp) +
                        0.1721 * e * Math.sin(m)
            }
            jdeCorr = jdeCorr +
                    0.0161 * Math.sin(2 * mp) -
                    0.0097 * Math.sin(2 * f1) +
                    0.0073 * e * Math.sin(mp - m) -
                    0.0050 * e * Math.sin(mp + m) -
                    0.0023 * Math.sin(mp - 2 * f1) +
                    0.0021 * e * Math.sin(2 * m) +
                    0.0012 * Math.sin(mp + 2 * f1) +
                    0.0006 * e * Math.sin(2 * mp + m) -
                    0.0004 * Math.sin(3 * mp) -
                    0.0003 * e * Math.sin(m + 2 * f1) +
                    0.0003 * Math.sin(a1) -
                    0.0002 * e * Math.sin(m - 2 * f1) -
                    0.0002 * e * Math.sin(2 * mp - m) -
                    0.0002 * Math.sin(omg)

            return jdeMMP + jdeCorr

        }
    }

    fun geocentricConjunction(
        hijriMonth: Byte,
        hijriYear: Long,
        deltaT: Double,
        optR: String
    ): Double {
        var jdNMGeo = 0.0
        val jdNM: Double = moonPhasesModified(hijriMonth, hijriYear, 1)

        val x1: Double = jdNM - 1 / 24.0
        val x2: Double = jdNM
        val x3: Double = jdNM + 1 / 24.0

        val y1: Double = sn.sunGeocentricLongitude(x1, deltaT, "appa") - ml.moonGeocentricLongitude(x1, deltaT, "appa")
        val y2: Double = sn.sunGeocentricLongitude(x2, deltaT, "appa") - ml.moonGeocentricLongitude(x2, deltaT, "appa")
        val y3: Double = sn.sunGeocentricLongitude(x3, deltaT, "appa") - ml.moonGeocentricLongitude(x3, deltaT, "appa")

        val a: Double = y2 - y1
        val b: Double = y3 - y2
        val c: Double = b - a

        var n0 = 0.0

        for (i in 1..2) {
            n0 = -2 * y2 / (a + b + c * n0)
            jdNMGeo = jdNM + n0 / 24.0
        }
        val lonG: Double = sn.sunGeocentricLongitude(jdNMGeo, deltaT, "appa")

        return when (optR) {
            "Ijtima" -> jdNMGeo
            "Bujur" -> lonG
            else -> jdNMGeo
        }
    }

    fun topocentricConjunction(
        hijriMonth: Byte,
        hijriYear: Long,
        deltaT: Double,
        gLon: Double,
        gLat: Double,
        elev: Double,
        optR: String
    ): Double {
        var jdNMTopo = 0.0

        val jdNM: Double = moonPhasesModified(hijriMonth, hijriYear, 1)

        val x1: Double = jdNM - 1 / 24.0
        val x2: Double = jdNM
        val x3: Double = jdNM + 1 / 24.0

        val y1: Double = sn.sunTopocentricLongitude(x1, deltaT, gLon, gLat, elev) - moonTopocentricLongitude(
            x1,
            deltaT,
            gLon,
            gLat,
            elev
        )
        val y2: Double = sn.sunTopocentricLongitude(x2, deltaT, gLon, gLat, elev) - moonTopocentricLongitude(
            x2,
            deltaT,
            gLon,
            gLat,
            elev
        )
        val y3: Double = sn.sunTopocentricLongitude(x3, deltaT, gLon, gLat, elev) - moonTopocentricLongitude(
            x3,
            deltaT,
            gLon,
            gLat,
            elev
        )

        val a: Double = y2 - y1
        val b: Double = y3 - y2
        val c: Double = b - a

        var n0 = 0.0
        n0 = -2 * y2 / (a + b + c * n0)

        for (i in 1..2) {
            n0 = -2 * y2 / (a + b + c * n0)
            jdNMTopo = jdNM + n0 / 24.0
        }

        val lonT = sn.sunTopocentricLongitude(jdNMTopo, deltaT, gLon, gLat, elev)

        return when (optR) {
            "Ijtima" -> jdNMTopo
            "Bujur" -> lonT
            else -> jdNMTopo
        }
    }

    fun moonTransitRiseSet(
        tglM: Byte,
        blnM: Byte,
        thnM: Long,
        gLon: Double,
        gLat: Double,
        elev: Double,
        tmZn: Double,
        trsType: String,
        maxItr: Int
    ): Any {
        var jd00LT: Double
        var jd00UT: Double
        var jde00UT: Double
        var alphaMm1d: Double
        var alphaM00d: Double
        var alphaMp1d: Double
        var deltaMm1d: Double
        var deltaM00d: Double
        var deltaMp1d: Double
        var pi: Double
        var h0: Double
        var cosHA0: Double
        var ha0: Any
        var t: Double
        var theta0: Double
        var m: Double
        var sTheta0: Double = 0.0
        var nT: Double
        var alphaM: Double = 0.0
        var deltaM: Double = 0.0
        var ha: Double
        var h: Double
        var dltm: Double = 0.0
        var jdTRS: Double
        var ttrs: Any = 0.0


        jd00UT = jd.KMJD(tglM, blnM, thnM, tmZn, tmZn) + -1

        for (dItr in 1..3) {
            jde00UT = jd00UT + dt.DeltaT(jd00UT) / 86400.0
            alphaM00d = moonGeocentricRightAscension(jde00UT)
            alphaMm1d = moonGeocentricRightAscension((jde00UT - 1))
            alphaMp1d = moonGeocentricRightAscension((jde00UT + 1))

            if (trsType == "TRANSIT") {
                deltaM00d = 0.0
                deltaMm1d = 0.0
                deltaMp1d = 0.0
            } else {
                deltaM00d = moonGeocentricDeclination(jde00UT)
                deltaMm1d = moonGeocentricDeclination((jde00UT - 1))
                deltaMp1d = moonGeocentricDeclination((jde00UT + 1))
            }

            pi = moonEquatorialHorizontalParallax(jde00UT)

            h0 = -(34 / 60.0) + 0.7275 * pi - 0.0353 * Math.sqrt(elev)
            cosHA0 =
                (Math.sin(mf.Rad(h0)) - Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(deltaM00d))) / (Math.cos(mf.Rad(gLat)) * Math.cos(
                    mf.Rad(deltaM00d)
                ))
            if (Math.abs(cosHA0) <= 1) {
                ha0 = mf.Deg(Math.acos(cosHA0))
            } else {
                ha0 = "!circumpolar"
            }

            t = (jde00UT - 2451545) / 36525.0

            theta0 = (100.46061837) + (36000.770053608 * t) + (0.000387933 * t * t) - (Math.pow(
                t,
                3.0
            ) / 38710000) + (nt.nutationInLongitude(jde00UT, 0.0) * Math.cos(
                mf.Rad(
                    nt.trueObliquityOfEcliptic(
                        jde00UT,
                        0.0
                    )
                )
            ))

            theta0 = mf.Mod(theta0, 360.0)

            m = (alphaM00d - gLon - theta0) / 360.0

            when (trsType) {
                "TRANSIT" -> dltm = -ha / 360.0
                "RISE" -> m = m - ha0.toString().toDouble() / 360.0
                "SET" -> m = m + ha0.toString().toDouble() / 360.0
            }

            m = mf.Mod(m, 1.0)

            for (Itr in 1..maxItr) {
                sTheta0 = theta0 + 360.985647 * m
                sTheta0 = mf.Mod(sTheta0, 360.0)
                nT = m
                alphaM = mf.Mod(
                    alphaM00d + nT / 2.0 * (mf.Mod((alphaM00d - alphaMm1d), 360.0) + mf.Mod(
                        (alphaMp1d - alphaM00d),
                        360.0
                    ) + nT * (mf.Mod((alphaMp1d - alphaM00d), 360.0) - mf.Mod((alphaM00d - alphaMm1d), 360.0))), 360.0
                )

                if (trsType == "TRANSIT") {
                    deltaM = 0.0
                } else {
                    deltaM =
                        deltaM00d + nT / 2.0 * ((deltaM00d - deltaMm1d) + (deltaMp1d - deltaM00d) + nT * ((deltaMp1d - deltaM00d) - (deltaM00d - deltaMm1d)))
                }

                ha = sTheta0 + gLon - alphaM
                if (mf.Mod(ha, 360.0) > 180.0) {
                    ha = mf.Mod(ha, 360.0) - 360.0
                } else {
                    ha = mf.Mod(ha, 360.0)
                }

                h = mf.Deg(
                    Math.asin(
                        Math.sin(mf.Rad(gLat)) * Math.sin(mf.Rad(deltaM)) + Math.cos(mf.Rad(gLat)) * Math.cos(
                            mf.Rad(
                                deltaM
                            )
                        ) * Math.cos(mf.Rad(ha))
                    )
                )

                when (trsType) {
                    "TRANSIT" -> dltm = -ha / 360.0
                    "RISE", "SET" -> dltm =
                        (h - h0) / (360.0 * Math.cos(mf.Rad(deltaM)) * Math.cos(mf.Rad(gLat)) * Math.sin(mf.Rad(ha)))
                }

                m = mf.Mod(m + dltm, 1.0)
            }

            jdTRS = jd00UT + m
            jd00LT = jd.KMJD(tglM, blnM, thnM, 0.0, tmZn)
            ttrs = jd.JDKM(jdTRS, tmZn, "JAMDES")

            if ((jdTRS >= (jd00LT + 0)) && (jdTRS <= (jd00LT + 1))) {
                ttrs = jd.JDKM(jdTRS, tmZn, "JAMDES")
            } else {
                jd00UT = jd00UT + 1
                ttrs = "x"
            }

        }
        return ttrs
    }


}
