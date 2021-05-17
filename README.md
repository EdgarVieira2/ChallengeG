# Desafio-basico-be

O desafio consiste em uma api para cadastro e busca de pessoa, com consulta de endereço consumindo uma api extrena de cep.

# Tecnologias

- Java8+
- Spring Boot
- Maven
- Git
- MongoDB

# Como baixar o projeto
```git clone https://github.com/EdgarVieira2/ChallengeG.git```

# Como rodar
```mvn spring-boot:run```

# Endpoints

## Criar pessoa

POST 'http://localhost:8080/pessoa/

Request:
```

{
    "nome":"Fulano",
    "dataNascimento":"13/04/1970",
    "cep":"25912021",
    "documento":"11111111111"
}
```

Resoponse:
```
{
    "id": "60a28e6b6d5d4350151856bf",
    "nome": "Fulano",
    "dataNascimento": "13/04/1970",
    "cep": "25912021",
    "documento": "11111111111",
    "bairro": "Pico (Santo Aleixo)",
    "localidade": "Magé",
    "uf": "RJ"
}
```

Exemplo:
```
curl --location --request POST 'http://localhost:8080/pessoa' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Fulano",
    "dataNascimento":"13/04/1970",
    "cep":"25912021",
    "documento":"11111111111"
}'
```
## Consultar todas as pessoas 

 GET 'http://localhost:8080/pessoa/
 
 Response:
```
[
 {
        "id": "60a068512195637b6deabeb3",
        "nome": "Edgar",
        "dataNascimento": "08/08/1995",
        "cep": "1234154",
        "documento": "12dasda31414",
        "bairro": null,
        "localidade": null,
        "uf": null
    },
    {
        "id": "60a0788a476a3b229509b326",
        "nome": "Jenifer",
        "dataNascimento": "13/01/1997",
        "cep": "25912021",
        "documento": "121231414",
        "bairro": "Pico (Santo Aleixo)",
        "localidade": "Magé",
        "uf": "RJ"
    },
    {
        "id": "60a24bd478544c6b4f9dfaeb",
        "nome": "Silvania",
        "dataNascimento": "13/04/1970",
        "cep": "25912021",
        "documento": "121231414",
        "bairro": "Pico (Santo Aleixo)",
        "localidade": "Magé",
        "uf": "RJ"
    }
 ]   
```
Exemplo:
```curl --location --request GET 'http://localhost:8080/pessoa'```

## Consultar pessoas por documento

GET 'http://localhost:8080/pessoa/documento/121231414'

Response:
```
 {
        "id": "60a0788a476a3b229509b326",
        "nome": "Jenifer",
        "dataNascimento": "13/01/1997",
        "cep": "25912021",
        "documento": "121231414",
        "bairro": "Pico (Santo Aleixo)",
        "localidade": "Magé",
        "uf": "RJ"
 }
 ```
 
 Exemplo:
``` curl --location --request GET 'http://localhost:8080/pessoa/documento/121231414'```
 
## Consultar pessoa por Id

GET 'http://localhost:8080/pessoa/60a0788a476a3b229509b326'

Response:
```
{
    "id": "60a0788a476a3b229509b326",
    "nome": "Jenifer",
    "dataNascimento": "13/01/1997",
    "cep": "25912021",
    "documento": "121231414",
    "bairro": "Pico (Santo Aleixo)",
    "localidade": "Magé",
    "uf": "RJ"
}
```
Exemplo:
```curl --location --request GET 'http://localhost:8080/pessoa/60a0788a476a3b229509b326'```



