Feature: Search User

  Background:
    Given Saya membuka halaman User.

  @User_Search_Data_NotFound_By_Username  @Negative
  Scenario: Sistem akan menampilkan tabel kosong, jika data User tidak ditemukan.
    When Saya memasukkan "BRI" di kolom pencarian USERNAME
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then tidak ada USER yang ditampilkan, serta muncul label bertuliskan "No Records Found"

  @User_Search_Data_Can't_Interact_By_EmployeeNameInvalid  @Negative
  Scenario: Sistem tidak melakukan pencarian data,karena Employee name tidak valid
    When Saya memasukkan "BRI" di kolom pencarian EMPLOYEE NAME pada HALAMAN USER MANAGEMENT
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then tidak ada USER yang ditampilkan, serta muncul label error Employee Name "Invalid"

  @User_Search_Data_Found_By_Username  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data Username tersedia pada table USER.
    When Saya memasukkan "pandu123" di kolom pencarian USERNAME
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then FITUR SEARCH USER berhasil menampilkan data pencarian "(1) Record Found"

#  @User_Search_Data_Found_By_EmployeeName  @Positive
#  Scenario: Sistem menampilkan hasil pencarian, jika data Employee Name tersedia pada table USER.
#    When Saya memasukkan "Jhonny  Don" di kolom pencarian EMPLOYEE NAME pada HALAMAN USER MANAGEMENT
#    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
#    Then FITUR SEARCH USER berhasil menampilkan data pencarian "(1) Record Found"
#
  @User_Search_Data_Found_By_Username_And_UserRole  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data Username tersedia pada table USER.
    When Saya memasukkan "pandu123" di kolom pencarian USERNAME
    And Saya memilih USER ROLE "Admin" di kolom pilihan USER ROLE
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then FITUR SEARCH USER berhasil menampilkan data pencarian "(1) Record Found"

  @User_Search_Data_Found_By_Username_And_StatusUser  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data Username tersedia pada table USER.
    When Saya memasukkan "employee2" di kolom pencarian USERNAME
    And Saya memilih STATUS USER "Enabled" di kolom pilihan STATUS USER
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then FITUR SEARCH USER berhasil menampilkan data pencarian "(1) Record Found"

  @User_Search_Incremental_Filter_Combination @Positive
  Scenario:  Incremental User Search Functionality
    When Saya memasukkan "employee2" di kolom pencarian USERNAME
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    When Tanpa Reset,Saya kembali memasukkan "pandu123" di kolom pencarian USERNAME
    And Saya memilih USER ROLE "Admin" di kolom pilihan USER ROLE
    And Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

