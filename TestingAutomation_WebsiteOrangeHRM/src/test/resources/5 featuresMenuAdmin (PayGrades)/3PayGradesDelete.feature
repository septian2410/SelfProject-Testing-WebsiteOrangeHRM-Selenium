Feature: DELETE PAY GRADES

  Background:
    Given Halaman "Pay Grades" sekarang terbuka. PAY GRADES

  @PayGrades_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data PAY GRADES
    And Saya menekan tombol DELETE, pada PAY GRADES bernama "PG-07 Update"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE PAY GRADES
    Then Terlihat FORM DELETE PAY GRADES telah menghilang.

  @PayGrades_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data PAY GRADES pada tabel.
    And Saya menekan tombol DELETE, pada PAY GRADES bernama "PG-07 Update"
    When Saya menekan tombol YES, DELETE pada FORM DELETE PAY GRADES
    Then PAY GRADES berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"