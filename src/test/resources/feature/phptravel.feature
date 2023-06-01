
Feature: Desafio de cucumber, selenium e java
  Desafio proposto para avaliar conhecimento adquiridos ao longo de estudos online.
  A prosta é:
  Exercício para prática dos itens documentados na primeira avaliação + itens aprendidos no curso de Cucumber/BDD
	Link do site: https://phptravels.com/demo/
	Cenário: 0001 - Requisitar demonstração do site
		Passos:
		- Preencher valores para o campo de "First Name", "Last Name", "Business Name", e "Email";
		- Realizar a operação de soma para o campo de validação e preenche-lo;
		- Clicar no botão "SUBMIT";
  
	@#001
  Scenario: Requisitar demonstração do site
    Given Estar no site https://phptravels.com/demo/
    And preencher o campo First Name
    And preencher o campo Last Name
    And preencher o campo Business Name
    And preencher o campo e-mail
    When Digitar a soma apresentada
    And Clicar no botão Submit
    Then Validar o Agradecimento 

