#!/usr/bin/env bash

set -e

sudo apt update
sudo apt install -y jq

HTTP_STATUS=$(
    curl -X 'POST' \
    'http://localhost:8080/user' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -w "%{http_code}" \
    -o user_create.json \
    -d '{
          "nome": "string",
          "telefone": "string",
          "email": "string",
          "senha": "string",
          "ativo": true,
          "tipoUsuario": "FUNCIONARIO"
        }'
)

echo "Status HTTP: $HTTP_STATUS"
if [ "$HTTP_STATUS" -ne 201 ]; then
    echo "Erro ao criar usuario"
    exit 1
fi

USER_ID=$(jq '.id' user_create.json)

echo "Usuario criado com ID: $USER_ID"

HTTP_STATUS=$(
    curl -X 'DELETE' \
    "http://localhost:8080/user/$USER_ID" \
    -H 'accept: */*' \
    -w "%{http_code}"
)

echo "Status HTTP: $HTTP_STATUS"
if [ "$HTTP_STATUS" -ne 204 ]; then
    echo "Erro ao deletar usuario"
    exit 1
fi