Feature: LOGOUT ADMIN

  @TC_Admin_Logout_Sukses  @Positive
  Scenario: Pengujian Berhasil Logout
    When saya menekan tombol PROFIL ADMIN
    And saya menekan tombol LOGOUT
    Then Tampil kembali dashboard LOGIN dengan logo teks "Login"