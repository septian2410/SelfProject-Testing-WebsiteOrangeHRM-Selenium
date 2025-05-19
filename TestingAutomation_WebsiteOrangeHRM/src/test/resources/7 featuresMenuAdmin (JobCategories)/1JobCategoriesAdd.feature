Feature: ADD JOB CATEGORIES

  Background:
    Given Tab "Job Categories" telah dimuat. JOB CATEGORIES

  @JobCategories_Add_Failed_Canceled  @Negative
  Scenario:Pengguna mencoba membatalkan penambahan JOB CATEGORIES
    When Saya menekan tombol ADD pada HALAMAN JOB CATEGORIES
    And Saya menekan tombol CANCEL pada pada FORM ADD JOB CATEGORIES
    Then Terlihat FORM ADD JOB CATEGORIES telah hilang.

  @JobCategories_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data JOB CATEGORIES tanpa mengisi kolom input apa pun.
    When Saya menekan tombol ADD pada HALAMAN JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM ADD JOB CATEGORIES
    Then FITUR TAMBAHKAN JOB CATEGORIES menampilkan pesan ERROR pada field JOB CATEGORY "Required"

  @JobCategories_Add_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba menambahkan data JOB CATEGORIES dengan data sebelumnya yang sudah terdaftar.
    When Saya menekan tombol ADD pada HALAMAN JOB CATEGORIES
    And Saya memasukkan JOB CATEGORY "Office and Clerical Workers" pada FORM ADD JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM ADD JOB CATEGORIES
    Then FITUR TAMBAHKAN JOB CATEGORIES menampilkan pesan ERROR pada field JOB CATEGORY "Already exists"

  @JobCategories_Add_Succes  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data JOB CATEGORIES Baru
    When Saya menekan tombol ADD pada HALAMAN JOB CATEGORIES
    And Saya memasukkan JOB CATEGORY "Administrative/Clerical" pada FORM ADD JOB CATEGORIES
    When Saya menekan tombol SAVE pada FORM ADD JOB CATEGORIES
    Then FITUR TAMBAHKAN JOB CATEGORIES menampilkan pesan Success "Successfully Saved"
