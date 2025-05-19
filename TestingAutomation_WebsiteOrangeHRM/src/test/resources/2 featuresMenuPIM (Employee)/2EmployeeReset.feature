Feature: Reset Employee

  Background:
    Given halaman Employee dimuat kembali.

  @Employee_Reset_Pencarian_Data_Berhasil  @Positive
  Scenario: Pengguna berhasil melakukan penghapusan data pada kolom inputan pencarian.
    And Saya mengisikan EMPLOYEE NAME "BRI" pada kolom pencarian Employee Name
    When saya menekan tombol RESET
    Then tampil kolom input pencarian Employee Name sudah kosong kembali pada halaman Employee
