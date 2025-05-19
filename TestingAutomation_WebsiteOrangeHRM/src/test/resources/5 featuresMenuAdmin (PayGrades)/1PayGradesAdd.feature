Feature: ADD PAY GRADES

  Background:
    Given Tab "Pay Grades" telah dimuat. PAY GRADES

  @PayGrades_Add_Failed_Canceled  @Negative
  Scenario:Pengguna mencoba membatalkan penambahan PAY GRADES
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya menekan tombol CANCEL pada pada FORM ADD PAY GRADE
    Then Terlihat FORM ADD PAY GRADE telah hilang.

  @PayGrades_Add_Failed_FieldEmpty  @Negative
  Scenario: Pengguna mencoba menambahkan data PAY GRADES tanpa mengisi kolom input apa pun.
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field PAY GRADE "Required"

  @PayGrades_Add_Failed_AlreadyExists  @Negative
  Scenario: Pengguna mencoba menambahkan data PAY GRADES dengan data sebelumnya yang sudah terdaftar.
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya memasukkan PAY GRADE "PG-03" pada FORM ADD PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field PAY GRADE "Already exists"

  @PayGrades_Add_Failed_CurrencyEmpty  @Positive
  Scenario: Pengguna mencoba menambahkan data PAY GRADES tanpa mengisi kolom currency.
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya memasukkan PAY GRADE "PG-04" pada FORM ADD PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    And Saya menekan tombol ADD pada FORM CURRENCIES
    And Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field CURRENCY "Required"

  @PayGrades_Add_Failed_SalaryInvalid  @Positive
  Scenario: Pengguna mencoba menambahkan data PAY GRADES dengan nilai Salary yang tidak benar.
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya memasukkan PAY GRADE "PG-05" pada FORM ADD PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    And Saya menekan tombol ADD pada FORM CURRENCIES
    When Saya memilih CURRENCY mata uang "EUR - Euro" pada FORM CURRENCIES
    And Saya memasukkan MINIMUM SALARY "#####" pada FORM CURRENCIES
    When Saya memasukkan MAXIMUM SALARY "#####" pada FORM CURRENCIES
    And Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field MINIMUM SALARY "Should be a valid number (xxx.xx)"

  @PayGrades_Add_Failed_MinimumSalaryHigherThanMaximumSalary  @Positive
  Scenario: Pengguna mencoba menambahkan data PAY GRADES dengan nilai MINIMUM Salary yang lebih besar dibandingkan MAXIMUM Salary .
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya memasukkan PAY GRADE "PG-06" pada FORM ADD PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    And Saya menekan tombol ADD pada FORM CURRENCIES
    When Saya memilih CURRENCY mata uang "EUR - Euro" pada FORM CURRENCIES
    And Saya memasukkan MINIMUM SALARY "100000000" pada FORM CURRENCIES
    When Saya memasukkan MAXIMUM SALARY "12000000" pada FORM CURRENCIES
    And Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field MINIMUM SALARY "Should be lower than Maximum Salary"

#  @PayGrades_Add_Failed_MaximumSalaryLowerThanMinimumSalary  @Positive
#  Scenario: Pengguna mencoba menambahkan data PAY GRADES dengan nilai MAXIMUM Salary yang lebih kecil dibandingkan MINIMUM Salary .
#    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
#    And Saya memasukkan PAY GRADE "WON" pada FORM ADD PAY GRADE
#    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
#    And Saya menekan tombol ADD pada FORM CURRENCIES
#    When Saya memilih CURRENCY mata uang "EUR - Euro" pada FORM CURRENCIES
#    And Saya memasukkan MINIMUM SALARY "1" pada FORM CURRENCIES
#    When Saya memasukkan MAXIMUM SALARY "10" pada FORM CURRENCIES
#    And Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE
#    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field MAXIMUM SALARY "Should be higher than Minimum Salary"

  @PayGrades_Add_Succes  @Positive
  Scenario:Pengguna Berhasil Menambahkan Data PAY GRADES Baru
    When Saya menekan tombol ADD pada HALAMAN PAY GRADE
    And Saya memasukkan PAY GRADE "PG-07" pada FORM ADD PAY GRADE
    When Saya menekan tombol SAVE pada FORM ADD PAY GRADE
    And Saya menekan tombol ADD pada FORM CURRENCIES
    When Saya memilih CURRENCY mata uang "EUR - Euro" pada FORM CURRENCIES
    And Saya memasukkan MINIMUM SALARY "15000000" pada FORM CURRENCIES
    When Saya memasukkan MAXIMUM SALARY "18000000" pada FORM CURRENCIES
    And Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE
    Then FITUR TAMBAHKAN PAY GRADE menampilkan pesan Success "Successfully Saved"





