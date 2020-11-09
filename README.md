# Selenide: Automação de ponta a ponta em Java 

## Ambiente de Testes
 - Tarefa: Instale o Docker no seu PC
    > Instalação do Docker no Kubuntu 
 - Ambiente Ninja+
    > Configuração da rede do Docker, Configuração da API e Configuração do Sistema.
 
 ## Introdução ao Selenide
 - Iniciando com TestNG
   > Framework de teste inspirado no JUnit e NUnit, Configurações flexíveis, Anotações e/ou Data providers e Instalação do TestNG via Maven.
 - Hello Selenide
   > Instalaçao do Selenide via Maven, Instalação do Selenium Java via Maven, Configurações iniciais do Selenide. 
 - Preenchendo formulários automaticamente
   > Buscando elementos, Preenchendo campos e Eventos.
 - Selenide x WebDriver
   > O Selenide possui uma abstração e uma simplificação em sua utilização e em sua configuração.
 - Automatizando fluxos alternativos
   > Implementação de vários cenários de login
 - Data-driven testing
   > Dados com o mesmo comportamento, a diferença está na entrada e saida dos dados.
     Com o Data provider existe um reaproveitamento do código utilizado facilitando e unificando a massa de dados.
     E mantendo a qualidade do codigo.
 ~~~java
        @DataProvider(name = "login-alerts")
        public Object[][] loginProvider() {
            return new Object[][]{
                    {"klebernascimento@outlook.com.br", "123456", "Usuário e/ou senha inválidos"},
                    {"404@404.com", "pwd123", "Usuário e/ou senha inválidos"},
                    {"klebernascimento@outlook.com.br", "", "Opps. Cadê a senha?"},
                    {"", "pwd123", "Opps. Cadê o email?"}
            };
        }
 ~~~
## Avançando na Automação
 - Padrão Page Objects
   > Adição de mais um camada que fará o encapsulamento das iterações com a pagina web.
   > Para cada pagina web/ou componente haverá uma classe java.
   ~~~java
    public class LoginPage {
    // Atributos e Metodos de interação com a pagina login
    }
   ~~~
   
      ~~~java
       public class LoginTests {
       // Atributos e Metodos de teses
       }
      ~~~
 - Nova feature do Ninja+
   > Criando uma classe para acessar recursos da pagina web. Preenchendo os campos do cadastro de filmes.
 - Evoluindo código de testes
   > Criando a classe BaseTest para ser utilizada em outras classes com herança.
 - Buscando e filtrando WebElements
   > Buscando e retornando uma lista de elementos com $$.
      ~~~java
       $$("ul li span")
      ~~~
 - Array de tags
 > Preenchendo os campos ano de lançamento, data de lançamento, atores e sinopse do filme.
   Usando ações do teclado, no exemplo foi o uso do TAB.
 - Modelando massa de teste 
 > Criando uma classe Model com atributos e construtor para a massa de dados.
 - Incrementando a massa de teste
#### Tecnologias utilizadas:
> Docker, Kubuntu, TestNG, Selenium, Maven, Selenide, Java.