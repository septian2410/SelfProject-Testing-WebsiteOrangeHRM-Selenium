Feature: LOGIN ADMIN

Background:
Given saya membuka halaman login pada Web Admin OrangeHRM

@Admin_Login_Failed_FieldEmpty @Negative
Scenario: Pengujian Login tanpa memasukkan username dan password
When saya langsung menekan tombol login
Then tampil label validasi "Required" pada inputan kosong username halaman login

@Admin_Login_Failed_KredensialInvalid @Negative
Scenario: Pengujian Login dengan Akun yang Tidak Terdaftar
And saya memasukkan username "pandu123"
And saya memasukkan password "qwerty123"
When saya menekan tombol login
Then tampil label validasi "Invalid credentials" pada halaman login

@Admin_Login_Succes  @Positive
Scenario: Pengujian Login dengan Kredensial valid dengan diberikan permission
And saya memasukkan username "pandu123"
And saya memasukkan password "12345qwert#B!24"
When saya menekan tombol login
Then tampil halaman Dashboard OranngeHRM dengan copyright "OrangeHRM OS 5.7"



