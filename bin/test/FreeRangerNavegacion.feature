@Navigation
Feature: Navigation bar
 To see the subpages
 Without logging in
 I can click the navigation bar links

 Rule: The user can retuiurn values from the table and validate them.
 
    Background: I am on the Free Range Testers web without logging in.
       Given I navigate to www.freerangetesters.com
    
    # Scenario: I can access the subpages through the navigation bar 
    #     Given I navigate to www.freerangetesters.com
    #     When I go to a section using the navigation bar

    # con el outline sig q le voy a poder pasar 1 tabla de ejemplos
    # Scenario Outline: I can access the subpages through the navigation bar 
    #     # Given I navigate to www.freerangetesters.com
    #     When I go to <section> using the navigation bar
    #     Examples:
    #         | section | 
    #         | Cursos |
    #         | Recursos | 
    #         | Blog |
    #         | Mentorías | 
    #         | Udemy | 

    @Courses
    Scenario: Courses are presented correctly to potential customers
        # Given I navigate to www.freerangetesters.com
        When I go to Cursos using the navigation bar
        And The user selects Introducción al Testing

    # Scenario: Users validate the page
    #     When I select Elegir Plan
    #     Then I can validate that the image is displayed

    @Plans @Courses 
    Scenario: Users can select a plan when signing up
        # Given I navigate to www.freerangetesters.com
        When I select Elegir Plan
        Then The client can validate the options in the checkout page
        And I add the email and click on the Continue button


    