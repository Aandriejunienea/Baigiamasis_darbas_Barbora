
![](projectPictures/barbora.png)
## Automation tests for www.barbora.lt

#### Link to the page [Barbora](https://barbora.lt/) <br><br>

#### Packages used
- TestNG `org.testng:testng`
- Selenium `org.seleniumhq.selenium:selenium-java`
- WebDriverManager `io.github.bonigarcia:webdrivermanager`


## Test cases
### Registration
__Test 1 (testSuccessfulRegistration)__
1. Open page and click "Registruotis"
2. Click "Registruotis su el.paštu"
3. Input "Vardas ir Pavardė" (Akvile Pavarde)
4. Input "El.pašto adresas" (demo@gmail.com)
5. Input "Slaptažodis" (Slaptazodis!123)
6. Input "Telefono numeris" (61234567)
7. Click "Testi"
8. Click "Gatvė ir namo numeris"
9. Input "Gatvė ir namo numeris" (Vilneles 3)
10. Click (Vilnelės g. 3, 11346 Vilnius)
11. Click "Testi"
12. Click "Susipažinau ir sutinku su pirkimo taisyklėmis ir privatumo politika"
13. Click "Registruotis"

Expected result: The new profile is successfully created, and the home page opens. 
The text "Your cart is empty" is displayed.

__Test 2 (testUnsuccessfulRegistrationWithDuplicateEmail)__
1. Open page and click "Registruotis"
2. Click "Registruotis su el.paštu"
3. Input "Vardas ir Pavardė" (Akvile Pavarde)
4. Input "El.pašto adresas" (demo@gmail.com)
5. Input "Slaptažodis" (Slaptazodis!123)
6. Input "Telefono numeris" (61234567)
7. Click "Testi"

Expected result: An error message is displayed: "Šis el. pašto adresas jau registruotas BARBOROJE". 

### Login
__Test 1 (testSuccessfulLogin)__
1. Open page and click "Prisijungti"
2. Input "El.pašto adresas" (demo@gmail.com)
3. Input "Slaptažodis" (Slaptazodis!123)
4. Click "Prisijungti su el.paštu"

Expected result: The user successfully logs in and the home page opens.
The text "Your cart is empty" is displayed.

__Test 2 (testUnsuccessfulLogin)__
1. Open page and click "Prisijungti"
2. Input "El.pašto adresas" (DataProvider)
3. Input "Slaptažodis" (DataProvider)
4. Click "Prisijungti su el.paštu"

Expected result: An appropriate error message is displayed.

#### Data-Driven Testing
We use a DataProvider to test multiple input scenarios.
Each test case uses predefined data combinations to verify application behavior under different conditions. <br>
The DataProvider ensures coverage of:
- Invalid credentials.
- Missing fields.

#### DataProvider Scenarios
| el. pašto adresas | Slaptažodis     | Expected Error Message                           |
|-------------------|-----------------|--------------------------------------------------|
| demogmail.com     | Slaptazodis!123 | "Įvesk el. pašto adresą"                         |
| demo@gmail        | Slaptazodis!123 | "Įvesk el. pašto adresą"                         |
| @gmail.com        | Slaptazodis!123 | "Įvesk el. pašto adresą"                         |
| demogmail         | Slaptazodis!123 | "Įvesk el. pašto adresą"                         |
| -                 | Slaptazodis!123 | "Įvesk el. pašto adresą"                         |
| -                 | -               | "Įvesk el. pašto adresą"                         |
| demogmail.com     | Slaptazodis     | "Įvesk el. pašto adresą"                         |
| demo@gmail.com    | -               | "Įvesk slaptažodį"                               |
| demo@gmail.com    | Slaptazodis     | "Neteisingas el. pašto adresas arba slaptažodis" |
| demo@gmail.com    | Slaptazodis!123 | "Neteisingas el. pašto adresas arba slaptažodis" |


### Profile editing
__Test 1 (testProfileDataEditingChangePavarde)__
1. Open page and Login
2. Hover over the dropdown menu located in the navigation bar "Akvile"
3. Click on "Mano nustatymai" when the dropdown list appears
4. Click on text field "Pavardė" and delete "Pavarde"
5. Input "Andriejuniene"
6. Click "Saugoti"
7. Click "Patvirtinti"
8. Click "Uždaryti"

Expected result: The surname is successfully changed.

### Delete account
__Test 1 (testAccountDeletion)__
1. Open page and Login
2. Hover over the dropdown menu located in the navigation bar "Akvile"
3. Click on "Mano nustatymai" when the dropdown list appears
6. Click "Pašalinti"
7. Click "Patvirtinti"

Expected result: The account was successfully deleted, and a notification message appears:
"Jūsų vartotojo duomenys yra sėkmingai pašalinti".

