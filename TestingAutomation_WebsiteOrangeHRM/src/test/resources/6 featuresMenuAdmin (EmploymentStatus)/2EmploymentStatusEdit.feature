Feature: EDIT EMPLOYMENT STATUS

  Background:
    Given Saya telah mengakses bagian "Employment Status" EMPLOYMENT STATUS

  @EmploymentStatus_Edit_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan pengeditan data EMPLOYMENT STATUS
    And Saya menekan tombol EDIT, pada CURRENCY bernama "Self-employed" pada HALAMAN EMPLOYMENT STATUS
    When Saya menekan tombol CANCEL pada FORM EDIT EMPLOYMENT STATUS
    Then Terlihat FORM EDIT EMPLOYMENT STATUS telah menghilang.

  @EmploymentStatus_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data EMPLOYMENT STATUS, karena kolom EMPLOYMENT STATUS dikosongkan.
    And Saya menekan tombol EDIT, pada CURRENCY bernama "Self-employed" pada HALAMAN EMPLOYMENT STATUS
    When Saya mengosongkan kolom EMPLOYMENT STATUS pada FORM EDIT EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM EDIT EMPLOYMENT STATUS
    Then FITUR EDIT EMPLOYMENT STATUS menampilkan label pesan error pada EMPLOYMENT STATUS "Required"

  @EmploymentStatus_Edit_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba mengubah data EMPLOYMENT STATUS dengan data sebelumnya yang sudah terdaftar.
    And Saya menekan tombol EDIT, pada CURRENCY bernama "Self-employed" pada HALAMAN EMPLOYMENT STATUS
    When Saya memasukkan EMPLOYMENT STATUS BARU yaitu "Student" pada FORM EDIT EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM EDIT EMPLOYMENT STATUS
    Then FITUR EDIT EMPLOYMENT STATUS menampilkan label pesan error pada EMPLOYMENT STATUS "Already exists"

  @EmploymentStatus_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada CURRENCY bernama "Self-employed" pada HALAMAN EMPLOYMENT STATUS
    Then Data "Self-employed" berhasil terisi otomatis pada FORM EDIT EMPLOYMENT STATUS sesuai data pada tabel EMPLOYMENT STATUS.

  @EmploymentStatus_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data EMPLOYMENT STATUS lama, menjadi Data EMPLOYMENT STATUS Baru
    And Saya menekan tombol EDIT, pada CURRENCY bernama "Self-employed" pada HALAMAN EMPLOYMENT STATUS
    When Saya memasukkan EMPLOYMENT STATUS BARU yaitu "Unemployed" pada FORM EDIT EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM EDIT EMPLOYMENT STATUS
    Then Data mengalami perubahan serta, FITUR EDIT EMPLOYMENT STATUS berhasil menampilkan pesan "Successfully Updated"

