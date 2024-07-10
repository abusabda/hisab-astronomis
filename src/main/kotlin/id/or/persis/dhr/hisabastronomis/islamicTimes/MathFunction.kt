package id.or.persis.dhr.hisabastronomis.islamicTimes

class MathFunction {
    // Math Function
    fun Deg(x: Double) = Math.toDegrees(x)
    fun Rad(x: Double) = Math.toRadians(x)
    fun Mod(x: Double, y: Double) = x - y * Math.floor(x / y) //F
    fun Sign(x: Double) = if (x > 0) {
        1
    } else if (x < 0) {
        -1
    } else {
        0
    }

    // fungsi ini hasilnya sesuai dengan umum dipakai
    fun Double.round(decimals: Int = 2): String {
        return "%.${decimals}f".format(this)
    }

    // fungsi ini hasilnya sesuai dengan umum dipakai
    fun RoundTo(xDec: Double, Place: Int = 2): String {
        val A: Double = Math.pow(10.0, Place.toDouble())
        val H: Double = if (xDec >= 0) {
            Math.floor(xDec * A + 0.5) / A
        } else {
            -Math.floor(Math.abs(xDec) * A + 0.5) / A
        }
        return H.toString()
    }

    fun DHHMS(
        DHrs: Double,
        OptResult: String = "HH:MM:SS",
        SecDecPlaces: Byte = 2,
        PosNegSign: String = ""
    ): String {
        val uDHrs: Double = Math.abs(DHrs)
        var uHrs: Double = Math.floor(uDHrs)
        val uDMin: Double = (uDHrs - uHrs) * 60.0
        var uMin: Double = Math.floor(uDMin)
        val uDSec: Double = (uDMin - uMin) * 60.0
        var uSec: String = "%.${SecDecPlaces}f".format(uDSec)

        if (uSec.toDouble() == 60.0) {
            uSec = "%.${SecDecPlaces}f".format(0.0)
            uMin = uMin + 1.0
        } else {
        }

        if (uMin == 60.0) {
            uMin = 0.0
            uHrs = uHrs + 1.0
        } else {
        }

        val sHrs = when {
            uHrs.toInt() < 10 -> "0${uHrs.toInt()}"
            else -> "${uHrs.toInt()}"
        }

        val sMin = when {
            uMin.toInt() < 10 -> "0${uMin.toInt()}"
            else -> "${uMin.toInt()}"
        }

        val sSec = when {
            uSec.toDouble() < 10.0 -> "0${uSec}"
            else -> "${uSec}"
        }

        val PNS = when (PosNegSign) {
            "+-" -> {
                when {
                    DHrs > 0.0 -> "+"
                    DHrs < 0.0 -> "-"
                    else -> ""
                }
            }

            else -> {
                when {
                    DHrs > 0.0 -> ""
                    DHrs < 0.0 -> "-"
                    else -> ""
                }
            }
        }

        return when (OptResult) {
            "HH:MM:SS" -> "$PNS${sHrs}:${sMin}:${sSec}"
            "HHMMSS" -> "$PNS${sHrs}h ${sMin}m ${sSec}s"
            "MMSS" -> "$PNS${sMin}m ${sSec}s"
            "HH:MM" -> "$PNS${sHrs}:${sMin}"
            else -> "$PNS${sHrs}:${sMin}:${sSec}"
        }
    }

    fun DHHM(
        DHrs: Double,
        OptResult: String = "HH:MM",
        MinDecPlaces: Byte = 2,
        PosNegSign: String = ""
    ): String {
        val uDHrs: Double = Math.abs(DHrs)
        var uHrs: Double = Math.floor(uDHrs)
        val uDMin: Double = (uDHrs - uHrs) * 60.0
        var uMin: String = "%.${MinDecPlaces}f".format(uDMin)

        if (uMin.toDouble() == 60.0) {
            uMin = "%.${MinDecPlaces}f".format(0.0)
            uHrs = uHrs + 1.0
        } else {
        }

        val sHrs: String = when {
            uHrs.toInt() < 10 -> "0${uHrs.toInt()}"
            else -> "${uHrs.toInt()}"
        }

        val sMin: String = when {
            uMin.toDouble() < 10.0 -> "0${uMin}"
            else -> "${uMin}"
        }

        val PNS: String = when (PosNegSign) {
            "+-" -> {
                when {
                    DHrs > 0.0 -> "+"
                    DHrs < 0.0 -> "-"
                    else -> ""
                }
            }

            else -> {
                when {
                    DHrs > 0.0 -> ""
                    DHrs < 0.0 -> "-"
                    else -> ""
                }
            }
        }

        return when (OptResult) {
            "HH:MM" -> "$PNS${sHrs}:${sMin}"
            "HHMM" -> "$PNS${sHrs}h ${sMin}m"
            else -> "$PNS${sHrs}:${sMin}"
        }
    }

    fun DDDMS(
        DDeg: Double,
        OptResult: String = "DDMMSS",
        SDP: Byte = 2
    ): String {
        val uDDeg = Math.abs(DDeg)
        var uDeg = Math.floor(uDDeg)
        val uDMin = (uDDeg - uDeg) * 60.0
        var uMin = Math.floor(uDMin)
        val uDSec = (uDMin - uMin) * 60.0
        var uSec = "%.${SDP}f".format(uDSec)

        if (uSec.toDouble() == 60.0) {
            uSec = "%.${SDP}f".format(0.0)
            uMin = uMin + 1.0
        } else {
        }

        if (uMin == 60.0) {
            uMin = 0.0
            uDeg = uDeg + 1.0
        } else {
        }

        val sDeg: String = when {
            uDeg.toInt() < 10 -> "00${uDeg.toInt()}"
            uDeg.toInt() < 100 -> "0${uDeg.toInt()}"
            else -> "${uDeg.toInt()}"
        }

        val sMin: String = when {
            uMin.toInt() < 10 -> "0${uMin.toInt()}"
            else -> "${uMin.toInt()}"
        }

        val sSec: String = when {
            uSec.toDouble() < 10.0 -> "0${uSec}"
            else -> "${uSec}"
        }

        val PNS: String = when {
            DDeg > 0.0 -> "+"
            DDeg < 0.0 -> "-"
            else -> ""
        }

        val BBBT: String
        val LULS: String

        if (DDeg > 0.0) {
            BBBT = "BT"
            LULS = "LU"
        } else {
            BBBT = "BB"
            LULS = "LS"
        }

        return when (OptResult) {
            "DDMMSS" -> "$PNS${sDeg}° ${sMin}’ ${sSec}”"
            "MMSS" -> "$PNS${sMin}’ ${sSec}”"
            "SS" -> "$PNS${sSec}”"
            "BBBT" -> "$PNS${sDeg}° ${sMin}’ ${sSec}” ${BBBT}"
            "LULS" -> "$PNS${sDeg}° ${sMin}’ ${sSec}” ${LULS}"
            else -> "$PNS${sDeg}° ${sMin}’ ${sSec}”"
        }
    }

    fun DDDMS2(
        DDeg: Double,
        OptResult: String = "DDMMSS",
        SDP: Byte = 2
    ): String {

        val uDDeg: Double = Math.abs(DDeg)
        var uDeg: String = "%.${0}f".format(Math.floor(uDDeg))
        val uDMin: Double = (uDDeg - uDeg.toString().toDouble()) * 60.0
        var uMin: String = "%.${0}f".format(Math.floor(uDMin))
        val uDSec: Double = (uDMin - uMin.toString().toDouble()) * 60.0
        var uSec: String = "%.${SDP}f".format(uDSec)

        if (uSec.toDouble() == 60.0) {
            uSec = "%.${SDP}f".format(0.0)
            uMin = uMin + 1.0
        } else {
        }

        if (uMin.toDouble() == 60.0) {
            uMin = 0.toString()
            uDeg = uDeg + 1.0
        } else {
        }

        val PNS: String = when {
            DDeg > 0.0 -> "+"
            DDeg < 0.0 -> "-"
            else -> ""
        }

        val BBBT: String
        val LULS: String

        if (DDeg > 0.0) {
            BBBT = "BT"
            LULS = "LU"
        } else {
            BBBT = "BB"
            LULS = "LS"
        }

        return when (OptResult) {
            "DDMMSS" -> "$PNS${uDeg}° ${uMin}’ ${uSec}”"
            "MMSS" -> "$PNS${uMin}’ ${uSec}”"
            "SS" -> "$PNS${uSec}”"
            "BBBT" -> "$PNS${uDeg}° ${uMin}’ ${uSec}” ${BBBT}"
            "LULS" -> "$PNS${uDeg}° ${uMin}’ ${uSec}” ${LULS}"
            else -> "$PNS${uDeg}° ${uMin}’ ${uSec}”"
        }
    }

    fun InterpolationFromFiveTabularValues(
        xM2: Double,
        xM1: Double,
        x00: Double,
        xP1: Double,
        xP2: Double,
        OptResult: Int
    ): Double {
        val A: Double = xM1 - xM2
        val B: Double = x00 - xM1
        val C: Double = xP1 - x00
        val D: Double = xP2 - xP1
        val E: Double = B - A
        val F: Double = C - B
        val G: Double = D - C
        val H: Double = F - E
        val J: Double = G - F
        val K: Double = J - H

        return when (OptResult) {
            0 -> x00
            1 -> ((B + C) / 2 - (H + J) / 12)
            2 -> (F / 2 - K / 24)
            3 -> ((H + J) / 12)
            4 -> (K / 24)
            else -> x00
        }
    }

}
