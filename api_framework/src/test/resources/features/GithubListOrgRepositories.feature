Feature: Get List of Organization Repositories End Point
  This feature file contains test scenarios for List organization repositories
	
	@smoke	
	@regression
  Scenario: Get All organization repositories
    Given Header has "Authorization" with value "Bearer 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"    
    When I execute "GET" request    
    Then I verify statuscode is 200    
  
  @regression
  @p1
  Scenario: Get All organization private repositories
    Given Header has "Authorization" with value "Bearer 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"  
    And Query param "type" is "private"  
    When I execute "GET" request    
    Then I verify statuscode is 200
  
  @regression  
  @p2
  Scenario Outline: Get All organization repositories with multiple params
    Given Header has "Authorization" with value "<auth>"  
    And Query param "type" is "<type>"  
    And Query param "per_page" is "<per_page>"
    When I execute "GET" request    
    Then I verify statuscode is <status_code>
    
  Examples:
  	|auth|type|per_page|status_code|
  	|Bearer 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|private|5|200|
  	|Bearer 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|private||200|
  	|Bearer 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|public|5|200|
  	
  	
  	
  	