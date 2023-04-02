Feature: Post Creation

  Scenario Outline: Add a post
    Given user is on application
    When user do login with "<userName>" and "<password>"
    And user add article
    Then verify article gets added

    Examples:
      | userName            | password   |
      | sonam6948@gmail.com | March@1234 |

  Scenario Outline: Unique article title warning message
    Given user is on application
    When user do login with "<userName>" and "<password>"
    And user adds article with already used "<articleTitle>"
    Then verify warning should display as "<warning>"

    Examples:
      | userName            | password   |articleTitle| warning|
      | sonam6948@gmail.com | March@1234 |Playwright  |title must be unique|

  Scenario Outline: edit article
    Given user is on application
    When user do login with "<userName>" and "<password>"
    And user add article for edit
    And user edits article
    Then verify article gets updated

    Examples:
      | userName            | password   |
      | sonam6948@gmail.com | March@1234 |

  Scenario Outline: add articles to favorite
    Given user is on application
    When user do login with "<userName>" and "<password>"
    And user add article
    And user add article to favorites
    Then verify article gets added to favorites

    Examples:
      | userName            | password   |
      | sonam6948@gmail.com | March@1234 |

