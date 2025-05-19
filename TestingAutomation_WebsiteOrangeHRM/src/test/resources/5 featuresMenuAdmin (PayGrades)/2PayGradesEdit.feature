Feature: EDIT PAY GRADES

  Background:
    Given Saya telah mengakses bagian "Pay Grades" PAY GRADES

  @PayGrades_Edit_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan pengeditan data PAY GRADE
    And Saya menekan tombol EDIT, pada CURRENCY bernama "PG-07" pada HALAMAN PAY GRADES
    When Saya menekan tombol CANCEL pada FORM EDIT PAY GRADES
    Then Terlihat FORM EDIT PAY GRADE telah menghilang.

  @PayGrades_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data PAY GRADE, karena kolom PAY GRADE dikosongkan.
    And Saya menekan tombol EDIT, pada CURRENCY bernama "PG-07" pada HALAMAN PAY GRADES
    When Saya mengosongkan kolom PAY GRADES pada FORM EDIT PAY GRADES
    When Saya menekan tombol SAVE pada FORM EDIT PAY GRADES
    Then FITUR EDIT PAY GRADES menampilkan label pesan error pada PAY GRADES "Required"

  @PayGrades_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada CURRENCY bernama "PG-07" pada HALAMAN PAY GRADES
    Then Data "PG-07" berhasil terisi otomatis pada FORM EDIT PAY GRADES sesuai data pada tabel PAY GRADES.

  @PayGrades_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data PAY GRADES lama, menjadi Data PAY GRADES Baru
    And Saya menekan tombol EDIT, pada CURRENCY bernama "PG-07" pada HALAMAN PAY GRADES
    When Saya memasukkan PAY GRADES BARU yaitu "PG-07 Update" pada FORM EDIT PAY GRADES
    And Saya mengganti CURRENCY lama dengan menghapusnya
    When Saya kembali menekan tombol ADD pada FORM CURRENCIES
    And Saya memilih CURRENCY mata uang baru "EUR - Euro" pada FORM CURRENCIES
    When Saya memasukkan MINIMUM SALARY baru "15000000" pada FORM CURRENCIES
    And Saya memasukkan MAXIMUM SALARY baru "18000000" pada FORM CURRENCIES
    When Saya menekan tombol SAVE CURRENCY pada FORM CURRENCIES
    When Saya menekan tombol SAVE pada FORM EDIT PAY GRADES
    Then Data mengalami perubahan serta, FITUR EDIT PAY GRADES berhasil menampilkan pesan "Successfully Updated"

