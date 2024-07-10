//package app
//
//import islamicTimes.*
//
//
//fun main() {
//
//    val mf = MathFunction()
//    val mo = MoonOtherFunc()
//
//    val tglM    : Byte = 1
//    val blnM    : Byte = 1
//    val thnM    : Long = 2024
//    val gLon    : Double = 107+36/60.0 + 0/36000
//    val gLat    : Double =   7+5/60.0
//    val elev    : Double = 730.0
//    val tmZn    : Double = 7.0
//
//    val moonRse = mo.moonTransitRiseSet(tglM,blnM,thnM,gLon,gLat,elev,tmZn,"RISE",2)
//    val moonTrs = mo.moonTransitRiseSet(tglM,blnM,thnM,gLon,gLat,elev,tmZn,"TRANSIT",2)
//    val MoonSet = mo.moonTransitRiseSet(tglM,blnM,thnM,gLon,gLat,elev,tmZn,"SET",2)

//    println("Moon Rise    : ${mf.DHHMS(moonRse.toString().toDouble(),"HH:MM:SS",0) +" LT"}")
//    println("Moon Transit : ${mf.DHHMS(moonTrs.toString().toDouble(),"HH:MM:SS",0) +" LT"}")
//    println("Moon Set     : ${mf.DHHMS(MoonSet.toString().toDouble(),"HH:MM:SS",0) +" LT"}")
//}