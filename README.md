# API para cálculo de divisão de contas
Esta API é composta de URLs para cadastro de produtos, 
valores e participantes em alguma transação comercial em que o valor precisa ser dividido, além de despesas e 
descontos em comum a todos os participantes da transação. Após o cadastro de todos os valores da transação terem 
ocorrido, é possível gerar um totalizador que dividirá o valor final que cada participante deverá pagar, com os
descontos ou despesas em comum aplicados para cada participante proporcionalmente ao valor pago do total da 
transação.

##Modelo de persistência
* Os dados utilizados para o cálculo dos totais são persistidos em um banco de dados SQL. Para praticidade,
nesta solução, é utilizado um banco de dados H2, que cria as entidades em memória enquanto a aplicação estiver
rodando. Os dados são apagados caso a aplicação seja reiniciada. O banco pode ser acessado, usando a senha e 
login padrão, pelo endereço http://localhost:8080/h2-ui .

##Geração do link de pagamento
* O modelo de estrutura da geração do link de pagamento é o mesmo da API disponibilizada pelo PicPay em:
  https://picpay.github.io/picpay-docs-digital-payments/checkout/resources/api-reference/
* As entidades de request e response e a chamada REST para a API externa (na package Integration) são uma
simplificação do sistema de cadastramento de links do PicPay, apenas com os campos obrigatórios.
* A aplicação está configurada para chamar um método mock que está dentro dela própria
(integration/mock/CobrancaPicPayClientMock), e que cria um link imaginário para ser mostrado para o usuário.
* Para utilizar a geração de links de pagamento, o usuário necessita cadastro no PicPay e a geração de dois
tokens de autenticação, enviados no header do request. Nesta solução, subentende-se que o usuário do
aplicativo informa seus tokens de autenticação do PicPay ao se logar. Os tokens são enviados mockados quando
o request é feito pelo frontend.
* O CPF do pagador, no link do PicPay, é um campo obrigatório. Para manter a fidelidade, nesta aplicação o
usuário também deverá informar um CPF para cada pagador para quem deseja gerar o link.

##Frontend
* O frontend é uma página html com javascript embedado (em resources/templates/index.html). Para utilizar, com
a aplicação rodando, acessar o localhost:8080.
* O html está dentro do projeto por praticidade e, apesar disso, o frontend e o backend estão totalmente desacoplados,
visto que o backend não tem conhecimento sobre aspecto nenhum do frontend, e pode ser chamado por qualquer tipo de
programa que faça requests para suas URLs.
* Todas as entidades de uma única transação estão ligadas por um Id de transação em comum, para que façam parte do
mesmo cálculo de totais. No frontend, é passado um id de transação fixo ("1"). Por isso, se for necessário mais um
teste, com um cálculo novo de totais, a aplicação precisa ser reiniciada.
