### MENU PIM ###

## SubMenu Employment Fitur

# FITUR SEARCH

* Case Search Not Found 
* fldEmployment = BRI

* Case Search Found Column Empty

* Case Search Found By EmploymentName
* fldEmploye =  Pandu  Septiandito

* Case Search Found By EmployeeId
* fldEmployeId = 0001

* Case Search Found By JobTitle And EmployeStatus
* drpDownEmploymentStatus = Associate
* drpDownJobTitle = Software Engineer

* Case Search Found By JobTitle And EmployeName
* fldEmploye = Riku
* drpDownJobTitle = Software Engineer

* Case Search Incremental Combination
* Step 1
* fldEmploye = Riku
* drpDownJobTitle = Software Engineer
* Step 2
* fldEmploye = Jhonny

# FITUR RESET

* Reset Succes 
* fldEmploye = BRI

# FITUR ADD

* Case Add Failed By FieldEmpty (?)
* Case Add Failed By Id Already Exists
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0001

* Case Add Failed Canceled
* Case Add Failed Passwordtooshort
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0014
* fldUsername = TESTER123
* fldPassword = 12345
* fldConfPassword = 12345

* Case Add Failed PasswordMissingUpperCase
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0014
* fldUsername = TESTER123
* fldPassword = 12345qwertZ
* fldConfPassword = 12345qwertZ

* Case Add Failed PasswordIsGuessable
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0014
* fldUsername = TESTER123
* fldPassword = 12345qwertZ!75
* fldConfPassword = 12345qwertZ!75

* Case Add Failed PasswordNotMatch
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0014
* fldUsername = TESTER123
* fldPassword = 12345qwertZ!75
* fldConfPassword = 12345qwertZ!74

* Case Add Success With Login Details
* btnUploadImage = dummy-profile-pic.jpg
* fldFirstName = TESTER1
* fldLastName = QA1
* fldEmployeId = 0014
* fldUsername = TESTER123
* fldPassword = 12345qwert#N!24
* fldConfPassword = 12345qwert#N!24

* Case Add Success
* fldFirstName = TESTER2
* fldLastName = QA2
* fldEmployeId = 0015

# FITUR EDIT

* Case Edit Failed By FieldEmpty (FirstName) (TESTER2)
* Case Edit Prefill (TESTER2)
* Case Edit Succes Without Change (TESTER2)

* Case Edit Succes (TESTER2)
* fldFirstName = TESTER2 UPDATE
* fldLastName = Data Update
* fldEmployeId = 0020
* fldOtherId = 3175020101010001
* fldDateLicense = 2028-05-15
* fldLicense = 9876543210987654
* drpDownNationality = Indonesian
* drpDownMarital = Single
* fldDateBirth = 2000-05-20
* btnAttachment = dummy-profile-pic.jpg
* fldComment = Ini Adalah Dokumen Pribadi
* fldJoinedDate = 2024-10-20
* drpDownJobDetails = DevOps Engineer
* drpDownJobCategory = IT & Software Development
* drpDownEmploymentStatus = Associate

# FITUR DELETE 

* Case Delete Failed Canceled (TESTER2 UPDATE)
* Case Delete Succes (TESTER2 UPDATE)