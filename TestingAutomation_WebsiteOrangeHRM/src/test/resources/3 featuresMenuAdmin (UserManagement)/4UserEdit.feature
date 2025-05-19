Feature: Edit User

  Background:
    Given Saya telah mengakses bagian User Management.

  @User_Edit_Failed_Canceled  @Negative
  Scenario: Pengguna membatalkan penghapusan data user
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    When Saya menekan tombol CANCEL pada FORM EDIT USER
    Then Terlihat FORM EDIT USER telah menghilang.

  @User_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data User, karena kolom USERNAME dikosongkan.
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    When Saya mengosongkan kolom USERNAME pada FORM EDIT USER
    And Saya menekan tombol SAVE pada FORM EDIT USER
    Then FITUR EDIT USER menampilkan label pesan error pada USERNAME "Required"
#
  @User_Edit_Failed_UsernameTooShort  @Positive
  Scenario: Pengguna Gagal Mengubah Data User, karena kolom USERNAME BARU terlalu sedikit
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    When Saya memasukkan USERNAME BARU yaitu "TEST" pada FORM EDIT USER
    When Saya memilih USER ROLE BARU yaitu "Admin" pada FORM EDIT USER
    And Saya memilih STATUS USER BARU yaitu "Disabled" pada FORM EDIT USER
    And Saya menekan tombol SAVE pada FORM EDIT USER
    Then FITUR EDIT USER menampilkan label pesan error pada USERNAME "Should be at least 5 characters"

  @User_Edit_Failed_EmployeeNameInvalid  @Positive
  Scenario: Pengguna Gagal Mengubah Data User, karena kolom EMPLOYEE NAME tidak terdaftar pada Sistem
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    When Saya memasukkan USERNAME BARU yaitu "TESTER123Update" pada FORM EDIT USER
    And Saya memasukkan NAMA EMPLOYEE BARU yaitu "FATIMA" pada FORM EDIT USER
    When Saya memilih USER ROLE BARU yaitu "Admin" pada FORM EDIT USER
    And Saya memilih STATUS USER BARU yaitu "Disabled" pada FORM EDIT USER
    And Saya menekan tombol SAVE pada FORM EDIT USER
    Then FITUR EDIT USER menampilkan label pesan error pada EMPLOYEE NAME "Invalid"

  @User_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    Then Data "USER321" berhasil terisi otomatis pada FORM EDIT EMPLOYEE sesuai data pada tabel USER.


  @User_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data User lama, menjadi Data User Baru
    And Saya menekan tombol EDIT, pada USER bernama "USER321" pada HALAMAN USER MANAGEMENT
    When Saya memasukkan USERNAME BARU yaitu "TESTER123Update" pada FORM EDIT USER
#    And Saya memasukkan NAMA EMPLOYEE BARU yaitu "Dummy Statis Data Baru" pada FORM EDIT USER
    When Saya memilih USER ROLE BARU yaitu "Admin" pada FORM EDIT USER
    And Saya memilih STATUS USER BARU yaitu "Disabled" pada FORM EDIT USER
    When Saya menekan tombol CHANGE PASSWORD pada FORM EDIT USER
    And Saya memasukkan PASSWORD BARU yaitu "12345qwert#N!300" pada FORM EDIT USER
    When Saya memasukkan CONFIRMASI PASSWORD BARU yaitu "12345qwert#N!300" pada FORM EDIT USER
    And Saya mengklik tombol SAVE pada FORM EDIT USER
    Then Data mengalami perubahan serta, FITUR EDIT USER berhasil menampilkan pesan "Successfully Updated"


  @User_Edit_Succes_Without_ChangePassword  @Positive
  Scenario: Pengguna Berhasil Mengubah Data User lama, menjadi Data User Baru
    And Saya menekan tombol EDIT, pada USER bernama "TESTER123Update" pada HALAMAN USER MANAGEMENT
    When Saya memasukkan USERNAME BARU yaitu "USER321" pada FORM EDIT USER
  #    And Saya memasukkan NAMA EMPLOYEE BARU yaitu "Dummy Statis Data Baru" pada FORM EDIT USER
    When Saya memilih USER ROLE BARU yaitu "ESS" pada FORM EDIT USER
    And Saya memilih STATUS USER BARU yaitu "Enabled" pada FORM EDIT USER
    And Saya menekan tombol SAVE pada FORM EDIT USER
    Then Data mengalami perubahan serta, FITUR EDIT USER berhasil menampilkan pesan "Successfully Updated"

