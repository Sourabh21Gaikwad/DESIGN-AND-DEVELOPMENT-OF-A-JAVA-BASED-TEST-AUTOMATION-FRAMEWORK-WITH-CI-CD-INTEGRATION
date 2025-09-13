Feature: Admin login functionality

  Scenario: Check records in Admin dashboard
    When I navigate to the dashboard
    Then enter the username "Aadhi04"
    And enter the employee name "Peter Anderson"
    Then click on the search button