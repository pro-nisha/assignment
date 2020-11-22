Feature: Confirm whether a visa is required to visit the UK

  Scenario Outline: Verify whether a visa is required for Japan Nationality to visit the UK for Study
    Given I provide a nationality of "<Nationality>"
    And I select the reason "<Reason>"
    And I state I am intending to stay for more than "<NumberOfMonth>" months
    When I submit the form
    Then I will be informed "<Result>"

    Examples:
    |Nationality||Reason||NumberOfMonth||Result|
    |japan|      |Study||6| |You do not need a visa to come to the UK|
    |japan|      |Study||7| |You’ll need a visa to study in the UK|

   Scenario Outline: Verify whether a visa is required for Japan Nationality to visit the UK for Tourism
    Given I provide a nationality of "<Nationality>"
    And I select the reason "<Reason>"
    When I submit the form
    Then I will be informed "<Result>"
    Examples:
       |Nationality||Reason||Result|
       |japan| |Tourism| |You do not need a visa if you’re staying up to 6 months|

   Scenario Outline: Verify whether a visa is required for Russia Nationality to visit the UK for Tourism
       Given I provide a nationality of "<Nationality>"
       And I select the reason "<Reason>"
       And I state I am not travelling or visiting a partner or family "<option>"
       When I submit the form
       Then I will be informed "<Result>"
       Examples:
          |Nationality||Reason||option||Result|
          |russia| |Tourism||no| |You’ll need a visa to come to the UK|



