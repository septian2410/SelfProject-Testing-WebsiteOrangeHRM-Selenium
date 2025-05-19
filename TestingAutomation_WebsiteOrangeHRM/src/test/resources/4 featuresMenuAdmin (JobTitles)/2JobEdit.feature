Feature: Edit Job Title

  Background:
    Given Saya telah mengakses bagian "Job Titles"

  @Job_Edit_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan pengeditan data job
    And Saya menekan tombol EDIT, pada JOB bernama "HR Manager" pada HALAMAN JOB TITLES
    When Saya menekan tombol CANCEL pada FORM EDIT JOB TITLES
    Then Terlihat FORM EDIT JOB TITLES telah menghilang.

  @Job_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data Job, karena kolom JOB TITLE dikosongkan.
    And Saya menekan tombol EDIT, pada JOB bernama "HR Manager" pada HALAMAN JOB TITLES
    When Saya mengosongkan kolom JOB TITLE pada FORM EDIT JOB TITLES
    When Saya menekan tombol SAVE pada FORM EDIT JOB TITLES
    Then FITUR EDIT JOB TITLE menampilkan label pesan error pada JOB TITLE "Required"

  @Job_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada JOB bernama "HR Manager" pada HALAMAN JOB TITLES
    Then Data "HR Manager" berhasil terisi otomatis pada FORM EDIT JOB TITLES sesuai data pada tabel JOB.

  @User_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data Job lama, menjadi Data Job Baru
    And Saya menekan tombol EDIT, pada JOB bernama "HR Manager" pada HALAMAN JOB TITLES
    When Saya memasukkan JOB TITLE BARU yaitu "HR Manager Update" pada FORM EDIT JOB TITLES
    And Saya memasukkan JOB DESCRIPTION BARU "Manage hiring processes, workplace relations, and labor law adherence. Formulate HR guidelines and strategic initiatives." pada FORM EDIT JOB TITLES
    When Saya memilih file baru "dummy-profile-pic.jpg" untuk di Upload pada JOB SPESIFICATION pada FORM EDIT JOB TITLES
    And Saya memasukkan NOTE BARU "UPDATE PROFFESION HUMAN RESOURCE" pada FORM EDIT JOB TITLES
    When Saya menekan tombol SAVE pada FORM EDIT JOB TITLES
    Then Data mengalami perubahan serta, FITUR EDIT JOB TITLES berhasil menampilkan pesan "Successfully Updated"

