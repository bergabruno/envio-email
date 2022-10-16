# API responsavel por envio de e-mails

ENDPOINTS:

METODO GET - LISTAR TODOS OS EMAILS COM O STATUS DE CADA UM:

http://localhost:****/api/v1/email


METODO POST - ENVIAR UM E-MAIL

http://localhost:****/api/v1/email/send-email

body:
{
    "emailTo": ${EMAIL_DESTINATARIO},
    "subject": ${TITUTLO},
    "text": ${TEXTO}
}

API FEITA COM CONEXAO AO MONGODB.


como filtrar por data:

http://localhost:****/api/v1/email/{date}

formato da data:
yyyy-MM-dd