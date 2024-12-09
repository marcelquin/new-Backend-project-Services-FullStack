PROJETO

  Inspirado no projeto existente presente no link: https://github.com/marcelquin/mhqa_servicos, para fins de demonstrativo de conhecimento, visando também a melhoria de desempenho, melhor manutenção e ampliação do mesmo, adicionando ferramentas e metodologias novas ao projeto como micro serviço, eureka gateway, swagger, dentre outros.

MICRO SERVIÇOS

  Microsserviços é uma abordagem de desenvolvimento de software que consiste em dividir uma aplicação em pequenos serviços independentes que se comunicam por APIs, facilitando manutenção, melhorias e atualizações, podendo ou não ser direcionadas a um banco de dados individual.

SWAGGER

  Swagger é uma especificação aberta e um conjunto de ferramentas que permite a documentação e o desenvolvimento de APIs (Application Programming Interface), possibilitando testes facilitados, e melhor entendimento do sistema.

EUREKA GATEWAY

  Eureka e Gateway são ferramentas com funções diferentes em uma arquitetura de microsserviços: 
  
Eureka:
  É um serviço de descoberta que funciona como um catálogo de todos os serviços disponíveis em um sistema. Quando um microsserviço é iniciado, ele se registra no Eureka, informando sua localização e outros metadados. 
  
Gateway:
  É um sistema ou equipamento que estabelece a comunicação entre múltiplos ambientes. Ele pode ser usado para agregar APIs de múltiplos serviços, mas também agir como um “porteiro”, controlando o acesso aos recursos. 
  
O Eureka é uma ferramenta desenvolvida pela Netflix para seu framework Spring Cloud Netflix. O Zuul é um API Gateway que usa o Eureka para redirecionar as requisições para os serviços.

  Unificando e ocultando a porta original do micro serviço chamada, se atualizando automaticamente as atualizações e manutenções de seus serviços.


DOCUMENTAÇÃO

  Esta presente na pasta Doc os diagramas de funcionamento e entidades, para fins de entendimento e guia do proprio desenvolvimento do projeto, podendo ser ampliado ou alterado durante a execução do projeto.

FLUXO DE MICRO SERVIÇOS DO PROJETO

    Usando o gateway para direcionamento de rotas, assim como esta descrito na documentação graficamente, a portas originais são ocultadas e centralizadas pelo eureka gateway, assim sendo cada fluxo possui suas particularidades, podendo ou não ser chamada por outra parte do sistema para executar uma função conforme necessidade.

MS_CLIENTE

  Responsável pelo cadastro e manutenção das informações referentes a clientes, sendo chamado dinamicamente pelo fluxo de dados principal quando há necessidade de buscar, inserir, alterar ou deletar uma informação

MS_SERVICO

  Responsável pelo cadastro e manutenção das informações referente a serviços presentes no sistema, assim como os demais micro serviços sendo chamados dinamicamente, sendo salvo somente as informações necessárias no fluxo principal no processo de criação e gerencia das informações da ordem de serviço

MS_FINANCEIRO

  Responsável pela capitação de informação de forma dinâmica, monitorando valores, pagamentos e gerando relatórios financeiros a fim de mostrar uma visão da saúde financeira, em relatório de débitos e vendas realizadas, dando uma visão geral do dia, mês ou ano.
  Funciona de certo modo como um sistema de backup de informação, tendo em vista que o fluxo principal também salva no seu banco de dados porem sem informações adicionais.

MS_PAGAMENTO

  Responsável por gerir, confirmar, ou negar pagamento, simulando uma api externa de autorização de transação financeira, Retornando ao ms_financeiro a que por sua vez salva a informação para geração do relatório financeiro.

ECOMMERCE

  Originalmente o fluxo de dados principal, sendo separado nos serviços cada um com sua responsabilidade gerenciando suas próprias informações, atualmente este módulo digamos assim cuida somente do inicio da abertura da ordem de serviço podendo ou não buscar os dados no micro serviço cliente, buscando e retornando informações do micro serviço de serviços e seguindo seu fluxo até o fim e conclusão da ordem de serviço. Tendo somente esta única responsabilidade, chamando eventualmente os serviços conforme necessidade do processo.
  
