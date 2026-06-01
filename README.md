#Sistema de Filas para Atendimento

Este sistema foi desenvolvido para gerenciar o fluxo de requisições e incidentes de um departamento de TI. A aplicação organiza o recebimento de tickets através de 5 níveis de criticidade (sendo 1 o nível mais urgente e 5 o de menor impacto). O algoritmo processa prioritariamente as demandas mais graves e, em caso de igualdade no nível de prioridade, adota o critério cronológico de chegada como regra de desempate.

##Como Baixar e Executar (Passo a Passo)

### 1. Obter o Código Fonte (Git Clone)
Abra o terminal da sua máquina (ou o Git Bash) e execute o comando abaixo para clonar o repositório:
```bash
git clone [https://github.com/diogoSgermano/Filas.git](https://github.com/diogoSgermano/Filas.git)
