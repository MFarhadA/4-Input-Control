```
nama : Muhammad Farhad Ajilla
nim : 23552011063
kelas : TIF CID 23 A
```

# Aplikasi Input Control Android (Kotlin)
![Preview Aplikasi](https://github.com/user-attachments/assets/0181089a-baad-45ec-a568-9756d5d104a1)

Aplikasi ini dikembangkan menggunakan Android (Kotlin) dan mengimplementasikan empat jenis input control yang umum digunakan dalam pengembangan aplikasi Android:
1. DatePicker & TimePicker
2. AlertDialog
3. Toast
4. EditText

## Fitur dan Penjelasan
### 1. Input Control: Date & Time Picker
![Date Time Picker](https://github.com/user-attachments/assets/39dcdb18-413f-426d-b933-ccbf96d86b08)
- Fungsi: ```pickDate(view: View)```
- Menampilkan **DatePickerDialog** untuk memilih tanggal.
- Setelah tanggal dipilih, langsung ditampilkan **TimePickerDialog** untuk memilih waktu.
- Hasil input akan ditampilkan pada **TextView** dengan ID ```tv_date_time dalam``` format:
  ```
  Tanggal: DD/MM/YYYY  
  Waktu: HH:MM
  ```
- Implementasi:
  ```Kotlin
  val calendar = Calendar.getInstance()
  val tvDateTime = findViewById<TextView>(R.id.tv_date_time)
  val datePicker = DatePickerDialog(
      this,
      { _, year, month, dayOfMonth ->
          val selectedDate = "$dayOfMonth/${month + 1}/$year"
          val timePicker = TimePickerDialog(
              this,
              { _, hour, minute ->
                  val selectedTime = String.format("%02d:%02d", hour, minute)

                  val dateTime = "Tanggal: $selectedDate\nWaktu: $selectedTime"
                  tvDateTime.setText(dateTime)
              },
              calendar.get(Calendar.HOUR_OF_DAY),
              calendar.get(Calendar.MINUTE),
              true
          )
          timePicker.show()
      },
      calendar.get(Calendar.YEAR),
      calendar.get(Calendar.MONTH),
      calendar.get(Calendar.DAY_OF_MONTH)
  )
  datePicker.show()
  ```
### 2. Input Control: AlertDialog
![AlertDialog](https://github.com/user-attachments/assets/2b4492ff-dfca-49a6-bcf4-451ce3b9c47e)
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
- Implementasi:
  ```Kotlin
  AlertDialog.Builder(this)
    .setTitle("Reset Tanggal & Waktu")
    .setMessage("Yakin ingin reset tanggal dan waktu???")
    .setPositiveButton("Yakin") { _, _ ->
        val tvDateTime = findViewById<TextView>(R.id.tv_date_time)
        tvDateTime.text = "Tanggal: DD/MM/YYYY\nWaktu: HH:MM"
  
        // 3. Input Control Toast
        Toast.makeText(this, "Tanggal & waktu telah direset", Toast.LENGTH_SHORT).show()
    }
    .setNegativeButton("Nanti Saja") { dialog, _ ->
        dialog.dismiss()
    }
    .show()
  ```
### 3. Input Control: Toast (Saat Reset)
![Toast](https://github.com/user-attachments/assets/8b8d4dd1-cfd9-4191-b41d-0257503edfab)
- Saat pengguna memilih "Yakin" di dalam **AlertDialog**, maka muncul **Toast** dengan pesan:
  ```
  Tanggal & waktu telah direset
  ```
- Implementasi:
  ```Kotlin
  Toast.makeText(this, "Tanggal & waktu telah direset", Toast.LENGTH_SHORT).show()
  ```
### 4. Input Control: Input Phone Number & Toast
![Input Phone Number & Toast](https://github.com/user-attachments/assets/eccc5ba9-47b7-4144-828c-bf4b720c5502)
- Fungsi: ```toastPhone(view: View)```
- Mengambil input dari **EditText** dengan ID ```et_phone```.
- Menampilkan **Toast** berisi nomor telepon yang diinput pengguna:
  ```
  Nomor telepon anda 08xxxxxxxx
  ```
- Implementasi:
  ```Kotlin
  val etPhone = findViewById<EditText>(R.id.et_phone)
  Toast.makeText(this, "Nomor telepon anda " + etPhone.text, Toast.LENGTH_SHORT).show()
  ```

## Teknologi yang Digunakan
1. Kotlin
2. XML
