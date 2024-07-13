Feature: User Login

  Scenario: Successful login
    Given the user is on the nop commerce login page
    When the user enters the valid credentials (username: "testing@gmail.com", password: "test@1234")
    And the user clicks on the login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
