# language: pt

  @wip
  Funcionalidade: Comprar um produto
    Eu como usuário
    Gostaria de acessar a Swag Labs
    Gostaria de adquirir produtos com sucesso

  Cenário: Comprar o produto Sauce Labs Backpack
    Dado que eu esteja logado na swag labs
    Quando eu incluo o produto carrinho
    E eu efetuo o pagamento
    Então eu irei visualizar a mensagem "Thank you for your order!"