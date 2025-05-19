Feature: Search Employee

  Background:
    Given Saya membuka halaman Employee.

  @Employee_Search_Data_NotFound  @Negative
  Scenario: Sistem akan menampilkan tabel kosong, jika data Employee tidak ditemukan.
    When Saya memasukkan "BRI" di kolom pencarian EMPLOYEE NAME
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then tidak ada employee yang ditampilkan, serta muncul label bertuliskan "No Records Found"

#  @Employee_Search_Data_ColumnEmpty  @Negative
#  Scenario: Sistem menampilkan kembali keseluruhan data tabel employee.
#    When Saya menghapus kolom pencarian employee
#    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
#    Then tampilkan semua employee tabel data

  @Employee_Search_Data_Found_By_EmployeeName  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data employee name tersedia pada table employee.
    When Saya memasukkan "Pandu  Septiandito" di kolom pencarian EMPLOYEE NAME
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

  @Employee_Search_Data_Found_By_EmployeeID  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data employee id tersedia pada table employee.
    When Saya memasukkan "0001" di kolom pencarian EMPLOYEE ID
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

  @Employee_Search_Data_Found_By_JobTitle_And_EmployeeStatus  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data employee tersedia pada table employee.
    When Saya memilih EMPLOYEMENT STATUS "Associate" di kolom pilihan EMPLOYEMENT STATUS
    And Saya memilih JOB TITLE "Software Engineer" di kolom pilihan JOB TITLE
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

  @Employee_Search_Data_Found_By_JobTitle_And_EmployeeName  @Positive
  Scenario: Sistem menampilkan hasil pencarian, jika data employee tersedia pada table employee.
    When Saya memasukkan "Riku" di kolom pencarian EMPLOYEE NAME
    And Saya memilih JOB TITLE "Software Engineer" di kolom pilihan JOB TITLE
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

  @Employee_Search_Incremental_Filter_Combination @Positive
  Scenario:  Incremental Employee Search Functionality
    When Saya memasukkan "Riku" di kolom pencarian EMPLOYEE NAME
    When Saya memilih JOB TITLE "Software Engineer" di kolom pilihan JOB TITLE
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    When Tanpa Reset,Saya kembali memasukkan "Jhonny" di kolom pencarian EMPLOYEE NAME
    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"

