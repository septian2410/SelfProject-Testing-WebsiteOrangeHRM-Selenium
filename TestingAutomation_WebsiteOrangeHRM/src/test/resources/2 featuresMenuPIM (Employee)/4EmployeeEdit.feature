Feature: Edit Employee

  Background:
    Given Saya telah mengakses bagian Employee.

  @Employee_Edit_Failed_FieldEmpty  @Negative
  Scenario: Pengguna Gagal Mengubah Data Employee, karena kolom first name employee dikosongkan.
    And Saya menekan tombol EDIT, pada employee bernama "TESTER2"
    When Saya menghapus first name pada kolom FIRST NAME
    When Saya menekan tombol SAVE pada FORM PERSONAL DETAILS
    Then FITUR EDIT EMPLOYEE menampilkan label pesan error pada kolom FIRST NAME yaitu "Required"

  @Employee_Edit_Prefill_Validation  @Positive
  Scenario: Verifikasi bahwa data yang dipilih otomatis terisi pada formulir edit tanpa perlu dikirimkan.
    And Saya menekan tombol EDIT, pada employee bernama "TESTER2"
    Then Data "TESTER2" berhasil terisi otomatis pada FORM EDIT EMPLOYEE sesuai data pada tabel employee.

  @Employee_Edit_Succes_WithoutChange  @Positive
  Scenario: Pengguna Berhasil Mengubah Data Employee, dengan nama Employee baru
    And Saya menekan tombol EDIT, pada employee bernama "TESTER2"
    When Saya menekan tombol SAVE pada FORM PERSONAL DETAILS
    Then Data tidak mengalami perubahan serta, FITUR EDIT EMPLOYEE berhasil menampilkan pesan "Successfully Updated"

  @Employee_Edit_Succes  @Positive
  Scenario: Pengguna Berhasil Mengubah Data Employee, dengan nama Employee baru
    And Saya menekan tombol EDIT, pada employee bernama "TESTER2"
    When Saya memasukkan FIRST NAMA EMPLOYEE BARU yaitu "TESTER2 UPDATE" pada kolom inputan Employee Name
    And Saya memasukkan LAST NAMA EMPLOYEE BARU yaitu "Data Update" pada kolom inputan Employee Name
    When Saya memasukkan EMPLOYEE ID BARU yaitu "0020" pada kolom inputan Employee ID
    And Saya memasukkan OTHER ID BARU berupa NO NIK yaitu "3175020101010001 " pada kolom inputan Other ID
    When Saya mengatur tanggal LICENSE EXPIRY DATE Yaitu "2028-05-15" pada FORM PERSONAL DETAILS
    And Saya memasukkan DRIVER'S LICENSE NUMBER BARU yaitu "9876543210987654" pada kolom inputan Driver's License Number
    When Saya mengatur NATIONALITY yaitu "Indonesian" pada FORM PERSONAL DETAILS
    And Saya mengatur MARITAL STATUS yaitu "Single" pada FORM PERSONAL DETAILS
    When Saya mengatur DATE OF BIRTH pada tanggal "2000-05-20" pada FORM PERSONAL DETAILS
    And Saya memilih Gender Male pada FORM PERSONAL DETAILS
    When Saya menekan tombol ADD ATTACHMENT, kemudian mengupload file bernama "Document Pribadi.pdf" sebagai dokumen probadi
    And Saya menambahkan COMMENT "Ini Adalah Dokumen Pribadi" pada kolom inputan Comment
    And Saya menekan tombol SAVE ADD ATTACHMENT pada FORM PERSONAL DETAILS
    When Saya menekan tombol SAVE pada FORM PERSONAL DETAILS
    And Saya menekan Sub menu JOB DETAILS
    When Saya mengatur waktu JOINED DATE pada tanggal "2024-10-20" pada FORM JOB DETAILS
    And Saya memilih JOB DETAILS "DevOps Engineer" pada FORM JOB DETAILS
    When Saya memilih JOB CATEGORY "IT & Software Development" pada FORM JOB DETAILS
    And Saya memilih EMPLOYMENT STATUS sebagai "Associate" pada FORM JOB DETAILS
    When Saya menekan tombol SAVE pada FORM JOB DETAILS

    Then Data mengalami perubahan serta, FITUR EDIT EMPLOYEE berhasil menampilkan pesan "Successfully Updated"

