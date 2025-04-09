```
nama : Muhammad Farhad Ajilla
nim : 23552011063
kelas : TIF CID 23 A
```

# Aplikasi Input Control Android (Kotlin)
Aplikasi ini dikembangkan menggunakan Android (Kotlin) dan mengimplementasikan empat jenis input control yang umum digunakan dalam pengembangan aplikasi Android:
1. DatePicker & TimePicker
2. AlertDialog
3. Toast
4. EditText

## Fitur dan Penjelasan
### 1. Input Control: Date & Time Picker
- Fungsi: ```pickDate(view: View)```
- Menampilkan **DatePickerDialog** untuk memilih tanggal.
- Setelah tanggal dipilih, langsung ditampilkan **TimePickerDialog** untuk memilih waktu.
- Hasil input akan ditampilkan pada **TextView** dengan ID ```tv_date_time dalam``` format:
```
Tanggal: DD/MM/YYYY  
Waktu: HH:MM
```
### 2. Input Control: AlertDialog
- Fungsi: ```resetDateTime(view: View)```
- Menampilkan **AlertDialog** dengan pesan:
```
Yakin ingin reset tanggal dan waktu???
```
- Tombol yang tersedia:
  - **Yakin** → Mereset TextView ke format default:
```
Tanggal: DD/MM/YYYY  
Waktu: HH:MM
```
  - **Nanti Saja** → Menutup dialog tanpa mengubah data.
### 3. Input Control: Toast (Saat Reset)
- Saat pengguna memilih "Yakin" di dalam **AlertDialog**, maka muncul **Toast** dengan pesan:
```
Tanggal & waktu telah direset
```
- Implementasi:
```
Toast.makeText(this, "Tanggal & waktu telah direset", Toast.LENGTH_SHORT).show()
```
### 4. Input Control: EditText & Toast
- Fungsi: ```toastPhone(view: View)```
- Mengambil input dari **EditText** dengan ID ```et_phone```.
- Menampilkan **Toast** berisi nomor telepon yang diinput pengguna:
```
Nomor telepon anda 08xxxxxxxx
```
- Implementasi:
```
val etPhone = findViewById<EditText>(R.id.et_phone)
Toast.makeText(this, "Nomor telepon anda " + etPhone.text, Toast.LENGTH_SHORT).show()
```

## Teknologi yang Digunakan
1. Kotlin
2. XML
