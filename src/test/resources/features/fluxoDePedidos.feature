# language: pt

  Funcionalidade: API - Pedidos

    Cenário: Listar pedidos
      Quando for solicitação a requisição de listagem
      Então deverá retornar os pedidos com sucesso

    Cenário: Criar pedido
      Quando for solicitada a criação de um pedido
      Então deverá ser criado com sucesso