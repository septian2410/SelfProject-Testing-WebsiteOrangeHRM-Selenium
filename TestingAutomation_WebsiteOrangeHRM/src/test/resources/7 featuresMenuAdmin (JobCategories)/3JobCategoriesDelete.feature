Feature: DELETE JOB CATEGORIES

  Background:
    Given Halaman "Job Categories" sekarang terbuka. JOB CATEGORIES

  @JobCategories_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data Job Title
    And Saya menekan tombol DELETE, pada JOB CATEGORY bernama "Administrative Support"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE JOB CATEGORY
    Then Terlihat FORM DELETE JOB CATEGORY telah menghilang.

  @JobCategories_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data Job pada tabel.
    And Saya menekan tombol DELETE, pada JOB CATEGORY bernama "Administrative Support"
    When Saya menekan tombol YES, DELETE pada FORM DELETE JOB CATEGORY
    Then JOB CATEGORY berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"