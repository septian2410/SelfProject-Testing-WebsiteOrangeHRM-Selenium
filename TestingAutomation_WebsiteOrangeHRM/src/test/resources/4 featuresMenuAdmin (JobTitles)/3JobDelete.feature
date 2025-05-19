Feature: Delete Job Title

  Background:
    Given Halaman "Job Titles" sekarang terbuka.

  @Job_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data Job Title
    And Saya menekan tombol DELETE, pada JOB TITLE bernama "HR Manager Update"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE JOB TITLE
    Then Terlihat FORM DELETE JOB TITLE telah menghilang.

  @Job_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data Job pada tabel.
    And Saya menekan tombol DELETE, pada JOB TITLE bernama "HR Manager Update"
    When Saya menekan tombol YES, DELETE pada FORM DELETE JOB TITLE
    Then JOB TITLE berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"