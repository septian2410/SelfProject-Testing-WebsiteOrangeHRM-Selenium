Feature: EDIT JOB CATEGORIES

  Background:
    Given Saya telah mengakses bagian "Job Categories" JOB CATEGORIES

  @JobCategories_Edit_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan pengeditan data JOB CATEGORIES
    And Saya menekan tombol EDIT, pada JOB CATEGORY bernama "Administrative/Clerical" pada HALAMAN JOB CATEGORIES
    When Saya menekan tombol CANCEL pada FORM EDIT JOB CATEGORIES
    Then Terlihat FORM EDIT JOB CATEGORIES telah menghilang.

  @JobCategories_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data JOB CATEGORIES, karena kolom JOB CATEGORIES dikosongkan.
    And Saya menekan tombol EDIT, pada JOB CATEGORY bernama "Administrative/Clerical" pada HALAMAN JOB CATEGORIES
    When Saya mengosongkan kolom JOB CATEGORIES pada FORM EDIT JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM EDIT JOB CATEGORIES
    Then FITUR EDIT JOB CATEGORIES menampilkan label pesan error pada JOB CATEGORY "Required"

  @JobCategories_Edit_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba mengubah data JOB CATEGORIES  dengan data sebelumnya yang sudah terdaftar.
    And Saya menekan tombol EDIT, pada JOB CATEGORY bernama "Administrative/Clerical" pada HALAMAN JOB CATEGORIES
    When Saya memasukkan JOB CATEGORY BARU yaitu "Office and Clerical Workers" pada FORM EDIT JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM EDIT JOB CATEGORIES
    Then FITUR EDIT JOB CATEGORIES menampilkan label pesan error pada JOB CATEGORY "Already exists"

  @JobCategories_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada JOB CATEGORY bernama "Administrative/Clerical" pada HALAMAN JOB CATEGORIES
    Then Data "Administrative/Clerical" berhasil terisi otomatis pada FORM EDIT JOB CATEGORIES sesuai data pada tabel JOB CATEGORIES.

  @JobCategories_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data JOB CATEGORIES lama, menjadi Data JOB CATEGORIES Baru
    And Saya menekan tombol EDIT, pada JOB CATEGORY bernama "Administrative/Clerical" pada HALAMAN JOB CATEGORIES
    When Saya memasukkan JOB CATEGORY BARU yaitu "Administrative Support" pada FORM EDIT JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM EDIT JOB CATEGORIES
    Then Data mengalami perubahan serta, FITUR EDIT JOB CATEGORIES berhasil menampilkan pesan "Successfully Updated"

