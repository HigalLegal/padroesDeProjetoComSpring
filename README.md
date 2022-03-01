# Explorando Padrões de Projetos na Prática com Java
Desafio da plataforma educacional open-source da Digital Innovation One, onde pude compreender os famosos padrões de projetos com o framework Spring. Nele, fiz uma API de cadastro de cliente com o cep, onde fiz também uso da API externa do ViaCEP. Para o consumo dessa API feita, fiz uso do Swagger (OpenAPI). Os padrões de projetos praticados foram:
* <strong>Singleton</strong> através da anotação <strong>@Autowired</strong> .
* <strong>Strategy</strong> através das anotações <strong>@Service</strong> e <strong>@Repository</strong> .
* <strong>Facade</strong> análoga a própria API Rest feita e também na camada de serviço, que é onde se cria as regras de negócio, tratamento de exceções, entre outras coisas.