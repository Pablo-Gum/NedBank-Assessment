Feature: Nedbank Assessment to book an Appointment with CURA Healthcare Service

  Scenario: Appointment with Hospital readmission

    Given User launches a browser and navigates to the Cura Health Service webPage
    When  user enters Username and Password and clicks on the login button
    Then user is logged in successfully and make Appointment Page is opened

    When user makes an Appointment
    Then user booked an Appointment and appointment Confirmation Page is opened
    When user clicks on go to Home page button
    Then user is on the home page
    When user clicks on the menu toggle
    And user clicks on the logout button
    Then user is logged out successfully

