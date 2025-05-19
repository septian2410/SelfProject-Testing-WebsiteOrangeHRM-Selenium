Feature: ADD EMPLOYMENT STATUS

  Background:
    Given Tab "Employment Status" telah dimuat. EMPLOYMENT STATUS

  @EmploymentStatus_Add_Failed_Canceled  @Negative
  Scenario:Pengguna mencoba membatalkan penambahan EMPLOYMENT STATUS
    When Saya menekan tombol ADD pada HALAMAN EMPLOYMENT STATUS
    And Saya menekan tombol CANCEL pada pada FORM ADD EMPLOYMENT STATUS
    Then Terlihat FORM ADD EMPLOYMENT STATUS telah hilang.

  @EmploymentStatus_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data EMPLOYMENT STATUS tanpa mengisi kolom input apa pun.
    When Saya menekan tombol ADD pada HALAMAN EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM ADD EMPLOYMENT STATUS
    Then FITUR TAMBAHKAN EMPLOYMENT STATUS menampilkan pesan ERROR pada field EMPLOYMENT STATUS "Required"

  @EmploymentStatus_Add_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba menambahkan data EMPLOYMENT STATUS dengan data sebelumnya yang sudah terdaftar.
    When Saya menekan tombol ADD pada HALAMAN EMPLOYMENT STATUS
    And Saya memasukkan EMPLOYMENT STATUS "Student" pada FORM ADD EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM ADD EMPLOYMENT STATUS
    Then FITUR TAMBAHKAN EMPLOYMENT STATUS menampilkan pesan ERROR pada field EMPLOYMENT STATUS "Already exists"

  @EmploymentStatus_Add_Succes  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data EMPLOYMENT STATUS Baru
    When Saya menekan tombol ADD pada HALAMAN EMPLOYMENT STATUS
    And Saya memasukkan EMPLOYMENT STATUS "Self-employed" pada FORM ADD EMPLOYMENT STATUS
    When Saya menekan tombol SAVE pada FORM ADD EMPLOYMENT STATUS
    Then FITUR TAMBAHKAN EMPLOYMENT STATUS menampilkan pesan Success "Successfully Saved"





