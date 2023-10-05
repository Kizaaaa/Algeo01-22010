# Linear Equation System, Determinant, and the Application
Tugas Besar 1 IF2123 Aljabar Linear dan Geometri -  Sistem Persamaan Linear, Determinan, dan Aplikasinya

<p align="center">
  <img height="360px" src="https://media.discordapp.net/attachments/1138429958486769706/1152174025112555610/IMG_20230915_162608.jpg?ex=65193bad&is=6517ea2d&hm=dd1b409d823bc8e47baf1c368dee9a4678076373d2abc48c61aaf702895af6da&=&width=935&height=701" alt="logo HMIF"/>
  <br>
  <a><i><sup>Personil kelompok "Daspro Gagal A"</sup></i></a>
</p>

## Anggota 
1. Maria Flora Renata Siringoringo (13522010)
2. M Athaullah Daffa Kusuma M (13522044)
3. Dzaky Satrio Nugroho (13522059)

## Deskripsi Singkat
Program ini merupakan tugas besar 1 dari mata kuliah IF2123 Aljabar Linear dan Geometri. Program ini berfungsi untuk Menginmplementasikan matriks dam metode-metode matriks dalam bahasa pemrograman java, Pencarian determinan matriks dengan beberapa metode, sampai aplikasi-aplikasi matriks seperti interpolasi polinomial, sampai regresi linear.  

## Informasi Tambahan
Program dibuat dengan : Java 20 (JDK20)
IDE yang digunakan : Visual Studio Code dengan banyak extension lainnya
Laporan dibuat dengan : Google Docs 

## Petunjuk Cara Menjalankan Program dan lainnya

### Cara Menjalankan Program
Ada 2 opsi untuk menjalankan program, yaitu:
1. Jalankan file RunProg.jar dengan
```
java -jar RunProg.jar
```
2. Jalankan secara manual, run dari program Main.java
### Input berupa File
Masukkan file txt yang hendak diuji ke dalam folder test yang telah disediakan, lalu input sesuai dengan instruksi lebih lanjut yang ada di dalam program.
### Output berupa File
Ketika program selesai dijalankan dan mendapat hasil, nantinya user akan ditanya apakah hendak menulis hasil di file txt. Jika iya, silahkan masukkan nama file txt. Jika file tersebut sudah ada di folder test/, maka file tersebut akan diwrite setelah isi dari file tersebut. Jika file tersebut tidak ada di folder test/, maka program akan membuat file baru dengan nama tersebut dan menulis hasil dari kalkulasi ke dalam file tersebut.  
 
## Branching dan Commit Messages

Setiap membuat branch baru harus ambil base dari `main`. Untuk penamaan commit dan branch mengikuti format berikut.
Format branch: `<type>/<title>`, contoh `feat/Navbar`.
Format commit: `<type>: <subject>`, contoh `feat: add navbar`.
Penamaan menggunakan camel case

Untuk type mengikuti semantic berikut.

- `feat`: (new feature for the user, not a new feature for build script)
- `fix`: (bug fix for the user, not a fix to a build script)
- `docs`: (changes to the documentation)
- `style`: (formatting, missing semi colons, etc; no production code change)
- `refactor`: (refactoring production code, eg. renaming a variable)
- `test`: (adding missing tests, refactoring tests; no production code change)
- `chore`: (updating grunt tasks etc; no production code change)