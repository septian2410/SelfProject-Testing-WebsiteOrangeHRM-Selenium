Feature: Add User

  Background:
    Given Tab User Management telah dimuat.

  @User_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data User tanpa mengisi kolom input apa pun.
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan pesan error pada field EMPLOYEE NAME "Required"

  @User_Add_Failed_Canceled  @Negative
  Scenario:Pengguna mencoba membatalkan penambahan user
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya menekan tombol CANCEL pada pada FORM ADD USER
    Then Terlihat FORM ADD USER telah hilang.

  @User_Add_Failed_with_Passwordtooshort  @Negative
  Scenario: Fail - Password too short (Very Weak)
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan label pesan error PASSWORD "Should have at least 8 characters"


  @User_Add_Failed_with_PasswordMissingUpperCase @Negative
  Scenario: Fail - Missing uppercase letter (Very Weak)
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwert" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwert" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan label pesan error PASSWORD "Your password must contain minimum 1 upper-case letter"


  @User_Add_Failed_with_PasswordMissingSpecialCharacter @Negative
  Scenario: Fail - Missing special character (Weak)
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwertZ" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan label pesan error PASSWORD "Your password must contain minimum 1 special character"


  @User_Add_Failed_with_PasswordIsGuessable @Negative
  Scenario: Fail - Password is guessable (Better)
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwertZ!75" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ!75" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan label pesan error PASSWORD "Your password meets the minimum requirements, but it could be guessable"


  @User_Add_Failed_with_PasswordNotMatch @Negative
  Scenario: Fail - Password is not match
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwertZ!75" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ!74" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan label pesan error CONFIRMASI PASSWORD "Passwords do not match"


  @User_Add_Failed_with_EmployeeInvalid @Negative
  Scenario: Fail - Employee Invalid
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Rino" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwertZ!75" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ!74" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan pesan error pada field EMPLOYEE NAME "Invalid"


  @User_Add_Succes  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data User Baru
    When Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT
    And Saya memasukkan EMPLOYEE NAME "Dummy  User Data" pada FORM ADD USER
    When Saya memasukkan USERNAME "USER321" pada FORM ADD USER
    And Saya memilih USER ROLE baru yaitu "ESS" pada FORM ADD USER
    When Saya memilih STATUS USER baru yaitu "Enabled" pada FORM ADD USER
    And Saya memasukkan PASSWORD baru "12345qwert#N!24" pada FORM ADD USER
    When Saya memasukkan CONFIRMASI PASSWORD baru "12345qwert#N!24" pada FORM ADD USER
    And Saya menekan tombol SAVE pada pada FORM ADD USER
    Then FITUR TAMBAHKAN USER menampilkan pesan Success "Successfully Saved"





