# Desafio-basico-be

O desafio consiste em cadastro e busca de pessoa contendo ,
- Nome
- Data Nascimento
- CEP
- Documento

Caso CEP seja inválido retorna um erro amigavel.

Caso tudo esteja correto é armazenado no banco de dados os seguintes dados:
Nome do usuario
-Idade
-Localidade
-Bairro
-uf
-Documento

# Tecnologias

- Java8+
- Spring Boot
- Maven
- Git
- MongoDB

# Endpoints
curl --location --request GET 'http://localhost:8080/pessoa/
curl --location --request POST 'http://localhost:8080/pessoa/

# Respostas possíveis 

{
    "id": "60a26f0f96a23e596110d8c5",
    "nome": "Pessoa",
    "dataNascimento": "13/04/1970",
    "cep": "25912021",
    "documento": "4444444444",
    "bairro": "Pico (Santo Aleixo)",
    "localidade": "Magé",
    "uf": "RJ"
}
