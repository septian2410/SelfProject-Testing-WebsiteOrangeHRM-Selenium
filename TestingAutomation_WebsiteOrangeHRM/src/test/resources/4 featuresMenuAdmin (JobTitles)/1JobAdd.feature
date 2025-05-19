Feature: Add Job Title

  Background:
    Given Tab "Job Titles" telah dimuat.

  @Job_Add_Failed_Canceled  @Negative
  Scenario:Pengguna mencoba membatalkan penambahan job
    When Saya menekan tombol ADD pada HALAMAN JOB TITLE
    And Saya menekan tombol CANCEL pada pada FORM JOB TITLE
    Then Terlihat FORM ADD JOB TITLE telah hilang.

  @Job_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data Job tanpa mengisi kolom input apa pun.
    When Saya menekan tombol ADD pada HALAMAN JOB TITLE
    And Saya menekan tombol SAVE pada pada FORM ADD JOB TITLE
    Then FITUR TAMBAHKAN JOB TITLE menampilkan pesan error pada field JOB TITLE "Required"

  @Job_Add_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba menambahkan data JOB TITLE dengan data sebelumnya yang sudah terdaftar.
    When Saya menekan tombol ADD pada HALAMAN JOB TITLE
    And Saya memasukkan JOB TITLE "Software Engineer" pada FORM JOB TITLE
    And Saya menekan tombol SAVE pada pada FORM ADD JOB TITLE
    Then FITUR TAMBAHKAN JOB TITLE menampilkan pesan error pada field JOB TITLE "Already exists"

  @Job_Add_Succes  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data Job Baru
    When Saya menekan tombol ADD pada HALAMAN JOB TITLE
    And Saya memasukkan JOB TITLE "HR Manager" pada FORM JOB TITLE
    When Saya memasukkan JOB DESCRIPTION "Oversee recruitment, employee relations, and compliance with labor laws. Develop HR policies and strategies." pada FORM JOB TITLE
    And Saya memilih file "dummy-profile-pic.jpg" untuk di Upload pada JOB SPESIFICATION pada FORM JOB TITLE
    When Saya memasukkan NOTE "NEW PROFESSION HUMAN RESOURCE" pada FORM JOB TITLE
    And Saya menekan tombol SAVE pada pada FORM ADD JOB TITLE
    Then FITUR TAMBAHKAN JOB TITLE menampilkan pesan Success "Successfully Saved"





