package islamicTimes

import java.util.*

class JulianDay {
    //SKALA WAKTU

    val dt = DynamicalTime()

    fun KMJD(
        TglM: Byte,
        BlnM: Byte,
        ThnM: Long,
        JamDes: Double = 0.0,
        TimeZone: Double = 0.0
    ): Double {
        val DD: Double
        val MM: Double
        val YY: Double
        val AA: Double
        val BB: Double
        val JD: Double

        DD = TglM + ((JamDes - TimeZone) / 24.0)
        if (BlnM > 2) {
            MM = BlnM.toDouble()
            YY = ThnM.toDouble()
        } else {
            MM = BlnM.toDouble() + 12
            YY = ThnM.toDouble() - 1
        }
        if ((ThnM.toDouble() + BlnM.toDouble() / 100 + TglM.toDouble() / 10000) >= 1582.1015) {
            AA = Math.floor(YY / 100)
            BB = 2 - AA + Math.floor(AA / 4)
        } else {
            BB = 0.0
        }
        JD = Math.floor(365.25 * (YY + 4716)) + Math.floor(30.6001 * (MM + 1)) + DD + BB - 1524.5
        return JD
    }

    //Konversi Julian Day ke Kalender Masehi
    fun JDKM(
        JD: Double,
        TmZn: Double = 0.0,
        OptResult: String = ""
    ): String {
        val Alpha: Double
        val Beta: Double
        val GC: Double
        val A: Double
        val CJD: Double
        val CJDN: Double
        val FracD: Double
        val JamDes: Double
        val B: Double
        val C: Double
        val D: Double
        val E: Double
        val TglM: Double
        val BlnM: Double
        val ThnM: Double
        val NoHrM: Double
        val NmHrMDt: Any
        val NmHrM: String
        val NmBlnMDt: Any
        val NmBlnM: String
        val ThnMHYNS: String
        val ThnMAYNS: String
        val Result: Any

        CJD = JD + 0.5 + TmZn / 24.0
        CJDN = Math.floor(CJD)
        FracD = CJD - CJDN

        Alpha = Math.floor((CJDN - 1867216.25) / 36524.25)
        Beta = 1 + Alpha - Math.floor(Alpha / 4)

        GC = if (CJDN >= 2299161) {
            Beta
        } else {
            0.0
        }

        A = CJDN + GC
        B = A + 1524
        C = Math.floor((B - 122.1) / 365.25)
        D = Math.floor(365.25 * C)
        E = Math.floor((B - D) / 30.6001)

        TglM = B - D - Math.floor(30.6001 * E)

        BlnM = if (E < 14) {
            E - 1
        } else {
            E - 13
        }

        ThnM = if (BlnM > 2) {
            C - 4716
        } else {
            C - 4715
        }

        JamDes = FracD * 24

// nama Hari
        NoHrM = CJDN - 7 * Math.floor(CJDN / 7)
        NmHrMDt = listOf(
            "Senin", "Selasa", "Rabu", "Kamis",
            "Jum'at", "Sabtu", "Ahad"
        )
        NmHrM = NmHrMDt.get(NoHrM.toInt())

// Nama Bulan
        NmBlnMDt = listOf(
            "Januari", "Februari", "Maret",
            "April", "Mei", "Juni",
            "Juli", "Agustus", "September",
            "Oktober", "November", "Desember"
        )
        NmBlnM = NmBlnMDt.get(BlnM.toInt() - 1)

//Jenis Penomoran tahun antara Historical dan Astronomical
        if (ThnM > 0) {
            ThnMHYNS = NmHrM + ", " + (TglM.toInt()
                .toByte()).toString() + " " + NmBlnM + " " + (ThnM.toLong()).toString() + " M"
            ThnMAYNS = NmHrM + ", " + (TglM.toInt()
                .toByte()).toString() + " " + NmBlnM + " " + "+" + (ThnM.toLong()).toString()
        } else {
            ThnMHYNS = NmHrM + ", " + (TglM.toInt().toByte()).toString() + " " + NmBlnM + " " + (Math.abs(ThnM)
                .toLong() + 1).toString() + " SM"
            ThnMAYNS =
                NmHrM + ", " + (TglM.toInt().toByte()).toString() + " " + NmBlnM + " " + (ThnM.toLong()).toString()
        }
//Kesimpulan
        Result = when ((OptResult.replace(" ", "")).uppercase(Locale.getDefault())) {
            "TGLM", "TGL" -> TglM.toInt()
            "BLNM", "BLN" -> BlnM.toInt()
            "THNM", "THN" -> ThnM.toLong()
            "NMBLNM", "BULAN" -> NmBlnM
            "NMHRM", "HARI", "HR" -> NmHrM
            "THNMHYNS" -> ThnMHYNS
            "THNMAYNS" -> ThnMAYNS
            "JAMDES", "JAMDESIMAL", "JAMD" -> JamDes.toDouble()
            "FRACDAY", "PECAHANHARI" -> FracD

            else -> NmHrM + ", " +
                    (TglM.toInt().toByte()).toString() + " " +
                    NmBlnM + " " +
                    (ThnM.toLong()).toString()
        }

        return Result.toString()
    }

    fun JDE(
        JD: Double,
        DeltaT: Double = 0.0
    ): Double {
        val JD = JD
        val DeltaT = DeltaT
        val JDE = (JD + DeltaT / 86400.0)

        return JDE
    }

    fun JC(
        JD: Double
    ): Double {
        val T: Double = (JD - 2451545) / 36525
        return T
    }

    fun JCE(
        JDE: Double
    ): Double {
        val T: Double = (JDE - 2451545) / 36525
        return T
    }

    fun JM(
        JC: Double
    ): Double {
        val Tau: Double = JC / 10.0
        return Tau
    }

    fun JME(
        JCE: Double
    ): Double {
        val Tau: Double = JCE / 10.0
        return Tau
    }

}