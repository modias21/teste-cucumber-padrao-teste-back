#language: pt

Funcionalidade: Criar um teste exemplo

  @Teste
  Cenario: Criar um teste exemplo para demonstração
    Dado que eu precise criar um testes exemplo
    Quando criar o codigo do teste
    Então apresentar o resultado para todos

  @TesteNegativo
  Cenario: Criar um teste exemplo para demonstração de teste negativo
    Dado que eu precise criar um testes exemplo
    Quando criar o codigo do teste negativo
    Então apresentar o resultado negativo

  @TesteMensagem
  Cenario: Criar um teste exemplo para demonstração de parâmentro errado
    Dado que eu precise criar um testes exemplo
    Quando criar o codigo do teste para validar a mensagem
    Então apresentar status code 400 uma mensagem "String 'teste' was not recognized as a valid Boolean."