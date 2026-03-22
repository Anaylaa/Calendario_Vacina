<div align="center">
 
<img src="https://readme-typing-svg.demolab.com?font=JetBrains+Mono&weight=700&size=13&duration=3000&pause=1000&color=00E5A0&center=true&vCenter=true&width=500&lines=Desafio+Mesttra+%C2%B7+Healthcare+API;Spring+Boot+%C2%B7+Java+17+%C2%B7+MySQL;Gerenciamento+de+Imuniza%C3%A7%C3%A3o+Familiar" alt="Typing SVG" />
 
# 💉 API de Vacinação Familiar
 
**Sistema completo para gerenciamento do histórico de imunização familiar**  
com controle de doses, validações inteligentes e calendário vacinal automatizado.
 
<br/>
 
![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_4.0.3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00758F?style=for-the-badge&logo=mysql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
 
![Status](https://img.shields.io/badge/status-concluído-00E5A0?style=flat-square)
![License](https://img.shields.io/badge/license-MIT-blue?style=flat-square)
![Desafio](https://img.shields.io/badge/desafio-Mesttra-9B59B6?style=flat-square)
 
</div>
 
---
 
## 🚀 Tecnologias Utilizadas
 
O projeto utiliza o ecossistema Spring para fornecer uma base robusta e escalável:
 
| Tecnologia | Versão | Descrição |
|---|---|---|
| ☕ **Java** | 17 (LTS) | Linguagem base do projeto |
| 🍃 **Spring Boot** | 4.0.3 | Framework principal |
| 🗄️ **Spring Data JPA** | — | Abstração da camada de persistência |
| 🐬 **MySQL** | — | Banco de dados relacional |
| 📖 **SpringDoc OpenAPI** | — | Documentação interativa (Swagger) |
| 📦 **Maven** | — | Gerenciador de dependências e build |
 
---
 
## 📋 Funcionalidades Principais
 
O sistema está dividido em quatro pilares:
 
<details>
<summary>👤 <strong>Gestão de Pacientes</strong></summary>
<br/>
 
Cadastro, atualização e exclusão de dados de familiares com:
- ✅ Validação de unicidade de CPF
- ✅ Proibição de datas de nascimento futuras
 
</details>
 
<details>
<summary>💊 <strong>Controle de Vacinas</strong></summary>
<br/>
 
Catálogo de vacinas segmentadas por público-alvo:
 
| Público | Badge |
|---|---|
| Crianças | ![Criança](https://img.shields.io/badge/CRIANÇA-00B8FF?style=flat-square) |
| Adolescentes | ![Adolescente](https://img.shields.io/badge/ADOLESCENTE-00E5A0?style=flat-square) |
| Adultos | ![Adulto](https://img.shields.io/badge/ADULTO-F8A040?style=flat-square) |
| Gestantes | ![Gestante](https://img.shields.io/badge/GESTANTE-C4A0FF?style=flat-square) |
 
Com controle de **idade limite de aplicação** para cada vacina.
 
</details>
 
<details>
<summary>🩺 <strong>Registro de Imunizações</strong></summary>
<br/>
 
Lançamento de doses aplicadas com os seguintes dados:
- 🏭 Fabricante e número do lote
- 📍 Local de aplicação
- 👨‍⚕️ Profissional responsável
 
</details>
 
<details>
<summary>📊 <strong>Painel de Estatísticas</strong></summary>
<br/>
 
- 📈 Contagem de vacinas aplicadas por paciente
- ⏰ Identificação de vacinas **atrasadas** com base na idade atual
- 🗓️ Previsão de vacinas para o **próximo mês**
 
</details>
 
---
 
## 🛠️ Como Executar
 
### Pré-requisitos
 
- [x] **Java 17** instalado
- [x] Servidor **MySQL** rodando localmente
- [x] Variáveis de ambiente configuradas:
 
```bash
JDBC_USERNAME_LOCALHOST=seu_usuario
JDBC_PASSWORD_LOCALHOST=sua_senha
```
 
### Passo a passo
 
**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```
 
**2. Crie o banco de dados no MySQL**
```sql
CREATE DATABASE vacinacao;
```
 
**3. Execute a aplicação**
 
```bash
# Linux / macOS
./mvnw spring-boot:run
```
 
```bash
# Windows
.\mvnw.cmd spring-boot:run
```
 
---
 
## 📖 Documentação da API
 
Após iniciar a aplicação, acesse a documentação interativa:
 
> 🔗 **Swagger UI:** [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)
 
---
 
## 🏗️ Estrutura de Pacotes
 
```
src/main/java/com/mesttra/vacinacao/
│
├── 🟢 controller/      # Endpoints REST expostos ao cliente
├── 🔵 dto/             # Objetos de transferência de dados
├── 🟠 entity/          # Entidades JPA — Dose, Imunizacao, Paciente, Vacina
├── 🟣 repository/      # Interfaces JPA para comunicação com o banco
├── 🌿 service/         # Regras de negócio e validações
└── 🔴 exceptions/      # Tratamento de erros e respostas amigáveis
```
 
---
 
<div align="center">
 
Desenvolvido com ❤️ para o **Desafio Mesttra**
 
</div>
