Feature: DELETE EMPLOYMENT STATUS

  Background:
    Given Halaman "Employment Status" sekarang terbuka. EMPLOYMENT STATUS

  @EmploymentStatus_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data EMPLOYMENT STATUS
    And Saya menekan tombol DELETE, pada EMPLOYMENT STATUS bernama "Unemployed"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE EMPLOYMENT STATUS
    Then Terlihat FORM DELETE EMPLOYMENT STATUS telah menghilang.

  @EmploymentStatus_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data EMPLOYMENT STATUS pada tabel.
    And Saya menekan tombol DELETE, pada EMPLOYMENT STATUS bernama "Unemployed"
    When Saya menekan tombol YES, DELETE pada FORM DELETE EMPLOYMENT STATUS
    Then EMPLOYMENT STATUS berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"