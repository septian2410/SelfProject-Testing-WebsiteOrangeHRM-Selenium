Feature: Reset User

  Background:
    Given halaman User Management dimuat kembali.

  @User_Reset_Pencarian_Data_Berhasil  @Positive
  Scenario: Pengguna berhasil melakukan penghapusan data pada kolom inputan pencarian.
    And Saya mengisikan USERNAME "BRI" pada kolom pencarian USERNAME
    When saya menekan tombol RESET pada HALAMAN USER MANAGEMENT
    Then tampil kolom input pencarian USERNAME sudah kosong kembali pada HALAMAN USER MANAGEMENT
