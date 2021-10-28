Feature: Create Repository under the organization end point
  This endpoint is used for creating repositories under an org
		
	# This scenario is with valid token and existing repo name
	@smoke
	@regression
	@createrepo
  Scenario Outline: Create a github repository positive
    Given Header has "Authorization" with value "<token>"   
    And Input JSON contains "<Repo_Name>","<description>","<private>"
    When I execute "POST" request    
    Then I verify statuscode is <status_code>
    And I verify response body contains "<Repo_Name>","<description>","<private>"
    
	Examples:
  |token|Repo_Name|status_code|description|private|  
  |Bearer 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|auto_repo_001|201|This is repo1|false|
  |Bearer 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|auto_repo_002|201|This is repo2|true|  
		
	# This scenario is with valid token and existing repo name
  Scenario Outline: Create a github repository negative
    Given Header has "Authorization" with value "<token>"   
    And Input JSON contains "<Repo_Name>","<description>","<private>"
    When I execute "POST" request    
    Then I verify statuscode is <status_code>
      
  Examples:
  |token|Repo_Name|status_code|description|private|    
  |Bearer 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|auto_repo_001|422|This is repo1|false|
  |Bearer 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|auto_repo_003|401|This is repo3|false|
  |Bearer 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|auto_repo_004|403|This is repo4|false|       