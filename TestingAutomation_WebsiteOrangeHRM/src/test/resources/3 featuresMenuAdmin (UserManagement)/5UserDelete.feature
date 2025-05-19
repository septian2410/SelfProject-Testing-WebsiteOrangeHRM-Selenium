Feature: Delete User

  Background:
    Given Halaman User sekarang terbuka.

  @User_Delete_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data User
    And Saya menekan tombol DELETE, pada USERNAME bernama "USER321"
    When Saya menekan tombol NO, CANCEL pada FORM DELETE USER
    Then Terlihat FORM DELETE USER telah menghilang.

  @User_Delete_Succes  @Positive
  Scenario: Pengguna berhasil menghapus data User pada tabel.
    And Saya menekan tombol DELETE, pada USERNAME bernama "USER321"
    When Saya menekan tombol YES, DELETE pada FORM DELETE USER
    Then USER berhasil dihapus pada table dan menampilkan pesan "Successfully Deleted"