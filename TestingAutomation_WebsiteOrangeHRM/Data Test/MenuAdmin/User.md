### Menu Admin ##

## SubMenu User Fitur

# Fitur Search

* Case Search Not Found By Username 
* fldUsername = BRI


* Case Search Not Found Can't Interact, Employee name invalid
* fldEmployee = BRI


* Case Search Found By Username
* fldUsername = pandu123


* Case Search Found By Employee name
* fldEmployee = Jhonny  Don


* Case Search Found By Username & UserRole
* fldUsername     = pandu123
* drpDownUserRole = Admin


* Case Search Found By Username & StatuUser
* fldUsername     = employee2
* drpDownUserRole = Enabled


* Case Search Found Incremental Combination (Without Reset)
* Step 1
* Search by Username
* fldUsername = employee2
* Step 2
* Search by Username & UserRole
* fldUsername = pandu123
* fldUsername = Admin

# Fitur RESET

* Case Reset Succes
* fldUsername = BRI

# Fitur ADD

* Case Add Failed By FieldEmpty (EmployeeName)
* Case Add Failed BY Canceled

* Case Add Failed By Password Too Short
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345
* fldConfPassword = 12345


* Case Add Failed By PasswordMissingUpperCase
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwert
* fldConfPassword = 12345qwert


* Case Add Failed By PasswordMissingSpecialCharacter
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwertZ
* fldConfPassword = 12345qwertZ


* Case Add Failed By PasswordIsGuessable 
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwertZ!75
* fldConfPassword = 12345qwertZ!75


* Case Add Failed By PasswordNotMatch 
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwertZ!75
* fldConfPassword = 12345qwertZ!74


* Case Add Failed By EmployeeInvalid
* fldEmployee = Rino
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwertZ!75
* fldConfPassword = 12345qwertZ!74


* Case Add Succes 
* fldEmployee = Dummy  User Data
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled
* fldPassword = 12345qwert#N!24
* fldConfPassword = 12345qwert#N!24

# Fitur EDIT

* Case Edit Failed Canceled
* Case Edit Failed EmptyField (fldUsername)


* Case Edit Failed UsernameTooShort (USER321)
* fldUsername = TEST
* drpDownUserRole = Admin
* drpDownStatusUser = Disabled


* Case Edit Failed Employment Invalid (USER321)
* fldUsername = TESTER123Update
* fldEmployment = FATIMA
* drpDownUserRole = Admin
* drpDownStatusUser = Disabled


* Case Edit Prefill (USER321)


* Case Edit Success (USER321)
* fldUsername = TESTER123Update
* drpDownUserRole = Admin
* drpDownStatusUser = Disabled
* fldPassword = 12345qwert#N!300
* fldConfPassword = 12345qwert#N!300


* Case Edit Success Change Password (TESTER123Update)
* fldUsername = USER321
* drpDownUserRole = ESS
* drpDownStatusUser = Enabled

# Fitur Delete


* Case Delete Failed Canceled (USER321)
* Case Delete Success (USER321)
