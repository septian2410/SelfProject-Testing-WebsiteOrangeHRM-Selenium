Feature: Delete Employee

  Background:
    Given Halaman Employee sekarang terbuka.

  @Employee_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data employee
    And Saya menekan tombol DELETE, pada employee bernama "TESTER2 UPDATE"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE EMPLOYEE
    Then Terlihat FORM DELETE EMPLOYEE telah menghilang.

  @Employee_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data employee pada tabel.
    And Saya menekan tombol DELETE, pada employee bernama "TESTER2 UPDATE"
    When Saya menekan tombol YES, DELETE pada FORM DELETE EMPLOYEE
    Then employee berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"