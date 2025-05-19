Feature: Add Employee

Background:
Given halaman Employee telah dimuat.

  @Employee_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data Employee tanpa mengisi kolom input apa pun.
    And Saya menekan tombol ADD pada halaman Employee List
    When Saya langsung menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error "Required"

  @Employee_Add_Failed_IdAlreadyExists  @Negative
  Scenario:Pengguna mencoba menambahkan data Employee, dengan ID yang sudah terdaftar sebelumnya
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0001"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error ID "Employee Id already exists"

  @Employee_Add_Failed_CancelAddEmployee  @Negative
  Scenario:Pengguna Berhasil Menambahkan Data Employee Baru, sekaligus membuat Login akses details
    And Saya menekan kembali tombol ADD pada halaman Employee List
    And Saya menekan tombol CANCEL pada FORM ADD EMPLOYEE
    Then Terlihat formulir ADD EMPLOYEE telah hilang.

  @Employee_Add_Failed_with_Passwordtooshort  @Negative
  Scenario: Fail - Password too short (Very Weak)
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0014"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error PASSWORD "Should have at least 8 characters"

  @Employee_Add_Failed_with_PasswordMissingUpperCase @Negative
  Scenario: Fail - Missing uppercase letter (Very Weak)
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0014"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345qwert"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345qwert"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error PASSWORD "Your password must contain minimum 1 upper-case letter"

  @Employee_Add_Failed_with_PasswordMissingSpecialCharacter @Negative
  Scenario: Fail - Missing special character (Weak)
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0014"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345qwertZ"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error PASSWORD "Your password must contain minimum 1 special character"

  @Employee_Add_Failed_with_PasswordIsGuessable @Negative
  Scenario: Fail - Password is guessable (Better)
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0014"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345qwertZ!75"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ!75"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error PASSWORD "Your password meets the minimum requirements, but it could be guessable"

  @Employee_Add_Failed_with_PasswordNotMatch @Negative
  Scenario: Fail - Password is not match
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER1"
    When Saya memasukkan LAST NAME employee baru "QA1"
    And Saya memasukkan EMPLOYEE ID baru "0014"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345qwertZ!75"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345qwertZ!74"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan label pesan error PASSWORD CONFIRMASI "Passwords do not match"

#  @Employee_Add_Succes  @Positive
#  Scenario:Pengguna Berhasil Menambahkan Data Employee Baru
#    And Saya menekan kembali tombol ADD pada halaman Employee List
#    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
#    And Saya memasukkan FIRST NAME employee baru "TESTER1"
#    When Saya memasukkan LAST NAME employee baru "QA1"
#    And Saya memasukkan EMPLOYEE ID baru "0014"
#    And Saya menekan tombol SAVE pada form add employee
#    Then fitur tambahkan employee menampilkan pesan Success "Successfully Saved"

  @Employee_Add_Succes_with_CreateLoginDetails  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data Employee Baru, sekaligus membuat Login akses details
    And Saya menekan kembali tombol ADD pada halaman Employee List
    When Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama "dummy-profile-pic.jpg"
    And Saya memasukkan FIRST NAME employee baru "TESTER2"
    When Saya memasukkan LAST NAME employee baru "QA2"
    And Saya memasukkan EMPLOYEE ID baru "0015"
    When Saya menekan CREATE LOGIN DETAILS
    And Saya memasukkan USERNAME baru "TESTER123"
    When Saya memasukkan PASSWORD baru "12345qwert#N!24"
    And Saya memasukkan CONFIRMASI PASSWORD baru "12345qwert#N!24"
    And Saya menekan tombol SAVE pada form add employee
    Then fitur tambahkan employee menampilkan pesan Success "Successfully Saved"


#When Saya mencari kategori yang telah ditambahkan, yaitu "Gaming Console & Aksesori"
#Then Sistem berhasil menampilkan kategori baru yang ditambahkan, yaitu "Gaming Console & Aksesori"

