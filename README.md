# Projeto de Envio de Mensagens com Padrão Adapter (MVC + Maven)

Este projeto Java demonstra a implementação do padrão de design **Adapter** em uma arquitetura **MVC (Model-View-Controller)**, utilizando **Maven** para gerenciamento de dependências. Ele simula o envio de mensagens usando sistemas legados (via terminal) e integra funcionalidades de envio real para **SMS** (via Twilio) e **Telegram** (via Telegram Bot API).

Este repositório é **privado**, e por isso os tokens das APIs são expostos diretamente no código para facilitar a avaliação.

---

## 🚀 Funcionalidades

* **Padrão Adapter:** Adapta sistemas legados para uma interface de envio unificada, permitindo integrar novas tecnologias de comunicação sem alterar a lógica principal.
* **Envio de SMS Real:** Integração com a API do **Twilio** para enviar SMS para números de telefone reais.
* **Envio de Telegram Real:** Integração com a **Telegram Bot API** para enviar mensagens via bot para chats do Telegram.
* **Sistemas Legados:** Simula sistemas legados de envio (SMS e Notificações) que operam via terminal, servindo como fallback ou demonstração do código antigo.
* **Interface de Console:** Interação com o usuário via terminal para escolher o tipo de mensagem e inserir o destinatário.

---

## 🛠️ Tecnologias Utilizadas

* **Java 23:** Linguagem de programação.
* **Apache Maven:** Ferramenta de automação de build e gerenciamento de dependências.
* **Twilio SDK:** Biblioteca Java para integração com a API Twilio (para SMS).
* **TelegramBots:** Biblioteca Java para integração com a Telegram Bot API.

---

## 📂 Estrutura do Projeto

O projeto segue a arquitetura MVC com os pacotes `model`, `view` e `controller`. Dentro do `controller`, criamos subpacotes `adapter` e `legacy` para melhor organização:
```
projeto-adapter/
├── pom.xml
└── src/
└── main/
└── java/
└── adapterproject/
├── model/
│   ├── Message.java
│   └── User.java
├── view/
│   └── ConsoleView.java
├── controller/
│   ├── MessageController.java
│   ├── adapter/
│   │   ├── SenderAdapter.java
│   │   ├── SmsSender.java
│   │   └── TelegramSender.java
│   └── legacy/
│       ├── LegacySmsSender.java
│       └── LegacyNotificationSender.java
└── Main.java
```

---

## ⚙️ Configuração e Execução

Para configurar e executar este projeto, siga os passos abaixo:

### 1. Pré-requisitos

* **Java Development Kit (JDK) 23:** Tenha o JDK 23 instalado e a variável de ambiente `JAVA_HOME` configurada corretamente, apontando para a raiz da instalação do JDK.
* **Apache Maven:** Instale o Maven.
* **Conexão com a Internet:** É necessária para o Maven baixar as dependências e para os envios de SMS/Telegram funcionarem.


### 2. Compilação do Projeto

1.  Abra o terminal (Prompt de Comando, PowerShell ou Terminal do VS Code) na pasta raiz do projeto (`projeto-adapter`, onde está o `pom.xml`).
2.  Execute o comando Maven para limpar e compilar o projeto, e baixar as dependências:
    ```bash
    mvn clean install -U
    ```

### 3. Execução da Aplicação

1.  Após a compilação bem-sucedida, no mesmo terminal na pasta raiz do projeto, execute:
    ```bash
    mvn exec:java -Dexec.mainClass="adapterproject.Main"
    ```
2.  A aplicação será iniciada e exibirá um menu no terminal.

---



Feito com ❤️ em Java.
