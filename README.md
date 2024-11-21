PROJETO

  Com função de adicionar melhorias em projeto existente presente no link: https://github.com/marcelquin/mhqa_servicos, para fins de demonstrativo de conhecimento, visando também a melhoria de desempenho para uma escala de uso maior.

DOCUMENTAÇÃO

  Esta presente na pasta Doc os diagramas de funcionamento e entidades, para fins de entendimento e guia do proprio desenvolvimento do projeto, podendo ser ampliado ou alterado durante a execução do projeto

MICRO SERVIÇOS

  Sistemas separados sendo chamados dinamicamente pelo fluxo principal, sendo roteada pelo gateway recebendo e enviando informações, deixando a conexão desacoplada, mais leve e fluida, para um melhor desempenho, manutenção e melhorias.

MS_CLIENTE

  Responsável pelo cadastro e manutenção das informações referentes a clientes, sendo chamado dinamicamente pelo fluxo de dados principal quando há necessidade de buscar, inserir, alterar ou deletar uma informação

MS_SERVICO

  Responsável pelo cadastro e manutenção das informações referente a serviços presentes no sistema, assim como os demais micro serviços sendo chamados dinamicamente, sendo salvo somente as informações necessárias no fluxo principal no processo de criação e gerencia das informações da ordem de serviço

MS_FINANCEIRO

  Responsável pela capitação de informação de forma dinâmica, monitorando valores, pagamentos e gerando relatórios financeiros a fim de mostrar uma visão da saúde financeira, em relatório de débitos e vendas realizadas, dando uma visão geral do dia, mês ou ano.
  Funciona de certo modo como um sistema de backup de informação, tendo em vista que o fluxo principal também salva no seu banco de dados porem sem informações adicionais.

MS_PAGAMENTO

  Responsável por gerir, confirmar, ou negar pagamento mediante inicialmente randômico booleano nos casos de compras no débito, ou crédito, simulando uma api externa de autorização de transação financeira.
  Retornando ao ms_financeiro a que por sua vez salva a informação mediante retorno true para geração do relatório financeiro.

  
