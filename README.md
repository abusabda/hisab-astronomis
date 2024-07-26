<h2 align="center"><b>Hisab Astronomis</b></h2>
<p align="center">
<b>Library Hisab metode VSOP87D & ELPMPP02 Full</b>
<p><br>

<p align="center">
<!-- Latest release -->
<img src="https://img.shields.io/github/v/release/hasanelfalakiy/hisab-astronomis?include_releases&label=latest%20release&style=for-the-badge&color=brightgreen" alt="latest_release"/>
<!-- Jitpack release -->
<img src="https://img.shields.io/jitpack/v/hasanelfalakiy/hisab-astronomis.svg?style=for-the-badge&color=brightgreen" alt="jitpack_release">
<!-- Github Repo size -->
<img src="https://img.shields.io/github/repo-size/hasanelfalakiy/hisab-astronomis?style=for-the-badge">
<!-- Build with Kotlin -->
<img src="https://img.shields.io/badge/Kotlin-C116E3?&style=for-the-badge&logo=kotlin&logoColor=white" alt="build_with_kotlin">
</p>

# hisab-astronomis

Hisab Astronomis adalah program hisab terkait perhitungan-perhitungan ilmu falak yang dibangun oleh Dewan Hisab dan Rukyat PP PERSIS 

Hisab Astronomis menggunakan algoritma VSOP87D dengan 2.462 suku koreksi untuk menghitung posisi Matahari. Serta algoritma ELP/MPP02 dengan 35.901 suku koreksi untuk menghitung posisi bulan. Walhasil untuk menghitung posisi matahari dan bulan, Hisab Astronomis menggunakan 38.363 suku koreksi. Sebagai perbandingan, program Accurate Times-Odeh menggunakan 3.786 suku koreksi. Atau WinHisab 2.0 -yang diduga menggunakan suku koreksi Jean Meeus- total suku koreksinya sekitar 377 suku koreksi.

Dalam Hisab Astronomis terdapat lima menu utama yaitu:

- [1] Waktu Shalat
- [2] Arah Kiblat
- [3] Takwim Hijriyah
- [4] Data Ephemeris Matahari-Bulan
- [5] Gerhana Bulan dan Gerhana Matahari

Selain itu, terdapat juga menu tambahan, yaitu menu:

- [6] Phase Bulan
- [7] Waktu Terbit, Transit, Terbenam Bulan
- [8] Konversi Kalender Hijri Urfi-Masehi
- [9] Konversi Julian Day.

# Contoh penggunaan

[Lihat di sini](.\src\main\kotlin\id\or\persis\dhr\hisabastronomis\app)

## Konfigurasi pertama

1. Masukkan kode ini ke settings.gradle.kts (root kotlin dsl) di blok ```repositories```
```kotlin.kts
  dependencyResolutionManagement {
    repositories {
      // contoh
      maven {
        url = uri("https://jitpack.io")
      }
    }
  }
```
Jika menggunakan groovy dsl
```groovy
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
```
2. Masukkan dependensi ke build.gradle.kts (app/build.gradle.kts kotlin dsl)
   di blok ```dependencies```

```kotlin.kts
implementation("com.github.hasanelfalakiy:hisab-astronomis:1.0.0")
```
jika menggunakan groovy dsl
```groovy
implementation 'com.github.hasanelfalakiy:hisab-astronomis:1.0.0'
```
## Ingin berkontribusi?

> Jika Anda ingin berkontribusi, silahkan menggarpu (Fork) repositori ini, cloning ke local memory, buat perubahan, push ke github, lalu kirim Pull request ke repositori ini

